package com.oracle.qa.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.oracle.qa.crm.base.TestBase;

public class LoginPage extends TestBase{
	
	
	@FindBy(name ="username")
	WebElement username;

	@FindBy(name ="password")
	WebElement password;
	
	@FindBy(xpath ="//input[@value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath ="//button[contains(@text(),'Sign Up')]")
	WebElement signUp;
	
	
	@FindBy(xpath ="//img[contains(@class,'img-responsive')]")
	WebElement freeCRMLogo;
	
	
	public LoginPage() {
		// TODO Auto-generated constructor stub
	PageFactory.initElements(driver, this);		
	}
	
	public String validatePageTitle(){
		return driver.getTitle();
	}
	
	
	public boolean validateLogo(){		
		return freeCRMLogo.isDisplayed();		
	}
	
	
	public HomePage login(String UserName, String Password){
		username.sendKeys(UserName);
		password.sendKeys(Password);
		//WebDriverWait wait = new WebDriverWait(driver, 40);
		//WebElement we = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));	
		loginBtn.submit();		
		//we = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[contains(@class,'img-responsive')]")));
		return new HomePage();
		
	}
	

}
