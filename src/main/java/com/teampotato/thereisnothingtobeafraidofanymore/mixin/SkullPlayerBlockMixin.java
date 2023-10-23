package com.teampotato.thereisnothingtobeafraidofanymore.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.SkullPlayerBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@Mixin(SkullPlayerBlock.class)
public class SkullPlayerBlockMixin {
    @Inject(method = "setPlacedBy", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/SkullBlock;setPlacedBy(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;)V", shift = At.Shift.AFTER), cancellable = true)
    private void onSetPlacedBy(World pLevel, BlockPos pPos, BlockState pState, LivingEntity pPlacer, ItemStack pStack, CallbackInfo ci) {
        ci.cancel();
    }
}
