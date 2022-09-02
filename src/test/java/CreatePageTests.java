import com.ui.api.qagenes.pages.AllTemplates;
import com.ui.api.qagenes.pages.CreatePage;
import com.ui.api.qagenes.pages.RegistrationPopUp;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

//@Listeners({LoggingListener.class })
@Epic("Smoke Tests")
@Feature("Create Page Tests")
public class CreatePageTests extends BaseTest {

    @Test(priority = 0, description = "Verify Registration pop up after click on New Project button")
    @Severity(SeverityLevel.MINOR)
    @Description("Test Description: Test to validate Registration pop up is open up after click on New Project button")
    @Story("As a user, I want to validate Registration pop up should appear after click on New Project button")
    public void testRegistrationPopUpVisibleAfterClickNewProjectButton() {

        page.getInstanceOfPage(CreatePage.class).
             acceptCookies().
             clickNewProject();
        boolean isVisible = page.getInstanceOfPage(RegistrationPopUp.class).
                                 checkPresenceOfRegistrationPopUp();
        Assert.assertTrue(isVisible, "Registration pop up is not present.");
    }


    @Test(priority = 0, description = "Verify Registration pop up after click on a template from templates page")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Test to validate Registration pop up is open up after click on any template in templates page")
    @Story("As a user, I want to navigate through Create Page > See All template > click  on any template in templates page then Registration pop up should appear.")
    public void testRegistrationPopUpVisibleAfterClickSeeAllTemplatesLink() {
        page.getInstanceOfPage(CreatePage.class).
                                              acceptCookies().
                                              clickSeeAllTemplatesLink();
        page.getInstanceOfPage(AllTemplates.class).clickOnFirstTemplate();
        boolean isVisible = page.getInstanceOfPage(RegistrationPopUp.class).checkPresenceOfRegistrationPopUp();
        Assert.assertTrue(isVisible, "Registration pop up is not present.");
    }

}