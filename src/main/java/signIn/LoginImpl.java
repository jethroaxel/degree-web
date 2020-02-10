package signIn;

import javax.inject.Inject;

import user.UserCredentials;

public class LoginImpl implements Login
{
    private final UserCredentials userCredentials;

    @Inject
    SignInNavigator signInNavigator;

    public LoginImpl(UserCredentials userCredentials)
    {
        this.userCredentials = userCredentials;
    }

    public void login()
    {
        SignInPage signInPage = signInNavigator.navigateToSignIn();
        signInPage.signIn(userCredentials.getUserName(), userCredentials.getPassword());
    }
}