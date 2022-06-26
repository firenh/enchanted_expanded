package fireopal.enchantedexpanded.enchantments;

import eu.pb4.polymer.api.utils.PolymerObject;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;

public class HarvestEnchantment extends Enchantment implements PolymerObject {
    protected HarvestEnchantment(Rarity weight, EquipmentSlot slotTypes) {
        super(weight, EnchantmentTarget.DIGGER, new EquipmentSlot[]{slotTypes});
    }

    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof HoeItem;
    }
}
