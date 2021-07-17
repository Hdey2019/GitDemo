package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\SERVER\\eclipse-workspace\\e2eProject\\src\\main\\java\\resources\\data.properties");

		// to load the properties file
		prop.load(fis);

		// get value of browser in a string variable
		String browserName = prop.getProperty("browser");
		prop.getProperty("url");
		System.out.println(browserName);

		// decide the browser

		if (browserName.equals("chrome")) {
			// code for chrome
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\SERVER\\eclipse-workspace\\e2eProject\\src\\main\\resources\\driver\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equals("IE")) {
			// code for IE
		}

		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;

	}

	
	public String getScreenShotPath(String testcaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testcaseName+".ping";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		
	}
	
	
	
	
	
}
