package org.pages;
import java.util.List;
import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

	// With out page factory
//	public WebElement getUser() {
//
//		WebElement txtUsername = driver.findElement(By.id("email"));
//		return txtUsername;
//	}

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBys({ @FindBy(id = "email"), @FindBy(xpath = "//input[@name='email']") })
	private List<WebElement> txtUsername;

	@FindAll({ @FindBy(id = "password"), @FindBy(xpath = "//input[@name='pass']") })
	private WebElement txtPassword;

	@FindBy(name = "login")
	private WebElement btnClick;

	public List<WebElement> getTxtUserName() {
		return txtUsername;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnClick() {
		return btnClick;
	}

	

}
