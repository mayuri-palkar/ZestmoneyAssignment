package testCases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import appModules.BaseTest;
import pageObject.FlipkartSearchItemPage;

public class FlipkartSearchItem extends BaseTest {
	
	static FlipkartSearchItemPage flipkartSearchItemPage;
	
	@BeforeTest
	public static void beforeSearchItemPage() throws Exception {
		
		BaseTest.setUp();
		driver.navigate().to("https://www.flipkart.com");
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		flipkartSearchItemPage = new FlipkartSearchItemPage(driver);
	}
	
	@Test(priority = 1) 
	public void flipkartOperation() throws InterruptedException {
		flipkartSearchItemPage.enterValueInSearch();
		flipkartSearchItemPage.selectItem();
	}

}
