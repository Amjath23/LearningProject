package pageobjectclass;



	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;

	public class HomePage {
	    WebDriver driver;

	    // Define locators
	    By searchBox = By.name("q"); // Assuming you have a search box with name 'q'
	    By searchButton = By.name("btnK"); // Assuming the search button has the name 'btnK'
	    By signInButton = By.id("signin"); // Assuming there's a sign-in button with id 'signin'

	    // Constructor
	    public HomePage(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Actions on the page
	    public void enterSearchText(String searchText) {
	        driver.findElement(searchBox).sendKeys(searchText);
	    }

	    public void clickSearchButton() {
	        driver.findElement(searchButton).click();
	    }

	    public void clickSignIn() {
	        driver.findElement(signInButton).click();
	    }

	    public String getTitle() {
	        return driver.getTitle();
	    }
	}



