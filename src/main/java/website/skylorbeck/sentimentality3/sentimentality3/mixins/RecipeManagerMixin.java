package website.skylorbeck.sentimentality3.sentimentality3.mixins;

import com.google.gson.JsonElement;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import website.skylorbeck.sentimentality3.sentimentality3.Declarer;
import website.skylorbeck.sentimentality3.sentimentality3.Declarer;
import website.skylorbeck.sentimentality3.sentimentality3.Ref;

import java.util.Map;

@Mixin(RecipeManager.class)
public class RecipeManagerMixin {
    @Inject(method = "apply", at = @At("HEAD"))
    public void interceptApply(Map<Identifier, JsonElement> map, ResourceManager resourceManager, Profiler profiler, CallbackInfo info) {
        if (Declarer.ARROW != null) {
            map.put(new Identifier(Ref.MODID,"arrow"), Declarer.ARROW);
        }
        if (Declarer.BREAD != null) {
            map.put(new Identifier(Ref.MODID,"bread"), Declarer.BREAD);
        }
        if (Declarer.BLACKSTONE != null) {
            map.put(new Identifier(Ref.MODID,"blackstone"), Declarer.BLACKSTONE);
        }
        if (Declarer.AMETHYST != null) {
            map.put(new Identifier(Ref.MODID,"amethyst"), Declarer.AMETHYST);
        }
        if (Declarer.BLAZEROD != null) {
            map.put(new Identifier(Ref.MODID,"blazerod"), Declarer.BLAZEROD);
        }
        if (Declarer.BROWN_MUSHROOM != null) {
            map.put(new Identifier(Ref.MODID,"brown_mushroom"), Declarer.BROWN_MUSHROOM);
        }
        if (Declarer.RED_MUSHROOM != null) {
            map.put(new Identifier(Ref.MODID,"red_mushroom"), Declarer.RED_MUSHROOM);
        }
        if (Declarer.CHAINBOOT != null) {
            map.put(new Identifier(Ref.MODID,"chainboot"), Declarer.CHAINBOOT);
        }
        if (Declarer.CHAINPANT != null) {
            map.put(new Identifier(Ref.MODID,"chainpant"), Declarer.CHAINPANT);
        }
        if (Declarer.CHAINCHEST != null) {
            map.put(new Identifier(Ref.MODID,"chainchest"), Declarer.CHAINCHEST);
        }
        if (Declarer.CHAINHELM != null) {
            map.put(new Identifier(Ref.MODID,"chainhelm"), Declarer.CHAINHELM);
        }
        if (Declarer.ANDESITE_BLAST != null) {
            map.put(new Identifier(Ref.MODID,"andesite_blast"), Declarer.ANDESITE_BLAST);
        }
        if (Declarer.ANDESITE_FURNACE != null) {
            map.put(new Identifier(Ref.MODID,"andesite_furnace"), Declarer.ANDESITE_FURNACE);
        }
        if (Declarer.ANDESITE_SMOKER != null) {
            map.put(new Identifier(Ref.MODID,"andesite_smoker"), Declarer.ANDESITE_SMOKER);
        }
        if (Declarer.BLACKSTONE_BLAST != null) {
            map.put(new Identifier(Ref.MODID,"blackstone_blast"), Declarer.BLACKSTONE_BLAST);
        }
        if (Declarer.BLACKSTONE_FURNACE != null) {
            map.put(new Identifier(Ref.MODID,"blackstone_furnace"), Declarer.BLACKSTONE_FURNACE);
        }
        if (Declarer.BLACKSTONE_SMOKER != null) {
            map.put(new Identifier(Ref.MODID,"blackstone_smoker"), Declarer.BLACKSTONE_SMOKER);
        }
        if (Declarer.BASALT_BLAST != null) {
            map.put(new Identifier(Ref.MODID,"basalt_blast"), Declarer.BASALT_BLAST);
        }
        if (Declarer.BASALT_FURNACE != null) {
            map.put(new Identifier(Ref.MODID,"basalt_furnace"), Declarer.BASALT_FURNACE);
        }
        if (Declarer.BASALT_SMOKER != null) {
            map.put(new Identifier(Ref.MODID,"basalt_smoker"), Declarer.BASALT_SMOKER);
        }
    }

}
