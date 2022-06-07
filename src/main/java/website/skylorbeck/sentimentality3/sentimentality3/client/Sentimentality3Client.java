package website.skylorbeck.sentimentality3.sentimentality3.client;

import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.SimpleResourceReloadListener;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.util.registry.Registry;
import website.skylorbeck.minecraft.skylorlib.Color;
import website.skylorbeck.sentimentality3.sentimentality3.ExtraHUD;
import website.skylorbeck.sentimentality3.sentimentality3.ModConfig;
import website.skylorbeck.sentimentality3.sentimentality3.Registrar;
import website.skylorbeck.sentimentality3.sentimentality3.SlimeChunkLocator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class Sentimentality3Client implements ClientModInitializer {
    public static final Identifier sentimentality3_send_seed = new Identifier("sentimentality3","send_seed");
    public ExtraHUD extraHUD;
    @Override
    public void onInitializeClient() {
        AutoConfig.getGuiRegistry(ModConfig.class);

        ClientPlayNetworking.registerGlobalReceiver(sentimentality3_send_seed, (client, handler, buf, responseSender) -> {
            long seed = buf.readLong();
            client.execute(() -> {
                SlimeChunkLocator.receivedSeed(seed);//save seed to slime chunk detector that requested it
            });
        });
        Registrar.clientRegister();
        extraHUD = new ExtraHUD();//add in the custom hud
        /*
        if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
            ResourceManagerHelper.get(ResourceType.CLIENT_RESOURCES).registerReloadListener(new SimpleResourceReloadListener<Boolean>() {

                @Override
                public Identifier getFabricId() {
                    return new Identifier("sentimentality3", "resources");
                }

                @Override
                public CompletableFuture<Boolean> load(ResourceManager manager, Profiler profiler, Executor executor) {
                    executor.execute(() -> {
                        Path prepath = Paths.get("cache/assets/sentimentality3/");
                        String path = prepath.toString().replace("\\", "/") + "/textures/item/";
                        try {
                            Files.createDirectories(Path.of(path));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        for (Item item : items) {
                            for (String image : images) {
                                Identifier sourceItem = Registry.ITEM.getId(item);
                                String partPath = path + item + "_" + image + ".png";
                                Identifier sourceTexture = null;
                                try {
                                    sourceTexture = new Identifier(sourceItem.getNamespace(), String.format("textures/%s%s", "item/" + sourceItem.getPath(), ".png"));
                                    if (manager.getResource(sourceTexture).isEmpty()){
                                        throw new IOException();
                                    }
                                    writeImage(manager, partPath, sourceItem, sourceTexture, image);
                                } catch (IOException e) {
                                    try {
                                        sourceTexture = new Identifier(sourceItem.getNamespace(), String.format("textures/%s%s", "block/" + sourceItem.getPath(), ".png"));
                                        if (manager.getResource(sourceTexture).isEmpty()){
                                            throw new IOException();
                                        }
                                        writeImage(manager, partPath, sourceItem, sourceTexture, image);
                                    } catch (IOException ignored) {
                                        ignored.printStackTrace();
                                    }
                                }
                            }
                        }
                    });
                    return CompletableFuture.completedFuture(true);
                }

                @Override
                public CompletableFuture<Void> apply(Boolean data, ResourceManager manager, Profiler profiler, Executor executor) {
                    return CompletableFuture.completedFuture(null);
                }
            });
        }

         */
    }
    

        private void writeImage(ResourceManager manager, String path, Identifier sourceItem, Identifier sourceTexture, String part) throws IOException {
//        Logger.getGlobal().log(Level.INFO, "Writing image for " + sourceItem.toString());
            ArrayList<Color> colors = new ArrayList<>();
            ArrayList<Color> greys = new ArrayList<>();
            NativeImage nativeImage = NativeImage.read(manager.getResource(sourceTexture).get().getInputStream());
            NativeImage template = NativeImage.read(manager.getResource(new Identifier("sentimentality3","textures/item/staging/"+part+ ".png")).get().getInputStream());

            ExtractColor(greys, template);
            ExtractColor(colors, nativeImage);
            Comparator<Color> comparator = (a, b) -> Float.compare(a.getRed() * 0.21f + a.getBlue() * 0.07f + a.getGreen() * 0.72f, b.getRed() * 0.21f + b.getBlue() * 0.07f + b.getGreen() * 0.72f);
            colors.sort(comparator);
            greys.sort(comparator);

            HashMap<Color, Color> map = new HashMap<>();
            for (int i = 0; i < greys.size(); i++) {
                map.put(greys.get(i), colors.get(i));
            }

            for (int x = 0; x < template.getWidth(); x++) {
                for (int y = 0; y < template.getHeight(); y++) {
                    Color color = Color.ofTransparent(template.getColor(x, y));
                    if (color.getAlpha() != 0) {
                        Color newColor = map.get(color);
                        template.setColor(x, y, newColor.getColor());
                    }
                }
            }
            template.writeTo(path);
        }

    private void ExtractColor(ArrayList<Color> greys, NativeImage template) {
        for (int x = 0; x < template.getWidth(); x++) {
            for (int y = 0; y < template.getHeight(); y++) {
                Color color = Color.ofTransparent(template.getColor(x, y));
                if (!greys.contains(color) && color.getAlpha() != 0)
                    greys.add(color);
            }
        }
    }

    static Item[] items = new Item[]{
            Items.SPRUCE_PLANKS,
            Items.BIRCH_PLANKS,
            Items.JUNGLE_PLANKS,
            Items.DARK_OAK_PLANKS,
            Items.ACACIA_PLANKS,
            Items.MANGROVE_PLANKS
    };
    static String[] images = new String[]{
            "axe",
            "axe_2",
            "axe_3",
            "axe_4",
            "sword",
            "sword_2",
            "sword_3",
            "sword_4",
            "shovel",
            "shovel_2",
            "shovel_3",
            "shovel_4",
            "pickaxe",
            "pickaxe_2",
            "pickaxe_3",
            "pickaxe_4",
            "hoe",
            "hoe_2",
            "hoe_3",
            "hoe_4"
    };
}
