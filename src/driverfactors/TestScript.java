package driverfactors;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import applicationLayer.AdminLoginPage;
import applicationLayer.AdminLogoutPage;
import applicationLayer.EmployeePage;

public class TestScript {
WebDriver driver;
@BeforeTest
public void setUp()
{
 driver = new ChromeDriver();
 driver.manage().window().maximize();
 driver.get("http://orangehrm.qedgetech.com/");
 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 AdminLoginPage Login = PageFactory.initElements(driver, AdminLoginPage.class);
 Login.verifylogin("Admin", "Qedge123!@#");
}
@Test
public void EmpCreation()
{
EmployeePage emp = PageFactory.initElements(driver, EmployeePage.class);
boolean res = emp.verifyaddEmp("Eswar", "Reeddy", "Manual");
System.out.println(res);
	}
@AfterTest
public void tearDown() {
AdminLogoutPage Logout = PageFactory.initElements(driver, AdminLogoutPage.class);
Logout.verifyLogout();
driver.close();
}
}
