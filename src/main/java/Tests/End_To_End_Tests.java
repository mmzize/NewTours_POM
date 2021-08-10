package Tests;

import Helpers.Report_Class;
import Helpers.TakeScreenshot;
import Pages.Login_Class;
import Pages.Register_Class;
import Setup.Setup_Class;
import com.aventstack.extentreports.Status;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

//Extend the report class so you can log the steps on the report
//extends is case sensitive
//extends the Report Class ...class names must match
public class End_To_End_Tests extends Report_Class{

    private WebDriver driver = Setup_Class.startBrowserOfChoice("https://demo.guru99.com/test/newtours/", "chrome");
    Register_Class register_class = PageFactory.initElements(driver, Register_Class.class);
    Login_Class login_class = PageFactory.initElements(driver, Login_Class.class);
    TakeScreenshot _screenShot=new TakeScreenshot();
    ////READ DATA FROM EXCEL///////
    private static final String excel =".//src//main//java//Test_Data//Test_Data.xlsx";
    FileInputStream fis = new FileInputStream(excel);
    XSSFWorkbook workbook = new XSSFWorkbook(fis);
    XSSFSheet Login_Test_Data = workbook.getSheetAt(0);
    XSSFSheet Register_Test_Data=workbook.getSheetAt(1);

    String Username = Login_Test_Data.getRow(1).getCell(0).getStringCellValue();
    String Password = Login_Test_Data.getRow(1).getCell(1).getStringCellValue();

    String First_Name=Register_Test_Data.getRow(1).getCell(0).getStringCellValue();
    String Last_Name=Register_Test_Data.getRow(1).getCell(1).getStringCellValue();
    String Phone=Register_Test_Data.getRow(1).getCell(2).getStringCellValue();
    String Email=Register_Test_Data.getRow(1).getCell(3).getStringCellValue();
    String Address=Register_Test_Data.getRow(1).getCell(4).getStringCellValue();
    String City=Register_Test_Data.getRow(1).getCell(5).getStringCellValue();
    String State=Register_Test_Data.getRow(1).getCell(6).getStringCellValue();
    String Postal_Code=Register_Test_Data.getRow(1).getCell(7).getStringCellValue();
    String Country=Register_Test_Data.getRow(1).getCell(8).getStringCellValue();
    String Username_Register=Register_Test_Data.getRow(1).getCell(9).getStringCellValue();
    String Password_Register=Register_Test_Data.getRow(1).getCell(10).getStringCellValue();



    public End_To_End_Tests() throws IOException {
    }
    //////

    @Test (priority = 1)
    public void Register_User_Test() throws Exception {
        test = extent.createTest("Register Class Tests", "Register New User");
        test.log(Status.PASS, "Click Register Link");
        register_class.Click_Register_link();
        test.log(Status.PASS,"Enter First Name");
        register_class.Enter_Firstname(First_Name);
        test.log(Status.PASS,"Enter Last Name");
        register_class.Enter_Lastname(Last_Name);
        test.log(Status.PASS,"Enter Cellphone Number");
        register_class.Enter_Phone(Phone);
        test.log(Status.PASS,"Enter Email Address");
        register_class.Enter_email(Email);
        test.log(Status.PASS,"Enter Home Address");
        register_class.Enter_Address(Address);
        test.log(Status.PASS,"Enter City");
        register_class.Enter_City(City);
        test.log(Status.PASS,"Enter State");
        register_class.Enter_State(State);
        test.log(Status.PASS,"Enter Postal Code");
        register_class.Enter_PostalCode(Postal_Code);
        test.log(Status.PASS,"Select Country");
        register_class.Enter_Country(Country);
        test.log(Status.PASS,"Enter Username");
        register_class.Enter_Username(Username_Register);
        test.log(Status.PASS,"Enter Password");
        register_class.Enter_Password(Password_Register);
        test.log(Status.PASS,"Confirm Password");
        register_class.Enter_ConfirmationPassword(Password_Register);
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
        login_class.Enter_Username(Username);
        test.log(Status.PASS,"Enter Password");
        login_class.Enter_Password(Password);

        _screenShot.takeSnapShot(driver,"Login_Tests_Screenshot");

        test.log(Status.PASS,"Click Submit Button");
        login_class.Click_Submit_Button();
        test.log(Status.PASS,"Verify Successful Login");
        login_class.Verify_Successful_Login();

        _screenShot.takeSnapShot(driver,"Verify Login Screenshot");


    }
    @Test(priority = 3)
    public void Login_Test_Two() throws Exception {
        test = extent.createTest("Login Class Tests", "Login User");
        test.log(Status.PASS, "Click Sign In Link");
        login_class.Click_SignOn_Link();
        test.log(Status.PASS,"Enter Username");
        login_class.Enter_Username(Username);
        test.log(Status.PASS,"Enter Password");
        login_class.Enter_Password(Password);

        _screenShot.takeSnapShot(driver,"Login_Tests_Screenshot");

        test.log(Status.PASS,"Click Submit Button");
        login_class.Click_Submit_Button();
        test.log(Status.PASS,"Verify Successful Login");
        login_class.Verify_Successful_Login();

        _screenShot.takeSnapShot(driver,"Verify Login Screenshot");


    }

    @AfterSuite
    public void Quit() {
        driver.quit();
    }
}