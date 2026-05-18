package com.xkball.roads.datagen;

import com.xkball.roads.Roads;
import com.xkball.roads.datagen.provider.ModItemModelProvider;
import com.xkball.roads.datagen.provider.ModLanguageProvider;
import com.xkball.roads.datagen.provider.ModRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Roads.MODID)
public class ModDatagen {
    @SubscribeEvent
    public static void gatherDataClient(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        // Client Datagen
        generator.addProvider(true, new ModItemModelProvider(packOutput, Roads.MODID));
        generator.addProvider(true, new ModLanguageProvider(packOutput, Roads.MODID, "zh_ch"));

        // Server Datagen
        generator.addProvider(true, new ModRecipeProvider.Runner(packOutput, lookupProvider));
    }
}
