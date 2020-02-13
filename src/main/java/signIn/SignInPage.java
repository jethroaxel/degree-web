package signIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

import home.HomePage;
import user.UserCredentials;

@Component
@Lazy
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

    private void addEmail(String username)
    {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
    }

    private void continueToPassword()
    {
        driver.findElement(CONTINUE).click();
    }

    private HomePage continueToSignIn(String password)
    {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_INPUT))
                .sendKeys(password);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(CONTINUE)).click().perform();

        return homePage;
    }

    public HomePage signIn(UserCredentials credentials)
    {
        addEmail(credentials.getUserName());
        continueToPassword();
        homePage = continueToSignIn(credentials.getPassword());
        return homePage;
    }
}
