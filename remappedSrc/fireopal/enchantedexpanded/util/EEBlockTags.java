package fireopal.enchantedexpanded.util;

import fireopal.enchantedexpanded.EnchantedExpanded;
import net.minecraft.block.Block;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.TagKey;

public class EEBlockTags {
    private static TagKey<Block> of(String id) {
        return TagKey.of(Registry.BLOCK_KEY, EnchantedExpanded.id(id));
    }

    public static final TagKey<Block> MELTS_FREEZING_ARROWS = of("melts_freezing_arrows");
    
}
