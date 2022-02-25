package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

import static junit.framework.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

public class Tests {
    @Test
    public void testGetChocolate() {
        Inventory inv = new Inventory();
        assertEquals(15, inv.getChocolate());
        System.out.println("testGetChocolate | GETTING CHOCOLATE COMPLETED");
    }

    @Test
    public void testSetChocolate() {
        Inventory inv = new Inventory();
        inv.setChocolate(9);
        assertEquals(9, inv.getChocolate());
        System.out.println("testSetChocolate | SETTING CHOCOLATE COMPLETED");
    }

    @Test
    public void testAddChocolate_normal() {
        Inventory inv = new Inventory();
        int firstBite = inv.getChocolate();
        try {
            inv.addChocolate("10");
        } catch (InventoryException e) {
            System.out.println("testAddChocolate_normal | ADDING CHOCOLATE FAILED");
        }
        assertEquals(firstBite + 10, inv.getChocolate());
        System.out.println("testAddChocolate_normal | ADDING CHOCOLATE COMPLETED");
    }

    @Test
    public void testAddChocolate_negative() {
        Inventory inv = new Inventory();
        assertThrows(InventoryException.class,()->inv.addChocolate("-40"));
        System.out.println("testAddChocolate_negative | ADDING NEGATIVE CHOCOLATE COMPLETE");
    }

    @Test
    public void testAddChocolate_word_string() {
        Inventory inv = new Inventory();
        assertThrows(InventoryException.class,()->inv.addChocolate("Mmm... Marabou"));
        System.out.println("testAddChocolate_word_string | ADDING WORD STRING TEST COMPLETED");
    }

    @Test
    public void testGetCoffee() {
        Inventory inv = new Inventory();
        assertEquals(15, inv.getCoffee());
        System.out.println("testGetCoffee | GETTING COFFEE COMPLETED");
    }

    @Test
    public void testSetCoffee() {
        Inventory inv = new Inventory();
        inv.setCoffee(5);
        assertEquals(5, inv.getCoffee());
        System.out.println("testSetCoffee | SETTING CHOCOLATE COMPLETED");
    }

    @Test
    public void testAddCoffee_normal() {
        Inventory inv = new Inventory();
        int firstSipOfTheDay = inv.getCoffee();
        try {
            inv.addCoffee("15");
        } catch (InventoryException e) {
            System.out.println("testAddCoffee_normal | ADDING COFFEE FAILED");
        }
        assertEquals(firstSipOfTheDay + 15, inv.getCoffee());
        System.out.println("testAddCoffee_normal | ADDING COFFEE COMPLETED");
    }

    @Test
    public void testEnoughIngredients_expected() {
        Recipe recipe = new Recipe();
        Inventory inv = new Inventory();
        try {
            recipe.setAmtCoffee("2");
            recipe.setAmtMilk("2");
            recipe.setAmtChocolate("2");
            recipe.setAmtSugar("2");
        } catch (RecipeException e) {
            fail("Failed to set amount of Ingredients");
        }

        assertTrue(inv.enoughIngredients(recipe));
    }

    @Test
    public void testEnoughIngredients_Not_Enough() {
        Recipe recipe = new Recipe();
        Inventory inv = new Inventory();
        try {
            recipe.setAmtCoffee("20");
            recipe.setAmtMilk("20");
            recipe.setAmtChocolate("20");
            recipe.setAmtSugar("20");
        } catch (RecipeException e) {
            fail("Failed to set amount of Ingredients");
        }
        assertFalse(inv.enoughIngredients(recipe));
    }

    @Test
    public void testUseIngredients() {
        Recipe recipe = new Recipe();
        Inventory inv = new Inventory();
        try {
            recipe.setAmtSugar("5");
            recipe.setAmtMilk("5");
            recipe.setAmtChocolate("5");
            recipe.setAmtCoffee("5");
        } catch (RecipeException e) {
            fail("Failed to set amount of Ingredients");
        }
        assertAll("useIngredients", () ->
                        assertTrue( inv.useIngredients(recipe)),
                () ->
                        assertEquals( 10, inv.getSugar()),
                () ->
                        assertEquals( 10, inv.getCoffee()),
                () ->
                        assertEquals( 10, inv.getChocolate()),
                () ->
                        assertEquals( 10, inv.getMilk())
        );
    }

    @Test
    public void testAddCoffee_negative() {
        Inventory inv = new Inventory();
        assertThrows(InventoryException.class,()->inv.addCoffee("-100"));
        System.out.println("testAddCoffee_negative | ADDING NEGATIVE COFFEE BALANCE TEST COMPLETED");
    }

