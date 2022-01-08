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
        
        if (Declarer.ANDESITE_BLAST != null) {
            map.put(new Identifier(Ref.MODID,"andesite_blast"), Declarer.ANDESITE_BLAST);
        }
        if (Declarer.ANDESITE_FURNACE != null) {
            map.put(new Identifier(Ref.MODID,"andesite_furnace"), Declarer.ANDESITE_FURNACE);
        }
        if (Declarer.ANDESITE_SMOKER != null) {
            map.put(new Identifier(Ref.MODID,"andesite_smoker"), Declarer.ANDESITE_SMOKER);
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
