package PradeepFadatareAutomation.PageObject;

import PradeepFadatareAutomation.AbstaractComponents.Abstractclass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Abstractclass {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "email")
    WebElement emailtxt;

    @FindBy(id = "passwd")
    WebElement passwordtxt;

    @FindBy(id = "SubmitLogin")
    WebElement signinbtn;

    @FindBy(id="email_create")
    WebElement emailnewaccouttxt;

    @FindBy(name = "SubmitCreate")
    WebElement createaccountbtn;

    public HomePage login(String username, String password){
        emailtxt.sendKeys(username);
        passwordtxt.sendKeys(password);
        signinbtn.click();
        return new HomePage(driver);

    }
    public AddressPage login1(String username, String password){
        emailtxt.sendKeys(username);
        passwordtxt.sendKeys(password);
        signinbtn.click();
        return new AddressPage(driver);

    }
    public AccountCreationPage createAccount(String newemail){
        emailnewaccouttxt.sendKeys(newemail);
        createaccountbtn.click();
        return new AccountCreationPage(driver);

    }
}
