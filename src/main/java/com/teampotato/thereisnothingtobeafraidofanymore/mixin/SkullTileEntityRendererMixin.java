package com.teampotato.thereisnothingtobeafraidofanymore.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.block.SkullBlock;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.tileentity.SkullTileEntityRenderer;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(SkullTileEntityRenderer.class)
public abstract class SkullTileEntityRendererMixin {
    @Shadow @Final private static Map<SkullBlock.ISkullType, ResourceLocation> SKIN_BY_TYPE;

    @Inject(method = "getRenderType", at = @At("HEAD"), cancellable = true)
    private static void onGetRenderType(SkullBlock.ISkullType pSkullType, GameProfile pGameProfile, @NotNull CallbackInfoReturnable<RenderType> cir) {
        ResourceLocation id = SKIN_BY_TYPE.get(pSkullType);
        cir.setReturnValue(RenderType.entityCutoutNoCullZOffset(id));
    }
}
