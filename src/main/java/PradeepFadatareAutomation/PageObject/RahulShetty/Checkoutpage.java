package PradeepFadatareAutomation.PageObject.RahulShetty;

import PradeepFadatareAutomation.AbstaractComponents.Abstractclass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkoutpage extends Abstractclass {

    public WebDriver driver;
    public String contryname;

    public Checkoutpage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath ="/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[1]/div/input")
    WebElement contrybtn;
    @FindBy(xpath = "/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[2]/a")
    WebElement placeordrbtn;
    @FindBy(xpath = "/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[1]/div/section/button[2]")
    WebElement selectcontry;

    public void addCountry(String contryname) {
        contrybtn.click();
        contrybtn.sendKeys(contryname);
        waitUntillWebElementToAppear(selectcontry);
        selectcontry.click();
    }
    public ConfirmationPage submitOrder(){
        placeordrbtn.click();
        ConfirmationPage  confirmationPage=new ConfirmationPage(driver);
        return confirmationPage;
    }
}
