package tests;


import base.IOSBaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends IOSBaseTest {
    LoginPage loginPage;

    @Test(priority = 2, dataProvider = "validLoginData")
    public void userCanLoginSuccessfully(String email, String pass, String code) {
        loginPage = new LoginPage(driver);
        loginPage.login(email, pass, code);
    }

    @Test(priority = 1, dataProvider = "invalidLoginData")
    public void userCannotLoginWithInvalidCredentials(String email, String pass, String code) {
        loginPage = new LoginPage(driver);
        loginPage.login(email, pass, code);
    }


    // ---------- DATA PROVIDERS ----------

    @DataProvider
    public Object[][] validLoginData() {
        return new Object[][]{
                {"samymahmoud@gmail.com", "Samy2020@2", "4"}
        };
    }

    @DataProvider
    public Object[][] invalidLoginData() {
        return new Object[][]{
                {"samymamoud@gmail.com", "wrongPass", "4"},
        };
    }
}




