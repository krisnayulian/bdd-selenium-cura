package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"login\"]/div/div/div[2]/form")
    private WebElement loginForm;

    @FindBy(id = "txt-username")
    private WebElement username;

    @FindBy(id = "txt-password")
    private WebElement password;

    @FindBy(id = "btn-login")
    private WebElement loginButton;

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public boolean isLoginFormPresent() {
        return loginForm.isDisplayed();
    }

    public void login(String username, String pass){
        this.username.clear();
        this.username.sendKeys(username);

        this.password.clear();
        this.password.sendKeys(pass);
        loginButton.click();
    }
}
