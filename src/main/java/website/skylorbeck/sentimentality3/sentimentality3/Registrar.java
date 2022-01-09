package website.skylorbeck.sentimentality3.sentimentality3;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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
import website.skylorbeck.minecraft.skylorlib.furnaces.ExtraBlastFurnaceBlockEntity;
import website.skylorbeck.minecraft.skylorlib.furnaces.ExtraFurnaceBlockEntity;
import website.skylorbeck.minecraft.skylorlib.furnaces.ExtraSmokerBlockEntity;

import java.util.Objects;

public class Registrar {
    //todo COMPRESSED TUFF
    //todo compressed calcite

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

        if (Ref.recipes) {
            Identifier tempID;
            //todo individual groups
            Declarer.ARROW = DynamicRecipeLoader.createShapelessRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Items.FLINT),Registry.ITEM.getId(Items.STICK),Registry.ITEM.getId(Items.FEATHER)),
                    Lists.newArrayList(false,false,false),
                    Registry.ITEM.getId(Items.ARROW),
                    4);
            tempID = Registry.ITEM.getId(Items.WHEAT);
            Declarer.BREAD = DynamicRecipeLoader.createShapelessRecipeJson(
                    Lists.newArrayList(tempID,tempID,tempID),
                    Lists.newArrayList(false,false,false),
                    Registry.ITEM.getId(Items.BREAD),
                    1);
            Declarer.BLACKSTONE = DynamicRecipeLoader.createShapedRecipeJsonComplex(
                    Lists.newArrayList(new String[]{Ref.MODID+":stone","minecraft:stone_bricks","minecraft:stone_crafting_materials","minecraft:stone"},new String[]{"minecraft:coals"}),
                    Lists.newArrayList(Lists.newArrayList(true,true,true,false),Lists.newArrayList(true)),
                    Lists.newArrayList("000","010","000"),
                    Registry.ITEM.getId(Items.BLACKSTONE),
                    8
            );
            Declarer.DIORITE = DynamicRecipeLoader.createShapedRecipeJsonComplex(
                    Lists.newArrayList(new String[]{Ref.MODID+":stone","minecraft:stone_bricks","minecraft:stone_crafting_materials","minecraft:stone"},new String[]{"minecraft:quartz"}),
                    Lists.newArrayList(Lists.newArrayList(true,true,true,false),Lists.newArrayList(false)),
                    Lists.newArrayList("000","010","000"),
                    Registry.ITEM.getId(Items.DIORITE),
                    8
            );
            Declarer.GRANITE = DynamicRecipeLoader.createShapedRecipeJson(
                    Lists.newArrayList(new Identifier(Ref.MODID,"diorite"),Registry.ITEM.getId(Items.RED_DYE)),
                    Lists.newArrayList(true,false),
                    Lists.newArrayList("000","010","000"),
                    Registry.ITEM.getId(Items.GRANITE),
                    8
            );
            Declarer.AMETHYST = DynamicRecipeLoader.createShapelessRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Items.AMETHYST_BLOCK)),
                    Lists.newArrayList(false),
                    Registry.ITEM.getId(Items.AMETHYST_SHARD),
                    4);
            tempID= Registry.ITEM.getId(Items.BLAZE_POWDER);
            Declarer.BLAZEROD = DynamicRecipeLoader.createShapelessRecipeJson(
                    Lists.newArrayList(tempID,tempID),
                    Lists.newArrayList(false,false),
                    Registry.ITEM.getId(Items.BLAZE_ROD),
                    2);
            tempID = Registry.ITEM.getId(Items.BROWN_MUSHROOM);
            Declarer.BROWN_MUSHROOM = DynamicRecipeLoader.createShapelessRecipeJson(
                    Lists.newArrayList(tempID,tempID),
                    Lists.newArrayList(false,false),
                    Registry.ITEM.getId(Items.BROWN_MUSHROOM_BLOCK),
                    1);
            tempID = Registry.ITEM.getId(Items.RED_MUSHROOM);
            Declarer.RED_MUSHROOM = DynamicRecipeLoader.createShapelessRecipeJson(
                    Lists.newArrayList(tempID,tempID),
                    Lists.newArrayList(false,false),
                    Registry.ITEM.getId(Items.RED_MUSHROOM_BLOCK),
                    1);
            Declarer.CHAINBOOT = DynamicRecipeLoader.createShapedRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Items.IRON_NUGGET),Registry.ITEM.getId(Items.IRON_INGOT)),//items
                    Lists.newArrayList(false,false),//type
                    Lists.newArrayList("0 0","1 1"),//pattern
                    Registry.ITEM.getId(Items.CHAINMAIL_BOOTS),
                    1
            );
            Declarer.CHAINCHEST = DynamicRecipeLoader.createShapedRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Items.IRON_NUGGET),Registry.ITEM.getId(Items.IRON_INGOT)),//items
                    Lists.newArrayList(false,false),//type
                    Lists.newArrayList("0 0","111","000"),//pattern
                    Registry.ITEM.getId(Items.CHAINMAIL_CHESTPLATE),
                    1
            );
            Declarer.CHAINPANT = DynamicRecipeLoader.createShapedRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Items.IRON_NUGGET),Registry.ITEM.getId(Items.IRON_INGOT)),//items
                    Lists.newArrayList(false,false),//type
                    Lists.newArrayList("0 0","1 1","0 0"),//pattern
                    Registry.ITEM.getId(Items.CHAINMAIL_LEGGINGS),
                    1
            );
            Declarer.CHAINHELM = DynamicRecipeLoader.createShapedRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Items.IRON_NUGGET),Registry.ITEM.getId(Items.IRON_INGOT)),//items
                    Lists.newArrayList(false,false),//type
                    Lists.newArrayList("010","1 1"),//pattern
                    Registry.ITEM.getId(Items.CHAINMAIL_HELMET),
                    1
            );
            Declarer.CHESTS = DynamicRecipeLoader.createShapedRecipeJson(
                    Lists.newArrayList(new Identifier("minecraft","logs")),//items
                    Lists.newArrayList(true),//type
                    Lists.newArrayList("000","0 0","000"),//pattern
                    Registry.ITEM.getId(Items.CHEST),
                    4
            );
            Declarer.CLAY = DynamicRecipeLoader.createShapelessRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Items.CLAY)),
                    Lists.newArrayList(false),
                    Registry.ITEM.getId(Items.CLAY_BALL),
                    4);
            Declarer.CHUNKLOADER = DynamicRecipeLoader.createShapedRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Items.DIAMOND),Registry.ITEM.getId(Items.GOLD_INGOT),Registry.ITEM.getId(Items.ENDER_PEARL)),//items
                    Lists.newArrayList(false,false,false),//type
                    Lists.newArrayList("010","121","010"),//pattern
                    Registry.ITEM.getId(Declarer.chunk_loader),
                    1
            );
            Declarer.QUARTZ_PILLAR_CHISELED = DynamicRecipeLoader.createShapelessRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Items.QUARTZ_PILLAR)),
                    Lists.newArrayList(false),
                    Registry.ITEM.getId(Items.CHISELED_QUARTZ_BLOCK),
                    1);
            Declarer.COPPERBOOT = DynamicRecipeLoader.createShapedRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Items.COPPER_INGOT)),//items
                    Lists.newArrayList(false),//type
                    Lists.newArrayList("0 0","0 0"),//pattern
                    Registry.ITEM.getId(Declarer.copper_boots),
                    1
            );
            Declarer.COPPERCHEST = DynamicRecipeLoader.createShapedRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Items.COPPER_INGOT)),//items
                    Lists.newArrayList(false),//type
                    Lists.newArrayList("0 0","000","000"),//pattern
                    Registry.ITEM.getId(Declarer.copper_chestplate),
                    1
            );
            Declarer.COPPERPANT = DynamicRecipeLoader.createShapedRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Items.COPPER_INGOT)),//items
                    Lists.newArrayList(false),//type
                    Lists.newArrayList("0 0","0 0","0 0"),//pattern
                    Registry.ITEM.getId(Declarer.copper_leggings),
                    1
            );
            Declarer.COPPERHELM = DynamicRecipeLoader.createShapedRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Items.COPPER_INGOT)),//items
                    Lists.newArrayList(false),//type
                    Lists.newArrayList("000","0 0"),//pattern
                    Registry.ITEM.getId(Declarer.copper_helmet),
                    1
            );
            Declarer.HORSE_DIAMOND = DynamicRecipeLoader.createShapedRecipeJson(
                    Lists.newArrayList(new Identifier("minecraft","wool"),Registry.ITEM.getId(Items.DIAMOND),Registry.ITEM.getId(Items.DIAMOND_LEGGINGS),Registry.ITEM.getId(Items.DIAMOND_HELMET)),//items
                    Lists.newArrayList(true,false,false,false),//type
                    Lists.newArrayList("  3","101","2 2"),//pattern
                    Registry.ITEM.getId(Items.DIAMOND_HORSE_ARMOR),
                    1
            );
            Declarer.HORSE_GOLD = DynamicRecipeLoader.createShapedRecipeJson(
                    Lists.newArrayList(new Identifier("minecraft","wool"),Registry.ITEM.getId(Items.GOLD_INGOT),Registry.ITEM.getId(Items.GOLDEN_LEGGINGS),Registry.ITEM.getId(Items.GOLDEN_HELMET)),//items
                    Lists.newArrayList(true,false,false,false),//type
                    Lists.newArrayList("  3","101","2 2"),//pattern
                    Registry.ITEM.getId(Items.GOLDEN_HORSE_ARMOR),
                    1
            );
            Declarer.HORSE_IRON = DynamicRecipeLoader.createShapedRecipeJson(
                    Lists.newArrayList(new Identifier("minecraft","wool"),Registry.ITEM.getId(Items.IRON_INGOT),Registry.ITEM.getId(Items.IRON_LEGGINGS),Registry.ITEM.getId(Items.IRON_HELMET)),//items
                    Lists.newArrayList(true,false,false,false),//type
                    Lists.newArrayList("  3","101","2 2"),//pattern
                    Registry.ITEM.getId(Items.IRON_HORSE_ARMOR),
                    1
            );
            tempID = Registry.ITEM.getId(Items.FEATHER);
            Declarer.FEATHER = DynamicRecipeLoader.createShapelessRecipeJson(
                    Lists.newArrayList(tempID,tempID,tempID,tempID,tempID,tempID,tempID,tempID,tempID),
                    Lists.newArrayList(false,false,false,false,false,false,false,false,false),
                    Registry.ITEM.getId(Declarer.feather_block),
                    1);
            Declarer.FEATHER_U = DynamicRecipeLoader.createShapelessRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Declarer.feather_block)),
                    Lists.newArrayList(false),
                    Registry.ITEM.getId(Items.FEATHER),
                    9);
            tempID = Registry.ITEM.getId(Items.ROTTEN_FLESH);
            Declarer.FLEATHER = DynamicRecipeLoader.createShapelessRecipeJson(
                    Lists.newArrayList(tempID,tempID,tempID,tempID),
                    Lists.newArrayList(false,false,false,false),
                    Registry.ITEM.getId(Declarer.fleather),
                    1);
            Declarer.FLINT = DynamicRecipeLoader.createShapelessRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Items.GRAVEL)),
                    Lists.newArrayList(false),
                    Registry.ITEM.getId(Items.FLINT),
                    1);
            Declarer.FURNACE = DynamicRecipeLoader.createShapedRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Items.COBBLESTONE)),
                    Lists.newArrayList(false),
                    Lists.newArrayList("000","0 0","000"),
                    Registry.ITEM.getId(Items.FURNACE),
                    1);
            Declarer.GLOWSTONE = DynamicRecipeLoader.createShapelessRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Items.GLOWSTONE)),
                    Lists.newArrayList(false),
                    Registry.ITEM.getId(Items.GLOWSTONE_DUST),
                    4);
            tempID = Registry.ITEM.getId(Items.STICK);
            Declarer.STICK_BUNDLE_S = DynamicRecipeLoader.createShapelessRecipeJson(
                    Lists.newArrayList(tempID,tempID,tempID,tempID),
                    Lists.newArrayList(false,false,false,false),
                    Registry.ITEM.getId(Declarer.small_stick_bundle),
                    1);
            Declarer.STICK_BUNDLE_S_U = DynamicRecipeLoader.createShapelessRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Declarer.small_stick_bundle)),
                    Lists.newArrayList(false),
                    tempID,
                    4);
            tempID = Registry.ITEM.getId(Declarer.small_stick_bundle);
            Declarer.STICK_BUNDLE_L = DynamicRecipeLoader.createShapelessRecipeJson(
                    Lists.newArrayList(tempID,tempID,tempID,tempID),
                    Lists.newArrayList(false,false,false,false),
                    Registry.ITEM.getId(Declarer.large_stick_bundle),
                    1);
            Declarer.STICK_BUNDLE_L_U = DynamicRecipeLoader.createShapelessRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Declarer.large_stick_bundle)),
                    Lists.newArrayList(false),
                    tempID,
                    4);
            Declarer.TORCH = DynamicRecipeLoader.createShapelessRecipeJson(
                    Lists.newArrayList(new Identifier(Ref.MODID,"coalblocks"),Registry.ITEM.getId(Declarer.large_stick_bundle)),
                    Lists.newArrayList(true,false),
                    Registry.ITEM.getId(Items.TORCH),
                    64);
            Declarer.MOSSY_COBBLESTONE = DynamicRecipeLoader.createShapedRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Items.COBBLESTONE),Registry.ITEM.getId(Items.WATER_BUCKET)),
                    Lists.newArrayList(false,false),
                    Lists.newArrayList("000","010","000"),
                    Registry.ITEM.getId(Items.FURNACE),
                    8);
            tempID = Registry.ITEM.getId(Items.PAPER);
            Declarer.NAMETAG = DynamicRecipeLoader.createShapelessRecipeJson(
                    Lists.newArrayList(tempID,tempID,Registry.ITEM.getId(Items.STRING),Registry.ITEM.getId(Items.SLIME_BALL)),
                    Lists.newArrayList(false,false,false,false),
                    Registry.ITEM.getId(Items.NAME_TAG),
                    1);
            Declarer.NOTCH_APPLE = DynamicRecipeLoader.createShapedRecipeJson(
                    Lists.newArrayList(Registry.ITEM.getId(Items.GOLD_BLOCK),Registry.ITEM.getId(Items.APPLE)),
                    Lists.newArrayList(false,false),
                    Lists.newArrayList("000","010","000"),
                    Registry.ITEM.getId(Items.ENCHANTED_GOLDEN_APPLE),
                    1);
            //personal items
            if (Ref.daylighter) {
            }
            if (Ref.slimer) {
            }
            if (Ref.chunker) {
            }
            //misc items
            if (Ref.fleather) {
            }
            if (Ref.charcoal) {
                tempID = Registry.ITEM.getId(Items.CHARCOAL);
                Declarer.CHARCOAL_BLOCK = DynamicRecipeLoader.createShapelessRecipeJson(
                        Lists.newArrayList(tempID,tempID,tempID,tempID,tempID,tempID,tempID,tempID,tempID),
                        Lists.newArrayList(false,false,false,false,false,false,false,false,false),
                        Registry.ITEM.getId(Declarer.charcoal_block),
                        1);
                Declarer.CHARCOAL_BLOCK_U = DynamicRecipeLoader.createShapelessRecipeJson(
                        Lists.newArrayList(Registry.ITEM.getId(Declarer.charcoal_block)),
                        Lists.newArrayList(false),
                        Registry.ITEM.getId(Items.CHARCOAL),
                        9);
            }
            if (Ref.sticks) {

            }
            if (Ref.featherBlock) {
            }
            if (Ref.coalChunks) {
                tempID = Registry.ITEM.getId(Declarer.charcoal_nugget);
                Declarer.CHARCOAL_NUGGET_U = DynamicRecipeLoader.createShapelessRecipeJson(
                        Lists.newArrayList(tempID,tempID,tempID,tempID,tempID,tempID,tempID,tempID),
                        Lists.newArrayList(false,false,false,false,false,false,false,false),
                        Registry.ITEM.getId(Items.CHARCOAL),
                        1);
                Declarer.CHARCOAL_NUGGET = DynamicRecipeLoader.createShapelessRecipeJson(
                        Lists.newArrayList(Registry.ITEM.getId(Items.CHARCOAL)),
                        Lists.newArrayList(false),
                        Registry.ITEM.getId(Declarer.charcoal_nugget),
                        8);
                tempID = Registry.ITEM.getId(Declarer.coal_nugget);
                Declarer.COAL_NUGGET_U = DynamicRecipeLoader.createShapelessRecipeJson(
                        Lists.newArrayList(tempID,tempID,tempID,tempID,tempID,tempID,tempID,tempID),
                        Lists.newArrayList(false,false,false,false,false,false,false,false),
                        Registry.ITEM.getId(Items.COAL),
                        1);
                Declarer.COAL_NUGGET = DynamicRecipeLoader.createShapelessRecipeJson(
                        Lists.newArrayList(Registry.ITEM.getId(Items.COAL)),
                        Lists.newArrayList(false),
                        Registry.ITEM.getId(Declarer.coal_nugget),
                        8);
            }


            //block entities
            //furnace entity
            if (Ref.furnaces) {
                Declarer.ANDESITE_FURNACE = DynamicRecipeLoader.createShapedRecipeJson(
                        Lists.newArrayList(new Identifier(Ref.MODID,"andesite")),//items
                        Lists.newArrayList(true),//type
                        Lists.newArrayList("000","0 0","000"),//pattern
                        Registry.ITEM.getId(Declarer.andesite_furnace),
                        1
                );
                Declarer.BLACKSTONE_FURNACE = DynamicRecipeLoader.createShapedRecipeJson(
                        Lists.newArrayList(new Identifier(Ref.MODID,"blackstone")),//items
                        Lists.newArrayList(true),//type
                        Lists.newArrayList("000","0 0","000"),//pattern
                        Registry.ITEM.getId(Declarer.blackstone_furnace),
                        1
                );
                Declarer.BASALT_FURNACE = DynamicRecipeLoader.createShapedRecipeJson(
                        Lists.newArrayList(new Identifier(Ref.MODID,"basalt")),//items
                        Lists.newArrayList(true),//type
                        Lists.newArrayList("000","0 0","000"),//pattern
                        Registry.ITEM.getId(Declarer.basalt_furnace),
                        1
                );
                Declarer.DEEPSLATE_FURNACE = DynamicRecipeLoader.createShapedRecipeJson(
                        Lists.newArrayList(new Identifier(Ref.MODID,"deepslate")),//items
                        Lists.newArrayList(true),//type
                        Lists.newArrayList("000","0 0","000"),//pattern
                        Registry.ITEM.getId(Declarer.deepslate_furnace),
                        1
                );
                Declarer.DIORITE_FURNACE = DynamicRecipeLoader.createShapedRecipeJson(
                        Lists.newArrayList(new Identifier(Ref.MODID,"diorite")),//items
                        Lists.newArrayList(true),//type
                        Lists.newArrayList("000","0 0","000"),//pattern
                        Registry.ITEM.getId(Declarer.diorite_furnace),
                        1
                );
                Declarer.ENDSTONE_FURNACE = DynamicRecipeLoader.createShapedRecipeJson(
                        Lists.newArrayList(new Identifier(Ref.MODID,"endstone")),//items
                        Lists.newArrayList(true),//type
                        Lists.newArrayList("000","0 0","000"),//pattern
                        Registry.ITEM.getId(Declarer.endstone_furnace),
                        1
                );
                Declarer.GRANITE_FURNACE = DynamicRecipeLoader.createShapedRecipeJson(
                        Lists.newArrayList(new Identifier(Ref.MODID,"granite")),//items
                        Lists.newArrayList(true),//type
                        Lists.newArrayList("000","0 0","000"),//pattern
                        Registry.ITEM.getId(Declarer.granite_furnace),
                        1
                );
                Declarer.NETHERRACK_FURNACE = DynamicRecipeLoader.createShapedRecipeJson(
                        Lists.newArrayList(Registry.ITEM.getId(Items.NETHERRACK)),//items
                        Lists.newArrayList(false),//type
                        Lists.newArrayList("000","0 0","000"),//pattern
                        Registry.ITEM.getId(Declarer.netherrack_furnace),
                        1
                );
            }
            //blast furnace entity
            if (Ref.blasts) {
                tempID = Registry.ITEM.getId(Items.IRON_INGOT);
                Declarer.ANDESITE_BLAST = DynamicRecipeLoader.createShapedRecipeJson(
                        Lists.newArrayList(tempID,Registry.ITEM.getId(Declarer.andesite_furnace),new Identifier(Ref.MODID,"andesite")),//items
                        Lists.newArrayList(false,false,true),//type
                        Lists.newArrayList("000","010","222"),//pattern
                        Registry.ITEM.getId(Declarer.andesite_blast_furnace),
                        1
                );
                Declarer.BLACKSTONE_BLAST = DynamicRecipeLoader.createShapedRecipeJson(
                        Lists.newArrayList(tempID,Registry.ITEM.getId(Declarer.blackstone_furnace),new Identifier(Ref.MODID,"blackstone")),//items
                        Lists.newArrayList(false,false,true),//type
                        Lists.newArrayList("000","010","222"),//pattern
                        Registry.ITEM.getId(Declarer.blackstone_blast_furnace),
                        1
                );
                Declarer.BASALT_BLAST = DynamicRecipeLoader.createShapedRecipeJson(
                        Lists.newArrayList(tempID,Registry.ITEM.getId(Declarer.basalt_furnace),new Identifier(Ref.MODID,"basalt")),//items
                        Lists.newArrayList(false,false,true),//type
                        Lists.newArrayList("000","010","222"),//pattern
                        Registry.ITEM.getId(Declarer.basalt_blast_furnace),
                        1
                );
                Declarer.DEEPSLATE_BLAST = DynamicRecipeLoader.createShapedRecipeJson(
                        Lists.newArrayList(tempID,Registry.ITEM.getId(Declarer.deepslate_furnace),new Identifier(Ref.MODID,"deepslate")),//items
                        Lists.newArrayList(false,false,true),//type
                        Lists.newArrayList("000","010","222"),//pattern
                        Registry.ITEM.getId(Declarer.deepslate_blast_furnace),
                        1
                );
                Declarer.DIORITE_BLAST = DynamicRecipeLoader.createShapedRecipeJson(
                        Lists.newArrayList(tempID,Registry.ITEM.getId(Declarer.diorite_furnace),new Identifier(Ref.MODID,"diorite")),//items
                        Lists.newArrayList(false,false,true),//type
                        Lists.newArrayList("000","010","222"),//pattern
                        Registry.ITEM.getId(Declarer.diorite_blast_furnace),
                        1
                );
                Declarer.ENDSTONE_BLAST = DynamicRecipeLoader.createShapedRecipeJson(
                        Lists.newArrayList(tempID,Registry.ITEM.getId(Declarer.endstone_furnace),new Identifier(Ref.MODID,"endstone")),//items
                        Lists.newArrayList(false,false,true),//type
                        Lists.newArrayList("000","010","222"),//pattern
                        Registry.ITEM.getId(Declarer.endstone_blast_furnace),
                        1
                );
                Declarer.GRANITE_BLAST = DynamicRecipeLoader.createShapedRecipeJson(
                        Lists.newArrayList(tempID,Registry.ITEM.getId(Declarer.granite_furnace),new Identifier(Ref.MODID,"granite")),//items
                        Lists.newArrayList(false,false,true),//type
                        Lists.newArrayList("000","010","222"),//pattern
                        Registry.ITEM.getId(Declarer.granite_blast_furnace),
                        1
                );
                Declarer.NETHERRACK_BLAST = DynamicRecipeLoader.createShapedRecipeJson(
                        Lists.newArrayList(tempID,Registry.ITEM.getId(Declarer.netherrack_furnace),Registry.ITEM.getId(Items.NETHER_BRICK)),//items
                        Lists.newArrayList(false,false,false),//type
                        Lists.newArrayList("000","010","222"),//pattern
                        Registry.ITEM.getId(Declarer.netherrack_blast_furnace),
                        1
                );
            }
            //smoker entity
            if (Ref.smokers) {
                tempID = new Identifier("minecraft","logs");
                Declarer.ANDESITE_SMOKER = DynamicRecipeLoader.createShapedRecipeJson(
                        Lists.newArrayList(Registry.ITEM.getId(Declarer.andesite_furnace),tempID),//items
                        Lists.newArrayList(false,true),//type
                        Lists.newArrayList(" 1 ","101"," 1 "),//pattern
                        Registry.ITEM.getId(Declarer.andesite_smoker),
                        1
                );
                Declarer.BLACKSTONE_SMOKER = DynamicRecipeLoader.createShapedRecipeJson(
                        Lists.newArrayList(Registry.ITEM.getId(Declarer.blackstone_furnace),tempID),//items
                        Lists.newArrayList(false,true),//type
                        Lists.newArrayList(" 1 ","101"," 1 "),//pattern
                        Registry.ITEM.getId(Declarer.blackstone_smoker),
                        1
                );
                Declarer.BASALT_SMOKER = DynamicRecipeLoader.createShapedRecipeJson(
                        Lists.newArrayList(Registry.ITEM.getId(Declarer.basalt_furnace),tempID),//items
                        Lists.newArrayList(false,true),//type
                        Lists.newArrayList(" 1 ","101"," 1 "),//pattern
                        Registry.ITEM.getId(Declarer.basalt_smoker),
                        1
                );
                Declarer.DEEPSLATE_SMOKER = DynamicRecipeLoader.createShapedRecipeJson(
                        Lists.newArrayList(Registry.ITEM.getId(Declarer.deepslate_furnace),tempID),//items
                        Lists.newArrayList(false,true),//type
                        Lists.newArrayList(" 1 ","101"," 1 "),//pattern
                        Registry.ITEM.getId(Declarer.deepslate_smoker),
                        1
                );
                Declarer.DIORITE_SMOKER = DynamicRecipeLoader.createShapedRecipeJson(
                        Lists.newArrayList(Registry.ITEM.getId(Declarer.diorite_furnace),tempID),//items
                        Lists.newArrayList(false,true),//type
                        Lists.newArrayList(" 1 ","101"," 1 "),//pattern
                        Registry.ITEM.getId(Declarer.diorite_smoker),
                        1
                );
                Declarer.ENDSTONE_SMOKER = DynamicRecipeLoader.createShapedRecipeJson(
                        Lists.newArrayList(Registry.ITEM.getId(Declarer.endstone_furnace),tempID),//items
                        Lists.newArrayList(false,true),//type
                        Lists.newArrayList(" 1 ","101"," 1 "),//pattern
                        Registry.ITEM.getId(Declarer.endstone_smoker),
                        1
                );
                Declarer.GRANITE_SMOKER = DynamicRecipeLoader.createShapedRecipeJson(
                        Lists.newArrayList(Registry.ITEM.getId(Declarer.granite_furnace),tempID),//items
                        Lists.newArrayList(false,true),//type
                        Lists.newArrayList(" 1 ","101"," 1 "),//pattern
                        Registry.ITEM.getId(Declarer.granite_smoker),
                        1
                );
                Declarer.NETHERRACK_SMOKER = DynamicRecipeLoader.createShapedRecipeJson(
                        Lists.newArrayList(Registry.ITEM.getId(Declarer.netherrack_furnace),tempID),//items
                        Lists.newArrayList(false,true),//type
                        Lists.newArrayList(" 1 ","101"," 1 "),//pattern
                        Registry.ITEM.getId(Declarer.netherrack_smoker),
                        1
                );
            }
            //furnaces
            if (Ref.furnaces) {

            }
            //blast furnaces
            if (Ref.blasts) {
            }
            //smokers
            if (Ref.smokers) {
            }
            //wool armor
            if (Ref.woolArmor) {
            }
            //copper armor
            if (Ref.copperArmor) {
            }
            //tools
            if (Ref.allTools) {
                if (Ref.graniteTools) {

                }
                if (Ref.dioriteTools) {
                }
                if (Ref.andesiteTools) {
                }
                if (Ref.quartzTools) {
                }
                if (Ref.netherrackTools) {
                }
                if (Ref.netherbrickTools) {
                }
                if (Ref.redNetherbrickTools) {
                }
                if (Ref.sandstoneTools) {
                }
                if (Ref.redSandstoneTools) {
                }
                if (Ref.lapisTools) {
                }
                if (Ref.emeraldTools) {
                }
                if (Ref.flintTools) {
                }
                if (Ref.redstoneTools) {
                }
                if (Ref.blackstoneTools) {
                }
                if (Ref.basaltTools) {
                }
                if (Ref.endstoneTools) {
                }
                if (Ref.warpedTools) {
                }
                if (Ref.crimsonTools) {
                }
                if (Ref.amethystTools) {
                }
                if (Ref.copperTools) {
                }
                if (Ref.deepslateTools) {
                }
            }

            //compressed cobble
            if (Ref.allCompressedBlocks) {
                if (Ref.cobble) {
                }
                //compressed dirt
                if (Ref.dirt) {
                }
                //compressed diorite
                if (Ref.diorite) {
                }
                //compressed granite
                if (Ref.granite) {
                }
                //compressed andesite
                if (Ref.andesite) {
                }
                //compressed netherrack
                if (Ref.netherrack) {
                }
                if (Ref.sand) {
                }
                if (Ref.gravel) {
                }
                if (Ref.deepslate) {
                }
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