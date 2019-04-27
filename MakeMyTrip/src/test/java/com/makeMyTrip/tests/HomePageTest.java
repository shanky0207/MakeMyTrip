package com.makeMyTrip.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.makeMyTrip.base.TestBase;
import com.makeMyTrip.pages.HomePage;
import com.makeMyTrip.pages.MakeMyTripPage;



public class HomePageTest extends TestBase {

	HomePage homepage;
	MakeMyTripPage makemytrippage;

	@BeforeMethod
	public void setupHomePage() {
		initilization();
	}

	@Test
	public void verifyhomePageTitleTest() {
		homepage = new HomePage();
		
		homepage.clickOnFlightLink();
		homepage.clickOnRoundTrip();
		homepage.selectFromandToDetails();
		homepage.selectDepartureDate();
		homepage.selectReturnDate();
		makemytrippage=homepage.clickOnSearchButton();
	}

	

	@AfterMethod
	public void teardown() {
		//driver.quit();
	}
}
