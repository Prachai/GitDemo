package page_Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstract_Class.AbstractUtility;

public class Landing_Page extends AbstractUtility
{
WebDriver driver;
public Landing_Page(WebDriver driver) 
{
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
@FindBy(id = "userEmail")
WebElement userEmail;
@FindBy(id = "userPassword")
WebElement passWord;
@FindBy(id = "login")
WebElement loginButton;

public Product_Page userLogin(String useremail ,String password) 
{
userEmail.sendKeys(useremail);	
passWord.sendKeys(password);	
loginButton.click();
Product_Page product_Page =new Product_Page(driver);
return product_Page;
}










}
