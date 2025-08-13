package tests;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.DealPage;
import pages.ShipmentPage;
import salesObjects.Deals;
import salesObjects.Shipments;

import java.time.Duration;
import java.time.LocalDate;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static utils.ConfigProperties.geProperty;

public class CreatingAdjustmentsTests {
    private DealPage dealPage;

    @Test
    public void CanCreateAbjustments() {
DealPage dealPage = page(DealPage.class);
ShipmentPage shipmentPage = page(ShipmentPage.class);
        Configuration.timeout = 15000;

        Configuration.browserSize = "1920x1080";
        open("https://dev.eurochem.ru/flow/deals#All/834190");
        $(By.id("login")).setValue(geProperty("web.username"));
        $(By.id("password")).setValue(geProperty("web.password"));
        $(By.xpath("//input[@value='Войти']")).click();



        $x("//header[@class='header']//a[@data-action='roleOwner.roleOwnerToolbarcopyNav']").click();
$x("//input[@Id='deal.makeTo']").click();
$x("//div[@class='modal']//li[@data-id='M2S']").click();
$x("//input[@id='deal.delayReasonType']").click();
$x("//li[@data-id='7']").click();
$x("//input[@name='deal.reasonDetails']").click();
        $x("//input[@name='deal.reasonDetails']").setValue("123");
       $x("//input[@name ='deal.referenceIdentifier']").click();
        $x("//input[@name ='deal.referenceIdentifier']").setValue("Test");
        $x("//input[@id='deal.referenceDate']").click();
        $(".today > a").click();
        $x("//input[@id='deal.trader']").click();
        $x("//input[@id='deal.trader']").setValue("Mariya Meshcheriakova");
        $x("//li[@data-id='79755' and contains(@class, 'item')]").click();
        $x("//input[@id='deal.culture']").click();
        $x("//li[@data-id='60']").click();

        $x("//input[@id='contractsForm.trader.out.contract']").click();
        $x("//input[@id='contractsForm.trader.out.contract']").setValue("E110-000000744");
        $x("//li[@data-id='501114']").click();

        $x("//header[@class='title group sticky']//a[@class='button primary']").click();

        $x("//a[@data-action='pageReview.Modify']").click();

        $x("//input[@id='deal.supplierResponsible']").click();
        $x("//input[@id='deal.supplierResponsible']").setValue("Mariya Meshcheriakova");
        $x("//li[@data-id='79755' and contains(@class, 'item')]").click();

        $x("//header[@class='title group sticky']//a[@class='button primary']").click();

        String actualStatus = $x("//header[@class='title group']//span[@class='state']").shouldBe(visible).getText();
        Assertions.assertEquals("Draft", actualStatus, "Status is not 'Draft'!");


        $x("//a[@data-action='pageReview.workflow-send-to-approval']").click();
        Selenide.refresh();


        String actualStatusDeal = $x("//span[@class='state']").shouldBe(visible).getText();
        Assertions.assertEquals("Confirmed", actualStatusDeal, "Status is not 'Confirmed'!");

        shipmentPage.shipmentStatusNewRequest(Shipments.builder()
                .openShipment("")
                .fillingFieldSpotFreight("1")
                .dateNewTransports("")
                .selectQuantity("1")
                .saveButtonShipment("")
                .build());
      $x("//a[@data-action='pageReview.confirm-shipment']").click();
$x("//a[contains(@class, 'button') and contains(@class, 'primary')]").click();
Selenide.sleep(1000);
Selenide.refresh();

        String CheckStatusShipment = $x("//span[@class='state']").shouldBe(visible).getText();
        Assertions.assertEquals("Requested", CheckStatusShipment, "Status is not 'Requested'!");
        shipmentPage.nextStatusAfterRequest(Shipments.builder()
                .confirmationFromRequstStatus("")
                .confirmShipmentOnTranspots("").build());
Selenide.refresh();
        String actualStatusNext = $x("//span[@class='state']").shouldBe(visible).getText();
        Assertions.assertEquals("Fixed", actualStatusNext, "Status is not 'Fixed'!");

        Selenide.switchTo().window(WebDriverRunner.getWebDriver().getWindowHandles().size() - 1);

        shipmentPage.newShipment(Shipments.builder()
                .openShipmentsInTransports("")
                .shipmentVessel("")
                .vesselTypeShipment("")
                .shipmentWaybill("1123")
                .shipmentNet("1")
                .shipmentGrossWeight("1")
                .checkedInAt("")

                .build());
        Selenide.sleep(1000);
Selenide.refresh();
        String actualStatusCheckedIn = $x("//dt[text()='Status:']/following-sibling::dd[@class='subject']").shouldBe(visible).getText();
        Assertions.assertEquals("CheckedIn", actualStatusCheckedIn , "Status is not 'CheckedIn'!");


//        shipmentPage.newShipmentAbjastment(Shipments.builder().build());

        String actualState = $x("//dt[text()='Status:']/following-sibling::dd[@class='subject']").shouldBe(visible).getText();
        Assertions.assertEquals("CheckedIn", actualState , "Status is not 'CheckedIn'!");



    }

}
