package com.training.sanity.tests;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.training.generics.ApplicationGenericMethods;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.AddNewPostPOM;
import com.training.pom.BlogPagePOM;
import com.training.pom.CategoriesPOM;
import com.training.pom.CommentsPOM;
import com.training.pom.DashboardPOM;
import com.training.pom.EditPostPOM;
import com.training.pom.HomePagePOM;
import com.training.pom.NewLaunchesPOM;
import com.training.pom.PostPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.trianing.waits.WaitTypes;

public class MediumTestCasesTest {

	private WebDriver driver; 
	private String baseUrl; 
	private HomePagePOM homePagePOM; 
	private static Properties properties; 
	private ScreenShot screenShot; 
	private ApplicationGenericMethods applicationgenericmethods;
	private GenericMethods genericmethods;
	String submittedpost;
	private WaitTypes waitTypes;
	private DashboardPOM dashboardPOM;
	private PostPOM postPOM;
	private CategoriesPOM categoriesPOM;
	private AddNewPostPOM addNewPost;
	private EditPostPOM editPost;
	private BlogPagePOM blogPage;
	private NewLaunchesPOM newLaunchesPOM;
	private CommentsPOM commentsPOM;
	private String userID;
	private String userPass;


	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		homePagePOM = new HomePagePOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		userID=properties.getProperty("UserID");
		userPass=properties.getProperty("password");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
	//(RETC_040)To verify whether application displays added post in blog section of home screen
	@Test()
	public void RETC_040()
	{
		try {
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			ApplicationGenericMethods appmethods = new ApplicationGenericMethods(driver); 
			appmethods.adminLogin(userID,userPass);   //Login to Application 
			DashboardPOM dashboardPOM= new DashboardPOM(driver);
			dashboardPOM.clickPostLink();  //Click on Post link 
			appmethods.checkDisplayedLinks();  //Validate the links displayed
			PostPOM postPOM= new PostPOM(driver);
			postPOM.clickCategoriesLink();   //Click on Categories Link
			CategoriesPOM categoriesPOM=new CategoriesPOM(driver);
			categoriesPOM.sendCategoryName("New Launches");  //Send Category Name
			categoriesPOM.sendCategorySlug("launch");        //Send Category Slug
			categoriesPOM.sendCategoryDescription("New Launches of villas, apartments, flats");//Send Category Description
			String categoryName=categoriesPOM.enteredCategoryName().getAttribute("value"); //Saving Category Name
			categoriesPOM.clickAddNewCategorybtn();    //Click Add New Category Button
			System.out.println("New Category added successfully.........");  //Display Success Message post category Add
			categoriesPOM.searchInputCategory(categoryName);   //Search Added Category
			GenericMethods genericmethods= new GenericMethods(driver);
			genericmethods.scrollIntoView(categoriesPOM.searchHelpbtn()); //Scroll screen to view the search Category Button
			categoriesPOM.clickSearchCategorybtn();//Click on Search Category Button
			appmethods.categoryAddCheck(categoryName); //To check entered category added in the existing categories module
			postPOM.clcikAllPostLink();  //Click on All Post link
			AddNewPostPOM addNewPost= new AddNewPostPOM(driver);
			addNewPost.clcikAddNewbtn();  //Click Add New Button
			addNewPost.sendPostTitle("New Launches");   //Send Post title 
			String submittedpost=addNewPost.sendpost().getAttribute("value");  
			addNewPost.sendBodyText("New Launch in Home");  //Send Body text
			addNewPost.clickCreatedCategory();  //Click on the CheckBox of the created Category earlier
			addNewPost.clickPublishbtn();   //Click on the Publish Button
			EditPostPOM editPost= new EditPostPOM(driver);
			editPost.clickViewPostbtn(); //Click on the link View post button
			BlogPagePOM blogPage=new BlogPagePOM(driver);
			Assert.assertEquals(appmethods.checkDisplayed(blogPage.verifyAddedPostInBlog()), true);//Validate added post
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	//(RETC_041)To verify whether application display comments added by the user in admin page
	@Test(dependsOnMethods="RETC_040")
	public void RETC_041() throws IOException
	{
		BlogPagePOM blogPage=new BlogPagePOM(driver);
		blogPage.clickAllBlog();  //Click on All Blog link on the Home Page
		AddNewPostPOM addNewPost= new AddNewPostPOM(driver);
		Assert.assertEquals(addNewPost.searchPostedTitlebyAdmin(), true);  //Validate post added by admin is visible 
		System.out.println("Post entered by admin is Present");  //Display Success Message
		blogPage.clickreadMore();   //Click on the read more link of the added post
		NewLaunchesPOM newLaunchesPOM= new NewLaunchesPOM(driver);
		newLaunchesPOM.sendcommentBox("I works in IBM");  //Enter comments in the comment Box
		newLaunchesPOM.sendauthorName("Mohammed Zubair"); //Enter Author Name
		newLaunchesPOM.sendEmail("mzubair0@in.ibm.com"); //Enter Email ID
		newLaunchesPOM.sendUrl("www.google.com");  //Enter URL
		newLaunchesPOM.clickPostComment();  //Click on submit comment button
		ApplicationGenericMethods appmethods = new ApplicationGenericMethods(driver); 
		appmethods.newWindow();   //Open New Window
		appmethods.switchToWindow();//Switch to New window
		appmethods.adminLogin(userID,userPass); //Login to the application 
		newLaunchesPOM.clickcomments();  //Click on the comments
		CommentsPOM commentsPOM= new CommentsPOM(driver);
		commentsPOM.sendcommentSearchInput("I works in IBM");//Search the entered comments are visible 
		commentsPOM.clickSearchSubmit();
	}
	//(RETC_042)To verify whether application displays added post in all post 
	@Test(dependsOnMethods="RETC_041")
	public void RETC_042() throws IOException, InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);  //Set the implicit timeout
		ApplicationGenericMethods appmethods = new ApplicationGenericMethods(driver); 
		appmethods.adminLogin(userID,userPass);   //Login to the application 
		DashboardPOM dashboardPOM= new DashboardPOM(driver);
		dashboardPOM.clickPostLink();  //Click on the Post link 
		appmethods.checkDisplayedLinks();  //Validate the links displayed
		AddNewPostPOM addNewPost= new AddNewPostPOM(driver);
		addNewPost.clcikAddNewbtn();  //Click on Add new button
		addNewPost.sendPostTitle("New Launches");   //Enter post title
		addNewPost.sendBodyText("New Launch in Home");  //Enter Body text
		addNewPost.clickPublishbtn();//Click on Publish Button
		PostPOM postPOM=new PostPOM(driver);
		String submittedpost=addNewPost.sendpost().getAttribute("value");
		postPOM.clcikAllPostLink();  //Click on All Post link 
		postPOM.sendpPostSearchInput("New Launches");  //Search added post title 
		postPOM.clickSearchPosts();//Click on the search post button
		System.out.println(submittedpost); // Display submitted post
		Assert.assertEquals(submittedpost, "New Launches");//Validate submitted post is displayed 
		postPOM.clickPostAddedByAdmin();
	}
}
