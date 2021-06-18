package website.skylorbeck.sentimentality3.sentimentality3;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "sentimentality3")
public class ModConfig implements ConfigData {


    @ConfigEntry.Gui.Tooltip
    boolean showItems = true;

    public boolean repairCost = true;

    @ConfigEntry.Gui.Tooltip
    public boolean pingIndicator = true;

    public boolean infinityFix = true;

    public boolean itemEntity = true;

    public boolean beehiveTips = true;

    public boolean durabilityWarn = true;
    /*@ConfigEntry.Gui.CollapsibleObject()
    public durabilityStuff durabilityStuff = new durabilityStuff();*/

    @ConfigEntry.Gui.CollapsibleObject()
    public CropStuff cropStuff = new CropStuff();

    @ConfigEntry.Gui.CollapsibleObject()
    clockStuff clockStuff = new clockStuff();

    @ConfigEntry.Gui.CollapsibleObject()
    sleepStuff sleepStuff = new sleepStuff();

    @ConfigEntry.Gui.CollapsibleObject()
    toggles toggles = new toggles();
    static class toggles {
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean chunker = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean slimer = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean daylighter = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean fleather = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean charcoal = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean coalChunks = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean sticks = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean featherBlock = true;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        @ConfigEntry.Gui.Excluded
        boolean gliders = false;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean furnaces = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean blasts = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean smokers = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean woolArmor = true;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean allTools = true;
        @ConfigEntry.Gui.Tooltip(count = 2)
        @ConfigEntry.Gui.CollapsibleObject()
        toolToggles toolToggles = new toolToggles();
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean allCompressedBlocks = true;
        @ConfigEntry.Gui.Tooltip(count = 2)
        @ConfigEntry.Gui.CollapsibleObject()
        compressedBlocks compressedBlocks = new compressedBlocks();
    }
    /*public static class durabilityStuff {
        public boolean durabilityWarn = true;
        @ConfigEntry.Gui.Excluded
        @ConfigEntry.BoundedDiscrete(min=10,max = 30)
        public int durabilityThreshold1 = 10;
        @ConfigEntry.Gui.Excluded
        @ConfigEntry.BoundedDiscrete(min=1,max = 15)
        public int durabilityThreshold2 = 5;
    }*/

    public static class CropStuff {
        public boolean cropSparkle = true;
        public enum SparkleType {
            DRAGON_BREATH,
            TOTEM_OF_UNDYING,
            ENCHANTED_HIT,
            HAPPY_VILLAGER,
            INSTANT_EFFECT,
        }
        public SparkleType sparkleType = SparkleType.INSTANT_EFFECT; //SparkleType.valueOf("INSTANT_EFFECT");
        @ConfigEntry.BoundedDiscrete(min=1,max = 15)
        public int sparkleCount = 2;
    }
    static class sleepStuff {
        boolean doSleepStuff = true;
        boolean showSleepCount = true;

        //@ConfigEntry.Gui.RequiresRestart
        @ConfigEntry.BoundedDiscrete(max = 100, min = 1)
        @ConfigEntry.Gui.Tooltip
        int sleepPercent = 50;
    }

    static class clockStuff {
        boolean doClock = true;
        @ConfigEntry.BoundedDiscrete(max = 3)
        @ConfigEntry.Gui.Tooltip(count = 4)
        int clockCorner = 1;
        boolean clockMilitary = false;
        boolean clockAmPm = true;
    }

    static class toolToggles{
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean graniteTools = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean dioriteTools = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean andesiteTools = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean quartzTools = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean netherrackTools = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean netherbrickTools = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean redNetherbrickTools = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean sandstoneTools = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean redSandstoneTools = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean lapisTools = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean emeraldTools = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean flintTools = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean redstoneTools = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean blackstoneTools = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean basaltTools = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean endstoneTools = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean warpedTools = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean crimsonTools = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean amethystTools = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean copperTools = true;
    }

    static class compressedBlocks{
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean cobble = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean dirt = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean diorite = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean andesite = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean granite = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean netherrack = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean sand = true;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean gravel = true;
    }
}