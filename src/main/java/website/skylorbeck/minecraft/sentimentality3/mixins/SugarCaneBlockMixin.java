package website.skylorbeck.minecraft.sentimentality3.mixins;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SugarCaneBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import website.skylorbeck.minecraft.sentimentality3.Ref;

import static net.minecraft.block.SugarCaneBlock.AGE;

@Mixin(SugarCaneBlock.class)
public class SugarCaneBlockMixin {
    @Inject(method = "randomTick",at = @At("TAIL"))
    public void EndlessGrowth(BlockState state, ServerWorld world, BlockPos pos, net.minecraft.util.math.random.Random random, CallbackInfo ci){
        if (world.isAir(pos.up())) {
            int i = 1;
            while (world.getBlockState(pos.down(i)).isOf(((SugarCaneBlock)(Object)this))) {
                ++i;
            }
            if (i < Ref.maxSugarCaneHeight) {
                int j = state.get(AGE);
                if (j == 15) {
                    world.setBlockState(pos.up(), ((SugarCaneBlock)(Object)this).getDefaultState());
                    world.setBlockState(pos, state.with(AGE, 0), Block.NO_REDRAW);
                } else {
                    world.setBlockState(pos, state.with(AGE, j + 1), Block.NO_REDRAW);
                }
            }
        }
    }
}