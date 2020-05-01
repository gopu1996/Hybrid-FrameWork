package com.org.qa.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;

/**
 * @author Gopal Pandey
 *
 */
public class ExtentReport {
	
	private static String name;

	
	public static ExtentReports generateReport() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");

		name = ".\\report\\" + format.format(new Date()) + ".html";
		ExtentReports report = new ExtentReports(name);
		return report;

	}

	public static String getFile() {
		return name;
	}

}
