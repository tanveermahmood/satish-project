package com.singlecare.web.steps;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.singlecare.web.pages.HomeTestPage;
import com.singlecare.web.util.CommonUtil;

public class HomeStepDefs {

	HomeTestPage homeTestPage = new HomeTestPage();
	CommonUtil commonUtil = new CommonUtil();

	@QAFTestStep(description = "user verifies top navigation section on home page")
	public void verifyNavigationBar() {
		homeTestPage.verifyNavigationBar();
	}

	@QAFTestStep(description = "user verifies {0} text on home page")
	public void verifyElementText(String element) {
		homeTestPage.verifyElementText(element);
	}
	
	/*@QAFTestStep(description = "user navigate to {0} page")
	public void userclickonSigninLnk(String page) {
		homeTestPage.clickOnElement(page);
	}*/

}