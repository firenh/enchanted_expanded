package fireopal.enchantedexpanded.enchantments;

import eu.pb4.polymer.api.utils.PolymerObject;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EquipmentSlot;

public class BrutalityEnchantment extends Enchantment implements PolymerObject {
    protected BrutalityEnchantment(Rarity weight, EquipmentSlot slotTypes) {
        super(weight, EnchantmentTarget.WEAPON, new EquipmentSlot[]{slotTypes});
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public boolean isTreasure() {
        return false;
    }

    @Override
    public float getAttackDamage(int level, EntityGroup group) {
        return level * 2.5f;
    }

    @Override
    public int getMinPower(int level) {
        return 10 + (level - 1) * 4;
    }

    @Override
    public int getMaxPower(int level) {
        return this.getMinPower(level) + 15;
    }
}
