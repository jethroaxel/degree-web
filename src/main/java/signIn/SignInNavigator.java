package signIn;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
@Import(SignInPage.class)
public class SignInNavigator
{
    private WebDriver driver;
    private String signInUrl;

    @Inject
    @Lazy
    SignInPage signInPage;

    @Inject
    public SignInNavigator(WebDriver driver, @Value("${login-url}")String signInUrl)
    {
        this.driver = driver;
        this.signInUrl = signInUrl;
    }

    public SignInPage navigateToSignIn()
    {
        System.out.println("navigating to: " + signInUrl);
        driver.get(signInUrl);
        return signInPage;
    }
}
