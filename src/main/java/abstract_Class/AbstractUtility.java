package abstract_Class;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import page_Objects.Orders_Page;

public class AbstractUtility 
{
WebDriver driver;
public AbstractUtility(WebDriver driver)
{
this.driver=driver;
}

@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
WebElement addToCart;
By addtoCart=By.xpath("(//ul//button[@class='btn btn-custom'])[3]");
@FindBy(xpath = "(//ul//button[@class='btn btn-custom'])[2]")
WebElement ordersButton;
By orders=By.xpath("(//ul//button[@class='btn btn-custom'])[2]");

public void visibilityOfElementLocated(By by) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(by));	
}
public void invisibilityOfElementLocated(By by) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.invisibilityOfElementLocated(by));	
}
public void visibilityOfWebElementLocated(WebElement element) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(element));	
}
public void visibilityOfListOfWebElementLocated(List<WebElement> element) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfAllElements(element));	
}

public void cartPage() 
{
try {
	addToCart.click();
} catch (ElementClickInterceptedException e) {
WebElement addcart=driver.findElement(addtoCart);
addcart.click();
}}

public Orders_Page ordersPage() 
{
	try {
		ordersButton.click();
	} catch (ElementClickInterceptedException e) 
	{
		ordersButton.click();		
	}
	Orders_Page orders_Page=new Orders_Page(driver);
	return orders_Page;
}

}
