package com.paulzzh.mymmm.event;

import com.paulzzh.mymmm.ClientProxy;
import com.paulzzh.mymmm.MyMMM;
import com.paulzzh.mymmm.config.MyMMMConfig;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import project.studio.manametalmod.MMM;


public class EventClient {
    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onEvent(KeyInputEvent event) {
        if (ClientProxy.keyToggleSet.isPressed()) {
            MyMMMConfig.m3_set = !MyMMMConfig.m3_set;
            if (MyMMMConfig.m3_set) {
                Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("启用立即发动"));
            } else {
                Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("关闭立即发动"));
            }
        }
    }
}
