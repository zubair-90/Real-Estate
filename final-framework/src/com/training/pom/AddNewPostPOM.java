package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generics.GenericMethods;
import com.trianing.waits.WaitTypes;

public class AddNewPostPOM {

	private WebDriver driver; 
	private GenericMethods genericMethods ;
	public AddNewPostPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id=\"wpbody-content\"]/div[3]/a")
	private WebElement addnew;
	public void clcikAddNewbtn()
	{
		WaitTypes waitTypes= new WaitTypes(driver);
		waitTypes.presenceElementLocated(addnew, 120);
		this.addnew.click(); 
	}
	
	@FindBy(xpath="//input[@name='post_title']")
	private WebElement addposttitle;

	public void sendPostTitle(String name) throws InterruptedException {
		this.addposttitle.click();
		this.addposttitle.sendKeys(name); 
	}
	
	@FindBy(xpath="//a[text()='New Launches']")
	private WebElement postedTitlebyAdmin;

	public boolean searchPostedTitlebyAdmin() {
		this.postedTitlebyAdmin.isDisplayed();
		return true;
	}
	
	@FindBy(xpath="//input[@name='post_title']")
	private WebElement sendposttitle;

	public WebElement sendpost() {
	
		return sendposttitle;
	}
	
	@FindBy(xpath="//textarea[@name='content']")
	private WebElement postbodytext;

	public void sendBodyText(String name) {
		this.postbodytext.clear(); 
		this.postbodytext.sendKeys(name); 
	}
	
	@FindBy(xpath="//label[text()=' New Launch']/input")
	private WebElement createdcategory;

	public void clickCreatedCategory(){
		genericMethods=new GenericMethods(driver);
		genericMethods.scrollIntoView(createdcategory);
		genericMethods.jsClick(this.createdcategory); 
	}

	//@FindBy(id="publish")
	@FindBy(xpath="//input[@id=\"publish\"]")
	private WebElement publishbtn;

	public void clickPublishbtn(){
		WaitTypes waitTypes= new WaitTypes(driver);
		waitTypes.presenceElementLocated(publishbtn, 60);
		this.publishbtn.click(); 
	}
}
