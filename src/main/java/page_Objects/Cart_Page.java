package page_Objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstract_Class.AbstractUtility;

public class Cart_Page extends AbstractUtility
{
	WebDriver driver;
	public Cart_Page(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

@FindBy(xpath = "//div[@class='cartSection']/h3")
List<WebElement> names; 

By buynowButton=By.xpath("//button[.='Buy Now']");
public PaymentPage buyNowProduct(String prodName) 
{
	WebElement confirmItemName=names.stream().filter(a->a.getText().equalsIgnoreCase(prodName)).findFirst().orElse(null);
	confirmItemName.findElement(buynowButton).click();
	PaymentPage payment_page=new PaymentPage(driver);
	return payment_page;
}










}
