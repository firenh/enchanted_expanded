package fireopal.enchantedexpanded.enchantments;

import fireopal.enchantedexpanded.EnchantedExpanded;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.registry.Registry;

public class EEEnchantments {
    private static Enchantment register(String id, Enchantment enchantment) {
        EnchantedExpanded.LOGGER.info("Registering Enchantment " + EnchantedExpanded.MODID + ":" + id);
        return Registry.register(Registry.ENCHANTMENT, EnchantedExpanded.id(id), enchantment);
    }

    public static void init() {
        new EEEnchantments();
    }

    public static final EquipmentSlot[] ARMOR_SLOTS = {EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};

    public static final Enchantment FROST_ASPECT = register("frost_aspect", new FrostAspectEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND));
    public static final Enchantment WITHERING = register("withering", new WitheringEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND));
    public static final Enchantment MAGIC_PROTECTION = register("magic_protection", new MagicProtectionEnchantment(Enchantment.Rarity.COMMON, EnchantmentTarget.ARMOR, ARMOR_SLOTS));
    public static final Enchantment ALLURING = register("alluring_curse", new AlluringEnchantment(Enchantment.Rarity.COMMON, EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));
    public static final Enchantment ATROPHY = register("atrophy_curse", new AtrophyEnchantment(Enchantment.Rarity.COMMON, EquipmentSlot.MAINHAND));
    public static final Enchantment HARVEST = register("harvest", new HarvestEnchantment(Enchantment.Rarity.COMMON, EquipmentSlot.MAINHAND));
    public static final Enchantment LAUNCHING = register("launching", new LaunchingEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND));
    public static final Enchantment FREEZING = register("freezing", new FreezingEnchantment(Enchantment.Rarity.RARE, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND}));
    public static final Enchantment DETINATION = register("detination", new DetinationEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));
    public static final Enchantment VELOCITY = register("velocity", new VelocityEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND}));

}
