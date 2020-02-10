package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class WebDriverFactory
{
    private String browser;
    private String pathToDriver;

    @Inject
    public WebDriverFactory(@Value("${browser}") String browser, @Value("${driver}")String pathToDriver)
    {
        this.browser= browser;
        this.pathToDriver = pathToDriver;
    }

    public WebDriver createWebDriver()
    {
        WebDriver webDriver;
        if(browser.equals(Browser.CHROME))
        {
            System.out.println("Using chromedriver binary in " + pathToDriver);
            System.setProperty("webdriver." + browser + ".driver", pathToDriver);
            webDriver = new ChromeDriver();
        }
        else {
            throw new RuntimeException( browser + " is unknown, or unsupported");
        }
        return webDriver;
    }
}
