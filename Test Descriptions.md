# General Description

The coverage report can be found in ``./Assignment-2/Coverage/``

To make it easier to run all tests at once, we put all test in ``./Tests/AllTests.java``

All tests also exist in their respective test files within the ``./Tests/`` folder.

Following is the descriptions of all the tests for each class.

# Inventory Class:

### Test for the setChocolate Method:
This test will is done by passing a number of chocolate units into the method and comparing it with that same number,if the method sets the number passed in
and the two numbers are equal, the test has passed.This is to show that the method does actually set the inputted value as intended.

### Test for the getChocolate method:
This test will is done by passing a number of chocolate units into the method and comparing it with that same number,if the method gets the number passed in
and the two numbers are equal, the test has passed.This is to show that the method does actually retrieve the inputted value.

### Test for addChocolate method:
This test will add units of chocolates to the inventory by using the addChocolate method. We will then check if the units of chocolate is
now equal to the previous number of units + the newly added number of units. If equal the test will pass. This test is to show that the addChocolate
method correctly adds and updates the units of chocolate in inventory.

### Test for the setSugar Method:
This test will is done by passing a number of sugar units into the method and comparing it with that same number,if the method sets the number passed in
and the two numbers are equal, the test has passed.This is to show that the method does actually set the inputted value as intended.

### Test for the getSugar method:
This test will is done by passing a number of sugar units into the method and comparing it with that same number,if the method gets the number passed in
and the two numbers are equal, the test has passed.This is to show that the method does actually retrieve the inputted value.

### Test for addSugar method:
This test will add units of sugar to the inventory by using the addSugar method. We will then check if the units of sugar is
now equal to the previous number of units + the newly added number of units. If equal the test will pass. This test is to show that the addSugar
method correctly adds and updates the units of sugar in inventory.

### Test for the setMilk Method:
This test will is done by passing a number of milk units into the method and comparing it with that same number,if the method sets the number passed in
and the two numbers are equal, the test has passed.This is to show that the method does actually set the inputted value as intended.

### Test for the getMilk method:
This test will is done by passing a number of milk units into the method and comparing it with that same number,if the method gets the number passed in
and the two numbers are equal, the test has passed.This is to show that the method does actually retrieve the inputted value.

### Test for addMilk method:
This test will add units of milk to the inventory by using the addMilk method. We will then check if the units of milk is
now equal to the previous number of units + the newly added number of units. If equal the test will pass. This test is to show that the addMilk
method correctly adds and updates the units of milk in inventory.

### Test for the setCoffee Method:
This test will is done by passing a number of coffee units into the method and comparing it with that same number,if the method sets the number passed in
and the two numbers are equal, the test has passed.This is to show that the method does actually set the inputted value as intended.

### Test for the getCoffee method:
This test will is done by passing a number of coffee units into the method and comparing it with that same number,if the method gets the number passed in
and the two numbers are equal, the test has passed.This is to show that the method does actually retrieve the inputted value.

### Test for addCoffee method:
This test will add units of coffee to the inventory by using the addCoffee method. We will then check if the units of coffee is
now equal to the previous number of units + the newly added number of units. If equal the test will pass. This test is to show that the addCoffee
method correctly adds and updates the units of coffee in inventory.

### Test for addChocolate method(erroneous input):
This test will pass a negative integer into the addChocolate method, when the test runs this number should not be added to the chocolate inventory but instead
should consider the input as an error which is caught in the catch block printing a message relying the error.If the test works in this manner it passes. This
is to make sure that no negative units of chocolate are ever added to the chocolate inventory.

### Test for addMilk method(erroneous input):
This test will pass a negative integer into the addMilk method, when the test runs this number should not be added to the milk inventory but instead
should consider the input as an error which is caught in the catch block printing a message relying the error.If the test works in this manner it passes. This
is to make sure that no negative units of milk are ever added to the milk inventory.

### Test for addSugar method(erroneous input):
This test will pass a negative integer into the addSugar method, when the test runs this number should not be added to the sugar inventory but instead
should consider the input as an error which is caught in the catch block printing a message relying the error.If the test works in this manner it passes. This
is to make sure that no negative units of sugar are ever added to the sugar inventory.

### Test for addCoffee method(erroneous input):
This test will pass a negative integer into the addCoffee method, when the test runs this number should not be added to the coffee inventory but instead
should consider the input as an error which is caught in the catch block printing a message relying the error.If the test works in this manner it passes. This
is to make sure that no negative units of coffee are ever added to the coffee inventory.




# CoffeMaker Book:

### Test for addRecipe Method :
testAddRecipe adds a new recipe, and is needed to assure that new recipes can be created. By being able to add recipes, additional recipes other than the 
defaults can be used.If the assert yields 'true', the creation of a new recipe may be considered successful.

### Test for deleteRecipe Method:
testDeleteRecipe deletes a recipe given by the index of the recipe. This assures that unused recipes can be deleted to save time and memory.
The test begins by creating a recipe. The list of recipies is then updated, and then search for the index of the recently created recipe.
Once an index matching the recently created recipe has been assigned a value, the test then attempts to delete the recipe. 
If the deletion was successful, it will result in 'true'.
If a recipe could not be compared to the recently created recipe, the test fails, and returns "Index of beverage to delete was null!".

### Test for checkInventory Method:
This test will first create a new coffeMaker object and then calls the checkInventory method on to the object, if assertTrue function returns true then the 
method works correctly and the test passes.This test is used make sure the method checkInventory checks for inventory stored inside a coffeeMaker and works 
as intended.

