package test_Scripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Original_Code
{
@Test
	public void submitOrder()
	{
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://rahulshettyacademy.com/client");
	driver.findElement(By.id("userEmail")).sendKeys("Chaip819@gmail.com");
	driver.findElement(By.id("userPassword")).sendKeys("Chaip819@gmail.com");
	driver.findElement(By.id("login")).click();

	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card")));
	List<WebElement> items = driver.findElements(By.cssSelector(".card"));
	WebElement element=items.stream().filter(a->a.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("zara coat 3")).findFirst().orElse(null);
	element.findElement(By.xpath("//button[.=' Add To Cart']")).click();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#toast-container")));

	WebElement addToCart= driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']"));
	try {
		addToCart.click();
	} catch (ElementClickInterceptedException e) {
	addToCart= driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']"));
	addToCart.click();
	}
	
	
	
	List<WebElement> names = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
	WebElement confirmItemName=names.stream().filter(a->a.getText().equalsIgnoreCase("zara coat 3")).findFirst().orElse(null);
	confirmItemName.findElement(By.xpath("//button[.='Buy Now']")).click();
	
	driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("india");
	 List<WebElement> list = driver.findElements(By.xpath("//section[@class='ta-results list-group ng-star-inserted']//span"));
	 WebElement countryName=list.stream().filter(a->a.getText().equalsIgnoreCase("india")).findFirst().orElse(null);
	 countryName.click();
	
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".action__submit")));
	 driver.findElement(By.cssSelector(".action__submit")).click();
	 
	 String text=driver.findElement(By.cssSelector(".hero-primary")).getText();
	 Assert.assertEquals(text, "THANKYOU FOR THE ORDER.");
	 
	}
}
