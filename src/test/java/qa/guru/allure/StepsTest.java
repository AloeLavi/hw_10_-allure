package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {
    final String REPOSITORY = "AloeLavi/lesson_1";
    final String ISSUE = "Wow Issue";
    @Test
    public void testIssueSearchLambda() {
        SelenideLogger.addListener("allure", new AllureSelenide());


        step("Открыть главную страницу", () -> {
            open("https://github.com");
        });

        step("Кликнуть на поисковую строку", () -> {
            $(".header-search-input").click();
        });

        step("Ввести в поисковую строку имя репозитория " + REPOSITORY, () -> {
            $(".header-search-input").sendKeys(REPOSITORY);
        });

        step("Нажать Enter", () -> {
            $(".header-search-input").submit();
        });

        step("Открыть репозиторий " + REPOSITORY, () -> {
             $(linkText(REPOSITORY)).click();
        });

        step("Открыть вкладку issues", () -> {
            $("#issues-tab").click();
        });

        step("Найти Issue с заголовком " + ISSUE, () -> {
            $("[data-hovercard-type=issue]").shouldHave(Condition.text(ISSUE));
        });
    }

    @Test
    public void testAnnotatedSteps(){
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.clickSearchField();
        steps.inputRepoName(REPOSITORY);
        steps.pressEnter();
        steps.openRepo(REPOSITORY);
        steps.openIssueTab();
        steps.findIssueByName(ISSUE);
    }
}
