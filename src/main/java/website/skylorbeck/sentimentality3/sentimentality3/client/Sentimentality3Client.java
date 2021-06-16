package website.skylorbeck.sentimentality3.sentimentality3.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.util.Identifier;
import website.skylorbeck.sentimentality3.sentimentality3.ExtraHUD;
import website.skylorbeck.sentimentality3.sentimentality3.Registrar;
import website.skylorbeck.sentimentality3.sentimentality3.SlimeChunkLocator;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class Sentimentality3Client implements ClientModInitializer {
    public static final Identifier sentimentality3_send_seed = new Identifier("sentimentality3","send_seed");
    public ExtraHUD extraHUD;
    @Override
    public void onInitializeClient() {
        ClientSidePacketRegistry.INSTANCE.register(sentimentality3_send_seed, (packetContext, attachedData) -> {
            long seed = attachedData.readLong();
            packetContext.getTaskQueue().execute(() -> {
                SlimeChunkLocator.receivedSeed(seed);//save seed to slime chunk detector that requested it
            });
        });
        Registrar.clientRegister();
        extraHUD = new ExtraHUD();//add in the custom hud
    }
}
