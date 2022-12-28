package fireopal.enchantedexpanded.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.entity.damage.DamageSource;

@Mixin(DamageSource.class)
public interface DamageSourceInvoker {

}
