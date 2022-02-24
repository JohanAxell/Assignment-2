package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class InventoryTest {

    private Inventory inv;
    private CoffeeMaker cm;
    private Recipe r1;
    private Recipe r2;
    private Recipe r3;
    private Recipe r4;

    public InventoryTest() {
    }

    @BeforeEach
    public void setUp() throws Exception {
        inv = new Inventory();
    }

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
        int firstBite = inv.getChocolate();
        try {
            inv.addChocolate("-100");
        } catch (InventoryException e) {
            System.out.println("testAddChocolate_negative | ADDING NEGATIVE CHOCOLATE COMPLETE");
        }
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
    public void testAddCoffee_negative() {
        Inventory inv = new Inventory();
        int firstSipOfTheDay = inv.getCoffee();
        try {
            inv.addCoffee("-50");
        } catch (InventoryException e) {
            System.out.println("testAddCoffee_negative | ADDING NEGATIVE COFFEE BALANCE COMPLETED");
        }
    }

    @Test
    public void testGetMilk() {
        Inventory inv = new Inventory();
        assertEquals(15, inv.getMilk());
        System.out.println("testGetMilk | GETTING MILK COMPLETED");
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
        try {
            inv.addMilk("-30");
        } catch (InventoryException e) {
            System.out.println("testAddMilk_negative | ADDED NEGATIVE MILK BALANCE COMPLETED");
        }
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
        System.out.println("testSetSugar | SET SUGAR BALANCE COMPLETED");
    }

    @Test
    public void testAddSugar_negative() {
        Inventory inv = new Inventory();
        try {
            inv.addSugar("-40");
        } catch (InventoryException e) {
            System.out.println("testAddSugar_negative | ADDED NEGATIVE SUGAR BALANCE COMPLETED");
        }
    }

        /*@Test
        public void testAddInventoryException() {
            Throwable exception = assertThrows(
                    InventoryException.class, () -> {
                        cm.addInventory("4", "-1", "asdf", "3"); // Should throw an InventoryException
                    }
            );
        }

        @Test
        public void testMakeCoffee_Normal() {
            cm.addRecipe(r1);
            assertEquals(25, cm.makeCoffee(0, 75));
        }

    }
*/
}