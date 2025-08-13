package tests;
import com.codeborne.selenide.*;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.openqa.selenium.*;
import pages.DealPage;
import pages.ShipmentPage;
import salesObjects.Deals;
import salesObjects.Shipments;
import java.time.LocalDate;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static utils.ConfigProperties.geProperty;

import com.codeborne.selenide.Selenide;


public class CreateCancelShipmentTests {


    private Shipments shipments;
    private Deals deals;

    public CreateCancelShipmentTests() {

    }

    @Test
    public void CanCreateCancelShipment() {
        SalesOrderOperation salesOrderOperation =new SalesOrderOperation();
        MaterialMovementOperation materialMovementOperation = new MaterialMovementOperation();
        SaleOrderConfirm saleOrderConfirm = new SaleOrderConfirm();
        ShipmentPage shipmentPage = page(ShipmentPage.class);
        DealPage dealPage = page(DealPage.class);

        Configuration.timeout = 15000;
        Configuration.browserSize = "1920x1080";
        open("https://dev.eurochem.ru/flow/deals#Drafts");
        $(By.id("login")).setValue(geProperty("web.username"));
        $(By.id("password")).setValue(geProperty("web.password"));
        $(By.xpath("//input[@value='Войти']")).click();

Selenide.sleep(2000);
Selenide.refresh();
        dealPage.searchDealInTheList(Deals.builder()
                .text("")
                .build());

dealPage.approvalDeal(Deals.builder().
        build());

        Selenide.sleep(30000);
        Selenide.refresh();

        String status = $x("//span[@class='state']")
                .getText();
        if (status.equals("Land Costs Input")) {
            $x("//a[@data-action='pageReview.workflow-approve']").click();

        } else if (status.equals("Confirmed")) {

        }






        shipmentPage.cancelShipmentOnTransports(Shipments.builder()
                        .openShipment("")
                        .fillingFieldSpotFreight("1")
                        .dateNewTransports("")
                        .selectQuantity("1")
                         .descriptionButton("")
                        .saveButtonShipment("")
                        .cancelShipment("")



                .build());
        Selenide.sleep(2000);
            Selenide.refresh();
            String actualStatusCanceled = $x("//span[@class='state']").shouldBe(visible).getText();
            Assertions.assertEquals("Canceled", actualStatusCanceled, "Status is not 'Canceled'!");

            Selenide.sleep(2000);
            List<String> tabs = WebDriverRunner.getWebDriver().getWindowHandles().stream().toList();

        // Сохраняем идентификатор первой вкладки
        String firstTab = tabs.get(0);
        // Переключаемся на последнюю вкладку (новую)
        Selenide.switchTo().window(tabs.get(tabs.size() - 1));


        // После завершения работы на второй вкладке, переключаемся обратно на первую
        Selenide.switchTo().window(firstTab);


        String actualStatusNewDeal = $x("//span[@class='state']").shouldBe(visible).getText();
        Assertions.assertEquals("Confirmed", actualStatusNewDeal, "Status is not 'Confirmed'!");


            shipmentPage.shipmentStatusRequest(Shipments.builder()
                    .openShipment("")
                    .fillingFieldSpotFreight("1")
                    .dateNewTransports("")
                    .selectQuantity("1")
                    .descriptionButton("")
                    .saveButtonShipment("")
                    .build());


        Selenide.switchTo().window(WebDriverRunner.getWebDriver().getWindowHandles().size() - 1);

        shipmentPage.confirmShipment(Shipments.builder().build());
Selenide.sleep(2000);
        Selenide.refresh();
        String CheckStatusShipment = $x("//span[@class='state']").shouldBe(visible).getText();
        Assertions.assertEquals("Requested", CheckStatusShipment, "Status is not 'Requested'!");

        shipmentPage.shipmentStatusFixed(Shipments.builder()
                .openShipmentsInTransports("")
                .shipmentVessel("")
                .vesselTypeShipment("")
                .shipmentWaybill("Df-1230")
                .pressButtonNextStatus("")
                .build());



        Selenide.sleep(4000);
        Selenide.refresh();
        String actualStatus = $x("//dt[text()='Status:']/following-sibling::dd[@class='subject']").shouldBe(visible).getText();
        Assertions.assertEquals("Fixed", actualStatus, "Status is not 'Fixed'!");



        shipmentPage.shipmentStatusCheckedIn(Shipments.builder()
                .shipmentWaybill("Df-1230")
                .shipmentNet("1")
                .shipmentGrossWeight("1")
                .checkedInAt("")
                .pressButtonNextStatus("")
                .build());



        Selenide.sleep(2000);
        Selenide.refresh();
        String actualStatusNext = $x("//dt[text()='Status:']/following-sibling::dd[@class='subject']").shouldBe(visible).getText();
        Assertions.assertEquals("CheckedIn", actualStatusNext, "Status is not 'CheckedIn'!");


        shipmentPage.shipmentStatusShipped(Shipments.builder()
                        .shippedAt("")
                        .pressButtonNextStatus("")
                .build());



        Selenide.sleep(5000);
        String actualStatusShipped = $x("//dt[text()='Status:']/following-sibling::dd[@class='subject']").shouldBe(visible).getText();
        Assertions.assertEquals("Shipped",actualStatusShipped, "Status is not 'Shipped'!");


shipmentPage.shipmentStatusReceived(Shipments.builder().build());
//
//
//        Selenide.sleep(3000);
//        Selenide.refresh();
//        String actualStatusReceived = $x("//dt[text()='Status:']/following-sibling::dd[@class='subject']").shouldBe(visible).getText();
//        Assertions.assertEquals("Received",actualStatusReceived, "Status is not 'Received'!");


$x("//a[contains(@href, '/flow/deals#')]").click();


        Selenide.switchTo().window(WebDriverRunner.getWebDriver().getWindowHandles().size() - 1);

$x("//a[@data-action='pageReview.pageReviewoperationsNav']").click();


Selenide.sleep(7000);




//        SelenideElement statusElement = $x("//tr[td/span[text()='Material Movement']]/td[@class='status']//span");
//
//        statusElement.shouldBe(Condition.visible)
//                .shouldHave(Condition.text("Processing"));
//        String actualStatusMovement = statusElement.getText();
//        Assertions.assertTrue(actualStatusMovement.contains("Processing "), "Operation status does not contain 'Processing '!");
//materialMovementOperation.MaterialMovement();


Selenide.refresh();
//Получаем ответ 200,статус перешел в Accounted

        SelenideElement statusElement1 = $x("//tr[td/span[text()='Material Movement']]/td[@class='status']//span");
        statusElement1.shouldBe(Condition.visible)
                .shouldHave(Condition.text("Accounted"));
//Делаем проверку
        String statusElementOne = statusElement1.getText();
        Assertions.assertTrue(statusElementOne.contains("Accounted "), "Operation status does not contain 'Accounted '!");

//После перехода проверяем в каком статусе Sales
        //Делаем рефреш
Selenide.sleep(7000);
Selenide.refresh();

//        SelenideElement statusElement2 = $x("//tr[td/span[text()='Sales Order']]/td[@class='status']//span");
//        statusElement2.shouldBe(Condition.visible)
//         .shouldHave(Condition.text("Processing "));
//        String statusElementTwo = statusElement2.getText();
//        Assertions.assertTrue(statusElementTwo.contains("Processing "), "Operation status does not contain 'Processing '!");

//        salesOrderOperation.salesOperation();



Selenide.refresh();

//
        SelenideElement statusElement3= $x("//tr[td/span[text()='Sales Order']]/td[@class='status']//span");
        statusElement3.shouldBe(Condition.visible)
                .shouldHave(Condition.text("Accounted "));
        String statusElemenThree = statusElement3.getText();
        Assertions.assertTrue(statusElemenThree.contains("Accounted "), "Operation status does not contain 'Accounted '!");
Selenide.sleep(30000);


//После выполнения операции переходим к следующей-Confirm Delivery
        //Ожидаем около 2 секунд и делаем рефреш страницы
        Selenide.refresh();
//        Selenide.refresh();
////Ожидаем перехода статуса в Processing
//        SelenideElement statusElement4 = $x("//tr[td/span[text()='Confirm Delivery']]/td[@class='status']//span");
//        SaleOrderConfirm.SaleOrder();
        Selenide.refresh();
        SelenideElement statusElement5= $x("//tr[td/span[text()='Confirm Delivery']]/td[@class='status']");
        statusElement5.shouldBe(Condition.visible)
                .shouldHave(Condition.text("Accounted "));
        String statusElementFive = statusElement5.getText();
        Assertions.assertTrue(statusElementFive.contains("Accounted "), "Operation status does not contain 'Accounted '!");
        Selenide.sleep(30000);
        WebDriverRunner.closeWebDriver();
    }
}


