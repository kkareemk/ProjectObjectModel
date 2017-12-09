package com.oracle.qa.crm.pages;

import org.apache.log4j.helpers.AbsoluteTimeDateFormat;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oracle.qa.crm.base.TestBase;

public class HomePage extends TestBase{
	
	
	@FindBy(xpath ="//td[contains(text(),'User: Naveen K')]")
	WebElement userName;
	
	@FindBy(xpath = "//a[contains(text(), 'Contacts')]")
	WebElement contacts;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement NewContacts;
	
	
	
	
	@FindBy(xpath = "//a[contains(text(), 'Deals')]")
	WebElement deals;
	
	@FindBy(xpath = "//a[contains(text(), 'Tasks')]")
	WebElement tasks;
	
	public HomePage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);	
	}
	
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}	
	
	public ContactsPage clickOnContactLink(){
		contacts.click();	
		return new ContactsPage();
	}
		
	public DealsPage clickOnDealsLink(){
		deals.click();		
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink(){
		tasks.click();		
		return new TasksPage();
	}
	
	
	public Boolean verifyCorrectUserName(){
		return userName.isDisplayed();
	}
	
	
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(contacts).build().perform();
		NewContacts.click();	
		
		
	}
	
	
	

}
