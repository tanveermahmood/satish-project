package com.singlecare.web.util;

import org.hamcrest.Matchers;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;


public class CommonUtil extends WebDriverBaseTestPage<WebDriverTestPage> {

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
		driver.get("/");
		driver.manage().window().maximize();
	}

	public void launchApp() {
		launchPage(null);
	}

	public void verifyPage(String page) {
		String title = driver.getTitle();
		Reporter.log("Page title is " + title, MessageTypes.Info);
		switch (page) {
		case "home":
			Validator.verifyThat("We are on singlecare page", title,
					Matchers.equalTo(pageProps.getString("home.title")));
			break;
		case "login":
			Validator.verifyThat("We are on Login page", title,
					Matchers.equalTo(pageProps.getString("login.page.title")));
			break;
		case "signup":
			Validator.verifyThat("We are on Signup page", title,
					Matchers.equalTo(pageProps.getString("signup.page.title")));
			break;
		case "member agreement":
			Validator.verifyThat("We are on Member agreement page", title,
					Matchers.equalTo(pageProps.getString("member.agreement.page.title")));
			navigatesBack();
			break;
		case "privacy policy":
			Validator.verifyThat("We are on Privacy policy page", title,
					Matchers.equalTo(pageProps.getString("privacy.policy.page.title")));
			navigatesBack();
			break;
		case "welcome":
			Validator.verifyThat("We are on user welcome page", title,
					Matchers.equalTo(pageProps.getString("user.welcome.page.title")));
			break;
		default:
			break;
		}
	}

	public void navigatesBack() {
		driver.navigate().back();
	}

}