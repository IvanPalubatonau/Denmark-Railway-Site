package com.epam.dsb.denmarkRailway.pages;

import org.openqa.selenium.By;

public class CombinedMuseumReturnTrainTicketPage extends AbstractPage {

	private static final By BUY_YOUR_TRAIN_AND_MUSEUM_OF_MARITANE_TICKET_BTN_LOCATOR = By
			.xpath("//a[@title='Buy your train and Museum of Maritime ticket']");// !!!REVIEW!!!

	public DeliveryFormPage openDeliveryFormPage() {
		click(BUY_YOUR_TRAIN_AND_MUSEUM_OF_MARITANE_TICKET_BTN_LOCATOR);
		return new DeliveryFormPage();

	}

}
