package com.oracle.qa.crm.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.oracle.qa.crm.base.TestBase;
import com.oracle.qa.crm.pages.ContactsPage;
import com.oracle.qa.crm.pages.HomePage;
import com.oracle.qa.crm.pages.LoginPage;
import com.oracle.qa.crm.utility.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		// TODO Auto-generated constructor stub
		super();
	}	
	
	@BeforeMethod
	public void setUp() {
		// TODO Auto-generated method stub
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));		
	}
	
	
	@Test(priority =1)
	public void verifyHomePageTitleTest(){
		String ActualTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(ActualTitle,"CRMPRO","Home Page title not matched");
		
	}
	
	@Test(priority =2)
	public void verifyUserNameTest(){
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority =3)
	public void verifyContactsLinkTest(){
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactLink();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
