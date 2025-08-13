package tests;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.DealPage;
import pages.ShipmentPage;
import salesObjects.Deals;
import salesObjects.Shipments;

import java.time.LocalDate;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static utils.ConfigProperties.geProperty;

public class CheckMaterialMovementTests {
    private DealPage dealPage;
    private ShipmentPage shipmentPage;

public CheckMaterialMovementTests() {

}

    @Test
    public void CanCheckStatusMovement (){
        ShipmentPage shipmentPage = page(ShipmentPage.class);
        DealPage dealPage = page(DealPage.class);
        MaterialMovementOperation materialMovementOperation = new MaterialMovementOperation();
        MaterialCanceled materialCanceled = new MaterialCanceled();

        Configuration.browserSize = "1920x1080";
        open("https://dev.eurochem.ru/flow/deals#All/new");
        Selenide.refresh();
        $(By.id("login")).setValue(geProperty("web.username"));
        $(By.id("password")).setValue(geProperty("web.password"));
        $(By.xpath("//input[@value='Войти']")).click();

        Selenide.switchTo().window(WebDriverRunner.getWebDriver().getWindowHandles().size() - 1);
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



        String status;
        String previousStatus = "";

        do {
            status = $x("//span[@class='state']").getText();
            System.out.println("Текущий статус: " + status);
            if (status.equals(previousStatus)) {
                System.out.println("Статус не изменился. Обновление страницы...");
                Selenide.refresh();
                sleep(5000);  // Ждем несколько секунд перед следующим обновлением
            } else {
                // Если статус изменился, сохраняем его в переменную previousStatus
                previousStatus = status;
            }

            // Продолжаем цикл, если статус не "Accounted"
        } while (!status.equals("Confirmed"));

        System.out.println("Статус изменился на 'Confirmed'. Операция завершена.");





        String status1 = $x("//span[@class='state']")
                .getText();
        if (status1.equals("Land Costs Input")) {
            $x("//a[@data-action='pageReview.workflow-approve']").click();

        } else if (status1.equals("Confirmed")) {

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

        $x("//a[contains(@href, '/flow/deals#')]").click();
        Selenide.switchTo().window(WebDriverRunner.getWebDriver().getWindowHandles().size() - 1);
        $x("//a[@data-action='pageReview.pageReviewoperationsNav']").click();






Selenide.sleep(3000);


        Selenide.refresh();



//        SelenideElement statusElement = $x("//tr[td/span[text()='Material Movement']]/td[@class='status']//span");
////Ожидаем процессинга
//        statusElement.shouldBe(Condition.visible)
//                .shouldHave(Condition.text("Processing"));
//        String actualStatusMovement = statusElement.getText();
//        Assertions.assertTrue(actualStatusMovement.contains("Processing "), "Operation status does not contain 'Processing '!");
////После получения статуса выполняем операцию по 'Material Movement'
//        materialMovementOperation.MaterialMovement();


Selenide.refresh();
        SelenideElement statusElement1 = $x("//tr[td/span[text()='Material Movement']]/td[@class='status']//span");

        statusElement1.shouldBe(Condition.visible)
                .shouldHave(Condition.text("Accounted "));
        String actualStatusMovement1 = statusElement1.getText();
        Assertions.assertTrue(actualStatusMovement1.contains("Accounted "), "Operation status does not contain 'Accounted '!");




        $(By.xpath("//a[@data-action='pageOperations.undo']")).click();
        Selenide.confirm("Are you sure?");
        Selenide.sleep(1000);
        Selenide.refresh();


        MaterialCanceled.MaterialMovementСanceled();








        Selenide.refresh();
        SelenideElement statusCancel = $x("//tr[td/span[text()='Material Movement']]/td[@class='status']//span");

        statusCancel.shouldBe(Condition.visible)
                .shouldHave(Condition.text("Discarded "));

        Selenide.closeWebDriver();



//        SelenideElement statusElement = $x("//tr[td/span[text()='Material Movement']]/td[@class='status']//span");
//
//
////        statusElement.shouldBe(Condition.visible)
////                .shouldHave(Condition.text("Accounted"));
////
//         Либо извлечь текст и проверить через регулярное выражение
////        String actualStatusMovement = statusElement.getText();
////        Assertions.assertTrue(actualStatus.contains("Accounted"), "Operation status does not contain 'Accounted'!");
////
////       $x("//tr[@class='section Success']//a[@data-action='pageOperations.undo']").click();
//        switchTo().alert().accept();
////
////        for (String tab : Selenide.webdriver().object().getWindowHandles()) {
//             Переключаемся на каждую вкладку
////            Selenide.webdriver().object().switchTo().window(tab);
//             Закрываем текущую вкладку
////            Selenide.webdriver().object().close();
////        }
////
//         Завершаем работу WebDriver
//        Selenide.closeWebDriver();

    }
}



