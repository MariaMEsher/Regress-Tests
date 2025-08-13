package tests;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import manager.BaseTests;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.*;
import pages.DealPage;
import salesObjects.Deals;
import org.junit.Test;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

import static utils.ConfigProperties.geProperty;

public class CreateDealNegativeTests {
    private DealPage dealPage;




    public CreateDealNegativeTests() {

//
//    }
//
//
//
//    @Attachment(value = "Screenshot", type = "image/png")
//    public static byte[] takeScreenshot() {
//        return Selenide.screenshot(OutputType.BYTES);
//
//
//    }
    }


    @Test
//    @AllureId("123") // если интеграция с TMS
//    @Feature("Авторизация")
//    @Story("Проверка входа с валидными данными")
//    @Severity(SeverityLevel.CRITICAL)
//    @Description("Этот тест проверяет успешный вход в систему")

    public void CanCreateNegative () {

        Configuration.timeout = 15000;
        DealPage dealPage = page(DealPage.class);
        Configuration.browserSize = "1920x1080";
        open("https://dev.eurochem.ru/flow/deals#All/new");
        $(By.id("login")).setValue(geProperty("web.username"));
        $(By.id("password")).setValue(geProperty("web.password"));
        $(By.xpath("//input[@value='Войти']")).click();





        dealPage.ClickButtonSave(Deals.builder()
                        .negativeSave("")
                .build());

        String actualErrorSave = $x("//div[@class='errors']//h2[text()='Please correct the following errors before ']").shouldBe(visible).getText();
        Assertions.assertEquals("Please correct the following errors before", actualErrorSave, "Status is not 'Please correct the following errors before ");

        Selenide.sleep(2000);
//        Selenide.screenshot("screenshot_name");
        for (String tab : Selenide.webdriver().object().getWindowHandles()) {
            // Переключаемся на каждую вкладку
            Selenide.webdriver().object().switchTo().window(tab);
            // Закрываем текущую вкладку
            Selenide.webdriver().object().close();
        }

        // Завершаем работу WebDriver



        Selenide.closeWebDriver();
    }


}
