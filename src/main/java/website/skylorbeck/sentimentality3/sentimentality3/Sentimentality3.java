package website.skylorbeck.sentimentality3.sentimentality3;

import io.netty.buffer.Unpooled;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import website.skylorbeck.sentimentality3.sentimentality3.client.Sentimentality3Client;

import java.util.Objects;

public class Sentimentality3 implements ModInitializer {
    public static final Identifier sentimentality3_get_seed= new Identifier("sentimentality3", "get_seed");

    @Override
    public void onInitialize() {
        //Logger.getLogger(Ref.MODID).log(Level.WARNING,"This is when Main is loaded");
        ConfigHolder<ModConfig> configHolder = AutoConfig.register(ModConfig.class, GsonConfigSerializer::new);//register config asap to prevent errors down the line
        ServerPlayNetworking.registerGlobalReceiver(sentimentality3_get_seed, (server, player, handler, buf, responseSender) -> {
            server.execute(() -> {
                PacketByteBuf data = new PacketByteBuf(Unpooled.buffer());
                data.writeLong(Objects.requireNonNull(player.getEntityWorld().getServer()).getOverworld().getSeed());//send seed back
                ServerPlayNetworking.send(player, Sentimentality3Client.sentimentality3_send_seed, data);
            });
        });
        configHolder.getConfig();
        Ref.getSettings();//gets all settings at launch to save on file reads. Certain settings would read every frame(!) insanely bad
        Registrar.register();//register everything serverside
        configHolder.registerSaveListener((manager, data) ->{//listen for config file changes
            Ref.getSomeSettings();//gets settings that don't need a full restart to properly do.
            //Logger.getLogger(Ref.MODID).log(Level.WARNING,"SAVE EVENT TRIGGERED");//this was used to help me see if it was actually working
            return ActionResult.SUCCESS;
        });
    }
}
