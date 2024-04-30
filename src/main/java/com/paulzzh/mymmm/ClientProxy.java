package com.paulzzh.mymmm;

import com.paulzzh.mymmm.event.EventClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.input.Keyboard;

public class ClientProxy extends CommonProxy {

    // Override CommonProxy methods here, if you want a different behaviour on the client (e.g. registering renders).
    // Don't forget to call the super methods as well.
    public static KeyBinding keyToggleSet = new KeyBinding("切换SET功能是否启用(PCR里那个打勾)", Keyboard.KEY_TAB, "mymmm");

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        ClientRegistry.registerKeyBinding(keyToggleSet);
        FMLCommonHandler.instance().bus().register(new EventClient());
        MinecraftForge.EVENT_BUS.register(new EventClient());
    }
}
