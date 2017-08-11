package com.singlecare.web.pages;

import java.util.List;
import org.hamcrest.Matchers;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;
import com.singlecare.web.template.HomeTemplate;

public class HomeTestPage extends HomeTemplate {
	
	
	@FindBy(locator = "mainlanding.homepage.promo.header.text")
	private QAFWebElement promoHeaderText;
	@FindBy(locator = "mainlanding.homepage.search.input")
	private QAFWebElement searchInput;
	@FindBy(locator = "mainlanding.homepage.explore.text")
	private QAFWebElement exploreText;
	@FindBy(locator = "mainlanding.homepage.promo.body.text")
	private QAFWebElement promoBodyText;
	@FindBy(locator = "mainlanding.homepage.explore.icons.list")
	private List<QAFWebElement> exploreIconsList;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}


	public QAFWebElement getPromoHeaderText() {
		return promoHeaderText;
	}

	public QAFWebElement getSearchInput() {
		return searchInput;
	}

	public QAFWebElement getExploreText() {
		return exploreText;
	}

	public QAFWebElement getPromoBodyText() {
		return promoBodyText;
	}

	public List<QAFWebElement> getExploreIconsList() {
		return exploreIconsList;
	}

	public void verifySigninLink() {
		getSigninLink().verifyVisible("Signin link");
	}

	public void verifyNavigationBar() {
		getSinglecarelogo().waitForPresent();
		getSinglecarelogo().verifyPresent();
		
		String[] leftHeaderSection = ConfigurationManager.getBundle().getString("home.left.header.items").split(":");
		String[] rightHeaderSection = ConfigurationManager.getBundle().getString("home.right.header.items").split(":");

		for (int i = 0; i < leftHeaderSection.length; i++) {
			getLeftHeaderSectionList().get(i).waitForVisible();
			Validator.verifyThat("Verify left header section", getLeftHeaderSectionList().get(i).getText(),
					Matchers.equalTo(leftHeaderSection[i]));
		}

		for (int i = 0; i < rightHeaderSection.length; i++) {
			getRightHeaderSectionList().get(i).waitForVisible();
			Validator.verifyThat("Verify right header section", getRightHeaderSectionList().get(i).getText(),
					Matchers.equalTo(rightHeaderSection[i]));
		}
	}

	public void verifyElementText(String element){
		switch(element){
		case "Top Promo" :
			Validator.verifyThat("Verify Top Promo header",getPromoHeaderText().getText(), Matchers.containsString(pageProps.getString("home.header.top.promo")));
			Validator.verifyThat("Verify Top Promo body",getPromoBodyText().getText(), Matchers.equalToIgnoringCase(pageProps.getString("home.body.top.promo")));
			break;
		case "Explore" :
			Validator.verifyThat("Verify Explore Text",getExploreText().getText(), Matchers.containsString(pageProps.getString("home.explore.text")));
			break;
		default :
			break;
		}
	}
	
	public void clickOnElement(String element){
		switch(element){
		case "signin":
			getSigninLink().waitForVisible();
			getSigninLink().click();
			break;
		default :
			break;
		}
	}
}