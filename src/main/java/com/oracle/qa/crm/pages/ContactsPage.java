package com.oracle.qa.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.oracle.qa.crm.base.TestBase;

public class ContactsPage extends TestBase{
	
	
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath = ".//*[@id='first_name']")
	WebElement firstName;
		
	@FindBy(xpath = ".//*[@id='surname']")
	WebElement lastName;
	
	@FindBy(name = "client_lookup")
	WebElement company;
	
	
	@FindBy(xpath = "//input[@class='button' and @value='Save']")
	WebElement saveBtn;
	
	
	public ContactsPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	
	public Boolean verifyContactsLabel(){
		return  contactsLabel.isDisplayed();
	}
	
	
	public void selectContactsByName(String contactName){
		driver.findElement(By.xpath("//a[@_name='"+contactName+"']/parent::td[@class='datalistrow']/preceding-sibling::td[@class='datalistrow']/input[@type='checkbox']")).click();
		
	}
	
	
	public void createNewContact(String title, String fName, String lName, String companyName){
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		company.sendKeys(companyName);
		saveBtn.click();		
	}
	
	
	
	
	
	
	
	
	
}
