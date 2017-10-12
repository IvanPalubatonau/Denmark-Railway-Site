package com.epam.dsb.denmarkRailway.pages;

import org.openqa.selenium.By;

public class DeliveryFormPage extends AbstractPage {

	private static final By SELECT_TRAVEL_DATE_WINDOW_LOCATOR = By.xpath(".//*[@id='fastpriskalendertextfield']");// !!!REVIEW!!!
	private static final By YOUR_EMAIL_ADRESS_WINDOW_LOCATOR = By.xpath(".//*[@id='id80']");// !!!REVIEW!!!
	private static final By REPEAT_YOUR_EMAIL_ADRESS_WINDOW_LOCATOR = By.xpath(".//*[@id='emailGentag']");// !!!REVIEW!!!
	private static final By SELECT_ID_WINDOW_LOCATOR = By.xpath("//select[@id='kortFelt']");// !!!REVIEW!!!
	private static final By ENTER_LAST_FOUR_DIGITS_WINDOW_LOCATOR = By.xpath(".//*[@id='cifreFelt']");// !!!REVIEW!!!
	private static final By NAME_OF_PASSENGER_WINDOW_LOCATOR = By.xpath(".//*[@id='navneFelt']");// !!!REVIEW!!!
	private static final By CONTINUE_BTN_LOCATOR = By.xpath(".//*[@id='fortsaetKnap']");// !!!REVIEW!!!
	// private static final By DATE_LOCATOR =
	// By.xpath(".//*[@id='fortsaetKnap']");// !!!REVIEW!!!????

	public void selectTravelDate(By locator) {

		selectElementInDropMenu(SELECT_TRAVEL_DATE_WINDOW_LOCATOR, locator);
	}

	public void enterYourEmailAdress(String emailAdress) {

		type(YOUR_EMAIL_ADRESS_WINDOW_LOCATOR, emailAdress);
	}

	public void repeatYourEmailAdress(String emailAdress) {

		type(REPEAT_YOUR_EMAIL_ADRESS_WINDOW_LOCATOR, emailAdress);
	}

	public void selectID(String ID) {

		selectByVisibleText(SELECT_ID_WINDOW_LOCATOR, ID);

	}

	public void enterLastFourDigitsOfCredutCard(String fourDigits) {

		type(ENTER_LAST_FOUR_DIGITS_WINDOW_LOCATOR, fourDigits);
	}

	public void enterNameOfPassenger(String fullName) {

		type(NAME_OF_PASSENGER_WINDOW_LOCATOR, fullName);
	}

	public ConfirmYourBookingPage openConfirmYourBookingPage() {

		click(CONTINUE_BTN_LOCATOR);
		return new ConfirmYourBookingPage();
	}

}