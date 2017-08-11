package com.singlecare.web.steps;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.singlecare.web.pages.LoginTestPage;
import com.singlecare.web.pages.SignupTestPage;
import com.singlecare.web.util.CommonUtil;

public class SignupStepDefs {

	SignupTestPage signupTestPage = new SignupTestPage();
	CommonUtil commonUtil = new CommonUtil();
	LoginTestPage loginTestPage = new LoginTestPage();

	
	@QAFTestStep(description = "user verifies signup page")
	public void userVerifySignupPage() {
		signupTestPage.verifyElementsOnSignupPage();
	}

	@QAFTestStep(description = "user do signup in signup page")
	public void userDoSignup() {
		signupTestPage.doSignUp();
	}
	
	@QAFTestStep(description = "verify user is on {0} page")
	public void userVerifyPage(String page) {
		commonUtil.verifyPage(page);
	}
	
	@QAFTestStep(description = "user gets welcome popup message")
	public void userVerifyWelcomePopupMsg() {
		signupTestPage.verifyWelcomepopupMsg();
	}
	
}