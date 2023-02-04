package support.playwright;

import com.microsoft.playwright.*;

import java.nio.file.Path;
import java.nio.file.Paths;

public class BrowserFactory {
    private static Playwright playwright;
    private static BrowserContext browserContext;

    public static Page getNewPage(String browserName, boolean enableRecording, boolean enableTracing, boolean headless) {
        playwright = Playwright.create();
        Browser browser;
        switch (browserName) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;
            case "firefox":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;
            case "safari":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(headless));
                break;
            default:
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;
        }

        browserContext = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(enableRecording ? Paths.get("target/") : null));

        if (enableTracing) {
            startTrace(browserContext);
        }

        return browserContext.newPage();
    }

    public static void close() {
        playwright.close();
    }

    public static void startTrace(BrowserContext browserContext) {
        browserContext.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true));
    }

    public static void stopTrace() {
        browserContext.tracing().stop(new Tracing.StopOptions()
                .setPath(Path.of("target/trace.zip")));
    }
}
