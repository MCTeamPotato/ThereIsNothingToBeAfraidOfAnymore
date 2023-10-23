package com.teampotato.thereisnothingtobeafraidofanymore.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.SkullTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SkullTileEntity.class)
public abstract class SkullTileEntityMixin extends TileEntity {
    public SkullTileEntityMixin(TileEntityType<?> p_i48289_1_) {
        super(p_i48289_1_);
    }

    @Inject(method = "save", at = @At("HEAD"), cancellable = true)
    private void onSave(CompoundNBT pCompound, @NotNull CallbackInfoReturnable<CompoundNBT> cir) {
        cir.setReturnValue(super.save(pCompound));
    }

    @Inject(method = "load", at = @At(value = "INVOKE", target = "Lnet/minecraft/tileentity/TileEntity;load(Lnet/minecraft/block/BlockState;Lnet/minecraft/nbt/CompoundNBT;)V", shift = At.Shift.AFTER), cancellable = true)
    private void onLoadIn(BlockState p_230337_1_, CompoundNBT p_230337_2_, @NotNull CallbackInfo ci) {
        ci.cancel();
    }

    @Inject(method = "updateGameprofile", at = @At("HEAD"), cancellable = true)
    private static void onUpdateGameProfile(GameProfile p_174884_0_, @NotNull CallbackInfoReturnable<GameProfile> cir) {
        cir.setReturnValue(null);
    }
}
