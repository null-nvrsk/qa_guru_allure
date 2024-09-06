package qa.guru.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("nullnvrsk")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Создание Issue для авторизованного пользователя")
    void staticLabelsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Test
    void dynamicLabelsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        Allure.getLifecycle().updateTestCase(
                t -> t.setName("Создание Issue для авторизованного пользователя")
        );
        Allure.feature("Issue в репозитории");
        Allure.story("Создание Issue");
        Allure.label("owner", "nullnvrsk");
        Allure.label("severity", SeverityLevel.CRITICAL.value());
        Allure.link("Testing", "https://testing.github.com");
    }
}