import com.ui.api.qagenes.pages.AllTemplates;
import com.ui.api.qagenes.pages.CreatePage;
import com.ui.api.qagenes.pages.RegistrationPopUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreatePageTests extends BaseTest {


    @Test
    public void testRegistrationPopUpVisibleAfterClickNewProjectButton() {

        page.getInstanceOfPage(CreatePage.class).
             acceptCookies().
             clickNewProject();
        boolean isVisible = page.getInstanceOfPage(RegistrationPopUp.class).
                                 checkPresenceOfRegistrationPopUp();
        Assert.assertTrue(isVisible, "Registration pop up is not present.");
    }


    @Test
    public void testRegistrationPopUpVisibleAfterClickSeeAllTemplatesLink() {
        page.getInstanceOfPage(CreatePage.class).
                                              acceptCookies().
                                              clickSeeAllTemplatesLink();
        page.getInstanceOfPage(AllTemplates.class).clickOnFirstTemplate();
        boolean isVisible = page.getInstanceOfPage(RegistrationPopUp.class).checkPresenceOfRegistrationPopUp();
        Assert.assertTrue(isVisible, "Registration pop up is not present.");
    }

}