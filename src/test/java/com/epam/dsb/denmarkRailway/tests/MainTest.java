package com.epam.dsb.denmarkRailway.tests;

import org.testng.annotations.Test;

import com.epam.dsb.denmarkRailway.pages.CombinedMuseumReturnTrainTicketPage;
import com.epam.dsb.denmarkRailway.pages.MainPage;

public class MainTest extends AbstactTest{
	

	@Test
	public void Test() {
	MainPage mainpage= new MainPage();
	mainpage.openMainPage();
	CombinedMuseumReturnTrainTicketPage museumpage=mainpage.openCombinedMuseumReturnTrainTicketPage();
	
	
	}

}
