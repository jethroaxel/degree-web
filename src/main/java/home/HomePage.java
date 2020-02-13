package home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

import profile.ProfilePage;

@Component
@Lazy
public class HomePage
{
    private static final By CARDS = By.cssSelector(".guts-m-t-1.m-guts-m-h-2");
    private static final By PROFILE = By.cssSelector(".tabnav__link.ng-scope");

    private final WebDriver driver;

    @Inject
    @Lazy
    ProfilePage profilePage;

    public HomePage(WebDriver webDriver)
    {
        this.driver = webDriver;
        new WebDriverWait(webDriver, 30)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CARDS));
    }

    public ProfilePage clickOnProfile()
    {
        driver.findElement(PROFILE).click();
        return profilePage;
    }
}
