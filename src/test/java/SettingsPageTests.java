import com.ui.api.qagenes.pages.CreatePage;
import com.ui.api.qagenes.pages.HomePage;
import com.ui.api.qagenes.pages.RegistrationPopUp;
import com.ui.api.qagenes.pages.SettingsPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.ui.api.qagenes.util.gui.PlatformConstants.SETTINGS_URL;
import static com.ui.api.qagenes.util.gui.PlatformConstants.UPLOAD_IMAGE_TEXT;

//@Listeners({LoggingListener.class })
@Epic("Regression Tests")
@Feature("Settings Page Tests")
public class SettingsPageTests extends BaseTest{

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        page.getInstanceOfPage(CreatePage.class).acceptCookies();
        page.getInstanceOfPage(RegistrationPopUp.class).doLogin();

    }
    @Test(priority = 0, description = "Verify settings page's url")
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Test Description: Test to validate setting page's url is ends with 'settings' word")
    @Story("As a user, I want to validate setting page's url should end with 'settings' word")
    public void testSettingsPageUrl(){
        page.getInstanceOfPage(HomePage.class).navigateToSettingPage();
        String Url = page.getInstanceOfPage(SettingsPage.class).getCurrentUrlOfPage();
        Assert.assertTrue(Url.endsWith(SETTINGS_URL), "Page url is not ending with 'Settings' word.");
    }

    @Test(priority = 0, description = "Verify text message for upload image's extension and size")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Test to validate text message for upload image's extension and size")
    @Story("As a user, I want to validate text message for upload image's extension and size")
    public void testTextForUploadImage(){
        page.getInstanceOfPage(HomePage.class).navigateToSettingPage();
        String text = page.getInstanceOfPage(SettingsPage.class).getTextOfUploadImage();
        Assert.assertTrue(text.equalsIgnoreCase(UPLOAD_IMAGE_TEXT), "Text ->"+ text +" about upload image is not matching from expected text ->" + UPLOAD_IMAGE_TEXT);
    }
    @Test(priority = 0, description = "Verify user can upload images in allowed extension '.png' or '.jpg'")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Test to validate that user can upload images in allowed extension '.png' or '.jpg")
    @Story("As a user, I want to validate user should be able to upload images in allowed extension '.png' or '.jpg")
    public void testUploadPhoto(){
        page.getInstanceOfPage(HomePage.class).navigateToSettingPage();
        boolean isSaveButtonDisabled=page.getInstanceOfPage(SettingsPage.class).
                            uploadImage().
                            clickSaveButton().
                            isSaveButtonDisabled();
        Assert.assertFalse(isSaveButtonDisabled, "Save button is enabled");



    }
}
