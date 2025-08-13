package tests;
import com.codeborne.selenide.*;
import com.codeborne.selenide.ex.ElementNotFound;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;
import static utils.ConfigProperties.geProperty;
import static com.codeborne.selenide.Condition.visible;

import org.junit.Test;
import pages.DealPage;
import pages.ShipmentPage;
import salesObjects.Deals;
import salesObjects.Shipments;

import java.util.List;

public class CheckingFunctionalityWithFlagDelayedTests {

    //Открыть сделку https://dev.eurochem.ru/flow/deals#All/827267
    //Нажать на копирование
    //Заполнить данные и проверить статус драфт
    //Перейти в словарь проставить настройку для chtrd
    //Перейти в созданную сделку
    //Проверить что окно с 'Delayed присутствует
    //Нажать на аппрув сделки и проверить статус confirmed
    //Создать шипмент перевести и проверить статус fixed
    //Заполнить данные и перевести в статус  Checkedin'
    //Проверить что дата ресивд залочена
    //Нажать на  marked as loaded и выполнить операцию Material Movement'
    //Проверить что статус перешел в нужный
    //
    //
    //
    //
    //
    //
    //
    //
    //
    @Test
    public void CanCheckFlagDelayed() {
        SalesOrderOperation salesOrderOperation =new SalesOrderOperation();
        MaterialMovementOperation materialMovementOperation = new MaterialMovementOperation();
        SaleOrderConfirm saleOrderConfirm = new SaleOrderConfirm();
            DealPage dealPage = page(DealPage.class);
            ShipmentPage shipmentPage = page(ShipmentPage.class);
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


            String actualModel = $x("//div[contains(@class, 'summary')]//dd[text()='Direct']").shouldBe(visible).getText();
            Assertions.assertEquals("Direct", actualModel, "Status is not 'Direct'!");


            String actualStatus = $x("//header[@class='title group']//span[@class='state']").shouldBe(visible).getText();
            Assertions.assertEquals("Draft", actualStatus, "Status is not 'Draft'!");

            String actualSalesUnit = $x("//div[contains(@class, 'summary')]//dd[text()='Eurochem Group AG (former Eurochem Trading GmbH) ']").shouldBe(visible).getText();
            Assertions.assertEquals("Eurochem Group AG (former Eurochem Trading GmbH) (CHE-306.864.578)", actualSalesUnit, "Sales Unit is incorrect!");
            String firstTab = WebDriverRunner.getWebDriver().getWindowHandle();



            executeJavaScript("window.open('https://dev.eurochem.ru/flow/dictionaries#All/salesUnitProperties/134', '_blank');");
            List<String> tabs = WebDriverRunner.getWebDriver().getWindowHandles().stream().toList();
            Selenide.switchTo().window(tabs.get(tabs.size() - 1));
            $x("//input[@name='salesUnitPropertie.hasDeliveryDelayed']").click();
            $x("//textarea[@name='dictionaryRegistry.serviceRequest']").click();
            $x("//textarea[@name='dictionaryRegistry.serviceRequest']").setValue("123");
            $x("//a[@data-action='pageForm.save']").click();


            Selenide.switchTo().window(firstTab);


//            Selenide.switchTo().window(firstTab);
            $x("//input[@type='checkbox']").shouldBe(exist);
        $x("//input[@name ='deal.notes']").click();
        $x("//header[@class='title group sticky']//a[@class='button primary']").click();
            $x("//a[@data-action='pageReview.workflow-send-to-approval']").click();

            Selenide.sleep(50000);
            Selenide.refresh();



            String status = $x("//span[@class='state']")
                    .getText();
            if (status.equals("Land Costs Input")) {
                    $x("//a[@data-action='pageReview.workflow-approve']").click();

            } else if (status.equals("Confirmed")) {

            }

            Selenide.sleep(3000);
            Selenide.refresh();


            shipmentPage.statusDraftShipment(Shipments.builder()
                    .openShipment("")
                    .fillingFieldSpotFreight("1")
                    .dateNewTransports("")
                    .selectQuantity("1")
                    .descriptionButton("")
                    .saveButtonShipment("")
                    .build());


            String actualStatusShipment = $x("//span[@class='state']").shouldBe(visible).getText();
            Assertions.assertEquals("Draft", actualStatusShipment, "Status is not 'Draft'!");


            Selenide.sleep(1000);
            Selenide.refresh();


            shipmentPage.confirmShipment(Shipments.builder()
                    .build());

            Selenide.sleep(1000);
            Selenide.refresh();

            shipmentPage.nextStatusAfterRequest(Shipments.builder()
                    .confirmationFromRequstStatus("")
                    .confirmShipmentOnTranspots("")


                    .build());
            Selenide.sleep(1000);
            Selenide.refresh();

            String actualStatusNext = $x("//span[@class='state']").shouldBe(visible).getText();
            Assertions.assertEquals("Fixed", actualStatusNext, "Status is not 'Fixed'!");

            Selenide.switchTo().window(WebDriverRunner.getWebDriver().getWindowHandles().size() - 1);

            shipmentPage.createShipment(Shipments.builder()
                    .openShipmentsInTransports("")
                    .shipmentVessel("")
                    .vesselTypeShipment("")
                    .shipmentWaybill("1123")
                    .shipmentNet("1")
                    .shipmentGrossWeight("1")
                    .checkedInAt("")

                    .build());


            Selenide.switchTo().window(WebDriverRunner.getWebDriver().getWindowHandles().size() - 1);



            Selenide.sleep(3000);
            String actualStatusCheckedIn = $x("//dt[text()='Status:']/following-sibling::dd[@class='subject']").shouldBe(visible).getText();
            Assertions.assertEquals("CheckedIn", actualStatusCheckedIn , "Status is not 'CheckedIn'!");



        shipmentPage.shipmentStatusShipped(Shipments.builder()
                .shippedAt("")
                .pressButtonNextStatus("")
                .build());



        Selenide.sleep(3000);
        String actualStatusShipped = $x("//dt[text()='Status:']/following-sibling::dd[@class='subject']").shouldBe(visible).getText();
        Assertions.assertEquals("Shipped",actualStatusShipped, "Status is not 'Shipped'!");


        shipmentPage.newStatusReceived(Shipments.builder().build());
        Selenide.sleep(3000);
        Selenide.refresh();
        String actualStatusReceived = $x("//dt[text()='Status:']/following-sibling::dd[@class='subject']").shouldBe(visible).getText();
        Assertions.assertEquals("Received",actualStatusReceived, "Status is not 'Received'!");

        $x("//a[contains(@href, '/flow/deals#')]").click();


        Selenide.switchTo().window(WebDriverRunner.getWebDriver().getWindowHandles().size() - 1);

        $x("//a[@data-action='pageReview.pageReviewoperationsNav']").click();


        Selenide.sleep(2000);



//Проверка статуса на 'Material Movement
//        SelenideElement statusElement = $x("//tr[td/span[text()='Material Movement']]/td[@class='status']//span");
////Ожидаем процессинга
//        statusElement.shouldBe(Condition.visible)
//                .shouldHave(Condition.text("Processing"));
//        String actualStatusMovement = statusElement.getText();
//        Assertions.assertTrue(actualStatusMovement.contains("Processing "), "Operation status does not contain 'Processing '!");
////После получения статуса выполняем операцию по 'Material Movement'
//        materialMovementOperation.MaterialMovement();



//Получаем ответ 200,статус перешел в Accounted
refresh();
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
//Проверяем что статус Processing
        SelenideElement statusElement2 = $x("//tr[td/span[text()='Sales Order']]/td[@class='status']//span");
        statusElement2.shouldBe(Condition.visible)
                .shouldHave(Condition.text("Processing "));
        String statusElementTwo = statusElement2.getText();
        Assertions.assertTrue(statusElementTwo.contains("Processing "), "Operation status does not contain 'Processing '!");
//Выполняем операцию
        salesOrderOperation.salesOperation();
//После выполнения делаем рефреш и проверяем статус


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
        Selenide.refresh();
//Ожидаем перехода статуса в Processing
        SelenideElement statusElement4 = $x("//tr[td/span[text()='Confirm Delivery']]/td[@class='status']//span");
        statusElement4.shouldBe(Condition.visible)
                .shouldHave(Condition.text("Processing "));
        String statusElementFour = statusElement4.getText();
        Assertions.assertTrue(statusElementFour.contains("Processing "), "Operation status does not contain 'Processing '!");
        //Выполняем операцию:
        SaleOrderConfirm.SaleOrder();

        Selenide.refresh();
        SelenideElement statusElement5= $x("//tr[td/span[text()='Confirm Delivery']]/td[@class='status']");
        statusElement5.shouldBe(Condition.visible)
                .shouldHave(Condition.text("Accounted "));
        String statusElementFive = statusElement5.getText();
        Assertions.assertTrue(statusElementFive.contains("Accounted "), "Operation status does not contain 'Accounted '!");
    }
}


//
//}
//
//
