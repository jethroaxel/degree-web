package profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

import javax.inject.Inject;

@Component
@Lazy
public class ProfilePage
{
    private static final By PATHWAYS_TAB = By.cssSelector("a.tabnav__link.ng-binding");
    private static final By CREATE_PATHWAYS = By.cssSelector(".btn.btn-primary.ng-binding");

    private final WebDriver driver;
    private WebElement pathways;

    @Lazy
    @Inject
    PathwaysModal pathwaysModal;

    @Inject
    public ProfilePage(WebDriver webDriver)
    {
        this.driver = webDriver;
        pathways = new WebDriverWait(webDriver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(PATHWAYS_TAB));
    }

    public PathwaysModal clickOnPathways()
    {
        pathways.click();
        List<WebElement> tabs = driver.findElements(PATHWAYS_TAB);
        tabs.get(3).click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(CREATE_PATHWAYS)).click();
        return pathwaysModal;
    }
}