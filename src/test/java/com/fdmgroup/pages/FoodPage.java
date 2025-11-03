package com.fdmgroup.pages;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.pojos.Food;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

public class FoodPage {
	Response response;
	
	private static List<Food> foods = new ArrayList<>();
	private  Food fd;
	private String url = "";

	public FoodPage() {
		super();
	}
	
	public void buildURL(String url) {
		this.url = url;
	}
	
	public void getRequestFoods() {
		response = given()
				.contentType(ContentType.JSON)
				.when()
				//.get("http://localhost:3000/foods")
				.get(this.url)
				.then()
				.assertThat().statusCode(200)
				.extract().response();
		foods = response.jsonPath().getList("", Food.class);
	}
	
	public boolean checkIfListIsEmpty() {
		boolean idExist = false;
		boolean nameExist = true;
		boolean priceExist = false;
		for(Food food : foods) {
			if(food.getId() > 0) {
				idExist = true;
			}
			if(food.getName().isEmpty()) {
				nameExist = false;
			}
			if(food.getPrice() > 0) {
				priceExist = true;
			}
		}
		return idExist&&nameExist&&priceExist;
	}
	public void createFood(int id, String name, double price) {
		fd = new Food(id, name, price);
	}
	
	public void postFood() {
		response = given()
				.contentType(ContentType.JSON)
				.with()
				.body(fd)
				.when()
				.post(this.url);
//				.then()
//				.assertThat().statusCode(201);
	}
	public void checkResponseCode(int code) {
		 response.then().assertThat().statusCode(code);
	}
	
	public void checkIfFoodExists(int id, String name) {
		response = given()
				.contentType(ContentType.JSON)
				.with()
				.queryParam("id", id)
				.when()
				.get(this.url);
		response.then()
				.assertThat().statusCode(200)
				.assertThat().body("name", hasItem(name));
	}
	
	public void updateFoods(int id, double price) {
		foods.get(id).setPrice(price);
	}
	
	public void putRequestFood(int id) {
		response = given()
				.contentType(ContentType.JSON)
				.with()
				.body(foods.get(id))
				.when()
				.put(this.url+"/"+String.valueOf(id));
	}
	
	public double checkIfChangeExists(int id) {
		response = given()
				.contentType(ContentType.JSON)
				.with()
				.pathParam("foodid", id)
				.when()
				.get(this.url+"/{foodid}");
		response.then()
				.assertThat().statusCode(200);
		
		return response.then().extract().as(Food.class).getPrice();
	}
}
