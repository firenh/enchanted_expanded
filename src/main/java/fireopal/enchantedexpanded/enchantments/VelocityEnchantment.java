package fireopal.enchantedexpanded.enchantments;

import eu.pb4.polymer.core.api.utils.PolymerObject;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;

public class VelocityEnchantment extends Enchantment implements PolymerObject {
    protected VelocityEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
    }
    
    @Override
    public int getMaxLevel() {
        return 4;
    }

    @Override
    public int getMinPower(int level) {
        return 10 + (level - 1) * 7;
    }

    @Override
    public int getMaxPower(int level) {
        return this.getMinPower(level) + 10;
    }

    @Override
    public boolean canAccept(Enchantment other) {
        return other != Enchantments.PIERCING || other != Enchantments.MULTISHOT || other != Enchantments.QUICK_CHARGE; 
    }
}
