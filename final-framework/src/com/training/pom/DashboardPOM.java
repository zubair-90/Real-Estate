package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generics.GenericMethods;
import com.trianing.waits.WaitTypes;

public class DashboardPOM {

	private WebDriver driver; 
	private GenericMethods genericMethods ;
	public DashboardPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[text()='Dashboard']")
	private WebElement dashboard;

	public WebElement CheckDashboard() {return dashboard;
	}
	
	@FindBy(xpath="//div[text()='Posts']")
	private WebElement post;
	
	public void clickPostLink() {
		this.post.click(); 
	}
	
	@FindBy(xpath="//div[text()='Properties']")
	private WebElement properties;
	
	public void clickPropertiesLink() {
		this.properties.click(); 
	}
	
	@FindBy(xpath="//li[@id=\"wp-admin-bar-my-account\"]/a")
	private WebElement adminAccount;
	
	public void mouseOverAdminAccount(WebDriver driver) {
		Actions a = new Actions(driver);
		a.moveToElement(adminAccount).build().perform();
	}
	
	
	@FindBy(xpath="//li[@id='wp-admin-bar-logout']//a[text()='Log Out']")
	//@FindBy(xpath="//a[text()='Log Out']")
	private WebElement logout;
	
	public void clicklogoutLink() throws InterruptedException {
		//WaitTypes waitTypes= new WaitTypes(driver);
		//Explcit wait was not working hence given Thread.sleep
		Thread.sleep(2000L);
		//waitTypes.presenceElementLocated(logout, 120);
		GenericMethods genericmethods= new GenericMethods(driver);
		genericmethods.jsClick(logout);
		this.logout.click(); 
	}
	
	@FindBy(xpath="//a[text()='log out']")
	private WebElement logoutLinkafterLogout;
	
	public void clickLogoutLinkafterLogout() {

		this.logoutLinkafterLogout.click();
	}
}
