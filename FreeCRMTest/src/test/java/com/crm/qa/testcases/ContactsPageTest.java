package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Contacts;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	Contacts contactsPage;
	DealsPage dealsPage;
	TasksPage tasksPage;

	String sheetName = "contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
		loginPage = new LoginPage();
		contactsPage= new Contacts();
		dealsPage = new DealsPage();
		tasksPage = new TasksPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}

	@Test(priority=1)
	public void verifyContactsPageLabel(){
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing from Contacts Page");
	}

	@Test(priority=2)
	public void selectSingleContactTest() {
		contactsPage.selectContactsByName("test2 test2");
	}

	@Test(priority=3)
	public void selectMultipleContactsTest() {
		contactsPage.selectContactsByName("test2 test2");
		contactsPage.selectContactsByName("Tom Peter");
	}

	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company){
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		contactsPage.createNewContact(title, firstName, lastName, company);

	}

	@Test(priority=5)
	public void validateCreateNewContact() {
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact("Mr.", "Chaman", "Chatni", "Dhokla");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
