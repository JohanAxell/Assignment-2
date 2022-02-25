package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class structuralCoverageMakeCoffee {

    @Test
    void testNullValueRecipe(){
        CoffeeMaker coffeeMaker = new CoffeeMaker();
     //   Recipe recipe = null;

       // coffeeMaker.addRecipe(recipe);
        Recipe[] currentRecipes = coffeeMaker.getRecipes();

        for (int i = 0; i < currentRecipes.length; i++){
            if (currentRecipes[i] == null){
                assertEquals(5, coffeeMaker.makeCoffee(i, 5));
            }
        }

    }

    @Test
    void testSuccessfulPurchase(){
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        Recipe recipe = new Recipe();
        recipe.setName("AlmondDrink");
        try {
            recipe.setPrice("5");
        } catch (RecipeException e) {
            e.printStackTrace();
        }

        coffeeMaker.addRecipe(recipe);
        Recipe[] currentRecipes = coffeeMaker.getRecipes();

        for (int i = 0; i < currentRecipes.length; i++){
            if (currentRecipes[i] == recipe){
                assertEquals(5,coffeeMaker.makeCoffee(i, 10));
            }

        }

    }


    @Test
    void testInventoryTooSmall(){
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        Recipe recipe = new Recipe();
        recipe.setName("HugeAmountOfCoffee");
        try {
            recipe.setPrice("5");
            recipe.setAmtCoffee("200");
        } catch (RecipeException e) {
            e.printStackTrace();
        }

        coffeeMaker.addRecipe(recipe);
        Recipe[] currentRecipes = coffeeMaker.getRecipes();

        for (int i = 0; i < currentRecipes.length; i++){
            if (currentRecipes[i] == recipe){
                assertEquals(10,coffeeMaker.makeCoffee(i, 10));
            }

        }

    }

    @Test
    void testNotEnoughMoney(){
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        Recipe recipe = new Recipe();
        recipe.setName("TinyCoffee");
        try {
            recipe.setPrice("5");
        } catch (RecipeException e) {
            e.printStackTrace();
        }

        coffeeMaker.addRecipe(recipe);
        Recipe[] currentRecipes = coffeeMaker.getRecipes();

        for (int i = 0; i < currentRecipes.length; i++){
            if (currentRecipes[i] == recipe){
                assertEquals(2,coffeeMaker.makeCoffee(i, 2));
            }

        }

    }



}
