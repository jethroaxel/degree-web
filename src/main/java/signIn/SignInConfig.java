package signIn;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import config.AppConfigurator;

@Configuration
@Import({AppConfigurator.class, SignInNavigator.class, SignInPage.class})
public class SignInConfig
{
}
