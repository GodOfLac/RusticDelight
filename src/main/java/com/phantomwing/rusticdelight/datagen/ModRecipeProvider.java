package com.phantomwing.rusticdelight.datagen;

import com.phantomwing.rusticdelight.RusticDelight;
import com.phantomwing.rusticdelight.item.ModItems;
import com.phantomwing.rusticdelight.tags.CommonTags;
import com.phantomwing.rusticdelight.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.crafting.CompoundIngredient;
import net.neoforged.neoforge.common.crafting.DataComponentIngredient;
import net.neoforged.neoforge.common.crafting.DifferenceIngredient;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;
import vectorwing.farmersdelight.data.recipe.CookingRecipes;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public static final float FOOD_COOKING_EXP = 0.35f;

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput output) {
        buildCraftingRecipes(output);
        buildCuttingRecipes(output);
        buildCookingRecipes(output);
    }

    private void buildCraftingRecipes(@NotNull RecipeOutput output) {
        // Bell pepper foods
        foodCookingRecipes(output, ModItems.BELL_PEPPER_GREEN, ModItems.ROASTED_BELL_PEPPER_GREEN, FOOD_COOKING_EXP);
        foodCookingRecipes(output, ModItems.BELL_PEPPER_YELLOW, ModItems.ROASTED_BELL_PEPPER_YELLOW, FOOD_COOKING_EXP);
        foodCookingRecipes(output, ModItems.BELL_PEPPER_RED, ModItems.ROASTED_BELL_PEPPER_RED, FOOD_COOKING_EXP);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.BELL_PEPPER_SOUP, 1)
                .requires(Items.BOWL)
                .requires(CommonTags.FOODS_BELL_PEPPER)
                .requires(CommonTags.FOODS_BELL_PEPPER)
                .requires(CommonTags.FOODS_BELL_PEPPER)
                .requires(CommonTags.FOODS_BELL_PEPPER)
                .requires(CommonTags.FOODS_BELL_PEPPER)
                .requires(CommonTags.FOODS_BELL_PEPPER)
                .unlockedBy(getHasName(ModItems.BELL_PEPPER_RED), has(ModItems.BELL_PEPPER_RED))
                .unlockedBy(getHasName(ModItems.BELL_PEPPER_GREEN), has(ModItems.BELL_PEPPER_GREEN))
                .unlockedBy(getHasName(ModItems.BELL_PEPPER_YELLOW), has(ModItems.BELL_PEPPER_YELLOW))
                .save(output);

        // Calamari
        foodCookingRecipes(output, ModItems.CALAMARI, ModItems.COOKED_CALAMARI, FOOD_COOKING_EXP);
        foodCookingRecipes(output, ModItems.CALAMARI_SLICE, ModItems.COOKED_CALAMARI_SLICE, FOOD_COOKING_EXP);

        // Rolls
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CALAMARI_ROLL, 2)
                .requires(ModItems.CALAMARI_SLICE)
                .requires(ModItems.CALAMARI_SLICE)
                .requires(vectorwing.farmersdelight.common.registry.ModItems.COOKED_RICE.get())
                .unlockedBy(getHasName(ModItems.CALAMARI_SLICE), has(ModItems.CALAMARI_SLICE))
                .unlockedBy(getHasName(vectorwing.farmersdelight.common.registry.ModItems.COOKED_RICE.get()), has(vectorwing.farmersdelight.common.registry.ModItems.COOKED_RICE.get()))
                .save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHERRY_BLOSSOM_ROLL, 2)
                .requires(ModTags.Items.CHERRY_BLOSSOM_INGREDIENTS)
                .requires(ModTags.Items.CHERRY_BLOSSOM_INGREDIENTS)
                .requires(vectorwing.farmersdelight.common.registry.ModItems.COOKED_RICE.get())
                .unlockedBy(getHasName(Items.PINK_PETALS), has(Items.PINK_PETALS))
                .unlockedBy(getHasName(Items.CHERRY_SAPLING), has(Items.CHERRY_SAPLING))
                .unlockedBy(getHasName(Items.CHERRY_LEAVES), has(Items.CHERRY_LEAVES))
                .unlockedBy(getHasName(vectorwing.farmersdelight.common.registry.ModItems.COOKED_RICE.get()), has(vectorwing.farmersdelight.common.registry.ModItems.COOKED_RICE.get()))
                .save(output);

        // Potato
        foodCookingRecipes(output, ModItems.POTATO_SLICES, ModItems.BAKED_POTATO_SLICES, FOOD_COOKING_EXP);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.POTATO_SALAD, 1)
                .requires(Items.BOWL)
                .requires(CommonTags.FOODS_POTATO)
                .requires(CommonTags.FOODS_ONION)
                .requires(CommonTags.FOODS_MILK)
                .requires(Tags.Items.EGGS)
                .unlockedBy(getHasName(Items.POTATO), has(Items.POTATO))
                .unlockedBy(getHasName(ModItems.POTATO_SLICES), has(ModItems.POTATO_SLICES))
                .save(output);

        // Cookies
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHERRY_BLOSSOM_COOKIE, 8)
                .requires(Items.WHEAT)
                .requires(Items.WHEAT)
                .requires(ModTags.Items.CHERRY_BLOSSOM_INGREDIENTS)
                .unlockedBy(getHasName(Items.PINK_PETALS), has(Items.PINK_PETALS))
                .unlockedBy(getHasName(Items.CHERRY_SAPLING), has(Items.CHERRY_SAPLING))
                .unlockedBy(getHasName(Items.CHERRY_LEAVES), has(Items.CHERRY_LEAVES))
                .save(output);

        // Pies
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.CHERRY_BLOSSOM_CHEESECAKE.get(), 1)
                .pattern("ccc")
                .pattern("mmm")
                .pattern("sOs")
                .define('c', ModTags.Items.CHERRY_BLOSSOM_INGREDIENTS)
                .define('s', Items.SUGAR)
                .define('m', CommonTags.FOODS_MILK)
                .define('O', vectorwing.farmersdelight.common.registry.ModItems.PIE_CRUST.get())
                .unlockedBy(getHasName(vectorwing.farmersdelight.common.registry.ModItems.PIE_CRUST.get()), has(vectorwing.farmersdelight.common.registry.ModItems.PIE_CRUST.get()))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.CHERRY_BLOSSOM_CHEESECAKE.get(), 1)
                .pattern("##")
                .pattern("##")
                .define('#', ModItems.CHERRY_BLOSSOM_CHEESECAKE_SLICE.get())
                .unlockedBy(getHasName(ModItems.CHERRY_BLOSSOM_CHEESECAKE_SLICE), has(ModItems.CHERRY_BLOSSOM_CHEESECAKE_SLICE))
                .save(output, ResourceLocation.fromNamespaceAndPath(RusticDelight.MOD_ID, "cherry_blossom_cheesecake_from_slices"));

        // Pancakes
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.HONEY_PANCAKES, 1)
                .pattern("XHX")
                .pattern("SBS")
                .pattern("XYX")
                .define('S', Items.SWEET_BERRIES)
                .define('H', Items.HONEY_BOTTLE)
                .define('X', Items.SUGAR)
                .define('B', ModItems.BATTER)
                .define('Y', Items.BOWL)
                .unlockedBy(getHasName(ModItems.BATTER), has(ModItems.BATTER))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.CHOCOLATE_PANCAKES, 1)
                .pattern("XMX")
                .pattern("CBC")
                .pattern("XYX")
                .define('C', Items.COCOA_BEANS)
                .define('M', CommonTags.FOODS_MILK)
                .define('X', Items.SUGAR)
                .define('B', ModItems.BATTER)
                .define('Y', Items.BOWL)
                .unlockedBy(getHasName(ModItems.BATTER), has(ModItems.BATTER))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.CHERRY_BLOSSOM_PANCAKES, 1)
                .pattern("XMX")
                .pattern("PBP")
                .pattern("XYX")
                .define('P', ModTags.Items.CHERRY_BLOSSOM_INGREDIENTS)
                .define('M', CommonTags.FOODS_MILK)
                .define('X', Items.SUGAR)
                .define('B', ModItems.BATTER)
                .define('Y', Items.BOWL)
                .unlockedBy(getHasName(ModItems.BATTER), has(ModItems.BATTER))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.VEGETABLE_PANCAKES, 1)
                .pattern("LVL")
                .pattern("VBV")
                .pattern("LYL")
                .define('L', CommonTags.FOODS_LEAFY_GREEN)
                .define('V', vegetablesPatch())
                .define('B', ModItems.BATTER)
                .define('Y', Items.BOWL)
                .unlockedBy(getHasName(ModItems.BATTER), has(ModItems.BATTER))
                .save(output);

        // Cotton
        oneToOne(output, RecipeCategory.MISC, ModItems.COTTON_BOLL, Items.STRING, 1);
        horizontalRecipe(output, RecipeCategory.MISC, ModItems.COTTON_BOLL, Items.PAPER, 3);
        twoBytwo(output, RecipeCategory.MISC, ModItems.COTTON_BOLL, vectorwing.farmersdelight.common.registry.ModItems.CANVAS.get(), 1);
        storageItemRecipes(output, RecipeCategory.MISC, ModItems.COTTON_SEEDS, ModItems.COTTON_SEEDS_BAG);
        storageItemRecipes(output, RecipeCategory.MISC, ModItems.COTTON_BOLL, ModItems.COTTON_BOLL_CRATE);

        // Bell peppers
        oneToOne(output, RecipeCategory.MISC, ModItems.BELL_PEPPER_GREEN, Items.GREEN_DYE, 1);
        oneToOne(output, RecipeCategory.MISC, ModItems.BELL_PEPPER_YELLOW, Items.YELLOW_DYE, 1);
        oneToOne(output, RecipeCategory.MISC, ModItems.BELL_PEPPER_RED, Items.RED_DYE, 1);
        storageItemRecipes(output, RecipeCategory.MISC, ModItems.BELL_PEPPER_SEEDS, ModItems.BELL_PEPPER_SEEDS_BAG);
        storageItemRecipes(output, RecipeCategory.MISC, ModItems.BELL_PEPPER_GREEN, ModItems.BELL_PEPPER_GREEN_CRATE);
        storageItemRecipes(output, RecipeCategory.MISC, ModItems.BELL_PEPPER_YELLOW, ModItems.BELL_PEPPER_YELLOW_CRATE);
        storageItemRecipes(output, RecipeCategory.MISC, ModItems.BELL_PEPPER_RED, ModItems.BELL_PEPPER_RED_CRATE);

        // Coffee
        storageItemRecipes(output, RecipeCategory.MISC, ModItems.COFFEE_BEANS, ModItems.COFFEE_BEANS_BAG);
        oneToOne(output, RecipeCategory.MISC, ModItems.COFFEE_BEANS, Items.YELLOW_DYE, 1);
        foodCookingRecipes(output, ModItems.COFFEE_BEANS, ModItems.ROASTED_COFFEE_BEANS, FOOD_COOKING_EXP);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.GOLDEN_COFFEE_BEANS, 1)
                .pattern("GGG")
                .pattern("GCG")
                .pattern("GGG")
                .define('G', Items.GOLD_NUGGET)
                .define('C', ModItems.ROASTED_COFFEE_BEANS)
                .unlockedBy(getHasName(ModItems.COFFEE_BEANS), has(ModItems.COFFEE_BEANS))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.MILK_COFFEE, 1)
                .requires(ModItems.COFFEE)
                .requires(CommonTags.FOODS_MILK)
                .unlockedBy(getHasName(ModItems.COFFEE), has(ModItems.COFFEE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHOCOLATE_COFFEE, 1)
                .requires(ModItems.MILK_COFFEE)
                .requires(Items.COCOA_BEANS)
                .requires(Items.COCOA_BEANS)
                .unlockedBy(getHasName(ModItems.MILK_COFFEE), has(ModItems.MILK_COFFEE))
                .save(output, getRecipeName(ModItems.MILK_COFFEE, ModItems.CHOCOLATE_COFFEE));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHOCOLATE_COFFEE, 1)
                .requires(ModItems.COFFEE)
                .requires(CommonTags.FOODS_MILK)
                .requires(Items.COCOA_BEANS)
                .requires(Items.COCOA_BEANS)
                .unlockedBy(getHasName(ModItems.COFFEE), has(ModItems.COFFEE))
                .save(output, getRecipeName(ModItems.COFFEE, ModItems.CHOCOLATE_COFFEE));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.HONEY_COFFEE, 1)
                .requires(ModItems.MILK_COFFEE)
                .requires(Items.HONEY_BOTTLE)
                .requires(Items.SUGAR)
                .unlockedBy(getHasName(ModItems.MILK_COFFEE), has(ModItems.MILK_COFFEE))
                .save(output, getRecipeName(ModItems.MILK_COFFEE, ModItems.HONEY_COFFEE));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.HONEY_COFFEE, 1)
                .requires(ModItems.COFFEE)
                .requires(CommonTags.FOODS_MILK)
                .requires(Items.HONEY_BOTTLE)
                .requires(Items.SUGAR)
                .unlockedBy(getHasName(ModItems.COFFEE), has(ModItems.COFFEE))
                .save(output, getRecipeName(ModItems.COFFEE, ModItems.HONEY_COFFEE));
    }

    private void buildCuttingRecipes(@NotNull RecipeOutput output) {
        // Cotton
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ModItems.WILD_COTTON), Ingredient.of(CommonTags.TOOLS_KNIFE), ModItems.COTTON_SEEDS, 1)
                .addResultWithChance(ModItems.COTTON_BOLL, 0.3F)
                .addResultWithChance(Items.WHITE_DYE, 0.1F)
                .build(output, ModItems.WILD_COTTON.getId());

        // Bell pepper
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ModItems.WILD_BELL_PEPPERS), Ingredient.of(CommonTags.TOOLS_KNIFE), ModItems.BELL_PEPPER_SEEDS, 1)
                .addResultWithChance(ModItems.BELL_PEPPER_RED, 0.3F)
                .addResultWithChance(Items.RED_DYE, 0.1F)
                .build(output, ModItems.WILD_BELL_PEPPERS.getId());

        // Coffee
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ModItems.WILD_COFFEE), Ingredient.of(CommonTags.TOOLS_KNIFE), ModItems.COFFEE_BEANS, 1)
                .addResultWithChance(ModItems.COFFEE_BEANS, 0.3F)
                .addResultWithChance(Items.YELLOW_DYE, 0.1F)
                .build(output, ModItems.WILD_COFFEE.getId());

        // Food
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(Items.POTATO), Ingredient.of(CommonTags.TOOLS_KNIFE), ModItems.POTATO_SLICES, 2)
                .build(output, ModItems.POTATO_SLICES.getId());
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(Items.BAKED_POTATO), Ingredient.of(CommonTags.TOOLS_KNIFE), ModItems.POTATO_SLICES, 2)
                .build(output, ModItems.BAKED_POTATO_SLICES.getId());
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ModItems.CALAMARI), Ingredient.of(CommonTags.TOOLS_KNIFE), ModItems.CALAMARI_SLICE, 2)
                .addResult(Items.BONE_MEAL)
                .build(output, ModItems.CALAMARI_SLICE.getId());
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ModItems.COOKED_CALAMARI), Ingredient.of(CommonTags.TOOLS_KNIFE), ModItems.COOKED_CALAMARI_SLICE, 2)
                .addResult(Items.BONE_MEAL)
                .build(output, ModItems.COOKED_CALAMARI_SLICE.getId());

        // Salvaging
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ItemTags.WOOL), Ingredient.of(Tags.Items.TOOLS_SHEAR), Items.STRING, 2)
                .build(output, ResourceLocation.fromNamespaceAndPath(RusticDelight.MOD_ID, "wool"));
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ItemTags.WOOL_CARPETS), Ingredient.of(Tags.Items.TOOLS_SHEAR), Items.STRING, 1)
                .build(output, ResourceLocation.fromNamespaceAndPath(RusticDelight.MOD_ID, "wool_carpet"));
    }

    private void buildCookingRecipes(@NotNull RecipeOutput output) {
        // Cooking oil
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.COOKING_OIL, 2, CookingRecipes.FAST_COOKING, CookingRecipes.SMALL_EXP, Items.GLASS_BOTTLE)
                .addIngredient(ModTags.Items.COOKING_OIL_INGREDIENTS)
                .addIngredient(ModTags.Items.COOKING_OIL_INGREDIENTS)
                .addIngredient(ModTags.Items.COOKING_OIL_INGREDIENTS)
                .addIngredient(ModTags.Items.COOKING_OIL_INGREDIENTS)
                .addIngredient(ModTags.Items.COOKING_OIL_INGREDIENTS)
                .addIngredient(ModTags.Items.COOKING_OIL_INGREDIENTS)
                .unlockedByAnyIngredient(ModItems.COTTON_SEEDS)
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .save(output, ModItems.COOKING_OIL.getId());

        // Batter
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.BATTER, 2, CookingRecipes.FAST_COOKING, CookingRecipes.SMALL_EXP, Items.BOWL)
                .addIngredient(CommonTags.FOODS_MILK)
                .addIngredient(Tags.Items.EGGS)
                .addIngredient(Items.WHEAT)
                .addIngredient(Items.WHEAT)
                .unlockedByAnyIngredient(Items.MILK_BUCKET, vectorwing.farmersdelight.common.registry.ModItems.MILK_BOTTLE.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .save(output, ModItems.BATTER.getId());

        // Spring Rolls
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.SPRING_ROLLS, 2, CookingRecipes.FAST_COOKING, CookingRecipes.MEDIUM_EXP)
                .addIngredient(ModTags.Items.COOKING_OIL)
                .addIngredient(CommonTags.FOODS_DOUGH)
                .addIngredient(CommonTags.FOODS_LEAFY_GREEN)
                .addIngredient(vectorwing.farmersdelight.common.tag.ModTags.CABBAGE_ROLL_INGREDIENTS)
                .unlockedByAnyIngredient(ModItems.COOKING_OIL)
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .save(output, ModItems.SPRING_ROLLS.getId());

        // Fruit Beignet
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.FRUIT_BEIGNET, 1, CookingRecipes.FAST_COOKING, CookingRecipes.MEDIUM_EXP)
                .addIngredient(ModTags.Items.COOKING_OIL)
                .addIngredient(CommonTags.FOODS_DOUGH)
                .addIngredient(Tags.Items.FOODS_FRUIT)
                .addIngredient(Items.SUGAR)
                .unlockedByAnyIngredient(ModItems.COOKING_OIL)
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .save(output, ModItems.FRUIT_BEIGNET.getId());

        // Fried Calamari
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.FRIED_CALAMARI, 1, CookingRecipes.NORMAL_COOKING, CookingRecipes.MEDIUM_EXP, Items.BOWL)
                .addIngredient(ModTags.Items.COOKING_OIL)
                .addIngredient(ModItems.BATTER)
                .addIngredient(CommonTags.FOODS_RAW_CALAMARI)
                .addIngredient(CommonTags.FOODS_TOMATO)
                .unlockedByAnyIngredient(ModItems.COOKING_OIL)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(output, ModItems.FRIED_CALAMARI.getId());

        // Fried Chicken
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.FRIED_CHICKEN, 1, CookingRecipes.NORMAL_COOKING, CookingRecipes.MEDIUM_EXP, Items.BOWL)
                .addIngredient(ModTags.Items.COOKING_OIL)
                .addIngredient(ModItems.BATTER)
                .addIngredient(CommonTags.FOODS_RAW_CHICKEN)
                .addIngredient(CommonTags.FOODS_ONION)
                .unlockedByAnyIngredient(ModItems.COOKING_OIL)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(output, ModItems.FRIED_CHICKEN.getId());

        // Fried Mushrooms
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.FRIED_MUSHROOMS, 1, CookingRecipes.NORMAL_COOKING, CookingRecipes.MEDIUM_EXP, Items.BOWL)
                .addIngredient(ModTags.Items.COOKING_OIL)
                .addIngredient(Items.BROWN_MUSHROOM)
                .addIngredient(Items.RED_MUSHROOM)
                .addIngredient(CommonTags.FOODS_ONION)
                .unlockedByAnyIngredient(ModItems.COOKING_OIL)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(output, ModItems.FRIED_MUSHROOMS.getId());

        // Fried Rice (Override)
        CookingPotRecipeBuilder.cookingPotRecipe(vectorwing.farmersdelight.common.registry.ModItems.FRIED_RICE.get(), 1, CookingRecipes.NORMAL_COOKING, CookingRecipes.MEDIUM_EXP, Items.BOWL)
                .addIngredient(vectorwing.farmersdelight.common.registry.ModItems.RICE.get())
                .addIngredient(CompoundIngredient.of(Ingredient.of(Tags.Items.EGGS), Ingredient.of(ModTags.Items.COOKING_OIL)))
                .addIngredient(CommonTags.FOODS_CARROT)
                .addIngredient(CommonTags.FOODS_ONION)
                .unlockedByAnyIngredient(vectorwing.farmersdelight.common.registry.ModItems.RICE.get(), Items.EGG, Items.CARROT, vectorwing.farmersdelight.common.registry.ModItems.ONION.get(), ModItems.COOKING_OIL)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(output);

        // Fried Egg (Alternative)
        CookingPotRecipeBuilder.cookingPotRecipe(vectorwing.farmersdelight.common.registry.ModItems.FRIED_EGG.get(), 1, CookingRecipes.FAST_COOKING, CookingRecipes.SMALL_EXP)
                .addIngredient(Items.EGG)
                .addIngredient(ModTags.Items.COOKING_OIL)
                .unlockedByAnyIngredient(ModItems.COOKING_OIL)
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .save(output, getRecipeName(ModItems.COOKING_OIL, vectorwing.farmersdelight.common.registry.ModItems.FRIED_EGG.get()));

        // Bell Pepper Soup
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.BELL_PEPPER_SOUP, 1, CookingRecipes.NORMAL_COOKING, CookingRecipes.MEDIUM_EXP, Items.BOWL)
                .addIngredient(CommonTags.FOODS_BELL_PEPPER)
                .addIngredient(CommonTags.FOODS_BELL_PEPPER)
                .addIngredient(CommonTags.FOODS_BELL_PEPPER)
                .addIngredient(CommonTags.FOODS_BELL_PEPPER)
                .unlockedByAnyIngredient(ModItems.BELL_PEPPER_GREEN, ModItems.BELL_PEPPER_YELLOW, ModItems.BELL_PEPPER_RED)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(output, ModItems.BELL_PEPPER_SOUP.getId());

        // Stuffed Bell Peppers
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.STUFFED_BELL_PEPPER_GREEN, 1, CookingRecipes.NORMAL_COOKING, CookingRecipes.MEDIUM_EXP)
                .addIngredient(ModItems.BELL_PEPPER_GREEN)
                .addIngredient(CommonTags.CROPS_RICE)
                .addIngredient(stuffedBellPepperFilling())
                .unlockedByAnyIngredient(ModItems.BELL_PEPPER_GREEN)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(output, ModItems.STUFFED_BELL_PEPPER_GREEN.getId());
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.STUFFED_BELL_PEPPER_YELLOW, 1, CookingRecipes.NORMAL_COOKING, CookingRecipes.MEDIUM_EXP)
                .addIngredient(ModItems.BELL_PEPPER_YELLOW)
                .addIngredient(CommonTags.CROPS_RICE)
                .addIngredient(stuffedBellPepperFilling())
                .unlockedByAnyIngredient(ModItems.BELL_PEPPER_YELLOW)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(output, ModItems.STUFFED_BELL_PEPPER_YELLOW.getId());
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.STUFFED_BELL_PEPPER_RED, 1, CookingRecipes.NORMAL_COOKING, CookingRecipes.MEDIUM_EXP)
                .addIngredient(ModItems.BELL_PEPPER_RED)
                .addIngredient(CommonTags.CROPS_RICE)
                .addIngredient(stuffedBellPepperFilling())
                .unlockedByAnyIngredient(ModItems.BELL_PEPPER_RED)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(output, ModItems.STUFFED_BELL_PEPPER_RED.getId());

        // Bell Pepper Pasta
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.BELL_PEPPER_PASTA, 1, CookingRecipes.NORMAL_COOKING, CookingRecipes.MEDIUM_EXP, Items.BOWL)
                .addIngredient(CommonTags.FOODS_PASTA)
                .addIngredient(ModItems.BELL_PEPPER_GREEN)
                .addIngredient(ModItems.BELL_PEPPER_YELLOW)
                .addIngredient(ModItems.BELL_PEPPER_RED)
                .unlockedByAnyIngredient(ModItems.BELL_PEPPER_GREEN, ModItems.BELL_PEPPER_YELLOW, ModItems.BELL_PEPPER_RED)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(output, ModItems.BELL_PEPPER_PASTA.getId());

        // Coffee
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.COFFEE, 1, CookingRecipes.NORMAL_COOKING, CookingRecipes.MEDIUM_EXP, Items.GLASS_BOTTLE)
                .addIngredient(waterIngredient())
                .addIngredient(ModItems.ROASTED_COFFEE_BEANS, 3)
                .unlockedByAnyIngredient(ModItems.ROASTED_COFFEE_BEANS)
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(output, ModItems.COFFEE.getId());

        // Milk Coffee
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.MILK_COFFEE, 1, CookingRecipes.NORMAL_COOKING, CookingRecipes.MEDIUM_EXP, Items.GLASS_BOTTLE)
                .addIngredient(CommonTags.FOODS_MILK)
                .addIngredient(ModItems.ROASTED_COFFEE_BEANS, 3)
                .unlockedByAnyIngredient(ModItems.ROASTED_COFFEE_BEANS)
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(output, ModItems.MILK_COFFEE.getId());

        // Chocolate Coffee
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.CHOCOLATE_COFFEE, 1, CookingRecipes.NORMAL_COOKING, CookingRecipes.MEDIUM_EXP, Items.GLASS_BOTTLE)
                .addIngredient(CommonTags.FOODS_MILK)
                .addIngredient(ModItems.ROASTED_COFFEE_BEANS, 3)
                .addIngredient(Items.COCOA_BEANS, 2)
                .unlockedByAnyIngredient(ModItems.ROASTED_COFFEE_BEANS)
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(output, ModItems.CHOCOLATE_COFFEE.getId());

        // Honey Coffee
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.HONEY_COFFEE, 1, CookingRecipes.NORMAL_COOKING, CookingRecipes.MEDIUM_EXP, Items.GLASS_BOTTLE)
                .addIngredient(CommonTags.FOODS_MILK)
                .addIngredient(ModItems.ROASTED_COFFEE_BEANS, 3)
                .addIngredient(Items.HONEY_BOTTLE, 1)
                .addIngredient(Items.SUGAR, 1)
                .unlockedByAnyIngredient(ModItems.ROASTED_COFFEE_BEANS)
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(output, ModItems.HONEY_COFFEE.getId());

        // Dark Coffee
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.DARK_COFFEE, 1, CookingRecipes.SLOW_COOKING, CookingRecipes.MEDIUM_EXP, Items.GLASS_BOTTLE)
                .addIngredient(waterIngredient())
                .addIngredient(ModItems.ROASTED_COFFEE_BEANS, 5)
                .unlockedByAnyIngredient(ModItems.ROASTED_COFFEE_BEANS)
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(output, ModItems.DARK_COFFEE.getId());

        // Coffee-Braised Beef
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.COFFEE_BRAISED_BEEF, 1, CookingRecipes.SLOW_COOKING, CookingRecipes.MEDIUM_EXP, Items.BOWL)
                .addIngredient(CommonTags.FOODS_RAW_BEEF)
                .addIngredient(ModItems.COFFEE)
                .addIngredient(CommonTags.FOODS_CARROT)
                .addIngredient(CommonTags.FOODS_POTATO)
                .unlockedByAnyIngredient(ModItems.COFFEE)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(output, ModItems.COFFEE_BRAISED_BEEF.getId());
    }

    protected static void oneToOne(RecipeOutput recipeOutput, RecipeCategory category, ItemLike item, ItemLike result, int count) {
        ShapelessRecipeBuilder.shapeless(category, result, count)
                .requires(item)
                .unlockedBy(getHasName(item), has(item))
                .save(recipeOutput, getRecipeName(item, result));
    }

    protected static void horizontalRecipe(RecipeOutput recipeOutput, RecipeCategory category, ItemLike item, ItemLike result, int count) {
        ShapedRecipeBuilder.shaped(category, result, count)
                .pattern("###")
                .define('#', item)
                .unlockedBy(getHasName(item), has(item))
                .save(recipeOutput, getRecipeName(item, result));
    }

    protected static void twoBytwo(RecipeOutput recipeOutput, RecipeCategory category, ItemLike item, ItemLike result, int count) {
        ShapedRecipeBuilder.shaped(category, result, count)
                .pattern("##")
                .pattern("##")
                .define('#', item)
                .unlockedBy(getHasName(item), has(item))
                .save(recipeOutput, getRecipeName(item, result));
    }

    protected static void storageItemRecipes(RecipeOutput recipeOutput, RecipeCategory category, ItemLike item, ItemLike storageItem) {
        // From item to storageItem
        ShapedRecipeBuilder.shaped(category, storageItem)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', item)
                .unlockedBy(getHasName(item), has(item))
                .save(recipeOutput, getRecipeName(item, storageItem));

        // From storageItem to item
        ShapelessRecipeBuilder.shapeless(category, item, 9)
                .requires(storageItem)
                .unlockedBy(getHasName(storageItem), has(storageItem))
                .save(recipeOutput, getRecipeName(storageItem, item));
    }

    protected static void foodCookingRecipes(@NotNull RecipeOutput recipeOutput, @NotNull ItemLike material, @NotNull ItemLike result, float experience) {
        foodSmelting(recipeOutput, material, result, experience, 200);
        foodSmoking(recipeOutput, material, result, experience, 100); // Smoking is twice as fast
        foodCampfireCooking(recipeOutput, material, result, experience, 600); // Campfire cooking takes three times longer
    }

    protected static void foodSmelting(@NotNull RecipeOutput recipeOutput, @NotNull ItemLike material, @NotNull ItemLike result, float experience, int cookingTime) {
        SimpleCookingRecipeBuilder
                .generic(Ingredient.of(material), RecipeCategory.FOOD, result, experience, cookingTime, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new)
                .unlockedBy(getHasName(material), has(material))
                .save(recipeOutput);
    }

    protected static void foodSmoking(@NotNull RecipeOutput recipeOutput, @NotNull ItemLike material, @NotNull ItemLike result, float experience, int cookingTime) {
        SimpleCookingRecipeBuilder
                .generic(Ingredient.of(material), RecipeCategory.FOOD, result, experience, cookingTime, RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new)
                .unlockedBy(getHasName(material), has(material))
                .save(recipeOutput, RusticDelight.MOD_ID + ":" + getItemName(result) + "_from_smoking");
    }

    protected static void foodCampfireCooking(@NotNull RecipeOutput recipeOutput, @NotNull ItemLike material, @NotNull ItemLike result, float experience, int cookingTime) {
        SimpleCookingRecipeBuilder
                .generic(Ingredient.of(material), RecipeCategory.FOOD, result, experience, cookingTime, RecipeSerializer.CAMPFIRE_COOKING_RECIPE, CampfireCookingRecipe::new)
                .unlockedBy(getHasName(material), has(material))
                .save(recipeOutput, RusticDelight.MOD_ID + ":" + getItemName(result) + "_from_campfire_cooking");
    }

    protected static String getRecipeName(ItemLike item, ItemLike result) {
        return RusticDelight.MOD_ID + ":" + getConversionRecipeName(result, item);
    }

    private static Ingredient vegetablesPatch() {
        return DifferenceIngredient.of(Ingredient.of(Tags.Items.FOODS_VEGETABLE), Ingredient.of(Items.MELON_SLICE));
    }

    private static Ingredient stuffedBellPepperFilling() {
        return DifferenceIngredient.of(Ingredient.of(vectorwing.farmersdelight.common.tag.ModTags.CABBAGE_ROLL_INGREDIENTS), Ingredient.of(CommonTags.FOODS_BELL_PEPPER));
    }

    private static Ingredient waterIngredient() {
        Ingredient waterBottleIngredient = DataComponentIngredient.of(true, DataComponents.POTION_CONTENTS, new PotionContents(Potions.WATER), Items.POTION);
        return CompoundIngredient.of(waterBottleIngredient, Ingredient.of(CommonTags.FOODS_WATER));
    }
}
