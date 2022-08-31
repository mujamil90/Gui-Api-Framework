import com.ui.api.qagenes.enums.Browsers;
import com.ui.api.qagenes.pages.AllTemplates;
import com.ui.api.qagenes.pages.RegistrationPopUp;
import com.ui.api.qagenes.listeners.RetryFailedTests;
import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.*;
import com.ui.api.qagenes.pages.CreatePage;

import static com.ui.api.qagenes.drivers.DriverManager.*;

public class CreatePageTests extends BaseTest {
    CookieStore cookieStore;
    BasicClientCookie clientCookie;

    @BeforeMethod (alwaysRun = true)
    public void setUp() {

        System.out.println("We will do something here");
//        createDriver(Browsers.CHROME);
////        CookieStore cookieStore = new BasicCookieStore();
////        BasicClientCookie clientCookie = new BasicClientCookie("ab.storage.sessionId.4fc46d16-14ad-4944-ba4b-c874f391cb00", "%7B%22g%22%3A%221227ed61-357e-e3ba-c129-0fccdc799050%22%2C%22e%22%3A1661800250321%2C%22c%22%3A1661798439368%2C%22l%22%3A1661798450321%7D");
////        cookieStore.addCookie(clientCookie);
////        org.openqa.selenium.Cookie c = new org.openqa.selenium.Cookie(cookieStore.getCookies().get(0).getName(), cookieStore.getCookies().get(0).getValue());
////        getDriver().manage().addCookie(c);
//        getDriver().manage().window().maximize();
//        getDriver().get("https://picsart.com/create/");

    }



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