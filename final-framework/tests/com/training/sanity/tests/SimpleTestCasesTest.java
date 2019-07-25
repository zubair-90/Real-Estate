package com.training.sanity.tests;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.training.generics.ApplicationGenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.DashboardPOM;
import com.training.pom.HomePagePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class SimpleTestCasesTest {
	private WebDriver driver; 
	private String baseUrl; 
	private HomePagePOM homePagePOM; 
	private static Properties properties; 
	private ScreenShot screenShot;
	ApplicationGenericMethods applicationGenericMethods;
	DashboardPOM dashboardPOM;
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
	//(RETC_010)To Verify whether application allows user to send the query in Contact Form Page
	@Test(priority=1)
	public void RETC_010()  {
		try {
			homePagePOM.mouseOverNewLaunchBtn();
			homePagePOM.clickDonecQuisImg();
			homePagePOM.sendYourName("Mohammed Zubair");
			homePagePOM.sendYourEmail("mzubair0@in.ibm.com");
			homePagePOM.sendYourSubject("Test");
			homePagePOM.sendYourMessage("To live a creative life, we must lose our fear of being wrong");
			homePagePOM.clickSubmit();
			try {
				Assert.assertEquals(homePagePOM.getmessagePostSubmit(), "Thank you for your message. It has been sent", "Message Sent ERROR");
			}catch(java.lang.AssertionError e) 
			{   screenShot.captureScreenShot("Message Submission Error"); }
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	//(RETC_011)To Verify whether application allows registered admin to login into application
	@Test(priority=2)
	public void RETC_011() 
	{try {
		ApplicationGenericMethods applicationGenericMethods= new ApplicationGenericMethods(driver);
		applicationGenericMethods.adminLogin();
		Assert.assertEquals(dashboardPOM.CheckDashboard().isDisplayed(), true,"Something went Wrong");
	} catch(Exception e)
	{e.printStackTrace();
	}
	}
	//(RETC-012)To verify whether application allows the admin to recover the password
	//As discussed with the Manipal team, Email functionality doesnot work on the server so Implemented the partial flow 
	@Test(priority=3)
	public void RETC_012()
	{
		try {
			homePagePOM.clickLoginRegisterLink();
			homePagePOM.clickLostYourPassword();
			homePagePOM.sendLostpswdUserEmail();
			homePagePOM.clickResetPassword();
			System.out.println(homePagePOM.getResetPasswordMessage());
		}catch(Exception e)
		{e.printStackTrace();
		}
	}
}


