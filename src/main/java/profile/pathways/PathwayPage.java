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

@Component
@Lazy
public class PathwayPage
{
    private static final By CARD_TITLE =
            By.cssSelector(".h3.path-tile-title.guts-p-r-1-half.ng-isolate-scope");

    private final WebDriver driver;
    List<WebElement> cardTitles;

    @Inject
    public PathwayPage(WebDriver driver)
    {
        this.driver = driver;
        cardTitles = new WebDriverWait(driver, 30).
                until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CARD_TITLE));
    }

    public String getCard(int index)
    {
        return cardTitles.get(index).getText();
    }
}
