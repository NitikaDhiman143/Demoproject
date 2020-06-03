package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageobject.homepageobjects;
import Resources.driverinitialization;

public class Validiatetext extends driverinitialization{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(driverinitialization.class.getName());
	@Test
	public void validatethetitleonhomepage() throws IOException {
		
		 driver =initializeDriver();
		 driver.get(prop.getProperty("url"));

		homepageobjects m = new homepageobjects(driver);
		Assert.assertEquals(m.gettitle().getText(), "FEATURED COURSES");
	   // Assert.assertTrue(m.gettitle().isDisplayed());   
	    log.error("succesfully browser launch");
	 // to identity the maven for log4j2 file you need to add the path of that file in POM xml
	}
	@AfterTest
	public void Close() throws IOException {
		driver.quit();
			
		
		
	}
	
		
	
		
		//Access method of the class by using two ways
		//by using inheritance
	//by using object of the class	
					
					
			
				    
	}
		
