package PradeepFadatareAutomation.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;
    public HomePage(WebDriver driver) {
        super();
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[normalize-space()='My wishlists']")
    WebElement wishlistlnk;

    @FindBy(xpath = "//span[normalize-space()='Order history and details']")
    WebElement orderhistorylink;


    public boolean validateMywishList() {
        return wishlistlnk.isDisplayed();
    }
    public boolean orderHistory() {
        return orderhistorylink.isDisplayed();
    }

    public String getCurrentUrl(WebDriver driver){
        String url=driver.getCurrentUrl();
        return url;
    }
}
