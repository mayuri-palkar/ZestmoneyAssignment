package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FlipkartSearchItemPage {

	WebDriver driver;
	String flipkartItemText = "iPhone XR -Yellow (256 GB)";
	public String FlipkartItemPrice;
	public int finalFlipkartPrice;

	/**
	 * Author: Mayuri Otari
	 * Purpose: Method to declare constructor
	 */
	public FlipkartSearchItemPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how = How.XPATH, using = "//button[@class='_2KpZ6l _2doB4z']")
	public WebElement closeIcon;

	@FindBy(how = How.XPATH, using = "//input[@title='Search for products, brands and more']")
	public WebElement searchBox;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	public WebElement searchIcon;

	@FindBy(how = How.XPATH, using = "//div[@class='col col-7-12']//div[@class='_4rR01T']")
	public List<WebElement> totalItems;
	
	@FindBy(how = How.XPATH, using = "//div[@class='_30jeq3 _16Jk6d']")
	public WebElement flipkartPrice;

	
	/**
	 * Author: Mayuri Otari
	 * Purpose: Method to search the item
	 */
	public void enterValueInSearch() throws InterruptedException {
		
		closeIcon.click();
		searchBox.sendKeys(flipkartItemText);
		Thread.sleep(2000);
		searchIcon.click();
	}

	
	/**
	 * Author: Mayuri Otari
	 * Purpose: Method to select exact item
	 */
	public void selectItem() throws InterruptedException {
		flipkartItemText = flipkartItemText.replaceAll("\\p{P}", "").replace("(", "").replace(")", "");
		System.out.println("Item to be searched : " + flipkartItemText);

		for (int i = 0; i < totalItems.size(); i++) {
			
			if (totalItems.get(i).getText().trim().replaceAll("\\p{P}", "").replace("(", "").replace(")", "")
					.contains(flipkartItemText.toString().trim())) {
				totalItems.get(i).click();
				Thread.sleep(2000);
				
				FlipkartItemPrice = flipkartPrice.getText().trim();
				finalFlipkartPrice = Integer.valueOf(FlipkartItemPrice);

				System.out.println("Amazon Price : " + finalFlipkartPrice);
			}
		}
	}
}
