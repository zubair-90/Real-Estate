package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.generics.ApplicationGenericMethods;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.AddPropertyPOM;
import com.training.pom.DashboardPOM;
import com.training.pom.EditPropertyPOM;
import com.training.pom.FeaturesPOM;
import com.training.pom.HomePagePOM;
import com.training.pom.PropertiesPOM;
import com.training.pom.RealEstatePOM;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.trianing.waits.WaitTypes;


public class ComplexTestCasesTest {


	private WebDriver driver; 
	private String baseUrl;
	private HomePagePOM homePagePOM;
	private static Properties properties; 
	private ScreenShot screenShot; 
	private ApplicationGenericMethods applicationgenericmethods;
	private GenericMethods genericmethods;
	private String userID;
	private String userPass;
	private WaitTypes waitTypes;
	private DashboardPOM dashboardPOM;
	private PropertiesPOM propertiesPOM;
	private FeaturesPOM featuresPOM;
	private AddPropertyPOM  addPropertyPOM;
	private ApachePOIExcelRead apachePOIExcelRead;
	private EditPropertyPOM editPropertyPOM;
	private RealEstatePOM realEstatePOM;

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
		Thread.sleep(5000L);
		driver.quit();
	}

	//To verify whether application allows admin to create property details based on the Feature 
	//created & added property get displayed on home screen for user
	@Test(enabled=true)
	public void RETC_070()
	{
        try {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		ApplicationGenericMethods appmethods = new ApplicationGenericMethods(driver); 
		//Login to Application wp-login.php
		appmethods.adminLogin(userID,userPass);  
		//Create the instance of DashboardPOM class
		DashboardPOM dashboardPOM= new DashboardPOM(driver);
		//Click on the Properties Link
		dashboardPOM.clickPropertiesLink();
		//Create instacen of the ApplicationGenericMethods class
		ApplicationGenericMethods applicationgenericmethods= new ApplicationGenericMethods(driver);
		//Validated all the displayed links post click on Properties link and matched it with expected output
		applicationgenericmethods.checkDisplayedPropertiesLinks();
		//Create instance of PropertiesPOM class
		PropertiesPOM propertiesPOM= new PropertiesPOM(driver);
		//Click Features Link
		propertiesPOM.clickFeaturesLink();
		//Create the instance of FeaturesPOM class
		FeaturesPOM featuresPOM= new FeaturesPOM(driver);
		//Send the Name as given
		featuresPOM.sendName("New Launches");
		//Send the Slug as given 
		featuresPOM.sendSlug("launch");
		//send the description as given
		featuresPOM.sendDescription("New Launches of villas, apartments, flats");
		//Click on the AddNewFeature button
		featuresPOM.clickAddNewFeaturebtn();
		//Click on add new link under properties section
		propertiesPOM.clickAddNewLink();
		//Create the instance of AddPropertyPOM class
		AddPropertyPOM  addPropertyPOM=new AddPropertyPOM(driver);
		//send post title as given
		addPropertyPOM.sendPostTitle("prestige");
		//send text as given
		addPropertyPOM.sendTextArea("home town");
		//Click on the created feature text Box
		addPropertyPOM.clickFeatureCheckBox(driver);
		//Click on the Publish Button
		addPropertyPOM.clickPublishbtn();
		//Validate "view Post" Link is visible or not 
		EditPropertyPOM editPropertyPOM= new EditPropertyPOM(driver);
		Assert.assertTrue(editPropertyPOM.verifyViewPostLink().isDisplayed());
		//Mouse Over on Admin Profile 
		dashboardPOM.mouseOverAdminAccount(driver);
		//Click on the Logout button
		dashboardPOM.clicklogoutLink();
		//Click on the Logout Link psot click on the Logout button
		dashboardPOM.clickLogoutLinkafterLogout();
		//Create the instance of RealEstatePOM
		RealEstatePOM realEstatePOM= new RealEstatePOM(driver);
		//Click on the Real Estate Icon
		realEstatePOM.clickRealEstateIcon();
		//Search the added Property i.e. prestige
		realEstatePOM.sendAddedPropertySearch("prestige");
		//Click on the search result
		realEstatePOM.clcikAddedProperty();
        } catch(Exception e)
        {
        	e.printStackTrace();
        }
	}
	@Test(dataProvider="getdata",enabled=true)
	public void RETC_071(String name , String email, String subject , String messageText)
	{
		try {
		HomePagePOM homePagePOM= new HomePagePOM(driver);
		//Mouse Over New Launch Link
		homePagePOM.mouseOverNewLaunchBtn();  
		//Click on the Image
		homePagePOM.clickprestigeImg();
		//Send Name
		homePagePOM.sendYourName(name);  
		//Send Email ID
		homePagePOM.sendYourEmail(email);
		//Send Subject
		homePagePOM.sendYourSubject(subject);
		//Send Message Text
		homePagePOM.sendYourMessage(messageText);
		//Click Submit Button
		homePagePOM.clickSubmit(); 
		try {
			Assert.assertEquals(homePagePOM.getmessagePostSubmit(), "Thank you for your message. It has been sent", "Message Sent ERROR");
		}catch(java.lang.AssertionError e) 

		{   System.out.println("There is an error in the message submission,Please refer the screen Shot");
		screenShot.captureScreenShot("Message Submission Error"); }
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] getdata() throws IOException
	{
		ApachePOIExcelRead apachePOIExcelRead = new ApachePOIExcelRead();
		List<List<Object>> data = apachePOIExcelRead.getExcelContent("C:/Users/MohammedZubairMohamm/Desktop/Testing.xlsx");

		Object[][] a = new Object[data.size()][4];

		for(int i = 0; i < data.size(); i++)
		{
			for(int j = 0; j < 4; j++)
			{
				a[i][j] = (data.get(i)).get(j);
			}
		}

		return a;
	}

	//Data Provider for checking the application behaviour in case of invalid data
	@DataProvider
	public Object[][] invaliddata() throws IOException
	{
		ApachePOIExcelRead apachePOIExcelRead = new ApachePOIExcelRead();
		List<List<Object>> data = apachePOIExcelRead.getExcelContent("C:/Users/MohammedZubairMohamm/Desktop/Invalid Data.xlsx");

		Object[][] a = new Object[data.size()][4];

		for(int i = 0; i < data.size(); i++)
		{
			for(int j = 0; j < 4; j++)
			{
				a[i][j] = (data.get(i)).get(j);
			}
		}

		return a;
	}


	@Test(dataProvider="invaliddata", enabled=true)
	public void RETC_072(String name , String email, String subject , String messageText)
	{
		try {
			HomePagePOM homePagePOM= new HomePagePOM(driver);

			//Mouse Over New Launch Link
			homePagePOM.mouseOverNewLaunchBtn();  
			//Click on the Image
			homePagePOM.clickprestigeImg();
			//Send Name
			homePagePOM.sendYourName(name);  
			//Send Email ID
			homePagePOM.sendYourEmail(email);
			//Send Subject
			homePagePOM.sendYourSubject(subject);
			//Send Message Text
			homePagePOM.sendYourMessage(messageText);
			//Click Submit Button
			homePagePOM.clickSubmit();
			//Check in case if Name is not provided then application is highlighting the Field
			if(name.trim().isEmpty()) {
				Assert.assertTrue(homePagePOM.verifyErrorInyourName());
			}
			//Check if in case Email is not provided then application is highlighting the Field
			if(email.trim().isEmpty()) {
				Assert.assertTrue(homePagePOM.verifyErrorInyourEmail());
			}

		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}

