import Client.User;
import Client.UserClient;
import PageObject.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.apache.commons.lang3.RandomStringUtils;
import PageObject.LoginPage;
import PageObject.RegistrationPage;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;
import static com.codeborne.selenide.Selenide.open;

@Epic("Creating new user role")
@Feature("Registration")
public class UserRegistrationErrorPasswordTest{

    private User user;
    private MainPage mainPage;

    @Before
    public void setUp() {
        user = User.getRandom();
        mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
    }

@Test
@DisplayName("Negative registration")
@Description("Check error field for password {<5}")
public void checkErrorFieldPasswordTest(){
        mainPage.clickEnterAccountButton();

        LoginPage loginPage=page(LoginPage.class);
        loginPage.clickRegistrationButton();

        RegistrationPage registrationPage=page(RegistrationPage.class);
        registrationPage.setNameField(user.getName());
        registrationPage.setEmailField(user.getEmail());
        registrationPage.setPasswordField(RandomStringUtils.randomAlphabetic(5));
        registrationPage.clickRegistrationButton();

        assertTrue("Error password field not displayed",registrationPage.errorPasswordFieldIsDisplayed());
        }
}
