package commonfunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Reporter;

import config.AppUtiles;

public class FunctionLibrary extends AppUtiles{ 

// method for login
	public static boolean VerifyLogin(String UserName,String PassWord)
	{
		driver.get(config.getProperty("Url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(config.getProperty("objuser"))).sendKeys("UserName");
		driver.findElement(By.xpath(config.getProperty("objpass"))).sendKeys("PassWord");
		driver.findElement(By.xpath(config.getProperty("objLogin"))).click();
		String expected="dashboard";
		String actual = driver.getCurrentUrl();
		if(actual.contains(expected))
		{
		Reporter.log("Login success::"+expected+" "+actual);
		return false;
       }
		else
		{
			// capture error message
			String errormessage = driver.findElement(By.xpath(config.getProperty(""))).getText();
			Reporter.log(errormessage+" "+expected+"   "+actual);
			return false;
		}
       }
       }
