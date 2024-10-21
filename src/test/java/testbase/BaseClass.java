package testbase;

import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Properties;
import java.util.Date;
import java.io.File;

import java.io.FileReader;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.apache.logging.log4j.LogManager;//log4j2
import org.apache.logging.log4j.Logger;//log4j2
import org.openqa.selenium.TakesScreenshot;

public class BaseClass 
{
public static WebDriver driver;
public Logger logger;
public Properties p;
	@BeforeClass(groups= {"Regression", "Sanity", "Master"})
	@Parameters({"OS", "browser"})
    public void setup(String os, String br) throws IOException
	{
		logger=LogManager.getLogger(this.getClass());//log4j2
		
		FileReader file=new FileReader(".//src//test/resources//configs");
		p=new Properties();
		p.load(file);
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
		DesiredCapabilities capabilities=new DesiredCapabilities();
		
		if(os.equalsIgnoreCase("MAC"))
		{
			capabilities.setPlatform(Platform.MAC);
		}
		else if(os.equalsIgnoreCase("Windows"))
		{
			capabilities.setPlatform(Platform.WIN11);
		}
		else
		{
			System.out.println("No matching os");
			return;
		}
		//browser
		switch(br.toLowerCase())
		{
		case "chrome": capabilities.setBrowserName("chrome"); break;
		case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
		case "firefox": capabilities.setBrowserName("firefox"); break;
		default: System.out.println("No matching browser"); return;
		}
		
		driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
	}
		
		
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(br.toLowerCase())
			{
			case "firefox": driver=new FirefoxDriver();break;
			case "chrome": driver=new ChromeDriver();break;
			default : System.out.println("Invalid browser"); return;

			}
		}
		
		
		
		driver.get(p.getProperty("appURL2")); // reading URL from properties file
		driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
	
	}
	
	@AfterClass(groups= {"Regression", "Sanity", "Master"})
	public void teardown() throws InterruptedException
	{
		Thread.sleep(4000);
		driver.quit();
	}
	//generating random values for first time register or sign-up
	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(7);
		return generatedString;
	}
	public String randomNumbers()
	{
		String generatedNumber=RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	public String randomAlphnumeric()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(7);
		String generatedNumber=RandomStringUtils.randomNumeric(10);
		return (generatedString+"@"+generatedNumber);
	}
	//taking screenshot method for failed testcases
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath = System.getProperty("user.dir") + File.separator + "screenshots" 
                + File.separator + tname + "_" + timeStamp + ".png";
File targetFile = new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}

}
