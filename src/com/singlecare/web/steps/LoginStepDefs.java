package com.singlecare.web.steps;

import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.singlecare.web.pages.LoginTestPage;
import com.singlecare.web.util.CommonUtil;

public class LoginStepDefs {

	LoginTestPage loginTestPage = new LoginTestPage();
	CommonUtil commonUtil = new CommonUtil();

	@QAFTestStep(description = "user verifies {0} page")
	public void userVerifyLoginPage(String page) {
		commonUtil.verifyPage(page);
		loginTestPage.verifyLoginPage();
	}

	@QAFTestStep(description = "user verifies successful log in")
	public void userIsOnWelcomePage() {
		QAFTestBase.pause(5000);
		commonUtil.verifyPage("Welcome");
	}

	@QAFTestStep(description = "user login with blank email and blank password")
	public void userClickOnEmailLeaveBlnk() {
		loginTestPage.clickOnElement("email");
		loginTestPage.clickOnElement("password");
		loginTestPage.clickOnElement("email");
	}

	@QAFTestStep(description = "user gets field error message")
	public void userVerifyErrorMsg() {
		loginTestPage.verifyErrorMsg();
	}

	@QAFTestStep(description = "verify user unable to log in")
	public void userVerifyLoginBtn() {
		loginTestPage.verifyLoginBtn();
	}

	@QAFTestStep(description = "user login with {0} and blank password")
	public void userLoginWithEmailAndBlnkPassword(String email) {
		loginTestPage.enterEmail(email);
		loginTestPage.enterPassword("");
		loginTestPage.clickOnElement("email");
	}

	@QAFTestStep(description = "user login with blank email and {0}")
	public void userLoginWithBlnkEmailAndPassword(String validPassword) {
		loginTestPage.enterEmail("");
		loginTestPage.clickOnElement("password");
		loginTestPage.enterPassword(validPassword);
	}
	
	@QAFTestStep(description = "user login with {0} and {1}" )
	public void userLoginWithEmailAndPassword(String email,String password) {
		loginTestPage.enterEmail(email);
		loginTestPage.enterPassword(password);
		loginTestPage.clickOnElement("login button");
		QAFTestBase.pause(2000);
		
	}

	@QAFTestStep(description = "user login with {email} and invalid {FormatPassword}" )
	public void userLoginWithEmailAndInvalidFormatPassword(String email,String FormatPassword) {
		loginTestPage.enterEmail(email);
		loginTestPage.enterPassword(FormatPassword);
		
	}

	@QAFTestStep(description = "user enters invalid password {0}")
	public void userEnterInvalidPassword(String invalidPassword) {
		loginTestPage.enterPassword(invalidPassword);
	}

	@QAFTestStep(description = "user gets validation error message")
	public void userVerifyValidErrorMsg() {
		loginTestPage.clickOnElement("email");
		loginTestPage.verifyValidErrorMsg();
	}
	
	@QAFTestStep(description = "user gets error message")
	public void userVerifyinvalidErrorMsg() {
		loginTestPage.verifyValidErrorMsg();
	}

	@QAFTestStep(description = "user login with invalid {0} and valid {1}" )
	public void userLoginWithInvalidEmailAndValidPassword(String sqlinvalidemail,String password) {
		loginTestPage.enterEmail(sqlinvalidemail);
		loginTestPage.enterPassword(password);
		
	}

	@QAFTestStep(description = "user gets password error message")
	public void userVerifyPasswordErrorMsg() {
		loginTestPage.clickOnElement("email");
		loginTestPage.verifyPasswordErrorMsg();
	}

	@QAFTestStep(description = "user gets invalid email error message")
	public void userVerifyInvalidEmailMsg() {
		loginTestPage.verifyInvalidEmailErrorMsg();
	}
	
}
