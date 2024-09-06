package qa.guru.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static io.qameta.allure.Allure.attachment;

public class AttachmentsTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE = 80;

    @Test
    void lambdaAttachmentsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com/");
            attachment("Source", webdriver().driver().source());
        });
    }

    @Test
    void annotatedAttachmentsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        WebSteps webSteps = new WebSteps();
        webSteps.openMainPage();
        webSteps.takeScreenshot();
    }
}
