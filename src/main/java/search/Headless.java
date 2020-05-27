package search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Headless {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new HtmlUnitDriver();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			driver.get("https://www.facebook.com/");
			 System.out.println("title is "+ driver.getTitle());
	}

}
