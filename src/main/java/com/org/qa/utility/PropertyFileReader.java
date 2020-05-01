package com.org.qa.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Gopal Pandey
 *
 */
public class PropertyFileReader {

	private static String configfile = "config.properties";

	public static Properties loadProperties() {
		
		FileInputStream file = null;
		Properties property = new Properties();
		try {
			file = new FileInputStream(configfile);
			property.load(file);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return property;

	}


	public static String getCromeDriver() {

		String Driver = loadProperties().getProperty("cromeDriver");
		if (Driver != null) {
			return Driver;
		} else {
			throw new RuntimeException("Driver not Found");
		}
	}
	
	public static String getFireFoxDriver() {

		String Driver = loadProperties().getProperty("FireFoxDriver");
		if (Driver != null) {
			return Driver;
		} else {
			throw new RuntimeException("Driver not Found");
		}
	}
	
	public static String getIEDriver() {

		String Driver = loadProperties().getProperty("IEDriver");
		if (Driver != null) {
			return Driver;
		} else {
			throw new RuntimeException("Driver not Found");
		}
	}
	
	public static String excelPath() {

		String excelPath = loadProperties().getProperty("excel");
		if (excelPath != null) {
			return excelPath;
		} else {
			throw new RuntimeException("excel sheet not Found");
		}

	}

	public static String excelPathOne() {

		String excelPath = loadProperties().getProperty("excel1");
		if (excelPath != null) {
			return excelPath;
		} else {
			throw new RuntimeException("excel sheet not Found");
		}

	}

	public static String excelPathTwo() {

		String excelPath = loadProperties().getProperty("excel2");
		if (excelPath != null) {
			return excelPath;
		} else {
			throw new RuntimeException("excel sheet not Found");
		}
	}

	public static String excelPathThree() {

		String excelPath = loadProperties().getProperty("excel3");
		if (excelPath != null) {
			return excelPath;
		} else {
			throw new RuntimeException("excel sheet not Found");
		}
	}

	public static String userName() {

		String userName = loadProperties().getProperty("username");
		if (userName != null) {
			return userName;
		} else {
			throw new RuntimeException("userName not Found");
		}

	}

	public static String password() {

		String password = loadProperties().getProperty("password");
		if (password != null) {
			return password;
		} else {
			throw new RuntimeException("password not Found");
		}

	}

	
	public static String excelFilename() {

		String fileName = loadProperties().getProperty("filename");
		if (fileName != null) {
			return fileName;
		} else {
			throw new RuntimeException("excel sheet not Found");
		}

	}

	public static String excelSheetname() {

		String sheet = loadProperties().getProperty("sheet");
		if (sheet != null) {
			return sheet;
		} else {
			throw new RuntimeException("excel sheet not Found");
		}

	}


	public static String getUrl() {
		String url = loadProperties().getProperty("url");
		if (url != null) {
			return url;
		} else {
			throw new RuntimeException("url not found");
		}
	}

	public static long getWait() {
		String wait = loadProperties().getProperty("wait");
		if (wait != null) {
			return Long.parseLong(wait);
		} else {
			throw new RuntimeException("url not found");
		}
	}

	public static String browser() {
		String browser = loadProperties().getProperty("browser");
		if (browser != null) {
			return browser;
		} else {
			throw new RuntimeException("Browser not found");
		}
	}
}
