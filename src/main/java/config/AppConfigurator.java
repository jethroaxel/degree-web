package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import user.UserCredentials;

@Configuration
@PropertySource("classpath:application.properties")
@Import(WebDriverFactory.class)
public class AppConfigurator
{
    @Bean
    @Qualifier("jethro-tester")
    UserCredentials provideUserCredentials()
    {
        return new UserCredentials("jethromontero@gmail.com", "test1234");
    }

    @Bean
    WebDriver provideWebDriver()
    {
        return new ChromeDriver();
    }
}
