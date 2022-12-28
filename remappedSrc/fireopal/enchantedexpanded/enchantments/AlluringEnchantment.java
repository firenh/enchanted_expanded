package fireopal.enchantedexpanded.enchantments;

import eu.pb4.polymer.api.utils.PolymerObject;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;

public class AlluringEnchantment extends Enchantment implements PolymerObject {
    protected AlluringEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot slotTypes) {
        super(weight, type, new EquipmentSlot[]{slotTypes});
    }

    public static int getKnockbackFactor() {
        return 2;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public boolean isTreasure() {
        return true;
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return other != Enchantments.KNOCKBACK && super.canAccept(other);
    }
}
