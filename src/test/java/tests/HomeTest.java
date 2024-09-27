package tests;


	

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

import pageobjectclass.HomePage;

	public class HomeTest {
	    WebDriver driver;
	    HomePage homepage;

	    @BeforeClass
	    public void setup() {
	        // Set the path to your chromedriver executable
	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

	        // Initialize WebDriver
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        // Open the homepage
	        driver.get("https://www.example.com"); // Replace with actual URL

	        // Initialize the Homepage object
	        homepage = new HomePage(driver);
	    }

	    @Test(priority = 1)
	    public void verifyHomepageTitle() {
	        String title = homepage.getTitle();
	        Assert.assertEquals(title, "Expected Title", "Homepage title is incorrect.");
	    }

	    @Test(priority = 2)
	    public void searchTest() {
	        homepage.enterSearchText("Selenium WebDriver");
	        homepage.clickSearchButton();
	        // You can add further verification after search results load
	    }

	    @Test(priority = 3)
	    public void signInTest() {
	        homepage.clickSignIn();
	        // You can add further verification for sign-in process
	    }

	    @AfterClass
	    public void teardown() {
	        driver.quit(); // Close browser after tests are done
	    }
	


}
