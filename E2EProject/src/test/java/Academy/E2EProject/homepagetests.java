package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
	
import pageobject.homepageobjects;
import pageobject.loginpageobjects;
import Resources.driverinitialization;

public class homepagetests extends driverinitialization
{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(driverinitialization.class.getName());

	@BeforeTest
	public void launchbrowser() throws IOException {
		
		 driver =initializeDriver();
		 driver.get(prop.getProperty("url"));
        
		homepageobjects hm = new homepageobjects(driver);
					hm.getlogin().click();
					log.error("succesfully login"); 
	}
	
		
	@Test(dataProvider="getData")
	public void loginsuccessfully(String uname , String pass) throws IOException
	{
	
		
		//Access method of the class by using two ways
		//by using inheritance
	//by using object of the class	
					
					loginpageobjects ln = new loginpageobjects(driver);
			        ln.getemail().clear();
					ln.getemail().sendKeys(uname);
					 ln.getpassword().clear();
					ln.getpassword().sendKeys(pass);
					System.out.println("Now the output is redirected!");
					
					}
				    @DataProvider
				    public Object[][] getData(){
				    	
				    	Object[][] data = new Object[2][2];
				    	
				    	data[0][0] = "nitikadiman@trantorinc.com";
				    	data[0][1] = "retrt";
				    	
				    	data[1][0] = "nitikadiman";
				    	data[1][1] = "trrtrt";
				    	log.error("succesfully login launch");   
				    	return data;
				    		
				    	
				    }
				    
				    
				    @AfterTest
					public void Closedriver() throws IOException {
						driver.quit();
						log.info("close browser");
					}
					
				    
	}
		
