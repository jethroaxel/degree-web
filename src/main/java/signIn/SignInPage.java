package signIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Lazy;

import javax.inject.Inject;

import home.HomePage;

public class SignInPage
{
    private static final By USERNAME_INPUT = By.id("username");
    private static final By CONTINUE = By.cssSelector(".js-spin-content > .ng-binding");
    private static final By PASSWORD_INPUT = By.id("password");

    private final WebDriver driver;

    @Inject
    @Lazy
    HomePage homePage;

    @Inject
    public SignInPage(WebDriver driver)
    {
        this.driver = driver;
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(USERNAME_INPUT));
    }

    public void addEmail(String username)
    {

    }

    public void continueToPassword()
    {
        driver.findElement(CONTINUE).click();

    }

    public HomePage continueToSignIn(By locator)
    {
        driver.findElement(CONTINUE).click();
        return homePage;
    }

    public void enterPassword(String password)
    {

    }
}
