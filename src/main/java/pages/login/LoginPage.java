package pages.login;

import pages.base.BasePage;

public class LoginPage extends BasePage {
    private String userInput = "#user-name";
    private String passwordInput = "#password";
    private String loginButton = "#login-button";

    public void goToLoginPage() {
        goTo("https://www.saucedemo.com/");
    }

    public void enterUser(String userName) {
        type(userInput, userName);
    }

    public void enterPassword(String password) {
        type(passwordInput, password);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public void login(String userName, String password) {
        enterUser(userName);
        enterPassword(password);
        clickLoginButton();
        waitUntilPageLoad();
    }
}
