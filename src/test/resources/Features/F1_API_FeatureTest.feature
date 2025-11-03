Feature: Test that the API Testing is functioning
	Background:
		Given User access the "foods" extension of the API endpoint
	
	Scenario: User should be able to get the list of all the foods so that I can see the ID, Name, and Price of the foods
		When User sends a GET request to the endpoint
		Then User should fill up the list of food items
		
	Scenario Outline: User should make a new food item so that I can see whether the new food item has been created or not
		Given User sends the <id>, "<Name>", and <Price> of the food
		When User sends a POST request to the endpoint
		Then User should get response status 201
		And User should create a new food in the JSON with same <id> and "<Name>"
		
		Examples:
			|id|Name|Price|
			|5|apple|7.8|
		
	Scenario Outline: User should update the price of the food item based on the food id so that I can see the price is changing at the end
		Given  User sends the <id> and <Price> of the food
		When User sends a PUT request for <id> to the endpoint
		Then User should update the food <id> in the JSON to the correct <Price>
		
		Examples:
			|id|Price|
			|3|9|