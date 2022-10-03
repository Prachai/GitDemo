package test_Components;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import page_Objects.Landing_Page;

public class BaseClass_WithHead_AND_HeadLess 
{
public WebDriver driver;
public String url;
public Landing_Page landing_Page;
public WebDriver initilizeDriver() throws IOException 
{
Properties properties=new  Properties();
FileInputStream  stream=new FileInputStream("D:\\TESTING\\SELENIUM+ ECLIPSE\\cucumber_\\0_Hybdrid_Framework_Practise_WorkingCode\\src\\main\\java\\resources\\global.properties");
properties.load(stream);	
url=properties.getProperty("url");

/* Step 1
String browserName=properties.getProperty("browser");

i will mention browser name from maven command
if i dont give its null then it fetches as usual global.properties
*///Step 2
String browserName=System.getProperty("browser")!=null ? System.getProperty("browser") : properties.getProperty("browser");


/*  HEAD-----browser pop up will happen
 if(browserName.equals("chrome")) 
{
	
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
} 
 */

if(browserName.equals("chrome")) 
{
// HEADLESS ----browser popup will not happen	
	ChromeOptions options=new ChromeOptions();
	WebDriverManager.chromedriver().setup();
	if(browserName.contains("headless")) 
	{
		options.addArguments("headless");
	}
	driver=new ChromeDriver(options);
	//optional if inspect doesnt work use this
	driver.manage().window().setSize(new Dimension(1440, 900));
}
else if(browserName.equals("firefox")) 
{
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
}
if(browserName.equals("edge")) 
{
	WebDriverManager.edgedriver().setup();
	driver=new EdgeDriver();
}
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
return driver;
}	

public String takeScreenshot(String testcaseName,WebDriver driver) throws IOException 
{
TakesScreenshot screenshot=(TakesScreenshot)driver;
File src=screenshot.getScreenshotAs(OutputType.FILE);
String path=System.getProperty("user.dir")+"//reports//"+testcaseName+".png";
File dst=new File(path);
FileUtils.copyFile(src, dst);
return path;
}



@BeforeMethod
public Landing_Page loginApplication() throws IOException 
{
	driver=initilizeDriver();
	driver.get(url);
	landing_Page=new Landing_Page(driver);
	return landing_Page;
}

@AfterMethod
public void closeApplication()
{
driver.close();	
}
}
