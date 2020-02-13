package profile;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import config.AppConfigurator;
import signIn.LoginImpl;
import signIn.SignInExtension;

@Configuration
@Import({AppConfigurator.class, LoginImpl.class, ProfileNavigator.class,
        SignInExtension.class, ProfilePage.class, PathwaysModal.class })
public class ProfileConfig
{
}
