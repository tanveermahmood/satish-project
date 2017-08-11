package com.singlecare.web.steps;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.singlecare.web.util.CommonUtil;
import com.singlecare.web.pages.HomeTestPage;
import com.singlecare.web.pages.LoginTestPage;
import com.singlecare.web.pages.SignupTestPage;

public class StepDefs {

	CommonUtil commonUtil = new CommonUtil();
	LoginTestPage loginTestPage = new LoginTestPage();
	SignupTestPage signupTestPage = new SignupTestPage();
	HomeTestPage homeTestPage = new HomeTestPage();
	/*
	 * Method to launch browser and navigate to app
	 */
	@QAFTestStep(description = "user is on singlecare {0} page")
	public void launchApp(String page) {
		commonUtil.launchApp();
		commonUtil.verifyPage(page);
	}

	/*
	 * Common method to verify Page is displayed.
	 * 
	 * @param page = ["Home" ,"Login"]
	 */
	@QAFTestStep(description = "user verifies {0} page")
	public void verifyPage(String page) {
		commonUtil.verifyPage(page);
	}
	
	@QAFTestStep(description = "user navigates to {0} page")
	public void userPerformOnPage(String page) {
		switch(page){
		case "signup":
			loginTestPage.clickOnElement(page);
			break;
		case "signin":
			homeTestPage.clickOnElement(page);
			break;
		case "member agreement":
			signupTestPage.clickOnElement(page);
			break;
		case "privacy policy":
			signupTestPage.clickOnElement(page);
			break;
			
		}
	}
}