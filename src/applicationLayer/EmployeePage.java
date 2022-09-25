package applicationLayer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class EmployeePage {
WebDriver driver;
// constructor  to override Webdriver method
public EmployeePage(WebDriver driver)
{
	this.driver = driver;
}
// define repository 
@FindBy(id="menu_pim_viewPimModule")
WebElement clickpim;
@FindBy(id="btnAdd")
WebElement addbtn;
@FindBy(name="firstName")
WebElement EnterFname;
@FindBy(name="middleName")
WebElement EnterMname;
@FindBy(name="lastName")
WebElement EnterLname;
@FindBy(id="employeeId")
WebElement beforeEid;
@FindBy(id="btnSave")
WebElement clickbtn;
@FindBy(name="personal[txtEmployeeId]")
WebElement AfterEid;
public boolean verifyaddEmp(String EnterFname, String EnterMname, String EnterLname)
{
 
	Actions ac = new Actions(driver);
	 ac.moveToElement(this.clickpim).click().perform();
	 ac.moveToElement(this.addbtn).click().perform();
	this.EnterFname.sendKeys(EnterFname);
	this.EnterMname.sendKeys(EnterMname);
	this.EnterLname.sendKeys(EnterLname);
	String expectedEid = this.beforeEid.getAttribute("value");
	ac.moveToElement(this.clickbtn).click().perform();
	String ActualEid = this.AfterEid.getAttribute("value");
	if(expectedEid.equals(ActualEid))
	{
		Reporter.log("emp Creation success::"+expectedEid+"  "+ActualEid,true);
		return true;
	}
	else
	{
		Reporter.log("emp Creation success::"+expectedEid+"  "+ActualEid,true);
		return false;
	}
		
		
}
}
