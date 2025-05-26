package darkbum.saltymod.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.gtnewhorizon.gtnhmixins.IEarlyMixinLoader;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

@SuppressWarnings("unused")
@IFMLLoadingPlugin.MCVersion("1.7.10")
public class EarlyMixinLoader implements IEarlyMixinLoader, IFMLLoadingPlugin {

    @Override
    public String getMixinConfig() {
        return "mixins.saltymod.early.json";
    }

    @Override
    public List<String> getMixins(Set<String> loadedCoreMods) {
        final List<String> mixins = new ArrayList<>();
//        mixins.add("minecraft.MixinGuiMultiplayer");
        return mixins;
    }

    @Override
    public String[] getASMTransformerClass() {
        return null;
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {}

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
