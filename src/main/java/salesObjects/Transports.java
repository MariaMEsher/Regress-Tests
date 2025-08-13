package salesObjects;



import lombok.Builder;
@Builder
public class Transports {
    private String searchOnPage;
private String openShipmentInDeal;
private String openTransportsOnDeals;
private String modifyTransportsCosts;
private String addNewTransportsCosts;
private String selectServiceCosts;
private String addQuantityTransportCosts;
private String addCarrierTransportCosts;
private String selectCarrier;
private String addPayer;
private String addPayerUnit;
private String unitMeasure;
private String unitSelect;
private String addAmount;
private String addCurrency;
private String addCurrencyUsd;
private String saveAndCreateAccrual;



    public String getSearchOnPage() {
        return searchOnPage;
    }

    public String getOpenTransportsOnDeals(){
        return openTransportsOnDeals;

    }


    public String getOpenShipmentInDeal(){
        return openShipmentInDeal;
    }


    public String getModifyTransportsCosts(){
        return modifyTransportsCosts;
    }

    public String getAddNewTransportsCosts(){
        return addNewTransportsCosts;
    }
    public String getSelectServiceCosts(){
        return selectServiceCosts;
    }
    public String getAddQuantityTransportCosts(){
        return addQuantityTransportCosts;
    }
    public String getAddCarrierTransportCosts(){
        return addCarrierTransportCosts;
    }
    public String getSelectCarrier(){
        return  selectCarrier;
    }
    public String getAddPayer() {
        return addPayer;
    }
    public String getAddPayerUnit(){
        return addPayerUnit;
    }
    public String getUnitMeasure(){
        return unitMeasure;
    }
    public String getUnitSelect(){
        return unitSelect;
    }
            public String getAddAmount(){
        return addAmount;
            }
            public String getAddCurrency(){
        return addCurrency;
            }
            public String getAddCurrencyUsd(){
        return addCurrencyUsd;
            }
            public String getSaveAndCreateAccrual(){
        return saveAndCreateAccrual;
            }
}







//        addCurrencyUsd.click();