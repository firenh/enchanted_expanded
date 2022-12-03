package fireopal.enchantedexpanded.gameplay;

import fireopal.enchantedexpanded.enchantments.EEEnchantments;
import fireopal.enchantedexpanded.enchantments.FrostAspectEnchantment;
import fireopal.enchantedexpanded.enchantments.WitheringEnchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;

public class OnAttack {
    public static void onAttack(LivingEntity attacker, Entity target) {
        frostAspect(attacker, target);
        withering(attacker, target);
        alluring(attacker, target);
        atrophy(attacker, target);
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

    private static void alluring(LivingEntity attacker, Entity target) {
        int level = EnchantmentHelper.getEquipmentLevel(EEEnchantments.ALLURING, attacker);
        
        if (level > 0 && target instanceof LivingEntity && ((LivingEntity) target).hurtTime == 0) {
            ((LivingEntity)target).takeKnockback(0.75 + level * 0.75f, -MathHelper.sin(attacker.getYaw() * ((float)Math.PI / 180)), MathHelper.cos(attacker.getYaw() * ((float)Math.PI / 180)));
        }
    }

    private static void atrophy(LivingEntity attacker, Entity target) {
        int level = EnchantmentHelper.getEquipmentLevel(EEEnchantments.ATROPHY, attacker);

        if (level > 0 && target instanceof LivingEntity && ((LivingEntity) target).hurtTime == 0) {
            attacker.damage(EEDamageSource.atrophy(attacker), level);
        }
    }
}
