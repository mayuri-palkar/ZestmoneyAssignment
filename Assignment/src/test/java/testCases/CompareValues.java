package testCases;

import org.testng.annotations.Test;

import appModules.BaseTest;
import pageObject.CompareValuesPage;

public class CompareValues extends BaseTest {
	
	static CompareValuesPage compareValuesPage;
	
	@Test(priority = 1) 
	public void comparePriceOperation() throws InterruptedException {
		compareValuesPage.comparePriceValues();
	}

}
