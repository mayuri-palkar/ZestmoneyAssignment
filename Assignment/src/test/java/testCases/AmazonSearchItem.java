package testCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import appModules.BaseTest;
import pageObject.AmazonSearchItemPage;

public class AmazonSearchItem extends BaseTest {
	
	static AmazonSearchItemPage amazonSearchItemPage;
	
	@BeforeTest
	public static void beforeSearchItemPage() throws Exception {		
		BaseTest.setUp();
		amazonSearchItemPage = new AmazonSearchItemPage(driver);
	}

	@Test(priority = 1) 
		public void amazonOpration() throws InterruptedException {
			amazonSearchItemPage.enterValueInSearch();
			amazonSearchItemPage.selectItem();
		}

}

