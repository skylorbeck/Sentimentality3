package website.skylorbeck.sentimentality3.sentimentality3;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.BlastFurnaceScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;

public class ExtraBlastFurnaceBlockEntity extends AbstractExtraFurnaceBlockEntity {//copy of vanilla code
    public ExtraBlastFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(Declarer.EXTRA_BLAST_FURNACE_ENTITY,pos,state,RecipeType.BLASTING);
    }

    protected int getFuelTime(ItemStack fuel) {
        return super.getFuelTime(fuel) / 2;
    }

    @Override
    public Text getContainerName() {
        return new TranslatableText("container.blast_furnace");
    }
    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new BlastFurnaceScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }
}