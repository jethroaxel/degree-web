package profile;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import config.AppConfigurator;
import profile.pathways.PathwayEditor;
import profile.pathways.PathwayPage;
import signIn.LoginImpl;
import signIn.SignInExtension;

@Configuration
@Import({AppConfigurator.class, LoginImpl.class, ProfileNavigator.class,
        SignInExtension.class, ProfilePage.class, PathwayEditor.PathwaysModal.class, PathwayEditor.class,
        PathwayPage.class })
public class ProfileConfig
{
}
