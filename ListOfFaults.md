Fails:

1) CoffeeMakerTest.testEditRecipe, and RecipeBookTest.testEditRecipeExist, failed due to recipebook.editRecipe is faulty. The reason for this may be due to it is changing the updated name to ""(blank). See our solution below:
```
	public synchronized String editRecipe(int recipeToEdit, Recipe newRecipe) {
		if (recipeArray[recipeToEdit] != null) {
			recipeArray[recipeToEdit] = newRecipe;
			return recipeArray[recipeToEdit].getName();
		} else {
			return null;
		}
	}
```


2) CoffeeMakerTest.testAddInventory can not run, due to the incorrect return type given(void instead of Boolean). See our solution below:
```
	public synchronized Boolean addInventory(String amtCoffee, String amtMilk, String amtSugar, String amtChocolate) throws InventoryException {
	    inventory.addCoffee(amtCoffee);
	    inventory.addMilk(amtMilk);
	    inventory.addSugar(amtSugar);
	    inventory.addChocolate(amtChocolate);
        return true;
    }
```


3) InventoryTest.testaddSugar fails due to Inventory.addSugar only allows for adding sugar to Inventory.sugar if the received amount of sugar is 0 or less than      0. Our solution can be found below:
```
	public synchronized void addSugar(String sugar) throws InventoryException {
    	int amtSugar = 0;
    	try {
    		amtSugar = Integer.parseInt(sugar);
    	} catch (NumberFormatException e) {
    		throw new InventoryException("Units of sugar must be a positive integer");
    	}
		if (amtSugar >= 0) {
			Inventory.sugar += amtSugar;
		} else {
			throw new InventoryException("Units of sugar must be a positive integer");
		}
    }
```    
    
    
4) InventoryTest.testuseIngredients fails due to line 220 of Inventory.java in which instead of amount of coffee being used being deducted from the total amount of coffee in inventory it is added on. Our solution is as follows:
```
	public synchronized boolean useIngredients(Recipe r) {
    	if (enoughIngredients(r)) {
	    	Inventory.coffee -= r.getAmtCoffee();
	    	Inventory.milk -= r.getAmtMilk();
	    	Inventory.sugar -= r.getAmtSugar();
	    	Inventory.chocolate -= r.getAmtChocolate();
	    	return true;
    	} else {
    		return false;
    	}
    }
```
