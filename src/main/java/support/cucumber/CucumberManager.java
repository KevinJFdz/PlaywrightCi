package support.cucumber;

import io.cucumber.java.Scenario;
import pages.base.BasePage;

public class CucumberManager {
    public static void setScenario(Scenario newScenario){
        CucumberReport.setScenario(newScenario);
    }
    public static Scenario getScenario(){
        return CucumberReport.getScenario();
    }

    public static void attachScreenshotToReport(byte[] screenshot){
        CucumberReport.attachScreenshotToReport(screenshot);
    }
    public static void attachScreenshotToReport(byte[] screenshot ,String message){
        CucumberReport.attachScreenshotToReport(screenshot, message);
    }

    public static void attachTextToReport(String name, String text){
        CucumberReport.attachTextToReport(name, text);
    }
    public static void attachJsonToReport(String name, String json){
        CucumberReport.attachJsonToReport(name, json);
    }
}
