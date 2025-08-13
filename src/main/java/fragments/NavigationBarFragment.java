package fragments;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

public class NavigationBarFragment{
    @FindBy (xpath = "//div[@id='toolbar']//a[2]")
    private SelenideElement newDealButton;

    public void clickNewDealButton(){
        newDealButton.click();
    }

}
