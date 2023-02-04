package support.playwright;

import com.microsoft.playwright.*;

import java.nio.file.Path;

public class PlaywrightMedia {
    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext browserContext;
    private static Page page;
    private static String browserName;
    private static boolean headless;

//    public static void setUpBrowser(String browserName) {
//        playwright = Playwright.create();
//        switch (browserName) {
//            case "chromium":
//                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//                break;
//            case "firefox":
//                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//                break;
//            case "safari":
//                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//                break;
//            case "chrome":
//                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
//                break;
//            default:
//                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//                break;
//        }
//        browserContext = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("target/")));
//    }

    public static BrowserContext getBrowserContext() {
        return browserContext;
    }

    public static Page getNewPage() {
        page = browserContext.newPage();
        return page;
    }

    public static void startTrace() {
        browserContext.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true));
    }

    public static void stopTrace() {
        browserContext.tracing().stop(new Tracing.StopOptions()
                .setPath(Path.of("target/trace.zip")));
    }

}
