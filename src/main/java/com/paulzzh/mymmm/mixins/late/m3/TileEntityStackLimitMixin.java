package com.paulzzh.mymmm.mixins.late.m3;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import project.studio.manametalmod.tileentity.TileEntityManaMetalInjection;

@Mixin(value = {TileEntityManaMetalInjection.class})
public class TileEntityStackLimitMixin {
    //getInventoryStackLimit
    @Inject(method = "func_70297_j_", at = @At(value = "HEAD"), cancellable = true, remap = false)
    private void injected(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(1);
    }
}
