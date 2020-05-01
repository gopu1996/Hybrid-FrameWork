package com.org.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.qa.commonmethod.CommonMethod;

/**
 * @author Gopal Pandey
 *
 */
public class FlightBookingPage {

	WebDriver flightPurchaseDriver;
	FlightBookingPage flightPurchase;

	@FindBy(css = "img[src='/images/masts/mast_book.gif']")
	@CacheLookup
	WebElement bookingValidation;

	@FindBy(xpath = "//b[contains(text(),'$1197')]")
	@CacheLookup
	WebElement ticketPrice;

	@FindBy(name = "passFirst0")
	@CacheLookup
	WebElement firstNamePassenger;

	@FindBy(name = "passLast0")
	@CacheLookup
	WebElement lastNamePassenger;

	@FindBy(name = "pass.0.meal")
	@CacheLookup
	WebElement firstPassengerMeal;

	@FindBy(name = "passFirst1")
	@CacheLookup
	WebElement secondNamePassenger;

	@FindBy(name = "passLast1")
	@CacheLookup
	WebElement secLastNamePassenger;

	@FindBy(name = "pass.1.meal")
	WebElement secondPassengerMeal;

	@FindBy(name = "creditCard")
	@CacheLookup
	WebElement cardType;

	@FindBy(name = "creditnumber")
	@CacheLookup
	WebElement cardNumber;

	@FindBy(name = "cc_exp_dt_mn")
	@CacheLookup
	WebElement cardExpirationMonths;

	@FindBy(name = "cc_exp_dt_yr")
	@CacheLookup
	WebElement cardExpirationYear;

	@FindBy(name = "cc_frst_name")
	@CacheLookup
	WebElement firstNameCardHolder;

	@FindBy(name = "cc_mid_name")
	@CacheLookup
	WebElement midNameCardHolder;

	@FindBy(name = "cc_last_name")
	@CacheLookup
	WebElement LastNameCardHolder;

	@FindBy(name = "billAddress1")
	@CacheLookup
	WebElement billingAddress;

	@FindBy(name = "billCity")
	@CacheLookup
	WebElement billingCity;

	@FindBy(name = "billState")
	@CacheLookup
	WebElement billingState;

	@FindBy(name = "billZip")
	@CacheLookup
	WebElement billingPin;

	@FindBy(name = "delAddress1")
	@CacheLookup
	WebElement deliveryAddress;

	@FindBy(name = "delCity")
	@CacheLookup
	WebElement deliveryCity;

	@FindBy(name = "delState")
	@CacheLookup
	WebElement deliveryState;

	@FindBy(name = "delZip")
	@CacheLookup
	WebElement deliveryPin;

	@FindBy(css = "input[type='image']")
	@CacheLookup
	WebElement continueBtn;

	public FlightBookingPage(WebDriver driver) {
		flightPurchaseDriver = driver;
		PageFactory.initElements(driver, this);
	}

	public String filghtReservationValidation() {

		return bookingValidation.getAttribute("src");
	}

	public String filghtPriceValidation() {

		return ticketPrice.getText();
	}

	public boolean personalInformation(String fisrtNamePass, String lastNamePass, String mealTypeFisrtPass,
			String secFirstNamePass, String secLastNamePass, String mealTypeSecPass, String card, String cardNo,
			String cardExpMonths, String cardExpYear, String firstNameCardholder, String midNameCardholder,
			String lastNameCardholder, String billingAddr, String billCity, String billState, String billPin,
			String delvrAddr, String delvrCity, String delvrState, String delvrPin) {

		firstNamePassenger.sendKeys(fisrtNamePass);
		lastNamePassenger.sendKeys(lastNamePass);
		CommonMethod.selectByValue(firstPassengerMeal, mealTypeFisrtPass);
		secondNamePassenger.sendKeys(secFirstNamePass);
		secLastNamePassenger.sendKeys(secLastNamePass);
		CommonMethod.selectByValue(secondPassengerMeal, mealTypeSecPass);
		CommonMethod.selectByValue(cardType, card);
		cardNumber.sendKeys(cardNo);
		CommonMethod.selectByVisibleText(cardExpirationMonths, cardExpMonths);
		CommonMethod.selectByVisibleText(cardExpirationYear, cardExpYear);
		firstNameCardHolder.sendKeys(firstNameCardholder);
		midNameCardHolder.sendKeys(midNameCardholder);
		LastNameCardHolder.sendKeys(lastNameCardholder);
		billingAddress.clear();
		billingAddress.sendKeys(billingAddr);
		billingCity.clear();
		billingCity.sendKeys(billCity);
		billingState.clear();
		billingState.sendKeys(billState);
		billingPin.clear();
		billingPin.sendKeys(billPin);
		deliveryAddress.clear();
		deliveryAddress.sendKeys(delvrAddr);
		deliveryCity.clear();
		deliveryCity.sendKeys(delvrCity);
		deliveryState.clear();
		deliveryState.sendKeys(delvrState);
		deliveryPin.clear();
		deliveryPin.sendKeys(delvrPin);
		continueBtn.click();
		
		return true;
	}
}
