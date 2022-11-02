package pradeepfadatareacademy.Tests.MyStoreTests;

import PradeepFadatareAutomation.PageObject.AccountCreationPage;
import PradeepFadatareAutomation.PageObject.HomePage;
import PradeepFadatareAutomation.PageObject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pradeepfadatareacademy.Data.DataProvider;
import pradeepfadatareacademy.Tests.TestComponent.BaseTest1;

public class AccountCreationPageTest extends BaseTest1 {

    @Test(groups = "sanity",dataProvider = "email",dataProviderClass = DataProvider.class)
    public void createAccount(String mail){
        LoginPage loginPage = indexPage.signin();
        AccountCreationPage accountCreationPage=loginPage.createAccount(mail);
        String txt=accountCreationPage.accountcreationtxt();
        Assert.assertEquals(txt,"AUTHENTICATION");

    }
}
