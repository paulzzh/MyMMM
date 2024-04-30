package com.paulzzh.mymmm.mixins.late.m3;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import project.studio.manametalmod.MMM;
import project.studio.manametalmod.blocks.BlockDirtBase;
import project.studio.manametalmod.blocks.BlockDirtGarden;
import project.studio.manametalmod.config.M3Config;

import java.util.Random;

@Mixin(value = BlockDirtGarden.class)
public class BlockDirtGardenMixin extends BlockDirtBase {
    public BlockDirtGardenMixin(String name) {
        super(name);
    }

    @Inject(method = "func_149674_a", at = @At(value = "HEAD"), cancellable = true, remap = false)
    private void injected(World world, int x, int y, int z, Random random, CallbackInfo ci) {
        Block block;
        if (y < 255 && y > -1 && MMM.getDimensionID(world) == M3Config.WorldGardenID && (block = world.getBlock(x, y + 1, z)) != Blocks.air) {
            if (((block instanceof IGrowable) || (block instanceof IPlantable)) && block.getTickRandomly() && hasWater(world, x, y, z)) {
                for (int s = 0; s < 8; s++) {
                    block.updateTick(world, x, y + 1, z, random);
                }
            }
        }
        ci.cancel();
    }
}
