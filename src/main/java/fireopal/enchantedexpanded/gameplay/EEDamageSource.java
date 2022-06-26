package fireopal.enchantedexpanded.gameplay;

import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.EntityDamageSource;

public class EEDamageSource {
    public static DamageSource atrophy(Entity target) {
        return ( new EntityDamageSource("thorns", target).setUsesMagic());
    }
}
