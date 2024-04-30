package com.paulzzh.mymmm.mixins.late.m3;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import project.studio.manametalmod.tileentity.TileEntityCrystalPillars;
import project.studio.manametalmod.tileentity.TileEntityManaMetalInjection;

@Mixin(value = {TileEntityCrystalPillars.class, TileEntityManaMetalInjection.class})
public class TileEntityAccessibleMixin {
    @Inject(method = "func_94128_d", at = @At(value = "HEAD"), cancellable = true, remap = false)
    private void injected(int p_94128_1_, CallbackInfoReturnable<int[]> cir) {
        cir.setReturnValue(new int[]{0});
    }
}
