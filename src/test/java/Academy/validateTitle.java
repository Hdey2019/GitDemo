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

public class validateTitle extends base {
	
	public WebDriver driver;
	
	public static Logger log=LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException, InterruptedException {

		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		log.info("URL loaded");
		// driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Thread.sleep(10000);

	}

	@Test
	public void verifyTitle() throws IOException, InterruptedException {

		// opening the page
		landingPage lp = new landingPage(driver);
		// clicking on no thanks
		lp.nosubscr().click();

		System.out.println(lp.getTitle().getText());

		// verifying the string
		// Assert.assertEquals(string actual, string expected)
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES");
		
		log.info("Succesfully validated the text");

	}

	@AfterTest
	public void teardown() {

		driver.close();
	}

}
