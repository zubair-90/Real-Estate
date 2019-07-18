package com.training.pom;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePOM {
	private WebDriver driver; 
	public HomePagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//ul[@id='responsive']//a[contains(text(),'New Launch')]")
	private WebElement newLaunch;
	public void mouseOverNewLaunchBtn() {
		Actions a = new Actions(driver);
		a.moveToElement(newLaunch).build().perform();
	}
	@FindBy(xpath="//ul[@id='responsive']//a[text()='Donec quis']")
	private WebElement donecQuisImg;
	public void clickDonecQuisImg() {
		this.donecQuisImg.click(); 
	}
	@FindBy(name="your-name")
	private WebElement yourNameEdt;

	public void sendyourName(String name) {
		this.yourNameEdt.clear(); 
		this.yourNameEdt.sendKeys(name); 
	}
	@FindBy(name="your-email")
	private WebElement yourEmailEdt;

	public void sendyourEmail(String email) {
		this.yourEmailEdt.clear(); 
		this.yourEmailEdt.sendKeys(email); 
	}
	@FindBy(name="your-subject")
	private WebElement yourSubjectEdt;

	public void sendyourSubject(String subject) {
		this.yourSubjectEdt.clear(); 
		this.yourSubjectEdt.sendKeys(subject); 
	}

	@FindBy(name="your-message")
	private WebElement yourMsgEdt;

	public void sendyourMessage(String message) {
		this.yourMsgEdt.clear(); 
		this.yourMsgEdt.sendKeys(message); 
	}
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submit;

	public void clickSubmit() {this.submit.click();
	}

	@FindBy(xpath="//form[@class='wpcf7-form failed']//div[@role='alert']")
	private WebElement messagePostSubmit;

	public String getmessagePostSubmit() throws InterruptedException
	{Thread.sleep(2000L);
	//		Actions a= new Actions(driver);
	//	    a.moveToElement(messagePostSubmit).build().perform();
	String msg=messagePostSubmit.getText();
	return msg;
	}
	@FindBy(xpath="//a[@class='sign-in']")
	private WebElement loginRegisterlink;

	public void clickloginRegisterlink() {
		this.loginRegisterlink.click(); 
	}

	@FindBy(xpath="//input[@id='user_login']")
	private WebElement userLogin;

	public void senduserLogin() throws IOException {
		this.userLogin.clear(); 
		FileInputStream fis = new FileInputStream("./resources/others.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String userID=pro.getProperty("UserID");
		this.userLogin.sendKeys(userID); 
	}
	@FindBy(xpath="//input[@id='user_pass']")
	private WebElement userPassword;

	public void senduserPassword() throws IOException {
		this.userPassword.clear(); 
		FileInputStream fis = new FileInputStream("./resources/others.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String userPass=pro.getProperty("password");
		this.userPassword.sendKeys(userPass); 
	}
	@FindBy(xpath="//input[@value='Sign In']")
	private WebElement SignIn;

	public void clickSignInbtn() {
		this.SignIn.click(); 
	}

	@FindBy(xpath="//h1[text()='Dashboard']")
	private WebElement dashboard;

	public WebElement CheckDashboard() {return dashboard;
	}

	@FindBy(xpath="//a[text()=' Lost Your Password?']")
	WebElement lostYourPassword;

	public void clicklostYourPassword()
	{this.lostYourPassword.click(); 
	}
	@FindBy(xpath="//input[@id='user_login']")
	private WebElement lostpswduseremail;
	public void sendlostpswduseremail() throws IOException
	{FileInputStream fis = new FileInputStream("./resources/others.properties");
	Properties pro=new Properties();
	pro.load(fis);
	String email=pro.getProperty("Email");
	this.lostpswduseremail.sendKeys(email); 
	}
	@FindBy(xpath="//input[@value='Reset Password']")
	private WebElement resetPassword;
	public void clickresetPassword()
	{this.resetPassword.click(); 
	}
	@FindBy(xpath="//article[@id=\"post-124\"]")
	private WebElement resetpasswordmessage;
	public String getresetpasswordmessage()
	{String message=this.resetpasswordmessage.getText();
	return message;
	}
}
