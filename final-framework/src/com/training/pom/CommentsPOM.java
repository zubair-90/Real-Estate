package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generics.GenericMethods;

public class CommentsPOM {

	private WebDriver driver; 
	private GenericMethods genericMethods ;
	public CommentsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="comment-search-input")
	private WebElement commentSearchInput; 
	
	public void sendcommentSearchInput(String userName) {
		this.commentSearchInput.clear();
		this.commentSearchInput.sendKeys(userName);
	}
	
	@FindBy(id="search-submit")
	private WebElement searchSubmit; 
	
	public void clickSearchSubmit() {
		
		this.searchSubmit.click();;
	}
}
