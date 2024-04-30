package com.paulzzh.mymmm.mixins.late.m3;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import project.studio.manametalmod.api.MoneySourceType;
import project.studio.manametalmod.entity.nbt.ManaMetalModRoot;
import project.studio.manametalmod.network.MessageManaPawnshopBuy;
import project.studio.manametalmod.tileentity.TileEntityManaPawnshop;

@Mixin(value = MessageManaPawnshopBuy.class)
public class MessageManaPawnshopBuyMixin {
    @Inject(method = "onMessage(Lproject/studio/manametalmod/network/MessageManaPawnshopBuy;Lcpw/mods/fml/common/network/simpleimpl/MessageContext;)Lcpw/mods/fml/common/network/simpleimpl/IMessage;",
        at = @At(value = "INVOKE", target = "Lproject/studio/manametalmod/tileentity/TileEntityManaPawnshop;func_70302_i_()I",
            shift = At.Shift.AFTER),
        cancellable = true, remap = false, locals = LocalCapture.CAPTURE_FAILHARD)
    private void injected(MessageManaPawnshopBuy message, MessageContext ctx, CallbackInfoReturnable<IMessage> cir, EntityPlayerMP player, TileEntity tile_entity, TileEntityManaPawnshop tile, int type, ManaMetalModRoot root, int addmoney, int data, MoneySourceType MST, int s) {
        if (tile.sellMoney != 0) {
            if (root.money.addMoney(tile.sellMoney, MST)) {
                tile.sellMoney = 0;
                tile.update_data();
            }
            int c = player.worldObj.rand.nextInt(3);
            player.worldObj.playSoundAtEntity(player, "manametalmod:item.coin" + c, 1.0f, ((player.worldObj.rand.nextFloat() - player.worldObj.rand.nextFloat()) * 0.2f) + 1.0f);
        }
        cir.setReturnValue(null);
    }
}
