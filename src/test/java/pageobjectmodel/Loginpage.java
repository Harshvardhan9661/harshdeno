package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	WebDriver driver;
	public Loginpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="input-email")
	public WebElement userid;
	@FindBy(id="input-password")
	public WebElement password;
	@FindBy(xpath="//input[@value='Login']")
	public WebElement submit;
	public void Enterusername(String username) {
		userid.sendKeys(username);
	}
	public void Enterpassword(String password1) {
		password.sendKeys(password1);
	}
	public Accountpage ClickSubmit() {
		submit.click();
		return new Accountpage(driver);
	}
	
	
	

}
