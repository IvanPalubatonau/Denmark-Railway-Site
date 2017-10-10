package com.epam.dsb.denmarkRailway.tests;

import org.testng.annotations.Test;

import com.epam.dsb.denmarkRailway.pages.MainPage;
import com.epam.dsb.denmarkRailway.utils.WebDriverSingletone;



public class BaseTest{
	

	@Test
	public void Test() {
	
	MainPage mainpage= new MainPage();
	mainpage.openMainPage()
	.openCombinedMuseumReturnTrainTicketPage();
	
	
	}
}
