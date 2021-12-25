package website.skylorbeck.sentimentality3.sentimentality3;

import me.shedaniel.autoconfig.AutoConfig;

public class Ref {//hardcoded references for use in registration and otherwise
    public static final String MODID = "sentimentality3";
    public static final String display = "display";
    public static final String color = "color";
    public static ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();

    public static boolean showItems = true;
    public static boolean repairCost = true;
    public static boolean pingIndicator = true;
    public static boolean infinityFix = true;
    public static boolean itemEntity = true;
    public static boolean altItemEntity = false;
    public static boolean beehiveTips = true;
    public static boolean durabilityWarn = true;
    public static boolean chunker = true;
    public static boolean slimer = true;
    public static boolean daylighter = true;
    public static boolean fleather = true;
    public static boolean charcoal = true;
    public static boolean coalChunks = true;
    public static boolean sticks = true;
    public static boolean featherBlock = true;
    public static boolean gliders = false;
    public static boolean furnaces = true;
    public static boolean blasts = true;
    public static boolean smokers = true;
    public static boolean woolArmor = true;
    public static boolean copperArmor = true;
    public static boolean allTools = true;
    public static boolean allCompressedBlocks = true;
    public static boolean cropSparkle = true;
    public static ModConfig.CropStuff.SparkleType sparkleType = ModConfig.CropStuff.SparkleType.INSTANT_EFFECT;
    public static int sparkleCount = 2;
    public static boolean showSleepCount = true;
    public static boolean doClock = true;
    public static int clockCorner = 1;
    public static boolean clockMilitary = false;
    public static boolean clockAmPm = true;
    public static boolean graniteTools = true;
    public static boolean dioriteTools = true;
    public static boolean andesiteTools = true;
    public static boolean quartzTools = true;
    public static boolean netherrackTools = true;
    public static boolean netherbrickTools = true;
    public static boolean redNetherbrickTools = true;
    public static boolean sandstoneTools = true;
    public static boolean redSandstoneTools = true;
    public static boolean lapisTools = true;
    public static boolean emeraldTools = true;
    public static boolean flintTools = true;
    public static boolean redstoneTools = true;
    public static boolean blackstoneTools = true;
    public static boolean basaltTools = true;
    public static boolean endstoneTools = true;
    public static boolean warpedTools = true;
    public static boolean crimsonTools = true;
    public static boolean amethystTools = true;
    public static boolean copperTools = true;
    public static boolean deepslateTools = true;
    public static boolean cobble = true;
    public static boolean dirt = true;
    public static boolean diorite = true;
    public static boolean andesite = true;
    public static boolean granite = true;
    public static boolean netherrack = true;
    public static boolean sand = true;
    public static boolean gravel = true;
    public static boolean deepslate = true;

    public static void getSettings() {
    /*
        chunker = config.toggles.chunker;
        slimer = config.toggles.slimer;
        daylighter = config.toggles.daylighter;
        fleather = config.toggles.fleather;
        charcoal = config.toggles.charcoal;
        coalChunks = config.toggles.coalChunks;
        sticks = config.toggles.sticks;
        featherBlock = config.toggles.featherBlock;
        gliders = config.toggles.gliders;
        furnaces = config.toggles.furnaces;
        blasts = config.toggles.blasts;
        smokers = config.toggles.smokers;
        woolArmor = config.toggles.woolArmor;
        copperArmor = config.toggles.copperArmor;
        allTools = config.toggles.allTools;
        allCompressedBlocks = config.toggles.allCompressedBlocks;
        graniteTools = config.toggles.toolToggles.graniteTools;
        dioriteTools = config.toggles.toolToggles.dioriteTools;
        andesiteTools = config.toggles.toolToggles.andesiteTools;
        quartzTools = config.toggles.toolToggles.quartzTools;
        netherrackTools = config.toggles.toolToggles.netherrackTools;
        netherbrickTools = config.toggles.toolToggles.netherbrickTools;
        redNetherbrickTools = config.toggles.toolToggles.redNetherbrickTools;
        sandstoneTools = config.toggles.toolToggles.sandstoneTools;
        redSandstoneTools = config.toggles.toolToggles.redSandstoneTools;
        lapisTools = config.toggles.toolToggles.lapisTools;
        emeraldTools = config.toggles.toolToggles.emeraldTools;
        flintTools = config.toggles.toolToggles.flintTools;
        redstoneTools = config.toggles.toolToggles.redstoneTools;
        blackstoneTools = config.toggles.toolToggles.blackstoneTools;
        basaltTools = config.toggles.toolToggles.basaltTools;
        endstoneTools = config.toggles.toolToggles.endstoneTools;
        warpedTools = config.toggles.toolToggles.warpedTools;
        crimsonTools = config.toggles.toolToggles.crimsonTools;
        amethystTools = config.toggles.toolToggles.amethystTools;
        copperTools = config.toggles.toolToggles.copperTools;
        deepslateTools = config.toggles.toolToggles.deepslateTools;
        cobble = config.toggles.compressedBlocks.cobble;
        dirt = config.toggles.compressedBlocks.dirt;
        diorite = config.toggles.compressedBlocks.diorite;
        andesite = config.toggles.compressedBlocks.andesite;
        granite = config.toggles.compressedBlocks.granite;
        netherrack = config.toggles.compressedBlocks.netherrack;
        sand = config.toggles.compressedBlocks.sand;
        gravel = config.toggles.compressedBlocks.gravel;
        deepslate = config.toggles.compressedBlocks.deepslate;
     */
        getSomeSettings();

    }

    public static void getSomeSettings() {
        showItems = config.showItems;
        repairCost = config.repairCost;
        pingIndicator = config.pingIndicator;
        infinityFix = config.infinityFix;
        itemEntity = config.itemEntity;
        beehiveTips = config.beehiveTips;
        durabilityWarn = config.durabilityWarn;
        cropSparkle = config.cropStuff.cropSparkle;
        sparkleType = config.cropStuff.sparkleType;
        sparkleCount = config.cropStuff.sparkleCount;
        showSleepCount = config.showSleepCount;
        doClock = config.clockStuff.doClock;
        clockCorner = config.clockStuff.clockCorner;
        clockMilitary = config.clockStuff.clockMilitary;
        clockAmPm = config.clockStuff.clockAmPm;
    }
}
