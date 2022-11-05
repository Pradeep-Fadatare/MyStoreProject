package pradeepfadatareacademy.Tests.TestComponent;

import PradeepFadatareAutomation.PageObject.IndexPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest1 {

    public WebDriver driver;
    public IndexPage indexPage;
    public Properties prop;

//    @Parameters("BrowserName")
    public WebDriver initialiseDriver() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\PradeepFadatareAutomation\\Resources\\GlobalData.properties");
        prop = new Properties();
        prop.load(fis);
        String BrowserName = prop.getProperty("browser");
        if (BrowserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (BrowserName.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (BrowserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            System.out.println("Browser Not Available");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

//    @Parameters("BrowserName")
    @BeforeMethod(alwaysRun = true)
    public IndexPage launchApplication() throws IOException {
        driver = initialiseDriver();
        driver.get(prop.getProperty("url"));
        indexPage=new IndexPage(driver);
        return indexPage;
    }



    public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown()
    {
        driver.quit();
    }
}
