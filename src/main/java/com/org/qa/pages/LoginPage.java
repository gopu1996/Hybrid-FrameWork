package com.org.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Gopal Pandey
 *
 */
public class LoginPage  {
	
	private WebDriver loginPageDriver;

	@FindBy(css = "img[src='/images/nav/logo.gif']")
	@CacheLookup
	WebElement applicationValidation;

	@FindBy(name = "userName")
	@CacheLookup
	WebElement username;

	@FindBy(name = "password")
	@CacheLookup
	WebElement password;

	@FindBy(name = "login")
	@CacheLookup
	WebElement loginBtn;

	public LoginPage(WebDriver driver) {
		loginPageDriver=driver;
		PageFactory.initElements(driver, this);
	}

	

	public String validateLoginPageTitle() {
		return loginPageDriver.getTitle();
	}

	public boolean applicationValidation() {
		return applicationValidation.isDisplayed();
	}

	public boolean login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		// loginBtn.click();
		JavascriptExecutor js = (JavascriptExecutor) loginPageDriver;
		js.executeScript("arguments[0].click();", loginBtn);
		return true;
     	//return new FlightReservationPage();
	}
}
