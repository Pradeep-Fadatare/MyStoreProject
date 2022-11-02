package pradeepfadatareacademy.Tests.MyStoreTests;

import PradeepFadatareAutomation.PageObject.HomePage;
import PradeepFadatareAutomation.PageObject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pradeepfadatareacademy.Tests.TestComponent.BaseTest1;

public class HomePageTest extends BaseTest1 {
    @Test(groups = "smoke")
    public void homePageValidation(){
        LoginPage loginPage = indexPage.signin();
        HomePage homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        boolean result=homePage.validateMywishList();
        Assert.assertTrue(result);
        boolean result1=homePage.orderHistory();
        Assert.assertTrue(result1);
    }
}
