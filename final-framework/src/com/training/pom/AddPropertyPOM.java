package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generics.GenericMethods;
import com.trianing.waits.WaitTypes;

public class AddPropertyPOM {

private WebDriver driver;
GenericMethods genericMethods;
	
	public AddPropertyPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//input[@name='post_title']")
	private WebElement postTitle;
	public void sendPostTitle(String postTitle)
	{
		this.postTitle.clear();
		this.postTitle.sendKeys(postTitle);
	}
	
	
	
	@FindBy(xpath="//textarea[@id=\"content\"]")
	private WebElement textArea;
	public void sendTextArea(String textArea)
	{
		this.textArea.clear();
		this.textArea.sendKeys(textArea);
	}
	
	
	@FindBy(xpath="//input[@id=\"in-region-38\"]")
	private WebElement featureCheckBox;
	public void clickFeatureCheckBox(WebDriver driver)
	{
		genericMethods=new GenericMethods(driver);
		genericMethods.scrollIntoView(featureCheckBox);
		genericMethods.jsClick(this.featureCheckBox); 
	}
	
	
	@FindBy(xpath="//input[@id='publish']")
	private WebElement publishbtn;
	public void clickPublishbtn()
	{
		WaitTypes waitTypes= new WaitTypes(driver);
		waitTypes.presenceElementLocated(publishbtn, 60);
		this.publishbtn.click();
	
	}
}


