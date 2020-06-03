package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Resources.driverinitialization;

public class loginpageobjects {
	public WebDriver driver;


	private By email = By.cssSelector("[id='user_email']");
	private By password = By.cssSelector("[type='password']");


public loginpageobjects(WebDriver driver) 
{
		// TODO Auto-generated constructor stub
this.driver =driver;
}

public WebElement getemail ()
{
	return driver.findElement(email);
	
}

public WebElement getpassword ()
{
	return driver.findElement(password);
	
}

}

