package pages;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import salesObjects.Transports;

import static com.codeborne.selenide.Selenide.$;

public class TransportPage {



    //Переходим в сделку(Делаем уточнение для какой сделки  Vessel Deep Sea Direct Santos)
// Открываем создание нового шипмента
//Заполняем полностью страницу transports
///Переводим в статус реквест
//Переходим на страницу самого шипмента заполняем данные
//Доводим статус до конечного статуса ресивд
//Переходим в операционную модель
//Проверяем что статус перешел в аккаунтед
//Переходим на страницу транспортс
//Открываем модифай страницы костов
//добавляем новые значения
//Нажимаем на сохранения
//Переходим обратно проверяем статус pending
//Выполняется первая операция,проверяем статус PurchaseService
//Нажимается сразу на отмену после выполнения
//Операция по отмене выполняется,проверка статуса отмены
//Выполняем операции по вторым добавленным костам
//Проверяем статус сначала статус PurchaseService
//
//Service — 219 ReceiveService
//
//Service — 220 DeliveryService

    @FindBy(xpath = "//input[@type='text']")
    public SelenideElement findDealOnPage;

    @FindBy(xpath = "//*[@id='Shipments']/header/div/a")
    public SelenideElement openShipmentInDeal;

    @FindBy(xpath = "//ol[@id='entries']//li[1]")
    public SelenideElement firstDeal;

    @FindBy(xpath = "//*[@id='Shipments']/div[3]/table/tbody/tr[2]/td[1]/a")
    public SelenideElement openTransportsOnDeals;

    @FindBy(xpath = "//a[@data-action='pageCosts.pageCostscostseditNav']")
    public SelenideElement modifyTransportsCosts;

    @FindBy(xpath = "//input[@id='transport.type']")
    public SelenideElement addNewTransportsCosts;

    @FindBy(xpath = "//li[@data-id='1301']")
    public SelenideElement selectServiceCosts;

    @FindBy(xpath = "//input[@id='transport.costs.0.quantity']")
    public SelenideElement addQuantityTransportCosts;

    @FindBy(xpath = "//input[@id='transport.costs.0.carrier']")
    public SelenideElement addCarrierTransportCosts;

    @FindBy(xpath = "//li[@data-id='57076']")
    public SelenideElement selectCarrier;

    @FindBy(xpath = "//input[@id='transport.costs.0.payer']")
    public SelenideElement addPayer;

    @FindBy(xpath = "//li[@data-id='CHTRD']")
    public SelenideElement addPayerUnit;

    @FindBy(xpath = "//input[@id='transport.costs.0.unitMeasure']")
    public SelenideElement unitMeasure;


    @FindBy(xpath = "//li[@data-id='unit']")
    public SelenideElement unitSelect;

    @FindBy(xpath = "//input[@id='transport.costs.0.amount']")
    public SelenideElement addAmount;


    @FindBy(xpath = "//input[@id='transport.costs.0.currency']")
    public SelenideElement addCurrency;

    @FindBy(xpath = "//li[@data-id='USD']")
    public SelenideElement addCurrencyUsd;


    @FindBy(xpath = "//input[@id='transport.type']")
    public SelenideElement addNewTransportsCostsNewLine;

    @FindBy(xpath = "//li[@data-id='1301']")
    public SelenideElement selectServiceCostsNewLine;

    @FindBy(xpath = "//input[@id='transport.costs.1.quantity']")
    public SelenideElement addQuantityTransportCostsNewLine;

    @FindBy(xpath = "//input[@id='transport.costs.1.carrier']")
    public SelenideElement addCarrierTransportCostsNewLine;

    @FindBy(xpath = "//li[@data-id='57076']")
    public SelenideElement selectCarrierNewLine;

    @FindBy(xpath = "//input[@id='transport.costs.1.payer']")
    public SelenideElement addPayerNewLine;

    @FindBy(xpath = "//li[@data-id='CHTRD']")
    public SelenideElement addPayerUnitNewLine;

