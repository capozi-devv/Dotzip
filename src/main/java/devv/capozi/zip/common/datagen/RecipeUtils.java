package devv.capozi.zip.common.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.*;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import static net.minecraft.data.recipe.RecipeGenerator.hasItem;

public class RecipeUtils extends FabricRecipeProvider {
    private RecipeUtils(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }
    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                RegistryWrapper.Impl<Item> registryWrapper = wrapperLookup.getOrThrow(Registries.ITEM.getKey());
            }
        };
    }
    @Override
    public String getName() {
        return "Dotzip Recipe Utils";
    }
    public static class Methods extends RecipeGenerator {
        protected Methods(RegistryWrapper.WrapperLookup registries, RecipeExporter exporter) {
            super(registries, exporter);
        }
        public void offerWoodSet(RecipeExporter consumer, String modid, Ingredient woodIngredient, Block planks, SlabBlock slab, PressurePlateBlock pressurePlateBlock, ButtonBlock buttonBlock, DoorBlock doorBlock, FenceBlock fenceBlock, FenceGateBlock fenceGateBlock, StairsBlock stairsBlock, TrapdoorBlock trapdoorBlock) {
            offerSlabRecipe(RecipeCategory.DECORATIONS, slab, planks);
            offerPressurePlateRecipe(pressurePlateBlock, planks);
            offerShapelessRecipe(buttonBlock, planks, modid, 1);
            createDoorRecipe(doorBlock, woodIngredient).criterion(hasItem(Items.OAK_PLANKS), conditionsFromTag(ItemTags.WOODEN_DOORS)).offerTo(consumer);
            createFenceRecipe(fenceBlock, woodIngredient).criterion(hasItem(Items.OAK_PLANKS), conditionsFromTag(ItemTags.WOODEN_FENCES)).offerTo(consumer);
            createFenceGateRecipe(fenceGateBlock, woodIngredient).criterion(hasItem(Items.OAK_PLANKS), conditionsFromTag(ItemTags.FENCE_GATES)).offerTo(consumer);
            createStairsRecipe(stairsBlock, woodIngredient).criterion(hasItem(Items.OAK_PLANKS), conditionsFromTag(ItemTags.WOODEN_STAIRS)).offerTo(consumer);
            createTrapdoorRecipe(trapdoorBlock, woodIngredient).criterion(hasItem(Items.OAK_PLANKS), conditionsFromTag(ItemTags.WOODEN_TRAPDOORS)).offerTo(consumer);
        }

        @Override
        public void generate() {
            RegistryWrapper.Impl<Item> registryWrapper = registries.getOrThrow(Registries.ITEM.getKey());
        }
    }
}
