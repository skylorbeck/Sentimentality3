package website.skylorbeck.sentimentality3.sentimentality3;

import net.minecraft.block.BlockState;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.math.BlockPos;

public class ExtraFurnaceBlockEntity extends AbstractExtraFurnaceBlockEntity {

    protected ExtraFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(Declarer.EXTRA_FURNACE_ENTITY,pos,state,RecipeType.SMELTING);
    }
}
