package com.paulzzh.mymmm.mixins.early.minecraft;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value = Minecraft.class)
public class MinecraftMixin {
    /**
     * @author Paulzzh
     * @reason remove Snooper
     */
    @Overwrite
    public boolean isSnooperEnabled() {
        return false;
    }
}
