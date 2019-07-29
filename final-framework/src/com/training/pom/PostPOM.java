package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generics.GenericMethods;
import com.trianing.waits.WaitTypes;

public class PostPOM {

	private WebDriver driver; 
	private GenericMethods genericMethods ;
	public PostPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//a[text()='All Posts']")
	private WebElement allPost;
	public WebElement verifyAllPostlink()
	{
		return  allPost;
	}


	@FindBy(xpath="//li[@id=\"menu-posts\"]/ul/li[3]/a")
	private WebElement addNew;
	public WebElement verifyAddNewLink()
	{
		return  addNew;
	}

	@FindBy(xpath="//li[@id=\"menu-posts\"]/ul/li[4]/a")
	private WebElement categories;
	public WebElement verifyCategoriesLink()
	{
		return  categories;
	}

	@FindBy(xpath="//li[@id=\"menu-posts\"]/ul/li[5]/a")
	private WebElement tags;
	public WebElement verifyTagsLink()
	{
		return  tags;
	}

	@FindBy(xpath="//li[@id=\"menu-posts\"]/ul/li[4]/a")
	private WebElement categoriesLink;

	public void clickCategoriesLink() {
		this.categoriesLink.click();
	}
	@FindBy(xpath="//a[text()='All Posts']")
	private WebElement allPostlink;
	public void clcikAllPostLink()
	{
		WaitTypes waitTypes= new WaitTypes(driver);
		waitTypes.presenceElementLocated(allPostlink, 60);
		this.allPostlink.click();
	}

	@FindBy(xpath="//input[@id='post-search-input']")
	private WebElement postsearchinput;
	public void sendpPostSearchInput(String name)
	{
		WaitTypes waitTypes= new WaitTypes(driver);
		waitTypes.presenceElementLocated(postsearchinput, 60);
		this.postsearchinput.clear();
		this.postsearchinput.sendKeys(name);
	}

	@FindBy(xpath="//input[@value='Search Posts']")
	private WebElement searchPosts;
	public void clickSearchPosts()
	{
		this.searchPosts.click();
	}
	@FindBy(xpath="//a[text()='New Launches']")
	private WebElement postAddedByAdmin;

	public void clickPostAddedByAdmin(){
		this.postAddedByAdmin.click();
	}
}
