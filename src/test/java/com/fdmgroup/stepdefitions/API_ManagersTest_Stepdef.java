package com.fdmgroup.stepdefitions;

import com.fdmgroup.testdata.TestData;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class API_ManagersTest_Stepdef {
	@Given("User access the {string} section of the API endpoint")
	public void user_access_the_section_of_the_api_endpoint(String url) {
	    Hooks.managers.buildURL(TestData.baseURL+url);
	}

	@Given("the manager with id {int} exists")
	public void the_manager_with_id_exists(int id) {
		Hooks.managers.getManager(id);
	}

	@Given("User sends the staff {int}, {string}, and {int} of the new staff")
	public void user_sends_the_staff_and_of_the_new_staff(int id, String string, double salary){
		Hooks.managers.createStaff(id, string, salary);
	}

	@When("I update the list of staffs for manager with id {int}")
	public void i_update_the_list_of_staffs_for_manager_with_id(int id) {
		Hooks.managers.updateList(id);
	}
	
	@Then("all the staff information under manager with id {int} should be updated")
	public void all_the_staff_information_under_manager_with_id_should_be_updated(int int1) {
		Hooks.managers.checkIfUpdated(int1);
	}

	@Given("the manager {string} and staff id {int} exists")
	public void the_manager_and_staff_id_exists(String name, int id) {
		Hooks.managers.getManagerByname(name);
	}

	@When("I delete the staff with id {int} under manager {string}")
	public void i_delete_the_staff_with_id_under_manager(int id, String name) {
		Hooks.managers.deleteComment(id);
	}

	@Then("the number of staffs managed by manager {int}")
	public void the_number_of_staffs_managed_by_manager(Integer int1) {
		Hooks.managers.checkIfSizeChange();
	}

}
