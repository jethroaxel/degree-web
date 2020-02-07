import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class WebDriverFactory
{
    private String browser;
    private static final String PATH_TO_CHROME_DRIVER_BINARY = "/path/to/binary";

    @Inject
    public WebDriverFactory(@Value("${browser}") String browser)
    {
        this.browser= browser;
    }

    public WebDriver createWebDriver()
    {
        WebDriver webDriver;
        if(browser.equals(Browser.CHROME))
        {
            System.setProperty("webdriver."+ browser + ".driver", PATH_TO_CHROME_DRIVER_BINARY);
            webDriver = new ChromeDriver();
        }
        else {
            throw new RuntimeException("Unknown, or unsupported browser");
        }
        return webDriver;
    }
}
