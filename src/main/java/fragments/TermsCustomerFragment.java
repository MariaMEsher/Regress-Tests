package fragments;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class TermsCustomerFragment {
    @FindBy(xpath = "//input[@id='deal.customer']")
    private SelenideElement descriptionField;

    @FindBy(xpath = "//div[@class='subfield input suggest']//input[@id='deal.salesUnit']")
    private SelenideElement descriptionSalesUnit;

    @FindBy(xpath = "//div[@class='subfield input select grid-2']//input[@id='deal.salesModel']")
    private SelenideElement fieldSalesModel;

    @FindBy(xpath = "//input[@id='deal.agreementDate']")
    private SelenideElement selectDateCalendar;



    public void fillDescriptionField(){

        descriptionField.click();



    }

}

