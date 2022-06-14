package website.skylorbeck.minecraft.sentimentality3.mixins;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import website.skylorbeck.minecraft.sentimentality3.Ref;

import javax.swing.*;
import java.util.Random;

@Mixin(CropBlock.class)
public abstract class Cropmixin {
    @Shadow public abstract boolean isMature(BlockState state);
    private static final Random RANDOM = new Random();

    @Inject(at = @At("HEAD"),cancellable = true,method = "hasRandomTicks")
    public void hasRandomTicks(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if (Ref.cropSparkle) {
            cir.setReturnValue(true);
        }
    }
    @Inject(at = @At("HEAD"), method = "randomTick")
    private void sparkleTick(BlockState state, ServerWorld world, BlockPos pos, net.minecraft.util.math.random.Random random, CallbackInfo ci) {
        if (Ref.cropSparkle) {
            ClientWorld clientWorld = MinecraftClient.getInstance().world;
            if (isMature(state)) {
                int count = Ref.sparkleCount;
                createParticles(clientWorld, pos, count);
                Timer timer = new Timer(2000, e ->
                        createParticles(clientWorld, pos, count));
                timer.setRepeats(false);
                timer.start();
            }
        }
    }
    @Environment(EnvType.CLIENT)
    private static void createParticles(WorldAccess world, BlockPos pos, int count) {
        if (count == 0) {
            count = 15;
        }

        BlockState blockState = world.getBlockState(pos);
        if (!blockState.isAir()) {
            double d = 0.5D;
            double g;
            if (blockState.isOf(Blocks.WATER)) {
                count *= 3;
                g = 1.0D;
                d = 3.0D;
            } else if (blockState.isOpaqueFullCube(world, pos)) {
                pos = pos.up();
                count *= 3;
                d = 3.0D;
                g = 1.0D;
            } else {
                g = blockState.getOutlineShape(world, pos).getMax(Direction.Axis.Y);
            }
            for(int i = 0; i < count; ++i) {
                double h = RANDOM.nextGaussian() * 0.02D;
                double j = RANDOM.nextGaussian() * 0.02D;
                double k = RANDOM.nextGaussian() * 0.02D;
                double l = 0.5D - d;
                double m = (double)pos.getX() + l + RANDOM.nextDouble() * d * 2.0D;
                double n = (double)pos.getY() + RANDOM.nextDouble() * g;
                double o = (double)pos.getZ() + l + RANDOM.nextDouble() * d * 2.0D;
                if (!world.getBlockState((new BlockPos(m, n, o)).down()).isAir()) {
                    ParticleEffect particleType = switch (Ref.sparkleType) {
                        case DRAGON_BREATH -> ParticleTypes.DRAGON_BREATH;
                        case ENCHANTED_HIT -> ParticleTypes.ENCHANTED_HIT;
                        case HAPPY_VILLAGER -> ParticleTypes.HAPPY_VILLAGER;
                        case INSTANT_EFFECT -> ParticleTypes.INSTANT_EFFECT;
                        case TOTEM_OF_UNDYING -> ParticleTypes.TOTEM_OF_UNDYING;
                    };
                    world.addParticle(particleType, m, n, o, h, j, k);
                }
            }
        }
    }
}