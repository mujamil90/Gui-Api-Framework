import com.ui.api.qagenes.pages.CreatePage;
import com.ui.api.qagenes.pages.HomePage;
import com.ui.api.qagenes.pages.RegistrationPopUp;
import com.ui.api.qagenes.pages.SettingsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SettingsPageTests extends BaseTest{

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        page.getInstanceOfPage(CreatePage.class).acceptCookies();
        page.getInstanceOfPage(RegistrationPopUp.class).doLogin();

    }

    @Test
    public void testSettingsPageUrl(){
        page.getInstanceOfPage(HomePage.class).navigateToSettingPage();
        String Url = page.getInstanceOfPage(SettingsPage.class).getCurrentUrlOfPage();
        Assert.assertTrue(Url.endsWith("settings"), "Page url is not ending with 'Settings' word.");
    }

    @Test
    public void testTextForUploadImage(){
        page.getInstanceOfPage(HomePage.class).navigateToSettingPage();
        String text = page.getInstanceOfPage(SettingsPage.class).getTextOfUploadImage();
        Assert.assertTrue(text.equalsIgnoreCase("You can upload jpg. or png image files. Max size 2mb."), "Text about upload image is not matching from expected text.");
    }
    @Test
    public void testUploadPhoto(){
        page.getInstanceOfPage(HomePage.class).navigateToSettingPage();
        boolean isSaveButtonDisabled=page.getInstanceOfPage(SettingsPage.class).
                            uploadImage().
                            clickSaveButton().
                            isSaveButtonDisabled();
        Assert.assertFalse(isSaveButtonDisabled, "Save button is enabled");



    }
}
