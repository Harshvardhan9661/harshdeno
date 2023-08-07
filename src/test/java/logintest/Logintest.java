package logintest;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basefolder.Baseclass;
import pageobjectmodel.Accountpage;
import pageobjectmodel.Homepage;
import pageobjectmodel.Loginpage;
import utilitypackage.DataUtil;
import utilitypackage.MyXLSReader;

//cass to read data from excel file 
//secod line comment 
//third line comment ;
public class Logintest extends Baseclass {
	MyXLSReader xlreader;
	
	@Test(dataProvider="getdate")
	public void loginmethod(HashMap<String,String> map) throws InterruptedException {
		//|| map.get("Runmode").equals("N")
		System.out.println("test1");
		if(!DataUtil.isRunnable(xlreader, "LoginTest", "Testcases") || map.get("Runmode").equals("N")) {
			System.out.println("test2");
			throw new SkipException("skipped test");}
		System.out.println("test5");
		Homepage homepage=new Homepage(driver);
		System.out.println("test6");
		homepage.clickonmyaccount();
		System.out.println("test7");
		Loginpage lp=homepage.clickonmylogin();
		lp.Enterusername(map.get("Username"));
		lp.Enterpassword(map.get("Password"));
		Accountpage ap=lp.ClickSubmit();
		Thread.sleep(40);
		boolean bl=ap.verifylogincredential();
		AssertJUnit.assertTrue(bl);	
	}
	@DataProvider(name="getdate")
	public Object[][] getdate() throws Exception {
		String path="UtilityFolder\\TutorialsNinja.xlsx";
		xlreader=new MyXLSReader(path);
		Object[][] obj=DataUtil.getTestData(xlreader, "LoginTest", "Data");
		return obj;}
}
