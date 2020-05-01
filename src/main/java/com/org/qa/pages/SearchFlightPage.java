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
public class SearchFlightPage {
      
	WebDriver  searchDriver;
      
	@FindBy(css = "img[src='/images/masts/mast_selectflight.gif']")
	@CacheLookup
	WebElement searchFlightPageValidation;

	@FindBy(css = "td[class='frame_action_xrows'] input")
	@CacheLookup
	List<WebElement> listOfFlight;

	@FindBy(name = "reserveFlights")
	@CacheLookup
	WebElement continueBtn;

	
	public SearchFlightPage(WebDriver driver) {
		searchDriver=driver;
		PageFactory.initElements(driver, this);
	}
	
	 public String verifySearchFlightPage() {
		 return searchFlightPageValidation.getAttribute("src");
	 }
     
	 public boolean selectFlights(String departFlightName , String returnFlightName) {
		 CommonMethod.ratioButtonSelector(listOfFlight, departFlightName);
		 CommonMethod.ratioButtonSelector(listOfFlight, returnFlightName);
		  CommonMethod.click(continueBtn);
       return true;
	 }
	 
}
