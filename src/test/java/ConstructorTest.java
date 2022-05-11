import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import PageObject.MainPage;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;
import static PageObject.MainPage.MAIN_PAGE_URL;

@Epic("Creating new user role")
@Feature("Constructor data")
public class ConstructorTest {

    private MainPage mainPage;

    @Before
    public void setUp() {
        mainPage = open(MAIN_PAGE_URL, MainPage.class);
    }

    @Test
    @DisplayName("Check buns")
    @Description("Checking click buns button and is displayed")
    public void checkChooseBunsConstructorTest() {
        mainPage.clickSaucesChoose();
        mainPage.clickBunsChoose();

        assertTrue(mainPage.isDisplayedKindsBuns());
    }

    @Test
    @DisplayName("Check sauces")
    @Description("Checking click sauces button and is displayed")
    public void checkChooseSaucesConstructorTest() {
        mainPage.clickSaucesChoose();

        assertTrue(mainPage.isDisplayedKindsSauces());
    }

    @Test
    @DisplayName("Check meats")
    @Description("Checking click meats button and is displayed")
    public void checkChooseMeatConstructorTest() {
        mainPage.clickMeatsChoose();

        assertTrue(mainPage.isDisplayedKindsMeats());
    }
}