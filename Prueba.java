import java.time.Duration;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;


public class Prueba {
  
	public WebDriver driver;
	
@Test
public void casoRefri() 
	{
		//Initialize driver /Users/a.delgado.bocanegra/Downloads
		System.setProperty("webdriver.chrome.driver", "/Users/a.delgado.bocanegra/Downloads/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//open website
		driver.get("https://www.amazon.com/");
		
		
		//set text to search for search for samsung fridge
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("refrigerador samsung");
		//Hit button to search for fridge
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		//view product page
		driver.findElement(By.xpath("//div[@class='a-section aok-relative s-image-square-aspect']//img[@alt='Refrigerador Samsung Top Mount de 11 pies RT29A5000S8']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		//add to cart
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30));
		driver.findElement(By.xpath("//input[@aria-labelledby='attachSiNoCoverage-announce']")).click();
		
		//set text to search for search for Mabe fridge
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("refrigerador mabe");
		//Hit button to search for fridge
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		//view product page
		driver.findElement(By.xpath("//img[@alt='Refrigerador Automático 360L Silver Mabe - RME360FGMRS0']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		//add to cart
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30));
		driver.findElement(By.xpath("//input[@aria-labelledby='attachSiNoCoverage-announce']")).click();
		
		//verify total purchase
		int totalPurchase = Integer.parseInt(driver.findElement(By.xpath("//span[@class='a-size-base a-color-price a-text-bold']")).getText());
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(totalPurchase < 10000, "Purchase is greater than 10000");
		softAssert.assertTrue(totalPurchase > 10000, "Purchase is lesser than 10000");
		
		//Close browser
		driver.quit();
	}
}