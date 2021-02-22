package pageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AmazonSearchItemPage {
	
	WebDriver driver;
	String amazonItemText = "iPhone XR (256GB) -Yellow";
	public String AmazonItemPrice;
	public int finalAmazonPrice;
	
	/**
	 * Author: Mayuri Otari
	 * Purpose: Method to declare constructor
	 */
	public AmazonSearchItemPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='twotabsearchtextbox']")
	public WebElement searchBox;
	
	@FindBy(how = How.XPATH, using = "//input[@id='nav-search-submit-button']")
	public WebElement searchIcon;
	
	@FindBy(how = How.XPATH, using = "//div[@class='sg-col-inner']//div[@class='a-section a-spacing-none']//a[@class='a-link-normal a-text-normal']//span")
	public List<WebElement> totalItems;
	
	@FindBy(how = How.XPATH, using = "//input[@id='add-to-cart-button']")
	public WebElement addTocart;
	
	@FindBy(how = How.XPATH, using = "//div[@class='a-section a-spacing-none a-padding-none']//span[@class='a-color-price']")
	public WebElement amazonPrice;
	
	
	/**
	 * Author: Mayuri Otari
	 * Purpose: Method to search the item
	 */
	public void enterValueInSearch() throws InterruptedException {
		searchBox.sendKeys("iPhone XR");
		Thread.sleep(2000);
		searchIcon.click();
	}
	
	
	/**
	 * Author: Mayuri Otari
	 * Purpose: Method to select exact item
	 */
	public void selectItem() throws InterruptedException {
		
		amazonItemText = amazonItemText.replaceAll("\\p{P}","").replace("(", "").replace(")", "");
		System.out.println("Item to be searched : "+ amazonItemText);
		
		for(int i=0; i<totalItems.size(); i++) {
			if(totalItems.get(i).getText().trim().contains(amazonItemText.toString().trim())) {
				totalItems.get(i).click();
				Thread.sleep(2000);
				//addTocart.click();
				//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addTocart);
				Thread.sleep(5000);
				AmazonItemPrice = amazonPrice.getText().trim();
				finalAmazonPrice = Integer.valueOf(AmazonItemPrice);
				System.out.println("Amazon Price : "+ finalAmazonPrice);
			}
		}
	}
}
