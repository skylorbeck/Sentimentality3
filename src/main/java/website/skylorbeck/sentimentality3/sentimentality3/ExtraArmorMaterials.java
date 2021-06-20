package website.skylorbeck.sentimentality3.sentimentality3;


import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ExtraArmorMaterials implements ArmorMaterial {
    WOOL("wool",3,new int[]{1,2,3,1},25,SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,0.0f,0.0f,()->{//low durability to prevent use as alternative to leather
        return Ingredient.ofItems(
                Items.BLACK_WOOL,
                Items.WHITE_WOOL,
                Items.BLUE_WOOL,
                Items.BROWN_WOOL,
                Items.CYAN_WOOL,
                Items.GRAY_WOOL,
                Items.GREEN_WOOL,
                Items.LIME_WOOL,
                Items.MAGENTA_WOOL,
                Items.ORANGE_WOOL,
                Items.PINK_WOOL,
                Items.PURPLE_WOOL,
                Items.RED_WOOL,
                Items.YELLOW_WOOL,
                Items.LIGHT_BLUE_WOOL,
                Items.LIGHT_GRAY_WOOL
        );
    }),
    COPPER("copper",10,new int[]{1,4,5,2},15,SoundEvents.ITEM_ARMOR_EQUIP_IRON,0.0f,0.0f,()->{//Chainmail defense, durability between leather and chain, enchantability of leather
        return Ingredient.ofItems(
                Items.COPPER_INGOT
        );
    });

    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Lazy<Ingredient> repairIngredientSupplier;

    ExtraArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = new Lazy(repairIngredientSupplier);
    }
    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return this.protectionAmounts[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredientSupplier.get();
    }
    @Environment(EnvType.CLIENT)
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
            return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
