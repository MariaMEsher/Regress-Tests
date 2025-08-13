package pages;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import salesObjects.Invoice;
import salesObjects.Transports;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class InvoicePage {


    @FindBy(xpath = "div[@class='group']//a[text()='Create invoice']")
    public SelenideElement createInvoiceButtonOnShipment;


    public void createInvoice(Invoice invoice){
        createInvoiceButtonOnShipment.click();
    }


}
