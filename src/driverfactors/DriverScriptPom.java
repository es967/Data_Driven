package driverfactors;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import applicationLayer.AdminLoginPage;
import applicationLayer.AdminLogoutPage;
import applicationLayer.EmployeePage;
import utilities.ExcelFileUtil;

public class DriverScriptPom {
WebDriver driver;
String inputpath ="C:\\Users\\Eswar Reddy\\eclipse-workspace\\DDT_Framework\\TsetInput\\EmpCreation.xlsx";
String outputpath ="C:\\Users\\Eswar Reddy\\eclipse-workspace\\DDT_Framework\\TestOutput\\Resutls.xlsx";
@BeforeTest
public void setUp()
{
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://orangehrm.qedgetech.com/");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	AdminLoginPage login = PageFactory.initElements(driver, AdminLoginPage.class);
	login.verifylogin("Admin", "Qedge123!@#");
}
public  void starttest () throws Throwable
{
	ExcelFileUtil xl = new ExcelFileUtil(inputpath);
	int rc = xl.rowCount("Employee");
	for(int i=1;i<=rc;i++)
	{
	String para1 = xl.getcellData("Employee", i, 0);
	String para2 = xl.getcellData("Employee", i, 1);
	String para3 = xl.getcellData("Employee", i, 2);
	
	EmployeePage emp = new PageFactory().initElements(driver, EmployeePage.class);
	boolean res = emp.verifyaddEmp(para1, para2, para3);
	if(res)
	{
		xl.setCelldata("Employee", i, 3, "pass", outputpath);
	}
	else
	{
		xl.setCelldata("Employee", i, 3, "fail", outputpath);
		
	}
}
}
@AfterTest
public void tearDowm()
{
	AdminLogoutPage logut= PageFactory.initElements(driver, AdminLogoutPage.class);
logut.verifyLogout();
	driver.close();
}
}