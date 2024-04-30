package com.paulzzh.mymmm;

import com.gtnewhorizon.gtnhmixins.ILateMixinLoader;
import com.gtnewhorizon.gtnhmixins.LateMixin;
import com.paulzzh.mymmm.mixins.Mixins;

import java.util.List;
import java.util.Set;

@LateMixin
public class MyMMMMixins implements ILateMixinLoader {
    @Override
    public String getMixinConfig() {
        return "mixins.mymmm.late.json";
    }

    @Override
    public List<String> getMixins(Set<String> loadedMods) {
        return Mixins.getLateMixins(loadedMods);
    }

}
