package tests;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.openqa.selenium.*;
import pages.DealPage;
import salesObjects.Deals;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static utils.ConfigProperties.geProperty;


public class CreateDealTests {
    private DealPage dealPage;



    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] takeScreenshot() {
        return Selenide.screenshot(OutputType.BYTES);
    }

    public CreateDealTests() {


    }

    @Test
    public void CanDevDeal() {

        DealPage dealPage = page(DealPage.class);
        Configuration.timeout = 15000;
        Configuration.browserSize = "1920x1080";
        open("https://dev.eurochem.ru/flow/deals#All/new");
        $(By.id("login")).setValue(geProperty("web.username"));
        $(By.id("password")).setValue(geProperty("web.password"));
        $(By.xpath("//input[@value='Войти']")).click();

        dealPage.termsConditionsCustomer(Deals.builder()
                .unit("CHTRD")
                .model("Direct")
                .date("")
                .country("Brazil")
                .customer("Cibra Trading Inc.")
                .currency("USD")
                .payment("100/7 B/L")


                 .build());


dealPage.Delivery(Deals.builder()
                .deliveryPeriod("")
                .transports("Vessel Deep Sea")
                .site("EC Trading Vessel, Ust")
                .deliveryTerms("CFR")
                .comment("Test")
                .company("Cibra Trading Inc.")
                .point("Santos")


        .build());

dealPage.Order(Deals.builder()
        .product("MAP 12:52 GRAN")
                .packageOrder("Bulk")

        .build());

dealPage.ContactsAndReferences(Deals.builder()
        .reference("ET/2022/12/Cibra/MAP/701674")

                .referenceDate("")

                .trader("Mariya Meshcheriakova")
                .assistant("Yvonne Soldner")
                .price("630")
                .origin("FOSFORIT")
                .quantity("300")
                .notes("")
                .save("")


        .build());

//Проверяем 'General information'
        //Deal is created

        //Status = Draft

        //Sales Unit = Eurochem Group AG (former Eurochem Trading GmbH)

        //Sales Model = Direct

Selenide.sleep(20000);
        String actualModel = $x("//div[contains(@class, 'summary')]//dd[text()='Direct']").shouldBe(visible).getText();
        Assertions.assertEquals("Direct", actualModel, "Status is not 'Direct'!");


        String actualStatus = $x("//header[@class='title group']//span[@class='state']").shouldBe(visible).getText();
        Assertions.assertEquals("Draft", actualStatus, "Status is not 'Draft'!");

        String actualSalesUnit = $x("//div[contains(@class, 'summary')]//dd[text()='Eurochem Group AG (former Eurochem Trading GmbH) ']").shouldBe(visible).getText();
        Assertions.assertEquals("Eurochem Group AG (former Eurochem Trading GmbH) (CHE-306.864.578)", actualSalesUnit, "Sales Unit is incorrect!");
        Selenide.closeWebDriver();

        Selenide.screenshot("screenshot_name2");



        Selenide.closeWebDriver();
    }
    }







