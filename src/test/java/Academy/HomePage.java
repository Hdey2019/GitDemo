package Academy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.landingPage;
import pageObjects.loginPage;
import resources.base;

public class HomePage extends base {
	
	public WebDriver driver;
	
	public static Logger log=LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException, InterruptedException {

		driver = initializeDriver();
		log.info("Driver is initialized");
		

	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String Username, String Password, String text)
			throws IOException, InterruptedException {
		
		//open browser
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		log.info("URL opened");
		// driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Thread.sleep(8000);
		

		// perform action on home page click on login

		landingPage lp = new landingPage(driver);
		lp.nosubscr().click();
		lp.getLogin().click();

		// perform action on login page
		loginPage lgnpg = new loginPage(driver);
		System.out.println(text);
		lgnpg.getEmail().sendKeys(Username);
		lgnpg.getPswd().sendKeys(Password);
		lgnpg.getSign().click();

	}

	@DataProvider
	public Object[][] getData() {
		// row stands for diff test data set e.g. restricted user, non restricted user
		// column stands for how many values per each test

		Object[][] data = new Object[2][3];
		// 0th row
		data[0][0] = "validuser@gmail.com";
		data[0][1] = "validpass";
		data[0][2] = "Valid User";

		// 1st row
		data[1][0] = "invaliduser@gmail.com";
		data[1][1] = "invalidpass";
		data[1][2] = "InValid User";

		return data;

	}

	@AfterTest
	public void teardown() {

		driver.close();
	}

}
