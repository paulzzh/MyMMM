package com.paulzzh.mymmm.mixins.late.m3;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import project.studio.manametalmod.ClientProxy;

@Mixin(value = ClientProxy.class)
public class ClientProxyMixin {
    @Inject(method = "init()V", at = @At(value = "INVOKE", target = "Lorg/lwjgl/opengl/Display;setTitle(Ljava/lang/String;)V"), cancellable = true, remap = false)
    private void injected(CallbackInfo ci) {
        ci.cancel();
    }
}
