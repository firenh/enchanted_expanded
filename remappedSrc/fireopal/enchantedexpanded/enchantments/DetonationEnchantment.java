package fireopal.enchantedexpanded.enchantments;

import eu.pb4.polymer.api.utils.PolymerObject;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.explosion.Explosion;

public class DetonationEnchantment extends Enchantment implements PolymerObject {
    protected DetonationEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot slotTypes) {
        super(weight, type, new EquipmentSlot[]{slotTypes});
    }

    public static int getKnockbackFactor() {
        return 2;
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
    public boolean isAvailableForEnchantedBookOffer() {
        return false;
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return false;
    }

    @Override
    public boolean isCursed() {
        return true;
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return false;
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() == Items.GOLDEN_SWORD;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        target.world.createExplosion(null, target.getX(), target.getBodyY(0.0625), target.getZ(), level, Explosion.DestructionType.BREAK);
        user.getMainHandStack().damage(Integer.MAX_VALUE, user.getRandom(), user instanceof ServerPlayerEntity ? (ServerPlayerEntity) user : null);
    }
}
