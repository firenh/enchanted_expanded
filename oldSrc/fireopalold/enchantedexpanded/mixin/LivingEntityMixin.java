// package fireopal.enchantedexpanded.mixin;

// import org.spongepowered.asm.mixin.Mixin;
// import org.spongepowered.asm.mixin.injection.At;
// import org.spongepowered.asm.mixin.injection.Inject;
// import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// import net.minecraft.entity.LivingEntity;
// import net.minecraft.entity.mob.MobEntity;

// @Mixin(LivingEntity.class)
// public class LivingEntityMixin {
//     @Inject(
//         method = "tick",
//         at = @At("TAIL"),
//         cancellable = true
//     )  
//     private void tick(CallbackInfo ci) {
//         if (!((((LivingEntity) (Object) this) instanceof MobEntity || ((LivingEntity) (Object) this) instanceof MobEntity))) ci.cancel();

//         int growthLevel = 0;

//         if (((LivingEntity) (Object) this) instanceof MobEntity) {
//             ((MobEntity) (LivingEntity) (Object) this).getArmorItems().forEach(null);
//         }
//     }
// }
