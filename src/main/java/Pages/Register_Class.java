package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Register_Class {

    private WebDriver driver;

    public Register_Class(WebDriver driver)
    {
        this.driver=driver;
    }

    @FindBy(xpath = "//a[contains(.,'REGISTER')]")
    WebElement Register_Link;

    @FindBy(xpath = "//input[contains(@name,'firstName')]")
    WebElement Firstname;

    @FindBy(xpath = "//input[contains(@name,'lastName')]")
    WebElement Lastname;

    @FindBy(xpath = "//input[contains(@name,'phone')]")
    WebElement Phone_number;

    @FindBy(xpath = "//input[contains(@name,'userName')]")
    WebElement Email;

    @FindBy(xpath = "//input[contains(@name,'address1')]")
    WebElement Address;

    @FindBy(xpath = "//input[contains(@name,'city')]")
    WebElement City;

    @FindBy(xpath = "//input[contains(@name,'state')]")
    WebElement State;

    @FindBy(xpath = "//input[contains(@name,'postalCode')]")
    WebElement Postal_Code;

    @FindBy(xpath = "//select[contains(@name,'country')]")
    WebElement Country;

    @FindBy(xpath = "//input[contains(@name,'email')]")
    WebElement Username;

    @FindBy(xpath = "//input[contains(@name,'password')]")
    WebElement Password;

    @FindBy(xpath = "//input[contains(@name,'confirmPassword')]")
    WebElement Confirm_password;

    @FindBy(xpath = "//input[contains(@name,'submit')]")
    WebElement Submit_Button;

    @FindBy(xpath = "//b[contains(.,'Note: Your user name is Test.')]")
    WebElement Welcome_note;



    public void Click_Register_link()
    {
        WebDriverWait register= new WebDriverWait(driver,30);
        register.until(ExpectedConditions.visibilityOf(Register_Link));
        Register_Link.click();
    }

    public void Enter_Firstname(String _firstName)
    {
        WebDriverWait Fn=new WebDriverWait(driver,30);
        Fn.until(ExpectedConditions.visibilityOf(Firstname));
        Firstname.sendKeys(_firstName);
    }

    public void Enter_Lastname(String _lastname)
    {
        Lastname.sendKeys(_lastname);
    }

    public void Enter_Phone(String _phone)
    {
        Phone_number.sendKeys(_phone);
    }

    public void Enter_email(String _email)
    {
        Email.sendKeys(_email);
    }

    public void Enter_Address(String _address)
    {
        Address.sendKeys(_address);
    }

    public void Enter_City(String _city)
    {
        City.sendKeys(_city);
    }

    public void Enter_State(String _state)
    {
        State.sendKeys(_state);
    }

    public void Enter_PostalCode(String _postalcode)
    {
        Postal_Code.sendKeys(_postalcode);
    }

    public void Enter_Country(String _country)
    {
        Select _countryDrp=new Select(Country);
        _countryDrp.selectByVisibleText(_country);
    }

    public void Enter_Username(String _username)
    {
        Username.sendKeys(_username);
    }

    public void Enter_Password(String _password)
    {
        Password.sendKeys(_password);
    }

    public void Enter_ConfirmationPassword(String _confirmPassword)
    {
        Confirm_password.sendKeys(_confirmPassword);
    }

    public void Click_Submit_Button()
    {
        Submit_Button.click();
    }

    public void Verify_Successful_Registration()
    {
        Assert.assertTrue(Welcome_note.isDisplayed());
    }
}
