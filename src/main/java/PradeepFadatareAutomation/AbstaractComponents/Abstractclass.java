package PradeepFadatareAutomation.AbstaractComponents;

import PradeepFadatareAutomation.PageObject.RahulShetty.CartPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Abstractclass {

    public WebDriver driver;
    public WebDriverWait wait;

    @FindBy(xpath = "/html/body/app-root/app-dashboard/app-sidebar/nav/ul/li[4]/button")
    WebElement myCartbtn;
    @FindBy(xpath = "/html/body/app-root/app-dashboard/app-sidebar/nav/ul/li[3]/button")
    WebElement myOrderbtn;

    public Abstractclass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitUntillElementToAppear(By findby) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findby));
    }

    public void waitUntillWebElementToAppear(WebElement ele) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public void waitForElementToDisappear(WebElement ele) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(ele));
    }

    public CartPage goToCart() {
        myCartbtn.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }

    public OrderPage goToMyOrder() {
        myOrderbtn.click();
        OrderPage orderpage = new OrderPage(driver);
        return orderpage;
    }

    public void selectByIndex(WebElement ele, int index) {
        Select select = new Select(ele);
        select.selectByIndex(index);
    }

    public void selectByvalue(WebElement ele, String value) {
        Select select = new Select(ele);
        select.selectByValue(value);
    }

    public void selectByVisibletxt(WebElement ele, String value) {
        Select select = new Select(ele);
        select.selectByVisibleText(value);
    }

    public boolean JSclickelment(WebElement ele) {
        boolean flag = false;
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("argument[0].click;", ele);
            flag = true;
        } catch (Exception e) {
            throw e;
        } finally {
            if (flag) {
                System.out.println("Click action is perfprmed");
            }
        }
        return flag;
    }

    public void MoveToTheElement(WebElement ele) {
        Actions actions = new Actions(driver);
        actions.moveToElement(ele);
    }
    public void screenShotWebElement(WebElement ele) throws IOException {
        File src=ele.getScreenshotAs(OutputType.FILE);
        File file=new File(System.getProperty("user.dir")+"\\logo\\first.png");
        FileUtils.copyFile(src,file);

    }
}
