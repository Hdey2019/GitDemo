package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {

	public WebDriver driver;

	// Object should be defined at the top
	By no = By.xpath("//button[text()='NO THANKS']");

	By title = By.xpath("//div[@class='text-center']/h2");

	By signin = By.xpath("//span[text()='Login']");

	By navbar = By.xpath("//ul[@class='nav navbar-nav navbar-right']");

	// method should be defined at the bottom

	public landingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		// this.variable = driver, that is in the landingPage(WebDriver driver)
		this.driver = driver; // created a constructor
	}

	public WebElement nosubscr() {
		return driver.findElement(no);
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}

	public WebElement getLogin() {

		return driver.findElement(signin);
	}

	public WebElement VerifyNavBar() {

		return driver.findElement(navbar);
	}

}
