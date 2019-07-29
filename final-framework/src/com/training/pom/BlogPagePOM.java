package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generics.GenericMethods;
import com.trianing.waits.WaitTypes;

public class BlogPagePOM {

	private WebDriver driver; 
	private WaitTypes waitTypes;
	public BlogPagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='New Launches']")
	private WebElement blog;

	public WebElement verifyAddedPostInBlog() {

		return blog;
	}

	@FindBy(xpath="//li[@id=\"menu-item-617\"]/a")
	private WebElement allBlog;

	public void clickAllBlog() {
		this .allBlog.click();
	}

	@FindBy(xpath=".//a[text()='New Launches']/parent::h3/following-sibling::a")
	private WebElement readMore;

	public void clickreadMore() {
		this .readMore.click();
	}
	
}
