package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.HomePagePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class SimpleTestCasesTest {

	private WebDriver driver; 
	private String baseUrl; 
	private HomePagePOM homePagePOM; 
	private static Properties properties; 
	private ScreenShot screenShot; 


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
			homePagePOM.sendyourName("Mohammed Zubair");
			homePagePOM.sendyourEmail("mzubair0@in.ibm.com");
			homePagePOM.sendyourSubject("Test");
			homePagePOM.sendyourMessage("To live a creative life, we must lose our fear of being wrong");
			homePagePOM.clickSubmit();
			System.out.println(homePagePOM.getmessagePostSubmit());

			if(homePagePOM.getmessagePostSubmit().equalsIgnoreCase("Thank you for your message. It has been sent")){
				System.out.println("Your message submitted successfully .....");
			}else{
				screenShot.captureScreenShot("Message Sent ERROR");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	//(RETC_011)To Verify whether application allows registered admin to login into application
	@Test(priority=2)
	public void RETC_011() 
	{
		try {
			homePagePOM.clickloginRegisterlink();
			homePagePOM.senduserLogin();
			homePagePOM.senduserPassword();
			homePagePOM.clickSignInbtn();

			if (homePagePOM.CheckDashboard().isDisplayed())
			{System.out.println("User is successfully logged in to the Portal .....");
			}
			else {
				screenShot.captureScreenShot("AdminLoginError");
				System.out.println("Something went Wrong ....");
			}
		} catch(Exception e)
		{e.printStackTrace();
		}
	}
	//(RETC-012)To verify whether application allows the admin to recover the password
	//As discussed with the Manipal team (Sunil), Email functionality doesnot work on the server so 
	//Implemented the partial flow 
	@Test(priority=3)
	public void RETC_012()
	{
		try {
			homePagePOM.clickloginRegisterlink();
			homePagePOM.clicklostYourPassword();
			homePagePOM.sendlostpswduseremail();
			homePagePOM.clickresetPassword();
			System.out.println(homePagePOM.getresetpasswordmessage());
		}catch(Exception e)
		{e.printStackTrace();
		}
	}
}


