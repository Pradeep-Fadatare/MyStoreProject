package PradeepFadatareAutomation.PageObject;

import PradeepFadatareAutomation.AbstaractComponents.Abstractclass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersummaryPage extends Abstractclass {
    WebDriver driver;
    public OrdersummaryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[text()='I confirm my order']")
    WebElement confrmordrbtn;

    public OrderConfirmationPage clickorderconfirm(){
        confrmordrbtn.click();
        return new OrderConfirmationPage(driver);
    }
}
