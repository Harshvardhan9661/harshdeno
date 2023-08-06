package basefolder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static Properties pro;
	public static WebDriver driver;
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		pro=new Properties();
		File profile=new File(System.getProperty("user.dir")+"\\UtilityFolder\\Inputfile.properties");
		FileInputStream fi=new FileInputStream(profile);
		pro.load(fi);
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(pro.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
