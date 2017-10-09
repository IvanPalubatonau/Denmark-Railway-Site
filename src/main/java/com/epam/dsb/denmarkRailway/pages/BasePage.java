package com.epam.dsb.denmarkRailway.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.epam.dsb.denmarkRailway.utils.WebDriverSingletone;



public class BasePage 
{
	

	protected WebDriver driver;
	

	protected BasePage() {
		this.driver=WebDriverSingletone.getMyBrowser();
	}

	
	
	public void open(String url) {
	       // Logger.info("Going to URL: " + url);
		driver.get(url);
	    }
	
	public void click(final By locator) {
        //waitForElementVisible(locator);
      //  Logger.info("Clicking element '" + driver.findElement(locator).getText() + "' (Located: " + locator + ")");
       // highlightElement(locator);
       // takeScreenshot();
       // unHighlightElement(locator);
		driver.findElement(locator).click();
    }
}
