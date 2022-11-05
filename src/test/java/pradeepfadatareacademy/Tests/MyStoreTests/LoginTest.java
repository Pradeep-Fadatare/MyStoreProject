package pradeepfadatareacademy.Tests.MyStoreTests;

import PradeepFadatareAutomation.PageObject.HomePage;
import PradeepFadatareAutomation.PageObject.LoginPage;
import org.testng.Assert;

import org.testng.annotations.Test;
import pradeepfadatareacademy.Data.DataProvider;
import pradeepfadatareacademy.Tests.TestComponent.BaseTest1;

public class LoginTest extends BaseTest1 {
    @Test(groups = {"smoke","sanity"})
    public void logintoApplication() {
        LoginPage loginPage = indexPage.signin();
        HomePage homePage = loginPage.login("admin@xyz.com", "admin@123");
//        HomePage homePage = loginPage.login("admin1@xyz.com", "admin@123");
        String actualUrl = homePage.getCurrentUrl(driver);
        Assert.assertEquals(actualUrl, "http://automationpractice.com/index.php?controller=my-account");
    }
}
