package com.org.qa.utility;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


/**
 * @author Gopal Pandey
 *
 */
public class ExtentLog {

	
	public static void extentLogInfo(String message, ExtentTest test, Logger log) {
		test.log(LogStatus.PASS, message);
		Log.info(message, log);

	}

	public static void extentLogWarn(String message, ExtentTest test, Logger log) {
		test.log(LogStatus.WARNING, message);
		Log.warn(message, log);

	}

	public static void logPass(String message, ExtentTest test, Logger log, WebDriver driver) {
		test.log(LogStatus.PASS, test.addScreenCapture(Screenshot.capture(driver)));
		Log.info(message, log);

	}

	public static void logFail(String message, ExtentTest test, Logger log, WebDriver driver) {
		test.log(LogStatus.FAIL, test.addScreenCapture(Screenshot.capture(driver)));
		Log.info(message, log);

	}

	public static void extentLogDebug(String message, ExtentTest test, Logger log) {
		test.log(LogStatus.PASS, message);
		Log.debug(message, log);

	}

	public static void extentLogError(String message, ExtentTest test, Logger log) {
		test.log(LogStatus.ERROR, message);
		Log.error(message, log);

	}

	public static void extentLogFatal(String message, ExtentTest test, Logger log) {
		test.log(LogStatus.FATAL, message);
		Log.fatal(message, log);

	}
}