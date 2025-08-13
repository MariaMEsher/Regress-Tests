package tests;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.DealPage;
import pages.ShipmentPage;
import pages.TransportPage;
import salesObjects.Shipments;
import salesObjects.Transports;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static utils.ConfigProperties.geProperty;

public class CheckСreatingTransportationсCostsTests {
        private TransportPage transportPage;
        private ShipmentPage shipmentPage;

public CheckСreatingTransportationсCostsTests(){

}

    @Test
    public void CanAddCosts() {
            TransportPage transportPage = page(TransportPage.class);
            ShipmentPage shipmentPage = page(ShipmentPage.class);
            DealPage dealPage =page(DealPage.class);

        Configuration.browserSize = "1920x1080";
open("https://dev.eurochem.ru/flow/transports#Invoiced");
refresh();
        $(By.id("login")).setValue(geProperty("web.username"));
        $(By.id("password")).setValue(geProperty("web.password"));
        $(By.xpath("//input[@value='Войти']")).click();



shipmentPage.searchShipmentInTheList(Shipments.builder()

                .build());


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


        Selenide.sleep(10000);
//        Selenide.refresh();
//            String actualStatusCost = $x("//*[@id='Costs']//td[text()='Pending']").shouldBe(visible).getText();
//            Assertions.assertEquals("Pending", actualStatusCost, "Status is not 'Pending'!");
//            Selenide.closeWebDriver();




        Selenide.closeWebDriver();


    }
}
