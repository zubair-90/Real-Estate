package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generics.GenericMethods;

public class NewLaunchesPOM {
	
	private WebDriver driver; 
	private GenericMethods genericMethods ;
	public NewLaunchesPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//textarea[@name='comment']")
	private WebElement commentBox;

	public void sendcommentBox(String comment){
		GenericMethods genericMethods=new GenericMethods(driver);
		genericMethods.scrollIntoView(commentBox);
		this.commentBox.clear();
		this.commentBox.sendKeys(comment);
   }
	
	@FindBy(xpath="//input[@name='author']")
	private WebElement author;

	public void sendauthorName(String comment){
		this.author.clear();
		this.author.sendKeys(comment);
   }
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement email;

	public void sendEmail(String comment){
		this.email.clear();
		this.email.sendKeys(comment);
   }
	
	@FindBy(xpath="//input[@id='url']")
	private WebElement url;

	public void sendUrl(String comment){
		this.url.clear();
		this.url.sendKeys(comment);
   }
	
	@FindBy(xpath="//input[@value='Post Comment']")
	private WebElement postComment;

	public void clickPostComment(){
		
		this.postComment.click();
   }
	
	@FindBy(xpath="//div[text()='Comments ']")
	private WebElement comments;

	public void clickcomments(){
		
		this.comments.click();
   }
}
