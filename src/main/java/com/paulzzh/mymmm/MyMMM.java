package com.paulzzh.mymmm;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(
    modid = MyMMM.MODID,
    version = Tags.VERSION,
    name = "MyMMM",
    acceptedMinecraftVersions = "[1.7.10]",
    acceptableRemoteVersions = "*",
    dependencies = " required-after:gtnhlib@[0.2.1,);",
    guiFactory = "com.paulzzh.mymmm.config.MyMMMGuiConfigFactory"
)
public class MyMMM {

    public static final String MODID = "mymmm";
    public static final Logger LOG = LogManager.getLogger(MODID);
    @SidedProxy(clientSide = "com.paulzzh.mymmm.ClientProxy", serverSide = "com.paulzzh.mymmm.CommonProxy")
    public static CommonProxy proxy;
    private static boolean[] spellSET_1 = {false, false, false, false, false, false, false};
    private static boolean[] spellSET_2 = {false, false, false, false, false, false, false};
    private static int[] spellSET_1_state = {0, 0, 0, 0, 0, 0, 0};
    private static int[] spellSET_2_state = {0, 0, 0, 0, 0, 0, 0};

    public static int[] getSpellSET_1_state() {
        return spellSET_1_state;
    }

    public static int[] getSpellSET_2_state() {
        return spellSET_2_state;
    }

    public static boolean[] getSpellSET_1() {
        return spellSET_1;
    }

    public static void setSpellSET_1(boolean[] var) {
        spellSET_1 = var;
    }

    public static boolean[] getSpellSET_2() {
        return spellSET_2;
    }

    public static void setSpellSET_2(boolean[] var) {
        spellSET_2 = var;
    }

    public static boolean toggleSpellSET_1(int data) {
        spellSET_1[data] = !spellSET_1[data];
        return spellSET_1[data];
    }

    public static boolean toggleSpellSET_2(int data) {
        spellSET_2[data] = !spellSET_2[data];
        return spellSET_2[data];
    }

    @Mod.EventHandler
    // preInit "Run before anything else. Read your config, create blocks, items, etc, and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    // load "Do your mod setup. Build whatever data structures you care about. Register recipes." (Remove if not needed)
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Mod.EventHandler
    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {
        proxy.serverStarting(event);
    }
}