    @Test
    public void testAddCoffee_word_string() {
        Inventory inv = new Inventory();
        assertThrows(InventoryException.class,()->inv.addCoffee("Coffee is so nice in the morning"));
        System.out.println("testAddCoffee_word_string | ADDING WORD STRING COFFEE TEST COMPLETED");
    }

    @Test
    public void testGetMilk() {
        Inventory inv = new Inventory();
        assertEquals(15, inv.getMilk());
        System.out.println("testGetMilk | GETTING MILK TEST COMPLETED");
    }

    @Test
    public void testSetMilk() {
        Inventory inv = new Inventory();
        inv.setCoffee(5);
        assertEquals(5, inv.getCoffee());
        System.out.println("testSetMilk | SETTING MILK COMPLETED");
    }

    @Test
    public void testAddMilk_normal() {
        Inventory inv = new Inventory();
        int firstAndLastDrink = inv.getMilk();
        try {
            inv.addMilk("20");
        } catch (InventoryException e) {
            System.out.println("testAddMilk_normal | ADDED MILK BALANCE FAILED");
        }
        assertEquals(firstAndLastDrink + 20, inv.getMilk());
        System.out.println("testAddMilk_normal | ADDED MILK BALANCE COMPLETED");
    }

    @Test
    public void testAddMilk_negative() {
        Inventory inv = new Inventory();
        assertThrows(InventoryException.class,()->inv.addMilk("-25"));
        System.out.println("testAddMilk_negative | ADDED NEGATIVE MILK BALANCE COMPLETED");
    }

    @Test
    public void testAddMilk_word_string() {
        Inventory inv = new Inventory();
        assertThrows(InventoryException.class,()->inv.addMilk("Some milk perhaps?"));
        System.out.println("testAddMilk_word_string | ADDING WORD STRING TEST COMPLETED");
    }

    @Test
    public void testGetSugar() {
        Inventory inv = new Inventory();
        assertEquals(15, inv.getSugar());
    }

    @Test
    public void testSetSugar() {
        System.out.println("testSetSugar | SET SUGAR BALANCE COMPLETED");
        Inventory inv = new Inventory();
        inv.setSugar(10);
        assertEquals(10, inv.getSugar());
    }

    @Test
    public void testAddSugar_normal() {
        Inventory inv = new Inventory();
        int bakeACake = inv.getSugar();
        try {
            inv.addSugar("10");
        } catch (InventoryException e) {
            System.out.println("testAddSugar_normal | ADDING TO SUGAR BALANCED FAILED");
        }
        assertEquals(bakeACake + 10, inv.getSugar());
        System.out.println("testAddSugar_normal | SET SUGAR BALANCE COMPLETED");
    }

    @Test
    public void testAddSugar_negative() {
        Inventory inv = new Inventory();
        assertThrows(InventoryException.class,()->inv.addSugar("-10"));
        System.out.println("testAddSugar_negative | ADDED NEGATIVE SUGAR BALANCE COMPLETED");
    }

    @Test
    public void testAddSugar_string_word() {
        Inventory inv = new Inventory();
        assertThrows(InventoryException.class,()->inv.addSugar("Sugar, Sugar , Oh, honey, honey"));
        System.out.println("testAddSugar_string_word | ADDING WORD STRING TEST COMPLETED");
    }

    @Test
    public void testAddSugar_negative_int() {
        Inventory inv = new Inventory();
        assertThrows(InventoryException.class,()->inv.addSugar("-10"));
    }

    // Can't hit line 183 in Inventory if the < sign isn't swapped with a > sign on line 183.
    @Test
    public void testAddSugar_expected() {
        Inventory inv = new Inventory();
        int bakeACake = inv.getSugar();
        try {
            inv.addSugar("15");
        } catch (InventoryException e) {
            System.out.println("testAddSugar_expected | ADDING TO SUGAR BALANCED FAILED");
        }
        assertEquals(bakeACake + 15, inv.getSugar());
        System.out.println("testAddSugar_expected | ADD SUGAR TEST COMPLETED");
    }

    @Test
    public void testSetPrice_NaN_string() {
        Recipe recipe = new Recipe();
        assertThrows(RecipeException.class, ()-> recipe.setPrice("This is a test"));
    }

    @Test
    public void testSetPrice_negative_string() {
        Recipe recipe = new Recipe();
        assertThrows(RecipeException.class,()->recipe.setPrice("-10"));
    }

