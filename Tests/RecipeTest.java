package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {

    @Test
    void testGetAmtChocolate(){
        Recipe recipe = new Recipe();
        assertTrue( recipe.getAmtChocolate() >= 0 );
    }

    @Test
    void testSetAmtChocolate(){
        Recipe recipe = new Recipe();
        String setValue = "5";
        try {
            recipe.setAmtChocolate(setValue);
        } catch (RecipeException e) {
            fail("Failed to set amount of chocolate!");
        }

        assertEquals(Integer.parseInt(setValue), recipe.getAmtChocolate());
    }


    @Test
    void testGetAmtCoffee(){
        Recipe recipe = new Recipe();
        assertTrue( recipe.getAmtCoffee() >= 0 );
    }

    @Test
    void testSetAmtCoffee(){
        Recipe recipe = new Recipe();
        String setValue = "7";
        try {
            recipe.setAmtCoffee(setValue);
        } catch (RecipeException e) {
            fail("Failed to set amount of coffee!");
        }

        assertEquals(Integer.parseInt(setValue), recipe.getAmtCoffee());
    }

    @Test
    void testGetAmtMilk(){
        Recipe recipe = new Recipe();
        assertTrue( recipe.getAmtMilk() >= 0 );
    }

    @Test
    void testSetAmtMilk(){
        Recipe recipe = new Recipe();
        String setValue = "3";
        try {
            recipe.setAmtMilk(setValue);
        } catch (RecipeException e) {
            fail("Failed to set amount of milk!");
        }

        assertEquals(Integer.parseInt(setValue), recipe.getAmtMilk());
    }

    @Test
    void testGetAmtSugar(){
        Recipe recipe = new Recipe();
        assertTrue( recipe.getAmtSugar() >= 0 );
    }

    @Test
    void testSetAmtSugar(){
        Recipe recipe = new Recipe();
        String setValue = "4";
        try {
            recipe.setAmtSugar(setValue);
        } catch (RecipeException e) {
            fail("Failed to set amount of sugar!");
        }

        assertEquals(Integer.parseInt(setValue), recipe.getAmtSugar());
    }

    @Test
    void testGetName(){
        Recipe recipe = new Recipe();
        assertTrue(recipe.getName() instanceof String);
    }

    @Test
    void testsetName(){
        Recipe recipe = new Recipe();
        String nameValue = "Jidde";
        recipe.setName(nameValue);
        assertEquals(nameValue, recipe.getName());
    }

    @Test
    void testGetPrice(){
        Recipe recipe = new Recipe();
        assertTrue( recipe.getPrice() >= 0 );
    }

    @Test
    void testSetPrice(){
        Recipe recipe = new Recipe();
        String setValue = "8";
        try {
            recipe.setPrice(setValue);
        } catch (RecipeException e) {
            fail("Failed to set price!");
        }

        assertEquals(Integer.parseInt(setValue), recipe.getPrice());
    }






}