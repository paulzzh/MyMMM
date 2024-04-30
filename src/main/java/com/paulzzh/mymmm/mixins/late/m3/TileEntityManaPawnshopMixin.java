package com.paulzzh.mymmm.mixins.late.m3;

import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import project.studio.manametalmod.MMM;
import project.studio.manametalmod.core.TileEntityUpdate;
import project.studio.manametalmod.tileentity.TileEntityManaPawnshop;

import static com.paulzzh.mymmm.util.ReflectHelper.SlotSell_cansell;

@Mixin(value = TileEntityManaPawnshop.class)
public abstract class TileEntityManaPawnshopMixin extends TileEntityUpdate {
    @Shadow(remap = false)
    public int sellMoney;
    @Shadow(remap = false)
    ItemStack[] items;

    @Shadow(remap = false)
    public abstract void setAllClear();

    //getAccessibleSlotsFromSide
    @Inject(method = "func_94128_d", at = @At(value = "HEAD"), cancellable = true, remap = false)
    private void injected(int p_94128_1_, CallbackInfoReturnable<int[]> cir) {
        cir.setReturnValue(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});
    }

    //isItemValidForSlot
    @Inject(method = "func_94041_b", at = @At(value = "HEAD"), cancellable = true, remap = false)
    private void injected3(int slot, ItemStack itemstack, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(SlotSell_cansell(itemstack, getBlockMetadata()));
    }

    //canInsertItem
    @Inject(method = "func_102007_a", at = @At(value = "HEAD"), cancellable = true, remap = false)
    private void injected4(int slot, ItemStack item, int face, CallbackInfoReturnable<Boolean> cir) {
        /*if (SlotSell_cansell(item,getBlockMetadata())) {
            if (item != null && slot < items.length && (items[slot] == null || areStacksEqual(items[slot], item))) {
                cir.setReturnValue(true);
                return;
            }
        }
        cir.setReturnValue(false);*/
        cir.setReturnValue(SlotSell_cansell(item, getBlockMetadata()));
    }

    @Inject(method = "func_145845_h", at = @At(value = "RETURN"), remap = false)
    private void injected5(CallbackInfo ci) {
        if (sellMoney >= 2000000000) {
            return;
        }
        int addmoney = 0;
        for (int s = 0; s < items.length; s++) {
            if (items[s] != null) {
                long temp = MMM.getItemStackMoneyValue(items[s]) * multiplier(getBlockMetadata());
                addmoney = (int) (addmoney + temp);
            }
        }
        if (addmoney != 0) {
            sellMoney += addmoney;
            update_data();
            setAllClear();
        }
    }

    private int multiplier(int type) {
        switch (type) {
            case 0:
                return 2;
            case 1:
                return 5;
            case 2:
                return 3;
            case 3:
                return 15;
            case 4:
                return 3;
            case 5:
                return 3;
            case 6:
                return 8;
            case 7:
                return 10;
            default:
                return 1;
        }
    }
}
