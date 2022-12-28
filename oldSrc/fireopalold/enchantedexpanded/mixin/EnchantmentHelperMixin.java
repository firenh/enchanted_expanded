package fireopal.enchantedexpanded.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import fireopal.enchantedexpanded.enchantments.AlluringEnchantment;
import fireopal.enchantedexpanded.enchantments.EEEnchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;

@Mixin(EnchantmentHelper.class)
public class EnchantmentHelperMixin {
    @Inject(method = "getKnockback", at = @At("RETURN"), cancellable = true)
    private static void getKnockback(LivingEntity entity, CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(
            cir.getReturnValue() - (AlluringEnchantment.getKnockbackFactor() * EnchantmentHelper.getEquipmentLevel(EEEnchantments.ALLURING, entity))
        );
    }
}
