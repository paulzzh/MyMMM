package com.paulzzh.mymmm.mixins.late.journeymap;

import com.paulzzh.mymmm.MyMMM;
import modinfo.mp.v1.Client;
import modinfo.mp.v1.Message;
import modinfo.mp.v1.Payload;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.concurrent.Future;

@Mixin(value = Client.class)
public class ClientMixin {
    /**
     * @author Paulzzh
     * @reason remove stat
     */
    @Overwrite(remap = false)
    public Future send(Payload payload, final Message.Callback callback) {
        MyMMM.LOG.info("block Journeymap web request");
        return null;
    }
}
