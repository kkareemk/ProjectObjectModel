package com.oracle.qa.crm.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.oracle.qa.crm.base.TestBase;
import com.oracle.qa.crm.pages.ContactsPage;
import com.oracle.qa.crm.pages.HomePage;
import com.oracle.qa.crm.pages.LoginPage;
import com.oracle.qa.crm.utility.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheet = "Contacts";
	
	
	public ContactsPageTest() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		homepage = new HomePage();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homepage.clickOnContactLink();
	}
	
	
	@Test(priority =1)
	public void verifyContactsPageLabel(){
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts Label is missing on the page.");
	}
	
	
	@Test(priority =2)
	public void selectSingleContactsTest(){
		contactsPage.selectContactsByName("abram RRnn");
	}
	
	
	@Test(priority =3)
	public void selectMultipleContactsTest(){
		contactsPage.selectContactsByName("abram RRnn");
		contactsPage.selectContactsByName("Akash Rathor");
		contactsPage.selectContactsByName("aab nnn");
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object[][] data = TestUtil.getTestData(sheet);
		return data;
		}
	
	@Test(priority =4, dataProvider="getCRMTestData")
	private void validateCreateNewContact(String Title, String FirstName, String LastName, String Company) {
		// TODO Auto-generated method stub
		homepage.clickOnNewContactLink();		
		//contactsPage.createNewContact("Mr.", "Tommy", "Pe", "Gmail");
		contactsPage.createNewContact(Title, FirstName, LastName, Company);
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	

}
