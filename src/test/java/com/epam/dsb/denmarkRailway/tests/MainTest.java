package com.epam.dsb.denmarkRailway.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.epam.dsb.denmarkRailway.pages.CombinedMuseumReturnTrainTicketPage;
import com.epam.dsb.denmarkRailway.pages.ConfirmYourBookingPage;
import com.epam.dsb.denmarkRailway.pages.DeliveryFormPage;
import com.epam.dsb.denmarkRailway.pages.MainPage;

public class MainTest extends AbstractTest{
	private static final By DATE_LOCATOR = By.xpath(".//*[@id='fastpriskalendertextfieldDpJs_cell24']/a");// !!!REVIEW!!!
	private static final String EMAIL = "sobaka@barabaka.com";
	private static final String ID = "VISA";
	private static final String FOUR_DIGITS_CREDIT_CARD = "1234";
	private static final String NAME_OF_PASSENGER = "Jen Pedersen";

	@Test
	public void Test() {
	MainPage mainpage= new MainPage();
	mainpage.openMainPage();
	CombinedMuseumReturnTrainTicketPage museumpage=mainpage.openCombinedMuseumReturnTrainTicketPage();
	DeliveryFormPage deliverypage=museumpage.openDeliveryFormPage();
	deliverypage.selectTravelDate(DATE_LOCATOR);
	deliverypage.enterYourEmailAdress(EMAIL);
	deliverypage.repeatYourEmailAdress(EMAIL);
	deliverypage.selectID(ID);
	deliverypage.enterLastFourDigitsOfCredutCard(FOUR_DIGITS_CREDIT_CARD);
	deliverypage.enterNameOfPassenger(NAME_OF_PASSENGER);
	ConfirmYourBookingPage bookingPage=deliverypage.openConfirmYourBookingPage();
	
	}

}
