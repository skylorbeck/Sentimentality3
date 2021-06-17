package website.skylorbeck.sentimentality3.sentimentality3.mixins;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.PlayerListHud;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import website.skylorbeck.sentimentality3.sentimentality3.Ref;

@Mixin({PlayerListHud.class})
public abstract class PingIndicator extends DrawableHelper {

    @Inject(method = "renderLatencyIcon",at = @At("HEAD"),cancellable = true)
    public void sentimentalRenderLatencyIcon(MatrixStack matrixStack, int i, int j, int k, PlayerListEntry playerListEntry, CallbackInfo ci) {
        if (Ref.pingIndicator) {
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);//white
            int ping = playerListEntry.getLatency();
            int rgb;
            if (ping < 0) {
                rgb = 255;//blue
            } else if (ping < 50) {
                rgb = 65280;//green
            } else if (ping < 100) {
                rgb = 43520;//dark green
            } else if (ping < 200) {
                rgb = 16776960;//yellow
            } else if (ping < 300) {
                rgb = 16711680;//red
            } else {
                rgb = 11141120;//dark red
            }

            String pingString = this.toSubscriptNumbers(Integer.toString(ping));
            this.setZOffset(this.getZOffset() + 100);
            DrawableHelper.drawCenteredText(matrixStack, MinecraftClient.getInstance().textRenderer, pingString, j + i - 11, k - 1, rgb);
            this.setZOffset(this.getZOffset() - 100);
            ci.cancel();
        }
    }
    private String toSubscriptNumbers(String string) {
        char[] chars = string.toCharArray();//convert string into array and return it

        for(int i = 0; i < chars.length; ++i) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                chars[i] = (char)(chars[i] + 8272);
            } else if (chars[i] == '-') {
                chars[i] = 8320;
            }
        }

        return new String(chars);
    }
}
