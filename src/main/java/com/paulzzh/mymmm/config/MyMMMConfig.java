package com.paulzzh.mymmm.config;

import com.gtnewhorizon.gtnhlib.config.Config;

@Config(modid = "mymmm")
public class MyMMMConfig {
    @Config.Comment("How shall I greet?")
    @Config.DefaultString("Hello World")
    @Config.RequiresMcRestart
    public static String greeting;
    @Config.Comment("m3魔改")
    @Config.DefaultBoolean(true)
    @Config.RequiresMcRestart
    public static boolean m3;

    @Config.Comment("m3技能set")
    @Config.DefaultBoolean(true)
    public static boolean m3_set;
    @Config.Comment("异步/禁用minecraft数据上报")
    @Config.DefaultBoolean(true)
    @Config.RequiresMcRestart
    public static boolean mc_stat;

    @Config.Comment("异步/禁用journeymap统计")
    @Config.DefaultBoolean(true)
    @Config.RequiresMcRestart
    public static boolean journey_stat;
    @Config.Comment("异步/禁用botania贡献")
    @Config.DefaultBoolean(true)
    @Config.RequiresMcRestart
    public static boolean bot_con;
    @Config.Comment("异步/禁用Aroma1997Core赞助披风")
    @Config.DefaultBoolean(true)
    @Config.RequiresMcRestart
    public static boolean aroma_cape;
}
