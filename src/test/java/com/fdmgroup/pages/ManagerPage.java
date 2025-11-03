package com.fdmgroup.pages;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.pojos.Comment;
import com.fdmgroup.pojos.Food;
import com.fdmgroup.pojos.Manager;
import com.fdmgroup.pojos.Staff;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ManagerPage {
	
	Response response;
	private static List<Staff> staffs = new ArrayList<>();
	private Staff stf;
	private Manager mmg;
	private Manager mng2;
	private String url = "";
	public ManagerPage() {
		super();
	}
	
	public void buildURL(String url) {
		this.url = url;
	}
	
	public void createStaff(int id, String name, double salary) {
		stf = new Staff(id, name, salary);
	}
	
	public void updateList(int id) {
		mmg = response.then().extract().response().jsonPath().getList("", Manager.class).get(0);
		mmg.getStaffs().add(stf);
		response = given()
				.contentType(ContentType.JSON)
				.with()
				.body(mmg)
				.when()
				.put(this.url+"/"+String.valueOf(id));
	}
	
	public void checkIfUpdated(int id) {
		response.then()
				.assertThat().statusCode(200);
	}
	
	public void getManager(int id) {
		response = given()
				.contentType(ContentType.JSON)
				.with()
				.queryParam("id", id)
				.when()
				.get(this.url);
		response.then()
				.assertThat().statusCode(200);
	}
	
	public void getManagerByname(String name) {
		response = given()
				.contentType(ContentType.JSON)
				.with()
				.queryParam("name", name)
				.when()
				.get(this.url);
		response.then()
				.assertThat().statusCode(200);
		
	}
	
	public void deleteComment(int id) {
		mng2 = response.then().extract().response().jsonPath().getList("", Manager.class).get(0);
		mng2.getStaffs().remove(id);
		response = given()
				.contentType(ContentType.JSON)
				.with()
				.body(mng2)
				.when()
				.put(this.url+"/"+String.valueOf(mng2.getId()));
	}
	
	public void checkIfSizeChange() {
		response.then()
				.assertThat().statusCode(200);
	}
}
