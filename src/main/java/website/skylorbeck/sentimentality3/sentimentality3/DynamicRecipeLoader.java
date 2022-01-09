package website.skylorbeck.sentimentality3.sentimentality3;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DynamicRecipeLoader {
    //todo abstract this to skylib
    public static JsonObject createShapelessRecipeJson(ArrayList<Identifier> items, ArrayList<Boolean> type, Identifier output, int outputCount) {
        JsonObject json = new JsonObject();
        json.addProperty("type", "minecraft:crafting_shapeless");
        JsonObject individualKey;
        JsonArray itemArray = new JsonArray();

        for (int i = 0; i < items.size(); ++i) {
            individualKey = new JsonObject();
            individualKey.addProperty(type.get(i) ? "tag" : "item", items.get(i).toString());
            itemArray.add(individualKey);
        }

        json.add("ingredients", itemArray);
        JsonObject result = new JsonObject();
        result.addProperty("item", output.toString());
        result.addProperty("count", outputCount);
        json.add("result", result);
//        Logger.getAnonymousLogger().log(Level.SEVERE,json.toString());
        return json;
    }

    public enum furnaceTypes{
        smelting,
        smoking,
        blasting
    }
    public static JsonObject createSmeltingRecipeJson(Item item, Item output,float experience, int cookTime,furnaceTypes furnaceType) {
        JsonObject json = new JsonObject();
        json.addProperty("type", "minecraft:"+furnaceType);
        JsonObject individualKey;
        individualKey = new JsonObject();
        individualKey.addProperty( "item",Registry.ITEM.getId(item).toString());
        json.add("ingredient", individualKey);
        json.addProperty("result", Registry.ITEM.getId(output).toString());
        json.addProperty("experience",experience);
        json.addProperty("cookingtime",furnaceType.equals(furnaceTypes.smelting)?cookTime:cookTime/2);
        Logger.getAnonymousLogger().log(Level.SEVERE, json.toString());
        return json;
    }

    public static JsonObject createSmeltingRecipeJsonComplex(Item[] items, Item output,float experience, int cookTime,furnaceTypes furnaceType) {
        JsonObject json = new JsonObject();
        json.addProperty("type", "minecraft:"+furnaceType);
        JsonObject individualKey;
        JsonArray itemArray = new JsonArray();
        for (Item item : items) {
            individualKey = new JsonObject();
            individualKey.addProperty("item", Registry.ITEM.getId(item).toString());
            itemArray.add(individualKey);
        }
        json.add("ingredient", itemArray);
        json.addProperty("result", Registry.ITEM.getId(output).toString());
        json.addProperty("experience",experience);
        json.addProperty("cookingtime",furnaceType.equals(furnaceTypes.smelting)?cookTime:cookTime/2);
        Logger.getAnonymousLogger().log(Level.SEVERE, json.toString());
        return json;
    }

    public static JsonObject createShapedRecipeJson(ArrayList<Identifier> items, ArrayList<Boolean> type, ArrayList<String> pattern, Identifier output, int outputCount) {
        JsonObject json = new JsonObject();
        json.addProperty("type", "minecraft:crafting_shaped");
        JsonArray jsonArray = new JsonArray();
        for (String s : pattern) {
            jsonArray.add(s);
        }
        json.add("pattern", jsonArray);
        JsonObject individualKey;
        JsonObject keyList = new JsonObject();

        for (int i = 0; i < items.size(); ++i) {
            individualKey = new JsonObject();
            individualKey.addProperty(type.get(i) ? "tag" : "item", items.get(i).toString());
            keyList.add(i + "", individualKey);
        }

        json.add("key", keyList);
        JsonObject result = new JsonObject();
        result.addProperty("item", output.toString());
        result.addProperty("count", outputCount);
        json.add("result", result);
        //Logger.getAnonymousLogger().log(Level.SEVERE,json.toString());
        return json;
    }

    public static JsonObject createShapedRecipeJsonComplex(ArrayList<String[]> items, ArrayList<ArrayList<Boolean>> type, ArrayList<String> pattern, Identifier output, int outputCount) {
        JsonObject json = new JsonObject();
        json.addProperty("type", "minecraft:crafting_shaped");
        JsonArray jsonArray = new JsonArray();
        for (String s : pattern) {
            jsonArray.add(s);
        }
        json.add("pattern", jsonArray);
        JsonObject keyList = new JsonObject();

        for (int i = 0; i < items.size(); ++i) {
            jsonArray = new JsonArray();
            for (int j = 0; j < items.get(i).length; j++) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty(type.get(i).get(j) ? "tag" : "item", items.get(i)[j]);
                jsonArray.add(jsonObject);
            }
            keyList.add(i + "", jsonArray);
        }

        json.add("key", keyList);
        JsonObject result = new JsonObject();
        result.addProperty("item", output.toString());
        result.addProperty("count", outputCount);
        json.add("result", result);
        //Logger.getAnonymousLogger().log(Level.SEVERE,json.toString());
        return json;
    }

    public static JsonObject createFurnace(String tag, Item expectedItem) {
        return createShapedRecipeJson(
                Lists.newArrayList(new Identifier(Ref.MODID, tag)),//items
                Lists.newArrayList(true),//type
                Lists.newArrayList("000", "0 0", "000"),//pattern
                Registry.ITEM.getId(expectedItem),
                1);
    }

    public static JsonObject createBlast(String tag, Item originalItem, Item expectedItem) {
        return createShapedRecipeJson(
                Lists.newArrayList(Registry.ITEM.getId(Items.IRON_INGOT), Registry.ITEM.getId(originalItem), new Identifier(Ref.MODID, tag)),//items
                Lists.newArrayList(false, false, true),//type
                Lists.newArrayList("000", "010", "222"),//pattern
                Registry.ITEM.getId(expectedItem),
                1
        );
    }

    public static JsonObject createSmoker(Item originalItem, Item expectedItem) {
        return createShapedRecipeJson(
                Lists.newArrayList(Registry.ITEM.getId(originalItem), new Identifier("minecraft", "logs")),//items
                Lists.newArrayList(false, true),//type
                Lists.newArrayList(" 1 ", "101", " 1 "),//pattern
                Registry.ITEM.getId(expectedItem),
                1
        );
    }
}