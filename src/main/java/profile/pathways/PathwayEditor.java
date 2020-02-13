package profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
@Lazy
public class PathwayEditor
{
    private static final By DONE_EDITING = By.cssSelector(".ib-v-middle.ng-binding.ng-scope");

    private final WebDriver driver;
    private WebElement doneButton;

    @Inject
    @Lazy
    private ProfilePage profilePage;

    @Inject
    public PathwayEditor(WebDriver driver)
    {
        this.driver = driver;
        doneButton = new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(DONE_EDITING));
    }

    public ProfilePage clickDoneButton()
    {
        doneButton.click();
        return profilePage;
    }
}
