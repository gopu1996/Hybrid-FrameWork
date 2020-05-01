package com.org.qa.testdata;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.org.qa.base.TestBase;
import com.org.qa.pages.FlightConfirmationPage;
import com.org.qa.pages.FlightBookingPage;
import com.org.qa.pages.FlightReservationPage;
import com.org.qa.pages.LoginPage;
import com.org.qa.pages.SearchFlightPage;
import com.org.qa.utility.ExtentLog;
import com.org.qa.utility.PropertyFileReader;
import com.org.qa.utility.ReadFromExcel;
import com.org.qa.utility.ReadMail;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author Gopal Pandey
 *
 */
public class TestData extends TestBase {

	WebDriver driver;
	LoginPage loginPage;
	SearchFlightPage selectFlight;
	FlightReservationPage flightReservation;
	FlightBookingPage flightBooking;
	FlightConfirmationPage flightConfirm;
	ExtentReports report;
	ExtentTest test;
	Logger log;

	public TestData() {
		super();
	}

	@BeforeTest
	public void setUp() {
		log = getLogger();
		driver = initization();
		driver.get(PropertyFileReader.getUrl());
		report = getReport();

	}

	@Test(priority = 1, enabled = true, description = "Description: Testing if user is able to login to Mecrcury Tours")
	public void loginToMercuryTours() {
		test = report.startTest("Loging page in  Mercury Tours ");
		loginPage = new LoginPage(driver);
		selectFlight = new SearchFlightPage(driver);
		flightReservation = new FlightReservationPage(driver);
		flightConfirm = new FlightConfirmationPage(driver);
		String title = loginPage.validateLoginPageTitle();

		try {
			Assert.assertEquals(title, "Welcome: Mercury Tours");
			ExtentLog.extentLogInfo("Mercury Tours title Validate", test, log);
			ExtentLog.extentLogInfo("Your are in  Mercury Tours", test, log);
		} catch (Exception e) {
			ExtentLog.extentLogError("Mercury Tours title Not Validate", test, log);
			ExtentLog.extentLogError("Your are Not In Mercury Tours", test, log);
			ExtentLog.logFail("Screenshot taken", test, log, driver);
		}
		boolean flag = loginPage.applicationValidation();
		try {
			Assert.assertTrue(flag);
			ExtentLog.extentLogInfo("Your are In Mercury Tours Login Page", test, log);
		} catch (Exception e) {
			ExtentLog.extentLogError("Your are Not In Mercury Tours Login Page", test, log);
			ExtentLog.logFail("Screenshot taken", test, log, driver);
		}
		if (loginPage.login(PropertyFileReader.userName(), PropertyFileReader.password())) {
			ExtentLog.extentLogInfo(
					"UserName " + PropertyFileReader.userName() + " Password "+PropertyFileReader.password() + "Send",
					test, log);
		} else {
			ExtentLog.extentLogError("UserName Password Not Send", test, log);
			ExtentLog.logFail("Screenshot taken", test, log, driver);
		}
	}

	@DataProvider(name = "fligtReservationData" )
	public Object[][] flightData() {
		Object[][] data = null;
		data = ReadFromExcel.excelFile(PropertyFileReader.excelPath(), "Sheet1");
		return data;
	}

	@Test(dependsOnMethods = { "loginToMercuryTours" }, priority = 2, dataProvider = "fligtReservationData", description = "Description: Testing if user is able to fill flight data to Mecrcury Tours")
	public void flightReservationTest(String pageValidation, String passenger, String departPlace, String deparMonth,
			String departDate, String arrivePlace, String returnMonth, String returnDate, String classes,
			String airlines) {
		test = report.startTest("Flight Reservation in  Mercury Tours ");
		flightReservation = new FlightReservationPage(driver);
		String flightReservationPage = flightReservation.filghtReservationValidation();
		try {
			Assert.assertEquals(flightReservationPage, pageValidation);
			ExtentLog.extentLogInfo("Your are In Mercury Tours Flight Reservation Page", test, log);
		} catch (Exception e) {
			ExtentLog.extentLogError("Your are Not In Mercury Tours Flight Reservation Page", test, log);
			ExtentLog.logFail("Screenshot taken", test, log, driver);
		}

		if (flightReservation.createNewContact(passenger, departPlace, deparMonth, departDate, arrivePlace, returnMonth,
				returnDate, classes, airlines)) {
			ExtentLog.extentLogInfo("Flight information Data Send", test, log);
		} else {
			ExtentLog.extentLogError("Flight information Data not Send", test, log);
			ExtentLog.logFail("Screenshot taken", test, log, driver);
		}
	}

