package website.skylorbeck.sentimentality3.sentimentality3;

import com.google.common.collect.Lists;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import website.skylorbeck.minecraft.skylorlib.DynamicRecipeLoader;
import website.skylorbeck.minecraft.skylorlib.furnaces.ExtraBlastFurnaceBlockEntity;
import website.skylorbeck.minecraft.skylorlib.furnaces.ExtraFurnaceBlockEntity;
import website.skylorbeck.minecraft.skylorlib.furnaces.ExtraSmokerBlockEntity;

import java.util.Objects;

import static website.skylorbeck.minecraft.skylorlib.DynamicRecipeLoader.*;


@SuppressWarnings("unchecked cast")
public class Registrar {
    public static void clientRegister() {//separated because servers don't like when they have this stuff registered on them
        //particles
        Declarer.END_FIRE_FLAME = Registry.register(Registry.PARTICLE_TYPE, new Identifier(Ref.MODID, "end_fire_flame"), FabricParticleTypes.simple());
        ParticleFactoryRegistry.getInstance().register(Declarer.END_FIRE_FLAME, FlameParticle.Factory::new);
        //tying the color provider to the wool armor
        ColorProviderRegistry.ITEM.register((stack, tintIndex) ->
                        stack.getSubNbt(Ref.display) != null && Objects.requireNonNull(stack.getSubNbt(Ref.display)).contains(Ref.color, 99) ? Objects.requireNonNull(stack.getSubNbt(Ref.display)).getInt(Ref.color) : 16777215,
                Declarer.wool_helmet,
                Declarer.wool_chestplate,
                Declarer.wool_leggings,
                Declarer.wool_boots
        );

    }

    public static void register() {
        regItem("personal_daylight_detector", Declarer.personal_daylight_detector);
        regItem("slime_chunk_locator", Declarer.slime_chunk_locator);
        regItem("chunkloader", Declarer.chunk_loader);
        regItem("fleather", Declarer.fleather);

        regBlock("charcoal_block_block", Declarer.charcoal_block_block);
        regItem("charcoal_block", Declarer.charcoal_block);
        FuelRegistry.INSTANCE.add(Declarer.charcoal_block, 16000);

        regItem("small_stick_bundle", Declarer.small_stick_bundle);
        FuelRegistry.INSTANCE.add(Declarer.small_stick_bundle, 400);

        regItem("large_stick_bundle", Declarer.large_stick_bundle);
        FuelRegistry.INSTANCE.add(Declarer.large_stick_bundle, 1600);

        regBlock("feather_block_block", Declarer.feather_block_block);
        regItem("feather_block", Declarer.feather_block);
        regItem("charcoal_nugget", Declarer.charcoal_nugget);
        FuelRegistry.INSTANCE.add(Declarer.charcoal_nugget, 200);

        regItem("coal_nugget", Declarer.coal_nugget);
        FuelRegistry.INSTANCE.add(Declarer.coal_nugget, 200);

        website.skylorbeck.minecraft.skylorlib.Declarer.EXTRA_FURNACE_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                "sentimentality3:furnace",
                FabricBlockEntityTypeBuilder.create(ExtraFurnaceBlockEntity::new,
                        Declarer.sandstone_furnaceblock,
                        Declarer.red_sandstone_furnaceblock,
                        Declarer.andesite_furnaceblock,
                        Declarer.granite_furnaceblock,
                        Declarer.diorite_furnaceblock,
                        Declarer.endstone_furnaceblock,
                        Declarer.blackstone_furnaceblock,
                        Declarer.netherrack_furnaceblock,
                        Declarer.basalt_furnaceblock,
                        Declarer.deepslate_furnaceblock
                ).build(null));

