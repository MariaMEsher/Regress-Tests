package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import salesObjects.Deals;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class DealPage {
    @FindBy(xpath = "//input[@id='deal.salesUnit']")
    public SelenideElement ClickSalesUnit;

    @FindBy(xpath = "//div[@class='modal']//li[@data-id='CHTRD']")
    public SelenideElement SelectSalesUnit;

    @FindBy(xpath = "//input[@id='deal.salesModel']")
    public SelenideElement ClickSales;

    @FindBy(xpath = "//div[@class='modal']//li[@data-id='Direct']")
    public SelenideElement SelectSalesModel;

    @FindBy(xpath = "//input[@id='deal.agreementDate']")
    public SelenideElement AgreementDate;

    @FindBy(css = ".today > a")
    public SelenideElement TodayAgreementDate;

    @FindBy(xpath = "//input[@id='deal.country']")
    public SelenideElement CustomerDestination;

    @FindBy(xpath = "//div[@class='modal']//li[@data-id='BR']")
    public SelenideElement SelectCountry;

    @FindBy(xpath = "//input[@id='deal.customer']")
    public SelenideElement SelectCustomer;

    @FindBy(xpath = "//div[@class='modal']//li[@data-id='5400548']")
    public SelenideElement InputCustomer;

    //@FindBy(xpath = "//div[@class='modal']//li[@data-id='10000179']")
   // public SelenideElement InputCustomerNew;


    @FindBy(xpath = "//input[@id='deal.currency']")
    public SelenideElement ClickCurrency;

    @FindBy(xpath = "//div[@class='modal']//li[@data-id='USD']")
    public SelenideElement ClickCurrencyUsd;

    @FindBy(xpath = ("//input[@id='deal.paymentTerms']"))
    public SelenideElement ClickPaymentTerms;

    @FindBy(xpath = ("//li[@data-id='100/7 B/L' and contains(@class, 'item')]"))
    public SelenideElement SelectPaymentTerms;


    @FindBy(id = "deal.deliveryStart")
    public static SelenideElement deliveryStart;

    @FindBy(css = ".today > a")
    public static SelenideElement deliveryStartPeriod;

    @FindBy(id = "deal.deliveryEnd")
    public SelenideElement deliveryEnd;

    @FindBy(css = ".next-month")
    public SelenideElement deliveryNextPeriod;


    @FindBy(xpath = "//input[@id='deal.transport']")
    public SelenideElement SelectTransports;

    @FindBy(xpath = "//li[@data-id='Z1-1100' and contains(@class, 'item')]")
    public SelenideElement ClickTransports;

    @FindBy(xpath = "//input[@id='deal.from']")
    public SelenideElement ShipFromSite;
    @FindBy(xpath = "//div[@class='modal']//li[@data-id='647']")
    public SelenideElement ShipFromSiteClick;

    @FindBy(xpath = "//input[@id='deal.deliveryTerms']")
    public SelenideElement DeliveryTerms;

    @FindBy(xpath = "//li[@data-id='CFR' and contains(@class, 'item')]")
    public SelenideElement DeliveryTermsClick;

    @FindBy(xpath = "//textarea[@name='deal.actualDeliveryChangeReason']")
    public SelenideElement ChangeReason;

    @FindBy(xpath = "//input[@id='deal.shipToCompany']")
    public SelenideElement ShipToCompany;

    @FindBy(xpath = "//li[@data-id='5400548' and contains(@class, 'item')]")
    public SelenideElement ShipToCompanySelect;

    @FindBy(xpath = "//input[@id='deal.deliveryLocation']")
    public static SelenideElement DeliveryPoint;

    @FindBy(xpath = "//li[@data-id='BR SSZ' and contains(@class, 'item')]")
    public SelenideElement DeliveryPointSantos;

    @FindBy(xpath = "//input[@id='deal.product']")
    public SelenideElement OrderProduct;

    @FindBy(xpath = "//li[@data-id='443928' and contains(@class, 'item')]")
    public SelenideElement OrderProductClick;

    @FindBy(xpath = "//input[@id='deal.package']")
    public SelenideElement DealPackage;

    @FindBy(xpath = "//li[@data-id='92' and contains(@class, 'item')]")
    public SelenideElement DealPackageClick;

    @FindBy(xpath = "//input[@name ='deal.referenceIdentifier']")
    public SelenideElement ReferenceIdentifier;

    @FindBy(xpath = "//input[@id='deal.referenceDate']")
    public SelenideElement ReferenceDateClick;

    @FindBy(css = ".today > a")
    public SelenideElement ReferenceDateSelect;

    @FindBy(xpath = "//input[@id='deal.trader']")
    public static SelenideElement DealTrader;

    @FindBy(xpath = "//li[@data-id='79755' and contains(@class, 'item')]")
    public static SelenideElement SelectTraderDeal;

    @FindBy(xpath = "//input[@id='deal.assistant']")
    public SelenideElement DealAssistant;

    @FindBy(xpath = "//li[@data-id='42' and contains(@class, 'item')]")
    public SelenideElement DealAssistantSelect;

    @FindBy(xpath = "//input[@id='deal.priceGross']")
    public SelenideElement DealPriceGross;

    @FindBy(xpath = "//input[@id='deal.origin']")
    public SelenideElement DealOriginClick;


    @FindBy(xpath = "//li[@data-id='FOSFORIT' and contains(@class, 'item')]")
    public SelenideElement DealOriginSelect;

    @FindBy(xpath = "//input[@id='deal.quantity']")
    public SelenideElement DealQuantity;

    @FindBy(xpath = "//input[@name ='deal.notes']")
    public static SelenideElement DealNotes;


    @FindBy(xpath = "//header[@class='title group sticky']//a[@class='button primary']")
    public static SelenideElement SaveButton;

    @FindBy(xpath = "//header[@class='title group']//a[@class='button primary']")
    public SelenideElement NegativeSave;

    @FindBy(xpath = "//input[@type='text']")
    public SelenideElement enteringTextIntoTheSearchBar;


    @FindBy(xpath = "//ol[@id='entries']//li[1]")
    public SelenideElement clickOnTheFoundDeal;

    @FindBy(xpath = "//header[@class='header']//a[@data-action='roleOwner.roleOwnerToolbarcopyNav']")
    public static SelenideElement CopyClick;

//    @FindBy(xpath = "//input[@Id='deal.makeTo']")
//    public static SelenideElement Edit;


//    @FindBy(xpath = "//div[@class='modal']//li[@data-id='M2S']")
//    public static SelenideElement modalSelect;

    @FindBy(xpath = "//a[@data-action='pageReview.pageReviewefficiencyNav']")
    public SelenideElement efficiencyCheck;


    @FindBy(xpath = "//header[@class='title group']//a[@class='button']")
    public SelenideElement efficiencyCheckCloseButton;

    @FindBy(xpath = "//header[@class='title group']//a[@data-action='pageReview.pageReviewoperationsNav']")
    public SelenideElement operationButton;

    @FindBy(xpath = "//a[@data-action='pageOperations.pageOperationsToolbarreviewNav']")
    public SelenideElement operationButtonExit;

    @FindBy(xpath = "//a[@data-action='pageReview.Modify']")
    public SelenideElement modifyClick;

    @FindBy(xpath = "//a[@data-action='pageReview.pageReviewplannedNav']")
    public SelenideElement buttonPlannedCosts;

    @FindBy(xpath = "//input[@id='planned.costType']")
    public SelenideElement  addCost;

    @FindBy(xpath = "//li[@data-id='ADDITIONAL CARGO STORAGE']")
    public SelenideElement selectCost;

    @FindBy(xpath = "//input[@id='planned.costs.8.amount']")
    public SelenideElement addAmountPlanned;

    @FindBy(xpath = "//input[@id='planned.costs.8.amountC']")
    public SelenideElement addCurrencyPlanned;

    @FindBy(xpath = "//li[@data-id='EUR']")
    public SelenideElement addCurrencyEUR;

    @FindBy(xpath = "//input[@id='planned.costs.8.salesUnit']")
    public SelenideElement addUnit;

    @FindBy(xpath = "//li[@data-id='CHTRD']")
    public SelenideElement addUnitChtrd;


    @FindBy(xpath = "//a[@data-action='pagePlannedCosts.save']")
    public SelenideElement saveButtonPlannedCosts;

    @FindBy(xpath = "//a[@data-toggle-target='planned-costs' and text()='Details']")
    public SelenideElement plannedCostsDetail;

    @FindBy(xpath = "//a[@data-action='pageReview.pageReviewplannedNav']")
    public SelenideElement plannedCostsButton;

    @FindBy(xpath = "//div[@class='caption']//a[@data-meta='8']")
    public SelenideElement plannedCostsDelete;

    @FindBy(xpath = "//div[@class='caption']//a[@data-meta='0']")
    public SelenideElement plannedCostsDelete2;

    @FindBy(xpath = "//a[@data-action='pageReview.workflow-send-to-approval']")
    public SelenideElement approvalDealClick;

    @FindBy(xpath = "//a[contains(@href, '/flow/deals#')]")
    public SelenideElement openDealOnShipments;

    @FindBy(xpath = "//a[@data-action='pageReview.pageReviewoperationsNav']")
    public SelenideElement openOperationModel;


    @FindBy(xpath = "//input[@id='deal.delayReasonType']")
    public static SelenideElement delayReasonSelect;


    @FindBy(xpath = "//li[@data-id='7']")
    public static SelenideElement actuallyLate;

    @FindBy(xpath = "//li[@data-id='MY PKG']")
    public static SelenideElement portKlang;

    @FindBy(xpath = "//input[@name='deal.reasonDetails']")
    public static SelenideElement reasonDetails;


    @FindBy(xpath = "//input[@name='deal.priceListIdentifier']")
    public static SelenideElement PriceListNo;

//li[@data-id='7']

    // Selenide.switchTo().window(WebDriverRunner.getWebDriver().getWindowHandles().size() - 1);



public void PriceListNoOperation(String string) {
//    PriceListNo.click();
//    PriceListNo.setValue("123");
}



    public void operation(String String) {
        openDealOnShipments.click();
        refresh();
        Selenide.switchTo().window(WebDriverRunner.getWebDriver().getWindowHandles().size() - 1);
        openOperationModel.click();

    }

    public void openPageOperationModel(Deals deals){
        operation((deals.getOpenDealOnShipments()));



    }

    private void costs(String text) {
        buttonPlannedCosts.click();
        addCost.click();
        selectCost.click();
        addAmountPlanned.click();
        addAmountPlanned.setValue(text);
        addCurrencyPlanned.click();
        addCurrencyEUR.click();
        addUnit.click();
        addUnitChtrd.click();
        saveButtonPlannedCosts.click();
        plannedCostsDetail.click();
        Selenide.sleep(10000);

    }




    public void plannedCostsDeal(Deals deals) {
        costs(deals.getPlannedCosts());

    }

    public void checkAddedTransportCosts(Deals deals){
        Selenide.sleep(10000);
        plannedCostsButton.click();
        plannedCostsDelete.click();
        plannedCostsDelete2.click();
        saveButtonPlannedCosts.click();
        plannedCostsDetail.click();
    }


    public void ClickSalesUnit(String text) {
        ClickSalesUnit.click();
        ClickSalesUnit.setValue(text);
        SelectSalesUnit.click();

    }

    public void ClickSalesModel(String text) {
        ClickSales.click();
        ClickSales.setValue(text);
        SelectSalesModel.click();
    }

    public void SelectAgreementDate(String date) {
        AgreementDate.click();
        TodayAgreementDate.click();
    }

    public void ClickCustomerDestination(String text) {
        CustomerDestination.click();
        CustomerDestination.setValue(text);
        SelectCountry.click();
    }

    public void ClickCustomer(String text) {
        SelectCustomer.click();
        SelectCustomer.setValue(text);
        InputCustomer.click();
        //InputCustomerNew.click();
    }

    //public void ClickCustomerNew(String text) {
       // InputCustomerNew.click();
   // }

   public void SelectCurrency(String text) {
       ClickCurrency.click();
       ClickCurrency.setValue(text);
       ClickCurrencyUsd.click();
   }

    public void PaymentTerms(String text) {
        ClickPaymentTerms.click();
        ClickPaymentTerms.setValue(text);
        SelectPaymentTerms.click();

    }

    public void Transports(String text) {
        SelectTransports.click();
        SelectTransports.setValue(text);
        ClickTransports.click();
    }

    public void SelectShipFromSite(String text) {
        ShipFromSite.click();
        ShipFromSite.setValue(text);
        ShipFromSiteClick.click();

    }

    public void DeliveryTermsClick(String text) {
        DeliveryTerms.click();
        DeliveryTerms.setValue(text);
        DeliveryTermsClick.click();

    }

    public void ChangeReasonText(String text) {
        ChangeReason.click();
        ChangeReason.setValue(text);
    }

    public void ShipToCompanyClick(String text) {
        ShipToCompany.click();
        ShipToCompany.setValue("Cibra Trading Inc.");
        ShipToCompanySelect.click();
    }

    public void DeliveryPointClick(String text) {
        DeliveryPoint.click();
        DeliveryPoint.setValue(text);
        DeliveryPointSantos.click();
    }

    public void OrderProductClick(String text) {
        OrderProduct.click();
        OrderProduct.setValue("MAP 12:52 GRAN");
        OrderProductClick.click();

    }

    public void DealPackageClick(String text) {
        DealPackage.click();
        DealPackage.setValue("BULK");
        DealPackageClick.click();

    }

    public void ReferenceIdentifierText(String text) {
        ReferenceIdentifier.click();
        ReferenceIdentifier.setValue(text);
    }


    public void DealTraderClick(String text) {
        DealTrader.clear();
        DealTrader.click();
        DealTrader.setValue(text);
        SelectTraderDeal.click();
    }


    public void DealAssistantClick(String text) {
        DealAssistant.click();
        DealAssistant.setValue(text);
        DealAssistantSelect.click();

    }

    public void DealPriceClick(String text) {
        DealPriceGross.click();
        DealPriceGross.setValue(text);


    }

    public void DealOrigin(String text) {
        DealOriginClick.click();
        DealOriginClick.setValue(text);
        DealOriginSelect.click();
    }


    public void DealQuantity(String text) {
        DealQuantity.click();
        DealQuantity.clear();
        DealQuantity.setValue(text);
    }

    public void DealNotesClick(String notes) {
        DealNotes.click();

    }

    public void SaveButton(String save) {
        Selenide.sleep(3000);
        SaveButton.click();


    }

    public void searchDealInTheList(Deals deals) {
        SearchBar(deals.getText());

    }
    public void SearchBar(String text) {
        enteringTextIntoTheSearchBar.click();
        enteringTextIntoTheSearchBar.setValue(text);
        clickOnTheFoundDeal.click();


    }

    public void copyDeal(Deals deals) {
        SearchBar(deals.getText());
        CopyClick.click();
//        Edit.click();
//        modalSelect.click();


    }

    public static void copyNewDeal(String text) {
        CopyClick.click();
        Selenide.sleep(1000);
//        Edit.click();
//        modalSelect.click();
        delayReasonSelect.click();
        actuallyLate.click();
        reasonDetails.click();
        reasonDetails.setValue("123");
        DeliveryPoint.click();
        DeliveryPoint.setValue("Port Klang (Pelabuhan Klang");
        portKlang.click();
        DealTrader.clear();
        DealTrader.click();
        DealTrader.setValue("Mariya Meshcheriakova");
        SelectTraderDeal.click();
        DealNotes.click();
        SaveButton.click();






    }

    public static void createAbjustmentDeal(String text){
        delayReasonSelect.click();
        actuallyLate.click();
        reasonDetails.click();
        reasonDetails.setValue("123");
        DeliveryPoint.click();
    }

    public void efficiencyButton(Deals deals) {
        efficiencyCheck.click();
        efficiencyCheckCloseButton.click();
    }


    public void operationButton(Deals deals) {
        operationButton.click();
    }

public void returnDeals(String string){
    operationButtonExit.click();
}
  public void  returnToTransportPage(Deals deals) {
      returnDeals(deals.getOperationButton());

  }
    public void modifyButton(Deals deals) {
        modifyClick.click();
        deliveryEnd.click();
        deliveryNextPeriod.click();
        $(By.linkText("10")).click();
        DealQuantity(deals.getQuantity());
        DealNotesClick(deals.getNotes());
        SaveButton(deals.getSave());

    }

    public void approv(String text) {
    approvalDealClick.click();
}

public void approvalDeal (Deals deals) {
    approv(deals.getApproval());
}



    public void editDeal(Deals deals) {
        DeliveryPointClick(deals.getPoint());
        DealNotesClick(deals.getNotes());
        PriceListNoOperation(deals.getPriceListNo());
        SaveButton(deals.getSave());
    }


//public void editDealAbjustment()


//public void copy(Deals deals) {
//    copyDealChtrd

    public void termsConditionsCustomer(Deals deals) {
        ClickSalesUnit(deals.getUnit());
        ClickSalesModel(deals.getModel());
        SelectAgreementDate(deals.getDate());
        ClickCustomerDestination(deals.getCountry());
        ClickCustomer(deals.getCustomer());
        SelectCurrency(deals.getCurrency());
        PaymentTerms(deals.getPayment());
        PriceListNoOperation(deals.getPriceListNo());


       // newCustomer(deals.getCustomerNew());


    }

public void Delivery(Deals deals) {
    deliveryStart.click();
    deliveryStartPeriod.click();
    deliveryEnd.click();
    deliveryNextPeriod.click();
    $(By.linkText("26")).click();
    Transports(deals.getTransports());
    SelectShipFromSite(deals.getSite());
    DeliveryTermsClick(deals.getDeliveryTerms());
    ChangeReasonText(deals.getComment());
    ShipToCompanyClick(deals.getCompany());
    DeliveryPointClick(deals.getPoint());


}

public void Order(Deals deals) {
    OrderProductClick(deals.getProduct());
    DealPackageClick(deals.getPackageOrder());

}

public void ClickNegativeSave(String negativeSave) {
    NegativeSave.click();
}


public void ContactsAndReferences(Deals deals) {

    ReferenceIdentifierText(deals.getReference());

    ReferenceDateClick.click();
    ReferenceDateSelect.click();
    DealTraderClick(deals.getTrader());
    DealAssistantClick(deals.getAssistant());
    DealPriceClick(deals.getPrice());
    DealOrigin(deals.getOrigin());
    DealQuantity(deals.getQuantity());
    DealNotesClick(deals.getNotes());
    Configuration.timeout = 20000;
    SaveButton(deals.getSave());





}



public void ClickButtonSave(Deals deals) {
    ClickNegativeSave(deals.getNegativeSave());



}


    }













