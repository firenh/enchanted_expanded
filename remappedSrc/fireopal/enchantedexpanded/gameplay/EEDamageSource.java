package fireopal.enchantedexpanded.gameplay;

import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.EntityDamageSource;

public class EEDamageSource {
    public static DamageSource brutality(Entity target) {
        return new EntityDamageSource("brutality", target).setBypassesProtection().setUsesMagic();
    }
}
