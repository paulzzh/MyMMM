package com.paulzzh.mymmm.config;

import com.gtnewhorizon.gtnhlib.config.ConfigException;
import com.gtnewhorizon.gtnhlib.config.SimpleGuiConfig;
import net.minecraft.client.gui.GuiScreen;

public class MyMMMGuiConfig extends SimpleGuiConfig {
    public MyMMMGuiConfig(GuiScreen parent) throws ConfigException {
        super(parent, MyMMMConfig.class, "mymmm", "MyMMM");
    }
}
