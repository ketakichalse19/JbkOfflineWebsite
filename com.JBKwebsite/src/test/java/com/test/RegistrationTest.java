package com.test;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.pages.RegistrationPage;

public class RegistrationTest extends TestBase {
	
	TestBase testbase = null;
	RegistrationPage register = null;

	@BeforeSuite
	public void launchApplication() throws Throwable {
		testbase = new TestBase();
		testbase.launchApplication();
		register = new RegistrationPage(driver);
	}
	
	@Test(priority = 1)
	public void checkRegistrationLink() {
		Assert.assertTrue(register.validateRegistraionLink(driver));
	}

	@Test(priority = 2)
	public void checkHeading() {
		Assert.assertTrue(register.getTextOfHeading(driver));
	}

	@Test(priority = 3)
	public void checkTitle() {
		Assert.assertTrue(register.getTitleOfRegistrationPage(driver));
	}

	@Test(priority = 4)
	public void checkTextBoxCounting() {
		Assert.assertTrue(register.validateNoOfTextBoxes(driver));
	}

	@Test(priority = 5)
	public void checkIfUserAdded() throws Throwable {
		register.EnterName();
		register.EnterMobile();
		register.EnterEmail();
		register.EnterPassword();
		Assert.assertTrue(register.validateAlertMessage(driver));
	}

	@Test(priority = 6)
	public void checkIfMembershipExist() {
		Assert.assertTrue(register.validationOfMembership(driver));
	}

}
