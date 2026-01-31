package devv.capozi.zip.common.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.*;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.function.Consumer;

public class RecipeUtils extends FabricRecipeProvider {
    private RecipeUtils(FabricDataOutput output) {
        super(output);
    }
    public void offerWoodSet(Consumer<RecipeJsonProvider> consumer, String modid, Ingredient woodIngredient, Block planks, SlabBlock slab, PressurePlateBlock pressurePlateBlock, ButtonBlock buttonBlock, DoorBlock doorBlock, FenceBlock fenceBlock, FenceGateBlock fenceGateBlock, StairsBlock stairsBlock, TrapdoorBlock trapdoorBlock) {
        offerSlabRecipe(consumer, RecipeCategory.DECORATIONS, slab, planks);
        offerPressurePlateRecipe(consumer, pressurePlateBlock, planks);
        offerShapelessRecipe(consumer, buttonBlock, planks, modid, 1);
        createDoorRecipe(doorBlock, woodIngredient);
        createFenceRecipe(fenceBlock, woodIngredient);
        createFenceGateRecipe(fenceGateBlock, woodIngredient);
        createStairsRecipe(stairsBlock, woodIngredient);
        createTrapdoorRecipe(trapdoorBlock, woodIngredient);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> consumer) {

    }
}
