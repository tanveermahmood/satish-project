package com.singlecare.web.pages;

import org.hamcrest.Matchers;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;
import com.singlecare.web.databeans.Signupdatabean;

public class SignupTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "signup.signuppage.overview.caption.text")
	private QAFWebElement overviewCaptionText;
	@FindBy(locator = "signup.signuppage.overview.first.mesage.text")
	private QAFWebElement overviewFirstMesageText;
	@FindBy(locator = "signup.signuppage.overview.second.mesage.text")
	private QAFWebElement overviewSecondMesageText;
	@FindBy(locator = "signup.signuppage.loginnow.link")
	private QAFWebElement loginnowLink;
	@FindBy(locator = "signup.signuppage.firstname.input")
	private QAFWebElement firstnameInput;
	@FindBy(locator = "signup.signuppage.lastname.input")
	private QAFWebElement lastnameInput;	
	@FindBy(locator = "signup.signuppage.dob.input")
	private QAFWebElement dobInput;
	@FindBy(locator = "signup.signuppage.email.input")
	private QAFWebElement emailInput;
	@FindBy(locator = "signup.signuppage.password.input")
	private QAFWebElement passwordInput;
	@FindBy(locator = "signup.signuppage.promocode.input")
	private QAFWebElement promocodeInput;
	@FindBy(locator = "signup.signuppage.promocode.tooltip.link")
	private QAFWebElement promocodeTooltipLink;
	@FindBy(locator = "signup.signuppage.promocode.tooltip.text")
	private QAFWebElement promocodeTooltipText;
	@FindBy(locator = "signup.signuppage.promocode.gotit.text")
	private QAFWebElement promocodeGotitText;
	@FindBy(locator = "signup.signuppage.continue.button")
	private QAFWebElement continueButton;
	@FindBy(locator = "signup.signuppage.memberagreement.link")
	private QAFWebElement memberagreementLink;
	@FindBy(locator = "signup.signuppage.privacypolicy.link")
	private QAFWebElement privacypolicyLink;
	@FindBy(locator = "signup.signuppage.accept.text")
	private QAFWebElement acceptText;
	@FindBy(locator = "signup.signuppage.welcome.popup.text")
	private QAFWebElement welcomePopupText;
	

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getOverviewCaptionText() {
		return overviewCaptionText;
	}

	public QAFWebElement getOverviewFirstMesageText() {
		return overviewFirstMesageText;
	}

	public QAFWebElement getOverviewSecondMesageText() {
		return overviewSecondMesageText;
	}

	public QAFWebElement getLoginnowLink() {
		return loginnowLink;
	}

	public QAFWebElement getFirstnameInput() {
		return firstnameInput;
	}

	public QAFWebElement getLastnameInput() {
		return lastnameInput;
	}

	public QAFWebElement getDobInput() {
		return dobInput;
	}

	public QAFWebElement getEmailInput() {
		return emailInput;
	}

	public QAFWebElement getPasswordInput() {
		return passwordInput;
	}

	public QAFWebElement getPromocodeInput() {
		return promocodeInput;
	}

	public QAFWebElement getPromocodeTooltipLink() {
		return promocodeTooltipLink;
	}

	public QAFWebElement getPromocodeTooltipText() {
		return promocodeTooltipText;
	}

	public QAFWebElement getPromocodeGotitText() {
		return promocodeGotitText;
	}

	public QAFWebElement getContinueButton() {
		return continueButton;
	}

	public QAFWebElement getMemberagreementLink() {
		return memberagreementLink;
	}

	public QAFWebElement getPrivacypolicyLink() {
		return privacypolicyLink;
	}

	public QAFWebElement getAcceptText() {
		return acceptText;
	}
	
	public QAFWebElement getWelcomePopupText() {
		return welcomePopupText;
	}

	
	public void clickOnGender(String gendertype) {
		String gender = String.format(ConfigurationManager.getBundle().getString("signup.signuppage.gender.radiobutton"),
				gendertype);
		QAFExtendedWebElement eleGender = new QAFExtendedWebElement(gender);
		eleGender.click();
	}

	public void verifyGender(String gendertype) {
		QAFExtendedWebElement gender = new QAFExtendedWebElement(
				String.format(ConfigurationManager.getBundle().getString("signup.signuppage.gender.radiobutton"), gendertype));
		Validator.verifyThat("Gender " + gendertype + " is visible ", gender.getText(), Matchers.equalTo(gendertype));
	}

	public void verifyElementsOnSignupPage() {
		Validator.verifyThat("Label Text Present ", getOverviewCaptionText().getText(),
				Matchers.equalTo(pageProps.getString("lets.get.started.text")));
		Validator.verifyThat("Label Text Present ", getOverviewFirstMesageText().getText(),
				Matchers.equalTo(pageProps.getString("help.us.get.to.know.text")));
		Validator.verifyThat("Label Text Present ", getOverviewSecondMesageText().getText(),
				Matchers.containsString(pageProps.getString("already.have.an.account.text")));
		Validator.verifyThat("Label Text Present ", getLoginnowLink().getText(),
				Matchers.containsString(pageProps.getString("login.now.text")));
		getFirstnameInput().verifyVisible();
		getLastnameInput().verifyVisible();
		verifyGender("Male");
		verifyGender("Female");
		getDobInput().verifyVisible();
		getEmailInput().verifyVisible();
		getPasswordInput().verifyVisible();
		getPromocodeInput().verifyVisible();
		getContinueButton().verifyVisible();
		getMemberagreementLink().verifyVisible();
		getPrivacypolicyLink().verifyVisible();
	}
	
	public void verifyWelcomepopupMsg(){
		getWelcomePopupText().waitForVisible();
		Validator.verifyThat("Welcome Popup Message Displayed ", getWelcomePopupText().getText(),
				Matchers.equalTo(pageProps.getString("user.welcome.popup.msg.text")));
	}

	public void doSignUp() {
		Signupdatabean signupdatabean = new Signupdatabean();
		signupdatabean.fillRandomData();
		signupdatabean.fillUiElements();
		getContinueButton().verifyEnabled();
		getContinueButton().click();
		// QAFTestBase.pause(20000);
	}

	public void clickOnElement(String element) {
		switch (element) {
		case "member agreement":
			getMemberagreementLink().waitForVisible();
			getMemberagreementLink().click();
			break;
		case "privacy policy":
			getPrivacypolicyLink().waitForPresent();
			getPrivacypolicyLink().click();
			break;
		case "login now":
			getLoginnowLink().waitForVisible();
			getLoginnowLink().click();
			break;
		default :
			break;
		}
	}

}