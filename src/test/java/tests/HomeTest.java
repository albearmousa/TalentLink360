package tests;

import base.IOSBaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class HomeTest extends IOSBaseTest {

    HomePage homePage;

    @BeforeMethod
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        homePage = loginPage.login(
                "samymahmoud@gmail.com", "Samy2020@2", "4"
        );
    }

    @Test
    public void test_home_screen() throws InterruptedException {
        assertTrue(homePage.isHomeDisplayed());
        homePage.setCheck_in();
        homePage.allowLocationOnceIfPresent();
        homePage.setCheck_in_msg();
        homePage.setCheck_out();
        homePage.setCheck_in_msg();
        homePage.setAnnualLeaveBalance();
    }
}

