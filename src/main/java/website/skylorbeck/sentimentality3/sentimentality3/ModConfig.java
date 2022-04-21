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
//    public boolean altItemEntity = true;

    public boolean beehiveTips = true;

    @ConfigEntry.Gui.CollapsibleObject()
    public DurabilityStuff durabilityStuff = new DurabilityStuff();

    @ConfigEntry.Gui.CollapsibleObject()
    public CropStuff cropStuff = new CropStuff();

    @ConfigEntry.Gui.CollapsibleObject()
    clockStuff clockStuff = new clockStuff();

//    @ConfigEntry.Gui.CollapsibleObject()
//    sleepStuff sleepStuff = new sleepStuff();
    public boolean showSleepCount = true;



    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Gui.CollapsibleObject()
    toggles toggles = new toggles();




    static class toggles {
        @ConfigEntry.Gui.RequiresRestart
        boolean chunker = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean slimer = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean daylighter = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean fleather = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean charcoal = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean coalChunks = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean sticks = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean featherBlock = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean furnaces = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean blasts = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean smokers = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean woolArmor = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean copperArmor = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean chainArmor = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean chests = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean massTorch = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean massArrow = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean allShapeless = true;
        @ConfigEntry.Gui.Tooltip(count = 2)
        @ConfigEntry.Gui.CollapsibleObject()
        Shapeless shapeless = new Shapeless();
        @ConfigEntry.Gui.RequiresRestart
        boolean allConvertStone = true;
        @ConfigEntry.Gui.Tooltip(count = 2)
        @ConfigEntry.Gui.CollapsibleObject()
        ConvertStone convertStone = new ConvertStone();
        @ConfigEntry.Gui.RequiresRestart
        boolean allUnpack = true;
        @ConfigEntry.Gui.Tooltip(count = 2)
        @ConfigEntry.Gui.CollapsibleObject()
        Unpack unpack = new Unpack();
        @ConfigEntry.Gui.RequiresRestart
        boolean allHorseArmor = true;
        @ConfigEntry.Gui.Tooltip(count = 2)
        @ConfigEntry.Gui.CollapsibleObject()
        HorseArmor horseArmor = new HorseArmor();
        @ConfigEntry.Gui.RequiresRestart
        boolean allOverPower = true;
        @ConfigEntry.Gui.Tooltip(count = 2)
        @ConfigEntry.Gui.CollapsibleObject()
        OverPowered overPowered = new OverPowered();
        @ConfigEntry.Gui.RequiresRestart
        boolean allRawSmelt = true;
        @ConfigEntry.Gui.Tooltip(count = 2)
        @ConfigEntry.Gui.CollapsibleObject()
        RawSmelt rawSmelt = new RawSmelt();
        @ConfigEntry.Gui.RequiresRestart
        boolean allReclaim = true;
        @ConfigEntry.Gui.Tooltip(count = 2)
        @ConfigEntry.Gui.CollapsibleObject()
        Reclaim reclaim = new Reclaim();
        @ConfigEntry.Gui.RequiresRestart
        boolean allTools = true;
        @ConfigEntry.Gui.Tooltip(count = 2)
        @ConfigEntry.Gui.CollapsibleObject()
        toolToggles toolToggles = new toolToggles();
        @ConfigEntry.Gui.RequiresRestart
        boolean allCompressedBlocks = true;
        @ConfigEntry.Gui.Tooltip(count = 2)
        @ConfigEntry.Gui.CollapsibleObject()
        compressedBlocks compressedBlocks = new compressedBlocks();
    }

    public static class Shapeless {
        public boolean bread = true;
        public boolean arrow = true;
        public boolean paper = true;
        public boolean shulker = true;
    }
    public static class ConvertStone{
        public boolean blackstone = true;
        public boolean gilded_blackstone = true;
        public boolean diorite = true;
        public boolean granite = true;
        public boolean andesite = true;
        public boolean mossy_cobble = true;
        public boolean quartz = true;
    }
    public static class Unpack{
        public boolean clay = true;
        public boolean flint = true;
        public boolean amethyst = true;
        public boolean blazerod = true;
        public boolean brown_mushroom = true;
        public boolean red_mushroom = true;
        public boolean wart = true;
        public boolean glowstone = true;
        public boolean string = true;
        public boolean quartz = true;
    }
    public static class HorseArmor{
        public boolean iron = true;
        public boolean gold = true;
        public boolean diamond = true;
    }
    public static class OverPowered{
        public boolean slime = true;
        public boolean trident = true;
        public boolean nametag = true;
        public boolean notchapple = true;
        public boolean saddle = true;
    }
    public static class RawSmelt{
        public boolean copper = true;
        public boolean iron = true;
        public boolean gold = true;
    }
    public static class Reclaim{
        public boolean copper = true;
        public boolean iron = true;
        public boolean gold = true;
        public boolean diamond = true;
    }

    public static class CropStuff {
        public int sugarCaneHeight = 5;
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

    static class clockStuff {
        boolean doClock = true;
        @ConfigEntry.BoundedDiscrete(max = 3)
        @ConfigEntry.Gui.Tooltip(count = 4)
        int clockCorner = 1;
        boolean clockMilitary = false;
        boolean clockAmPm = true;
    }

    static class DurabilityStuff {
        public boolean durabilityWarn = true;
        @ConfigEntry.BoundedDiscrete(min = 10,max = 30)
        int firstWarn = 10;
        @ConfigEntry.BoundedDiscrete(min = 1,max = 9)
        int secondWarn = 5;
    }

    static class toolToggles{
        @ConfigEntry.Gui.RequiresRestart
        boolean graniteTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean dioriteTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean andesiteTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean quartzTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean netherrackTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean netherbrickTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean redNetherbrickTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean sandstoneTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean redSandstoneTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean lapisTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean emeraldTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean flintTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean redstoneTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean blackstoneTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean basaltTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean endstoneTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean warpedTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean crimsonTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean amethystTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean copperTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean deepslateTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean spruceTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean birchTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean jungleTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean acaciaTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean darkOakTools = true;
    }

    static class compressedBlocks{
        @ConfigEntry.Gui.RequiresRestart
        boolean cobble = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean dirt = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean diorite = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean andesite = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean granite = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean netherrack = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean sand = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean gravel = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean deepslate = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean tuff = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean calcite = true;
    }
}