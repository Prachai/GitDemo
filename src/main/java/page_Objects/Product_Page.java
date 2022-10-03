package page_Objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import abstract_Class.AbstractUtility;

public class Product_Page extends AbstractUtility{
	WebDriver driver;
	public Product_Page(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
@FindBy(css  = ".mb-3")
List<WebElement> items;

By prodName=By.cssSelector("b");
By addtoCart=By.xpath("//div[@class='card-body']//button[@class='btn w-10 rounded']");	
By confirmationMsg=By.cssSelector("#toast-container");	
	
	public Cart_Page getTheProduct(String itemName) throws InterruptedException 
	{
		visibilityOfListOfWebElementLocated(items);
		WebElement element=items.stream().filter(a->a.findElement(prodName).getText().equalsIgnoreCase(itemName)).findFirst().orElse(null);
		element.findElement(addtoCart).click();
		visibilityOfElementLocated(confirmationMsg);
		invisibilityOfElementLocated(confirmationMsg);
		Thread.sleep(2000);
		cartPage();
		Cart_Page cart_page=new Cart_Page(driver);
		return cart_page;
	}
}
