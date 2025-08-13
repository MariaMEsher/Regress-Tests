package tests;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.openqa.selenium.*;
import pages.DealPage;
import salesObjects.Deals;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static utils.ConfigProperties.geProperty;


public class CopyDealsTests {
    private DealPage dealPage;


  public CopyDealsTests(){

    }
    @Test
    public void CanCopyDeal() {
        Configuration.timeout = 15000;
        DealPage dealPage = page(DealPage.class);
        Configuration.browserSize = "1920x1080";
        open("https://dev.eurochem.ru/flow/deals#Drafts");
        $(By.id("login")).setValue(geProperty("web.username"));
        $(By.id("password")).setValue(geProperty("web.password"));
        $(By.xpath("//input[@value='Войти']")).click();

Selenide.sleep(2000);
    Selenide.refresh();
        dealPage.copyDeal(Deals.builder()
                        .text("Vessel Deep Sea direct")
                        .build());



          dealPage.editDeal(Deals.builder()
                          .point("Santos")


        .build());


//
        String actualModel = $x("//div[contains(@class, 'summary')]//dd[text()='Direct']").shouldBe(visible).getText();
        Assertions.assertEquals("Direct", actualModel, "Status is not 'Direct'!");


        String actualStatus = $x("//header[@class='title group']//span[@class='state']").shouldBe(visible).getText();
        Assertions.assertEquals("Draft", actualStatus, "Status is not 'Draft'!");

        String actualSalesUnit = $x("//div[contains(@class, 'summary')]//dd[text()='Eurochem Group AG (former Eurochem Trading GmbH) ']").shouldBe(visible).getText();
        Assertions.assertEquals("Eurochem Group AG (former Eurochem Trading GmbH) (CHE-306.864.578)", actualSalesUnit, "Sales Unit is incorrect!");


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