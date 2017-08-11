package com.singlecare.web.databeans;

import com.qmetry.qaf.automation.data.BaseFormDataBean;
import com.qmetry.qaf.automation.ui.annotations.UiElement;
import com.qmetry.qaf.automation.ui.annotations.UiElement.Type;
import com.qmetry.qaf.automation.util.RandomStringGenerator.RandomizerTypes;
import com.qmetry.qaf.automation.util.Randomizer;
import com.singlecare.web.pages.SignupTestPage;

public class Signupdatabean extends BaseFormDataBean {

	@Randomizer(format = "Sample", type = RandomizerTypes.LETTERS_ONLY, length = 6)
	@UiElement(fieldLoc = "signup.signuppage.firstname.input", order = 1)
	private String fname;

	@Randomizer(format = "Demo", type = RandomizerTypes.LETTERS_ONLY, length = 6)
	@UiElement(fieldLoc = "signup.signuppage.lastname.input", order = 2)
	private String lname;

	@Randomizer(dataset = { "Male", "Female" })
	@UiElement(fieldLoc = "signup.signuppage.gender.radiobutton", required = true, fieldType = Type.checkbox, order = 3)
	private String gender;

	@Randomizer(dataset = { "10/05/1992", "11/24/1987", "06/08/1975", "09/30/1990", "01/17/1995"})
	@UiElement(fieldLoc = "signup.signuppage.dob.input", order = 4)
	private String dob;

	@Randomizer(prefix = "Infostretch+", type = RandomizerTypes.DIGITS_ONLY, suffix = "@gmail.com", length = 1)
	@UiElement(fieldLoc = "signup.signuppage.email.input", order = 5)
	private String email;

	@Randomizer(prefix = "D1", format = "Demo@1234", type = RandomizerTypes.MIXED, length = 8)
	@UiElement(fieldLoc = "signup.signuppage.password.input", order = 6)
	private String password;

	/*@UiElement(fieldLoc = "signup.signuppage.promocode.input", order = 7)
	private String promocode = "QATEST001";*/

	public void fillGender() {
		SignupTestPage signupTestPage = new SignupTestPage();
		signupTestPage.clickOnGender(gender);
	}

}
