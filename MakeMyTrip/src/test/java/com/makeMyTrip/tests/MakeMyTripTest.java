package com.makeMyTrip.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.makeMyTrip.base.TestBase;
import com.makeMyTrip.pages.HomePage;
import com.makeMyTrip.pages.MakeMyTripPage;



public class MakeMyTripTest extends TestBase {

	HomePage homepage;
	MakeMyTripPage makemytrippage;

	@BeforeMethod
	public void setUpForMakeMyTripPage()
	{
		initilization();
		homepage= new HomePage();
		homepage.clickOnFlightLink();
		homepage.clickOnRoundTrip();
		homepage.selectFromandToDetails();
		homepage.selectDepartureDate();
		homepage.selectReturnDate();
		makemytrippage=homepage.clickOnSearchButton();
	}

	@Test(priority=1, enabled=true)
	public void getDepartureAndReturnFlightRecordTest()
	{
		makemytrippage.getDepartureFlightcount();
		makemytrippage.getReturnFlightCount();
	}

	@Test(priority=2, enabled=true)
	public void getDepAndRetRecordNonStopCheckboxTest()
	{
		makemytrippage.clickOnFilterAndgetDepAndRetrCount("NonStop");
	}

	@Test(priority=3,enabled=true)
	public void getDepAndRetRecordOneStopCheckboxTest()
	{
		makemytrippage.clickOnFilterAndgetDepAndRetrCount("OneStop");

	}


	@Test(priority=4,enabled=true)
	public void verifyDepartureAndReturnPriceTest()
	{
		makemytrippage.clickOnDepartureRadioButton();
		makemytrippage.clickOnReturnRadioButton();
		Assert.assertEquals(makemytrippage.getDepartureFlightPrice(), makemytrippage.getDepartureFlightPriceAtBottom());
		Assert.assertEquals(makemytrippage.getReturnFlightPrice(),(makemytrippage.getReturnFlightPriceAtBottom()));
		Assert.assertEquals(makemytrippage.getTotalFareAmt(), makemytrippage.getTotalAmountOfTicketFlight());
		

	}

	@AfterMethod
	public void teardown() {
		//driver.quit();
	}
}
