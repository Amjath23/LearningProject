package pageobjectclass;



	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class LoginPage {

	    WebDriver driver;

	    // PageFactory annotation for locating elements
	    @FindBy(id = "username")
	    WebElement username;

	    @FindBy(id = "password")
	    WebElement password;

	    @FindBy(id = "loginButton")
	    WebElement loginButton;

	    // Constructor to initialize elements
	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    // Actions for login
	    public void enterUsername(String uname) {
	        username.sendKeys(uname);
	    }

	    public void enterPassword(String pwd) {
	        password.sendKeys(pwd);
	    }

	    public void clickLogin() {
	        loginButton.click();
	    }
	}


