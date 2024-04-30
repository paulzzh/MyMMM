package com.paulzzh.mymmm.mixins.late.m3;

import com.paulzzh.mymmm.MyMMM;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import project.studio.manametalmod.entity.nbt.ManaMetalModRoot;
import project.studio.manametalmod.hudgui.GuiHUD;
import project.studio.manametalmod.hudgui.HUDGUIType;
import project.studio.manametalmod.network.MessageSkill;
import project.studio.manametalmod.network.PacketHandlerMana;
import project.studio.manametalmod.spell.GuiSkillLV1;
import project.studio.manametalmod.spell.GuiSkillLV2;

import static project.studio.manametalmod.hudgui.GuiHUD.white;

@Mixin(value = GuiHUD.class)
public abstract class GuiHUDMixin extends GuiScreen {
    private static final ResourceLocation set_border = new ResourceLocation("mymmm:textures/gui/set_border.png");
    @Shadow(remap = false)
    public ManaMetalModRoot rootPlayer;

    @Invoker(value = "drawTexturedHUD", remap = false)
    public abstract void invokeDrawTexturedHUD(int x, int y, int u, int v, int width, int height, HUDGUIType type);

    @Invoker(value = "drawStringHUD", remap = false)
    public abstract void invokeDrawStringHUD(FontRenderer render, String text, int x, int y, int color, HUDGUIType type);

    @Inject(method = "renderSkillCD1", at = @At(value = "TAIL"), remap = false)
    public void injected(int width, int bottom_height, int x, int y, int u, int v, int data, CallbackInfo ci) {
        if (MyMMM.getSpellSET_1()[data]) {
            this.mc.getTextureManager().bindTexture(set_border);
            this.invokeDrawTexturedHUD(width + x, bottom_height + y, 0, 0, 20, 20, HUDGUIType.SurvivalFactor);
            this.mc.getTextureManager().bindTexture(GuiSkillLV1.texture2);
            if (MyMMM.getSpellSET_1_state()[data]>0 && this.rootPlayer.carrer.getSpellLV_1()[data] > 0 && this.rootPlayer.carrer.getSpellCD_LV1()[data] <= 0) {
                MyMMM.getSpellSET_1_state()[data]-=1;
                PacketHandlerMana.INSTANCE.sendToServer(new MessageSkill(100 + data));
            }
        }
        if (this.rootPlayer.carrer.getSpellLV_1()[data] > 0 && this.rootPlayer.carrer.getSpellCD_LV1()[data] > 0) {
            MyMMM.getSpellSET_1_state()[data]=10;
            //this.invokeDrawStringHUD(this.mc.fontRenderer, String.valueOf(this.rootPlayer.carrer.getSpellCD_LV1()[data]), width + x + 3, bottom_height + y, white, HUDGUIType.Skill);
            //this.mc.getTextureManager().bindTexture(GuiSkillLV1.texture2);
        }
    }

    @Inject(method = "renderSkillCD2", at = @At(value = "TAIL"), remap = false)
    public void injected2(int width, int bottom_height, int x, int y, int u, int v, int data, CallbackInfo ci) {
        if (MyMMM.getSpellSET_2()[data]) {
            this.mc.getTextureManager().bindTexture(set_border);
            this.invokeDrawTexturedHUD(width + x, bottom_height + y, 0, 0, 20, 20, HUDGUIType.SurvivalFactor);
            this.mc.getTextureManager().bindTexture(GuiSkillLV2.texture4);
            if (MyMMM.getSpellSET_2_state()[data]>0 && this.rootPlayer.carrer.getSpellLV_2()[data] > 0 && this.rootPlayer.carrer.getSpellCD_LV2()[data] <= 0) {
                MyMMM.getSpellSET_2_state()[data]-=1;
                PacketHandlerMana.INSTANCE.sendToServer(new MessageSkill(200 + data));
            }
        }
        if (this.rootPlayer.carrer.getSpellLV_2()[data] > 0 && this.rootPlayer.carrer.getSpellCD_LV2()[data] > 0) {
            MyMMM.getSpellSET_2_state()[data]=10;
            //this.invokeDrawStringHUD(this.mc.fontRenderer, String.valueOf(this.rootPlayer.carrer.getSpellCD_LV2()[data]), width + x + 3, bottom_height + y, white, HUDGUIType.Skill);
            //this.mc.getTextureManager().bindTexture(GuiSkillLV2.texture4);
        }
    }
}
