package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class driverinitialization {

	public  WebDriver driver;
	public Properties prop;
public WebDriver initializeDriver() throws IOException
{
	
prop= new Properties();
// Can give the direct path of the project
//FileInputStream fis=new FileInputStream("C:\\Users\\HP\\Framework\\E2EProject\\src\\main\\java\\resources\\Data.properties");

//2nd way here one java class {System.getProperty("user.dir")} provided the path of the project directly by this so that when we give the 
//project to anyone else then user dont need to modify any thing in  this project it will directly pick the pth of users system
FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\resources\\Data.properties");

prop.load(fis);
//THis is for the Maven Command, no need of property file just pass it into the command 
// mvn test -Dbrowser=chrome
String browserName=System.getProperty("browser");

//THis path get from property file
//String browserName=prop.getProperty("browser");
System.out.println(browserName);

//Run Application in Chrome browser simply
//if(browserName.equals("chrome"))
//{
//	 System.setProperty("webdriver.chrome.driver", "D:\\Selenium Setup\\Browser Drivers\\chromedriver.exe");
//	 driver= new ChromeDriver();	 
//}
//execute in chrome driver
	

//Run chrome browser by opening the browser or by not opening the browser in that case will consider the 
// Headless mode >>> not open the browser with that execution will occur
	
if(browserName.contains("chrome"))
	{
		 System.setProperty("webdriver.chrome.driver", "D:\\Selenium Setup\\Browser Drivers\\chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		if(browserName.contains("headless"))
		{
			options.addArguments("--window-size=1366,768	");
			options.addArguments("--disable-gpu");
			options.addArguments("--disable-extensions");
			options.setExperimentalOption("useAutomationExtension", false);
			options.addArguments("--proxy-server='direct://'");
			options.addArguments("--proxy-bypass-list=*");
			options.addArguments("--start-maximized");
			options.addArguments("--headless");
		}
	 driver= new ChromeDriver(options);	
//// mvn command for this >> 	mvn test -Dbrowser=chromeheadless
}


else if (browserName.equals("firefox"))
{
	 driver= new FirefoxDriver();
	//firefox code
}
else if (browserName.equals("IE"))
{
//	IE code
}

driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
return driver;


}
//Screenshot code pass to listerner class 
public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source =ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	FileUtils.copyFile(source,new File(destinationFile));
	return destinationFile;


}




}