        website.skylorbeck.minecraft.skylorlib.Declarer.EXTRA_BLAST_FURNACE_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                "sentimentality3:blast_furnace",
                FabricBlockEntityTypeBuilder.create(ExtraBlastFurnaceBlockEntity::new,
                        Declarer.sandstone_blast_furnaceblock,
                        Declarer.red_sandstone_blast_furnaceblock,
                        Declarer.andesite_blast_furnaceblock,
                        Declarer.granite_blast_furnaceblock,
                        Declarer.diorite_blast_furnaceblock,
                        Declarer.endstone_blast_furnaceblock,
                        Declarer.blackstone_blast_furnaceblock,
                        Declarer.netherrack_blast_furnaceblock,
                        Declarer.basalt_blast_furnaceblock,
                        Declarer.deepslate_blast_furnaceblock
                ).build(null));

        website.skylorbeck.minecraft.skylorlib.Declarer.EXTRA_SMOKER_FURNACE_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                "sentimentality3:smoker",
                FabricBlockEntityTypeBuilder.create(ExtraSmokerBlockEntity::new,
                        Declarer.sandstone_smokerblock,
                        Declarer.red_sandstone_smokerblock,
                        Declarer.andesite_smokerblock,
                        Declarer.granite_smokerblock,
                        Declarer.diorite_smokerblock,
                        Declarer.endstone_smokerblock,
                        Declarer.blackstone_smokerblock,
                        Declarer.netherrack_smokerblock,
                        Declarer.basalt_smokerblock,
                        Declarer.deepslate_smokerblock
                ).build(null));

        regBlock("sandstone_furnace", Declarer.sandstone_furnaceblock);
        regItem("sandstone_furnaceitem", Declarer.sandstone_furnace);
        regBlock("red_sandstone_furnace", Declarer.red_sandstone_furnaceblock);
        regItem("red_sandstone_furnaceitem", Declarer.red_sandstone_furnace);
        regBlock("andesite_furnace", Declarer.andesite_furnaceblock);
        regItem("andesite_furnaceitem", Declarer.andesite_furnace);
        regBlock("granite_furnace", Declarer.granite_furnaceblock);
        regItem("granite_furnaceitem", Declarer.granite_furnace);
        regBlock("diorite_furnace", Declarer.diorite_furnaceblock);
        regItem("diorite_furnaceitem", Declarer.diorite_furnace);
        regBlock("endstone_furnace", Declarer.endstone_furnaceblock);
        regItem("endstone_furnaceitem", Declarer.endstone_furnace);
        regBlock("blackstone_furnace", Declarer.blackstone_furnaceblock);
        regItem("blackstone_furnaceitem", Declarer.blackstone_furnace);
        regBlock("netherrack_furnace", Declarer.netherrack_furnaceblock);
        regItem("netherrack_furnaceitem", Declarer.netherrack_furnace);
        regBlock("basalt_furnace", Declarer.basalt_furnaceblock);
        regItem("basalt_furnaceitem", Declarer.basalt_furnace);
        regBlock("deepslate_furnace", Declarer.deepslate_furnaceblock);
        regItem("deepslate_furnaceitem", Declarer.deepslate_furnace);

        regBlock("sandstone_blast_furnace", Declarer.sandstone_blast_furnaceblock);
        regItem("sandstone_blast_furnaceitem", Declarer.sandstone_blast_furnace);
        regBlock("red_sandstone_blast_furnace", Declarer.red_sandstone_blast_furnaceblock);
        regItem("red_sandstone_blast_furnaceitem", Declarer.red_sandstone_blast_furnace);
        regBlock("andesite_blast_furnace", Declarer.andesite_blast_furnaceblock);
        regItem("andesite_blast_furnaceitem", Declarer.andesite_blast_furnace);
        regBlock("granite_blast_furnace", Declarer.granite_blast_furnaceblock);
        regItem("granite_blast_furnaceitem", Declarer.granite_blast_furnace);
        regBlock("diorite_blast_furnace", Declarer.diorite_blast_furnaceblock);
        regItem("diorite_blast_furnaceitem", Declarer.diorite_blast_furnace);
        regBlock("endstone_blast_furnace", Declarer.endstone_blast_furnaceblock);
        regItem("endstone_blast_furnaceitem", Declarer.endstone_blast_furnace);
        regBlock("blackstone_blast_furnace", Declarer.blackstone_blast_furnaceblock);
        regItem("blackstone_blast_furnaceitem", Declarer.blackstone_blast_furnace);
        regBlock("netherrack_blast_furnace", Declarer.netherrack_blast_furnaceblock);
        regItem("netherrack_blast_furnaceitem", Declarer.netherrack_blast_furnace);
        regBlock("basalt_blast_furnace", Declarer.basalt_blast_furnaceblock);
        regItem("basalt_blast_furnaceitem", Declarer.basalt_blast_furnace);
        regBlock("deepslate_blast_furnace", Declarer.deepslate_blast_furnaceblock);
        regItem("deepslate_blast_furnaceitem", Declarer.deepslate_blast_furnace);

        regBlock("sandstone_smoker", Declarer.sandstone_smokerblock);
        regItem("sandstone_smokeritem", Declarer.sandstone_smoker);
        regBlock("red_sandstone_smoker", Declarer.red_sandstone_smokerblock);
        regItem("red_sandstone_smokeritem", Declarer.red_sandstone_smoker);
        regBlock("andesite_smoker", Declarer.andesite_smokerblock);
        regItem("andesite_smokeritem", Declarer.andesite_smoker);
        regBlock("granite_smoker", Declarer.granite_smokerblock);
        regItem("granite_smokeritem", Declarer.granite_smoker);
        regBlock("diorite_smoker", Declarer.diorite_smokerblock);
        regItem("diorite_smokeritem", Declarer.diorite_smoker);
        regBlock("endstone_smoker", Declarer.endstone_smokerblock);
        regItem("endstone_smokeritem", Declarer.endstone_smoker);
        regBlock("blackstone_smoker", Declarer.blackstone_smokerblock);
        regItem("blackstone_smokeritem", Declarer.blackstone_smoker);
        regBlock("netherrack_smoker", Declarer.netherrack_smokerblock);
        regItem("netherrack_smokeritem", Declarer.netherrack_smoker);
        regBlock("basalt_smoker", Declarer.basalt_smokerblock);
        regItem("basalt_smokeritem", Declarer.basalt_smoker);
        regBlock("deepslate_smoker", Declarer.deepslate_smokerblock);
        regItem("deepslate_smokeritem", Declarer.deepslate_smoker);

        regItem("wool_helmet", Declarer.wool_helmet);
        regItem("wool_chestplate", Declarer.wool_chestplate);
        regItem("wool_leggings", Declarer.wool_leggings);
        regItem("wool_boots", Declarer.wool_boots);

        regItem("copper_helmet", Declarer.copper_helmet);
        regItem("copper_chestplate", Declarer.copper_chestplate);
        regItem("copper_leggings", Declarer.copper_leggings);
        regItem("copper_boots", Declarer.copper_boots);

        regItem("granite_pick", Declarer.granite_pick);
        regItem("granite_axe", Declarer.granite_axe);
        regItem("granite_shovel", Declarer.granite_shovel);
        regItem("granite_sword", Declarer.granite_sword);
        regItem("granite_hoe", Declarer.granite_hoe);

        regItem("diorite_pick", Declarer.diorite_pick);
        regItem("diorite_axe", Declarer.diorite_axe);
        regItem("diorite_shovel", Declarer.diorite_shovel);
        regItem("diorite_sword", Declarer.diorite_sword);
        regItem("diorite_hoe", Declarer.diorite_hoe);

        regItem("andesite_pick", Declarer.andesite_pick);
        regItem("andesite_axe", Declarer.andesite_axe);
        regItem("andesite_shovel", Declarer.andesite_shovel);
        regItem("andesite_sword", Declarer.andesite_sword);
        regItem("andesite_hoe", Declarer.andesite_hoe);

        regItem("quartz_pick", Declarer.quartz_pick);
        regItem("quartz_axe", Declarer.quartz_axe);
        regItem("quartz_shovel", Declarer.quartz_shovel);
        regItem("quartz_sword", Declarer.quartz_sword);
        regItem("quartz_hoe", Declarer.quartz_hoe);

        regItem("netherrack_pick", Declarer.netherrack_pick);
        regItem("netherrack_axe", Declarer.netherrack_axe);
        regItem("netherrack_shovel", Declarer.netherrack_shovel);
        regItem("netherrack_sword", Declarer.netherrack_sword);
        regItem("netherrack_hoe", Declarer.netherrack_hoe);

        regItem("netherbrick_pick", Declarer.netherbrick_pick);
        regItem("netherbrick_axe", Declarer.netherbrick_axe);
        regItem("netherbrick_shovel", Declarer.netherbrick_shovel);
        regItem("netherbrick_sword", Declarer.netherbrick_sword);
        regItem("netherbrick_hoe", Declarer.netherbrick_hoe);

        regItem("rednetherbrick_pick", Declarer.rednetherbrick_pick);
        regItem("rednetherbrick_axe", Declarer.rednetherbrick_axe);
        regItem("rednetherbrick_shovel", Declarer.rednetherbrick_shovel);
        regItem("rednetherbrick_sword", Declarer.rednetherbrick_sword);
        regItem("rednetherbrick_hoe", Declarer.rednetherbrick_hoe);

        regItem("sandstone_pick", Declarer.sandstone_pick);
        regItem("sandstone_axe", Declarer.sandstone_axe);
        regItem("sandstone_shovel", Declarer.sandstone_shovel);
        regItem("sandstone_sword", Declarer.sandstone_sword);
        regItem("sandstone_hoe", Declarer.sandstone_hoe);

        regItem("redsandstone_pick", Declarer.redsandstone_pick);
        regItem("redsandstone_axe", Declarer.redsandstone_axe);
        regItem("redsandstone_shovel", Declarer.redsandstone_shovel);
        regItem("redsandstone_sword", Declarer.redsandstone_sword);
        regItem("redsandstone_hoe", Declarer.redsandstone_hoe);

        regItem("lapis_pick", Declarer.lapis_pick);
        regItem("lapis_axe", Declarer.lapis_axe);
        regItem("lapis_shovel", Declarer.lapis_shovel);
        regItem("lapis_sword", Declarer.lapis_sword);
        regItem("lapis_hoe", Declarer.lapis_hoe);

        regItem("emerald_pick", Declarer.emerald_pick);
        regItem("emerald_axe", Declarer.emerald_axe);
        regItem("emerald_shovel", Declarer.emerald_shovel);
        regItem("emerald_sword", Declarer.emerald_sword);
        regItem("emerald_hoe", Declarer.emerald_hoe);

        regItem("flint_pick", Declarer.flint_pick);
        regItem("flint_axe", Declarer.flint_axe);
        regItem("flint_shovel", Declarer.flint_shovel);
        regItem("flint_sword", Declarer.flint_sword);
        regItem("flint_hoe", Declarer.flint_hoe);

        regItem("redstone_pick", Declarer.redstone_pick);
        regItem("redstone_axe", Declarer.redstone_axe);
        regItem("redstone_shovel", Declarer.redstone_shovel);
        regItem("redstone_sword", Declarer.redstone_sword);
        regItem("redstone_hoe", Declarer.redstone_hoe);

        regItem("blackstone_pick", Declarer.blackstone_pick);
        regItem("blackstone_axe", Declarer.blackstone_axe);
        regItem("blackstone_shovel", Declarer.blackstone_shovel);
        regItem("blackstone_sword", Declarer.blackstone_sword);
        regItem("blackstone_hoe", Declarer.blackstone_hoe);

        regItem("basalt_pick", Declarer.basalt_pick);
        regItem("basalt_axe", Declarer.basalt_axe);
        regItem("basalt_shovel", Declarer.basalt_shovel);
        regItem("basalt_sword", Declarer.basalt_sword);
        regItem("basalt_hoe", Declarer.basalt_hoe);

        regItem("endstone_pick", Declarer.endstone_pick);
        regItem("endstone_axe", Declarer.endstone_axe);
        regItem("endstone_shovel", Declarer.endstone_shovel);
        regItem("endstone_sword", Declarer.endstone_sword);
        regItem("endstone_hoe", Declarer.endstone_hoe);

        regItem("warped_pick", Declarer.warped_pick);
        regItem("warped_axe", Declarer.warped_axe);
        regItem("warped_shovel", Declarer.warped_shovel);
        regItem("warped_sword", Declarer.warped_sword);
        regItem("warped_hoe", Declarer.warped_hoe);

        regItem("crimson_pick", Declarer.crimson_pick);
        regItem("crimson_axe", Declarer.crimson_axe);
        regItem("crimson_shovel", Declarer.crimson_shovel);
        regItem("crimson_sword", Declarer.crimson_sword);
        regItem("crimson_hoe", Declarer.crimson_hoe);

        regItem("amethyst_pick", Declarer.amethyst_pick);
        regItem("amethyst_axe", Declarer.amethyst_axe);
        regItem("amethyst_shovel", Declarer.amethyst_shovel);
        regItem("amethyst_sword", Declarer.amethyst_sword);
        regItem("amethyst_hoe", Declarer.amethyst_hoe);

        regItem("copper_pick", Declarer.copper_pick);
        regItem("copper_axe", Declarer.copper_axe);
        regItem("copper_shovel", Declarer.copper_shovel);
        regItem("copper_sword", Declarer.copper_sword);
        regItem("copper_hoe", Declarer.copper_hoe);

        regItem("deepslate_pick", Declarer.deepslate_pick);
        regItem("deepslate_axe", Declarer.deepslate_axe);
        regItem("deepslate_shovel", Declarer.deepslate_shovel);
        regItem("deepslate_sword", Declarer.deepslate_sword);
        regItem("deepslate_hoe", Declarer.deepslate_hoe);

        regItem("monuple_compressed_cobblestone", Declarer.monuple_compressed_cobblestone);
        regBlock("monuple_compressed_cobblestone_block", Declarer.monuple_compressed_cobblestone_block);
        regItem("couple_compressed_cobblestone", Declarer.couple_compressed_cobblestone);
        regBlock("couple_compressed_cobblestone_block", Declarer.couple_compressed_cobblestone_block);
        regItem("triple_compressed_cobblestone", Declarer.triple_compressed_cobblestone);
        regBlock("triple_compressed_cobblestone_block", Declarer.triple_compressed_cobblestone_block);
        regItem("quadruple_compressed_cobblestone", Declarer.quadruple_compressed_cobblestone);
        regBlock("quadruple_compressed_cobblestone_block", Declarer.quadruple_compressed_cobblestone_block);
        regItem("quintuple_compressed_cobblestone", Declarer.quintuple_compressed_cobblestone);
        regBlock("quintuple_compressed_cobblestone_block", Declarer.quintuple_compressed_cobblestone_block);
        regItem("sextuple_compressed_cobblestone", Declarer.sextuple_compressed_cobblestone);
        regBlock("sextuple_compressed_cobblestone_block", Declarer.sextuple_compressed_cobblestone_block);
        regItem("septuple_compressed_cobblestone", Declarer.septuple_compressed_cobblestone);
        regBlock("septuple_compressed_cobblestone_block", Declarer.septuple_compressed_cobblestone_block);
        regItem("octuple_compressed_cobblestone", Declarer.octuple_compressed_cobblestone);
        regBlock("octuple_compressed_cobblestone_block", Declarer.octuple_compressed_cobblestone_block);
        regItem("nonuple_compressed_cobblestone", Declarer.nonuple_compressed_cobblestone);
        regBlock("nonuple_compressed_cobblestone_block", Declarer.nonuple_compressed_cobblestone_block);

        regItem("monuple_compressed_dirt", Declarer.monuple_compressed_dirt);
        regBlock("monuple_compressed_dirt_block", Declarer.monuple_compressed_dirt_block);
        regItem("couple_compressed_dirt", Declarer.couple_compressed_dirt);
        regBlock("couple_compressed_dirt_block", Declarer.couple_compressed_dirt_block);
        regItem("triple_compressed_dirt", Declarer.triple_compressed_dirt);
        regBlock("triple_compressed_dirt_block", Declarer.triple_compressed_dirt_block);
        regItem("quadruple_compressed_dirt", Declarer.quadruple_compressed_dirt);
        regBlock("quadruple_compressed_dirt_block", Declarer.quadruple_compressed_dirt_block);
        regItem("quintuple_compressed_dirt", Declarer.quintuple_compressed_dirt);
        regBlock("quintuple_compressed_dirt_block", Declarer.quintuple_compressed_dirt_block);
        regItem("sextuple_compressed_dirt", Declarer.sextuple_compressed_dirt);
        regBlock("sextuple_compressed_dirt_block", Declarer.sextuple_compressed_dirt_block);
        regItem("septuple_compressed_dirt", Declarer.septuple_compressed_dirt);
        regBlock("septuple_compressed_dirt_block", Declarer.septuple_compressed_dirt_block);
        regItem("octuple_compressed_dirt", Declarer.octuple_compressed_dirt);
        regBlock("octuple_compressed_dirt_block", Declarer.octuple_compressed_dirt_block);
        regItem("nonuple_compressed_dirt", Declarer.nonuple_compressed_dirt);
        regBlock("nonuple_compressed_dirt_block", Declarer.nonuple_compressed_dirt_block);

        regItem("monuple_compressed_diorite", Declarer.monuple_compressed_diorite);
        regBlock("monuple_compressed_diorite_block", Declarer.monuple_compressed_diorite_block);
        regItem("couple_compressed_diorite", Declarer.couple_compressed_diorite);
        regBlock("couple_compressed_diorite_block", Declarer.couple_compressed_diorite_block);
        regItem("triple_compressed_diorite", Declarer.triple_compressed_diorite);
        regBlock("triple_compressed_diorite_block", Declarer.triple_compressed_diorite_block);
        regItem("quadruple_compressed_diorite", Declarer.quadruple_compressed_diorite);
        regBlock("quadruple_compressed_diorite_block", Declarer.quadruple_compressed_diorite_block);
        regItem("quintuple_compressed_diorite", Declarer.quintuple_compressed_diorite);
        regBlock("quintuple_compressed_diorite_block", Declarer.quintuple_compressed_diorite_block);
        regItem("sextuple_compressed_diorite", Declarer.sextuple_compressed_diorite);
        regBlock("sextuple_compressed_diorite_block", Declarer.sextuple_compressed_diorite_block);
        regItem("septuple_compressed_diorite", Declarer.septuple_compressed_diorite);
        regBlock("septuple_compressed_diorite_block", Declarer.septuple_compressed_diorite_block);
        regItem("octuple_compressed_diorite", Declarer.octuple_compressed_diorite);
        regBlock("octuple_compressed_diorite_block", Declarer.octuple_compressed_diorite_block);
        regItem("nonuple_compressed_diorite", Declarer.nonuple_compressed_diorite);
        regBlock("nonuple_compressed_diorite_block", Declarer.nonuple_compressed_diorite_block);

        regItem("monuple_compressed_granite", Declarer.monuple_compressed_granite);
        regBlock("monuple_compressed_granite_block", Declarer.monuple_compressed_granite_block);
        regItem("couple_compressed_granite", Declarer.couple_compressed_granite);
        regBlock("couple_compressed_granite_block", Declarer.couple_compressed_granite_block);
        regItem("triple_compressed_granite", Declarer.triple_compressed_granite);
        regBlock("triple_compressed_granite_block", Declarer.triple_compressed_granite_block);
        regItem("quadruple_compressed_granite", Declarer.quadruple_compressed_granite);
        regBlock("quadruple_compressed_granite_block", Declarer.quadruple_compressed_granite_block);
        regItem("quintuple_compressed_granite", Declarer.quintuple_compressed_granite);
        regBlock("quintuple_compressed_granite_block", Declarer.quintuple_compressed_granite_block);
        regItem("sextuple_compressed_granite", Declarer.sextuple_compressed_granite);
        regBlock("sextuple_compressed_granite_block", Declarer.sextuple_compressed_granite_block);
        regItem("septuple_compressed_granite", Declarer.septuple_compressed_granite);
        regBlock("septuple_compressed_granite_block", Declarer.septuple_compressed_granite_block);
        regItem("octuple_compressed_granite", Declarer.octuple_compressed_granite);
        regBlock("octuple_compressed_granite_block", Declarer.octuple_compressed_granite_block);
        regItem("nonuple_compressed_granite", Declarer.nonuple_compressed_granite);
        regBlock("nonuple_compressed_granite_block", Declarer.nonuple_compressed_granite_block);

        regItem("monuple_compressed_andesite", Declarer.monuple_compressed_andesite);
        regBlock("monuple_compressed_andesite_block", Declarer.monuple_compressed_andesite_block);
        regItem("couple_compressed_andesite", Declarer.couple_compressed_andesite);
        regBlock("couple_compressed_andesite_block", Declarer.couple_compressed_andesite_block);
        regItem("triple_compressed_andesite", Declarer.triple_compressed_andesite);
        regBlock("triple_compressed_andesite_block", Declarer.triple_compressed_andesite_block);
        regItem("quadruple_compressed_andesite", Declarer.quadruple_compressed_andesite);
        regBlock("quadruple_compressed_andesite_block", Declarer.quadruple_compressed_andesite_block);
        regItem("quintuple_compressed_andesite", Declarer.quintuple_compressed_andesite);
        regBlock("quintuple_compressed_andesite_block", Declarer.quintuple_compressed_andesite_block);
        regItem("sextuple_compressed_andesite", Declarer.sextuple_compressed_andesite);
        regBlock("sextuple_compressed_andesite_block", Declarer.sextuple_compressed_andesite_block);
        regItem("septuple_compressed_andesite", Declarer.septuple_compressed_andesite);
        regBlock("septuple_compressed_andesite_block", Declarer.septuple_compressed_andesite_block);
        regItem("octuple_compressed_andesite", Declarer.octuple_compressed_andesite);
        regBlock("octuple_compressed_andesite_block", Declarer.octuple_compressed_andesite_block);
        regItem("nonuple_compressed_andesite", Declarer.nonuple_compressed_andesite);
        regBlock("nonuple_compressed_andesite_block", Declarer.nonuple_compressed_andesite_block);

        regItem("monuple_compressed_netherrack", Declarer.monuple_compressed_netherrack);
        regBlock("monuple_compressed_netherrack_block", Declarer.monuple_compressed_netherrack_block);
        regItem("couple_compressed_netherrack", Declarer.couple_compressed_netherrack);
        regBlock("couple_compressed_netherrack_block", Declarer.couple_compressed_netherrack_block);
        regItem("triple_compressed_netherrack", Declarer.triple_compressed_netherrack);
        regBlock("triple_compressed_netherrack_block", Declarer.triple_compressed_netherrack_block);
        regItem("quadruple_compressed_netherrack", Declarer.quadruple_compressed_netherrack);
        regBlock("quadruple_compressed_netherrack_block", Declarer.quadruple_compressed_netherrack_block);
        regItem("quintuple_compressed_netherrack", Declarer.quintuple_compressed_netherrack);
        regBlock("quintuple_compressed_netherrack_block", Declarer.quintuple_compressed_netherrack_block);
        regItem("sextuple_compressed_netherrack", Declarer.sextuple_compressed_netherrack);
        regBlock("sextuple_compressed_netherrack_block", Declarer.sextuple_compressed_netherrack_block);
        regItem("septuple_compressed_netherrack", Declarer.septuple_compressed_netherrack);
        regBlock("septuple_compressed_netherrack_block", Declarer.septuple_compressed_netherrack_block);
        regItem("octuple_compressed_netherrack", Declarer.octuple_compressed_netherrack);
        regBlock("octuple_compressed_netherrack_block", Declarer.octuple_compressed_netherrack_block);
        regItem("nonuple_compressed_netherrack", Declarer.nonuple_compressed_netherrack);
        regBlock("nonuple_compressed_netherrack_block", Declarer.nonuple_compressed_netherrack_block);

        regItem("monuple_compressed_sand", Declarer.monuple_compressed_sand);
        regBlock("monuple_compressed_sand_block", Declarer.monuple_compressed_sand_block);
        regItem("couple_compressed_sand", Declarer.couple_compressed_sand);
        regBlock("couple_compressed_sand_block", Declarer.couple_compressed_sand_block);
        regItem("triple_compressed_sand", Declarer.triple_compressed_sand);
        regBlock("triple_compressed_sand_block", Declarer.triple_compressed_sand_block);
        regItem("quadruple_compressed_sand", Declarer.quadruple_compressed_sand);
        regBlock("quadruple_compressed_sand_block", Declarer.quadruple_compressed_sand_block);
        regItem("quintuple_compressed_sand", Declarer.quintuple_compressed_sand);
        regBlock("quintuple_compressed_sand_block", Declarer.quintuple_compressed_sand_block);
        regItem("sextuple_compressed_sand", Declarer.sextuple_compressed_sand);
        regBlock("sextuple_compressed_sand_block", Declarer.sextuple_compressed_sand_block);
        regItem("septuple_compressed_sand", Declarer.septuple_compressed_sand);
        regBlock("septuple_compressed_sand_block", Declarer.septuple_compressed_sand_block);
        regItem("octuple_compressed_sand", Declarer.octuple_compressed_sand);
        regBlock("octuple_compressed_sand_block", Declarer.octuple_compressed_sand_block);
        regItem("nonuple_compressed_sand", Declarer.nonuple_compressed_sand);
        regBlock("nonuple_compressed_sand_block", Declarer.nonuple_compressed_sand_block);

        regItem("monuple_compressed_gravel", Declarer.monuple_compressed_gravel);
        regBlock("monuple_compressed_gravel_block", Declarer.monuple_compressed_gravel_block);
        regItem("couple_compressed_gravel", Declarer.couple_compressed_gravel);
        regBlock("couple_compressed_gravel_block", Declarer.couple_compressed_gravel_block);
        regItem("triple_compressed_gravel", Declarer.triple_compressed_gravel);
        regBlock("triple_compressed_gravel_block", Declarer.triple_compressed_gravel_block);
        regItem("quadruple_compressed_gravel", Declarer.quadruple_compressed_gravel);
        regBlock("quadruple_compressed_gravel_block", Declarer.quadruple_compressed_gravel_block);
        regItem("quintuple_compressed_gravel", Declarer.quintuple_compressed_gravel);
        regBlock("quintuple_compressed_gravel_block", Declarer.quintuple_compressed_gravel_block);
        regItem("sextuple_compressed_gravel", Declarer.sextuple_compressed_gravel);
        regBlock("sextuple_compressed_gravel_block", Declarer.sextuple_compressed_gravel_block);
        regItem("septuple_compressed_gravel", Declarer.septuple_compressed_gravel);
        regBlock("septuple_compressed_gravel_block", Declarer.septuple_compressed_gravel_block);
        regItem("octuple_compressed_gravel", Declarer.octuple_compressed_gravel);
        regBlock("octuple_compressed_gravel_block", Declarer.octuple_compressed_gravel_block);
        regItem("nonuple_compressed_gravel", Declarer.nonuple_compressed_gravel);
        regBlock("nonuple_compressed_gravel_block", Declarer.nonuple_compressed_gravel_block);

        regItem("monuple_compressed_cobbled_deepslate", Declarer.monuple_compressed_cobbled_deepslate);
        regBlock("monuple_compressed_cobbled_deepslate_block", Declarer.monuple_compressed_cobbled_deepslate_block);
        regItem("couple_compressed_cobbled_deepslate", Declarer.couple_compressed_cobbled_deepslate);
        regBlock("couple_compressed_cobbled_deepslate_block", Declarer.couple_compressed_cobbled_deepslate_block);
        regItem("triple_compressed_cobbled_deepslate", Declarer.triple_compressed_cobbled_deepslate);
        regBlock("triple_compressed_cobbled_deepslate_block", Declarer.triple_compressed_cobbled_deepslate_block);
        regItem("quadruple_compressed_cobbled_deepslate", Declarer.quadruple_compressed_cobbled_deepslate);
        regBlock("quadruple_compressed_cobbled_deepslate_block", Declarer.quadruple_compressed_cobbled_deepslate_block);
        regItem("quintuple_compressed_cobbled_deepslate", Declarer.quintuple_compressed_cobbled_deepslate);
        regBlock("quintuple_compressed_cobbled_deepslate_block", Declarer.quintuple_compressed_cobbled_deepslate_block);
        regItem("sextuple_compressed_cobbled_deepslate", Declarer.sextuple_compressed_cobbled_deepslate);
        regBlock("sextuple_compressed_cobbled_deepslate_block", Declarer.sextuple_compressed_cobbled_deepslate_block);
        regItem("septuple_compressed_cobbled_deepslate", Declarer.septuple_compressed_cobbled_deepslate);
        regBlock("septuple_compressed_cobbled_deepslate_block", Declarer.septuple_compressed_cobbled_deepslate_block);
        regItem("octuple_compressed_cobbled_deepslate", Declarer.octuple_compressed_cobbled_deepslate);
        regBlock("octuple_compressed_cobbled_deepslate_block", Declarer.octuple_compressed_cobbled_deepslate_block);
        regItem("nonuple_compressed_cobbled_deepslate", Declarer.nonuple_compressed_cobbled_deepslate);
        regBlock("nonuple_compressed_cobbled_deepslate_block", Declarer.nonuple_compressed_cobbled_deepslate_block);

        regItem("monuple_compressed_tuff", Declarer.monuple_compressed_tuff);
        regBlock("monuple_compressed_tuff_block", Declarer.monuple_compressed_tuff_block);
        regItem("couple_compressed_tuff", Declarer.couple_compressed_tuff);
        regBlock("couple_compressed_tuff_block", Declarer.couple_compressed_tuff_block);
        regItem("triple_compressed_tuff", Declarer.triple_compressed_tuff);
        regBlock("triple_compressed_tuff_block", Declarer.triple_compressed_tuff_block);
        regItem("quadruple_compressed_tuff", Declarer.quadruple_compressed_tuff);
        regBlock("quadruple_compressed_tuff_block", Declarer.quadruple_compressed_tuff_block);
        regItem("quintuple_compressed_tuff", Declarer.quintuple_compressed_tuff);
        regBlock("quintuple_compressed_tuff_block", Declarer.quintuple_compressed_tuff_block);
        regItem("sextuple_compressed_tuff", Declarer.sextuple_compressed_tuff);
        regBlock("sextuple_compressed_tuff_block", Declarer.sextuple_compressed_tuff_block);
        regItem("septuple_compressed_tuff", Declarer.septuple_compressed_tuff);
        regBlock("septuple_compressed_tuff_block", Declarer.septuple_compressed_tuff_block);
        regItem("octuple_compressed_tuff", Declarer.octuple_compressed_tuff);
        regBlock("octuple_compressed_tuff_block", Declarer.octuple_compressed_tuff_block);
        regItem("nonuple_compressed_tuff", Declarer.nonuple_compressed_tuff);
        regBlock("nonuple_compressed_tuff_block", Declarer.nonuple_compressed_tuff_block);
        
        regItem("monuple_compressed_calcite", Declarer.monuple_compressed_calcite);
        regBlock("monuple_compressed_calcite_block", Declarer.monuple_compressed_calcite_block);
        regItem("couple_compressed_calcite", Declarer.couple_compressed_calcite);
        regBlock("couple_compressed_calcite_block", Declarer.couple_compressed_calcite_block);
        regItem("triple_compressed_calcite", Declarer.triple_compressed_calcite);
        regBlock("triple_compressed_calcite_block", Declarer.triple_compressed_calcite_block);
        regItem("quadruple_compressed_calcite", Declarer.quadruple_compressed_calcite);
        regBlock("quadruple_compressed_calcite_block", Declarer.quadruple_compressed_calcite_block);
        regItem("quintuple_compressed_calcite", Declarer.quintuple_compressed_calcite);
        regBlock("quintuple_compressed_calcite_block", Declarer.quintuple_compressed_calcite_block);
        regItem("sextuple_compressed_calcite", Declarer.sextuple_compressed_calcite);
        regBlock("sextuple_compressed_calcite_block", Declarer.sextuple_compressed_calcite_block);
        regItem("septuple_compressed_calcite", Declarer.septuple_compressed_calcite);
        regBlock("septuple_compressed_calcite_block", Declarer.septuple_compressed_calcite_block);
        regItem("octuple_compressed_calcite", Declarer.octuple_compressed_calcite);
        regBlock("octuple_compressed_calcite_block", Declarer.octuple_compressed_calcite_block);
        regItem("nonuple_compressed_calcite", Declarer.nonuple_compressed_calcite);
        regBlock("nonuple_compressed_calcite_block", Declarer.nonuple_compressed_calcite_block);


        Declarer.FLEATHERCOOK = createSmeltingRecipeJson(Declarer.fleather, Items.LEATHER, 0.1f, 200, furnaceTypes.smoking);//always load this, even if you can't craft the fleather

        Identifier tempID;
        if (Ref.shapeless) {
            if (Ref.shapeless_arrow) {
                Declarer.ARROW = createShapelessRecipeJson(
                        Lists.newArrayList(Registry.ITEM.getId(Items.FLINT), Registry.ITEM.getId(Items.STICK), Registry.ITEM.getId(Items.FEATHER)),
                        Lists.newArrayList(false, false, false),
                        Registry.ITEM.getId(Items.ARROW),
                        4);
            }
            if (Ref.shapeless_bread) {
                tempID = Registry.ITEM.getId(Items.WHEAT);
                Declarer.BREAD = createShapelessRecipeJson(
                        Lists.newArrayList(tempID, tempID, tempID),
                        Lists.newArrayList(false, false, false),
                        Registry.ITEM.getId(Items.BREAD),
                        1);
            }
            if (Ref.shapeless_paper) {
                tempID = Registry.ITEM.getId(Items.SUGAR_CANE);
                Declarer.PAPER = createShapelessRecipeJson(
                        Lists.newArrayList(tempID, tempID, tempID),
                        Lists.newArrayList(false, false, false),
                        Registry.ITEM.getId(Items.PAPER),
                        3);
            }
            if (Ref.shapeless_shulker) {
                tempID = Registry.ITEM.getId(Items.SHULKER_SHELL);
                Declarer.SHULKERBOX = createShapelessRecipeJson(
                        Lists.newArrayList(tempID, tempID, Registry.ITEM.getId(Items.CHEST)),
                        Lists.newArrayList(false, false, false),
                        Registry.ITEM.getId(Items.SHULKER_BOX),
                        1);
            }
        }
        if (Ref.convertStone) {
            if (Ref.convertStone_blackstone) {
                Declarer.BLACKSTONE = DynamicRecipeLoader.createShapedRecipeJsonComplex(
                        Lists.newArrayList(new String[]{Ref.MODID + ":stone", "minecraft:stone_bricks", "minecraft:stone_crafting_materials", "minecraft:stone"}, new String[]{"minecraft:coals"}),
                        Lists.newArrayList(Lists.newArrayList(true, true, true, false), Lists.newArrayList(true)),
                        Lists.newArrayList("000", "010", "000"),
                        Registry.ITEM.getId(Items.BLACKSTONE),
                        8
                );
            }
            if (Ref.convertStone_diorite) {
                Declarer.DIORITE = DynamicRecipeLoader.createShapedRecipeJsonComplex(
                        Lists.newArrayList(new String[]{Ref.MODID + ":stone", "minecraft:stone_bricks", "minecraft:stone_crafting_materials", "minecraft:stone"}, new String[]{"minecraft:quartz"}),
                        Lists.newArrayList(Lists.newArrayList(true, true, true, false), Lists.newArrayList(false)),
                        Lists.newArrayList("000", "010", "000"),
                        Registry.ITEM.getId(Items.DIORITE),
                        8
                );
            }
            if (Ref.convertStone_granite) {
                Declarer.GRANITE = createShapedRecipeJson(
                        Lists.newArrayList(new Identifier(Ref.MODID, "diorite"), Registry.ITEM.getId(Items.RED_DYE)),
                        Lists.newArrayList(true, false),
                        Lists.newArrayList("000", "010", "000"),
                        Registry.ITEM.getId(Items.GRANITE),
                        8
                );
            }
            if (Ref.convertStone_andesite) {
                Declarer.ANDESITE = createShapedRecipeJson(
                        Lists.newArrayList(new Identifier(Ref.MODID, "diorite"), Registry.ITEM.getId(Items.COBBLESTONE)),
                        Lists.newArrayList(true, false),
                        Lists.newArrayList("000", "010", "000"),
                        Registry.ITEM.getId(Items.ANDESITE),
                        8
                );
            }
            if (Ref.convertStone_gilded_blackstone) {
                Declarer.GILDED_BLACKSTONE = createShapedRecipeJson(
                        Lists.newArrayList(Registry.ITEM.getId(Items.GOLD_NUGGET), Registry.ITEM.getId(Items.BLACKSTONE)),
                        Lists.newArrayList(false, false),
                        Lists.newArrayList("000", "010", "000"),
                        Registry.ITEM.getId(Items.GILDED_BLACKSTONE),
                        1
                );
            }
            if (Ref.convertStone_mossy_cobblestone) {
                Declarer.MOSSY_COBBLESTONE = createShapedRecipeJson(
                        Lists.newArrayList(Registry.ITEM.getId(Items.COBBLESTONE), Registry.ITEM.getId(Items.WATER_BUCKET)),
                        Lists.newArrayList(false, false),
                        Lists.newArrayList("000", "010", "000"),
                        Registry.ITEM.getId(Items.MOSSY_COBBLESTONE),
                        8);
            }
        }
        if (Ref.quartz) {
            Declarer.QUARTZ_PILLAR_CHISELED = createShapelessRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Items.QUARTZ_PILLAR)),
                    Lists.newArrayList(false),
                    Registry.ITEM.getId(Items.CHISELED_QUARTZ_BLOCK),
                    1);
            Declarer.QUARTZ_CHISELED = createShapelessRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Items.CHISELED_QUARTZ_BLOCK)),
                    Lists.newArrayList(false),
                    Registry.ITEM.getId(Items.QUARTZ_BLOCK),
                    1);
        }
        if (Ref.unpack) {
            if (Ref.unpack_clay) {
                Declarer.CLAY = createShapelessRecipeJson(
                        Lists.newArrayList(Registry.ITEM.getId(Items.CLAY)),
                        Lists.newArrayList(false),
                        Registry.ITEM.getId(Items.CLAY_BALL),
                        4);
            }
            if (Ref.unpack_flint) {
                Declarer.FLINT = createShapelessRecipeJson(
                        Lists.newArrayList(Registry.ITEM.getId(Items.GRAVEL)),
                        Lists.newArrayList(false),
                        Registry.ITEM.getId(Items.FLINT),
                        1);
            }
            if (Ref.unpack_amethyst) {
                Declarer.AMETHYST = createShapelessRecipeJson(
                        Lists.newArrayList(Registry.ITEM.getId(Items.AMETHYST_BLOCK)),
                        Lists.newArrayList(false),
                        Registry.ITEM.getId(Items.AMETHYST_SHARD),
                        4);
            }
            if (Ref.unpack_blazerod) {
                tempID = Registry.ITEM.getId(Items.BLAZE_POWDER);
                Declarer.BLAZEROD = createShapelessRecipeJson(
                        Lists.newArrayList(tempID, tempID),
                        Lists.newArrayList(false, false),
                        Registry.ITEM.getId(Items.BLAZE_ROD),
                        1);
            }
            if (Ref.unpack_brown_mushroom) {
                tempID = Registry.ITEM.getId(Items.BROWN_MUSHROOM);
                Declarer.BROWN_MUSHROOM = createShapelessRecipeJson(
                        Lists.newArrayList(tempID, tempID, tempID, tempID),
                        Lists.newArrayList(false, false, false, false),
                        Registry.ITEM.getId(Items.BROWN_MUSHROOM_BLOCK),
                        1);
            }
            if (Ref.unpack_red_mushroom) {
                tempID = Registry.ITEM.getId(Items.RED_MUSHROOM);
                Declarer.RED_MUSHROOM = createShapelessRecipeJson(
                        Lists.newArrayList(tempID, tempID, tempID, tempID),
                        Lists.newArrayList(false, false, false, false),
                        Registry.ITEM.getId(Items.RED_MUSHROOM_BLOCK),
                        1);
            }
            if (Ref.unpack_wart) {
                Declarer.WART = createShapelessRecipeJson(
                        Lists.newArrayList(Registry.ITEM.getId(Items.NETHER_WART_BLOCK)),
                        Lists.newArrayList(false),
                        Registry.ITEM.getId(Items.NETHER_WART),
                        9);
            }
            if (Ref.unpack_glowstone) {
                Declarer.GLOWSTONE = createShapelessRecipeJson(
                        Lists.newArrayList(Registry.ITEM.getId(Items.GLOWSTONE)),
                        Lists.newArrayList(false),
                        Registry.ITEM.getId(Items.GLOWSTONE_DUST),
                        4);
            }
            if (Ref.unpack_string) {
                Declarer.STRING = createShapelessRecipeJson(
                        Lists.newArrayList(new Identifier("minecraft", "wool")),
                        Lists.newArrayList(true),
                        Registry.ITEM.getId(Items.STRING),
                        4);
            }
            if (Ref.unpack_quartz) {
                Declarer.QUARTZ = createShapelessRecipeJson(
                        Lists.newArrayList(Registry.ITEM.getId(Items.QUARTZ_BLOCK)),
                        Lists.newArrayList(false),
                        Registry.ITEM.getId(Items.QUARTZ),
                        4);
            }
        }
        if (Ref.chests) {
            Declarer.CHESTS = createShapedRecipeJson(
                    Lists.newArrayList(new Identifier("minecraft", "logs")),//items
                    Lists.newArrayList(true),//type
                    Lists.newArrayList("000", "0 0", "000"),//pattern
                    Registry.ITEM.getId(Items.CHEST),
                    4
            );
        }
        if (Ref.horseArmor) {
            if (Ref.horseArmor_diamond) {
                Declarer.HORSE_DIAMOND = createShapedRecipeJson(
                        Lists.newArrayList(new Identifier("minecraft", "wool"), Registry.ITEM.getId(Items.DIAMOND), Registry.ITEM.getId(Items.DIAMOND_LEGGINGS), Registry.ITEM.getId(Items.DIAMOND_HELMET)),//items
                        Lists.newArrayList(true, false, false, false),//type
                        Lists.newArrayList("  3", "101", "2 2"),//pattern
                        Registry.ITEM.getId(Items.DIAMOND_HORSE_ARMOR),
                        1
                );
            }
            if (Ref.horseArmor_gold) {
                Declarer.HORSE_GOLD = createShapedRecipeJson(
                        Lists.newArrayList(new Identifier("minecraft", "wool"), Registry.ITEM.getId(Items.GOLD_INGOT), Registry.ITEM.getId(Items.GOLDEN_LEGGINGS), Registry.ITEM.getId(Items.GOLDEN_HELMET)),//items
                        Lists.newArrayList(true, false, false, false),//type
                        Lists.newArrayList("  3", "101", "2 2"),//pattern
                        Registry.ITEM.getId(Items.GOLDEN_HORSE_ARMOR),
                        1
                );
            }
            if (Ref.horseArmor_iron) {
                Declarer.HORSE_IRON = createShapedRecipeJson(
                        Lists.newArrayList(new Identifier("minecraft", "wool"), Registry.ITEM.getId(Items.IRON_INGOT), Registry.ITEM.getId(Items.IRON_LEGGINGS), Registry.ITEM.getId(Items.IRON_HELMET)),//items
                        Lists.newArrayList(true, false, false, false),//type
                        Lists.newArrayList("  3", "101", "2 2"),//pattern
                        Registry.ITEM.getId(Items.IRON_HORSE_ARMOR),
                        1
                );
            }
        }
        if (Ref.massTorch) {
            Declarer.TORCH = createShapelessRecipeJson(
                    Lists.newArrayList(new Identifier(Ref.MODID, "coalblocks"), Registry.ITEM.getId(Declarer.large_stick_bundle)),
                    Lists.newArrayList(true, false),
                    Registry.ITEM.getId(Items.TORCH),
                    64);
        }
        if (Ref.overpowered) {
            if (Ref.overpowered_slime) {
                Declarer.SLIMEBALL = createShapelessRecipeJson(
                        Lists.newArrayList(Registry.ITEM.getId(Items.HONEY_BOTTLE), Registry.ITEM.getId(Items.LIME_DYE)),
                        Lists.newArrayList(false, false),
                        Registry.ITEM.getId(Items.SLIME_BALL),
                        1);
            }
            if (Ref.overpowered_trident) {
                Declarer.TRIDENT = createShapedRecipeJson(
                        Lists.newArrayList(Registry.ITEM.getId(Items.IRON_INGOT), Registry.ITEM.getId(Items.STICK)),//items
                        Lists.newArrayList(false, false),//type
                        Lists.newArrayList(" 00", " 10", "1  "),//pattern
                        Registry.ITEM.getId(Items.TRIDENT),
                        1
                );
            }
            if (Ref.overpowered_nametag) {
                tempID = Registry.ITEM.getId(Items.PAPER);
                Declarer.NAMETAG = createShapelessRecipeJson(
                        Lists.newArrayList(tempID, tempID, Registry.ITEM.getId(Items.STRING), Registry.ITEM.getId(Items.SLIME_BALL)),
                        Lists.newArrayList(false, false, false, false),
                        Registry.ITEM.getId(Items.NAME_TAG),
                        1);
            }
            if (Ref.overpowered_notchapple) {
                Declarer.NOTCH_APPLE = createShapedRecipeJson(
                        Lists.newArrayList(Registry.ITEM.getId(Items.GOLD_BLOCK), Registry.ITEM.getId(Items.APPLE)),
                        Lists.newArrayList(false, false),
                        Lists.newArrayList("000", "010", "000"),
                        Registry.ITEM.getId(Items.ENCHANTED_GOLDEN_APPLE),
                        1);
            }
            if (Ref.overpowered_saddle) {
                Declarer.SADDLE = createShapedRecipeJson(
                        Lists.newArrayList(Registry.ITEM.getId(Items.LEATHER), Registry.ITEM.getId(Items.TRIPWIRE_HOOK), Registry.ITEM.getId(Items.STRING)),//items
                        Lists.newArrayList(false, false, false),//type
                        Lists.newArrayList("000", "2 2", "1 1"),//pattern
                        Registry.ITEM.getId(Items.SADDLE),
                        1
                );
            }
        }
        if (Ref.rawBlockSmelt) {
            if (Ref.rawBlockSmelt_copper) {
                Declarer.COPPER_BLOCK_FURNACE = createSmeltingRecipeJson(Items.RAW_COPPER_BLOCK, Items.COPPER_BLOCK, 7f, 1600, furnaceTypes.smelting);
                Declarer.COPPER_BLOCK_BLAST = createSmeltingRecipeJson(Items.RAW_COPPER_BLOCK, Items.COPPER_BLOCK, 7f, 1600, furnaceTypes.blasting);
            }
            if (Ref.rawBlockSmelt_iron) {
                Declarer.IRON_BLOCK_FURNACE = createSmeltingRecipeJson(Items.RAW_IRON_BLOCK, Items.IRON_BLOCK, 7f, 1600, furnaceTypes.smelting);
                Declarer.IRON_BLOCK_BLAST = createSmeltingRecipeJson(Items.RAW_IRON_BLOCK, Items.IRON_BLOCK, 7f, 1600, furnaceTypes.blasting);
            }
            if (Ref.rawBlockSmelt_gold) {
                Declarer.GOLD_BLOCK_FURNACE = createSmeltingRecipeJson(Items.RAW_GOLD_BLOCK, Items.GOLD_BLOCK, 7f, 1600, furnaceTypes.smelting);
                Declarer.GOLD_BLOCK_BLAST = createSmeltingRecipeJson(Items.RAW_GOLD_BLOCK, Items.GOLD_BLOCK, 7f, 1600, furnaceTypes.blasting);
            }
        }
        if (Ref.reclaim) {
            if (Ref.reclaim_copper) {
                Declarer.RECLAIM_COPPER = createSmeltingRecipeJsonComplex(new Item[]{
                                Declarer.copper_pick,
                                Declarer.copper_shovel,
                                Declarer.copper_axe,
                                Declarer.copper_hoe,
                                Declarer.copper_sword,
                                Declarer.copper_helmet,
                                Declarer.copper_chestplate,
                                Declarer.copper_leggings,
                                Declarer.copper_boots
                        },
                        Items.COPPER_INGOT, 0.1f, 200, furnaceTypes.blasting);
            }
            if (Ref.reclaim_iron) {
                Declarer.RECLAIM_IRON = createSmeltingRecipeJsonComplex(new Item[]{
                                Items.IRON_PICKAXE,
                                Items.IRON_SHOVEL,
                                Items.IRON_AXE,
                                Items.IRON_HOE,
                                Items.IRON_SWORD,
                                Items.IRON_HELMET,
                                Items.IRON_CHESTPLATE,
                                Items.IRON_LEGGINGS,
                                Items.IRON_BOOTS,
                                Items.IRON_HORSE_ARMOR
                        },
                        Items.IRON_INGOT, 0.1f, 200, furnaceTypes.blasting);
            }
            if (Ref.reclaim_gold) {
                Declarer.RECLAIM_GOLD = createSmeltingRecipeJsonComplex(new Item[]{
                                Items.GOLDEN_PICKAXE,
                                Items.GOLDEN_SHOVEL,
                                Items.GOLDEN_AXE,
                                Items.GOLDEN_HOE,
                                Items.GOLDEN_SWORD,
                                Items.GOLDEN_HELMET,
                                Items.GOLDEN_CHESTPLATE,
                                Items.GOLDEN_LEGGINGS,
                                Items.GOLDEN_BOOTS,
                                Items.GOLDEN_HORSE_ARMOR
                        },
                        Items.GOLD_INGOT, 0.1f, 200, furnaceTypes.blasting);
            }
            if (Ref.reclaim_diamond) {
                Declarer.RECLAIM_DIAMOND = createSmeltingRecipeJsonComplex(new Item[]{
                                Items.DIAMOND_PICKAXE,
                                Items.DIAMOND_SHOVEL,
                                Items.DIAMOND_AXE,
                                Items.DIAMOND_HOE,
                                Items.DIAMOND_SWORD,
                                Items.DIAMOND_HELMET,
                                Items.DIAMOND_CHESTPLATE,
                                Items.DIAMOND_LEGGINGS,
                                Items.DIAMOND_BOOTS,
                                Items.DIAMOND_HORSE_ARMOR
                        },
                        Items.DIAMOND, 0.1f, 200, furnaceTypes.blasting);
            }
        }
        if (Ref.daylighter) {
            Declarer.PDD = createShapedRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Items.DAYLIGHT_DETECTOR), Registry.ITEM.getId(Items.GOLD_INGOT)),//items
                    Lists.newArrayList(false, false),//type
                    Lists.newArrayList(" 1 ", "101", " 1 "),//pattern
                    Registry.ITEM.getId(Declarer.personal_daylight_detector),
                    1
            );
        }
        if (Ref.slimer) {
            Declarer.SCL = createShapelessRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Items.IRON_INGOT), Registry.ITEM.getId(Items.SLIME_BALL), Registry.ITEM.getId(Items.REDSTONE_BLOCK)),
                    Lists.newArrayList(false, false, false),
                    Registry.ITEM.getId(Declarer.slime_chunk_locator),
                    1);
        }
        if (Ref.massArrow) {
            Declarer.MASS_ARROW = createShapelessRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Declarer.feather_block), Registry.ITEM.getId(Declarer.large_stick_bundle), Registry.ITEM.getId(Items.OBSIDIAN)),
                    Lists.newArrayList(false, false, false),
                    Registry.ITEM.getId(Items.ARROW),
                    64);
        }
        if (Ref.chunker) {
            Declarer.CHUNKLOADER = createShapedRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Items.DIAMOND), Registry.ITEM.getId(Items.GOLD_INGOT), Registry.ITEM.getId(Items.ENDER_PEARL)),//items
                    Lists.newArrayList(false, false, false),//type
                    Lists.newArrayList("010", "121", "010"),//pattern
                    Registry.ITEM.getId(Declarer.chunk_loader),
                    1
            );
        }
        if (Ref.fleather) {
            tempID = Registry.ITEM.getId(Items.ROTTEN_FLESH);
            Declarer.FLEATHER = createShapelessRecipeJson(
                    Lists.newArrayList(tempID, tempID, tempID, tempID),
                    Lists.newArrayList(false, false, false, false),
                    Registry.ITEM.getId(Declarer.fleather),
                    1);
        }
        if (Ref.charcoal) {
            tempID = Registry.ITEM.getId(Items.CHARCOAL);
            Declarer.CHARCOAL_BLOCK = createShapelessRecipeJson(
                    Lists.newArrayList(tempID, tempID, tempID, tempID, tempID, tempID, tempID, tempID, tempID),
                    Lists.newArrayList(false, false, false, false, false, false, false, false, false),
                    Registry.ITEM.getId(Declarer.charcoal_block),
                    1);
            Declarer.CHARCOAL_BLOCK_U = createShapelessRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Declarer.charcoal_block)),
                    Lists.newArrayList(false),
                    Registry.ITEM.getId(Items.CHARCOAL),
                    9);
        }
        if (Ref.sticks) {
            tempID = Registry.ITEM.getId(Items.STICK);
            Declarer.STICK_BUNDLE_S = createShapelessRecipeJson(
                    Lists.newArrayList(tempID, tempID, tempID, tempID),
                    Lists.newArrayList(false, false, false, false),
                    Registry.ITEM.getId(Declarer.small_stick_bundle),
                    1);
            Declarer.STICK_BUNDLE_S_U = createShapelessRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Declarer.small_stick_bundle)),
                    Lists.newArrayList(false),
                    tempID,
                    4);
            tempID = Registry.ITEM.getId(Declarer.small_stick_bundle);
            Declarer.STICK_BUNDLE_L = createShapelessRecipeJson(
                    Lists.newArrayList(tempID, tempID, tempID, tempID),
                    Lists.newArrayList(false, false, false, false),
                    Registry.ITEM.getId(Declarer.large_stick_bundle),
                    1);
            Declarer.STICK_BUNDLE_L_U = createShapelessRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Declarer.large_stick_bundle)),
                    Lists.newArrayList(false),
                    tempID,
                    4);
        }
        if (Ref.featherBlock) {
            tempID = Registry.ITEM.getId(Items.FEATHER);
            Declarer.FEATHER = createShapelessRecipeJson(
                    Lists.newArrayList(tempID, tempID, tempID, tempID, tempID, tempID, tempID, tempID, tempID),
                    Lists.newArrayList(false, false, false, false, false, false, false, false, false),
                    Registry.ITEM.getId(Declarer.feather_block),
                    1);
            Declarer.FEATHER_U = createShapelessRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Declarer.feather_block)),
                    Lists.newArrayList(false),
                    Registry.ITEM.getId(Items.FEATHER),
                    9);
        }
        if (Ref.coalChunks) {
            tempID = Registry.ITEM.getId(Declarer.charcoal_nugget);
            Declarer.CHARCOAL_NUGGET_U = createShapelessRecipeJson(
                    Lists.newArrayList(tempID, tempID, tempID, tempID, tempID, tempID, tempID, tempID),
                    Lists.newArrayList(false, false, false, false, false, false, false, false),
                    Registry.ITEM.getId(Items.CHARCOAL),
                    1);
            Declarer.CHARCOAL_NUGGET = createShapelessRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Items.CHARCOAL)),
                    Lists.newArrayList(false),
                    Registry.ITEM.getId(Declarer.charcoal_nugget),
                    8);
            tempID = Registry.ITEM.getId(Declarer.coal_nugget);
            Declarer.COAL_NUGGET_U = createShapelessRecipeJson(
                    Lists.newArrayList(tempID, tempID, tempID, tempID, tempID, tempID, tempID, tempID),
                    Lists.newArrayList(false, false, false, false, false, false, false, false),
                    Registry.ITEM.getId(Items.COAL),
                    1);
            Declarer.COAL_NUGGET = createShapelessRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Items.COAL)),
                    Lists.newArrayList(false),
                    Registry.ITEM.getId(Declarer.coal_nugget),
                    8);
        }
        if (Ref.furnaces) {
            Declarer.FURNACE = createShapedRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Items.COBBLESTONE)),
                    Lists.newArrayList(false),
                    Lists.newArrayList("000", "0 0", "000"),
                    Registry.ITEM.getId(Items.FURNACE),
                    1);//changing the vanilla recipe is a must if you want to be able to craft the below

            Declarer.ANDESITE_FURNACE = createFurnace(new Identifier(Ref.MODID,"andesite"), Declarer.andesite_furnace);
            Declarer.BLACKSTONE_FURNACE = createFurnace(new Identifier(Ref.MODID,"blackstone"), Declarer.blackstone_furnace);
            Declarer.BASALT_FURNACE = createFurnace(new Identifier(Ref.MODID,"basalt"), Declarer.basalt_furnace);
            Declarer.DEEPSLATE_FURNACE = createFurnace(new Identifier(Ref.MODID,"deepslate"), Declarer.deepslate_furnace);
            Declarer.DIORITE_FURNACE = createFurnace(new Identifier(Ref.MODID,"diorite"), Declarer.diorite_furnace);
            Declarer.ENDSTONE_FURNACE = createFurnace(new Identifier(Ref.MODID,"endstone"), Declarer.endstone_furnace);
            Declarer.GRANITE_FURNACE = createFurnace(new Identifier(Ref.MODID,"granite"), Declarer.granite_furnace);
            Declarer.SANDSTONE_FURNACE = createFurnace(new Identifier(Ref.MODID,"sandstone"), Declarer.sandstone_furnace);
            Declarer.RED_SANDSTONE_FURNACE = createFurnace(new Identifier(Ref.MODID,"redsandstone"), Declarer.red_sandstone_furnace);
            Declarer.NETHERRACK_FURNACE = createShapedRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Items.NETHERRACK)),//items
                    Lists.newArrayList(false),//type
                    Lists.newArrayList("000", "0 0", "000"),//pattern
                    Registry.ITEM.getId(Declarer.netherrack_furnace),
                    1
            );
        }
        if (Ref.blasts) {
            Declarer.ANDESITE_BLAST = createBlast(new Identifier(Ref.MODID,"andesite"), Declarer.andesite_furnace, Declarer.andesite_blast_furnace);
            Declarer.BLACKSTONE_BLAST = createBlast(new Identifier(Ref.MODID,"blackstone"), Declarer.blackstone_furnace, Declarer.blackstone_blast_furnace);
            Declarer.BASALT_BLAST = createBlast(new Identifier(Ref.MODID,"basalt"), Declarer.basalt_furnace, Declarer.basalt_blast_furnace);
            Declarer.DEEPSLATE_BLAST = createBlast(new Identifier(Ref.MODID,"deepslate"), Declarer.deepslate_furnace, Declarer.deepslate_blast_furnace);
            Declarer.DIORITE_BLAST = createBlast(new Identifier(Ref.MODID,"diorite"), Declarer.diorite_furnace, Declarer.diorite_blast_furnace);
            Declarer.ENDSTONE_BLAST = createBlast(new Identifier(Ref.MODID,"endstone"), Declarer.endstone_furnace, Declarer.endstone_blast_furnace);
            Declarer.GRANITE_BLAST = createBlast(new Identifier(Ref.MODID,"granite"), Declarer.granite_furnace, Declarer.granite_blast_furnace);
            Declarer.SANDSTONE_BLAST = createBlast(new Identifier(Ref.MODID,"sandstone"), Declarer.sandstone_furnace, Declarer.sandstone_blast_furnace);
            Declarer.RED_SANDSTONE_BLAST = createBlast(new Identifier(Ref.MODID,"redsandstone"), Declarer.red_sandstone_furnace, Declarer.red_sandstone_blast_furnace);
            Declarer.NETHERRACK_BLAST = createShapedRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Items.IRON_INGOT), Registry.ITEM.getId(Declarer.netherrack_furnace), Registry.ITEM.getId(Items.NETHER_BRICK)),//items
                    Lists.newArrayList(false, false, false),//type
                    Lists.newArrayList("000", "010", "222"),//pattern
                    Registry.ITEM.getId(Declarer.netherrack_blast_furnace),
                    1
            );
        }
        if (Ref.smokers) {
            Declarer.ANDESITE_SMOKER = createSmoker(Declarer.andesite_furnace, Declarer.andesite_smoker);
            Declarer.BLACKSTONE_SMOKER = createSmoker(Declarer.blackstone_furnace, Declarer.blackstone_smoker);
            Declarer.BASALT_SMOKER = createSmoker(Declarer.basalt_furnace, Declarer.basalt_smoker);
            Declarer.DEEPSLATE_SMOKER = createSmoker(Declarer.deepslate_furnace, Declarer.deepslate_smoker);
            Declarer.DIORITE_SMOKER = createSmoker(Declarer.diorite_furnace, Declarer.diorite_smoker);
            Declarer.ENDSTONE_SMOKER = createSmoker(Declarer.endstone_furnace, Declarer.endstone_smoker);
            Declarer.GRANITE_SMOKER = createSmoker(Declarer.granite_furnace, Declarer.granite_smoker);
            Declarer.SANDSTONE_SMOKER = createSmoker(Declarer.sandstone_furnace, Declarer.sandstone_smoker);
            Declarer.RED_SANDSTONE_SMOKER = createSmoker(Declarer.red_sandstone_furnace, Declarer.red_sandstone_smoker);
            Declarer.NETHERRACK_SMOKER = createShapedRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Declarer.netherrack_furnace), new Identifier("minecraft", "logs")),//items
                    Lists.newArrayList(false, true),//type
                    Lists.newArrayList(" 1 ", "101", " 1 "),//pattern
                    Registry.ITEM.getId(Declarer.netherrack_smoker),
                    1
            );
        }
        if (Ref.chainArmor) {
            Declarer.CHAINBOOT = createShapedRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Items.IRON_NUGGET), Registry.ITEM.getId(Items.IRON_INGOT)),//items
                    Lists.newArrayList(false, false),//type
                    Lists.newArrayList("0 0", "1 1"),//pattern
                    Registry.ITEM.getId(Items.CHAINMAIL_BOOTS),
                    1
            );
            Declarer.CHAINCHEST = createShapedRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Items.IRON_NUGGET), Registry.ITEM.getId(Items.IRON_INGOT)),//items
                    Lists.newArrayList(false, false),//type
                    Lists.newArrayList("0 0", "111", "000"),//pattern
                    Registry.ITEM.getId(Items.CHAINMAIL_CHESTPLATE),
                    1
            );
            Declarer.CHAINPANT = createShapedRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Items.IRON_NUGGET), Registry.ITEM.getId(Items.IRON_INGOT)),//items
                    Lists.newArrayList(false, false),//type
                    Lists.newArrayList("000", "1 1", "0 0"),//pattern
                    Registry.ITEM.getId(Items.CHAINMAIL_LEGGINGS),
                    1
            );
            Declarer.CHAINHELM = createShapedRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Items.IRON_NUGGET), Registry.ITEM.getId(Items.IRON_INGOT)),//items
                    Lists.newArrayList(false, false),//type
                    Lists.newArrayList("010", "1 1"),//pattern
                    Registry.ITEM.getId(Items.CHAINMAIL_HELMET),
                    1
            );
        }
        if (Ref.woolArmor) {
            tempID = new Identifier("minecraft", "wool");
            Declarer.WOOLBOOT = createShapedRecipeJson(
                    Lists.newArrayList(tempID),//items
                    Lists.newArrayList(true),//type
                    Lists.newArrayList("0 0", "0 0"),//pattern
                    Registry.ITEM.getId(Declarer.wool_boots),
                    1
            );
            Declarer.WOOLCHEST = createShapedRecipeJson(
                    Lists.newArrayList(tempID),//items
                    Lists.newArrayList(true),//type
                    Lists.newArrayList("0 0", "000", "000"),//pattern
                    Registry.ITEM.getId(Declarer.wool_chestplate),
                    1
            );
            Declarer.WOOLPANT = createShapedRecipeJson(
                    Lists.newArrayList(tempID),//items
                    Lists.newArrayList(true),//type
                    Lists.newArrayList("000", "0 0", "0 0"),//pattern
                    Registry.ITEM.getId(Declarer.wool_leggings),
                    1
            );
            Declarer.WOOLHELM = createShapedRecipeJson(
                    Lists.newArrayList(tempID),//items
                    Lists.newArrayList(true),//type
                    Lists.newArrayList("000", "0 0"),//pattern
                    Registry.ITEM.getId(Declarer.wool_helmet),
                    1
            );
        }
        if (Ref.copperArmor) {
            tempID = Registry.ITEM.getId(Items.COPPER_INGOT);
            Declarer.COPPERBOOT = createShapedRecipeJson(
                    Lists.newArrayList(tempID),//items
                    Lists.newArrayList(false),//type
                    Lists.newArrayList("0 0", "0 0"),//pattern
                    Registry.ITEM.getId(Declarer.copper_boots),
                    1
            );
            Declarer.COPPERCHEST = createShapedRecipeJson(
                    Lists.newArrayList(tempID),//items
                    Lists.newArrayList(false),//type
                    Lists.newArrayList("0 0", "000", "000"),//pattern
                    Registry.ITEM.getId(Declarer.copper_chestplate),
                    1
            );
            Declarer.COPPERPANT = createShapedRecipeJson(
                    Lists.newArrayList(tempID),//items
                    Lists.newArrayList(false),//type
                    Lists.newArrayList("000", "0 0", "0 0"),//pattern
                    Registry.ITEM.getId(Declarer.copper_leggings),
                    1
            );
            Declarer.COPPERHELM = createShapedRecipeJson(
                    Lists.newArrayList(tempID),//items
                    Lists.newArrayList(false),//type
                    Lists.newArrayList("000", "0 0"),//pattern
                    Registry.ITEM.getId(Declarer.copper_helmet),
                    1
            );
        }
        if (Ref.allTools) {
            if (Ref.graniteTools) {
                tempID = new Identifier(Ref.MODID, "granite");
                Declarer.GRANITE_AXE = createTool(tempID, ToolTypes.Axe, Declarer.granite_axe);
                Declarer.GRANITE_PICKAXE = createTool(tempID, ToolTypes.Pickaxe, Declarer.granite_pick);
                Declarer.GRANITE_SWORD = createTool(tempID, ToolTypes.Sword, Declarer.granite_sword);
                Declarer.GRANITE_SHOVEL = createTool(tempID, ToolTypes.Shovel, Declarer.granite_shovel);
                Declarer.GRANITE_HOE = createTool(tempID, ToolTypes.Hoe, Declarer.granite_hoe);
            }
            if (Ref.dioriteTools) {
                tempID = new Identifier(Ref.MODID, "diorite");
                Declarer.DIORITE_AXE = createTool(tempID, ToolTypes.Axe, Declarer.diorite_axe);
                Declarer.DIORITE_PICKAXE = createTool(tempID, ToolTypes.Pickaxe, Declarer.diorite_pick);
                Declarer.DIORITE_SWORD = createTool(tempID, ToolTypes.Sword, Declarer.diorite_sword);
                Declarer.DIORITE_SHOVEL = createTool(tempID, ToolTypes.Shovel, Declarer.diorite_shovel);
                Declarer.DIORITE_HOE = createTool(tempID, ToolTypes.Hoe, Declarer.diorite_hoe);
            }
            if (Ref.andesiteTools) {
                tempID = new Identifier(Ref.MODID, "andesite");
                Declarer.ANDESITE_AXE = createTool(tempID, ToolTypes.Axe, Declarer.andesite_axe);
                Declarer.ANDESITE_PICKAXE = createTool(tempID, ToolTypes.Pickaxe, Declarer.andesite_pick);
                Declarer.ANDESITE_SWORD = createTool(tempID, ToolTypes.Sword, Declarer.andesite_sword);
                Declarer.ANDESITE_SHOVEL = createTool(tempID, ToolTypes.Shovel, Declarer.andesite_shovel);
                Declarer.ANDESITE_HOE = createTool(tempID, ToolTypes.Hoe, Declarer.andesite_hoe);
            }
            if (Ref.quartzTools) {
                Declarer.QUARTZ_AXE = createTool(Items.QUARTZ, ToolTypes.Axe, Declarer.quartz_axe);
                Declarer.QUARTZ_PICKAXE = createTool(Items.QUARTZ, ToolTypes.Pickaxe, Declarer.quartz_pick);
                Declarer.QUARTZ_SWORD = createTool(Items.QUARTZ, ToolTypes.Sword, Declarer.quartz_sword);
                Declarer.QUARTZ_SHOVEL = createTool(Items.QUARTZ, ToolTypes.Shovel, Declarer.quartz_shovel);
                Declarer.QUARTZ_HOE = createTool(Items.QUARTZ, ToolTypes.Hoe, Declarer.quartz_hoe);
            }
            if (Ref.netherrackTools) {
                Declarer.NETHERRACK_AXE = createTool(Items.NETHERRACK, ToolTypes.Axe, Declarer.netherrack_axe);
                Declarer.NETHERRACK_PICKAXE = createTool(Items.NETHERRACK, ToolTypes.Pickaxe, Declarer.netherrack_pick);
                Declarer.NETHERRACK_SWORD = createTool(Items.NETHERRACK, ToolTypes.Sword, Declarer.netherrack_sword);
                Declarer.NETHERRACK_SHOVEL = createTool(Items.NETHERRACK, ToolTypes.Shovel, Declarer.netherrack_shovel);
                Declarer.NETHERRACK_HOE = createTool(Items.NETHERRACK, ToolTypes.Hoe, Declarer.netherrack_hoe);
            }
            if (Ref.netherbrickTools) {
                Declarer.NETHERBRICK_AXE = createTool(Items.NETHER_BRICK, ToolTypes.Axe, Declarer.netherbrick_axe);
                Declarer.NETHERBRICK_PICKAXE = createTool(Items.NETHER_BRICK, ToolTypes.Pickaxe, Declarer.netherbrick_pick);
                Declarer.NETHERBRICK_SWORD = createTool(Items.NETHER_BRICK, ToolTypes.Sword, Declarer.netherbrick_sword);
                Declarer.NETHERBRICK_SHOVEL = createTool(Items.NETHER_BRICK, ToolTypes.Shovel, Declarer.netherbrick_shovel);
                Declarer.NETHERBRICK_HOE = createTool(Items.NETHER_BRICK, ToolTypes.Hoe, Declarer.netherbrick_hoe);
            }
            if (Ref.redNetherbrickTools) {
                Declarer.RED_NETHERBRICK_AXE = createTool(Items.RED_NETHER_BRICKS, ToolTypes.Axe, Declarer.rednetherbrick_axe);
                Declarer.RED_NETHERBRICK_PICKAXE = createTool(Items.RED_NETHER_BRICKS, ToolTypes.Pickaxe, Declarer.rednetherbrick_pick);
                Declarer.RED_NETHERBRICK_SWORD = createTool(Items.RED_NETHER_BRICKS, ToolTypes.Sword, Declarer.rednetherbrick_sword);
                Declarer.RED_NETHERBRICK_SHOVEL = createTool(Items.RED_NETHER_BRICKS, ToolTypes.Shovel, Declarer.rednetherbrick_shovel);
                Declarer.RED_NETHERBRICK_HOE = createTool(Items.RED_NETHER_BRICKS, ToolTypes.Hoe, Declarer.rednetherbrick_hoe);
            }
            if (Ref.sandstoneTools) {
                tempID = new Identifier(Ref.MODID, "sandstone");
                Declarer.SANDSTONE_AXE = createTool(tempID, ToolTypes.Axe, Declarer.sandstone_axe);
                Declarer.SANDSTONE_PICKAXE = createTool(tempID, ToolTypes.Pickaxe, Declarer.sandstone_pick);
                Declarer.SANDSTONE_SWORD = createTool(tempID, ToolTypes.Sword, Declarer.sandstone_sword);
                Declarer.SANDSTONE_SHOVEL = createTool(tempID, ToolTypes.Shovel, Declarer.sandstone_shovel);
                Declarer.SANDSTONE_HOE = createTool(tempID, ToolTypes.Hoe, Declarer.sandstone_hoe);
            }
            if (Ref.redSandstoneTools) {
                tempID = new Identifier(Ref.MODID, "redsandstone");
                Declarer.RED_SANDSTONE_AXE = createTool(tempID, ToolTypes.Axe, Declarer.redsandstone_axe);
                Declarer.RED_SANDSTONE_PICKAXE = createTool(tempID, ToolTypes.Pickaxe, Declarer.redsandstone_pick);
                Declarer.RED_SANDSTONE_SWORD = createTool(tempID, ToolTypes.Sword, Declarer.redsandstone_sword);
                Declarer.RED_SANDSTONE_SHOVEL = createTool(tempID, ToolTypes.Shovel, Declarer.redsandstone_shovel);
                Declarer.RED_SANDSTONE_HOE = createTool(tempID, ToolTypes.Hoe, Declarer.redsandstone_hoe);
            }
            if (Ref.lapisTools) {
                Declarer.LAPIS_AXE = createTool(Items.LAPIS_BLOCK, ToolTypes.Axe, Declarer.lapis_axe);
                Declarer.LAPIS_PICKAXE = createTool(Items.LAPIS_BLOCK, ToolTypes.Pickaxe, Declarer.lapis_pick);
                Declarer.LAPIS_SWORD = createTool(Items.LAPIS_BLOCK, ToolTypes.Sword, Declarer.lapis_sword);
                Declarer.LAPIS_SHOVEL = createTool(Items.LAPIS_BLOCK, ToolTypes.Shovel, Declarer.lapis_shovel);
                Declarer.LAPIS_HOE = createTool(Items.LAPIS_BLOCK, ToolTypes.Hoe, Declarer.lapis_hoe);
            }
            if (Ref.emeraldTools) {
                Declarer.EMERALD_AXE = createTool(Items.EMERALD, ToolTypes.Axe, Declarer.emerald_axe);
                Declarer.EMERALD_PICKAXE = createTool(Items.EMERALD, ToolTypes.Pickaxe, Declarer.emerald_pick);
                Declarer.EMERALD_SWORD = createTool(Items.EMERALD, ToolTypes.Sword, Declarer.emerald_sword);
                Declarer.EMERALD_SHOVEL = createTool(Items.EMERALD, ToolTypes.Shovel, Declarer.emerald_shovel);
                Declarer.EMERALD_HOE = createTool(Items.EMERALD, ToolTypes.Hoe, Declarer.emerald_hoe);
            }
            if (Ref.flintTools) {
                Declarer.FLINT_AXE = createTool(Items.FLINT, ToolTypes.Axe, Declarer.flint_axe);
                Declarer.FLINT_PICKAXE = createTool(Items.FLINT, ToolTypes.Pickaxe, Declarer.flint_pick);
                Declarer.FLINT_SWORD = createTool(Items.FLINT, ToolTypes.Sword, Declarer.flint_sword);
                Declarer.FLINT_SHOVEL = createTool(Items.FLINT, ToolTypes.Shovel, Declarer.flint_shovel);
                Declarer.FLINT_HOE = createTool(Items.FLINT, ToolTypes.Hoe, Declarer.flint_hoe);
            }
            if (Ref.redstoneTools) {
                Declarer.REDSTONE_AXE = createTool(Items.REDSTONE_BLOCK, ToolTypes.Axe, Declarer.redstone_axe);
                Declarer.REDSTONE_PICKAXE = createTool(Items.REDSTONE_BLOCK, ToolTypes.Pickaxe, Declarer.redstone_pick);
                Declarer.REDSTONE_SWORD = createTool(Items.REDSTONE_BLOCK, ToolTypes.Sword, Declarer.redstone_sword);
                Declarer.REDSTONE_SHOVEL = createTool(Items.REDSTONE_BLOCK, ToolTypes.Shovel, Declarer.redstone_shovel);
                Declarer.REDSTONE_HOE = createTool(Items.REDSTONE_BLOCK, ToolTypes.Hoe, Declarer.redstone_hoe);
            }
            if (Ref.blackstoneTools) {
                tempID = new Identifier(Ref.MODID, "blackstone");
                Declarer.BLACKSTONE_AXE = createTool(tempID, ToolTypes.Axe, Declarer.blackstone_axe);
                Declarer.BLACKSTONE_PICKAXE = createTool(tempID, ToolTypes.Pickaxe, Declarer.blackstone_pick);
                Declarer.BLACKSTONE_SWORD = createTool(tempID, ToolTypes.Sword, Declarer.blackstone_sword);
                Declarer.BLACKSTONE_SHOVEL = createTool(tempID, ToolTypes.Shovel, Declarer.blackstone_shovel);
                Declarer.BLACKSTONE_HOE = createTool(tempID, ToolTypes.Hoe, Declarer.blackstone_hoe);
            }
            if (Ref.basaltTools) {
                tempID = new Identifier(Ref.MODID, "basalt");
                Declarer.BASALT_AXE = createTool(tempID, ToolTypes.Axe, Declarer.basalt_axe);
                Declarer.BASALT_PICKAXE = createTool(tempID, ToolTypes.Pickaxe, Declarer.basalt_pick);
                Declarer.BASALT_SWORD = createTool(tempID, ToolTypes.Sword, Declarer.basalt_sword);
                Declarer.BASALT_SHOVEL = createTool(tempID, ToolTypes.Shovel, Declarer.basalt_shovel);
                Declarer.BASALT_HOE = createTool(tempID, ToolTypes.Hoe, Declarer.basalt_hoe);
            }
            if (Ref.endstoneTools) {
                tempID = new Identifier(Ref.MODID, "endstone");
                Declarer.ENDSTONE_AXE = createTool(tempID, ToolTypes.Axe, Declarer.endstone_axe);
                Declarer.ENDSTONE_PICKAXE = createTool(tempID, ToolTypes.Pickaxe, Declarer.endstone_pick);
                Declarer.ENDSTONE_SWORD = createTool(tempID, ToolTypes.Sword, Declarer.endstone_sword);
                Declarer.ENDSTONE_SHOVEL = createTool(tempID, ToolTypes.Shovel, Declarer.endstone_shovel);
                Declarer.ENDSTONE_HOE = createTool(tempID, ToolTypes.Hoe, Declarer.endstone_hoe);
            }
            if (Ref.warpedTools) {
                Declarer.WARPED_AXE = createTool(Items.WARPED_PLANKS, ToolTypes.Axe, Declarer.warped_axe);
                Declarer.WARPED_PICKAXE = createTool(Items.WARPED_PLANKS, ToolTypes.Pickaxe, Declarer.warped_pick);
                Declarer.WARPED_SWORD = createTool(Items.WARPED_PLANKS, ToolTypes.Sword, Declarer.warped_sword);
                Declarer.WARPED_SHOVEL = createTool(Items.WARPED_PLANKS, ToolTypes.Shovel, Declarer.warped_shovel);
                Declarer.WARPED_HOE = createTool(Items.WARPED_PLANKS, ToolTypes.Hoe, Declarer.warped_hoe);
            }
            if (Ref.crimsonTools) {
                Declarer.CRIMSON_AXE = createTool(Items.CRIMSON_PLANKS, ToolTypes.Axe, Declarer.crimson_axe);
                Declarer.CRIMSON_PICKAXE = createTool(Items.CRIMSON_PLANKS, ToolTypes.Pickaxe, Declarer.crimson_pick);
                Declarer.CRIMSON_SWORD = createTool(Items.CRIMSON_PLANKS, ToolTypes.Sword, Declarer.crimson_sword);
                Declarer.CRIMSON_SHOVEL = createTool(Items.CRIMSON_PLANKS, ToolTypes.Shovel, Declarer.crimson_shovel);
                Declarer.CRIMSON_HOE = createTool(Items.CRIMSON_PLANKS, ToolTypes.Hoe, Declarer.crimson_hoe);
            }
            if (Ref.amethystTools) {
                Declarer.AMETHYST_AXE = createTool(Items.AMETHYST_BLOCK, ToolTypes.Axe, Declarer.amethyst_axe);
                Declarer.AMETHYST_PICKAXE = createTool(Items.AMETHYST_BLOCK, ToolTypes.Pickaxe, Declarer.amethyst_pick);
                Declarer.AMETHYST_SWORD = createTool(Items.AMETHYST_BLOCK, ToolTypes.Sword, Declarer.amethyst_sword);
                Declarer.AMETHYST_SHOVEL = createTool(Items.AMETHYST_BLOCK, ToolTypes.Shovel, Declarer.amethyst_shovel);
                Declarer.AMETHYST_HOE = createTool(Items.AMETHYST_BLOCK, ToolTypes.Hoe, Declarer.amethyst_hoe);
            }
            if (Ref.copperTools) {
                Declarer.COPPER_AXE = createTool(Items.COPPER_INGOT, ToolTypes.Axe, Declarer.copper_axe);
                Declarer.COPPER_PICKAXE = createTool(Items.COPPER_INGOT, ToolTypes.Pickaxe, Declarer.copper_pick);
                Declarer.COPPER_SWORD = createTool(Items.COPPER_INGOT, ToolTypes.Sword, Declarer.copper_sword);
                Declarer.COPPER_SHOVEL = createTool(Items.COPPER_INGOT, ToolTypes.Shovel, Declarer.copper_shovel);
                Declarer.COPPER_HOE = createTool(Items.COPPER_INGOT, ToolTypes.Hoe, Declarer.copper_hoe);
            }
            if (Ref.deepslateTools) {
                tempID = new Identifier(Ref.MODID, "deepslate");
                Declarer.DEEPSLATE_AXE = createTool(tempID, ToolTypes.Axe, Declarer.deepslate_axe);
                Declarer.DEEPSLATE_PICKAXE = createTool(tempID, ToolTypes.Pickaxe, Declarer.deepslate_pick);
                Declarer.DEEPSLATE_SWORD = createTool(tempID, ToolTypes.Sword, Declarer.deepslate_sword);
                Declarer.DEEPSLATE_SHOVEL = createTool(tempID, ToolTypes.Shovel, Declarer.deepslate_shovel);
                Declarer.DEEPSLATE_HOE = createTool(tempID, ToolTypes.Hoe, Declarer.deepslate_hoe);
            }
        }
        if (Ref.allCompressedBlocks) {
            if (Ref.cobble) {
                Declarer.COBBLESTONE_1X = createCompressedBlock(Items.COBBLESTONE, Declarer.monuple_compressed_cobblestone);
                Declarer.COBBLESTONE_1XU = createUncompressedBlock(Declarer.monuple_compressed_cobblestone, Items.COBBLESTONE);
                Declarer.COBBLESTONE_2X = createCompressedBlock(Declarer.monuple_compressed_cobblestone, Declarer.couple_compressed_cobblestone);
                Declarer.COBBLESTONE_2XU = createUncompressedBlock(Declarer.couple_compressed_cobblestone, Declarer.monuple_compressed_cobblestone);
                Declarer.COBBLESTONE_3X = createCompressedBlock(Declarer.couple_compressed_cobblestone, Declarer.triple_compressed_cobblestone);
                Declarer.COBBLESTONE_3XU = createUncompressedBlock(Declarer.triple_compressed_cobblestone, Declarer.couple_compressed_cobblestone);
                Declarer.COBBLESTONE_4X = createCompressedBlock(Declarer.triple_compressed_cobblestone, Declarer.quadruple_compressed_cobblestone);
                Declarer.COBBLESTONE_4XU = createUncompressedBlock(Declarer.quadruple_compressed_cobblestone, Declarer.triple_compressed_cobblestone);
                Declarer.COBBLESTONE_5X = createCompressedBlock(Declarer.quadruple_compressed_cobblestone, Declarer.quintuple_compressed_cobblestone);
                Declarer.COBBLESTONE_5XU = createUncompressedBlock(Declarer.quintuple_compressed_cobblestone, Declarer.quadruple_compressed_cobblestone);
                Declarer.COBBLESTONE_6X = createCompressedBlock(Declarer.quintuple_compressed_cobblestone, Declarer.sextuple_compressed_cobblestone);
                Declarer.COBBLESTONE_6XU = createUncompressedBlock(Declarer.sextuple_compressed_cobblestone, Declarer.quintuple_compressed_cobblestone);
                Declarer.COBBLESTONE_7X = createCompressedBlock(Declarer.sextuple_compressed_cobblestone, Declarer.septuple_compressed_cobblestone);
                Declarer.COBBLESTONE_7XU = createUncompressedBlock(Declarer.septuple_compressed_cobblestone, Declarer.sextuple_compressed_cobblestone);
                Declarer.COBBLESTONE_8X = createCompressedBlock(Declarer.septuple_compressed_cobblestone, Declarer.octuple_compressed_cobblestone);
                Declarer.COBBLESTONE_8XU = createUncompressedBlock(Declarer.octuple_compressed_cobblestone, Declarer.septuple_compressed_cobblestone);
                Declarer.COBBLESTONE_9X = createCompressedBlock(Declarer.octuple_compressed_cobblestone, Declarer.nonuple_compressed_cobblestone);
                Declarer.COBBLESTONE_9XU = createUncompressedBlock(Declarer.nonuple_compressed_cobblestone, Declarer.octuple_compressed_cobblestone);
            }
            if (Ref.dirt) {
                Declarer.DIRT_1X = createCompressedBlock(Items.DIRT, Declarer.monuple_compressed_dirt);
                Declarer.DIRT_1XU = createUncompressedBlock(Declarer.monuple_compressed_dirt, Items.DIRT);
                Declarer.DIRT_2X = createCompressedBlock(Declarer.monuple_compressed_dirt, Declarer.couple_compressed_dirt);
                Declarer.DIRT_2XU = createUncompressedBlock(Declarer.couple_compressed_dirt, Declarer.monuple_compressed_dirt);
                Declarer.DIRT_3X = createCompressedBlock(Declarer.couple_compressed_dirt, Declarer.triple_compressed_dirt);
                Declarer.DIRT_3XU = createUncompressedBlock(Declarer.triple_compressed_dirt, Declarer.couple_compressed_dirt);
                Declarer.DIRT_4X = createCompressedBlock(Declarer.triple_compressed_dirt, Declarer.quadruple_compressed_dirt);
                Declarer.DIRT_4XU = createUncompressedBlock(Declarer.quadruple_compressed_dirt, Declarer.triple_compressed_dirt);
                Declarer.DIRT_5X = createCompressedBlock(Declarer.quadruple_compressed_dirt, Declarer.quintuple_compressed_dirt);
                Declarer.DIRT_5XU = createUncompressedBlock(Declarer.quintuple_compressed_dirt, Declarer.quadruple_compressed_dirt);
                Declarer.DIRT_6X = createCompressedBlock(Declarer.quintuple_compressed_dirt, Declarer.sextuple_compressed_dirt);
                Declarer.DIRT_6XU = createUncompressedBlock(Declarer.sextuple_compressed_dirt, Declarer.quintuple_compressed_dirt);
                Declarer.DIRT_7X = createCompressedBlock(Declarer.sextuple_compressed_dirt, Declarer.septuple_compressed_dirt);
                Declarer.DIRT_7XU = createUncompressedBlock(Declarer.septuple_compressed_dirt, Declarer.sextuple_compressed_dirt);
                Declarer.DIRT_8X = createCompressedBlock(Declarer.septuple_compressed_dirt, Declarer.octuple_compressed_dirt);
                Declarer.DIRT_8XU = createUncompressedBlock(Declarer.octuple_compressed_dirt, Declarer.septuple_compressed_dirt);
                Declarer.DIRT_9X = createCompressedBlock(Declarer.octuple_compressed_dirt, Declarer.nonuple_compressed_dirt);
                Declarer.DIRT_9XU = createUncompressedBlock(Declarer.nonuple_compressed_dirt, Declarer.octuple_compressed_dirt);
            }
            if (Ref.diorite) {
                Declarer.DIORITE_1X = createCompressedBlock(Items.DIORITE, Declarer.monuple_compressed_diorite);
                Declarer.DIORITE_1XU = createUncompressedBlock(Declarer.monuple_compressed_diorite, Items.DIORITE);
                Declarer.DIORITE_2X = createCompressedBlock(Declarer.monuple_compressed_diorite, Declarer.couple_compressed_diorite);
                Declarer.DIORITE_2XU = createUncompressedBlock(Declarer.couple_compressed_diorite, Declarer.monuple_compressed_diorite);
                Declarer.DIORITE_3X = createCompressedBlock(Declarer.couple_compressed_diorite, Declarer.triple_compressed_diorite);
                Declarer.DIORITE_3XU = createUncompressedBlock(Declarer.triple_compressed_diorite, Declarer.couple_compressed_diorite);
                Declarer.DIORITE_4X = createCompressedBlock(Declarer.triple_compressed_diorite, Declarer.quadruple_compressed_diorite);
                Declarer.DIORITE_4XU = createUncompressedBlock(Declarer.quadruple_compressed_diorite, Declarer.triple_compressed_diorite);
                Declarer.DIORITE_5X = createCompressedBlock(Declarer.quadruple_compressed_diorite, Declarer.quintuple_compressed_diorite);
                Declarer.DIORITE_5XU = createUncompressedBlock(Declarer.quintuple_compressed_diorite, Declarer.quadruple_compressed_diorite);
                Declarer.DIORITE_6X = createCompressedBlock(Declarer.quintuple_compressed_diorite, Declarer.sextuple_compressed_diorite);
                Declarer.DIORITE_6XU = createUncompressedBlock(Declarer.sextuple_compressed_diorite, Declarer.quintuple_compressed_diorite);
                Declarer.DIORITE_7X = createCompressedBlock(Declarer.sextuple_compressed_diorite, Declarer.septuple_compressed_diorite);
                Declarer.DIORITE_7XU = createUncompressedBlock(Declarer.septuple_compressed_diorite, Declarer.sextuple_compressed_diorite);
                Declarer.DIORITE_8X = createCompressedBlock(Declarer.septuple_compressed_diorite, Declarer.octuple_compressed_diorite);
                Declarer.DIORITE_8XU = createUncompressedBlock(Declarer.octuple_compressed_diorite, Declarer.septuple_compressed_diorite);
                Declarer.DIORITE_9X = createCompressedBlock(Declarer.octuple_compressed_diorite, Declarer.nonuple_compressed_diorite);
                Declarer.DIORITE_9XU = createUncompressedBlock(Declarer.nonuple_compressed_diorite, Declarer.octuple_compressed_diorite);
            }
            if (Ref.granite) {
                Declarer.GRANITE_1X = createCompressedBlock(Items.GRANITE, Declarer.monuple_compressed_granite);
                Declarer.GRANITE_1XU = createUncompressedBlock(Declarer.monuple_compressed_granite, Items.GRANITE);
                Declarer.GRANITE_2X = createCompressedBlock(Declarer.monuple_compressed_granite, Declarer.couple_compressed_granite);
                Declarer.GRANITE_2XU = createUncompressedBlock(Declarer.couple_compressed_granite, Declarer.monuple_compressed_granite);
                Declarer.GRANITE_3X = createCompressedBlock(Declarer.couple_compressed_granite, Declarer.triple_compressed_granite);
                Declarer.GRANITE_3XU = createUncompressedBlock(Declarer.triple_compressed_granite, Declarer.couple_compressed_granite);
                Declarer.GRANITE_4X = createCompressedBlock(Declarer.triple_compressed_granite, Declarer.quadruple_compressed_granite);
                Declarer.GRANITE_4XU = createUncompressedBlock(Declarer.quadruple_compressed_granite, Declarer.triple_compressed_granite);
                Declarer.GRANITE_5X = createCompressedBlock(Declarer.quadruple_compressed_granite, Declarer.quintuple_compressed_granite);
                Declarer.GRANITE_5XU = createUncompressedBlock(Declarer.quintuple_compressed_granite, Declarer.quadruple_compressed_granite);
                Declarer.GRANITE_6X = createCompressedBlock(Declarer.quintuple_compressed_granite, Declarer.sextuple_compressed_granite);
                Declarer.GRANITE_6XU = createUncompressedBlock(Declarer.sextuple_compressed_granite, Declarer.quintuple_compressed_granite);
                Declarer.GRANITE_7X = createCompressedBlock(Declarer.sextuple_compressed_granite, Declarer.septuple_compressed_granite);
                Declarer.GRANITE_7XU = createUncompressedBlock(Declarer.septuple_compressed_granite, Declarer.sextuple_compressed_granite);
                Declarer.GRANITE_8X = createCompressedBlock(Declarer.septuple_compressed_granite, Declarer.octuple_compressed_granite);
                Declarer.GRANITE_8XU = createUncompressedBlock(Declarer.octuple_compressed_granite, Declarer.septuple_compressed_granite);
                Declarer.GRANITE_9X = createCompressedBlock(Declarer.octuple_compressed_granite, Declarer.nonuple_compressed_granite);
                Declarer.GRANITE_9XU = createUncompressedBlock(Declarer.nonuple_compressed_granite, Declarer.octuple_compressed_granite);
            }
            if (Ref.andesite) {
                Declarer.ANDESITE_1X = createCompressedBlock(Items.ANDESITE, Declarer.monuple_compressed_andesite);
                Declarer.ANDESITE_1XU = createUncompressedBlock(Declarer.monuple_compressed_andesite, Items.ANDESITE);
                Declarer.ANDESITE_2X = createCompressedBlock(Declarer.monuple_compressed_andesite, Declarer.couple_compressed_andesite);
                Declarer.ANDESITE_2XU = createUncompressedBlock(Declarer.couple_compressed_andesite, Declarer.monuple_compressed_andesite);
                Declarer.ANDESITE_3X = createCompressedBlock(Declarer.couple_compressed_andesite, Declarer.triple_compressed_andesite);
                Declarer.ANDESITE_3XU = createUncompressedBlock(Declarer.triple_compressed_andesite, Declarer.couple_compressed_andesite);
                Declarer.ANDESITE_4X = createCompressedBlock(Declarer.triple_compressed_andesite, Declarer.quadruple_compressed_andesite);
                Declarer.ANDESITE_4XU = createUncompressedBlock(Declarer.quadruple_compressed_andesite, Declarer.triple_compressed_andesite);
                Declarer.ANDESITE_5X = createCompressedBlock(Declarer.quadruple_compressed_andesite, Declarer.quintuple_compressed_andesite);
                Declarer.ANDESITE_5XU = createUncompressedBlock(Declarer.quintuple_compressed_andesite, Declarer.quadruple_compressed_andesite);
                Declarer.ANDESITE_6X = createCompressedBlock(Declarer.quintuple_compressed_andesite, Declarer.sextuple_compressed_andesite);
                Declarer.ANDESITE_6XU = createUncompressedBlock(Declarer.sextuple_compressed_andesite, Declarer.quintuple_compressed_andesite);
                Declarer.ANDESITE_7X = createCompressedBlock(Declarer.sextuple_compressed_andesite, Declarer.septuple_compressed_andesite);
                Declarer.ANDESITE_7XU = createUncompressedBlock(Declarer.septuple_compressed_andesite, Declarer.sextuple_compressed_andesite);
                Declarer.ANDESITE_8X = createCompressedBlock(Declarer.septuple_compressed_andesite, Declarer.octuple_compressed_andesite);
                Declarer.ANDESITE_8XU = createUncompressedBlock(Declarer.octuple_compressed_andesite, Declarer.septuple_compressed_andesite);
                Declarer.ANDESITE_9X = createCompressedBlock(Declarer.octuple_compressed_andesite, Declarer.nonuple_compressed_andesite);
                Declarer.ANDESITE_9XU = createUncompressedBlock(Declarer.nonuple_compressed_andesite, Declarer.octuple_compressed_andesite);
            }
            if (Ref.netherrack) {
                Declarer.NETHERRACK_1X = createCompressedBlock(Items.NETHERRACK, Declarer.monuple_compressed_netherrack);
                Declarer.NETHERRACK_1XU = createUncompressedBlock(Declarer.monuple_compressed_netherrack, Items.NETHERRACK);
                Declarer.NETHERRACK_2X = createCompressedBlock(Declarer.monuple_compressed_netherrack, Declarer.couple_compressed_netherrack);
                Declarer.NETHERRACK_2XU = createUncompressedBlock(Declarer.couple_compressed_netherrack, Declarer.monuple_compressed_netherrack);
                Declarer.NETHERRACK_3X = createCompressedBlock(Declarer.couple_compressed_netherrack, Declarer.triple_compressed_netherrack);
                Declarer.NETHERRACK_3XU = createUncompressedBlock(Declarer.triple_compressed_netherrack, Declarer.couple_compressed_netherrack);
                Declarer.NETHERRACK_4X = createCompressedBlock(Declarer.triple_compressed_netherrack, Declarer.quadruple_compressed_netherrack);
                Declarer.NETHERRACK_4XU = createUncompressedBlock(Declarer.quadruple_compressed_netherrack, Declarer.triple_compressed_netherrack);
                Declarer.NETHERRACK_5X = createCompressedBlock(Declarer.quadruple_compressed_netherrack, Declarer.quintuple_compressed_netherrack);
                Declarer.NETHERRACK_5XU = createUncompressedBlock(Declarer.quintuple_compressed_netherrack, Declarer.quadruple_compressed_netherrack);
                Declarer.NETHERRACK_6X = createCompressedBlock(Declarer.quintuple_compressed_netherrack, Declarer.sextuple_compressed_netherrack);
                Declarer.NETHERRACK_6XU = createUncompressedBlock(Declarer.sextuple_compressed_netherrack, Declarer.quintuple_compressed_netherrack);
                Declarer.NETHERRACK_7X = createCompressedBlock(Declarer.sextuple_compressed_netherrack, Declarer.septuple_compressed_netherrack);
                Declarer.NETHERRACK_7XU = createUncompressedBlock(Declarer.septuple_compressed_netherrack, Declarer.sextuple_compressed_netherrack);
                Declarer.NETHERRACK_8X = createCompressedBlock(Declarer.septuple_compressed_netherrack, Declarer.octuple_compressed_netherrack);
                Declarer.NETHERRACK_8XU = createUncompressedBlock(Declarer.octuple_compressed_netherrack, Declarer.septuple_compressed_netherrack);
                Declarer.NETHERRACK_9X = createCompressedBlock(Declarer.octuple_compressed_netherrack, Declarer.nonuple_compressed_netherrack);
                Declarer.NETHERRACK_9XU = createUncompressedBlock(Declarer.nonuple_compressed_netherrack, Declarer.octuple_compressed_netherrack);
            }
            if (Ref.sand) {
                Declarer.SAND_1X = createCompressedBlock(Items.SAND, Declarer.monuple_compressed_sand);
                Declarer.SAND_1XU = createUncompressedBlock(Declarer.monuple_compressed_sand, Items.SAND);
                Declarer.SAND_2X = createCompressedBlock(Declarer.monuple_compressed_sand, Declarer.couple_compressed_sand);
                Declarer.SAND_2XU = createUncompressedBlock(Declarer.couple_compressed_sand, Declarer.monuple_compressed_sand);
                Declarer.SAND_3X = createCompressedBlock(Declarer.couple_compressed_sand, Declarer.triple_compressed_sand);
                Declarer.SAND_3XU = createUncompressedBlock(Declarer.triple_compressed_sand, Declarer.couple_compressed_sand);
                Declarer.SAND_4X = createCompressedBlock(Declarer.triple_compressed_sand, Declarer.quadruple_compressed_sand);
                Declarer.SAND_4XU = createUncompressedBlock(Declarer.quadruple_compressed_sand, Declarer.triple_compressed_sand);
                Declarer.SAND_5X = createCompressedBlock(Declarer.quadruple_compressed_sand, Declarer.quintuple_compressed_sand);
                Declarer.SAND_5XU = createUncompressedBlock(Declarer.quintuple_compressed_sand, Declarer.quadruple_compressed_sand);
                Declarer.SAND_6X = createCompressedBlock(Declarer.quintuple_compressed_sand, Declarer.sextuple_compressed_sand);
                Declarer.SAND_6XU = createUncompressedBlock(Declarer.sextuple_compressed_sand, Declarer.quintuple_compressed_sand);
                Declarer.SAND_7X = createCompressedBlock(Declarer.sextuple_compressed_sand, Declarer.septuple_compressed_sand);
                Declarer.SAND_7XU = createUncompressedBlock(Declarer.septuple_compressed_sand, Declarer.sextuple_compressed_sand);
                Declarer.SAND_8X = createCompressedBlock(Declarer.septuple_compressed_sand, Declarer.octuple_compressed_sand);
                Declarer.SAND_8XU = createUncompressedBlock(Declarer.octuple_compressed_sand, Declarer.septuple_compressed_sand);
                Declarer.SAND_9X = createCompressedBlock(Declarer.octuple_compressed_sand, Declarer.nonuple_compressed_sand);
                Declarer.SAND_9XU = createUncompressedBlock(Declarer.nonuple_compressed_sand, Declarer.octuple_compressed_sand);
            }
            if (Ref.gravel) {
                Declarer.GRAVEL_1X = createCompressedBlock(Items.GRAVEL, Declarer.monuple_compressed_gravel);
                Declarer.GRAVEL_1XU = createUncompressedBlock(Declarer.monuple_compressed_gravel, Items.GRAVEL);
                Declarer.GRAVEL_2X = createCompressedBlock(Declarer.monuple_compressed_gravel, Declarer.couple_compressed_gravel);
                Declarer.GRAVEL_2XU = createUncompressedBlock(Declarer.couple_compressed_gravel, Declarer.monuple_compressed_gravel);
                Declarer.GRAVEL_3X = createCompressedBlock(Declarer.couple_compressed_gravel, Declarer.triple_compressed_gravel);
                Declarer.GRAVEL_3XU = createUncompressedBlock(Declarer.triple_compressed_gravel, Declarer.couple_compressed_gravel);
                Declarer.GRAVEL_4X = createCompressedBlock(Declarer.triple_compressed_gravel, Declarer.quadruple_compressed_gravel);
                Declarer.GRAVEL_4XU = createUncompressedBlock(Declarer.quadruple_compressed_gravel, Declarer.triple_compressed_gravel);
                Declarer.GRAVEL_5X = createCompressedBlock(Declarer.quadruple_compressed_gravel, Declarer.quintuple_compressed_gravel);
                Declarer.GRAVEL_5XU = createUncompressedBlock(Declarer.quintuple_compressed_gravel, Declarer.quadruple_compressed_gravel);
                Declarer.GRAVEL_6X = createCompressedBlock(Declarer.quintuple_compressed_gravel, Declarer.sextuple_compressed_gravel);
                Declarer.GRAVEL_6XU = createUncompressedBlock(Declarer.sextuple_compressed_gravel, Declarer.quintuple_compressed_gravel);
                Declarer.GRAVEL_7X = createCompressedBlock(Declarer.sextuple_compressed_gravel, Declarer.septuple_compressed_gravel);
                Declarer.GRAVEL_7XU = createUncompressedBlock(Declarer.septuple_compressed_gravel, Declarer.sextuple_compressed_gravel);
                Declarer.GRAVEL_8X = createCompressedBlock(Declarer.septuple_compressed_gravel, Declarer.octuple_compressed_gravel);
                Declarer.GRAVEL_8XU = createUncompressedBlock(Declarer.octuple_compressed_gravel, Declarer.septuple_compressed_gravel);
                Declarer.GRAVEL_9X = createCompressedBlock(Declarer.octuple_compressed_gravel, Declarer.nonuple_compressed_gravel);
                Declarer.GRAVEL_9XU = createUncompressedBlock(Declarer.nonuple_compressed_gravel, Declarer.octuple_compressed_gravel);
            }
            if (Ref.deepslate) {
                Declarer.COBBLED_DEEPSLATE_1X = createCompressedBlock(Items.COBBLED_DEEPSLATE, Declarer.monuple_compressed_cobbled_deepslate);
                Declarer.COBBLED_DEEPSLATE_1XU = createUncompressedBlock(Declarer.monuple_compressed_cobbled_deepslate, Items.COBBLED_DEEPSLATE);
                Declarer.COBBLED_DEEPSLATE_2X = createCompressedBlock(Declarer.monuple_compressed_cobbled_deepslate, Declarer.couple_compressed_cobbled_deepslate);
                Declarer.COBBLED_DEEPSLATE_2XU = createUncompressedBlock(Declarer.couple_compressed_cobbled_deepslate, Declarer.monuple_compressed_cobbled_deepslate);
                Declarer.COBBLED_DEEPSLATE_3X = createCompressedBlock(Declarer.couple_compressed_cobbled_deepslate, Declarer.triple_compressed_cobbled_deepslate);
                Declarer.COBBLED_DEEPSLATE_3XU = createUncompressedBlock(Declarer.triple_compressed_cobbled_deepslate, Declarer.couple_compressed_cobbled_deepslate);
                Declarer.COBBLED_DEEPSLATE_4X = createCompressedBlock(Declarer.triple_compressed_cobbled_deepslate, Declarer.quadruple_compressed_cobbled_deepslate);
                Declarer.COBBLED_DEEPSLATE_4XU = createUncompressedBlock(Declarer.quadruple_compressed_cobbled_deepslate, Declarer.triple_compressed_cobbled_deepslate);
                Declarer.COBBLED_DEEPSLATE_5X = createCompressedBlock(Declarer.quadruple_compressed_cobbled_deepslate, Declarer.quintuple_compressed_cobbled_deepslate);
                Declarer.COBBLED_DEEPSLATE_5XU = createUncompressedBlock(Declarer.quintuple_compressed_cobbled_deepslate, Declarer.quadruple_compressed_cobbled_deepslate);
                Declarer.COBBLED_DEEPSLATE_6X = createCompressedBlock(Declarer.quintuple_compressed_cobbled_deepslate, Declarer.sextuple_compressed_cobbled_deepslate);
                Declarer.COBBLED_DEEPSLATE_6XU = createUncompressedBlock(Declarer.sextuple_compressed_cobbled_deepslate, Declarer.quintuple_compressed_cobbled_deepslate);
                Declarer.COBBLED_DEEPSLATE_7X = createCompressedBlock(Declarer.sextuple_compressed_cobbled_deepslate, Declarer.septuple_compressed_cobbled_deepslate);
                Declarer.COBBLED_DEEPSLATE_7XU = createUncompressedBlock(Declarer.septuple_compressed_cobbled_deepslate, Declarer.sextuple_compressed_cobbled_deepslate);
                Declarer.COBBLED_DEEPSLATE_8X = createCompressedBlock(Declarer.septuple_compressed_cobbled_deepslate, Declarer.octuple_compressed_cobbled_deepslate);
                Declarer.COBBLED_DEEPSLATE_8XU = createUncompressedBlock(Declarer.octuple_compressed_cobbled_deepslate, Declarer.septuple_compressed_cobbled_deepslate);
                Declarer.COBBLED_DEEPSLATE_9X = createCompressedBlock(Declarer.octuple_compressed_cobbled_deepslate, Declarer.nonuple_compressed_cobbled_deepslate);
                Declarer.COBBLED_DEEPSLATE_9XU = createUncompressedBlock(Declarer.nonuple_compressed_cobbled_deepslate, Declarer.octuple_compressed_cobbled_deepslate);
            }
            if (Ref.tuff) {
                Declarer.TUFF_1X = createCompressedBlock(Items.TUFF, Declarer.monuple_compressed_tuff);
                Declarer.TUFF_1XU = createUncompressedBlock(Declarer.monuple_compressed_tuff, Items.TUFF);
                Declarer.TUFF_2X = createCompressedBlock(Declarer.monuple_compressed_tuff, Declarer.couple_compressed_tuff);
                Declarer.TUFF_2XU = createUncompressedBlock(Declarer.couple_compressed_tuff, Declarer.monuple_compressed_tuff);
                Declarer.TUFF_3X = createCompressedBlock(Declarer.couple_compressed_tuff, Declarer.triple_compressed_tuff);
                Declarer.TUFF_3XU = createUncompressedBlock(Declarer.triple_compressed_tuff, Declarer.couple_compressed_tuff);
                Declarer.TUFF_4X = createCompressedBlock(Declarer.triple_compressed_tuff, Declarer.quadruple_compressed_tuff);
                Declarer.TUFF_4XU = createUncompressedBlock(Declarer.quadruple_compressed_tuff, Declarer.triple_compressed_tuff);
                Declarer.TUFF_5X = createCompressedBlock(Declarer.quadruple_compressed_tuff, Declarer.quintuple_compressed_tuff);
                Declarer.TUFF_5XU = createUncompressedBlock(Declarer.quintuple_compressed_tuff, Declarer.quadruple_compressed_tuff);
                Declarer.TUFF_6X = createCompressedBlock(Declarer.quintuple_compressed_tuff, Declarer.sextuple_compressed_tuff);
                Declarer.TUFF_6XU = createUncompressedBlock(Declarer.sextuple_compressed_tuff, Declarer.quintuple_compressed_tuff);
                Declarer.TUFF_7X = createCompressedBlock(Declarer.sextuple_compressed_tuff, Declarer.septuple_compressed_tuff);
                Declarer.TUFF_7XU = createUncompressedBlock(Declarer.septuple_compressed_tuff, Declarer.sextuple_compressed_tuff);
                Declarer.TUFF_8X = createCompressedBlock(Declarer.septuple_compressed_tuff, Declarer.octuple_compressed_tuff);
                Declarer.TUFF_8XU = createUncompressedBlock(Declarer.octuple_compressed_tuff, Declarer.septuple_compressed_tuff);
                Declarer.TUFF_9X = createCompressedBlock(Declarer.octuple_compressed_tuff, Declarer.nonuple_compressed_tuff);
                Declarer.TUFF_9XU = createUncompressedBlock(Declarer.nonuple_compressed_tuff, Declarer.octuple_compressed_tuff);
            }
            if (Ref.calcite) {
                Declarer.CALCITE_1X = createCompressedBlock(Items.CALCITE, Declarer.monuple_compressed_calcite);
                Declarer.CALCITE_1XU = createUncompressedBlock(Declarer.monuple_compressed_calcite, Items.CALCITE);
                Declarer.CALCITE_2X = createCompressedBlock(Declarer.monuple_compressed_calcite, Declarer.couple_compressed_calcite);
                Declarer.CALCITE_2XU = createUncompressedBlock(Declarer.couple_compressed_calcite, Declarer.monuple_compressed_calcite);
                Declarer.CALCITE_3X = createCompressedBlock(Declarer.couple_compressed_calcite, Declarer.triple_compressed_calcite);
                Declarer.CALCITE_3XU = createUncompressedBlock(Declarer.triple_compressed_calcite, Declarer.couple_compressed_calcite);
                Declarer.CALCITE_4X = createCompressedBlock(Declarer.triple_compressed_calcite, Declarer.quadruple_compressed_calcite);
                Declarer.CALCITE_4XU = createUncompressedBlock(Declarer.quadruple_compressed_calcite, Declarer.triple_compressed_calcite);
                Declarer.CALCITE_5X = createCompressedBlock(Declarer.quadruple_compressed_calcite, Declarer.quintuple_compressed_calcite);
                Declarer.CALCITE_5XU = createUncompressedBlock(Declarer.quintuple_compressed_calcite, Declarer.quadruple_compressed_calcite);
                Declarer.CALCITE_6X = createCompressedBlock(Declarer.quintuple_compressed_calcite, Declarer.sextuple_compressed_calcite);
                Declarer.CALCITE_6XU = createUncompressedBlock(Declarer.sextuple_compressed_calcite, Declarer.quintuple_compressed_calcite);
                Declarer.CALCITE_7X = createCompressedBlock(Declarer.sextuple_compressed_calcite, Declarer.septuple_compressed_calcite);
                Declarer.CALCITE_7XU = createUncompressedBlock(Declarer.septuple_compressed_calcite, Declarer.sextuple_compressed_calcite);
                Declarer.CALCITE_8X = createCompressedBlock(Declarer.septuple_compressed_calcite, Declarer.octuple_compressed_calcite);
                Declarer.CALCITE_8XU = createUncompressedBlock(Declarer.octuple_compressed_calcite, Declarer.septuple_compressed_calcite);
                Declarer.CALCITE_9X = createCompressedBlock(Declarer.octuple_compressed_calcite, Declarer.nonuple_compressed_calcite);
                Declarer.CALCITE_9XU = createUncompressedBlock(Declarer.nonuple_compressed_calcite, Declarer.octuple_compressed_calcite);
            }
        }
    }

    //instead of typing out this every single time, I just made it into a function with the hardcoded reference too
    public static void regItem(String name, Item itemid) {
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, name), itemid);
    }

    public static void regBlock(String name, Block blockid) {
        Registry.register(Registry.BLOCK, new Identifier(Ref.MODID, name), blockid);
    }
}