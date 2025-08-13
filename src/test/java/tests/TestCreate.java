package tests;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import pages.DealPage;
import salesObjects.Deals;
import org.junit.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

import static utils.ConfigProperties.geProperty;

public class TestCreate {
    private DealPage dealPage;




    public TestCreate() {

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

    public void CanTestNegative () {

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

        String actualErrorSave = $x("//div[@class='errors']//h2[text()='Please correct the following errors before continuing']").shouldBe(visible).getText();
        Assertions.assertEquals("Please correct the following errors before continuing", actualErrorSave, "Status is not 'Please correct the following errors before continuing");

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