package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accountpage {
	WebDriver driver;
	public Accountpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='Edit your account information']")
	public WebElement verifylogin;
	public boolean verifylogincredential() {
		boolean bl=false;
		try {			
		 bl=verifylogin.isDisplayed();
	}
		catch(Throwable e) {
			bl=false;
			System.out.println(e.getStackTrace());
		}
		return bl;
	}}
