package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generics.GenericMethods;
import com.trianing.waits.WaitTypes;

public class EditPropertyPOM {

	private WebDriver driver; 
	private GenericMethods genericMethods ;
	public EditPropertyPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='View post']")
	private WebElement viewPost;
	public WebElement verifyViewPostLink()
	{
		WaitTypes waitTypes= new WaitTypes(driver);
		waitTypes.presenceElementLocated(viewPost, 120);
		return viewPost;
	}
	
	
}
