package com.paulzzh.mymmm.mixins.late.m3;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import project.studio.manametalmod.Author;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Mixin(value = Author.class)
public class AuthorMixin {
    @Final
    @Shadow(remap = false)
    private static final Map<String, UUID> managers = new HashMap();

    @Inject(method = "<clinit>", at = @At(value = "TAIL"), remap = false)
    private static void injected(CallbackInfo ci) {
        managers.clear();
    }
}
