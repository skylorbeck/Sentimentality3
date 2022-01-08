package website.skylorbeck.sentimentality3.sentimentality3;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.item.Item;
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
            individualKey.addProperty(type.get(i)?"tag":"item",items.get(i).toString());
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

    public static JsonObject createShapedRecipeJson(ArrayList<Identifier> items, ArrayList<Boolean> type, ArrayList<String> pattern, Identifier output,int outputCount) {
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
            individualKey.addProperty(type.get(i)?"tag":"item",items.get(i).toString());
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
    public static JsonObject createShapedRecipeJsonComplex(ArrayList<String[]> items,ArrayList<ArrayList<Boolean>> type, ArrayList<String> pattern, Identifier output,int outputCount) {
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
                jsonObject.addProperty(type.get(i).get(j)?"tag":"item",items.get(i)[j]);
                jsonArray.add(jsonObject);
            }
            keyList.add(i + "",jsonArray);
        }

        json.add("key", keyList);
        JsonObject result = new JsonObject();
        result.addProperty("item", output.toString());
        result.addProperty("count", outputCount);
        json.add("result", result);
        //Logger.getAnonymousLogger().log(Level.SEVERE,json.toString());
        return json;
    }
}
