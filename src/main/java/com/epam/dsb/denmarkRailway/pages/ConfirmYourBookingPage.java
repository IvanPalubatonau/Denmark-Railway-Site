package com.epam.dsb.denmarkRailway.pages;

import org.openqa.selenium.By;

public class ConfirmYourBookingPage extends AbstractPage {
	
    private static final By PRICE_ELEMENT_LOCATOR = By.xpath(".//*[@id='rejse_info']/div/div/div[@class='kolonne5']");
    
    
    public String getPriceOfTicket() {
    	String priceOfTicket=getTextofElement(PRICE_ELEMENT_LOCATOR);
		return priceOfTicket;
    }
}
