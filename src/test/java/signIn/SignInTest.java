package signIn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.util.Assert;

import javax.inject.Inject;

import home.HomePage;
import user.UserCredentials;

@ExtendWith(SpringExtension.class)
@SpringJUnitConfig(value = SignInConfig.class)
public class SignInTest
{
    SignInPage signInPage;

    HomePage homePage;

    @Inject
    SignInNavigator signInNavigator;

    @Inject
    UserCredentials userCredentials;

    public void weeeit()
    {
        try
        { Thread.sleep(1500);}
        catch(InterruptedException e) { e.printStackTrace();}
    }

    @BeforeEach
    public void setup()
    {
        signInPage = signInNavigator.navigateToSignIn();
    }

    @Test
    public void GoToSignInPage()
    {
        signInPage.addEmail(userCredentials.getUserName());
        signInPage.continueToPassword();
        homePage = signInPage.continueToSignIn(userCredentials.getPassword());
        Assert.notNull(homePage, "Home pae should load");
    }
}