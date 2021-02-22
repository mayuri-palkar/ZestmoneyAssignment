package pageObject;

public class CompareValuesPage {
	
	AmazonSearchItemPage amazonPage;
	FlipkartSearchItemPage flipkarPage;
	
	/**
	 * Author: Mayuri Otari
	 * Purpose: Method to compare both prices
	 */
	public void comparePriceValues() {
		if(amazonPage.finalAmazonPrice < flipkarPage.finalFlipkartPrice) {
			System.out.println("Amazon Price is lesser value : " + amazonPage.finalAmazonPrice);
		}
		else {
			System.out.println("Flipkart Price is lesser value : " + flipkarPage.finalFlipkartPrice);
		}
	}
}
