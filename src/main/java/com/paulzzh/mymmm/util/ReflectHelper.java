package com.paulzzh.mymmm.util;

import net.minecraft.item.ItemStack;

import java.lang.reflect.Method;

public class ReflectHelper {
    private static final Class<?> SlotSell;
    private static final Method SlotSell_cansell;

    static {
        try {
            SlotSell = reflectClass("project.studio.manametalmod.inventory.SlotSell");
            SlotSell_cansell = reflectMethod(SlotSell, "cansell", ItemStack.class, int.class);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to initialize M3 reflection hacks!", e);
        }
    }

    public static Class<?> reflectClass(String name) throws ClassNotFoundException {
        return Class.forName(name);
    }

    public static Method reflectMethod(Class<?> owner, String name, Class<?>... paramTypes)
        throws NoSuchMethodException {
        Method m = owner.getDeclaredMethod(name, paramTypes);
        m.setAccessible(true);
        return m;
    }

    public static Object invokeStatic(Method m, Object... args) {
        try {
            return m.invoke(null, args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean SlotSell_cansell(ItemStack item, int type) {
        return (Boolean) invokeStatic(SlotSell_cansell, item, type);
    }
}
