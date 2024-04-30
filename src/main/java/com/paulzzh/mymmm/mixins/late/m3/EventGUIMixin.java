package com.paulzzh.mymmm.mixins.late.m3;

import com.paulzzh.mymmm.MyMMM;
import com.paulzzh.mymmm.config.MyMMMConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import project.studio.manametalmod.ClientProxy;
import project.studio.manametalmod.MMM;
import project.studio.manametalmod.core.CareerCore;
import project.studio.manametalmod.entity.nbt.ManaMetalModRoot;
import project.studio.manametalmod.event.EventGUI;

@Mixin(value = EventGUI.class)
public class EventGUIMixin {
    @Redirect(method = "onKeyInput", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/settings/KeyBinding;func_151468_f()Z"), remap = false)
    public boolean injected(KeyBinding instance) {
        boolean pressed = instance.isPressed();
        if (!MyMMMConfig.m3_set) {
            MyMMM.setSpellSET_1(new boolean[]{false, false, false, false, false, false, false});
            MyMMM.setSpellSET_2(new boolean[]{false, false, false, false, false, false, false});
            return pressed;
        }
        if (pressed) {
            setset(instance == ClientProxy.keySkill1, 0);
            setset(instance == ClientProxy.keySkill2, 1);
            setset(instance == ClientProxy.keySkill3, 2);
            setset(instance == ClientProxy.keySkill4, 3);
            setset(instance == ClientProxy.keySkill5, 4);
            setset(instance == ClientProxy.keySkill6, 5);
            setset(instance == ClientProxy.keySkill7, 6);
        }
        return pressed;
    }

    public void setset(boolean isPressed, int i) {
        if (isPressed) {
            EntityPlayer player = Minecraft.getMinecraft().thePlayer;
            ManaMetalModRoot root = MMM.getEntityNBT(player);
            int data = root.carrer.getSpellKey()[i] % 100;
            int lv = root.carrer.getSpellKey()[i] / 100;
            if (lv == 1 && root.carrer.getSpellLV_1()[data] > 0 && root.carrer.getSpellCD_LV1()[data] > 0) {
                if (MyMMM.toggleSpellSET_1(data)) {
                    MyMMM.getSpellSET_1_state()[data]=10;
                    player.addChatComponentMessage(new ChatComponentText("立即发动 一转技能: " + MMM.getTranslateText("Skill.name_" + data + "_" + CareerCore.getPlayerCarrer(root).toString() + "_1")));
                }
            }
            if (lv == 2 && root.carrer.getSpellLV_2()[data] > 0 && root.carrer.getSpellCD_LV2()[data] > 0) {
                if (MyMMM.toggleSpellSET_2(data)) {
                    MyMMM.getSpellSET_2_state()[data]=10;
                    player.addChatComponentMessage(new ChatComponentText("立即发动 二转技能: " + MMM.getTranslateText("Skill.name_" + data + "_" + CareerCore.getPlayerCarrer(root).toString() + "_2")));
                }
            }
        }
    }
}
