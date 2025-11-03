package com.fdmgroup.stepdefitions;

import com.fdmgroup.testdata.TestData;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class APIFeatureTest {
	@Given("User access the {string} extension of the API endpoint")
	public void user_access_the_extension_of_the_api_endpoint(String url) {
		Hooks.foods.buildURL(TestData.baseURL+url);
	}

	@When("User sends a GET request to the endpoint")
	public void user_sends_a_get_request_to_the_endpoint() {
	    Hooks.foods.getRequestFoods();
	}

	@Then("User should fill up the list of food items")
	public void user_should_fill_up_the_list_of_food_items() {
		assertTrue(Hooks.foods.checkIfListIsEmpty());
	    
	}

	@Given("User sends the {int}, {string}, and {double} of the food")
	public void user_sends_the_and_of_the_food(int id, String name, double price) {
		Hooks.foods.createFood(id, name, price);
	}

	@When("User sends a POST request to the endpoint")
	public void user_sends_a_post_request_to_the_endpoint() {
		Hooks.foods.postFood();
	}

	@Then("User should get response status {int}")
	public void user_should_get_response_status(int code) {
		Hooks.foods.checkResponseCode(code);
	}

	@Then("User should create a new food in the JSON with same {int} and {string}")
	public void user_should_create_a_new_food_in_the_json_with_same_and(int id, String name) {
		Hooks.foods.checkIfFoodExists(id, name);
	}

	@Given("User sends the {int} and {double} of the food")
	public void user_sends_the_and_of_the_food(int id, double price){
		Hooks.foods.updateFoods(id, price);
	}

	@When("User sends a PUT request for {int} to the endpoint")
	public void user_sends_a_put_request_for_to_the_endpoint(int id) {
		Hooks.foods.putRequestFood(id);
	}

	@Then("User should update the food {int} in the JSON to the correct {double}")
	public void user_should_update_the_food_in_the_json_to_the_correct(int id, double price) {
		assertEquals(price, Hooks.foods.checkIfChangeExists(id), 0.1);
	}
}
