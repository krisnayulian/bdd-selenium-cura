package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.openLogin();
    }

    @Test
    public void loginFormPresentedTest() {
        Assert.assertTrue(loginPage.isLoginFormPresent());
    }

    @Test(dependsOnMethods = "loginFormPresentedTest")
    public void loginTest() {
        loginPage.login(username, password);
        Assert.assertTrue(driver.getCurrentUrl().contains("#appointment"));
        Assert.assertTrue(appointmentPage.isAppointmentFormPresent());

    }
}
