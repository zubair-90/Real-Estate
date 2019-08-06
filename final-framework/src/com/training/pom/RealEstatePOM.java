package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generics.GenericMethods;
import com.training.sanity.tests.SimpleTestCasesTest;
import com.trianing.waits.WaitTypes;

public class RealEstatePOM {

	private WebDriver driver; 
	private GenericMethods genericMethods ;
	private WaitTypes waitTypes;
	private SimpleTestCasesTest simpleTestCasesTest;
	public RealEstatePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Real Estate']")
	private WebElement realEstateIcon;

	public void clickRealEstateIcon(){

		this.realEstateIcon.click();
	}
	
	@FindBy(xpath="//input[@title='Search input']")
	private WebElement addedPropertySearch;

	public void sendAddedPropertySearch(String property){

		this.addedPropertySearch.clear();
		this.addedPropertySearch.sendKeys(property);
	}
	
	@FindBy(xpath="//div[@id=\"mCSBap_1_container\"]/div/div[1]/div[1]/h3/a/span")
	private WebElement addedProperty;

	public void clcikAddedProperty(){

		Actions a = new Actions(driver);
		a.moveToElement(addedProperty).click().build().perform();
	}
	
	
}
