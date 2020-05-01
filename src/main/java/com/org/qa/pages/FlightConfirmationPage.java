package com.org.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Gopal Pandey
 *
 */
public class FlightConfirmationPage {

	WebDriver flightConfirmationDriver;

	@FindBy(css = "img[src='/images/masts/mast_confirmation.gif']")
	@CacheLookup
	WebElement confirmationPageValidation;

	@FindBy(xpath = "//b")
	@CacheLookup
	List<WebElement> ticketBoking;

	@FindBy(css = "img[src='/images/forms/Logout.gif']")
	@CacheLookup
	WebElement logoutBtn;

	@FindBy(css = "img[src='/images/masts/mast_signon.gif']")
	@CacheLookup
	WebElement signOnPageValidation;

	public FlightConfirmationPage(WebDriver driver) {
		flightConfirmationDriver = driver;
		PageFactory.initElements(driver, this);
	}

	public String totalPriceValidation() {

		return ticketBoking.get(16).getText();
	}

	public String bookingToastMessageValidation() {

		return ticketBoking.get(0).getText();
	}

	public String filghtConfirmationPageValidation() {

		return confirmationPageValidation.getAttribute("src");
	}

	public String signUpPageValidation() {

		return signOnPageValidation.getAttribute("src");
	}

	public void clickOncontinueBtn() {

		logoutBtn.click();

	}

}
