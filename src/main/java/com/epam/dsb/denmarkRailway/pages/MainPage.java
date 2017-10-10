package com.epam.dsb.denmarkRailway.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.epam.dsb.denmarkRailway.utils.WebDriverSingletone;





public class MainPage extends BasePage {
	
	public static final String URL = "https://www.dsb.dk/en";
	private static final By SEARCH_JOURNEY_BTN_LOCATOR = By.id("formSubmitBtn");
	private static final By COMBINED_MUSEUM_RETURN_TRAIN_TICKET_HYPERLINK_LOCATOR = By.xpath("//a[@href='/en/travelling-in-the-cities/combined-museum-and-return-tickets/']");// !!!REVIEW!!!
	
	
	public MainPage openMainPage() {
        open(URL);
        return this;
    }
 
	public void openCombinedMuseumReturnTrainTicketPage() {
        click(COMBINED_MUSEUM_RETURN_TRAIN_TICKET_HYPERLINK_LOCATOR);
      
    }
	
}