package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.DealPage;
import salesObjects.Deals;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static utils.ConfigProperties.geProperty;

public class CheckApprovalsTests {
    private DealPage dealPage;

public CheckApprovalsTests() {

}
    @Test
    public void CanApprovalsTests() {


        DealPage dealPage = page(DealPage.class);

        Configuration.browserSize = "1920x1080";
        open("https://dev.eurochem.ru/flow/deals#Drafts");
        $(By.id("login")).setValue(geProperty("web.username"));
        $(By.id("password")).setValue(geProperty("web.password"));
        $(By.xpath("//input[@value='Войти']")).click();
        Selenide.sleep(3000);
Selenide.refresh();
        $x("//input[@type='text']").click();
        $x("//input[@type='text']").setValue("Vessel Deep Sea direct today");
        $x("//ol[@id='entries']//li[1]").click();




        $x("//a[@data-action='pageReview.workflow-send-to-approval']").click();

        String status1 = $x("//span[@class='state']")
                .getText();
        if (status1.equals("Land Costs Input")) {
            $x("//a[@data-action='pageReview.workflow-approve']").click();

        } else if (status1.equals("Confirmed")) {

        }







//        Selenide.sleep(70000);
//        Selenide.refresh();
//
//
//        String actualStatusDeal = $x("//span[@class='state']").shouldBe(visible).getText();
//        Assertions.assertEquals("Confirmed", actualStatusDeal, "Status is not 'Confirmed'!");




        //span[@class='state']
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
