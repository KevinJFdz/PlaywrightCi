package steps.base.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.base.BasePage;
import support.cucumber.CucumberManager;
import support.playwright.PlaywrightManager;

public class Hooks {

    private PlaywrightManager playwrightManager;
    @Before()
    public void setUp(Scenario scenario){
        playwrightManager = new PlaywrightManager("chrome", true, true, true);
        BasePage.setPage(playwrightManager.getNewPage());
        CucumberManager.setScenario(scenario);
    }

    @After()
    public void tearDown(){
        playwrightManager.close();
    }
}
