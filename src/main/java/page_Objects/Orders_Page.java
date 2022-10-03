package page_Objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstract_Class.AbstractUtility;

public class Orders_Page extends AbstractUtility
{
	WebDriver driver;
	public Orders_Page(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

@FindBy(xpath ="//tr[@class='ng-star-inserted']/td[2]" )	
List<WebElement> lists;

public boolean verifyTheOrderedProduct(String itemName) 
{
	boolean element = lists.stream().anyMatch(a->a.getText().equalsIgnoreCase(itemName));
return element;	
}

	
}
