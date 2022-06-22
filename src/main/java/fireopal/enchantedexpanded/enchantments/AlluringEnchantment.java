package fireopal.enchantedexpanded.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class AlluringEnchantment extends Enchantment {
    protected AlluringEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot slotTypes) {
        super(weight, type, new EquipmentSlot[]{slotTypes});
    }

    public static int getKnockbackFactor() {
        return 2;
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return false;
    }
}
