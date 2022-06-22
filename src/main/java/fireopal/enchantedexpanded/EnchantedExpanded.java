package fireopal.enchantedexpanded;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fireopal.enchantedexpanded.enchantments.EEEnchantments;
import fireopal.enchantedexpanded.gameplay.AddToLootTable;

public class EnchantedExpanded implements ModInitializer {
	public static final String MODID = "enchanted_expanded";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {
		EEEnchantments.init();
		AddToLootTable.init();
		LOGGER.info("Expanding Enchantments... Done!");
	}

	public static Identifier id(String id) {
		return new Identifier(MODID, id);
	}
}
