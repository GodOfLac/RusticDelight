package com.phantomwing.rusticdelight.datagen;

import com.phantomwing.rusticdelight.RusticDelight;
import com.phantomwing.rusticdelight.item.ItemManager;
import com.phantomwing.rusticdelight.loot.AddItemModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, RusticDelight.MOD_ID);
    }

    @Override
    protected void start() {
        // Entity loot tables
        add("calamari_from_squid", new AddItemModifier(
                new LootItemCondition[] {
                        defaultLootTable("entities/squid"),
                },
                ItemManager.CALAMARI.get(),
                1,
                2
        ));
        add("calamari_from_glow_squid", new AddItemModifier(
                new LootItemCondition[] {
                        defaultLootTable("entities/glow_squid"),
                },
                ItemManager.CALAMARI.get(),
                1,
                2
        ));
    }

    private LootItemCondition defaultLootTable(String name) {
        return new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace(name)).build();
    }
}
