package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Login_Class {

    //we are creating an instance of a driver with type Webdriver
    private WebDriver driver;

    //Constructor to pass driver information to another class
    public Login_Class(WebDriver driver){
        this.driver=driver;
    }

    //Locating all the elements we need on the login page

    @FindBy(xpath = "//a[@href='login.php'][contains(.,'SIGN-ON')]")
    WebElement Sign_In_Link;

    @FindBy(xpath = "//a[@href='login.php'][contains(.,'sign-in')]")
    WebElement SignOn_Link;

    @FindBy(xpath = "//input[contains(@name,'userName')]")
    WebElement Username;

    @FindBy(xpath = "//input[contains(@name,'password')]")
    WebElement Password;

    @FindBy(xpath = "//input[contains(@name,'submit')]")
    WebElement Submit_Button;

    @FindBy(xpath = "//h3[contains(.,'Login Successfully')]")
    WebElement Login_Message;


    //Creating Login method

    public void Click_SignOn_Link()
    {

        WebDriverWait sign=new WebDriverWait(driver,30);
        sign.until(ExpectedConditions.visibilityOf(SignOn_Link));

        SignOn_Link.click();
    }

    //Clicking the Sign In Link
    public void Click_Sign_In_Link()
    {

        WebDriverWait sign=new WebDriverWait(driver,30);
        sign.until(ExpectedConditions.visibilityOf(Sign_In_Link));

        Sign_In_Link.click();
    }


    //Creating Username method
    public void  Enter_Username(String _username)
    {
        WebDriverWait username=new WebDriverWait(driver,30);
        username.until(ExpectedConditions.visibilityOf(Username));

        Username.sendKeys(_username );
    }

    //Creating a Password method
    public void Enter_Password(String _password)
    {
        Password.sendKeys(_password);
    }

    //Creating a Submit method
    public void Click_Submit_Button()
    {
        Submit_Button.click();
    }

    //Creating a verification message method that the user is logged in successfully

    public void Verify_Successful_Login()
    {
        WebDriverWait welcome=new WebDriverWait(driver,30);
        welcome.until(ExpectedConditions.visibilityOf(Login_Message));

        //Assert/Verify that the message is displayed
        Assert.assertTrue(Login_Message.isDisplayed());
    }
}
