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
public class Test_Data_Tests{

    private WebDriver driver = Setup_Class.startBrowserOfChoice("https://demo.guru99.com/test/newtours/", "chrome");
    Register_Class register_class = PageFactory.initElements(driver, Register_Class.class);
    Login_Class login_class = PageFactory.initElements(driver, Login_Class.class);
    ////
/*
    private static final String excel =".//src//main//java//TestData//TestData.xlsx";
    FileInputStream fis = new FileInputStream(excel);
    XSSFWorkbook workbook = new XSSFWorkbook(fis);
    XSSFSheet sheet = workbook.getSheetAt(0);

    String Username=sheet.getRow(1).getCell(1).getStringCellValue();
*/

    public Test_Data_Tests() throws IOException {
    }
    @Test()
    public void Login_Test() {
        login_class.Click_Sign_In_Link();

        login_class.Enter_Username("Test");

        login_class.Enter_Password("Test");

        login_class.Click_Submit_Button();

        login_class.Verify_Successful_Login();
    }

    @AfterSuite
    public void Quit() {
        driver.quit();
    }
}