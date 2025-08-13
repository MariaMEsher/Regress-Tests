package tests;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.DealPage;
import pages.ShipmentPage;
import salesObjects.Deals;
import salesObjects.Shipments;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static utils.ConfigProperties.geProperty;

public class CheckMultipleOperationsTests {
    private Shipments shipments;
    private Deals deals;


    public CheckMultipleOperationsTests() {

    }
    @Test
    public void CanAccountingShipments(){
        ShipmentPage shipmentPage = page(ShipmentPage.class);
        DealPage dealPage = page(DealPage.class);


        Configuration.browserSize = "1920x1080";
        open("https://dev.eurochem.ru/flow/deals#All/new");
        Selenide.refresh();
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


        String actualModel = $x("//div[contains(@class, 'summary')]//dd[text()='Direct']").shouldBe(visible).getText();
        Assertions.assertEquals("Direct", actualModel, "Status is not 'Direct'!");


        String actualStatus = $x("//header[@class='title group']//span[@class='state']").shouldBe(visible).getText();
        Assertions.assertEquals("Draft", actualStatus, "Status is not 'Draft'!");

        String actualSalesUnit = $x("//div[contains(@class, 'summary')]//dd[text()='Eurochem Group AG (former Eurochem Trading GmbH) ']").shouldBe(visible).getText();
        Assertions.assertEquals("Eurochem Group AG (former Eurochem Trading GmbH) (CHE-306.864.578)", actualSalesUnit, "Sales Unit is incorrect!");

        $x("//a[@data-action='pageReview.workflow-send-to-approval']").click();





        Selenide.sleep(30000);
        Selenide.refresh();

        String status = $x("//span[@class='state']")
                .getText();
        if (status.equals("Land Costs Input")) {
            $x("//a[@data-action='pageReview.workflow-approve']").click();

        } else if (status.equals("Confirmed")) {

        }




        shipmentPage.createShipmentForMultipleOperation(Shipments.builder()
                .fillingFieldSpotFreight("1")
                .dateNewTransports("")
                .selectQuantity("1")
                .descriptionButton("")
                .saveButtonShipment("")
                .build());


        shipmentPage.confirmShipment(Shipments.builder().build());

        String actualStatusShipment = $x("//span[@class='state']").shouldBe(visible).getText();
        Assertions.assertEquals("Draft", actualStatusShipment, "Status is not 'Draft'!");
        Selenide.refresh();

        //shipmentPage.confirmShipment(Shipments.builder()
           //     .build());

        Selenide.refresh();
        String CheckStatusShipment = $x("//span[@class='state']").shouldBe(visible).getText();
        Assertions.assertEquals("Requested", CheckStatusShipment, "Status is not 'Requested'!");



        $x("//a[@data-action='roleOwner.Multipleoperations']").click();
        $x("//input[@id='search.salesUnit']").click();
        $x("//li[@data-id='CHTRD']").click();
        $x("//input[@id='search.state']").click();
        $x("//li[@data-id='Requested']").click();

        $x("//input[@id='search.from']").click();
        $x("//li[@data-id='647']").click();

        $x("//input[@id='search.shippedScheduled']").click();
        $(".today > a").shouldBe(Condition.visible).click();

        $x("//div[@class='subfield input checkbox']//input[@data-sync='pageShipmentSearch.search.rows.selectedChanged']").click();

        $x("//div[@class='group']//a[@class='button' and text()='Change state']").click();

        $x("//a[@data-action='pageShipmentSearch.shipment-search-open-date-form']").click();

        $x("//input[@id='update.checkedInScheduled']").click();

        $(".today > a").click();

        $x("//input[@id='update.shippedAt']").click();
        $(".today > a").click();


        $x("//a[@data-action='pageShipmentSearch.update.shipment-search-change-state']").click();
        $x(" //a[contains(@class, 'button') and contains(@class, 'primary')]").click();
        $x("//a[contains(@href, '/flow/transports#')]").click();

        Selenide.sleep(2000);
        refresh();

        String actualStatusShipped = $x("//span[@class='state']").shouldBe(visible).getText();
        Assertions.assertEquals("Shipped", actualStatusShipped, "Status is not 'Shipped'!");


        $x("//a[@data-action='roleOwner.Multipleoperations']").click();

        $x("//input[@id='search.salesUnit']").click();
        $x("//li[@data-id='CHTRD']").click();
        $x("//input[@id='search.state']").click();
        $x("//li[@data-id='Shipped']").click();
        $x("//input[@id='search.from']").click();
        $x("//li[@data-id='647']").click();
        $x("//input[@id='search.shippedScheduled']").click();
        $(".today > a").click();


        ElementsCollection elements = $$x("//div[@class='subfield input checkbox']//input[@data-sync='pageShipmentSearch.search.rows.selectedChanged']");

        // Проверить, что элементы найдены
        if (elements.size() > 0) {
            // Выбрать первый элемент (индекс 0) и выполнить действие, например, клик
            elements.get(0).click();
        } else {
            System.out.println("Элементы не найдены.");
        }

        $x("//div[@class='subfield input checkbox']//input[@data-sync='pageShipmentSearch.search.rows.selectedChanged']").click();

        $x("//div[@class='group']//a[@class='button' and text()='Change state']").click();
        $x("//a[@data-action='pageShipmentSearch.shipment-search-open-date-form']").click();
        $x("//input[@id='update.checkedInScheduled']").click();

        $(".today > a").click();

        $x("//input[@id='update.shippedAt']").click();
        $(".today > a").click();
        ;


        $x("//a[@data-action='pageShipmentSearch.update.shipment-search-change-state']").click();
        $x(" //a[contains(@class, 'button') and contains(@class, 'primary')]").click();
        $x("//a[contains(@href, '/flow/transports#')]").click();
        Selenide.sleep(10000);
        refresh();
        String actualStatusReceived = $x("//span[@class='state']").shouldBe(visible).getText();
        Assertions.assertEquals("Received", actualStatusReceived, "Status is not 'Received'!");


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





