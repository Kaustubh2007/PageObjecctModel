package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//td[contains(text(), 'User: Kaustubh Baitule')]")
	@CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath="//a[contains(text(),'Contacts' )]")
	WebElement contactsLink;

	@FindBy(xpath="//a[contains(text(),'New Contact' )]")
	WebElement newContactLink;

	@FindBy(xpath="//a[contains(text(),'Deals' )]")
	WebElement dealsLink;

	//a[contains(text(),'Tasks' )]
	@FindBy(xpath="//a[contains(text(),'Tasks' )]")
	WebElement tasksLink;

	//Initializing HomePage Objects
	public HomePage(){
		PageFactory.initElements(driver, this);
	}

	//Actions
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyLoginUser() {
		return userNameLabel.isDisplayed();
	}

	public Contacts clickOnContactsLink() {
		contactsLink.click();
		return new Contacts();
	}

	public void clickOnNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform(); //a[@title='New Contact']
		newContactLink.click();
	}

	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
}
