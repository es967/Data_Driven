package config;

import java.io.FileInputStream;


import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AppUtiles {
public static WebDriver driver;
public static Properties config;
@BeforeTest
public static void setUp() throws Throwable, Throwable
{
config = new Properties();
config.load(new FileInputStream("C:\\Users\\Eswar Reddy\\eclipse-workspace\\DDT_Framework\\ProperteyFile\\Environment.Properties"));
if(config.getProperty("Browser").equalsIgnoreCase("Chrome"));
{
driver = new ChromeDriver();
driver.manage().window().maximize();
}
}
@AfterTest
public static void tearDown(){
	driver.close();
}

}


	