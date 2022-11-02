package PradeepFadatareAutomation.PageObject;

import PradeepFadatareAutomation.AbstaractComponents.Abstractclass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage extends Abstractclass {

    WebDriver driver;

    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//p/strong[contais(text(),'Your order on My Store is completed')]")
    WebElement cnfrmmsg;

    public String confirmmsgofproduct(){
        String msg=cnfrmmsg.getText();
        return msg;
    }
}
