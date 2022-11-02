package PradeepFadatareAutomation.PageObject;

import PradeepFadatareAutomation.AbstaractComponents.Abstractclass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage extends Abstractclass {

    WebDriver driver;
    public ShippingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "cgv")
    WebElement checkBtn;

    @FindBy(xpath = "//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
    WebElement chckoutbtn;

    public void clickcheckbtn(){
        checkBtn.click();
    }

    public PaymentPage proceedToCheckOut(){
        waitUntillWebElementToAppear(chckoutbtn);
        chckoutbtn.click();
        return new PaymentPage(driver);
    }
}
