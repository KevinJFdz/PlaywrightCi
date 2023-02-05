package steps.login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.dashboard.DashboardPage;
import pages.login.LoginPage;
import pages.orange.LoginOrangePage;
import support.cucumber.CucumberManager;

public class LoginSteps {
    private LoginPage loginPage = new LoginPage();
    private DashboardPage dashboardPage = new DashboardPage();
    private LoginOrangePage loginOrangePage = new LoginOrangePage();

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        loginPage.goToLoginPage();
    }

    @When("the user enter his credentials")
    public void theUserEnterHisCredentials() {
        loginPage.login("standard_user","secret_sauce");
        CucumberManager.attachScreenshotToReport(loginPage.takeScreenshot());
    }

    @Then("the app should display de dashboard section")
    public void theAppShouldDisplayDeDashboardSection() throws InterruptedException {
        dashboardPage.addToCartItemByPosition(3);
        dashboardPage.clickShoppingCartButton();
        CucumberManager.attachScreenshotToReport(dashboardPage.takeScreenshot());
        loginOrangePage.goToOrangeLogin();
        CucumberManager.attachScreenshotToReport(loginOrangePage.takeScreenshot());
        loginOrangePage.closOrangeTab();
        CucumberManager.attachScreenshotToReport(loginOrangePage.takeScreenshot());
    }

    @Then("the app should not display de dashboard section")
    public void theAppShouldNotDisplayDeDashboardSection() {
        Assert.fail("Fallo");
        CucumberManager.attachScreenshotToReport(loginOrangePage.takeScreenshot());
    }
}
