package salesObjects;
import lombok.Builder;

@Builder
public class Shipments {

    private String selectQuantity;
    private String search;
    private String dateShipment;
    private String spot;
    private String cancelShipment;
    private String openShipment;
    private String fillingFieldSpotFreight;
    private String dateNewTransports;
    private String descriptionButton;
    private String saveButtonShipment;
    private String openShipmentsInTransports;
    private String shipmentVessel;
    private String vesselTypeShipment;
    private String shipmentWaybill;
private String shipmentNet;
private String shipmentGrossWeight;
private String checkedInAt;
private String planDate;
private String pressButtonNextStatus;
private String confirmShipmentOnTranspots;
private String shippedAt;
private String confirmationFromRequstStatus;
private String input;
    public static String text;
private String searchDealId;
private String quantityPerTransfer;
private String capacity;
private String blockSchedule;
private String atTerminal;


public String getAtTerminal(){
    return atTerminal;
}

public String getBlockSchedule(){
    return blockSchedule;
}

public String getCapacity(){
    return capacity;
}
//input[@id='shipment.quantityPerTransfer']


    public  String getQuantityPerTransfer() {
        return quantityPerTransfer;

    }
public String getInput(){
    return input;
}
    public static String getText(){
        return text;

    }
public String getPressButtonNextStatus() {
    return pressButtonNextStatus;
}


public String getSearchDealId() {
    return searchDealId;
}

public String getShipmentNet(){
    return shipmentNet;
}

    public String getShipmentWaybill() {
        return shipmentWaybill;
    }

    public String getSelectQuantity() {
        return selectQuantity;
    }

    public String getSearch() {
        return search;
    }

    public String getDateShipment() {
        return dateShipment;
    }

    public String getSpot() {
        return spot;
    }

    public String getCancelShipment() {
        return cancelShipment;
    }

    public String getOpenShipment() {
        return openShipment;
    }

    public String getFillingFieldSpotFreight() {
        return fillingFieldSpotFreight;
    }

    public String getDateNewTransports() {
        return dateNewTransports;
    }

    public String getDescriptionButton() {
        return descriptionButton;
    }

    public String getSaveButtonShipment() {
        return saveButtonShipment;

    }

    public String getOpenShipmentsInTransports() {
        return openShipmentsInTransports;
    }

    public String getShipmentVessel() {
        return shipmentVessel;
    }

    public String getVesselTypeShipment() {
        return vesselTypeShipment;

    }
    public String getShipmentGrossWeight(){
    return shipmentGrossWeight;
    }
    public String getCheckedInAt() {
    return checkedInAt;
    }
public String getPlanDate() {
    return planDate;
}

public String getConfirmShipmentOnTranspots() {
    return confirmShipmentOnTranspots;
}
public String getShippedAt(){
    return shippedAt;
}
public String getConfirmationFromRequstStatus(){
    return confirmationFromRequstStatus;
}
}