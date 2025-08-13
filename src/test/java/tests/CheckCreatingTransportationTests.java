package tests;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.DealPage;
import pages.ShipmentPage;
import pages.TransportPage;
import salesObjects.Deals;
import salesObjects.Shipments;
import salesObjects.Transports;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static utils.ConfigProperties.geProperty;


public class CheckCreatingTransportationTests {
    private TransportPage transportPage;

    private ShipmentPage shipmentPage;


    public CheckCreatingTransportationTests() {


    }

//Переходим в сделку(Делаем уточнение для какой сделки  Vessel Deep Sea Direct Santos)
// Открываем создание нового шипмента
//Заполняем полностью страницу transports
///Переводим в статус реквест
//Переходим на страницу самого шипмента заполняем данные
//Доводим статус до конечного статуса ресивд
//Переходим в операционную модель
//Проверяем что статус перешел в аккаунтед
//Переходим на страницу транспортс
//Открываем модифай страницы костов
//добавляем новые значения
//Нажимаем на сохранения
//Переходим обратно проверяем статус pending


//Выполняется первая операция,проверяем статус PurchaseService
//Нажимается сразу на отмену после выполнения
//Операция по отмене выполняется,проверка статуса отмены
//Выполняем операции по вторым добавленным костам
//Проверяем статус сначала статус PurchaseService
//
//Service — 219 ReceiveService
//
//Service — 220 DeliveryService


    @Test
    public void CanCheckTransportsCosts() {
        TransportPage trasportPage = page(TransportPage.class);
        ShipmentPage shipmentPage = page(ShipmentPage.class);
        DealPage dealPage = page(DealPage.class);
        TransportPage transportPage = page(TransportPage.class);
        Configuration.browserSize = "1920x1080";
        open("https://dev.eurochem.ru/flow/deals#All");
        $(By.id("login")).setValue(geProperty("web.username"));
        $(By.id("password")).setValue(geProperty("web.password"));
        $(By.xpath("//input[@value='Войти']")).click();


//Открытие страницы
        trasportPage.searchOnPageDeal(Transports.builder()

                .searchOnPage("EC Trading Vessel, Ust'-Luga today")
                .build());

//Создание шипмента
        shipmentPage.shipmentStatusRequest(Shipments.builder()
                .openShipment("")
                .fillingFieldSpotFreight("1")
                .dateNewTransports("")
                .selectQuantity("1")
                .descriptionButton("")
                .saveButtonShipment("")
                .build());

        shipmentPage.confirmShipment(Shipments.builder()
                .build());

//Проверка на статус реквест
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


        Selenide.sleep(3000);
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


        Selenide.sleep(3000);
        String actualStatusShipped = $x("//dt[text()='Status:']/following-sibling::dd[@class='subject']").shouldBe(visible).getText();
        Assertions.assertEquals("Shipped", actualStatusShipped, "Status is not 'Shipped'!");


        shipmentPage.shipmentStatusReceived(Shipments.builder().build());


        Selenide.sleep(3000);
        Selenide.refresh();
        String actualStatusReceived = $x("//dt[text()='Status:']/following-sibling::dd[@class='subject']").shouldBe(visible).getText();
        Assertions.assertEquals("Received", actualStatusReceived, "Status is not 'Received'!");


        $x("//a[contains(@href, '/flow/deals#')]").click();


        Selenide.switchTo().window(WebDriverRunner.getWebDriver().getWindowHandles().size() - 1);

        $x("//a[@data-action='pageReview.pageReviewoperationsNav']").click();



        SelenideElement statusElement1 = $x("//tr[td/span[text()='Material Movement']]/td[@class='status']//span");
        statusElement1.shouldBe(Condition.visible)
                .shouldHave(Condition.text("Accounted"));
//Делаем проверку
        String statusElementOne = statusElement1.getText();
        Assertions.assertTrue(statusElementOne.contains("Accounted "), "Operation status does not contain 'Accounted '!");

//После перехода проверяем в каком статусе Sales
        //Делаем рефреш
        Selenide.sleep(11000);
        Selenide.refresh();



        Selenide.refresh();
        Selenide.refresh();
        SelenideElement statusElement3= $x("//tr[td/span[text()='Sales Order']]/td[@class='status']//span");
        statusElement3.shouldBe(Condition.visible)
                .shouldHave(Condition.text("Accounted "));
        String statusElemenThree = statusElement3.getText();
        Assertions.assertTrue(statusElemenThree.contains("Accounted "), "Operation status does not contain 'Accounted '!");
        Selenide.sleep(10000);


//После выполнения операции переходим к следующей-Confirm Delivery
        //Ожидаем около 2 секунд и делаем рефреш страницы
        Selenide.refresh();
//        Selenide.refresh();
////Ожидаем перехода статуса в Processing
//        SelenideElement statusElement4 = $x("//tr[td/span[text()='Confirm Delivery']]/td[@class='status']//span");

        Selenide.refresh();
        Selenide.refresh();
        Selenide.sleep(10000);
        SelenideElement statusElement5= $x("//tr[td/span[text()='Confirm Delivery']]/td[@class='status']");
        statusElement5.shouldBe(Condition.visible)
                .shouldHave(Condition.text("Accounted "));
        String statusElementFive = statusElement5.getText();
        Assertions.assertTrue(statusElementFive.contains("Accounted "), "Operation status does not contain 'Accounted '!");











        Selenide.$x("//a[@data-action='pageOperations.pageOperationsToolbarreviewNav']").click();



        $x("//*[@id='Shipments']//tr/td[1]/a").click();

        //table//*[contains(text(), 'Invoiced')]




        transportPage.createNewTransportsCosts(Transports.builder()
                .modifyTransportsCosts("")
                .addNewTransportsCosts("")
                .selectServiceCosts("")
                .addCarrierTransportCosts("")
                .addQuantityTransportCosts("1")
                .addCarrierTransportCosts("")
                .selectCarrier("")
                .addPayer("")
                .addPayerUnit("")
                .unitMeasure("")
                .unitSelect("")
                .addAmount("50")
                .addCurrency("")
                .addCurrencyUsd("")
                .saveAndCreateAccrual("")
                .build());

                //Выполняем проверку статуса Pending
//                Selenide.sleep(20000);
//                Selenide.refresh();
//                String actualStatusCost = $x("//*[@id='Costs']//td[text()='Pending']").shouldBe(visible).getText();
//                Assertions.assertEquals("Pending", actualStatusCost, "Status is not 'Pending'!");
//                Selenide.closeWebDriver();




                Selenide.closeWebDriver();


            }
        }


