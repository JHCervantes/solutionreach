package com.solutionreach;

import com.solutionreach.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {
    private WebDriver driver;
    private String baseUrl = "https://www.smilereminder.com/";

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/test/java/resources/geckodriver");
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser not supported, please use 'chrome' or 'firefox'");
        }
    }

    @Test
    public void login() {
        driver.get(baseUrl + LoginPage.URL);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("test", "thiswillfail");

        Assert.assertEquals(loginPage.getLoginResult(), "Sign in failed!");
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }
}