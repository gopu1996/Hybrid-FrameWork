package com.org.qa.utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


/**
 * @author Gopal Pandey
 *
 */
public class Screenshot {

	public static String capture(WebDriver driver) {

		DateTimeFormatter date = DateTimeFormatter.ofPattern("dd_MM_yy_HH_mm_ss");
		LocalDateTime now = LocalDateTime.now();
		TakesScreenshot ts=(TakesScreenshot) driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir")+"/screenshot/"+date.format(now)+".jpg";
        File destination=new File(path);

        try 
        {
            FileUtils.copyFile(src, destination);
        } catch (IOException e) 
        {
            System.out.println("Capture Failed "+e.getMessage());
        }
        return path;
	}
}