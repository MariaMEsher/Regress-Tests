package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import pages.InvoicePage;
import pages.ShipmentPage;
import pages.TransportPage;
import salesObjects.Invoice;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CheckCeatingInvoiceTests {
    private TransportPage transportPage;
    private ShipmentPage shipmentPage;
    private InvoicePage invoicePage;

//Переходим в шипмент со статусом invoiced
//Проверяем что статус у транспортных инвойсов delivered
//Нажимаем на создание инвойса
//Добавляем данные нажимаем на save,проверяем статус draft
//Нажимаем на Book
//Проверяем статус pending
///Выполняем операцию
//Смотрим что у инвойсов есть значок 'Inv'
///




    @Test
    public void CanCheckCreateInvoice(){

InvoicePage invoicePage = page(InvoicePage.class);
        Configuration.browserSize = "1920x1080";
        open("https://dev.eurochem.ru/flow/transports#All/2754913?gordeev");
        $(By.id("login")).setValue("meshcheriakovame@suek.ru");
        $(By.id("password")).setValue("klaKplak5375097");
        $(By.xpath("//input[@value='Войти']")).click();

        //Проверяем что статус у транспортных инвойсов delivered


        String actualStatusCost = $x("//*[@id='Costs']//td[text()='Pending']").shouldBe(visible).getText();
        Assertions.assertTrue(actualStatusCost.equals("Delivered") || actualStatusCost.equals("Pending"),
                "Status is neither 'Delivered' nor 'Pending'! Actual status: " + actualStatusCost);

//Открываем tadas интерфейс

invoicePage.createInvoice(Invoice.builder()
                .buttonCreateInvoice("")
        .build());
    }

}



