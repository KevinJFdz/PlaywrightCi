package pages.orange;

import pages.base.BasePage;

public class LoginOrangePage extends BasePage {

    public void goToOrangeLogin(){
        openNewTab("https://opensource-demo.orangehrmlive.com/");
    }

    public void closOrangeTab(){
        switchToPreviousTab();
    }
}
