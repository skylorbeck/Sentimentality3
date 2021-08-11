package website.skylorbeck.sentimentality3.sentimentality3;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CompressedBlock extends Block {
    private static final IntProperty compression = IntProperty.of("compression",1,9);//I used blockstates to make generic compressed blocks instead of hardcoding each type
    public CompressedBlock(Settings settings,int level) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(compression,level));
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        switch (this.getDefaultState().get(compression)) {//append different tooltips based on the state given at block registration
            case 1 -> tooltip.add(new TranslatableText("block.sentimentality3.compressed.monuple"));
            case 2 -> tooltip.add(new TranslatableText("block.sentimentality3.compressed.couple"));
            case 3 -> tooltip.add(new TranslatableText("block.sentimentality3.compressed.triple"));
            case 4 -> tooltip.add(new TranslatableText("block.sentimentality3.compressed.quadruple"));
            case 5 -> tooltip.add(new TranslatableText("block.sentimentality3.compressed.quintuple"));
            case 6 -> tooltip.add(new TranslatableText("block.sentimentality3.compressed.sextuple"));
            case 7 -> tooltip.add(new TranslatableText("block.sentimentality3.compressed.septuple"));
            case 8 -> tooltip.add(new TranslatableText("block.sentimentality3.compressed.octuple"));
            case 9 -> tooltip.add(new TranslatableText("block.sentimentality3.compressed.nonuple"));
        }
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(compression);
    }
}
