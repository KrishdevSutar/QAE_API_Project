package com.fdmgroup.stepdefitions;

import static org.junit.Assert.assertEquals;

import com.fdmgroup.testdata.TestData;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class API_CommentTest_Stepdef {
	@Given("User access the {string} portion of the API endpoint")
	public void user_access_the_extension_of_the_api_endpoint(String url) {
		Hooks.comments.buildURL(TestData.baseURL+url);
	}
	
	@Given("User sends the {int} and {int}, {int}, and {string} of the comment")
	public void user_sends_the_and_and_of_the_comment(int foodid, int id, int userid, String body) {
	    Hooks.comments.createComment(foodid, id, userid, body);
	}

	@When("User sends a POST request to the Comment endpoint")
	public void user_sends_a_post_request_to_the_comment_endpoint() {
		Hooks.comments.postComment();
	}
	
	@Then("User should get response status {int} for comment being made")
	public void user_should_get_response_status_for_comment_being_made(int code) {
		Hooks.comments.checkResponseCode(code);
	}

	@Then("User should create a new comment in the JSON with same {int}, {int} and {string}")
	public void user_should_create_a_new_comment_in_the_json_with_same_and(int id, int foodid, String body) {
		Hooks.comments.checkIfCommentExists(id, foodid, body);
	}

	@When("User sends a Delete request to the endpoint with ID {int}")
	public void user_sends_a_delete_request_to_the_endpoint_with_id(int id) {
		Hooks.comments.deleteComment(id);
	}

	@Then("User should not be see the comment with ID {int}")
	public void user_should_not_be_see_the_comment_with_id(int id) {
		Hooks.comments.checkIfCommentDoesntExists(id);
	}

	@When("User sends a GET request with foodid {int} to the Comment endpoint")
	public void user_sends_a_get_request_with_foodid_to_the_comment_endpoint(int foodid) {
		Hooks.comments.getRequestByFoodID(foodid);
	}

	@When("User sends a GET request with userid {int} to the Comment endpoint")
	public void user_sends_a_get_request_with_userid_to_the_comment_endpoint(int userid) {
		Hooks.comments.getRequestByUserID(userid);
	}

	@Then("User should have the same {string} as two requests")
	public void user_should_have_the_same_as_two_requests(String body) {
		assertEquals(body, Hooks.comments.getFoodCommBody());
		assertEquals(body, Hooks.comments.getUserCommBody());
	}
}
