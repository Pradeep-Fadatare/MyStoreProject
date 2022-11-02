package PradeepFadatareAutomation.PageObject.RahulShetty;

import PradeepFadatareAutomation.AbstaractComponents.Abstractclass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class LandinPage extends Abstractclass {

    public WebDriver driver;
    public LandinPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "userEmail")
    WebElement userEmailtxt;

    @FindBy(id = "userPassword")
    WebElement userPassworttxt;

    @FindBy(id = "login")
    WebElement loginbtn;

    @FindBy(xpath = "//*[@id=\"toast-container\"]")
    WebElement errormsg;



    public ProductCatalog loginaction(String email,String password){
        userEmailtxt.sendKeys(email);
        userPassworttxt.sendKeys(password);
        loginbtn.click();
        ProductCatalog productCatalog=new ProductCatalog(driver);
        return productCatalog;
    }

    public String getmeErrormsg(){

        waitUntillWebElementToAppear(errormsg);
        return errormsg.getText();
    }

    public void goTo() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\PradeepFadatareAutomation\\Resources\\GlobalData.properties");
        Properties prop = new Properties();
        prop.load(fis);
        driver.get(prop.getProperty("url"));
    }
}
