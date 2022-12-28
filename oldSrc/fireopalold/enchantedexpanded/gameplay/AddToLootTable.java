package fireopal.enchantedexpanded.gameplay;

import net.minecraft.util.Identifier;

public class AddToLootTable {
    public static final Identifier NETHER_FORTRESS_LOOT_TABLE_ID = new Identifier("chests/nether_bridge");

    public static void init() {
        // LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
        //     if (source.isBuiltin() && NETHER_FORTRESS_LOOT_TABLE_ID.equals(id)) {
        //         LootPool.Builder poolBuilder = LootPool.builder()
        //             .with(
        //                 ItemEntry.builder(Items.BOOK)
        //                     .conditionally(RandomChanceLootCondition.builder(0.2f))
        //                     .apply(new EnchantRandomlyLootFunction.Builder().add(EEEnchantments.WITHERING))
        //             );
        
        //         tableBuilder.pool(poolBuilder);
        //     }
        // });
    }
}