	@DataProvider(name = "fligtSearchData")
	public Object[][] flightName() {
		Object[][] data = null;
		data = ReadFromExcel.excelFile(PropertyFileReader.excelPathOne(), "Sheet1");
		return data;
	}

	@Test(dependsOnMethods = { "flightReservationTest" }, dataProvider = "fligtSearchData", priority = 3 , description = "Description: Testing if user is able to select a flight to Mecrcury Tours")
	public void searchFlightTest(String searchPageValidation, String departFlightName, String returnFlightName) {
		test = report.startTest("search Flight in  Mercury Tours ");
		selectFlight = new SearchFlightPage(driver);
		String searchFlightnPage = selectFlight.verifySearchFlightPage();
		try {
			Assert.assertEquals(searchFlightnPage, searchPageValidation);
			ExtentLog.extentLogInfo("Your are  In Mercury Tours select Flight Page", test, log);
		} catch (Exception e) {
			ExtentLog.extentLogError("Your are Not In Mercury Tours  select Flight Page", test, log);
			ExtentLog.logFail("Screenshot taken", test, log, driver);
		}

		if (selectFlight.selectFlights(departFlightName, returnFlightName)) {
			ExtentLog.extentLogInfo("Flight Name  Data Send", test, log);
		} else {
			ExtentLog.extentLogError("Flight Name  Data not  Send", test, log);
			ExtentLog.logFail("Screenshot taken", test, log, driver);
		}
	}

	@DataProvider(name = "fligtTicketPurchaseData")
	public Object[][] flightTicketPurchase() {
		Object[][] data = null;
		data = ReadFromExcel.excelFile(PropertyFileReader.excelPathTwo(), "Sheet1");
		return data;
	}

	@Test(dependsOnMethods = { "searchFlightTest" }, priority = 4, dataProvider = "fligtTicketPurchaseData" , description = "Description: Testing if user is able to Book a flight to Mecrcury Tours")
	public void flightPurchaseTest(String flightPurchaseValidation, String ticketPrice, String fisrtNamePass,
			String lastNamePass, String mealTypeFisrtPass, String secFirstNamePass, String secLastNamePass,
			String mealTypeSecPass, String card, String cardNo, String cardExpMonths, String cardExpYear,
			String firstNameCardholder, String midNameCardholder, String lastNameCardholder, String billingAddr,
			String billCity, String billState, String billPin, String delvrAddr, String delvrCity, String delvrState,
			String delvrPin) {
		test = report.startTest("Flight Booking in  Mercury Tours ");
		flightBooking = new FlightBookingPage(driver);
		String flightPurchasePageValidation = flightBooking.filghtReservationValidation();
		try {
			Assert.assertEquals(flightPurchasePageValidation, flightPurchaseValidation);
			ExtentLog.extentLogInfo("Your are  In Mercury Tours Flight Purchase Page", test, log);
		} catch (Exception e) {
			ExtentLog.extentLogError("Your are Not In Mercury Tours Flight Purchase Page", test, log);
			ExtentLog.logFail("Screenshot taken", test, log, driver);
		}
		String ticketPriceValidation = flightBooking.filghtPriceValidation();
		try {
			Assert.assertEquals(ticketPriceValidation, ticketPrice);
			ExtentLog.extentLogInfo("Ticket Price Validated " + ticketPriceValidation, test, log);
		} catch (Exception e) {
			ExtentLog.extentLogError("Ticket Price Not Validated " + ticketPriceValidation, test, log);
			ExtentLog.logFail("Screenshot taken", test, log, driver);
		}

		if (flightBooking.personalInformation(fisrtNamePass, lastNamePass, mealTypeFisrtPass, secFirstNamePass,
				secLastNamePass, mealTypeSecPass, card, cardNo, cardExpMonths, cardExpYear, firstNameCardholder,
				midNameCardholder, lastNameCardholder, billingAddr, billCity, billState, billPin, delvrAddr, delvrCity,
				delvrState, delvrPin)) {
			ExtentLog.extentLogInfo("Customer Information data send", test, log);
		} else {
			ExtentLog.extentLogError("Customer Information data Not send", test, log);
			ExtentLog.logFail("Screenshot taken", test, log, driver);
		}
	}

