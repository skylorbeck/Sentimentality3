package website.skylorbeck.sentimentality3.sentimentality3;

import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

public class ExtraAxeItem extends AxeItem {//Axe is protected for some reason
    protected ExtraAxeItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
