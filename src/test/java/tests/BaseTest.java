package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.AppointmentPage;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver;

    protected WebDriverWait driverWait;

    protected HomePage homePage;

    protected LoginPage loginPage;

    protected AppointmentPage appointmentPage;

    protected final String username = "John Doe";

    protected final String password = "ThisIsNotAPassword";

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "/home/krisna/github/chromedriver-linux64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver (options);
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage = new HomePage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
        appointmentPage = new AppointmentPage(driver, driverWait);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://katalon-demo-cura.herokuapp.com/");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

