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
import com.trianing.waits.WaitTypes;

public class HomePagePOM {
	private WebDriver driver; 
	private GenericMethods genericMethods ;
	private WaitTypes waitTypes;
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
		GenericMethods genericMethods	=new GenericMethods(driver);
		genericMethods.scrollIntoView(yourMsgEdt);
	    return messagePostSubmit;
	}
	@FindBy(xpath="//a[@class='sign-in']")
	private WebElement loginRegisterlink;

	public void clickLoginRegisterLink() {
		this.loginRegisterlink.click(); 
	}

	@FindBy(xpath="//input[@id='user_login']")
	private WebElement userLogin;

	public void sendUserLogin() throws IOException {
		this.userLogin.clear(); 
		FileInputStream fis = new FileInputStream("./resources/others.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String userID=pro.getProperty("UserID");
		this.userLogin.sendKeys(userID); 
	}
	@FindBy(xpath="//input[@id='user_pass']")
	private WebElement userPassword;

	public void sendUserPassword() throws IOException {
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
	
	@FindBy(xpath="//div[text()='Posts']")
	private WebElement post;
	
	public void clickpostlink() {
		this.post.click(); 
	}
   
	@FindBy(xpath="//a[text()='All Posts']")
	private WebElement allPost;
	public WebElement verifyallPostlink()
	{
		return  allPost;
	}
	@FindBy(xpath="//*[@id=\"menu-posts\"]/ul/li[3]/a")
	private WebElement addNew;
	public WebElement verifyaddNewlink()
	{
		return  addNew;
	}
	@FindBy(xpath="//*[@id=\"menu-posts\"]/ul/li[4]/a")
	private WebElement categories;
	public WebElement verifycategorieslink()
	{
		return  categories;
	}
	
	@FindBy(xpath="//*[@id=\"menu-posts\"]/ul/li[5]/a")
	private WebElement tags;
	public WebElement verifytagslink()
	{
		return  tags;
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
	
	
	@FindBy(xpath="//input[@value='Add New Category']")
	private WebElement categoryaddnewcategory;
	public void clickAddNewCategorybtn() {
		this.categoryaddnewcategory.click(); 
	}
	
	@FindBy(xpath="//input[@id='tag-search-input']")
	private WebElement categorysearch;

	public void inputSearchcategory(String name) {
		this.categorysearch.clear(); 
		this.categorysearch.sendKeys(name); 
	}
	
	@FindBy(xpath="//input[@value='Search Categories']")
	private WebElement searchcategorybtn;
	public void clicksearchcategorybtn() {
		this.searchcategorybtn.click(); 
	}
	
	@FindBy(xpath="//button[@id='contextual-help-link']")
	private WebElement helpbutton;
	public WebElement searchhelpbtn() {
		
		return helpbutton;
	}
	
	@FindBy(xpath="//a[@class='row-title']")
	private WebElement searchresult;
	public WebElement searchresult() {
		
		return searchresult;
	}
	
	@FindBy(xpath="//input[@id='tag-name']")
	private WebElement enteredcategoryname;

	public WebElement enteredCategoryName() {
		
		return enteredcategoryname;
	}
	
	@FindBy(xpath="//a[text()='All Posts']")
	private WebElement allPostlink;
	public void clcikallPostlink()
	{
		this.allPostlink.click();
	}

	@FindBy(xpath="//*[@id=\"wpbody-content\"]/div[3]/a")
	private WebElement addnew;
	public void clcikaddnewbtn()
	{
		this.addnew.click(); 
	}
	
	@FindBy(xpath="//input[@name='post_title']")
	private WebElement addposttitle;

	public void sendposttitle(String name) throws InterruptedException {
		this.addposttitle.click();
		this.addposttitle.sendKeys(name); 
	}
	
	@FindBy(xpath="//textarea[@name='content']")
	private WebElement postbodytext;

	public void sendbodytext(String name) {
		this.postbodytext.clear(); 
		this.postbodytext.sendKeys(name); 
	}

	
	@FindBy(xpath="//input[@id='publish']")
	private WebElement publishbtn;

	public void clickpublishbtn(){
		this.publishbtn.click(); 
	}

	@FindBy(xpath="//a[text()='View post']")
	private WebElement viewpost;

	public void clickviewpostbtn() {
		waitTypes.presenceElementLocated(viewpost, 60);
		this.viewpost.click(); 
	}
	
	@FindBy(xpath="//input[@name='post_title']")
	private WebElement sendposttitle;

	public WebElement sendpost() {
	
		return sendposttitle;
	}
	
	
	@FindBy(xpath="//label[text()=' New Launch']/input")
	private WebElement createdcategory;

	public void clickcreatedcategory(){
		genericMethods=new GenericMethods(driver);
		genericMethods.scrollIntoView(createdcategory);
		genericMethods.jsClick(this.createdcategory); 
	}
	
}
