import java.time.Duration;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;


public class Prueba {
  
	public WebDriver driver;
	
@Test
public void casoRefriSamsung() 
	{
		//Initialize driver /Users/a.delgado.bocanegra/Downloads
		System.setProperty("webdriver.chrome.driver", "/Users/a.delgado.bocanegra/eclipse-workspace/chromedriver");
		WebDriver driver = new ChromeDriver();
		//open website
		driver.get("https://www.amazon.com.mx/");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		
		//set text to search for search for samsung fridge
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("refrigerador samsung");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		//Hit button to search for fridge
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		
		//view product page
		driver.findElement(By.xpath("//div[@class='a-section aok-relative s-image-square-aspect']//img[@alt='Refrigerador Samsung Top Mount de 11 pies RT29A5000S8']")).click();
		//add to cart
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.findElement(By.xpath("//input[@aria-labelledby='attachSiNoCoverage-announce']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		
		//set text to search for search for Mabe fridge
		driver.findElement(By.id("nav-logo-sprites")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("refrigerador mabe");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		//Hit button to search for fridge
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		
		//view product page
		driver.findElement(By.xpath("//img[@alt='Refrigerador Automático 360L Silver Mabe - RME360FGMRS0']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		//add to cart
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.findElement(By.xpath("//input[@aria-labelledby='attachSiNoCoverage-announce']")).click();
		
		//verify total purchase
		//Find purchase mount
		String purchaseAmt = driver.findElement(By.xpath("//span[@class='a-size-base a-color-price a-text-bold']")).getText();
		//Remove special characters
		String dbAmt = purchaseAmt.replaceAll("[$,]", "");
		//Cast string as double
		Double totalPurchase = Double.parseDouble(dbAmt);
		//Price comparison
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(totalPurchase < 10000, "Purchase is greater than 10000");
		softAssert.assertTrue(totalPurchase > 10000, "Purchase is lesser than 10000");
		
		//Close browser
		driver.quit();
	}
}