package profile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.inject.Inject;

import profile.pathways.PathwayEditor;
import profile.pathways.PathwayPage;
import signIn.SignInExtension;

@ExtendWith(SpringExtension.class)
@SpringJUnitConfig(value = ProfileConfig.class)
public class ProfileTest
{
    static String PATHWAT_NAME = "Test Pathway";

    ProfilePage profilePage;
    PathwayEditor.PathwaysModal pathwaysModal;
    PathwayEditor pathwayEditor;
    PathwayPage pathwayPage;

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
        profilePage.goToPathwayTab();
        pathwaysModal = profilePage.clickOnPathways();
        Assertions.assertNotNull(pathwaysModal);

        pathwayEditor = pathwaysModal.fillUpForm(PATHWAT_NAME,
                "testing purposes", "java");
        pathwayEditor.clickDoneButton();

        profileNavigator.navigateToProfile();
        pathwayPage = profilePage.goToPathwayTab();
        Assertions.assertEquals(pathwayPage.getCard(0), PATHWAT_NAME);
    }
}