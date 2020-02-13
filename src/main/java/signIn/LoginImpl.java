package signIn;

import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

import user.UserCredentials;

@Component
@Import(SignInNavigator.class)
public class LoginImpl implements Login
{
    private final UserCredentials userCredentials;

    @Inject
    SignInNavigator signInNavigator;

    @Inject
    public LoginImpl(UserCredentials userCredentials)
    {
        this.userCredentials = userCredentials;
    }

    public void login()
    {
        SignInPage signInPage = signInNavigator.navigateToSignIn();
        signInPage.signIn(userCredentials);
    }
}