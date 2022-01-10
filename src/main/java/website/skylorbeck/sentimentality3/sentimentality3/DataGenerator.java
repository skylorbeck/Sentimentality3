package website.skylorbeck.sentimentality3.sentimentality3;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.tag.BlockTags;

public class DataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        fabricDataGenerator.addProvider(BlockTagProviderImpl::new);
    }

    private static class BlockTagProviderImpl extends FabricTagProvider.BlockTagProvider {
        public BlockTagProviderImpl(FabricDataGenerator dataGenerator) {
            super(dataGenerator);
        }

        @Override
        protected void generateTags() {
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.monuple_compressed_cobblestone_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.couple_compressed_cobblestone_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.triple_compressed_cobblestone_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.quadruple_compressed_cobblestone_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.quintuple_compressed_cobblestone_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.sextuple_compressed_cobblestone_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.septuple_compressed_cobblestone_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.octuple_compressed_cobblestone_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.nonuple_compressed_cobblestone_block);
            getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(Declarer.monuple_compressed_dirt_block);
            getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(Declarer.couple_compressed_dirt_block);
            getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(Declarer.triple_compressed_dirt_block);
            getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(Declarer.quadruple_compressed_dirt_block);
            getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(Declarer.quintuple_compressed_dirt_block);
            getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(Declarer.sextuple_compressed_dirt_block);
            getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(Declarer.septuple_compressed_dirt_block);
            getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(Declarer.octuple_compressed_dirt_block);
            getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(Declarer.nonuple_compressed_dirt_block);
            getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(Declarer.monuple_compressed_gravel_block);
            getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(Declarer.couple_compressed_gravel_block);
            getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(Declarer.triple_compressed_gravel_block);
            getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(Declarer.quadruple_compressed_gravel_block);
            getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(Declarer.quintuple_compressed_gravel_block);
            getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(Declarer.sextuple_compressed_gravel_block);
            getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(Declarer.septuple_compressed_gravel_block);
            getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(Declarer.octuple_compressed_gravel_block);
            getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(Declarer.nonuple_compressed_gravel_block);
            getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(Declarer.monuple_compressed_sand_block);
            getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(Declarer.couple_compressed_sand_block);
            getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(Declarer.triple_compressed_sand_block);
            getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(Declarer.quadruple_compressed_sand_block);
            getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(Declarer.quintuple_compressed_sand_block);
            getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(Declarer.sextuple_compressed_sand_block);
            getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(Declarer.septuple_compressed_sand_block);
            getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(Declarer.octuple_compressed_sand_block);
            getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(Declarer.nonuple_compressed_sand_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.monuple_compressed_granite_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.couple_compressed_granite_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.triple_compressed_granite_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.quadruple_compressed_granite_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.quintuple_compressed_granite_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.sextuple_compressed_granite_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.septuple_compressed_granite_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.octuple_compressed_granite_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.nonuple_compressed_granite_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.monuple_compressed_diorite_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.couple_compressed_diorite_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.triple_compressed_diorite_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.quadruple_compressed_diorite_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.quintuple_compressed_diorite_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.sextuple_compressed_diorite_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.septuple_compressed_diorite_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.octuple_compressed_diorite_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.nonuple_compressed_diorite_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.monuple_compressed_andesite_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.couple_compressed_andesite_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.triple_compressed_andesite_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.quadruple_compressed_andesite_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.quintuple_compressed_andesite_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.sextuple_compressed_andesite_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.septuple_compressed_andesite_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.octuple_compressed_andesite_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.nonuple_compressed_andesite_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.monuple_compressed_netherrack_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.couple_compressed_netherrack_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.triple_compressed_netherrack_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.quadruple_compressed_netherrack_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.quintuple_compressed_netherrack_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.sextuple_compressed_netherrack_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.septuple_compressed_netherrack_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.octuple_compressed_netherrack_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.nonuple_compressed_netherrack_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.monuple_compressed_cobbled_deepslate_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.couple_compressed_cobbled_deepslate_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.triple_compressed_cobbled_deepslate_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.quadruple_compressed_cobbled_deepslate_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.quintuple_compressed_cobbled_deepslate_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.sextuple_compressed_cobbled_deepslate_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.septuple_compressed_cobbled_deepslate_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.octuple_compressed_cobbled_deepslate_block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.nonuple_compressed_cobbled_deepslate_block);

            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.sandstone_blast_furnaceblock);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.red_sandstone_blast_furnaceblock);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.andesite_blast_furnaceblock);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.granite_blast_furnaceblock);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.diorite_blast_furnaceblock);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.netherrack_blast_furnaceblock);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.blackstone_blast_furnaceblock);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.basalt_blast_furnaceblock);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.endstone_blast_furnaceblock);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.deepslate_blast_furnaceblock);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.sandstone_furnaceblock);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.red_sandstone_furnaceblock);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.andesite_furnaceblock);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.granite_furnaceblock);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.diorite_furnaceblock);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.netherrack_furnaceblock);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.blackstone_furnaceblock);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.basalt_furnaceblock);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.endstone_furnaceblock);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.deepslate_furnaceblock);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.sandstone_smokerblock);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.red_sandstone_smokerblock);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.andesite_smokerblock);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.granite_smokerblock);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.diorite_smokerblock);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.netherrack_smokerblock);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.blackstone_smokerblock);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.basalt_smokerblock);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.endstone_smokerblock);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Declarer.deepslate_smokerblock);
        }
    }
}
