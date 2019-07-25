package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generics.GenericMethods;

public class DashboardPOM {

	private WebDriver driver; 
	private GenericMethods genericMethods ;
	public DashboardPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[text()='Dashboard']")
	private WebElement dashboard;

	public WebElement CheckDashboard() {return dashboard;
	}
}
