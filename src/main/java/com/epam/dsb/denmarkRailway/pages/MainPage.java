package com.epam.dsb.denmarkRailway.pages;

import org.openqa.selenium.By;






public class MainPage extends AbstractPage {
	
	public static final String URL = "https://www.dsb.dk/en";
	private static final By COMBINED_MUSEUM_RETURN_TRAIN_TICKET_HYPERLINK_LOCATOR = By.xpath("//a[@href='/en/travelling-in-the-cities/combined-museum-and-return-tickets/']");// !!!REVIEW!!!
	
	
	public MainPage openMainPage() {
        open(URL);
        return this;
    }
 
	public CombinedMuseumReturnTrainTicketPage openCombinedMuseumReturnTrainTicketPage() {
        click(COMBINED_MUSEUM_RETURN_TRAIN_TICKET_HYPERLINK_LOCATOR);
		return new CombinedMuseumReturnTrainTicketPage();
      
    }
	
}