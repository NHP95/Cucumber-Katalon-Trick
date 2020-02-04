package com.test.login
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import com.kms.katalon.core.webui.driver.DriverFactory


public class LoginPage {
	@FindBy(id = "j_username") WebElement usernameTxb
	@FindBy(id = "j_password") WebElement passwordTxb
	@FindBy(css = "input[value='Sign in']") WebElement loginBtn
	@FindBy(id = "header-account") WebElement accountIcn
	@FindBy(css = ".modal-errors-info") WebElement errTxt

	public LoginPage() {
		PageFactory.initElements(DriverFactory.getWebDriver(), this)
	}

	public void login(String username, String password) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getWebDriver(), 5)
		wait.until(ExpectedConditions.visibilityOf(usernameTxb))
		usernameTxb.sendKeys(username)
		passwordTxb.sendKeys(password)
		loginBtn.click()
	}

	public WebElement getAccountIcn() {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getWebDriver(), 5)
		return wait.until(ExpectedConditions.visibilityOf(accountIcn))
	}
}