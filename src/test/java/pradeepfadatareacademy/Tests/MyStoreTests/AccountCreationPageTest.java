package pradeepfadatareacademy.Tests.MyStoreTests;

import PradeepFadatareAutomation.PageObject.AccountCreationPage;
import PradeepFadatareAutomation.PageObject.HomePage;
import PradeepFadatareAutomation.PageObject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pradeepfadatareacademy.Data.DataProvider;
import pradeepfadatareacademy.Tests.TestComponent.BaseTest1;

public class AccountCreationPageTest extends BaseTest1 {

    @Test(groups = "sanity")
    public void createAccount(){
        LoginPage loginPage = indexPage.signin();
        AccountCreationPage accountCreationPage=loginPage.createAccount("padyafadatare@gmail.com");
        String txt=accountCreationPage.accountcreationtxt();
        Assert.assertEquals(txt,"AUTHENTICATION");

    }
}
