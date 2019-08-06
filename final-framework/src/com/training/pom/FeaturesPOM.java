package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FeaturesPOM {
	
private WebDriver driver;
	
	public FeaturesPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="tag-name")
	private WebElement name;
	public void sendName(String name)
	{
		this.name.clear();
		this.name.sendKeys(name);
	}
	
	
	@FindBy(xpath="//input[@id='tag-slug']")
	private WebElement slug;
	public void sendSlug(String slug)
	{
		this.slug.clear();
		this.slug.sendKeys(slug);
	}
	
	@FindBy(xpath="//textarea[@id='tag-description']")
	private WebElement description;
	public void sendDescription(String description)
	{
		this.description.clear();
		this.description.sendKeys(description);
	}
	
	@FindBy(xpath="//input[@value='Add New Feature']")
	private WebElement addNewFeaturebtn;
	public void clickAddNewFeaturebtn()
	{
		this.addNewFeaturebtn.click();
	}
	
}
