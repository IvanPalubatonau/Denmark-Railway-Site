package com.epam.dsb.denmarkRailway.tests;

import org.testng.annotations.Test;

import com.epam.dsb.denmarkRailway.utils.Browser;



public class BaseTest{
	
	public static final String URL = "https://www.dsb.dk/en";
	//protected Browser browser;
	
	@Test
	public void Test() {
	Browser.getBrowser().open(URL);
	//browser.open(URL);
	}
}
