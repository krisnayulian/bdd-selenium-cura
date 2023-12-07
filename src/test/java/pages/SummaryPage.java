package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummaryPage extends BasePage {

    @FindBy(id = "facility")
    private WebElement facility;

    @FindBy(id = "hospital_readmission")
    private WebElement readmission;

    @FindBy(id = "program")
    private WebElement program;

    @FindBy(id = "visit_date")
    private WebElement visitDate;

    public SummaryPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getFacility() {
        return facility;
    }

    public WebElement getReadmission() {
        return readmission;
    }

    public WebElement getProgram() {
        return program;
    }

    public WebElement getVisitDate() {
        return visitDate;
    }
}
