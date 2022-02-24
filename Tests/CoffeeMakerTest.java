package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeMakerTest {

    @BeforeEach
    public void setup(){
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        Recipe recipe = new Recipe();
        RecipeBook recipeBook = new RecipeBook();
        Inventory inventory = new Inventory();
    }

    @Test
    void testAddRecipe(){
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        Recipe recipe = new Recipe();
        assertTrue(coffeeMaker.addRecipe(recipe));



    }

    @Test
    void testDeleteRecipe(){

        CoffeeMaker coffeeMaker = new CoffeeMaker();
        Recipe recipe = new Recipe();
        recipe.setName("AlmondDrink");
        coffeeMaker.addRecipe(recipe);
        System.out.println("Recipe has been added");
        Recipe[] currentRecipes = coffeeMaker.getRecipes();

        Integer indexToDelete = null;
        currentRecipes = coffeeMaker.getRecipes();
        for (int i = 0; i < currentRecipes.length; i++){
            if (currentRecipes[i] == recipe){
                indexToDelete = i;
            }
        }
        if (indexToDelete != null){
            assertTrue(true, coffeeMaker.deleteRecipe(indexToDelete));
            System.out.println("Recipe has been deleted");
        } else {
            fail("Index of beverage to delete was null!");
        }

    }

    @Test
    void testEditRecipe(){
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        Recipe recipe = new Recipe();
        recipe.setName("AlmondDrink");
        coffeeMaker.addRecipe(recipe);
        System.out.println("Recipe has been added");
        Recipe[] currentRecipes = coffeeMaker.getRecipes();

        Recipe editedRecipe = new Recipe();
        editedRecipe.setName("AwesomeAlmondDrink");

        Integer indexToEdit = null;
        currentRecipes = coffeeMaker.getRecipes();
        for (int i = 0; i < currentRecipes.length; i++){
            if (currentRecipes[i] == recipe){
                indexToEdit = i;
            }
        }
        if (indexToEdit != null){
            assertEquals("AwesomeAlmondDrink", coffeeMaker.editRecipe(indexToEdit, editedRecipe));
        } else {
            fail("Index of beverage to edit was null!");
        }
    }

    @Test
    void testAddInventory(){
        /*
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        try {
            assertTrue(coffeeMaker.addInventory("1", "2", "3", "4"));
        } catch (InventoryException e) {
            e.printStackTrace();
        }
*/
    }

    @Test
    void testCheckInventory(){
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        assertTrue(coffeeMaker.checkInventory() instanceof String);
    }

    @Test
    void testMakeCoffee(){
        CoffeeMaker coffeeMaker = new CoffeeMaker();

        Recipe recipe = new Recipe();

        recipe.setName("AlmondDrink");
        try {
            recipe.setPrice("5");
        } catch (RecipeException e) {
            e.printStackTrace();
        }
        coffeeMaker.addRecipe(recipe);
        Integer indexToPurchase = null;
        Recipe[] currentRecipes = coffeeMaker.getRecipes();
        for (int i = 0; i < currentRecipes.length; i++){
            if (currentRecipes[i] == recipe){
                indexToPurchase = i;
            }
        }

        if (indexToPurchase != null) {

            Integer finalIndexToPurchase = indexToPurchase;
            Integer finalIndexToPurchase1 = indexToPurchase;
            Integer finalIndexToPurchase2 = indexToPurchase;
            assertAll("coffeeMaker", () ->
                        assertTrue( 10 >= coffeeMaker.makeCoffee(finalIndexToPurchase, 10)),
                    () ->
                        assertTrue( 0 < coffeeMaker.makeCoffee(finalIndexToPurchase1, 10))

            );
        } else {
            fail("Index of purchased beverage was null!");
        }

    }


    @Test
    void testGetRecipes(){
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        assertTrue(coffeeMaker.getRecipes() instanceof Recipe[]);
    }

}