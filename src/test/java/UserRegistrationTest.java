import Client.User;
import Client.UserClient;
import Client.UserCredentials;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import PageObject.LoginPage;
import PageObject.MainPage;
import PageObject.RegistrationPage;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static PageObject.LoginPage.LOGIN_PAGE_URL;

@Epic("Creating new user role")
@Feature("Registration")
public class UserRegistrationTest {

    private User user;
    private UserClient userClient;
    private MainPage mainPage;
    private String accessToken;

    @Before
    public void setUp() {
        userClient = new UserClient();
        user = User.getRandom();
        mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
    }

    @After
    public void tearDown() {
        accessToken = userClient.login(UserCredentials.from(user)).extract().path("accessToken");
        userClient.deleteUser(accessToken);
    }

    @Test
    @DisplayName("Positive registration")
    @Description("Positive registration and check LOGIN_PAGE_URL")
    public void positiveRegistrationTest() {
        mainPage.clickEnterAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegistrationButton();

        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.setNameField(user.getName());
        registrationPage.setEmailField(user.getEmail());
        registrationPage.setPasswordField(user.getPassword());
        registrationPage.clickRegistrationButton();

        webdriver().shouldHave(url(LOGIN_PAGE_URL));
    }
}