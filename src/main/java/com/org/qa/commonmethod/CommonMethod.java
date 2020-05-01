package com.org.qa.commonmethod;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.org.qa.utility.Log;

/**
 * @author Gopal Pandey
 *
 */
public class CommonMethod {


	public static boolean click(WebElement click) {
		try {

			click.click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;

	}

	public static boolean navigateToUrl(WebDriver driver, String url, Logger log) {

		try {
			driver.get(url);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;

	}

	public static boolean sendElement(String data, WebElement send) {
		try {
			send.sendKeys(data);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;

	}

	public static WebElement getElement(By selector, WebDriver driver) {
		try {
			return driver.findElement(selector);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static List<WebElement> fetchElements(By selector, WebElement element) {
		try {
			return element.findElements(selector);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static List<WebElement> getElements(By selector, WebDriver driver) {
		try {
			return driver.findElements(selector);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	public static String getPageTitle(WebDriver driver) {

		try {

			System.out.println(driver.getTitle());

			return driver.getTitle();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	public static boolean selectByValue(WebElement element, String value) {
		try {
			Select select = new Select(element);
			select.selectByValue(value);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public static boolean selectByVisibleText(WebElement element, String value) {
		try {
			Select month = new Select(element);
			month.selectByVisibleText(value);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public static boolean ratioButtonSelector(List<WebElement> element, String Value) {
		try {

			for (int i = 0; i < element.size(); i++) {
				if (element.get(i).getAttribute("value").equalsIgnoreCase(Value)) {
					if (element.get(i).isEnabled()) {
						element.get(i).click();
					}
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

}
