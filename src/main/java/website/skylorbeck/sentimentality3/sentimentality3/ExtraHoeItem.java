package website.skylorbeck.sentimentality3.sentimentality3;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;

public class ExtraHoeItem extends HoeItem {//Hoe is protected for some reason
    protected ExtraHoeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
