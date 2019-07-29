package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generics.GenericMethods;

public class CategoriesPOM {
	
	private WebDriver driver; 
	private GenericMethods genericMethods ;
	public CategoriesPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//input[@id='tag-name']")
	private WebElement categoryname;

	public void sendCategoryName(String name) {
		this.categoryname.clear(); 
		this.categoryname.sendKeys(name); 
	}
	
	@FindBy(xpath="//input[@id='tag-slug']")
	private WebElement categoryslug;

	public void sendCategorySlug(String name) {
		this.categoryslug.clear(); 
		this.categoryslug.sendKeys(name); 
	}
	
	@FindBy(xpath="//textarea[@id='tag-description']")
	private WebElement categorydescription;

	public void sendCategoryDescription(String name) {
		this.categorydescription.clear(); 
		this.categorydescription.sendKeys(name); 
	}
	
	@FindBy(xpath="//input[@id='tag-name']")
	private WebElement enteredcategoryname;

	public WebElement enteredCategoryName() {
		
		return enteredcategoryname;
	}
	@FindBy(xpath="//input[@value='Add New Category']")
	private WebElement categoryaddnewcategory;
	public void clickAddNewCategorybtn() {
		this.categoryaddnewcategory.click(); 
	}
	@FindBy(xpath="//input[@id='tag-search-input']")
	private WebElement categorysearch;

	public void searchInputCategory(String name) {
		this.categorysearch.clear(); 
		this.categorysearch.sendKeys(name); 
	}
	
	@FindBy(xpath="//button[@id='contextual-help-link']")
	private WebElement helpbutton;
	public WebElement searchHelpbtn() {
		
		return helpbutton;
	}
	@FindBy(xpath="//input[@value='Search Categories']")
	private WebElement searchcategorybtn;
	public void clickSearchCategorybtn() {
		this.searchcategorybtn.click(); 
	}
	
	@FindBy(xpath="//a[@class='row-title']")
	private WebElement searchresult;
	public WebElement searchresult() {
		
		return searchresult;
	}
	
}
