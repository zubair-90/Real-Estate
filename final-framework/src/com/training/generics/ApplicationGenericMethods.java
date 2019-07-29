package com.training.generics;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.training.pom.CategoriesPOM;
import com.training.pom.HomePagePOM;
import com.training.pom.PostPOM;
import com.training.sanity.tests.SimpleTestCasesTest;

public class ApplicationGenericMethods {

	WebDriver driver ; 
	private PostPOM postPOM;
	CategoriesPOM categoriesPOM;
	private SimpleTestCasesTest simpleTestCasesTest;

	public ApplicationGenericMethods(WebDriver driver){
		this.driver = driver;
	}
	public void checkDisplayedLinks()
	{
		PostPOM postPOM= new PostPOM(driver);
		boolean checkAllPostLink=postPOM.verifyAllPostlink().isDisplayed();
		String allPostLink=postPOM.verifyAllPostlink().getText();
		boolean checkAddNewLink=postPOM.verifyAddNewLink().isDisplayed();
		String  addNewLink=postPOM.verifyAddNewLink().getText();
		boolean checkCategoriesLink=postPOM.verifyCategoriesLink().isDisplayed();
		String categoriesLink=postPOM.verifyCategoriesLink().getText();
		boolean checkTagsLink=postPOM.verifyTagsLink().isDisplayed();
		String tagsLink=postPOM.verifyTagsLink().getText();
		Assert.assertEquals(checkAllPostLink, true); 
		Assert.assertEquals(checkAddNewLink, true); 
		Assert.assertEquals(checkCategoriesLink, true); 
		Assert.assertEquals(checkTagsLink, true); 
        System.out.println("Expected Links are displaying successfully. Displayed Links are" );
        System.out.println(allPostLink +"\n" +addNewLink +"\n" +categoriesLink  + "\n" +tagsLink);
	}
	public void categoryAddCheck(String categoryName)
	{CategoriesPOM categoriesPOM= new CategoriesPOM(driver);
	String result=categoriesPOM.searchresult().getText();
	Assert.assertEquals(categoryName, result);
	System.out.println("Added category is displaying in existing categories module....");
	}
	public void adminLogin(String userID, String userPass) throws IOException 
	{
		HomePagePOM homePagePOM= new HomePagePOM(driver);   
		homePagePOM.clickLoginRegisterLink(); //CLick on Register Link
		homePagePOM.sendUserLogin(userID);   //Send User ID , to be picked from Properties File
		homePagePOM.sendUserPassword(userPass);////Send Password , to be picked from Properties File
		homePagePOM.clickSignInbtn();
	}
	public boolean checkDisplayed(WebElement element)
	{
		element.isDisplayed();
		return true;
	}
	public void newWindow()
	{
		String a = "window.open('http://realestate.upskills.in/','_blank');";
		((JavascriptExecutor)driver).executeScript(a);
	}
	public void switchToWindow()
	{
		 	Set<String> s1=driver.getWindowHandles();		
	        Iterator<String> i1=s1.iterator();	
	        String NewLauncWindow=i1.next();
	        String RealStateHomeScreen=i1.next();
	        driver.switchTo().window(RealStateHomeScreen);
	}
		
}


