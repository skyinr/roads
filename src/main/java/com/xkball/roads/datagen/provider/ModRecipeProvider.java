package com.xkball.roads.datagen.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {
        // Add your recipes here.


    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        @NotNull
        protected RecipeProvider createRecipeProvider(HolderLookup.@NonNull Provider  registries, @NonNull RecipeOutput output) {
            return new ModRecipeProvider(registries, output);
        }

        @Override
        @NotNull
        public String getName() {
            return "Roads Recipes";
        }
    }
}
