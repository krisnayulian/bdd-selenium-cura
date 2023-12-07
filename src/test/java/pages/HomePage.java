package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    @FindBy(id = "btn-make-appointment")
    private WebElement makeAppointmentButton;

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getMakeAppointmentButton() {
        return makeAppointmentButton;
    }

    public void openLogin() {
        makeAppointmentButton.click();
    }
}
