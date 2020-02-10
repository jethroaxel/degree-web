package profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Profile
{
    private static final By PATHWAYS = By.cssSelector("a.tabnav__link.ng-binding");
    private static final By CREATE_PATHWAYS = By.cssSelector(".btn.btn-primary.ng-binding");

    private final WebDriver webDriver;

    public Profile(WebDriver webDriver)
    {
        this.webDriver = webDriver;
        new WebDriverWait(webDriver, 30)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CREATE_PATHWAYS));
    }

    public Pathways clickOnPathways()
    {
        webDriver.findElement(PATHWAYS).click();
        return new Pathways();//implement
    }
}