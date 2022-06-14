package website.skylorbeck.minecraft.sentimentality3;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
@Environment(EnvType.CLIENT)

public class ModImpl implements ModMenuApi {
    public String getModId() {
        return "sentimentality3";
    }


        @Override
        public ConfigScreenFactory<?> getModConfigScreenFactory() {
            return parent -> AutoConfig.getConfigScreen(ModConfig.class, parent).get();
        }
}