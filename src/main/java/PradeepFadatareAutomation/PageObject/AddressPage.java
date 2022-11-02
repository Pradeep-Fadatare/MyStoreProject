package PradeepFadatareAutomation.PageObject;

import PradeepFadatareAutomation.AbstaractComponents.Abstractclass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressPage extends Abstractclass {

    WebDriver driver;
    public AddressPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button[name='processAddress'] span")
    WebElement proceedTochckOut;

    public ShippingPage clickOnChckOut(){
        proceedTochckOut.click();
        return new ShippingPage(driver);
    }
}
