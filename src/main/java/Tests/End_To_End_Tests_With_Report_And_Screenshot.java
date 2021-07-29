package Tests;

import Helpers.Report_Class;
import Helpers.TakeScreenshot;
import Pages.Login_Class;
import Pages.Register_Class;
import Setup.Setup_Class;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

//Extend the report class so you can log the steps on the report
//extends is case sensitive
//extends the Report Class ...class names must match
public class End_To_End_Tests_With_Report_And_Screenshot extends Report_Class{

    private WebDriver driver = Setup_Class.startBrowserOfChoice("https://demo.guru99.com/test/newtours/", "chrome");
    Register_Class register_class = PageFactory.initElements(driver, Register_Class.class);
    Login_Class login_class = PageFactory.initElements(driver, Login_Class.class);
    TakeScreenshot _screenShot=new TakeScreenshot();

    @Test (priority = 1)
    public void Register_User_Test() throws Exception {
        test = extent.createTest("Register Class Tests", "Register New User");
        test.log(Status.PASS, "Click Register Link");
        register_class.Click_Register_link();
        test.log(Status.PASS,"Enter First Name");
        register_class.Enter_Firstname("Mandla");
        test.log(Status.PASS,"Enter Last Name");
        register_class.Enter_Lastname("Mzize");
        test.log(Status.PASS,"Enter Cellphone Number");
        register_class.Enter_Phone("0761231234");
        test.log(Status.PASS,"Enter Email Address");
        register_class.Enter_email("test@test.com");
        test.log(Status.PASS,"Enter Home Address");
        register_class.Enter_Address("address");
        test.log(Status.PASS,"Enter City");
        register_class.Enter_City("City");
        test.log(Status.PASS,"Enter State");
        register_class.Enter_State("Illinois");
        test.log(Status.PASS,"Enter Postal Code");
        register_class.Enter_PostalCode("1234");
        test.log(Status.PASS,"Select Country");
        register_class.Enter_Country("SOUTH AFRICA");
        test.log(Status.PASS,"Enter Username");
        register_class.Enter_Username("Test");
        test.log(Status.PASS,"Enter Password");
        register_class.Enter_Password("Test");
        test.log(Status.PASS,"Confirm Password");
        register_class.Enter_ConfirmationPassword("Test");
        test.log(Status.PASS,"Click Submit Button");
        _screenShot.takeSnapShot(driver,"Register_User_Test_Screenshot");
        register_class.Click_Submit_Button();
        test.log(Status.PASS,"Verify Successful Registration");
        register_class.Verify_Successful_Registration();
    }
//Priority first then Alphabetically
    @Test(priority = 2)
    public void Login_Test() throws Exception {
        test = extent.createTest("Login Class Tests", "Login User");
        test.log(Status.PASS, "Click Sign In Link");
        login_class.Click_SignOn_Link();
        test.log(Status.PASS,"Enter Username");
        login_class.Enter_Username("Test");
        test.log(Status.PASS,"Enter Password");
        login_class.Enter_Password("Test");
        _screenShot.takeSnapShot(driver,"Login_Test_Screenshot");
        test.log(Status.PASS,"Click Submit Button");
        login_class.Click_Submit_Button();
        test.log(Status.PASS,"Verify Successful Login");
        login_class.Verify_Successful_Login();
    }

    @AfterSuite
    public void Quit() {
        driver.quit();
    }
}