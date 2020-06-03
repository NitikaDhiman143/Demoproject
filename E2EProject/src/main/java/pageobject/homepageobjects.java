package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resources.driverinitialization;

public class homepageobjects {
	
	
		public WebDriver driver;
		By signin=By.cssSelector("a[href*='sign_in']");
		By title=By.xpath("//div[@class='text-center']//h2");

		public homepageobjects(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver =driver;
		}

	
		
	public  WebElement getlogin ()
	{
		return driver.findElement(signin);
		
	}
	
	public  WebElement gettitle ()
	{
		return driver.findElement(title);
		
	}

}
