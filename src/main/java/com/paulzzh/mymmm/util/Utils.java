package com.paulzzh.mymmm.util;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class Utils {
    public static boolean areStacksEqual(ItemStack aStack1, ItemStack aStack2) {
        return areStacksEqual(aStack1, aStack2, false);
    }

    public static boolean areStacksEqual(ItemStack aStack1, ItemStack aStack2, boolean aIgnoreNBT) {
        return aStack1 != null && aStack2 != null
            && aStack1.getItem() == aStack2.getItem()
            && (aIgnoreNBT || (((aStack1.getTagCompound() == null) == (aStack2.getTagCompound() == null))
            && (aStack1.getTagCompound() == null || aStack1.getTagCompound()
            .equals(aStack2.getTagCompound()))))
            && (Items.feather.getDamage(aStack1) == Items.feather.getDamage(aStack2)
            || Items.feather.getDamage(aStack1) == OreDictionary.WILDCARD_VALUE
            || Items.feather.getDamage(aStack2) == OreDictionary.WILDCARD_VALUE);
    }
}
