package website.skylorbeck.sentimentality3.sentimentality3.mixins;

import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import net.minecraft.world.ServerWorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(HostileEntity.class)
public class HostileEntityMixin {

    @Inject(method = "isSpawnDark", at = @At(value = "INVOKE"), cancellable = true)
    private static void completeDarknessOnly(ServerWorldAccess world, BlockPos pos, Random random, CallbackInfoReturnable<Boolean> cir) {
        if (world.getLightLevel(LightType.BLOCK, pos) > 0) {
            cir.setReturnValue(false);
        }
    }

}