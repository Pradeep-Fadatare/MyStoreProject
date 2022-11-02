package PradeepFadatareAutomation.PageObject;

import PradeepFadatareAutomation.AbstaractComponents.Abstractclass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;


public class IndexPage extends Abstractclass {

    public WebDriver driver;

    public IndexPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a.login")
    WebElement signinbtn;
    @FindBy(css = "#search_query_top")
    WebElement searchtxt;
    @FindBy(xpath = "//div[@id='header_logo']/a/img")
    WebElement logoimg;
    @FindBy(name = "submit_search")
    WebElement searchbtn;


    public LoginPage signin() {

        signinbtn.click();
        return new LoginPage(driver);
    }

    public boolean validateLogo() throws IOException {
        screenShotWebElement(logoimg);
        return logoimg.isDisplayed();
    }

    public String getTitle(WebDriver driver) {
        String ttl = driver.getTitle();
        return ttl;
    }

    public SearchResultPage searchProduct(String productName) {
        searchtxt.sendKeys(productName);
        searchbtn.click();
        return new SearchResultPage(driver);
    }

}
