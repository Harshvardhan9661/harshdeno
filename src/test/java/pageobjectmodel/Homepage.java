package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	WebDriver driver;
	

	public  Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@title='My Account']")
	public  WebElement clickonmyacco;
	@FindBy(xpath="//a[text()='Login'][1]")
	public  WebElement clickonlogin;
	public void clickonmyaccount() {
		System.out.println("test3");
		clickonmyacco.click();
		System.out.println("test4");
	}
	public Loginpage clickonmylogin() {
		clickonlogin.click();
		return new Loginpage(driver);
	}
	

}
