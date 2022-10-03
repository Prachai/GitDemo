package page_Objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import abstract_Class.AbstractUtility;

public class PaymentPage extends AbstractUtility {
	WebDriver driver;
	public PaymentPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

@FindBy(xpath = "//input[@placeholder='Select Country']")
WebElement countryTextfield;
@FindBy(xpath = "//section[@class='ta-results list-group ng-star-inserted']//span")
List<WebElement> list;
@FindBy(css = ".action__submit")	
WebElement placeorderButton;
	
public Confirmation_Page paymentSelected(String countryname) {
	countryTextfield.sendKeys(countryname);
	 WebElement countryName=list.stream().filter(a->a.getText().equalsIgnoreCase(countryname)).findFirst().orElse(null);
	 countryName.click();	
	 visibilityOfWebElementLocated(placeorderButton);
	 placeorderButton.click();
	 Confirmation_Page cnfPage=new Confirmation_Page(driver);
	 return cnfPage;
} 	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
