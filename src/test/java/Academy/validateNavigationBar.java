package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.landingPage;
import resources.base;

public class validateNavigationBar extends base {
	
	public WebDriver driver;
	
	public static Logger log=LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException, InterruptedException {

		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		log.info("URL loaded");
		// driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Thread.sleep(8000);

	}

	@Test
	public void verifyTitle() throws IOException, InterruptedException {

		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		// driver.get("http://www.qaclickacademy.com/");
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Thread.sleep(7000);

		// opening the page
		landingPage lp = new landingPage(driver);
		// clicking on no thanks
		lp.nosubscr().click();

		// verifying the navbar
		Assert.assertTrue(lp.VerifyNavBar().isDisplayed(), "Navigation Bar Present");
		
		log.info("Navigation bar validated");

	}

	@AfterTest
	public void teardown() {

		driver.close();
	}

}
