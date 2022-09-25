package applicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginPage {
// define Repository page events
	@FindBy(name="txtUsername")
	WebElement objUser;
	@FindBy(id="txtPassword")
	WebElement objpass;
	@FindBy(id="btnLogin")
	WebElement objlogin;
	// write a method
	public void verifylogin(String user, String pass)
	{
		objUser.sendKeys(user);
		objpass.sendKeys(pass);
		objlogin.submit();
			
		}
	}

	

