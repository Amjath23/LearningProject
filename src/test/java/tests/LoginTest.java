package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pageobjectclass.LoginPage;
	import Utilities.ExcelUtil;
	import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

	import java.io.IOException;

	public class LoginTest {

	    WebDriver driver;
	    LoginPage loginPage;
	    ExcelUtil excelUtil;
	    Logger log;
	
	    ExtentReports extent;
	    ExtentTest test;

	    @BeforeClass
	    public void setup() throws IOException {
	    ExtentSparkReporter	 htmlReporter = new  ExtentSparkReporter("extentReport.html");
	         htmlReporter.config().setTheme(Theme.DARK);
	         extent = new ExtentReports();
	         extent.attachReporter(htmlReporter);
	         test = extent.createTest("Login Test");
	        log = LogManager.getLogger(LoginTest.class);
	        log.info("Setting up the driver and initializing the page.");
	        
	        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Drivers\\chromedriver-win64\\chromedriver.exe");
	        driver = new ChromeDriver();
	        loginPage = new LoginPage(driver);
	        excelUtil = new ExcelUtil("path/to/testdata.xlsx");
	        
	        driver.get("https://practicetestautomation.com/practice-test-login/");
	    }

	    @DataProvider(name = "LoginData")
	    public Object[][] getLoginData() throws IOException {
	        int rowCount = excelUtil.getRowCount("Sheet1");
	        int colCount = excelUtil.getColumnCount("Sheet1");

	        Object[][] data = new Object[rowCount][colCount];

	        for (int i = 1; i <= rowCount; i++) {
	            data[i - 1][0] = excelUtil.getCellData("Sheet1", i, 0);
	            data[i - 1][1] = excelUtil.getCellData("Sheet1", i, 1);
	        }
	        return data;
	    }

	    @Test(dataProvider = "LoginData")
	    public void loginTest(String username, String password) {
	        log.info("Starting login test with username: " + username);
	        
	        loginPage.enterUsername(username);
	        loginPage.enterPassword(password);
	        loginPage.clickLogin();

	        // Assuming successful login navigates to a homepage with "Home" title
	        String expectedTitle = "Home";
	        String actualTitle = driver.getTitle();
	        Assert.assertEquals(actualTitle, expectedTitle, "Login failed!");
	        
	        log.info("Login test passed for username: " + username);
	    }

	    @AfterClass
	    public void tearDown() throws IOException {
	        log.info("Test completed, closing browser and Excel.");
	        driver.quit();
	        excelUtil.close();
	    }
	}



