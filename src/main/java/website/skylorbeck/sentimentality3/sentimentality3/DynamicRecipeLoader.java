package website.skylorbeck.sentimentality3.sentimentality3;

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

    public static JsonObject Arrow = null;

    public static JsonObject createShapelessRecipeJson(ArrayList<Item> items, ArrayList<String> type, Identifier output, int outputCount) {
        JsonObject json = new JsonObject();
        json.addProperty("type", "minecraft:crafting_shapeless");
        JsonObject individualKey;
        JsonArray itemArray = new JsonArray();

        for (int i = 0; i < items.size(); ++i) {
            individualKey = new JsonObject();
            individualKey.addProperty(type.get(i),Registry.ITEM.getId(items.get(i)).toString());
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
    public static JsonObject createShapedRecipeJson(ArrayList<Character> keys, ArrayList<Item> items, ArrayList<String> type, ArrayList<String> pattern, Identifier output,int outputCount) {
        JsonObject json = new JsonObject();
        json.addProperty("type", "minecraft:crafting_shaped");
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(pattern.get(0));
        jsonArray.add(pattern.get(1));
        jsonArray.add(pattern.get(2));
        json.add("pattern", jsonArray);
        JsonObject individualKey;
        JsonObject keyList = new JsonObject();

        for (int i = 0; i < keys.size(); ++i) {
            individualKey = new JsonObject();
            individualKey.addProperty(type.get(i), Registry.ITEM.getId(items.get(i)).toString());
            keyList.add(keys.get(i) + "", individualKey);
        }

        json.add("key", keyList);
        JsonObject result = new JsonObject();
        result.addProperty("item", output.toString());
        result.addProperty("count", outputCount);
        json.add("result", result);
        return json;
    }
}
