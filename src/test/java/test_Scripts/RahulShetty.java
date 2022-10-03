package test_Scripts;

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
import page_Objects.Cart_Page;
import page_Objects.Confirmation_Page;
import page_Objects.Landing_Page;
import page_Objects.Orders_Page;
import page_Objects.PaymentPage;
import page_Objects.Product_Page;
import test_Components.BaseClass;

public class RahulShetty extends BaseClass 
{
public String itemName;
	
@Test
public void submitOrder() throws InterruptedException
{
Product_Page product_Page=landing_Page.userLogin("Chaip819@gmail.com","Chaip819@gmail.com");
itemName="zara coat 3";
Cart_Page cart_page=product_Page.getTheProduct(itemName);
//cartPage
PaymentPage payment_page=cart_page.buyNowProduct(itemName);
//payment page
String country="india";
Confirmation_Page cnfPage=payment_page.paymentSelected(country);
//confirmtion page
String text=cnfPage.orderConfirmation();
Assert.assertEquals(text, "THANKYOU FOR THE ORDER.");
}


//dependsOnMethods = "submitOrder"
@Test()
public void validationOrder() 
{
Product_Page product_Page=landing_Page.userLogin("Chaip819@gmail.com","Chaip819@gmail.co");
Orders_Page orders_Page=product_Page.ordersPage();
Boolean element=orders_Page.verifyTheOrderedProduct(itemName);
Assert.assertTrue(element);

}
}



