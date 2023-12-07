package cura;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest {
    WebDriver driver;

    @BeforeTest
    private void init () {
        System.setProperty("webdriver.chrome.driver", "/home/krisna/github/chromedriver-linux64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver (options);
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();

    }
    @Test
    private void checkElement (){
     // check element h1
    Assert.assertEquals(driver.findElement(By.cssSelector("header h1")).getText(), "CURA Healthcare Service");
    Assert.assertEquals(Color.fromString(driver.findElement(By.cssSelector("header h1")).getCssValue("color")).asHex(), "#ffffff");
    // check element h3
        Assert.assertEquals(driver.findElement(By.cssSelector("header h3")).getText(), "We Care About Your Health");
        Assert.assertEquals(Color.fromString(driver.findElement(By.cssSelector("header h3")).getCssValue("color")).asHex(), "#4fb6e7");
        // check button
        Assert.assertEquals(driver.findElement(By.id("btn-make-appointment")).getText(), "Make Appointment");
        Assert.assertEquals(Color.fromString(driver.findElement(By.id("btn-make-appointment")).getCssValue("background-color")).asRgba(), "rgba(115, 112, 181, 0.8)");
        // check toogle menu
        Assert.assertEquals(Color.fromString(driver.findElement(By.id("menu-toggle")).getCssValue("background-color")).asRgba(), "rgba(115, 112, 181, 0.8)");
    }
}
