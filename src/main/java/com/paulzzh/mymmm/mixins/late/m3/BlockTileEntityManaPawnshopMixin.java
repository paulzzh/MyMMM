package com.paulzzh.mymmm.mixins.late.m3;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import project.studio.manametalmod.blocks.BlockTileEntityManaPawnshop;
import project.studio.manametalmod.itemAndBlockCraft.ItemCraft10;
import project.studio.manametalmod.tileentity.TileEntityManaPawnshop;

import static project.studio.manametalmod.MMM.spawnItemInWorld;

@Mixin(value = BlockTileEntityManaPawnshop.class)
public class BlockTileEntityManaPawnshopMixin {
    //breakBlock
    @Inject(method = "func_149749_a", at = @At(value = "INVOKE", target = "Lproject/studio/manametalmod/MMM;dropTileEntityItems(Lnet/minecraft/world/World;III)V"), remap = false)
    private void injected(World world, int x, int y, int z, Block p_149749_5_, int p_149749_6_, CallbackInfo ci) {
        TileEntity te = world.getTileEntity(x, y, z);
        if (te instanceof TileEntityManaPawnshop) {
            long money = ((TileEntityManaPawnshop) te).sellMoney;
            if (money > 0) {
                ItemStack item = new ItemStack(ItemCraft10.ItemMoneybags, 1, 0);
                NBTTagCompound tag = new NBTTagCompound();
                tag.setLong("money", money);
                item.setTagCompound(tag);
                spawnItemInWorld(world, item, x + 0.5f, y + 0.5f, z + 0.5f);
            }
        }
    }
}
