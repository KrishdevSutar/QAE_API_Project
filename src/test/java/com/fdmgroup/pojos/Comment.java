package com.fdmgroup.pojos;

public class Comment {
	private int id;
	private int userid;
	private String body;
	private int foodId;
	
	
	public Comment() {
		super();
	}
	
	public Comment(int id, int userid, String body, int foodId) {
		super();
		this.id = id;
		this.userid = userid;
		this.body = body;
		this.foodId = foodId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
}
