package com.paulzzh.mymmm.mixins;

import cpw.mods.fml.common.Mod;

public enum TargetedMod {
    VANILLA("Minecraft", null),
    BOTANIA("Botania", null, "Botania"),
    AROMA1997CORE("Aroma1997Core", null, "Aroma1997Core"),
    JOURNEYMAP("JourneyMap", null, "journeymap"),
    MMM("ManaMetalModRPG", null, "manametalmod");
    /**
     * The "name" in the {@link Mod @Mod} annotation
     */
    public final String modName;
    /**
     * Class that implements the IFMLLoadingPlugin interface
     */
    public final String coreModClass;
    /**
     * The "modid" in the {@link Mod @Mod} annotation
     */
    public final String modId;

    TargetedMod(String modName, String coreModClass) {
        this(modName, coreModClass, null);
    }

    TargetedMod(String modName, String coreModClass, String modId) {
        this.modName = modName;
        this.coreModClass = coreModClass;
        this.modId = modId;
    }

    @Override
    public String toString() {
        return "TargetedMod{modName='" + modName + "', coreModClass='" + coreModClass + "', modId='" + modId + "'}";
    }
}
