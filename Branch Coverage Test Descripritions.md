Test for addSugar Method (Sentence Input):
This test will take a sentence that will be passed into the addSugar method. We use the assertThrows function to make sure the exceptions has been thrown.
If thrown the test passes. This test is meant to check that the exceptions of the method works as expected with the given input.

Test for setPrice Method (Negative Number Input):
This test will take a negative number that will be passed into the setPrice method. We use the assertThrows function to make sure the exceptions has been thrown.
If thrown the test passes. This test is meant to check that the exceptions of the method works as expected with the given input.

Test for setPrice Method (Sentence Input):
This test will take a sentence that will be passed into the setPrice method. We use the assertThrows function to make sure the exceptions has been thrown.
If thrown the test passes. This test is meant to check that the exceptions of the method works as expected with the given input.

Test for makeCoffee Method:
All tests hit line 89 and 103.
testNullValueRecipe - This test is meant to hit line 91 and 92. This test attempts to make a purchase on an recipe that is null. We expect this to return the same amount that was paid.

testSuccessfulPurchase - This test is meant to hit line 93 to 95. This test attempts to make a purchase with sufficient money on a recipe that is not null. It is expected to return the paid amount minus the cost of the recipe in change.

testInventoryTooSmall - This test is meant to hit line 96 to 98. The test attempts to make a purchase on a recipe that lacks the needed amount of ingredients to fulfill the purchase, where the amount of ingredients required are higher than the available amounts. It is expected to return the change as the same amount that was paid.

testNotEnoughMoney - This test is meant to hit line 99 to 100. The test attempts to make a purchase on a valid recipe, but lacking the sufficient funds to make a purchase. It is expected to return the change with the same value as was paid.

And together they all fulfill full line coverage(100%).


Test for addRecipe. This test adds a recipe, and adds the same recipe again, which results in 100% line coverage. The first time we add the recipe, we hit line 30 - 33, and 39 - 49(all lines expect 34). Line 34 is hit by the second attempt of adding the same recipe.