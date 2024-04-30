package com.paulzzh.mymmm.mixins.late.botania;

import com.paulzzh.mymmm.MyMMM;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import vazkii.botania.client.core.handler.ContributorFancinessHandler.ThreadContributorListLoader;

@Mixin(value = ThreadContributorListLoader.class)
public class ThreadContributorListLoaderMixin {
    /**
     * @author Paulzzh
     * @reason remove Contributor
     */
    @Overwrite(remap = false)
    public void run() {
        MyMMM.LOG.info("block Botania web request");
    }
}
