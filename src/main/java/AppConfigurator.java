import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@Import(WebDriverFactory.class)
public class AppConfigurator
{
    @Bean
    @Qualifier("jethro-tester")
    Credentials provideUserCredentials()
    {
        return new Credentials("jethromontero@gmail.com", "test1234");
    }

    @Bean
    WebDriver provideWebDriver(WebDriverFactory webDriverFactory)
    {
        return webDriverFactory.createWebDriver();
    }
}
