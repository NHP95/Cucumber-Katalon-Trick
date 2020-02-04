package com.test.login
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import cucumber.api.Scenario
import cucumber.api.java.After
import cucumber.api.java.Before
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class LoginStep {
	LoginPage loginPage

	@Before
	def setUp() {
		WebUI.openBrowser('')
		loginPage = new LoginPage()
	}

	@After
	def tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot)DriverFactory.getWebDriver()).getScreenshotAs(OutputType.BYTES)
			scenario.embed(screenshot, "image/png")
		}
		WebUI.closeBrowser()
	}


	@Given("I navigate to {string}")
	def I_navigate_to_page(String url) {
		WebUI.navigateToUrl(url)
	}

	@When("I login to system using {string} and {string} as credentials")
	def I_login_to_system(String username, String password) {
		loginPage.login(username, password)
	}

	@Then("I see an account icon displayed")
	def I_see_account_icon() {
		WebUI.verifyEqual(loginPage.getAccountIcn().isDisplayed(), true)
	}

	@Then("I see {string} displayed as error message")
	def I_see_error_message(String msg) {
		WebUI.verifyEqual(loginPage.getErrTxt().getText().trim().contains(msg), true)
	}
}