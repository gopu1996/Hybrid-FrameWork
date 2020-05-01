package com.org.qa.utility;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

/**
 * @author Gopal Pandey
 *
 */
public class Log {

	
	public static void LogFunc(Logger log) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
		SimpleLayout layout = new SimpleLayout();
		try {

			FileAppender append = new FileAppender(layout, "log\\" + format.format(new Date()) + ".log", true);
			log.addAppender(append);
		} catch (IOException e) {
			log.error(log);

		}
	}

	/**
	 * @param message
	 * @param log
	 */
	public static void info(String message, Logger log) {
		log.info(message);
	}

	/**
	 * @param message
	 * @param log
	 */
	public static void warn(String message, Logger log) {
		log.warn(message);
	}

	/**
	 * @param message
	 * @param log
	 */
	public static void error(String message, Logger log) {
		log.error(message);
	}

	/**
	 * @param message
	 * @param log
	 */
	public static void fatal(String message, Logger log) {
		log.fatal(message);
	}

	/**
	 * @param message
	 * @param log
	 */
	public static void debug(String message, Logger log) {
		log.debug(message);
	}

	/**
	 * @param Classname
	 * @return
	 */
	public static Logger logg(Class Classname) {
		Logger log = Logger.getLogger(Classname);
		return log;

	}
}
