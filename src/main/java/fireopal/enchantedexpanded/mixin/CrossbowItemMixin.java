package fireopal.enchantedexpanded.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import fireopal.enchantedexpanded.duck.DuckPersistentProjectileEntity;
import fireopal.enchantedexpanded.enchantments.EEEnchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

@Mixin(CrossbowItem.class)
public class CrossbowItemMixin {
    @Inject(method = "createArrow", at = @At("RETURN"), cancellable = true)
    private static void createArrow(World world, LivingEntity entity, ItemStack crossbow, ItemStack arrow, CallbackInfoReturnable<PersistentProjectileEntity> cir) {
        int freezingLevel = EnchantmentHelper.getLevel(EEEnchantments.FREEZING, crossbow);
        int velocityLevel = EnchantmentHelper.getLevel(EEEnchantments.VELOCITY, crossbow);
        PersistentProjectileEntity arrowEntity = cir.getReturnValue();

        if (freezingLevel != 0) {
            ((DuckPersistentProjectileEntity)arrowEntity).setFreezingLevel(freezingLevel);
            arrowEntity.setDamage(arrowEntity.getDamage() / Math.pow(2, freezingLevel));
            arrowEntity.setCritical(false);
        }

        if (velocityLevel != 0) {
            Vec3d velocity = arrowEntity.getVelocity().multiply(1 + ((double) velocityLevel / 3.0));
            ((DuckPersistentProjectileEntity) arrowEntity).setVelocityLevel(velocityLevel);

            arrowEntity.setVelocity(velocity);
            System.out.println("Velocity Arrow; Old Velocity: " + arrowEntity.getVelocity() + " | New Velocity: " + velocity);
        }

        cir.setReturnValue(arrowEntity);
    }

    @ModifyArg(
        method = "shoot(Lnet/minecraft/world/World;Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/util/Hand;Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemStack;FZFFF)V",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/ModifiableWorld;spawnEntity(Lnet/minecraft/entity/Entity;)Z"
        )
    )
    private static Entity modifyShoot(Entity projectile) {
        return projectile;
    }
}
