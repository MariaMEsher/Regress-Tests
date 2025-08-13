package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;


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

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;
import static utils.ConfigProperties.geProperty;
public class VesselContainerTests {



    public VesselContainerTests() {


    }
    @Test
    public void CheckVesselContainer() {
        DealPage dealPage = page(DealPage.class);
        ShipmentPage shipmentPage = page(ShipmentPage.class);
        SalesOrderOperation salesOrderOperation = new SalesOrderOperation();
        MaterialMovementOperation materialMovementOperation = new MaterialMovementOperation();
        SaleOrderConfirm saleOrderConfirm = new SaleOrderConfirm();
        assertTrue(true);


        Configuration.timeout = 15000;
        open("https://dev.eurochem.ru/flow/deals#All/827267");
        $(By.id("login")).setValue(geProperty("web.username"));
        $(By.id("password")).setValue(geProperty("web.password"));
        $(By.xpath("//input[@value='Войти']")).click();


        Selenide.sleep(1000);

        $x("//header[@class='header']//a[@data-action='roleOwner.roleOwnerToolbarcopyNav']").click();
//        $x("//input[@Id='deal.makeTo']").click();
//        $x("//div[@class='modal']//li[@data-id='M2S']").click();
        $x("//input[@id='deal.delayReasonType']").click();
        $x("//li[@data-id='7']").click();
        $x("//input[@name='deal.reasonDetails']").click();
        $x("//input[@name='deal.reasonDetails']").setValue("test");
        $x("//input[@id='deal.trader']").click();
        $x("//input[@id='deal.trader']").setValue("Meshcheriakova");
        $x("//li[@data-id='79755']").click();
        $x("//input[@id='deal.deliveryLocation']").click();
        $x("//input[@id='deal.deliveryLocation']").setValue("Port Klang");
        $x("//li[@data-id='MY PKG']").click();

        $x("//input[@id='deal.supplierResponsible']").click();
        $x("//input[@id='deal.supplierResponsible']").setValue("Meshcheriakova");
        $x("//input[@id='deal.supplierResponsible']").click();
        $x("//li[@data-id='79755']").click();
//        $x("//input[@name ='deal.notes']").click();
//        Selenide.sleep(1000);
        $x("//header[@class='title group sticky']//a[@class='button primary']").click();

        String actualStatus = $x("//header[@class='title group']//span[@class='state']").shouldBe(visible).getText();
        Assertions.assertEquals("Draft", actualStatus, "Status is not 'Draft'!");
        $x("//a[@data-action='pageReview.workflow-send-to-approval']").click();




        Selenide.sleep(30000);
        Selenide.refresh();

        String status = $x("//span[@class='state']")
                .getText();
        if (status.equals("Land Costs Input")) {
            $x("//a[@data-action='pageReview.workflow-approve']").click();

        } else if (status.equals("Confirmed")) {

        }

//
//
//
//        String actualStatusDeal = $x("//span[@class='state']").shouldBe(visible).getText();
//        Assertions.assertEquals("Confirmed", actualStatusDeal, "Status is not 'Confirmed'!");


        shipmentPage.createNewShipmenForVessel(Shipments.builder()
                .openShipment("")
                .fillingFieldSpotFreight("1")
                .dateNewTransports("")
                .selectQuantity("15")
                        .quantityPerTransfer("5")
                        .confirmShipmentOnTranspots("5")
                .descriptionButton("")
                .saveButtonShipment("")
                .build());
        String CheckStatusShipment = $x("//span[@class='state']").shouldBe(visible).getText();
        Assertions.assertEquals("Draft", CheckStatusShipment, "Draft'!");
//input[@name='search.dealId']

$x("//a[@data-action='pageReview.confirm-shipment']").click();
$x("//a[@class='button primary ']").click();
        $x("//a[@data-action='pageReview.mark-transport-as']").click();
        $x("//a[@class='button primary ']").click();
        Selenide.sleep(1000);
        Selenide.refresh();

        String actualStatusNext = $x("//span[@class='state']").shouldBe(visible).getText();
        Assertions.assertEquals("Fixed", actualStatusNext, "Status is not 'Fixed'!");

        shipmentPage.shipmentForVesselInformation(Shipments.builder()
                .openShipmentsInTransports("")
                .shipmentVessel("")
                .vesselTypeShipment("")
                .shipmentWaybill("Df-1230")
                .pressButtonNextStatus("")
                .build());


        String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
//        $x("input[@id='shipment.atTerminalAt']").click();
//        $x("input[@id='shipment.atTerminalAt']").setValue(currentDate);
//        $x("input[@id='shipment.atTerminalAt']").shouldHave(Condition.value(currentDate));
//        Selenide.sleep(2000);
//        $x("//a[@data-action='185']").click();






        $x("//input[@id='shipment.checkedInAt']").click();
        $x("//input[@id='shipment.checkedInAt']").setValue(currentDate);
        $x("//input[@id='shipment.checkedInAt']").shouldHave(Condition.value(currentDate));

        $x("//input[@id='shipment.transfers.0.tareWeight']").click();
        $x("//input[@id='shipment.transfers.0.tareWeight']").sendKeys("5");



        $x("//input[@id='shipment.transfers.2.section']").click();
        $x("//li[@data-id='C103-N1']").click();

        Selenide.sleep(2000);
        ;


//Gross W. (mt
        $x("//input[@id='shipment.transfers.0.grossWeight']").click();
        $x("//input[@id='shipment.transfers.0.grossWeight']").sendKeys("5");

//cюда дату
        $x("//input[@id='shipment.vessel']").click();

        $x("//input[@id='shipment.atTerminalScheduled']").click();
        $x("//input[@id='shipment.atTerminalScheduled']").setValue(currentDate);
        $x("//input[@id='shipment.atTerminalScheduled']").shouldHave(Condition.value(currentDate));

        $x("//input[@id='shipment.vessel']").click();
        //Container ID
        $x("//input[@name='shipment.transfers.0.cargoIdentifier']").click();
        $x("//input[@name='shipment.transfers.0.cargoIdentifier']").sendKeys("EX11A11F");


        $x("//input[@id='shipment.shippedAt']").click();
        $x("//input[@id='shipment.shippedAt']").setValue(currentDate);
        $x("//input[@id='shipment.shippedAt']").shouldHave(Condition.value(currentDate));
        $x("//a[@data-action='185']").click();
//
//
//        $x("//input[@name='shipment.transfers.0.sealIdentifier']").click();
//        $x("//input[@name='shipment.transfers.0.sealIdentifier']").sendKeys("12/23");
//
//
//
//        $x("//input[@id='shipment.receivedAt']").click();
//        $x("//input[@id='shipment.receivedAt']").setValue(currentDate);
//        $x("//input[@id='shipment.receivedAt']").shouldHave(Condition.value(currentDate));
//        $x("//input[@id='shipment.vessel']").click();
//
//        $x("//input[@id='shipment.transfers.0.netWeight']").click();
//        $x("//input[@id='shipment.transfers.0.netWeight']").sendKeys("5");
//
//        $x("//input[@id='shipment.vessel']").click();
//        $x("//input[@name='shipment.transfers.0.waybill']").click();
//        $x("//input[@name='shipment.transfers.0.waybill']").sendKeys("test");
//        $x("//input[@id='shipment.vessel']").click();
//
//
//
//
//
//        $x("//input[@id='shipment.transfers.1.tareWeight']").click();
//        $x("//input[@id='shipment.transfers.1.tareWeight']").sendKeys("5");
//        $x("//input[@id='shipment.vessel']").click();
//        $x("//input[@name='shipment.transfers.1.waybill']").click();
//        $x("//input[@name='shipment.transfers.1.waybill']").sendKeys("test");
//        $x("//input[@id='shipment.vessel']").click();
//
//
//        $x("//input[@id='shipment.transfers.1.grossWeight']").click();
//        $x("//input[@id='shipment.transfers.1.grossWeight']").sendKeys("5");
//        $x("//input[@id='shipment.vessel']").click();
//        $x("//input[@name='shipment.transfers.1.sealIdentifier']").click();
//        $x("//input[@name='shipment.transfers.1.sealIdentifier']").sendKeys("12/23");
//
//        $x("//input[@id='shipment.vessel']").click();
//        $x("//input[@id='shipment.transfers.1.netWeight']").click();
//        $x("//input[@id='shipment.transfers.1.netWeight']").sendKeys("5");
//        $x("//input[@id='shipment.vessel']").click();
//
//        $x("//input[@id='shipment.vessel']").click();
//        $x("//input[@name='shipment.transfers.1.cargoIdentifier']").click();
//        $x("//input[@name='shipment.transfers.1.cargoIdentifier']").sendKeys("EX11A11F");
//        $x("//input[@id='shipment.vessel']").click();
//        $x("//a[@data-action='185']").click();
//
//
//
//
//        Selenide.sleep(2000);
//
//
//
//        $x("//input[@id='shipment.transfers.2.tareWeight']").click();
//        $x("//input[@id='shipment.transfers.2.tareWeight']").sendKeys("0");
//        $x("//input[@id='shipment.vessel']").click();
//        $x("//input[@name='shipment.transfers.2.waybill']").click();
//        $x("//input[@name='shipment.transfers.2.waybill']").sendKeys("test");
//        $x("//input[@id='shipment.vessel']").click();
//
//
//        $x("//input[@id='shipment.transfers.2.grossWeight']").click();
//        $x("//input[@id='shipment.transfers.2.grossWeight']").sendKeys("0");
//        $x("//input[@id='shipment.vessel']").click();
//        $x("//input[@name='shipment.transfers.2.sealIdentifier']").click();
//        $x("//input[@name='shipment.transfers.2.sealIdentifier']").sendKeys("12/23");
//
//        $x("//input[@id='shipment.vessel']").click();
//        $x("//input[@id='shipment.transfers.2.netWeight']").click();
//        $x("//input[@id='shipment.transfers.2.netWeight']").sendKeys("5");
//        $x("//input[@id='shipment.vessel']").click();
//
//        $x("//input[@id='shipment.vessel']").click();
//        $x("//input[@name='shipment.transfers.2.cargoIdentifier']").click();
//        $x("//input[@name='shipment.transfers.2.cargoIdentifier']").sendKeys("EX11A11F");
//        $x("//input[@id='shipment.vessel']").click();
//
//
//
//        $x("//input[@id='shipment.atTerminalAt']").click();
//        $x("//input[@id='shipment.atTerminalAt']").setValue(currentDate);
//        $x("//input[@id='shipment.atTerminalAt']").shouldHave(Condition.value(currentDate));
//
//
//


//        $x("//a[@data-action='181']").click();
//Selenide.refresh();
//$x("//input[@id='shipment.transfers.0.loadedAt']").click();
//        $x("//input[@id='shipment.transfers.0.loadedAt']").setValue(currentDate);
//        $x("//input[@id='shipment.transfers.0.loadedAt']").click();





//
//
//
//        shipmentPage.block(Shipments.builder()
//                .checkedInAt("")
//                .shippedAt("")
//                .atTerminal("")
//                .shipmentWaybill("5")
//
//
//                .build());
//
//        //li[@data-id='18'].click
//
//
////проставить ожидание






    }
}
