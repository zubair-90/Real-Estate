package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ApplicationGenericMethods;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.HomePagePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class MediumTestCasesTest {

	private WebDriver driver; 
	private String baseUrl; 
	private HomePagePOM homePagePOM; 
	private static Properties properties; 
	private ScreenShot screenShot; 
	private ApplicationGenericMethods applicationgenericmethods;
	private GenericMethods genericmethods;
	String submittedpost;


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
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
	//(RETC_040)To verify whether application displays added post in blog section of home screen
	@Test
	public void RETC_040() throws IOException, InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		ApplicationGenericMethods appmethods = new ApplicationGenericMethods(driver); 
		appmethods.adminLogin();
		homePagePOM.clickpostlink();
		appmethods.checkdisplayedlinks();  //Validate the links displayed
		homePagePOM.verifycategorieslink().click();  
		homePagePOM.sendCategoryName("New Launches");
		homePagePOM.sendCategorySlug("launch");
		homePagePOM.sendCategoryDescription("New Launches of villas, apartments, flats");
		String categoryName=homePagePOM.enteredCategoryName().getAttribute("value");
		homePagePOM.clickAddNewCategorybtn();
		System.out.println("New Category added successfully.........");
		homePagePOM.inputSearchcategory(categoryName);
		GenericMethods genericmethods= new GenericMethods(driver);
		genericmethods.scrollIntoView(homePagePOM.searchhelpbtn());
		homePagePOM.clicksearchcategorybtn();
		appmethods.categoryaddcheck(categoryName); //To check entered category added in the existing categories module 
		homePagePOM.clcikallPostlink();
		homePagePOM.clcikaddnewbtn();
		homePagePOM.sendposttitle("New Launches");
		String submittedpost=homePagePOM.sendpost().getAttribute("value");
		System.out.println(submittedpost);
		homePagePOM.sendbodytext("New Launch in Home");
		homePagePOM.clickcreatedcategory();
		homePagePOM.clickpublishbtn();
		homePagePOM.clickviewpostbtn();
		System.out.println(driver.findElement(By.xpath("//a[text()='New Launches']")).isDisplayed());
		
	}

	
}
