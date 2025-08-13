package tests;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.DealPage;
import salesObjects.Deals;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static utils.ConfigProperties.geProperty;

public class CheckWorkingWithDealsTests {
    private DealPage dealPage;

    public CheckWorkingWithDealsTests() {

    }

    @Test
    public void CanCheckWorking() {

        DealPage dealPage = page(DealPage.class);

        Configuration.browserSize = "1920x1080";
        open("https://dev.eurochem.ru/flow/deals#Drafts");
        $(By.id("login")).setValue(geProperty("web.username"));
        $(By.id("password")).setValue(geProperty("web.password"));
        $(By.xpath("//input[@value='Войти']")).click();


        dealPage.searchDealInTheList(Deals.builder().build());

        dealPage.efficiencyButton(Deals.builder().build());

        dealPage.operationButton(Deals.builder().build());

        dealPage.returnToTransportPage(Deals.builder().build());

                String actualExecutionModel = $x("//div[@class= 'table accounting operations']").shouldBe(visible).getText();
        Assertions.assertEquals("No operations of accounting objects creation. Schedule a shipment to create accounting.", actualExecutionModel, "No operations of accounting objects creation. Schedule a shipment to create accounting.");


        dealPage.modifyButton(Deals.builder()
                        .quantity("3025")
                        .notes("")
                        .save("")

                .build());

        //Проверка на статус
        Selenide.sleep(10000);
        String actualStatus = $x("//header[@class='title group']//span[@class='state']").shouldBe(visible).getText();
        Assertions.assertEquals("Draft", actualStatus, "Status is not 'Draft'!");


        dealPage.plannedCostsDeal(Deals.builder()
                .buttonPlannedCosts("")
                .addCost("")
                .selectCost("")
                .addAmountPlanned("5")
                .plannedCosts("5")
                .addCurrencyPlanned("5")
                .addCurrencyEUR("USD")
                .addUnit("")
                .addUnitName("CHTRD")
                .saveButtonPlannedCosts("")
                .plannedCostsDetail("")
                .build());

        Selenide.sleep(3000);
        String actualPlannedCosts = $x("//tr[@data-toggle-target='planned-costs']//td[text()='ADDITIONAL CARGO STORAGE']").shouldBe(visible).getText();
        Assertions.assertEquals("ADDITIONAL CARGO STORAGE", actualPlannedCosts, "Status is not 'ADDITIONAL CARGO STORAGE'!");



        dealPage.checkAddedTransportCosts(Deals.builder()
                .plannedCostsDetail("")
                .plannedCostsButton("")
                .plannedCostsDelete("")
                .saveButtonPlannedCosts("")
                .plannedCostsDetail("")

                .build());


        Selenide.sleep(2000);
        $x("//tr[@data-toggle-target='planned-costs']//td[text()='ADDITIONAL CARGO STORAGE']")
                .shouldNotBe(visible);
        Assertions.assertTrue(true, "The element 'ADDITIONAL CARGO STORAGE' is not present, as expected.");



        for (String tab : Selenide.webdriver().object().getWindowHandles()) {
            // Переключаемся на каждую вкладку
            Selenide.webdriver().object().switchTo().window(tab);
            // Закрываем текущую вкладку
            Selenide.webdriver().object().close();
        }

        // Завершаем работу WebDriver
        Selenide.closeWebDriver();






//SELECT *
//FROM operations
//WHERE action = 'SUEK.websphere.materialMovement.loadVessel'
//AND name = 'SUEK.websphere.materialMovement.loadVessel'
//AND context LIKE '%"salesUnit_id":"CHTRD"%'
//AND createdAt >= NOW() - INTERVAL 5 MINUTE;


// Get the custom field "Parent issue in hierarchy"
//        CustomFieldManager customFieldManager = ComponentAccessor.getCustomFieldManager()
//        CustomField parentIssueField = customFieldManager.getCustomFieldObjectByName("Parent issue in hierarchy");
//        CustomField onecustomField = customFieldManager.getCustomFieldObjectByName("one custom field");
//
//        CustomFieldManager customFieldManager = ComponentAccessor.getCustomFieldManager()
//        CustomField parentIssueField = customFieldManager.getCustomFieldObjectByName("Parent issue in hierarchy")
//
//
//// Get the current issue
//        IssueManager issueManager = ComponentAccessor.getIssueManager()
//        Issue currentIssue = issueManager.getIssueObject(issue.key)
//
//// Get the value of the "Parent issue in hierarchy" field for the current issue
//        def parentIssueFieldValue = currentIssue.getCustomFieldValue(parentIssueField)




    }
}