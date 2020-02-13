package profile;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class ProfileNavigator
{
    private WebDriver driver;
    private String profileUrl;

    @Inject
    @Lazy
    ProfilePage profilePage;

    public ProfileNavigator(WebDriver driver, @Value("${profile-url}")String profileUrl)
    {
        this.driver = driver;
        this.profileUrl = profileUrl;
    }

    public ProfilePage navigateToProfile()
    {
        driver.get(profileUrl);
        return profilePage;
    }
}
