package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RecipeBookTest {

    @Test
    void testGetRecipes() {
        RecipeBook recipeBook = new RecipeBook();
        assertTrue(recipeBook.getRecipes() instanceof Recipe[]);
    }

    @Test
    void testAddRecipeTrue(){
        RecipeBook recipeBook = new RecipeBook();
        Recipe recipe = new Recipe();

        assertTrue(recipeBook.addRecipe(recipe));
    }

    @Test
    void testAddRecipeExist(){
        RecipeBook recipeBook = new RecipeBook();
        Recipe recipe = new Recipe();
        recipe.setName("Sugar Daddy");

        recipeBook.addRecipe(recipe);
        Recipe[] currentRecipes = recipeBook.getRecipes();

        assertTrue(Arrays.asList(currentRecipes).contains(recipe));
    }

    @Test
    void testDeleteRecipeTrue(){
        RecipeBook recipeBook = new RecipeBook();
        Recipe recipe = new Recipe();
        recipe.setName("Sugar Daddy");

        recipeBook.addRecipe(recipe);
        Recipe[] currentRecipes = recipeBook.getRecipes();
        Integer index = null;


        for (int i = 0; i < currentRecipes.length; i++){
            if (currentRecipes[i] == recipe){
                index = i;
            }
        }
        if (index != null){
            assertEquals(recipe.getName(), recipeBook.deleteRecipe(index));
        } else {
            fail("Failed to find index of added recipe!");
        }


    }

    @Test
    void testDeleteRecipeExist(){
        RecipeBook recipeBook = new RecipeBook();
        Recipe recipe = new Recipe();
        recipe.setName("Sugar Daddy");

        recipeBook.addRecipe(recipe);
        Recipe[] currentRecipes = recipeBook.getRecipes();

        Integer index = null;


        for (int i = 0; i < currentRecipes.length; i++){
            if (currentRecipes[i] == recipe){
                index = i;
            }
        }
        if (index != null){
            recipeBook.deleteRecipe(index);
            assertFalse(Arrays.asList(currentRecipes).contains(recipe));
        } else {
            fail("Failed to find index of added recipe!");
        }
    }

    @Test
    void testEditRecipeTrue(){
        RecipeBook recipeBook = new RecipeBook();
        Recipe recipe = new Recipe();
        recipe.setName("Sugar Daddy");
        recipeBook.addRecipe(recipe);
        Recipe[] currentRecipes = recipeBook.getRecipes();

        Integer index = null;

        for (int i = 0; i < currentRecipes.length; i++){
            if (currentRecipes[i] == recipe){
                index = i;
            }
        }

        Recipe updatedRecipe = new Recipe();
        updatedRecipe.setName("Sugar Mommy");
        assertEquals(recipe.getName(), recipeBook.editRecipe(index, updatedRecipe));

    }

    @Test
    void testEditRecipeExist(){
        RecipeBook recipeBook = new RecipeBook();
        Recipe recipe = new Recipe();
        recipe.setName("Sugar Daddy");
        System.out.println(recipe.getName());
        recipeBook.addRecipe(recipe);
        Recipe[] currentRecipes = recipeBook.getRecipes();

        Integer index = null;

        for (int i = 0; i < currentRecipes.length; i++){
            if (currentRecipes[i] == recipe){
                index = i;
            }
        }

        Recipe testRecipe = new Recipe();


        Recipe updatedRecipe = new Recipe();
        updatedRecipe.setName("Sugar Mommy");
        testRecipe.setName(updatedRecipe.getName());


        try {
            updatedRecipe.setPrice("100");
        } catch (RecipeException e) {
            e.printStackTrace();
        }
        try {
            testRecipe.setPrice(String.valueOf(updatedRecipe.getPrice()));
        } catch (RecipeException e) {
            e.printStackTrace();
        }

        try {
            updatedRecipe.setAmtChocolate("3");
        } catch (RecipeException e) {
            e.printStackTrace();
        }
        try {
            testRecipe.setAmtChocolate(String.valueOf(updatedRecipe.getAmtChocolate()));
        } catch (RecipeException e) {
            e.printStackTrace();
        }

        try {
            updatedRecipe.setAmtSugar("2");
        } catch (RecipeException e) {
            e.printStackTrace();
        }
        try {
            testRecipe.setAmtSugar(String.valueOf(updatedRecipe.getAmtSugar()));
        } catch (RecipeException e) {
            e.printStackTrace();
        }

        try {
            updatedRecipe.setAmtCoffee("7");
        } catch (RecipeException e) {
            e.printStackTrace();
        }
        try {
            testRecipe.setAmtCoffee(String.valueOf(updatedRecipe.getAmtCoffee()));
        } catch (RecipeException e) {
            e.printStackTrace();
        }

        try {
            updatedRecipe.setAmtMilk("4");
        } catch (RecipeException e) {
            e.printStackTrace();
        }
        try {
            testRecipe.setAmtMilk(String.valueOf(updatedRecipe.getAmtMilk()));
        } catch (RecipeException e) {
            e.printStackTrace();
        }



        System.out.println(updatedRecipe.getName());
        recipeBook.editRecipe(index, updatedRecipe);

        currentRecipes = recipeBook.getRecipes();
        Recipe[] finalCurrentRecipes = currentRecipes;
        Integer finalIndex = index;


        assertAll("recipeBook",
                () -> assertEquals(testRecipe.getName(), finalCurrentRecipes[finalIndex].getName()),
                () -> assertEquals(testRecipe.getAmtChocolate(), finalCurrentRecipes[finalIndex].getAmtChocolate()),
                () -> assertEquals(testRecipe.getPrice(), finalCurrentRecipes[finalIndex].getPrice()),
                () -> assertEquals(testRecipe.getAmtCoffee(), finalCurrentRecipes[finalIndex].getAmtCoffee()),
                () -> assertEquals(testRecipe.getAmtMilk(), finalCurrentRecipes[finalIndex].getAmtMilk()),
                () -> assertEquals(testRecipe.getAmtSugar(), finalCurrentRecipes[finalIndex].getAmtSugar())
                );

    }



}