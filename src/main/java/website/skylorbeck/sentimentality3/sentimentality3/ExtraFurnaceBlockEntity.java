package website.skylorbeck.sentimentality3.sentimentality3;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ExtraFurnaceBlockEntity extends AbstractExtraFurnaceBlockEntity {

    protected ExtraFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(Declarer.EXTRA_FURNACE_ENTITY,pos,state,RecipeType.SMELTING);
    }

    public static <T extends BlockEntity> void tick(World world, BlockPos blockPos, BlockState state, T t) {
        AbstractExtraFurnaceBlockEntity.tick(world,blockPos,state, (AbstractExtraFurnaceBlockEntity) t);
    }
}
