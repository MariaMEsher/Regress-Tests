package tests;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;

import manager.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.openqa.selenium.*;
import pages.DealPage;
import pages.ShipmentPage;
import salesObjects.Deals;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.Assert.assertTrue;
import static utils.ConfigProperties.geProperty;

public class FunctionalCostsShipmentTests {


    public FunctionalCostsShipmentTests(){

    }


    @Test
    public void CanCheckCostsShipment(){
        DealPage dealPage = page(DealPage.class);
        ShipmentPage shipmentPage = page(ShipmentPage.class);
        SalesOrderOperation salesOrderOperation = new SalesOrderOperation();
        MaterialMovementOperation materialMovementOperation = new MaterialMovementOperation();
        SaleOrderConfirm saleOrderConfirm = new SaleOrderConfirm();
        Allure.addAttachment("Test Attachment", "This is an attachment example");
        assertTrue(true);


        Configuration.timeout = 15000;
        open("https://dev.eurochem.ru/flow/transports");
        $(By.id("login")).setValue(geProperty("web.username"));
        $(By.id("password")).setValue(geProperty("web.password"));
        $(By.xpath("//input[@value='Войти']")).click();


        $x("//a[@data-action='roleOwner.Costs']").click();
        $x("//input[@id='search.customer']").click();
        $x("//input[@id='search.customer']").setValue("Cibra Trading Inc.");
        $x("//li[@data-id='5400548']").click();
        $x("//input[@id='search.shipmentState']").click();
        $x("//li[@data-id='Invoiced']").click();
        $x("//input[@id='search.carrier']").click();
        $x("//li[@data-id='57076']").click();
        $x("//input[@id='search.payer']").click();
        $x("//li[@data-id='CHTRD']").click();
        $x("//input[@id='search.shippedDateFrom']").click();
        $(".today > a").click();
Selenide.sleep(2000);
        String rowText = $x("//div[contains(text(), 'Transshipment')]").getText();
        System.out.println("Full row text: " + rowText);
        Selenide.closeWebDriver();
    }
}