	@DataProvider(name = "flightConfirmation")
	public Object[][] flightConfirmation() {
		Object[][] data = null;
		data = ReadFromExcel.excelFile(PropertyFileReader.excelPathThree(), "Sheet1");
		return data;
	}

	@Test(dependsOnMethods = { "flightPurchaseTest" }, priority = 5, dataProvider = "flightConfirmation" , description = "Description: Testing if user is able to get confirmation of flight and logout user should able to see signup page to Mecrcury Tours")
	public void flightConfirmationTest(String flightConfirmationValidation, String bookingToastMessage,
			String totalPriceValidation, String singUpPageValidation) {
		test = report.startTest("Flight Conformation in  Mercury Tours ");
		String flightConfirmationPageValidation = flightConfirm.filghtConfirmationPageValidation();
		try {
			Assert.assertEquals(flightConfirmationPageValidation, flightConfirmationValidation);
			ExtentLog.extentLogInfo("Your are In Mercury Tours Flight confirmation Page", test, log);
		} catch (Exception e) {
			ExtentLog.extentLogError("Your are not  In Mercury Tours Flight confirmation Page", test, log);
			ExtentLog.logFail("Screenshot taken", test, log, driver);
		}

		String bookingToastMessageValidation = flightConfirm.bookingToastMessageValidation();
		try {
			Assert.assertEquals(bookingToastMessageValidation, bookingToastMessage);
			ExtentLog.extentLogInfo("Booking Toast Message Validated " + bookingToastMessageValidation, test, log);
		} catch (Exception e) {
			ExtentLog.extentLogError("Booking Not Toast Message Validated " + bookingToastMessageValidation, test, log);
			ExtentLog.logFail("Screenshot taken", test, log, driver);
		}
		String totalPrice = flightConfirm.totalPriceValidation();
		try {
			Assert.assertEquals(totalPriceValidation, totalPrice);
			ExtentLog.extentLogInfo("Ticket Total Price Validated " + totalPrice, test, log);
		} catch (Exception e) {
			ExtentLog.extentLogError("Ticket Total Price not Validated " + totalPrice, test, log);
			ExtentLog.logFail("Screenshot taken", test, log, driver);
		}

		flightConfirm.clickOncontinueBtn();
		String singUpPage = flightConfirm.signUpPageValidation();
		try {
			Assert.assertEquals(singUpPageValidation, singUpPage);
			ExtentLog.extentLogInfo("Your are  In Mercury Tours Sing Up Page", test, log);
			ExtentLog.logPass("Pass ScreenShot taken", test, log, driver);                   //Here i take screendhot for pass testcases
		} catch (Exception e) {
			ExtentLog.extentLogError("Your are Not In Mercury Tours Sing Up Page", test, log);
			ExtentLog.logFail("Screenshot taken", test, log, driver);
		}

	}

	@AfterTest
	public void tearDown() {
		report.flush();
		report.endTest(test);
		driver.quit();
		ReadMail.email();
	}

}
