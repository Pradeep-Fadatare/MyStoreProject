package PradeepFadatareAutomation.PageObject;

import PradeepFadatareAutomation.AbstaractComponents.Abstractclass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends Abstractclass {
    WebDriver driver;
    @FindBy(css = "a.cheque span")
    WebElement payByChkbtn;
    @FindBy(css = ".bankwire span")
    WebElement payByBankWire;

    public PaymentPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public OrdersummaryPage clickOnPaymentMethod() {
        payByBankWire.click();
        return new OrdersummaryPage(driver);
    }
}
