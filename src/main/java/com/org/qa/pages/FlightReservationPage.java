package com.org.qa.pages;

import java.util.List;

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
public class FlightReservationPage {
 
	 WebDriver reservationDriver; 
	
	@FindBy(css ="img[src='/images/masts/mast_flightfinder.gif']")
	@CacheLookup
	WebElement filghtReservationValidation;

	@FindBy(name = "passCount")
	@CacheLookup
	WebElement numberOfPassenger;

	@FindBy(name = "fromPort")
	@CacheLookup
	WebElement departPlace;

	@FindBy(name = "fromMonth")
	@CacheLookup
	WebElement departMonth;

	@FindBy(name = "fromDay")
	@CacheLookup
	WebElement departingDate;

	@FindBy(name = "toPort")
	@CacheLookup
	WebElement arrivingPlace;

	@FindBy(name = "toMonth")
	@CacheLookup
	WebElement returnMonth;

	@FindBy(name = "toDay")
	@CacheLookup
	WebElement returnDate;

	@FindBy(name = "airline")
	@CacheLookup
	WebElement airlineList;

	@FindBy(name = "findFlights")
	@CacheLookup
	WebElement continueBtn;

	@FindBy(name = "servClass")
	@CacheLookup
	List<WebElement> serviceClassRadioButton;

	public FlightReservationPage(WebDriver driver) {
		reservationDriver =driver;
		PageFactory.initElements(driver, this);
	}

	public String filghtReservationValidation() {
		return filghtReservationValidation.getAttribute("src");
	}

	public boolean createNewContact(String Passenger, String departingPlace, String departMonths,
			String departingDates, String arrivingPlaces, String returnMonths, String returnDates, String classValue,
			String airlineLists) {

		CommonMethod.selectByValue(numberOfPassenger, Passenger)
		CommonMethod.selectByValue(departPlace, departingPlace);
		CommonMethod.selectByValue(departMonth, departMonths);
		CommonMethod.selectByValue(departingDate, departingDates);
		CommonMethod.selectByValue(arrivingPlace, arrivingPlaces);
		CommonMethod.selectByValue(returnMonth, returnMonths);
		CommonMethod.selectByValue(returnDate, returnDates);
		CommonMethod.ratioButtonSelector(serviceClassRadioButton, classValue);
		CommonMethod.selectByVisibleText(airlineList, airlineLists);
		CommonMethod.click(continueBtn);
	return true;	
	}


}
