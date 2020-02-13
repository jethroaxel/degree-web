package profile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.inject.Inject;

import signIn.SignInExtension;

@ExtendWith(SpringExtension.class)
@SpringJUnitConfig(value = ProfileConfig.class)
public class ProfileTest
{
    ProfilePage profilePage;

    PathwaysModal pathwaysModal;

    @Inject
    ProfileNavigator profileNavigator;

    @Inject
    @RegisterExtension
    SignInExtension signInExtension;

    @BeforeEach
    public void setup()
    {
        profilePage = profileNavigator.navigateToProfile();
    }

    @Test
    public void ShouldCreatePathWay_ByAddingSkill()
    {
        pathwaysModal = profilePage.clickOnPathways();
        Assertions.assertNotNull(pathwaysModal);
        pathwaysModal.fillUpForm("Test Pathway", "testing purposes", "java");

        weeeit();
    }

    public void weeeit()
    {
        try
        { Thread.sleep(5000);}
        catch(InterruptedException e) { e.printStackTrace();}
    }
}
