package com.singlecare.web.pages;

import org.hamcrest.Matchers;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class LoginTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "login.loginpage.singlecare.logo")
	private QAFWebElement singlecarelogo;
	@FindBy(locator = "login.loginpage.login.text")
	private QAFWebElement loginText;
	@FindBy(locator = "login.loginpage.email.input")
	private QAFWebElement emailInput;
	@FindBy(locator = "login.loginpage.password.input")
	private QAFWebElement passwordInput;
	@FindBy(locator = "login.loginpage.rememberme.checkbox")
	private QAFWebElement remembermeCheckbox;
	@FindBy(locator = "login.loginpage.login.button")
	private QAFWebElement loginButton;
	@FindBy(locator = "login.loginpage.forgetpassword.button")
	private QAFWebElement forgetpasswordButton;
	@FindBy(locator = "login.loginpage.signup.message.text")
	private QAFWebElement signupMessageText;
	@FindBy(locator = "login.loginpage.signup.button")
	private QAFWebElement signupButton;
	@FindBy(locator = "login.loginpage.error.msg.label")
	private QAFWebElement errorMsgLabel;
	@FindBy(locator = "login.loginpage.rememberme.label")
	private QAFWebElement remembermeLabel;
	@FindBy(locator = "login.loginpage.header.error.msg.label")
	private QAFWebElement headerErrorMsglabel;
	@FindBy(locator = "login.loginpage.password.error.msg.label")
	private QAFWebElement passwordErrorMsgLabel;
	@FindBy(locator = "login.loginpage.email.error.msg.label")
	private QAFWebElement emailErrorMsgLabel;

	

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getSinglecarelogo() {
		return singlecarelogo;
	}

	public QAFWebElement getLoginText() {
		return loginText;
	}

	public QAFWebElement getEmailInput() {
		return emailInput;
	}

	public QAFWebElement getPasswordInput() {
		return passwordInput;
	}

	public QAFWebElement getRemembermeCheckbox() {
		return remembermeCheckbox;
	}

	public QAFWebElement getLoginButton() {
		return loginButton;
	}

	public QAFWebElement getForgetpasswordButton() {
		return forgetpasswordButton;
	}

	public QAFWebElement getSignupMessageText() {
		return signupMessageText;
	}

	public QAFWebElement getSignupButton() {
		return signupButton;
	}

	public QAFWebElement getErrorMsgLabel() {
		return errorMsgLabel;
	}

	public QAFWebElement getRemembermeLabel() {
		return remembermeLabel;
	}

	public QAFWebElement getHeaderErrorMsglabel() {
		return headerErrorMsglabel;
	}

	public QAFWebElement getPasswordErrorMsgLabel() {
		return passwordErrorMsgLabel;
	}

	public QAFWebElement getEmailErrorMsgLabel() {
		return emailErrorMsgLabel;
	}

	public void verifyLoginPage() {
		getSinglecarelogo().verifyVisible();
		Validator.verifyThat(getLoginText().getText(), Matchers.equalTo(pageProps.getString("login.text")));
		getEmailInput().verifyVisible();
		getPasswordInput().verifyVisible();
		getRemembermeCheckbox().verifyVisible();
		Validator.verifyThat(getRemembermeLabel().getText(),
				Matchers.containsString(pageProps.getString("rememberme.text")));
		getLoginButton().verifyPresent();
		getForgetpasswordButton().verifyPresent();
		Validator.verifyThat(getSignupMessageText().getText(),
				Matchers.containsString(pageProps.getString("dont.have.account.text")));
		getSignupButton().verifyPresent();
	}

	public void clickOnElement(String element) {
		switch (element) {
		case "email":
			getEmailInput().waitForPresent();
			getEmailInput().click();
			break;
		case "password":
			getPasswordInput().waitForPresent();
			getPasswordInput().click();
			break;
		case "signup":
			getSignupButton().waitForVisible();
			getSignupButton().click();
			break;
		case "login button":
			getLoginButton().waitForEnabled();
			getLoginButton().click();
			break;
		default :
			break;
		}
	}

	public void enterEmail(String email) {
		getEmailInput().waitForPresent();
		getEmailInput().clear();
		getEmailInput().sendKeys(email);
	}

	public void enterPassword(String password) {
		getPasswordInput().waitForPresent();
		getPasswordInput().clear();
		getPasswordInput().sendKeys(password);
	}

	public void verifyErrorMsg() {
		Validator.verifyThat("Error message Displayed", getErrorMsgLabel().getText(),
				Matchers.equalTo(pageProps.getString("error.message.loginpage")));
	}

	public void verifyLoginBtn() {
		getLoginButton().verifyDisabled();
	}

	public void doLogin(String email, String password) {
		getEmailInput().waitForPresent();
		getEmailInput().clear();
		getEmailInput().sendKeys(email);
		getPasswordInput().waitForPresent();
		getPasswordInput().clear();
		getPasswordInput().sendKeys(password);
		getLoginButton().waitForEnabled();
		getLoginButton().click();
	}

	public void verifyValidErrorMsg() {
		Validator.verifyThat("Error message Displayed", getHeaderErrorMsglabel().getText(),
				Matchers.containsString(pageProps.getString("header.Error.message.text")));
	}
	
	public void verifyPasswordErrorMsg(){
		Validator.verifyThat("Password Error message Displayed",getPasswordErrorMsgLabel().getText(), Matchers.equalTo(pageProps.getString("password.Error.message.text")));
 
    }

	public void verifyInvalidEmailErrorMsg(){
		Validator.verifyThat("Invalid Email Error message Displayed",getEmailErrorMsgLabel().getText(), Matchers.equalTo(pageProps.getString("email.error.message.text")));
 
    }
}
