package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PropertiesPOM {

	private WebDriver driver;
	
	public PropertiesPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='All Properties']")
	private WebElement allPropertiesLink;
	
	public WebElement  verifyAllPropertiesLink()
	{
		return allPropertiesLink;
	}
	
	@FindBy(xpath="//li[@id=\"menu-posts-property\"]/ul/li[3]/a")
	private WebElement addNewLink;
	
	public WebElement  verifyAddNewLink()
	{
		return addNewLink;
	}
	
	@FindBy(xpath="//li[@id=\"menu-posts-property\"]/ul/li[3]/a")
	private WebElement addNewLnk;
	
	public void  clickAddNewLink()
	{
		this.addNewLnk.click();
	}
	
	@FindBy(xpath="//a[text()='Features']")
	private WebElement featuresLink;
	
	public WebElement  verifyFeaturesLink()
	{
		return featuresLink;
	}
	
	@FindBy(xpath="//a[text()='Features']")
	private WebElement featureLink;
	
	public void  clickFeaturesLink()
	{
		this.featureLink.click();
	}
	
	@FindBy(xpath="//a[text()='Regions']")
	private WebElement regionsLink;
	
	public WebElement  verifyregionsLink()
	{
		return regionsLink;
	}
	
	@FindBy(xpath="//a[text()='Properties Settings']")
	private WebElement propertiesSettingLink;
	
	public WebElement  verifypropertiesSettingLink()
	{
		return propertiesSettingLink;
	}
	
}
