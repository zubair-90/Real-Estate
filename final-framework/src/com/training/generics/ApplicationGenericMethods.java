package com.training.generics;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import com.training.pom.HomePagePOM;

public class ApplicationGenericMethods {

	WebDriver driver ; 

	public ApplicationGenericMethods(WebDriver driver){
		this.driver = driver;
	}
	public void checkdisplayedlinks()
	{
		HomePagePOM homePagePOM= new HomePagePOM(driver);
		boolean checkallpostlink=homePagePOM.verifyallPostlink().isDisplayed();
		String allpostlink=homePagePOM.verifyallPostlink().getText();
		boolean checkaddNewlink=homePagePOM.verifyaddNewlink().isDisplayed();
		String  addNewlink=homePagePOM.verifyaddNewlink().getText();
		boolean checkcategorieslink=homePagePOM.verifycategorieslink().isDisplayed();
		String categorieslink=homePagePOM.verifycategorieslink().getText();
		boolean checktagslink=homePagePOM.verifytagslink().isDisplayed();
		String tagslink=homePagePOM.verifytagslink().getText();

		if(checkallpostlink=true && checkaddNewlink &&checkcategorieslink && checktagslink ==true)
		{
			System.out.println("Links displayed are...... \n" +allpostlink +"\n" +addNewlink +"\n" +categorieslink +"\n" +tagslink);
		}
		else
		{
			System.out.println("Not all links are displaying ...");
		}
	}
	public void categoryaddcheck(String categoryName)
	{HomePagePOM homePagePOM= new HomePagePOM(driver);
	String result=homePagePOM.searchresult().getText();
	if(result.equalsIgnoreCase(categoryName))
	{
		System.out.println("Added category is displaying in existing categories module....");
	}

	}
	public void adminLogin() throws IOException 
	{
		HomePagePOM homePagePOM= new HomePagePOM(driver);
		homePagePOM.clickLoginRegisterLink();
		homePagePOM.sendUserLogin();
		homePagePOM.sendUserPassword();
		homePagePOM.clickSignInbtn();
	}
}


