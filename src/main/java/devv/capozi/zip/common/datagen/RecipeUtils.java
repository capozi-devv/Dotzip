package devv.capozi.zip.common.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.*;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;

import java.util.function.Consumer;

public class RecipeUtils extends FabricRecipeProvider {
    private RecipeUtils(FabricDataOutput output) {
        super(output);
    }
    public static void offerWoodSet(Consumer<RecipeJsonProvider> consumer, String modid, Ingredient woodIngredient, Block planks, SlabBlock slab, PressurePlateBlock pressurePlateBlock, ButtonBlock buttonBlock, DoorBlock doorBlock, FenceBlock fenceBlock, FenceGateBlock fenceGateBlock, StairsBlock stairsBlock, TrapdoorBlock trapdoorBlock) {
        offerSlabRecipe(consumer, RecipeCategory.DECORATIONS, slab, planks);
        offerPressurePlateRecipe(consumer, pressurePlateBlock, planks);
        offerShapelessRecipe(consumer, buttonBlock, planks, modid, 1);
        createDoorRecipe(doorBlock, woodIngredient).criterion(hasItem(Items.OAK_PLANKS), conditionsFromTag(ItemTags.WOODEN_DOORS)).offerTo(consumer);
        createFenceRecipe(fenceBlock, woodIngredient).criterion(hasItem(Items.OAK_PLANKS), conditionsFromTag(ItemTags.WOODEN_FENCES)).offerTo(consumer);
        createFenceGateRecipe(fenceGateBlock, woodIngredient).criterion(hasItem(Items.OAK_PLANKS), conditionsFromTag(ItemTags.FENCE_GATES)).offerTo(consumer);
        createStairsRecipe(stairsBlock, woodIngredient).criterion(hasItem(Items.OAK_PLANKS), conditionsFromTag(ItemTags.WOODEN_STAIRS)).offerTo(consumer);
        createTrapdoorRecipe(trapdoorBlock, woodIngredient).criterion(hasItem(Items.OAK_PLANKS), conditionsFromTag(ItemTags.WOODEN_TRAPDOORS)).offerTo(consumer);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> consumer) {

    }
}
