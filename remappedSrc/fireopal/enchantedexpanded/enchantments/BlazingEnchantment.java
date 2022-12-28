package fireopal.enchantedexpanded.enchantments;

import eu.pb4.polymer.api.utils.PolymerObject;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class BlazingEnchantment extends Enchantment implements PolymerObject {
    protected BlazingEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.isOf(Items.FLINT_AND_STEEL);
    }

    
}
