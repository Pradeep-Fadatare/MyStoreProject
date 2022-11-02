package PradeepFadatareAutomation.PageObject;

import PradeepFadatareAutomation.AbstaractComponents.Abstractclass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage extends Abstractclass {
    WebDriver driver;
    public AccountCreationPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "h1.page-heading")
    WebElement createacctxt;

    public String accountcreationtxt(){
        String txt=createacctxt.getText();
        return  txt;
    }
}
