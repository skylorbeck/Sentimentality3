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
import website.skylorbeck.minecraft.skylorlib.Declarer;
import website.skylorbeck.minecraft.skylorlib.Registrar;
import website.skylorbeck.minecraft.skylorlib.SkylorLib;
import website.skylorbeck.sentimentality3.sentimentality3.DynamicRecipeLoader;
import website.skylorbeck.sentimentality3.sentimentality3.Ref;

import java.util.Map;

@Mixin(RecipeManager.class)
public class RecipeManagerMixin {
    @Inject(method = "apply", at = @At("HEAD"))
    public void interceptApply(Map<Identifier, JsonElement> map, ResourceManager resourceManager, Profiler profiler, CallbackInfo info) {
        if (DynamicRecipeLoader.Arrow != null) {
            map.put(new Identifier(Ref.MODID,"arrow"), DynamicRecipeLoader.Arrow);
        }
    }

}
