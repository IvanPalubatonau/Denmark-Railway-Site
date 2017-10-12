package com.epam.dsb.denmarkRailway.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import com.epam.dsb.denmarkRailway.utils.WebDriverSingletone;

public abstract class AbstractTest {
	protected WebDriver driver;

	@BeforeTest
	public void initBrowser() {
		driver = WebDriverSingletone.getMyBrowser();
	}

	@AfterTest
	public void closeBrowser() {
		//driver.close();
	}

}
