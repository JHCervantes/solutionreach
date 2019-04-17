package com.solutionreach.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by jcervantes on 4/17/19.
 */
public class LoginPage {
    public static final String URL = "/sr/login.jsp";

    @FindBy(id = "okta-signin-username")
    private WebElement usernameInput;

    @FindBy(id = "okta-signin-password")
    private WebElement passwordInput;

    @FindBy(id = "okta-signin-submit")
    private WebElement submitButton;

    @FindBy(className = "okta-form-infobox-error")
    private WebElement resultMessage;

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        this.usernameInput.sendKeys(username);
        this.passwordInput.sendKeys(password);

        WebDriverWait wait = new WebDriverWait(this.driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(this.submitButton));

        this.submitButton.click();
    }

    public String getLoginResult() {
        WebDriverWait wait = new WebDriverWait(this.driver, 3);
        wait.until(ExpectedConditions.visibilityOf(resultMessage));

        return this.resultMessage.getText();
    }
}
