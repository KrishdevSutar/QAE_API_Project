package com.fdmgroup.pages;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.pojos.Comment;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class CommentPage {
	Response response;
	ValidatableResponse res;
	
	private Comment comm;
	private Comment comm1;
	private Comment comm2;
	private static List<Comment> comments1 = new ArrayList<>();
	private static List<Comment> comments2 = new ArrayList<>();
	private String url = "";

	public CommentPage() {
		super();
	}
	
	public void buildURL(String url) {
		this.url = url;
	}
	

	public void createComment(int foodid, int id, int userid, String body) {
		comm = new Comment(id, userid, body, foodid);
	}
	
	public void postComment() {
		response = given()
				.contentType(ContentType.JSON)
				.with()
				.body(comm)
				.when()
				.post(this.url);
		
	}
	
	public void checkResponseCode(int code) {
		 response.then().assertThat().statusCode(code);
	}
	
	public void checkIfCommentExists(int id, int foodid, String body) {
		response = given()
				.contentType(ContentType.JSON)
				.with()
				.queryParam("id", id)
				.queryParam("foodid", foodid)
				.queryParam("body", body)
				.when()
				.get(this.url);
		response.then()
				.assertThat().statusCode(200);
	}
	public void deleteComment(int id) {
		response = given()
				.contentType(ContentType.JSON)
				.when()
				.delete(this.url+"/"+id);
		response.then()
				.assertThat().statusCode(200);
	}
	
	public void checkIfCommentDoesntExists(int id) {
		response = given()
				.contentType(ContentType.JSON)
				.with()
				.pathParam("commentid", id)
				.when()
				.get(this.url+"/{commentid}");
		response.then()
				.assertThat().statusCode(404);
	}
	
	public void getRequestByFoodID(int id) {
		response = given()
				.contentType(ContentType.JSON)
				.with()
				.queryParam("foodId", id)
				.when()
				.get(this.url)
				.then()
				.assertThat().statusCode(200)
				.extract().response();
		comments1 = response.jsonPath().getList("", Comment.class);
		comm1 = comments1.get(0);
	}
	
	public void getRequestByUserID(int id) {
		response = given()
				.contentType(ContentType.JSON)
				.with()
				.queryParam("userid", id)
				.when()
				.get(this.url)
				.then()
				.assertThat().statusCode(200)
				.extract().response();
		comments2 = response.jsonPath().getList("", Comment.class);
		comm2 = comments2.get(0);
	}
	
	public String getFoodCommBody() {
		return comm1.getBody();
	}
	
	public String getUserCommBody() {
		return comm2.getBody();
	}
}
