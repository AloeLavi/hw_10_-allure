package qa.guru.allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Открыть главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Кликнуть на поисковую строку")
    public void clickSearchField() {
        $(".header-search-input").click();
    }

    @Step("Ввести в поисковую строку текст {repo} ")
    public void inputRepoName(String repo) {
        $(".header-search-input").sendKeys(repo);
    }

    @Step("Нажать Enter")
    public void pressEnter() {
        $(".header-search-input").submit();
    }

    @Step("Открыть репозиторий  {repo}")
    public void openRepo(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Открыть вкладку issues")
    public void openIssueTab() {
        $("#issues-tab").click();    }

    @Step("Найти Issue с заголовком  {issue}")
    public void findIssueByName(String issue) {
        $("[data-hovercard-type=issue]").shouldHave(Condition.text(issue));

    }


}
