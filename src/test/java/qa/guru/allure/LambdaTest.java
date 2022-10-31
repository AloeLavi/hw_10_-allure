package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaTest {
    @Test
    public void testIssueSearchLambda() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть главную страницу", () -> {
            open("https://github.com");
        });

        step("Кликнуть на поисковую строку", () -> {
            $(".header-search-input").click();
        });

        step("Ввести в поисковую строку имя репозитория AloeLavi/lesson_1", () -> {
            $(".header-search-input").sendKeys("AloeLavi/lesson_1");
        });

        step("Нажать Enter", () -> {
            $(".header-search-input").submit();
        });

        step("Открыть репозиторий lesson_1", () -> {
             $(linkText("AloeLavi/lesson_1")).click();
        });

        step("Открыть вкладку issues", () -> {
            $("#issues-tab").click();
        });

        step("Найти Issue с заголовком Wow Issue", () -> {
            $("[data-hovercard-type=issue]").shouldHave(Condition.text("Wow Issue"));
        });
    }
}
