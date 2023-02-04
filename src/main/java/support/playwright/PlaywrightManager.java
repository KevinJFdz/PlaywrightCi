package support.playwright;

import com.microsoft.playwright.*;

public class PlaywrightManager {
    private static String browserName;
    private static boolean isRecorded;
    private static boolean traced;
    private static boolean isHeadless;


    public PlaywrightManager(String browser, boolean record, boolean trace,boolean headless) {
        browserName = browser;
        isRecorded = record;
        traced = trace;
        isHeadless = headless;
    }

    public static Page getNewPage() {
        return BrowserFactory.getNewPage(browserName, isRecorded, traced,isHeadless);
    }

    public static void close() {
        BrowserFactory.close();
    }
}
