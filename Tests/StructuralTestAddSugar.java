package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class StructureTestAddSugar {
    @Test
    public void testAddSugar_negative_string() {
        Inventory inv = new Inventory();
        try {
            inv.addSugar("This is a test");
        } catch (InventoryException e) {
            System.out.println("testAddSugar_negative_int | ADDED NEGATIVE SUGAR BALANCE COMPLETED");
        }
    }

    @Test
    public void testAddSugar_negative_int() {
        Inventory inv = new Inventory();
        assertThrows(InventoryException.class,()->inv.addSugar("-10"));
    }

    // Can't hit line 183 in Inventory if the < sign isn't swapped with a > sign on line 183.
    @Test
    public void testAddSugar_normal() {
        Inventory inv = new Inventory();
        int bakeACake = inv.getSugar();
        try {
            inv.addSugar("15");
        } catch (InventoryException e) {
            System.out.println("testAddSugar_normal | ADDING TO SUGAR BALANCED FAILED");
        }
        assertEquals(bakeACake + 15, inv.getSugar());
        System.out.println("testSetSugar | SET SUGAR BALANCE COMPLETED");
    }
}
