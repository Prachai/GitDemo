package page_Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import abstract_Class.AbstractUtility;

public class Confirmation_Page extends AbstractUtility {
	WebDriver driver;
	public Confirmation_Page(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

@FindBy(css = ".hero-primary")
WebElement confirmationText;
public String orderConfirmation() {
	 String text=confirmationText.getText();
	 return text;
	
}

}
