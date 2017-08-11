package com.singlecare.web.template;

import java.util.List;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class HomeTemplate extends WebDriverBaseTestPage<WebDriverTestPage>{

	@FindBy(locator = "hometemplate.signin.link")
	private QAFWebElement signinLink;
	@FindBy(locator = "hometemplate.header.menu.list")
	private List<QAFWebElement> headerMenuList;
	@FindBy(locator = "hometemplate.left.header.section.list")
	private List<QAFWebElement> leftHeaderSectionList;
	@FindBy(locator = "hometemplate.right.header.section.list")
	private List<QAFWebElement> rightHeaderSectionList;
	@FindBy(locator = "hometemplate.singlecare.logo")
	private QAFWebElement singlecarelogo;
	
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}

	public QAFWebElement getSigninLink() {
		return signinLink;
	}

	public List<QAFWebElement> getHeaderMenuList() {
		return headerMenuList;
	}

	public List<QAFWebElement> getLeftHeaderSectionList() {
		return leftHeaderSectionList;
	}

	public List<QAFWebElement> getRightHeaderSectionList() {
		return rightHeaderSectionList;
	}

	public QAFWebElement getSinglecarelogo() {
		return singlecarelogo;
	}

}
