package fireopal.enchantedexpanded.enchantments;

import eu.pb4.polymer.api.utils.PolymerObject;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EquipmentSlot;

public class AtrophyEnchantment extends Enchantment implements PolymerObject {
    protected AtrophyEnchantment(Rarity weight, EquipmentSlot slotTypes) {
        super(weight, EnchantmentTarget.WEAPON, new EquipmentSlot[]{slotTypes});
    }
    
    @Override
    public boolean isCursed() {
        return true;
    }

    @Override
    public int getMaxLevel() {
        return 4;
    }

    @Override
    public boolean isTreasure() {
        return true;
    }

    @Override
    public float getAttackDamage(int level, EntityGroup group) {
        return level;
    }
}
