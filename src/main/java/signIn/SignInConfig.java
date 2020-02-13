package signIn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import config.AppConfigurator;

@Configuration
@Import({AppConfigurator.class, SignInNavigator.class, SignInPage.class, LoginImpl.class})
public class SignInConfig
{
    @Bean
    public SignInExtension provideSignInExtension(LoginImpl login)
    {
        return new SignInExtension(login);
    }
}
