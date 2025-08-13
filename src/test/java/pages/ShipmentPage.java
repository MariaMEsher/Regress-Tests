package pages;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import salesObjects.Shipments;
import tests.XmlGenerator;

import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ShipmentPage {

    @FindBy(xpath = "//input[@id='shipment.parts.0.quantity']")
    public SelenideElement ClickQuantity;

    @FindBy(xpath = "//input[@type='text']")
    public SelenideElement selectText;

    @FindBy(xpath = "//ol[@id='entries']//li[1]")
    public SelenideElement clickDeal;


    @FindBy(xpath = "//input[@id='shipment.checkedInScheduled']")
    public SelenideElement checkedInDate;

    @FindBy(xpath = "//input[@id='shipment.shippedScheduled']")
    public SelenideElement shippedDate;

    @FindBy(xpath = "//input[@id='shipment.receivedScheduled']")
    public SelenideElement receivedDate;

    @FindBy(xpath = "//input[@id='shipment.spotFreight']")
    public SelenideElement spotFreight;

    @FindBy(css = ".today > a")
    public SelenideElement planCheckedInDate;

    @FindBy(css = ".today > a")
    public SelenideElement planShippedDate;

    @FindBy(css = ".today > a")
    public SelenideElement planReceivedDate;

    @FindBy(xpath = "//*[@id='Shipments']/header/div/a")
    public SelenideElement openShipmentInDeal;

    @FindBy(xpath = "//textarea[@name='shipment.productCustomDescription']")
    public SelenideElement productDescriptionInvoice;

    @FindBy(xpath = "//header[@class='title group']//a[@data-action='pageShipmentForm.save']")
    public SelenideElement saveButtonPageTransports;

    @FindBy(xpath = "//a[@data-action='pageReview.cancel-transport']")
    public SelenideElement cancelTransports;

    @FindBy(xpath = "//a[contains(@class, 'button') and contains(@class, 'primary')]")
    public SelenideElement yes;

    @FindBy(xpath = "//a[@data-action='pageReview.confirm-shipment']")
    public SelenideElement confirmationFromDraftStatus;

    @FindBy(xpath = "//a[@data-action='pageReview.mark-transport-as']")
    public SelenideElement confirmationFromRequestStatus;

    @FindBy(xpath = "//*[@id='Review']//td[1]")
    public SelenideElement openShip;


    @FindBy(xpath = "//input[@id='shipment.vessel']")
    public SelenideElement shipmentVessel;


    @FindBy(xpath = "//li[@data-id='5']//a[text()='[General] RUBYN / 8511885']")
    public SelenideElement selectShipmentVessel;

    @FindBy(xpath = "//li[@data-id='18']//a[text()='[General] Agaete / 9044932']")
    public SelenideElement selectShipmentVesselType;


    @FindBy(xpath = "//input[@id='shipment.vesselType']")
    public SelenideElement typeVessel;

    @FindBy(xpath = "//li[@data-id='Barge']")
    public SelenideElement typeVesselSelect;
    //под создание шипмента и переключение на следующий статус

    @FindBy(xpath = "//input[@name='shipment.transfers.0.waybill']")
    public SelenideElement shipmentWaybill;

    @FindBy(xpath = "//input[@id='shipment.transfers.0.netWeight']")
    public SelenideElement shipmentNetWeight;

    @FindBy(xpath = "//input[@id='shipment.transfers.0.grossWeight']")
    public SelenideElement shipmentGrossWeight;

    @FindBy(xpath = "//input[@id='shipment.checkedInAt']")
    public static SelenideElement checkedInAt;

    @FindBy(xpath = "//input[@id='shipment.receivedAt']")
    public SelenideElement receivedDateShipment;

    //@FindBy(xpath = "//a[@data-method='select' and text()='" + currentDay + "']")
   // public SelenideElement planDate;

    @FindBy(xpath = "//a[@data-action='save-and-mark-shipment-as']")
    public SelenideElement pressButtonNextStatus;


    @FindBy(xpath = "//input[@type='text']")
    public SelenideElement enteringTextIntoTheSearchBar;


    @FindBy(xpath = "//ol[@id='entries']//li[1]")
    public SelenideElement clickOnTheFoundShipment;


    @FindBy(xpath = "//input[@id='shipment.shippedAt']")
    public SelenideElement shippedAt;

    @FindBy(xpath = " //div[@class='subfield input text']")
    public SelenideElement inputType;

    //div[@class='subfield input text']

    @FindBy(xpath = "//input[@name='shipment.vesselIdentifier']")
    public SelenideElement Vehicle;



    @FindBy(xpath = "//input[@name='shipment.cargoIdentifier']")
    public SelenideElement trailerPlates;

    @FindBy(xpath = "//input[@name='shipment.carBrand']")
    public SelenideElement carBrand;



    @FindBy(xpath = "//input[@id='shipment.transfers.0.section']")
    public SelenideElement wSection;

    @FindBy(xpath = "//li[@data-id='905']")
    public SelenideElement wSectionNumber;

    @FindBy(xpath = "//input[@name='shipment.transfers.0.sealIdentifier']")
    public SelenideElement  sealID;

    @FindBy(xpath = "//input[@id='shipment.transfers.0.tareWeight']")
    public SelenideElement  tareW;

    @FindBy(xpath = "//input[@name='shipment.driverIdentifier']")
    public SelenideElement  driverName;

    @FindBy(xpath = "//input[@name='search.dealId']")
    public SelenideElement searchDealId;


    @FindBy(xpath = "//input[@id='shipment.quantityPerTransfer']")
    public SelenideElement quantityPerTransfer;


    @FindBy(xpath = "//input[@id='shipment.maxCapacity']")
    public SelenideElement capacity;


    @FindBy(xpath = "//input[@id='shipment.atTerminalScheduled']")
    public SelenideElement atTerminal;

    @FindBy(xpath = "input[@id='shipment.atTerminalAt']")
public SelenideElement atTerminalAt;







    public void blockSchedule(String text) {



        String status = checkedInAt.getText();
        int currentDay = LocalDate.now().getDayOfMonth();

        if (status.equals(String.valueOf(currentDay))) {
            $x("//a[@data-method='select' and text()='" + currentDay + "']").click();
        } else if (status.equals("Date Field")) {
            // добавьте логику для обработки случая "Date Field"
        }

//        checkedInAt.click();
//        int currentDay = LocalDate.now().getDayOfMonth();
//        $x("//a[@data-method='select' and text()='" + currentDay + "']").click();



        atTerminal.click();
        int terminal = LocalDate.now().getDayOfMonth();
        $x("//a[@data-method='select' and text()='" + terminal + "']").click();

        atTerminalAt.click();
        int terminalAt = LocalDate.now().getDayOfMonth();
        $x("//a[@data-method='select' and text()='" + terminalAt + "']").click();

        shipmentWaybill.click();
        shipmentWaybill.setValue(text).pressTab();


        receivedDateShipment.click();
        int ReceivedDay = LocalDate.now().getDayOfMonth();
        $x("//a[@data-method='select' and text()='" + ReceivedDay + "']").click();







        atTerminal.click();
        $x("//a[@data-method='select' and text()='" + "//input[@id='shipment.atTerminalScheduled']" + "']").click();
//


        shippedAt.click();
        int ShippedDay = LocalDate.now().getDayOfMonth();
        $x("//a[@data-method='select' and text()='" + ShippedDay + "']").pressTab();

    }




public void block(Shipments shipments) {
    blockSchedule(shipments.getBlockSchedule());





    //C103-N1
















    }

    public void  quantityTransfer(String text) {
        quantityPerTransfer.click();
        quantityPerTransfer.setValue(text);

    }



    public void selectShipmentVesselType(String text){
        shipmentVessel.click();
        selectShipmentVesselType.click();
        capacity.click();
        capacity.setValue(text);


    }
public void searchDealId(String text) {
    searchDealId.click();

}
    public void searchBar(String text) {
        Selenide.refresh();
        enteringTextIntoTheSearchBar.click();
        enteringTextIntoTheSearchBar.setValue(text);
        clickOnTheFoundShipment.click();
    }


    public void searchShipmentInTheList(Shipments shipments){
        searchBar(Shipments.getText());
    }

    public static void checkedInAtShipments(String string) {
        checkedInAt.click();
        int currentDay = LocalDate.now().getDayOfMonth();
     $x("//a[@data-method='select' and text()='" + currentDay + "']").click();
    }


    public void shippedAtShipments(String string) {
        shippedAt.click();
        int ShippedDay = LocalDate.now().getDayOfMonth();
        $x("//a[@data-method='select' and text()='" + ShippedDay + "']").click();
    }

    public void shipmentStatusReceived(Shipments shipments) {
//        receivedDateShipment.click();
//        int ReceivedDay = LocalDate.now().getDayOfMonth();
//        $x("//a[@data-method='select' and text()='" + ReceivedDay + "']").click();
        button(shipments.getPressButtonNextStatus());
    }
public void newStatusReceived(Shipments shipments) {
    button(shipments.getPressButtonNextStatus());
}

    public void button(String string) {
        pressButtonNextStatus.click();
        yes.click();
    }

public void shipmentWaybill(String text) {
    shipmentWaybill.click();
    shipmentWaybill.setValue(text).pressTab();

}
public void shipmentNet(String text){
    shipmentNetWeight.click();
    shipmentNetWeight.setValue(text).pressTab();
}

public void shipmentGross(String text){
    shipmentGrossWeight.click();
    shipmentGrossWeight.setValue(text).pressTab();

}

    public void confirm(String string) {
    confirmationFromDraftStatus.click();
        yes.click();
}

public void confirmShipment(Shipments shipments){
    confirm(shipments.getConfirmShipmentOnTranspots());

}

public void nextStatusAfterRequest(Shipments shipments) {
    confirmationFromRequestStatus.click();
    yes.click();
}
public void openShipmentsInTransports(String openShipmentsInTransports){
    openShip.click();

}

public void vesselTypeShipment(String text) {
    typeVessel.click();
    typeVesselSelect.click();

}

public void selectVessel(String string) {
    shipmentVessel.click();
    selectShipmentVessel.click();
}

    public void openShipment(String string) {
        openShipmentInDeal.click();
    }

    public void createShipmentForMultipleOperation(Shipments shipments){
        openShipment(shipments.getOpenShipment());
        Selenide.switchTo().window(WebDriverRunner.getWebDriver().getWindowHandles().size() - 1);
        fillingFieldSpotFreight(shipments.getFillingFieldSpotFreight());
        dateNewTransports(shipments.getDateNewTransports());
        SelectQuantity(shipments.getSelectQuantity());
        descriptionButton(shipments.getDescriptionButton());
        saveButtonShipment(shipments.getSaveButtonShipment());


    }



    public void fillingFieldSpotFreight(String text) {
        spotFreight.click();
        spotFreight.sendKeys(text);

    }
    public void dateNewTransports(String string){
        checkedInDate.click();
    planCheckedInDate.click();
        shippedDate.click();
    planShippedDate.click();
        receivedDate.click();
    planReceivedDate.click();


}

public void descriptionButton(String string) {
    productDescriptionInvoice.click();

}

public void saveButtonShipment(String string) {
    saveButtonPageTransports.click();
}


public void cancelShipment(String string) {
    cancelTransports.click();
    yes.click();

}




public void shipmentStatusCheckedIn (Shipments shipments){
    shipmentWaybill(shipments.getShipmentWaybill());
    shipmentNet(shipments.getShipmentNet());
    shipmentGross(shipments.getShipmentGrossWeight());
    checkedInAtShipments(shipments.getCheckedInAt());
    button(shipments.getPressButtonNextStatus());



}

public void inputTypeText(String text) {
    inputType.click();
}


public void shipmentStatusRequest(Shipments shipments) {

    openShipment(shipments.getOpenShipment());
    Selenide.switchTo().window(WebDriverRunner.getWebDriver().getWindowHandles().size() - 1);
    fillingFieldSpotFreight(shipments.getFillingFieldSpotFreight());
    dateNewTransports(shipments.getDateNewTransports());
    SelectQuantity(shipments.getSelectQuantity());
    descriptionButton(shipments.getDescriptionButton());
    saveButtonShipment(shipments.getSaveButtonShipment());


}
public void createNewShipmenForVessel(Shipments shipments) {
    openShipment(shipments.getOpenShipment());
    Selenide.switchTo().window(WebDriverRunner.getWebDriver().getWindowHandles().size() - 1);
    fillingFieldSpotFreight(shipments.getFillingFieldSpotFreight());
    quantityTransfer(shipments.getQuantityPerTransfer());
    dateNewTransports(shipments.getDateNewTransports());
    SelectQuantity(shipments.getSelectQuantity());
    searchDealId(shipments.getSearchDealId());
    saveButtonShipment(shipments.getSaveButtonShipment());

}


    public void shipmentStatusNewRequest(Shipments shipments) {

        openShipment(shipments.getOpenShipment());
        Selenide.switchTo().window(WebDriverRunner.getWebDriver().getWindowHandles().size() - 1);
        fillingFieldSpotFreight(shipments.getFillingFieldSpotFreight());
        dateNewTransports(shipments.getDateNewTransports());
        SelectQuantity(shipments.getSelectQuantity());
        inputTypeText(shipments.getInput());
        saveButtonShipment(shipments.getSaveButtonShipment());

    }
public void cancelShipmentOnTransports(Shipments shipments) {
    openShipment(shipments.getOpenShipment());
    Selenide.switchTo().window(WebDriverRunner.getWebDriver().getWindowHandles().size() - 1);
    fillingFieldSpotFreight(shipments.getFillingFieldSpotFreight());
    dateNewTransports(shipments.getDateNewTransports());
    SelectQuantity(shipments.getSelectQuantity());
    descriptionButton(shipments.getDescriptionButton());
    saveButtonShipment(shipments.getSaveButtonShipment());
    cancelShipment(shipments.getCancelShipment());


}



public void shipmentStatusShipped(Shipments shipments){
    shippedAtShipments(shipments.getShippedAt());
    button(shipments.getPressButtonNextStatus());


}
public void shipmentStatusFixed(Shipments shipments) {
    openShipmentsInTransports(shipments.getOpenShipmentsInTransports());
    Selenide.switchTo().window(WebDriverRunner.getWebDriver().getWindowHandles().size() - 1);
    selectVessel(shipments.getShipmentVessel());
    vesselTypeShipment(shipments.getVesselTypeShipment());
    Selenide.sleep(2000);
    button(shipments.getPressButtonNextStatus());

}


public void shipmentForVesselInformation(Shipments shipments){
    openShipmentsInTransports(shipments.getOpenShipmentsInTransports());
    Selenide.switchTo().window(WebDriverRunner.getWebDriver().getWindowHandles().size() - 1);
    selectShipmentVesselType(shipments.getCapacity());
    vesselTypeShipment(shipments.getVesselTypeShipment());
//    button(shipments.getPressButtonNextStatus());

}








public void newShipment(Shipments shipments) {
    openShipmentsInTransports(shipments.getOpenShipmentsInTransports());
    Selenide.switchTo().window(WebDriverRunner.getWebDriver().getWindowHandles().size() - 1);
    Vehicle.click();
    Vehicle.setValue("test");
    trailerPlates.click();
    trailerPlates.setValue("test").pressTab();
    carBrand.click();
    carBrand.setValue("Test").sendKeys(Keys.TAB);
    Selenide.sleep(2000);
    wSection.click();
    wSectionNumber.click();
    sealID.click();
    sealID.setValue("123");
    tareW.click();
    tareW.setValue("123");
    driverName.click();
    driverName.setValue("test");
    shipmentWaybill(shipments.getShipmentWaybill());
    shipmentNet(shipments.getShipmentNet());
    shipmentGross(shipments.getShipmentGrossWeight());
    checkedInAtShipments(shipments.getCheckedInAt());
    button(shipments.getPressButtonNextStatus());
    button(shipments.getPressButtonNextStatus());
    button(shipments.getPressButtonNextStatus());


}
public void newShipmentAbjastment(Shipments shipments) {
    shippedAtShipments(shipments.getShippedAt());
    button(shipments.getPressButtonNextStatus());


    Selenide.sleep(67000);



//    shipmentWaybill(shipments.getShipmentWaybill());
//    shipmentNet(shipments.getShipmentNet());
//    shipmentGross(shipments.getShipmentGrossWeight());
    checkedInAtShipments(shipments.getCheckedInAt());
    button(shipments.getPressButtonNextStatus());
    Selenide.sleep(2000);

}
public void createShipment(Shipments shipments) {
    openShipmentsInTransports(shipments.getOpenShipmentsInTransports());
    Selenide.switchTo().window(WebDriverRunner.getWebDriver().getWindowHandles().size() - 1);
    selectVessel(shipments.getShipmentVessel());
    vesselTypeShipment(shipments.getVesselTypeShipment());
    Selenide.sleep(2000);
    shipmentWaybill(shipments.getShipmentWaybill());
    shipmentNet(shipments.getShipmentNet());
    shipmentGross(shipments.getShipmentGrossWeight());
    checkedInAtShipments(shipments.getCheckedInAt());
    button(shipments.getPressButtonNextStatus());
    button(shipments.getPressButtonNextStatus());
    button(shipments.getPressButtonNextStatus());
    Selenide.sleep(2000);






}



public void newCreateShipment(Shipments shipments) {
    openShipmentsInTransports(shipments.getOpenShipmentsInTransports());
    Selenide.switchTo().window(WebDriverRunner.getWebDriver().getWindowHandles().size() - 1);
    selectVessel(shipments.getShipmentVessel());
    vesselTypeShipment(shipments.getVesselTypeShipment());
    Selenide.sleep(2000);
    shipmentWaybill(shipments.getShipmentWaybill());
    shipmentNet(shipments.getShipmentNet());
    shipmentGross(shipments.getShipmentGrossWeight());
    checkedInAtShipments(shipments.getCheckedInAt());
    Selenide.sleep(2000);
}

public void nextStatus(Shipments shipments){
    shippedAtShipments(shipments.getShippedAt());
    button(shipments.getPressButtonNextStatus());
    button(shipments.getPressButtonNextStatus());
    button(shipments.getPressButtonNextStatus());
    button(shipments.getPressButtonNextStatus());

}
public void statusDraftShipment(Shipments shipments) {
    openShipment(shipments.getOpenShipment());
    Selenide.switchTo().window(WebDriverRunner.getWebDriver().getWindowHandles().size() - 1);
    fillingFieldSpotFreight(shipments.getFillingFieldSpotFreight());
    dateNewTransports(shipments.getDateNewTransports());
    SelectQuantity(shipments.getSelectQuantity());
    descriptionButton(shipments.getDescriptionButton());
    saveButtonShipment(shipments.getSaveButtonShipment());


}





//    public void createNewTransports(Shipments shipments) {
//        fillingFieldsTransports(shipments.getDateShipment());





    public void SelectQuantity(String text) {

        ClickQuantity.click();
        ClickQuantity.sendKeys(text);
    }




    public void findDealSearch(String text) {
        selectText.click();
        selectText.setValue(text);
        clickDeal.click();


    }
    public void searchDeal(Shipments shipments) {
        findDealSearch(shipments.getSearch());
    }



    //$x("//div[@class='subfield input number']//input[@id='shipment.parts.0.quantity']").click();
    //$x("//div[@class='subfield input number']//input[@id='shipment.parts.0.quantity']").setValue("10");
}
