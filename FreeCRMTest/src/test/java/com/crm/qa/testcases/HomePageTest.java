package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Contacts;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	Contacts contactsPage;
	DealsPage dealsPage;
	TasksPage tasksPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		contactsPage = new Contacts();
		dealsPage = new DealsPage();
		tasksPage = new TasksPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO");
	}

	@Test(priority=2)
	public void verifyLoginUserTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyLoginUser());
	}

	@Test(priority=3)
	public void verifyContactsLinkTest() {
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}

	@Test(priority=4)
	public void verifyDealsLinkTest() {
		testUtil.switchToFrame();
		dealsPage = homePage.clickOnDealsLink();
	}

	@Test(priority=5)
	public void verifyTasksLinkTest() {
		testUtil.switchToFrame();
		tasksPage = homePage.clickOnTasksLink();
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
