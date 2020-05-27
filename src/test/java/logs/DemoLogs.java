package logs;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;
import org.testng.annotations.Test;

public class DemoLogs {
	WebDriver driver;
	Logger log = Logger. getLogger(DemoLogs.class);
	@BeforeMethod
	public void setup(){
		log.info("****************************** Starting test cases execution  *****************************************");
		/*System.setProperty("webdriver.gecko.driver", "C:\\Users\\SimTaj\\workspace\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http:\\fb.com");*/
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SimTaj\\workspace\\chromedriver.exe");
		driver = new ChromeDriver();
		log.info("launching chrome broswer");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://classic.crmpro.com");
		log.info("entering application URL");
		log.warn("Hey this just a warning message");
		log.fatal("hey this is just fatal error message");
		log.debug("this is debug message");
	}
	
	@Test(priority = 1)
	public void FreeCrmTitleTest(){
		log.info("****************************** starting test case1 *****************************************");
		log.info("****************************** freeCrmTitleTest *****************************************");
		String title= driver.getTitle();
		Assert.assertEquals(title,"CRMPRO - CRM software for customer relationship management, sales, and support.");
	}

	 @Test(priority = 2)
	 public void FreeCrmLogoTest(){
		 log.info("****************************** starting test case2 *****************************************");
			log.info("****************************** freeCrmLogoTest *****************************************");
		boolean b = driver.findElement(By.xpath("//img[contains(@class,'img-responsive')]")).isDisplayed();
		Assert.assertTrue(b);
	 }
	
	 @AfterMethod
		public void tearDown(){
			driver.quit();
			log.info("****************************** Browser is closed *****************************************");
	 }
	
	
	

}
