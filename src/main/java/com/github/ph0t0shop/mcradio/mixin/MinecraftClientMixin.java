package com.github.ph0t0shop.mcradio.mixin;

import com.github.ph0t0shop.mcradio.MCRadio;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    @Inject(method = "<init>", at=@At("RETURN"))
    public void afterResourceLoadInject(CallbackInfo ci) {
        MCRadio.onResourceLoad();
    }
}
