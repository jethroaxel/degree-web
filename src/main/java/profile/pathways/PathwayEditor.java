package profile.pathways;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

import javax.inject.Inject;

import profile.ProfilePage;

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

    @Component
    @Lazy
    public static class PathwaysModal
    {
        private static final By PATHWAY_NAME = By.id("pathName");
        private static final By PATHWAY_DESCRIPTION = By.id("pathDescription");
        private static final By PATHWAY_SKILL = By.id("tagSearch");
        private static final By SAVE_PATHWAY = By.cssSelector(".js-spin-content");

        private final WebDriver driver;
        private WebElement save;

        @Inject
        @Lazy
        PathwayEditor pathwayEditor;

        @Inject
        public PathwaysModal(WebDriver driver)
        {
            this.driver = driver;
            save = new WebDriverWait(driver, 30)
                    .until(ExpectedConditions.visibilityOfElementLocated(SAVE_PATHWAY));
        }

        private void setField(By locator, String value)
        {
            WebElement e = driver.findElement(locator);
            e.clear();
            e.sendKeys(value);
        }

        public PathwayEditor fillUpForm(String name, String description, String skill)
        {
            final By LIST_OF_SKILLS_AVAILABLE = By.cssSelector("span strong");
            setField(PATHWAY_NAME, name);
            setField(PATHWAY_DESCRIPTION, description);
            setField(PATHWAY_SKILL, skill);

            List<WebElement> skillsAvailable = new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(LIST_OF_SKILLS_AVAILABLE));
            for(WebElement e: skillsAvailable)
            {
                if(e.getText().equals(skill))
                {
                    e.click();
                    break;
                }
            }
            save.click();
            return pathwayEditor;
        }
    }
}
