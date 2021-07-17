package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	
	
	public WebDriver driver;

	// Object should be defined at the top
	By email = By.xpath("//input[@id='user_email']");
	By pswd = By.xpath("//input[@id='user_password']");
	By sign_in=By.xpath("//input[@value='Log In']");

	// method should be defined at the bottom

	public loginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		//this.variable = driver, that is in the landingPage(WebDriver driver) 
		this.driver = driver; // created a constructor
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getPswd() {

		return driver.findElement(pswd);
	}
	
	public WebElement getSign() {

		return driver.findElement(sign_in);
	}
	
	
	

}