### Test for editRecipe:
testEditRecipe creates one instance of CoffeeMaker and one of Recipe.
The recipe instance is given a name through the method setName, which may be used later on in the test.
The coffeeMaker instance calls the addRecipe method, and sends the recently created recipe instance to the method.
A list of all recipes is then generated, and stored in an array.
Once the generated list has been created, a new Recipe instance(editedRecipe) is created, which is needed to update the variables in 
the original Recipe instance.
A name is given to the editedRecipe object, which will be used later on.
The list of all recipes are updated to assure that relevant recipes are included in the list. Each recipe is then traversed through, and 
compared to the original Recipe object. If a comparison was found, the index of the recipe is saved.
If an index was saved, the the updating process occurs through the editRecipe method being called through the coffeeMaker instance, 
and the index of the recipe along with the edited recipe object. Directly after the update method finishes, a comparison is made between 
the hardcoded name of the edited recipe, along with the name returned from the updating method call. The test may be considered successful if this occurs.
If an index was not saved, the test may be considered as failed, and returns a message("Index of beverage to edit was null!") to the tester.

### Test for makeCoffee Method:
In this test we first create two object a coffeeMaker object and a recipe object. We also set a name and price for the recipe object. We then create a Recipe 
array, currentRecipes, which will contain all the recipes stored in the coffeeMaker. We search for our intend recipe by index of the recipes and once 
found we use said index to test the makeCoffee method. In the test we pass 10 as our amount paid and if our change which makeCoffee method returns is between
10 and 1 then our test is a sucess. If index of recipe is not found the test should print "Index of purchased beverage was null!".This test is meant to check 
that the makeCoffee method returns the correct change for the recipe purchased.

### Test for getRecipes Method:
This test will first create a new coffeMaker object and then calls the getRecipes method on to the object, if assertTrue function returns true then the 
method works correctly and the test passes.This test is used make sure the method getRecipes retrives the coffeMaker object correctly and works 
as intended.





# Recipe Class:

### Test for the testGetAmtChocolate Method:
This test will pass if the amount of chocolate received by GetAmtChocolate is more than or equal to 0. 

### Test for the testSetAmtChocolate method:
This test will create an instance of recipe and sets its chocolate amount value to 5. Then then the test will pass if the predetermined value of 5 is 
equal the value of GetAmtChocolate. 

### Test for testGetAmtCoffee method:
This test will pass if the amount of coffee received by GetAmtCoffee is more than or equal to 0. 

### Test for testSetAmtCoffee method:
This test will create an instance of recipe and sets its coffee amount value to 5. Then then the test will pass if the predetermined value of 5 is 
equal the value of GetAmtCoffee. 

### Test for testGetAmtMilk method:
This test will pass if the amount of milk received by GetAmtMilk is more than or equal to 0.

### Test for testSetAmtMilk method:
This test will create an instance of recipe and sets its milk amount value to 5. Then then the test will pass if the predetermined value of 5 is 
equal the value of GetAmtMilk.

### Test for testGetAmtSugar method:
This test will pass if the amount of sugar received by GetAmtSugar is more than or equal to 0.

### Test for testSetAmtSugar method: 
This test will create an instance of recipe and sets its sugar amount value to 5. Then then the test will pass if the predetermined value of 5 is 
equal the value of GetAmtSugar.

### Test for testGetName method: 
This test will pass if the name received by recipe.getName is an instance of String. 

### Test for testsetName method:
This test will pass if the name recevied by getName is the same as the name passed by the setName method. 

### Test for testGetPrice method:
This test will pass if the price in recipe.value attribute is a positive number. 

### Test for testSetPrice method: 
This test will pass if the value received by recipe.getPrice is the same as the one passed in recipe.setPrice.  




# RecipeBook Class: 

### Test for testGetRecipes method: 
This test will pass if recipebook.getRecipes returns an instance of the Recipe array. 

### Test for testAddRecipeTrue method:
We will create a recipe and add it to the recipeBook and by doing so we receive ”true” then the test passes. 

### Test for testAddRecipeExist method: 
Here we create an instance of recipe, set that instances name to sugar daddy, we then add it to the recipe book. We then get a new instance of the 
entire recipe book and check if the recipe passed is contained in the new book, if so, the test passes.  

### Test for testDeleteRecipeTrue method: 
Here we create an instance of recipe, set that instances name to sugar daddy, we then add it to the recipe book. Then we delete that instance from the book 
and check the book again. The test will pass if the deleted recipes name is the same as the created recipes name. 

### Test for testDeleteRecipeExist method:
Here we create an instance of recipe, set that instances name to sugar daddy, we then add it to the recipe book. Then we delete that instance from the book 
and check the book again, if that instance is gone from the recipe book the test passes.

### Test for testEditRecipeTrue method: 
Here we create an instance of recipe, set that instances name to sugar daddy, we then add it to the recipe book. We then loop through the recipebook to find 
the index of the added recipe. We then create an instance of a new recipe and update the name to Sugar Mommy. Lastly, the test passes if the returned name after editing is the same as of the original one. 

### Test for testEditRecipeExist method:

Here we create an instance of recipe, set that instances name to sugar daddy, we then add it to the recipe book. We then loop through the recipebook to find 
the index of the added recipe. We then create an instance of a new recipe and update the name to Sugar Mommy.
We set all values to specific attributes and see if all gets updated. If they do, the test passes. 
