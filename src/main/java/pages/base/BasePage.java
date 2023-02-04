package pages.base;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import support.playwright.PlaywrightManager;

import java.util.ArrayList;
import java.util.List;

public class BasePage {
    private static List<Page> pageList = new ArrayList<>();
    private static Page page;
    private static BrowserContext browserContext;


    public static void setBrowserContext(BrowserContext newBrowserContext){
        browserContext = newBrowserContext;
        setPage(browserContext.newPage());
    }
    public static void setPage(Page newPage){
        page = newPage;
    }
    public Page getNewPage(){
        return PlaywrightManager.getNewPage();
    }

    public Page openNewTab(String url){
        pageList.add(page);
        Page newTab = getNewPage();
        setPage(newTab);
        page.navigate(url);
        page.waitForLoadState(LoadState.NETWORKIDLE);
        pageList.add(page);
        return newTab;
    }

    public void switchToPreviousTab(){
        pageList.remove(pageList.size() - 1);
        page.close();
        setPage(pageList.get(pageList.size() - 1));
    }

    public void goTo(String url){
        page.navigate(url);
    }
    protected void click(String elementSelector){
        page.click(elementSelector);
    }

    protected void click(String elementSelector, String elementToClick){
        page.locator(elementSelector).locator(elementToClick).click();
    }

    protected void click(String elementListLocator, int elementPosition, String elementToClick){
        page.locator(elementListLocator).nth(elementPosition).locator(elementToClick).click();
    }

    protected void type(String elementSelector, String textToType){
        page.type(elementSelector, textToType);
    }

    protected void waitUntilPageLoad(){
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }

    protected boolean isVisible(String elementSelector){
        return page.isVisible(elementSelector);
    }

    public byte[] takeScreenshot(){
        return page.screenshot();
    }
}
