package signIn;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class SignInExtension implements BeforeEachCallback
{
    private final Login login;

    public SignInExtension(Login login)
    {
        this.login = login;
    }

    //this extension will log in a user every time a test runs.
    public void beforeEach(ExtensionContext extensionContext)
    {
        login.login();
    }
}