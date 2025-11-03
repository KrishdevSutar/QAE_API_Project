package com.fdmgroup.stepdefitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.fdmgroup.pages.CommentPage;
import com.fdmgroup.pages.FoodPage;
import com.fdmgroup.pages.ManagerPage;
import com.fdmgroup.utilities.DriverUtilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	static FoodPage foods;
	static CommentPage comments;
	static ManagerPage managers;
	

	@Before
	public static void init() {
		foods = new FoodPage();
		comments = new CommentPage();
		managers = new ManagerPage();
	}
}
