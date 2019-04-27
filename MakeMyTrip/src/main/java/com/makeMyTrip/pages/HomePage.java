package com.makeMyTrip.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.makeMyTrip.base.TestBase;
import com.makeMyTrip.util.UserdefinedFunctions;



public class HomePage extends TestBase {

	@FindBy(linkText="Flights")
	WebElement flightLink;

	@FindBy(xpath="//li[contains(text(),'Round Trip')]")
	WebElement roundTripButton;

	@FindBy(xpath="//span[contains(text(),'From')]")
	WebElement fromButton;

	@FindBy(xpath="//input[@type='text' and @class='react-autosuggest__input react-autosuggest__input--open']")
	WebElement fromTextbox;

	@FindBy(xpath="//div[@class='calc60']/p[contains(text(),'Delhi, India')]")
	WebElement selectDelhi;

	@FindBy(xpath="//div[@class='calc60']/p[contains(text(),'Bangalore, India')]")
	WebElement selectBanglore;

	//to select current date
	@FindBy(xpath="//div[@class='DayPicker-Day DayPicker-Day--start DayPicker-Day--selected']//preceding::div[1]")
	WebElement selectDepartureDate;

	//to select next day date
	/*@FindBy(xpath="//div[@class='DayPicker-Day DayPicker-Day--start DayPicker-Day--selected']")
	WebElement selectDepartureDate;*/

	@FindBy(xpath="//a[contains(text(),'Search')]")
	WebElement searchButton;

	public HomePage() {

		PageFactory.initElements(driver, this);

	}

	public void clickOnFlightLink()
	{
		flightLink.click();
	}

	public void clickOnRoundTrip()
	{
		roundTripButton.click();
	}

	public void selectFromandToDetails()
	{
		fromButton.click();
		selectDelhi.click();
		selectBanglore.click();
	}

	public void selectDepartureDate()
	{
		selectDepartureDate.click();
	}

	public void selectReturnDate()
	{
		int day=UserdefinedFunctions.getReturnDate();
		List<WebElement> row = driver.findElements(By.xpath("//div[@class='DayPicker-Day']"));
		for (WebElement cell: row) {

			if (cell.getText().equals(String.valueOf(day))) {
				cell.click();
				break;
			}
		}
	}

	public MakeMyTripPage clickOnSearchButton()
	{
		searchButton.click();
		driver.manage().deleteAllCookies();

		return new MakeMyTripPage();
	}
}
