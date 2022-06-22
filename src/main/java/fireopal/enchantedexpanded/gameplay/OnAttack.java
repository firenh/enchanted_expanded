package fireopal.enchantedexpanded.gameplay;

import fireopal.enchantedexpanded.enchantments.EEEnchantments;
import fireopal.enchantedexpanded.enchantments.FrostAspectEnchantment;
import fireopal.enchantedexpanded.enchantments.WitheringEnchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

public class OnAttack {
    public static void onAttack(LivingEntity attacker, Entity target) {
        frostAspect(attacker, target);
        withering(attacker, target);
    }

    private static void frostAspect(LivingEntity attacker, Entity target) {
        int frostAspectLevel = EnchantmentHelper.getEquipmentLevel(EEEnchantments.FROST_ASPECT, attacker);
        
        if (frostAspectLevel > 0) {
            int frozenTicks = FrostAspectEnchantment.getFrozenTicks(frostAspectLevel);

            if (frozenTicks > target.getFrozenTicks()) target.setFrozenTicks(frozenTicks);
            FrostAspectEnchantment.spawnFrozenParticles(target, target.getEntityWorld());
        }
    }

    private static void withering(LivingEntity attacker, Entity target) {
        int level = EnchantmentHelper.getEquipmentLevel(EEEnchantments.WITHERING, attacker);
        
        if (level > 0) {
            WitheringEnchantment.effect(level, attacker, target);
        }
    }
}
