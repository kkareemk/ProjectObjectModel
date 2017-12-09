package com.oracle.qa.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.oracle.qa.crm.base.TestBase;
import com.oracle.qa.crm.pages.HomePage;
import com.oracle.qa.crm.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		// TODO Auto-generated constructor stub
		super();	
	}
	
	@BeforeMethod
	public void setUp() {
		// TODO Auto-generated method stub
		initialization();
		loginPage = new LoginPage();		
	}
	
	@Test(priority =1)
	public void loginPageTitleTest(){
		String title = loginPage.validatePageTitle();
		Assert.assertEquals("#1 Free CRM for Any Business: Online Customer Relationship Software", title);
	}
	
	@Test(priority =2)
	public void crmLogoImageTest(){
		boolean flag = loginPage.validateLogo();
		Assert.assertTrue(flag);		
	}
	
	
	@Test(priority =3)
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
