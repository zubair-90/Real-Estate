package com.training.pom;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.training.generics.GenericMethods;
import com.training.sanity.tests.SimpleTestCasesTest;
import com.trianing.waits.WaitTypes;

public class HomePagePOM {
	private WebDriver driver; 
	private GenericMethods genericMethods ;
	private WaitTypes waitTypes;
	private SimpleTestCasesTest simpleTestCasesTest;
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

	public void sendYourName(String name) {
		this.yourNameEdt.clear(); 
		this.yourNameEdt.sendKeys(name); 
	}
	@FindBy(name="your-email")
	private WebElement yourEmailEdt;

	public void sendYourEmail(String email) {
		this.yourEmailEdt.clear(); 
		this.yourEmailEdt.sendKeys(email); 
	}
	@FindBy(name="your-subject")
	private WebElement yourSubjectEdt;

	public void sendYourSubject(String subject) {
		this.yourSubjectEdt.clear(); 
		this.yourSubjectEdt.sendKeys(subject); 
	}

	@FindBy(name="your-message")
	private WebElement yourMsgEdt;

	public void sendYourMessage(String message) {
		this.yourMsgEdt.clear(); 
		this.yourMsgEdt.sendKeys(message); 
	}
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submit;

	public void clickSubmit() {
		this.submit.click();
	}

	@FindBy(xpath="//form[@class='wpcf7-form failed']//div[@role='alert']")
	private WebElement messagePostSubmit;
	public WebElement getmessagePostSubmit()
	{
		genericMethods =new GenericMethods(driver);
		genericMethods.scrollIntoView(yourMsgEdt);
		return messagePostSubmit;
	}
	@FindBy(className="sign-in")
	private WebElement loginRegisterlink;

	public void clickLoginRegisterLink() {
		this.loginRegisterlink.click(); 
	}

	@FindBy(id="user_login")
	private WebElement userLogin;

	public void sendUserLogin(String userID) throws IOException {
		this.userLogin.clear(); 
		this.userLogin.sendKeys(userID); 
	}
	@FindBy(xpath="//input[@id='user_pass']")
	private WebElement userPassword;

	public void sendUserPassword(String userPass) throws IOException {
		this.userPassword.clear(); 
		this.userPassword.sendKeys(userPass); 
	}
	@FindBy(xpath="//input[@value='Sign In']")
	private WebElement SignIn;

	public void clickSignInbtn() {
		this.SignIn.click(); 
	}
	@FindBy(xpath="//a[text()=' Lost Your Password?']")
	WebElement lostYourPassword;

	public void clickLostYourPassword()
	{this.lostYourPassword.click(); 
	}
	@FindBy(xpath="//input[@id='user_login']")
	private WebElement lostpswduseremail;
	public void sendLostpswdUserEmail() throws IOException
	{FileInputStream fis = new FileInputStream("./resources/others.properties");
	Properties pro=new Properties();
	pro.load(fis);
	String email=pro.getProperty("Email");
	this.lostpswduseremail.sendKeys(email); 
	}
	@FindBy(xpath="//input[@value='Reset Password']")
	private WebElement resetPassword;
	public void clickResetPassword()
	{this.resetPassword.click(); 
	}
	@FindBy(xpath="//article[@id=\"post-124\"]")
	private WebElement resetpasswordmessage;
	public String getResetPasswordMessage()
	{String message=this.resetpasswordmessage.getText();
	return message;
	}
	@FindBy(xpath="//a[text()='New Launches']")
	private WebElement postDetails;

	public boolean verifypostDetails(){

		this.postDetails.isDisplayed();
		return true  ;
	}
}
