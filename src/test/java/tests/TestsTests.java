package tests;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

import manager.ApplicationManager;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import pages.DealPage;
import pages.ShipmentPage;
import salesObjects.Deals;
import salesObjects.Shipments;
import salesObjects.Transports;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.ConfigProperties.geProperty;

public class TestsTests {
    private ApplicationManager app;

    // Конструктор принимает экземпляр ApplicationManager
    public void LoginPage() {
    }

    private Shipments shipments;
    private Deals deals;
    private Transports transports;

    public void testMethod() {
    }

    @Test
    public void AnyTests() {
        Configuration.timeout = 15000;
        SalesOrderOperation salesOrderOperation =new SalesOrderOperation();
        MaterialMovementOperation materialMovementOperation = new MaterialMovementOperation();
        SaleOrderConfirm saleOrderConfirm = new SaleOrderConfirm();
        DealPage dealPage = page(DealPage.class);
        Configuration.browserSize = "1920x1080";
        open("https://dev.eurochem.ru/flow/deals#All/902258/operations");
        $(By.id("login")).setValue(geProperty("web.username"));
        $(By.id("password")).setValue(geProperty("web.password"));
        $(By.xpath("//input[@value='Войти']")).click();

//        String actualStatus = $x("//header[@class='title group']//span[@class='state']").shouldBe(visible).getText();
//        Assertions.assertEquals("Draft", actualStatus, "Status is not 'Draft'!");



        SelenideElement statusElement = $x("//tr[td/span[text()='Material Movement']]/td[@class='status']//span");

//
    }
}











//        // Найти все строки таблицы
//        ElementsCollection rows = (ElementsCollection) $x("//div[@class='collection']");
//
//        // Пройтись по строкам и вывести содержимое каждой ячейки
//        for (SelenideElement row : rows) {
//            ElementsCollection cells = (ElementsCollection) row.$x("td");
//            for (SelenideElement cell : cells) {
//                System.out.print(cell.getText() + " | ");
//            }
//            System.out.println();
//        }
//    }
//}
//
//



//        statusElement.shouldBe(Condition.visible)
//                .shouldHave(Condition.text("Processing"));
//        String actualStatusMovement = statusElement.getText();
//        Assertions.assertTrue(actualStatusMovement.contains("Processing "), "Operation status does not contain 'Processing '!");
//        materialMovementOperation.MaterialMovement();

//
//        Selenide.refresh();
////Получаем ответ 200,статус перешел в Accounted
//
//        SelenideElement statusElement1 = $x("//tr[td/span[text()='Material Movement']]/td[@class='status']//span");
//        statusElement1.shouldBe(Condition.visible)
//                .shouldHave(Condition.text("Accounted"));
////Делаем проверку
//        String statusElementOne = statusElement1.getText();
//        Assertions.assertTrue(statusElementOne.contains("Accounted "), "Operation status does not contain 'Accounted '!");
//
////После перехода проверяем в каком статусе Sales
//        //Делаем рефреш
//        Selenide.sleep(7000);
//        Selenide.refresh();
//
//        SelenideElement statusElement2 = $x("//tr[td/span[text()='Sales Order']]/td[@class='status']//span");
//        statusElement2.shouldBe(Condition.visible)
//                .shouldHave(Condition.text("Processing "));
//        String statusElementTwo = statusElement2.getText();
//        Assertions.assertTrue(statusElementTwo.contains("Processing "), "Operation status does not contain 'Processing '!");
//
//        salesOrderOperation.salesOperation();
//
//
//
//        Selenide.refresh();
//
//
//        SelenideElement statusElement3= $x("//tr[td/span[text()='Sales Order']]/td[@class='status']//span");
//        statusElement3.shouldBe(Condition.visible)
//                .shouldHave(Condition.text("Accounted "));
//        String statusElemenThree = statusElement3.getText();
//        Assertions.assertTrue(statusElemenThree.contains("Accounted "), "Operation status does not contain 'Accounted '!");
//        Selenide.sleep(30000);
//
//
////После выполнения операции переходим к следующей-Confirm Delivery
//        //Ожидаем около 2 секунд и делаем рефреш страницы
//        Selenide.refresh();
////        Selenide.refresh();
//////Ожидаем перехода статуса в Processing
////        SelenideElement statusElement4 = $x("//tr[td/span[text()='Confirm Delivery']]/td[@class='status']//span");
//        SaleOrderConfirm.SaleOrder();
//        Selenide.refresh();
//        SelenideElement statusElement5= $x("//tr[td/span[text()='Confirm Delivery']]/td[@class='status']");
//        statusElement5.shouldBe(Condition.visible)
//                .shouldHave(Condition.text("Accounted "));
//        String statusElementFive = statusElement5.getText();
//        Assertions.assertTrue(statusElementFive.contains("Accounted "), "Operation status does not contain 'Accounted '!");
//
//    }
//    }



//        Selenide.sleep(2000);

//        $x("//input[@name='shipment.transfers.2.waybill']").click();
//        $x("//input[@name='shipment.transfers.2.waybill']").sendKeys("test");
//        Selenide.sleep(2000);
//        $x("//a[@data-action='185']").click();
//
//
//
//        $x("//input[@id='shipment.transfers.0.netWeight']").click();