    @FindBy(xpath = "//input[@id='transport.costs.1.unitMeasure']")
    public SelenideElement unitMeasureNewLine;


    @FindBy(xpath = "//li[@data-id='unit']")
    public SelenideElement unitSelectNewLine;

    @FindBy(xpath = "//input[@id='transport.costs.1.amount']")
    public SelenideElement addAmountNewLine;


    @FindBy(xpath = "//input[@id='transport.costs.1.currency']")
    public SelenideElement addCurrencyNewLine;

    @FindBy(xpath = "//li[@data-id='USD']")
    public SelenideElement addCurrencyUsdNewLine;

    @FindBy(xpath = "//a[@data-action='pageShipmentCostsForm.accrue-transport-costs']")
    public SelenideElement saveAndCreateAccrual;







public void transportsCosts(String string) {
    modifyTransportsCosts.click();
    addNewTransportsCosts.click();
    selectServiceCosts.click();
    addQuantityTransportCosts.click();
    addQuantityTransportCosts.sendKeys("1");
    addCarrierTransportCosts.click();
    selectCarrier.click();
    addPayer.click();
    addPayerUnit.click();
    unitMeasure.click();
    unitSelect.click();
    addCurrency.click();
    addCurrencyUsd.click();
    addAmount.click();
    addAmount.sendKeys("70");
    addNewTransportsCostsNewLine.click();
    selectServiceCostsNewLine.click();
    addQuantityTransportCostsNewLine.click();
    addQuantityTransportCostsNewLine.sendKeys("1");
    addCarrierTransportCostsNewLine.click();
    selectCarrierNewLine.click();
    addPayerNewLine.click();
    addPayerUnitNewLine.click();
    unitMeasureNewLine.click();
    unitSelectNewLine.click();
    addAmountNewLine.click();
    addAmountNewLine.sendKeys("40");
    addCurrencyNewLine.click();
    addCurrencyUsdNewLine.click();
    saveAndCreateAccrual.click();

}

public void createNewTransportsCosts(Transports transports){
    transportsCosts(transports.getModifyTransportsCosts());
}





    public void checkTransports(String text){
        openTransportsOnDeals.click();
        modifyTransportsCosts.click();
        addNewTransportsCosts.click();
        selectServiceCosts.click();
        addQuantityTransportCosts.click();
        addQuantityTransportCosts.sendKeys("1");
        addCarrierTransportCosts.click();
        selectCarrier.click();
        addPayer.click();
        addPayerUnit.click();
        unitMeasure.click();
        unitSelect.click();
        addCurrency.click();
        addCurrencyUsd.click();
        addAmount.click();
        addAmount.sendKeys("50");
        addNewTransportsCostsNewLine.click();
        selectServiceCostsNewLine.click();
        addQuantityTransportCostsNewLine.click();
        addQuantityTransportCostsNewLine.sendKeys("1");
        addCarrierTransportCostsNewLine.click();
        selectCarrierNewLine.click();
        addPayerNewLine.click();
        addPayerUnitNewLine.click();
        unitMeasureNewLine.click();
        unitSelectNewLine.click();
        addAmountNewLine.click();
        addAmountNewLine.sendKeys("50");
        addCurrencyNewLine.click();
        addCurrencyUsdNewLine.click();

    }

    public void addTransportsCosts(Transports transports){
        checkTransports(transports.getOpenTransportsOnDeals());
    }


//Открываем страницу
public void findDeal(String text) {
    findDealOnPage.click();
    findDealOnPage.setValue(text);
    firstDeal.click();
}

//Находим шипмент на странице

public void searchOnPageDeal(Transports transports) {
    Selenide.refresh();
    findDeal(transports.getSearchOnPage());
   // findButtonNewShipment(transports.getOpenShipmentInDeal());
}


public void addTransportsCosts() {

}

   // $x("//input[@type='text']").setValue("Vessel Deep Sea Direct Santos today");
   // $x("//ol[@id='entries']//li[1]").click();
}
