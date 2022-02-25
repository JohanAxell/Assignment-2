package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Test;

import static junit.framework.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class StructureTestSetPrice {

    @Test
    public void testSetPrice_NaN_string() {
        Recipe recipe = new Recipe();
        assertThrows(RecipeException.class, ()-> recipe.setPrice("This is a test"));
    }

    @Test
    public void testAddSugar_negative_int() {
        Recipe recipe = new Recipe();
        assertThrows(RecipeException.class,()->recipe.setPrice("-10"));
    }

    // Can't hit line 183 in Inventory if the < sign isn't swapped with a > sign on line 183.
    @Test
    public void testSetPrice_normal() {
        Recipe recipe = new Recipe();
        try {
            recipe.setPrice("25");
        } catch (RecipeException e) {
            fail("testAddSugar_normal | SETTING PRICE TEST FAILED");
        }
        assertEquals(25, recipe.getPrice());
    }
}
