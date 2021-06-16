package website.skylorbeck.sentimentality3.sentimentality3;

import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class ExtraPickaxeItem extends PickaxeItem {//Pickaxe is protected for some reason
    protected ExtraPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
