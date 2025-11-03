Feature: Test that the second portion API Testing is functioning
	Background:
		Given User access the "comments" portion of the API endpoint
		
	Scenario Outline: User should create a new comment with foodId so that I can see whether the new comment has been created 
		Given User sends the <foodId> and <id>, <userid>, and "<body>" of the comment
		When User sends a POST request to the Comment endpoint
		Then User should get response status 201 for comment being made
		And User should create a new comment in the JSON with same <id>, <foodId> and "<body>"
		
		Examples:
		|foodId|id|userid|body|
		|6|5|10|spectacular|
		
	#Scenario Outline: User should be able to delete the comment according to the comment’s id so that the body of the comment should not be visible anymore 
	#	When User sends a Delete request to the endpoint with ID <id>
	#	Then User should not be see the comment with ID <id>
		
	#	Examples:
	#	|id|
	#	|4|
	
	Scenario Outline: User should be  able to get the comment information based on the user id and the food id so that I can very whether the body of the message is correct or not 
		When User sends a GET request with foodid <foodId> to the Comment endpoint
		And User sends a GET request with userid <userid> to the Comment endpoint
		Then User should have the same "<body>" as two requests
		
		Examples:
		|foodId|userid|body|
		|3|3|it is okay|