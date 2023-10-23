package com.teampotato.thereisnothingtobeafraidofanymore.mixin;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SkullItem;
import net.minecraft.item.WallOrFloorItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SkullItem.class)
public abstract class SkullItemMixin extends WallOrFloorItem {
    public SkullItemMixin(Block pStandingBlock, Block pWallBlock, Properties pProperties) {
        super(pStandingBlock, pWallBlock, pProperties);
    }

    @Inject(method = "getName", at = @At("HEAD"), cancellable = true)
    private void onGetName(ItemStack pStack, @NotNull CallbackInfoReturnable<ITextComponent> cir) {
        cir.setReturnValue(super.getName(pStack));
    }

    @Inject(method = "verifyTagAfterLoad", at = @At("HEAD"), cancellable = true)
    private void onVerify(CompoundNBT compoundNBT, @NotNull CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(super.verifyTagAfterLoad(compoundNBT));
    }
}
