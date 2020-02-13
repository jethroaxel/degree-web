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

import profile.pathways.PathwayEditor;
import profile.pathways.PathwayPage;

@Component
@Lazy
public class ProfilePage
{
    private static final By TAB = By.cssSelector("a.tabnav__link.ng-binding");
    private static final By CREATE_PATHWAYS = By.cssSelector(".btn.btn-primary.ng-binding");

    private final WebDriver driver;
    private WebElement pathways;
    List<WebElement> tabs;

    @Inject
    @Lazy
    PathwayEditor.PathwaysModal pathwaysModal;

    @Inject
    @Lazy
    PathwayPage pathwayPage;

    @Inject
    public ProfilePage(WebDriver webDriver)
    {
        this.driver = webDriver;
        tabs = new WebDriverWait(webDriver, 30)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(TAB));
    }

    public PathwayPage goToPathwayTab()
    {
        tabs = driver.findElements(TAB);
        tabs.get(3).click();
        return pathwayPage;
    }

    public PathwayEditor.PathwaysModal clickOnPathways()
    {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(CREATE_PATHWAYS)).click();
        return pathwaysModal;
    }
}