package com.test.steps;

import java.net.MalformedURLException;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.test.driver.manager.DriverManager;

public class Common {

	public static RemoteWebDriver driver;

	public Common() {
		if (driver == null) {
			try {
				driver = DriverManager.getDriverDynamic();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
	}

}