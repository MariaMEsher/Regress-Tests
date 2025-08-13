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
public class RailBulkDryTests {

    @Test
    public void RailRegress(){
        DealPage dealPage = page(DealPage.class);
        ShipmentPage shipmentPage = page(ShipmentPage.class);
        SalesOrderOperation salesOrderOperation = new SalesOrderOperation();
        MaterialMovementOperation materialMovementOperation = new MaterialMovementOperation();
        SaleOrderConfirm saleOrderConfirm = new SaleOrderConfirm();
        assertTrue(true);


        Configuration.timeout = 15000;
        open("https://dev.eurochem.ru/flow/deals#All/711915");
        $(By.id("login")).setValue(geProperty("web.username"));
        $(By.id("password")).setValue(geProperty("web.password"));
        $(By.xpath("//input[@value='Войти']")).click();

$x("//a[@data-action='roleOwner.roleOwnerToolbarcopyNav']").click();
$x("//input[@id='deal.makeTo']").click();
$x("//li[@data-id='M2S']").click();
$x("//input[@id='deal.delayReasonType']").click();
$x("//li[@data-id='7']").click();
$x("//input[@name='deal.reasonDetails']").click();
        $x("//input[@name='deal.reasonDetails']").setValue("test");
        $x("//input[@id='deal.deliveryLocation']").click();
        $x("//input[@id='deal.deliveryLocation']").setValue("Beslan");
        $x("//li[@data-id='538500']").click();
        $x("//input[@id='deal.trader']").click();
        $x("//input[@id='deal.trader']").setValue("Mariya Meshcheriakov");
        $x("//li[@data-id='79755']").click();
//        $x("//input[@id='deal.assistant']").click();
//        $x("//input[@id='deal.assistant']").setValue("Mariya Meshcheriakova");
//        $x("//li[@data-id='79755']").click();
        $x("//input[@id='deal.category']").click();
        $x("//li[@data-id='1']").click();
$x("//input[@id='deal.culture']").click();
$x("//li[@data-id='60']").click();
$x("//input[@id='deal.traderResponsible']").click();
        $x("//input[@id='deal.traderResponsible']").setValue("Mariya Meshcheriakov");
        $x("//li[@data-id='79755']").click();
//        $x("//input[@id='deal.supplierResponsible']").click();
//        $x("//input[@id='deal.supplierResponsible']").setValue("Meshcheriakova");
//        $x("//li[@data-id='79755']").click();

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
$x("//a[@data-action='pageReview.Modify']").click();


$x("//input[@id='deal.supplierResponsible']").click();
        $x("//input[@id='deal.supplierResponsible']").setValue("Mariya Meshcheriakov");
        $x("//li[@data-id='79755']").click();


$x("//input[@id='contractsForm.trader.out.contract']").click();


        $x("//input[@id='contractsForm.trader.out.contract']").setValue("E350-000004601");
$x("//li[@data-id='489588']").click();

        $x("//input[@id='contractsForm.customer.out.contract']").setValue("E200-000009102");
        $x("//li[@data-id='489212']").click();
        $x("//input[@id='contractsForm.trader.out.contract']").click();
        $x("//header[@class='title group sticky']//a[@class='button primary']").click();
        $x("//a[@data-action='pageReview.workflow-approve']").click();
        open("https://jira.digtp.com/browse/STM-2157");
        $x("//input[@type='text']").click();
        $x("//input[@type='text']").setValue("meshcheria");
        $x("//li[@data-id='79755']").click();
        $x("//a[@data-action='pageReview.pageReviewToolbareditNav']").click();
        String financialControl = $x("//input[@name='person.scopes.financialControl']").shouldBe(visible).getText();
//        Assertions.assertEquals(ex);

        Selenide.sleep(540000);





    }
}

