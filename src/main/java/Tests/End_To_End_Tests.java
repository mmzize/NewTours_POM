package Tests;

import Pages.Login_Class;
import Pages.Register_Class;
import Setup.Setup_Class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class End_To_End_Tests {

    private WebDriver driver = Setup_Class.startBrowserOfChoice("https://demo.guru99.com/test/newtours/","chrome");
    Register_Class register_class = PageFactory.initElements(driver, Register_Class.class);
    Login_Class login_class =PageFactory.initElements(driver,Login_Class.class);
    @Test
    public void Register_User_Test()
    {
     register_class.Click_Register_link();
     register_class.Enter_Firstname("Mandla");
     register_class.Enter_Lastname("Mzize");
     register_class.Enter_Phone("0761231234");
     register_class.Enter_email("test@test.com");
     register_class.Enter_Address("address");
     register_class.Enter_City("City");
     register_class.Enter_State("Illinois");
     register_class.Enter_PostalCode("1234");
     register_class.Enter_Country("SOUTH AFRICA");
     register_class.Enter_Username("Test");
     register_class.Enter_Password("Test");
     register_class.Enter_ConfirmationPassword("Test");
     register_class.Click_Submit_Button();
     register_class.Verify_Successful_Registration();
    }
    @Test(priority = 1)
    public void Login_Test()
    {
        login_class.Click_SignOn_Link();
        login_class.Enter_Username("Test");
        login_class.Enter_Password("Test");
        login_class.Click_Submit_Button();
        login_class.Verify_Successful_Login();

    }
    @AfterSuite
    public void Quit()
    {
        driver.quit();
    }
}
