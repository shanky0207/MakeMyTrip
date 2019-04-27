package com.makeMyTrip.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.makeMyTrip.base.TestBase;
import com.makeMyTrip.util.UserdefinedFunctions;

public class MakeMyTripPage extends TestBase  {

	@FindBy(xpath="//label[@for='filter_stop0']/span[contains(text(),'Non Stop')]//preceding::span[1]")
	WebElement nonStopCheckbox;

	@FindBy(xpath="//label[@for='filter_stop1']/span[contains(text(),'1 Stop')]//preceding::span[1]")
	WebElement oneStopCheckbox;

	@FindBy(xpath="//*[@id=\"ow_domrt-jrny\"]/div[2]/div[5]/label/div[1]/span[1]")
	WebElement departureRadioButton;

	@FindBy(xpath="//*[@id=\"rt-domrt-jrny\"]/div[2]/div[4]/label/div[1]/span[1]")
	WebElement returnFlightRadioButton;

	@FindBy(xpath="//*[@id=\"ow_domrt-jrny\"]/div[2]/div[5]/label/div[2]/div[3]/p/span")
	WebElement departurePrice;

	@FindBy(xpath="//*[@id=\"rt-domrt-jrny\"]/div[2]/div[4]/label/div[2]/div[3]/p/span")
	WebElement returnPrice;

	@FindBy(xpath="//*[@id=\"left-side--wrapper\"]/div[2]/div/div[3]/div/div[1]/div/div[2]/div/div[2]/div[4]/p/span")
	WebElement returnPriceAtBottom;

	@FindBy(xpath="//*[@id=\"left-side--wrapper\"]/div[2]/div/div[3]/div/div[1]/div/div[1]/div/div[2]/div[4]/p/span")
	WebElement departurePriceAtBottom;

	@FindBy(xpath="//span[@class='splitVw-total-fare']")
	WebElement totalFareAmount;

	@FindBy(xpath="//div[@class='fli-list splitVw-listing']/input[@name='splitowJourney']")
	List<WebElement> depatureFlight;

	@FindBy(xpath="//div[@class='splitVw-sctn pull-right']//div[@class='fli-list splitVw-listing']")
	List<WebElement> returnFlight;

	@FindBy(xpath="//span[@class='deal-tag']//following::span[1]")
	WebElement discountTagAmount;


	public MakeMyTripPage() {

		PageFactory.initElements(driver, this);
	}

	//to get total number of departure Flight records
	public void getDepartureFlightcount()
	{
		UserdefinedFunctions.scrollTillBottomPage();
		waitForSeconds(5);
		UserdefinedFunctions.scrollTillBottomPage();
		waitForSeconds(5);
		UserdefinedFunctions.scrollTillBottomPage();
		waitForSeconds(5);
		UserdefinedFunctions.scrollTillBottomPage();
		waitForSeconds(5);
		UserdefinedFunctions.scrollTillBottomPage();
		waitForSeconds(5);
		//List<WebElement> depatureFlight = driver.findElements(By.xpath("//div[@class='fli-list splitVw-listing']/input[@name='splitowJourney']"));
		int count = depatureFlight.size();
		System.out.println("Total number of departure Flight records: "+count);
	}


	//to get total number of return Flight records
	public void getReturnFlightCount()
	{
		UserdefinedFunctions.scrollTillBottomPage();
		waitForSeconds(5);
		UserdefinedFunctions.scrollTillBottomPage();
		waitForSeconds(5);
		UserdefinedFunctions.scrollTillBottomPage();
		waitForSeconds(5);
		UserdefinedFunctions.scrollTillBottomPage();
		waitForSeconds(5);
		UserdefinedFunctions.scrollTillBottomPage();
		waitForSeconds(5);
		//List<WebElement> depatureFlight = driver.findElements(By.xpath("//div[@class='splitVw-sctn pull-right']//div[@class='fli-list splitVw-listing']"));
		int count = returnFlight.size();
		System.out.println("Total number of Return Flight records: "+count);
	}

	//to clicl on the requred filter(Nonstop/Onestop) and get total number of departure and return Flight records
	public void clickOnFilterAndgetDepAndRetrCount(String filter)
	{
		if(filter.equalsIgnoreCase("NonStop"))
		{
			nonStopCheckbox.click();
			getDepartureFlightcount();
			getReturnFlightCount();
		}
		else if(filter.equalsIgnoreCase("OneStop"))
		{
			oneStopCheckbox.click();
			getDepartureFlightcount();
			getReturnFlightCount();
		}
		else
		{
			System.out.println("Please select the correct filter");
		}
	}

	// to click on Departure Radio Button present on 5th row
	public void clickOnDepartureRadioButton()
	{
		if(departureRadioButton.isDisplayed())
		{
			waitForSeconds(10);
			UserdefinedFunctions.scrollusingCordinate();
			waitForSeconds(10);
			departureRadioButton.click();
		}
		else
		{
			System.out.println("Consider the first selected depature flight");
		}
	}

	// to click on Return Radio Button present on 4th row
	public void clickOnReturnRadioButton()
	{
		if(departureRadioButton.isDisplayed())
		{
			waitForSeconds(5);
			returnFlightRadioButton.click();
		}
		else
		{
			waitForSeconds(10);
			UserdefinedFunctions.scrollusingCordinate();
			waitForSeconds(10);
			returnFlightRadioButton.click();
		}

	}

	// to get selected departure Flight price Amount
	public String getDepartureFlightPrice()
	{
		String depPrice=departurePrice.getText();
		return depPrice;
	}

	// to get departure Flight price which is present at bottom
	public String getDepartureFlightPriceAtBottom()
	{
		String depPriceAtBottom=departurePriceAtBottom.getText();
		return depPriceAtBottom;
	}

	// to get selected Return Flight price Amount
	public String getReturnFlightPrice()
	{
		String returnprice=returnPrice.getText();
		return returnprice;

	}

	// to get return Flight price which is present at bottom
	public String getReturnFlightPriceAtBottom()
	{
		String returnpriceAtBottom=returnPriceAtBottom.getText();
		return returnpriceAtBottom;
	}

	//to calculate total amount of departure flight price and return flight price
	public String getTotalAmountOfTicketFlight()
	{
		int sum;

		int departurePriceAtbottom = Integer.parseInt(getDepartureFlightPriceAtBottom().replaceAll("[Rs ,]", ""));
		int returnPriceAtbottom = Integer.parseInt(getReturnFlightPriceAtBottom().replaceAll("[Rs ,]", ""));
		
		waitForSeconds(5);

		if(driver.getPageSource().contains("Return trip discount")) {
			int dAmount = Integer.parseInt(discountTagAmount.getText().replaceAll("[Rs ]", ""));
			sum = (departurePriceAtbottom + returnPriceAtbottom)- dAmount;

		}
		else 
		{

			sum = departurePriceAtbottom + returnPriceAtbottom;
		}


		return String.valueOf(sum);
	}

	//to get total amount present at bottom of the page
	public String getTotalFareAmt()
	{

		String totalamt = totalFareAmount.getText().replaceAll("[Rs ,]", "");

		return String.valueOf(totalamt);
	}
}