    @Test
    public void testSetPrice_normal() {
        Recipe recipe = new Recipe();
        try {
            recipe.setPrice("25");
        } catch (RecipeException e) {
            fail("testSetPrice_normal | SETTING PRICE TEST FAILED");
        }
        assertEquals(25, recipe.getPrice());
    }

    @Test
    public void testAddRecipe(){
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        Recipe recipe = new Recipe();
        assertTrue(coffeeMaker.addRecipe(recipe));
    }

    @Test
    public void testDeleteRecipe(){

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
            Assertions.fail("Index of beverage to delete was null!");
        }

    }

    @Test
    public void testEditRecipe(){
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
            Assertions.assertEquals("AwesomeAlmondDrink", coffeeMaker.editRecipe(indexToEdit, editedRecipe));
        } else {
            Assertions.fail("Index of beverage to edit was null!");
        }
    }

    @Test
    public void testCheckInventory(){
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        assertTrue(coffeeMaker.checkInventory() instanceof String);
    }

    @Test
    public void testMakeCoffee(){
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
            Assertions.fail("Index of purchased beverage was null!");
        }

    }

    @Test
    public void testNullValueRecipe(){
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        //   Recipe recipe = null;

        // coffeeMaker.addRecipe(recipe);
        Recipe[] currentRecipes = coffeeMaker.getRecipes();

        for (int i = 0; i < currentRecipes.length; i++){
            if (currentRecipes[i] == null){
                Assertions.assertEquals(5, coffeeMaker.makeCoffee(i, 5));
            }
        }

    }

    @Test
    public void testSuccessfulPurchase(){
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
                Assertions.assertEquals(5,coffeeMaker.makeCoffee(i, 10));
            }

        }

    }


    @Test
    public void testInventoryTooSmall(){
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
                Assertions.assertEquals(10,coffeeMaker.makeCoffee(i, 10));
            }

        }

    }

    @Test
    public void testNotEnoughMoney(){
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
                Assertions.assertEquals(2,coffeeMaker.makeCoffee(i, 2));
            }

        }

    }

    @Test
    public void testAddEmptyRecipe(){
        RecipeBook recipeBook = new RecipeBook();
        Recipe recipe = new Recipe();
        assertTrue(recipeBook.addRecipe(recipe));
        assertFalse(recipeBook.addRecipe(recipe));
    }

    @Test
    public void testGetRecipes() {
        RecipeBook recipeBook = new RecipeBook();
        assertTrue(recipeBook.getRecipes() instanceof Recipe[]);
    }

    @Test
    public void testAddRecipeTrue(){
        RecipeBook recipeBook = new RecipeBook();
        Recipe recipe = new Recipe();

        assertTrue(recipeBook.addRecipe(recipe));
    }

    @Test
    public void testAddRecipeExist(){
        RecipeBook recipeBook = new RecipeBook();
        Recipe recipe = new Recipe();
        recipe.setName("Sugar Daddy");

        recipeBook.addRecipe(recipe);
        Recipe[] currentRecipes = recipeBook.getRecipes();

        assertTrue(Arrays.asList(currentRecipes).contains(recipe));
    }

    @Test
    public void testDeleteRecipeTrue(){
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
            Assertions.assertEquals(recipe.getName(), recipeBook.deleteRecipe(index));
        } else {
            Assertions.fail("Failed to find index of added recipe!");
        }


    }

    @Test
    public void testDeleteRecipeExist(){
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
            Assertions.fail("Failed to find index of added recipe!");
        }
    }

    @Test
    public void testEditRecipeTrue(){
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
        Assertions.assertEquals(recipe.getName(), recipeBook.editRecipe(index, updatedRecipe));

    }

    @Test
    public void testEditRecipeExist(){
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
                () -> Assertions.assertEquals(testRecipe.getName(), finalCurrentRecipes[finalIndex].getName()),
                () -> Assertions.assertEquals(testRecipe.getAmtChocolate(), finalCurrentRecipes[finalIndex].getAmtChocolate()),
                () -> Assertions.assertEquals(testRecipe.getPrice(), finalCurrentRecipes[finalIndex].getPrice()),
                () -> Assertions.assertEquals(testRecipe.getAmtCoffee(), finalCurrentRecipes[finalIndex].getAmtCoffee()),
                () -> Assertions.assertEquals(testRecipe.getAmtMilk(), finalCurrentRecipes[finalIndex].getAmtMilk()),
                () -> Assertions.assertEquals(testRecipe.getAmtSugar(), finalCurrentRecipes[finalIndex].getAmtSugar())
        );
    }
}
