package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SummaryPage;
import pages.healthcareProgram;

public class AppointmentTest extends BaseTest {

    private SummaryPage summaryPage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        summaryPage = new SummaryPage(driver, driverWait);
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.openLogin();
        loginPage.login(username, password);
    }

    @Test
    public void appointmentTest() {
        String facility = "Hongkong CURA Healthcare Center";
        boolean applyCheckbox = true;
        healthcareProgram healthcareProgram = pages.healthcareProgram.None;
        String visitDate = "13/02/2023";

        appointmentPage.makeAppointment(facility, applyCheckbox, healthcareProgram, visitDate);
        Assert.assertEquals(summaryPage.getFacility().getText(), facility);
        Assert.assertEquals(summaryPage.getProgram().getText(), healthcareProgram.name());
        Assert.assertEquals(summaryPage.getVisitDate().getText(), visitDate);
        Assert.assertEquals(summaryPage.getReadmission().getText(), "Yes");

    }
}
