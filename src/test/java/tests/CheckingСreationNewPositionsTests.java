package tests;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static utils.ConfigProperties.geProperty;

//Перейти в таблицу локации Go to: https://test.eurochem.ru/flow/dictionaries#All/locations
//Нажать на создание новой локации Press 'Add new location' button
//Заполнить определенные поля (id и name)
//Заполнить комментарий и сохранить
//Найти новую локацию в поиске

public class CheckingСreationNewPositionsTests {

    public CheckingСreationNewPositionsTests() {


    }

@Test
public void canCheckinglocation() {

    Configuration.browserSize = "1920x1080";
    open("https://test.eurochem.ru/flow/dictionaries#All/locations");
    $(By.id("login")).setValue(geProperty("web.username"));
    $(By.id("password")).setValue(geProperty("web.password"));
    $(By.xpath("//input[@value='Войти']")).click();

    $x("//a[@data-action='pageList.pageListToolbarnewNav']").click();
    $x("//input[@name='location.primaryKey']").click();
    $x("//input[@name='location.primaryKey']").setValue("Test ID Location");
    $x("//input[@name='location.name']").click();
    $x("//input[@name='location.name']").setValue("Test NAME Location");
    $x("//textarea[@name='dictionaryRegistry.serviceRequest']").click();
    $x("//textarea[@name='dictionaryRegistry.serviceRequest']").setValue("test");
    $x("//a[@data-action='pageForm.save']").click();
    $x("//input[@name='location.primaryKey']").click();
    $x("//input[@name='location.primaryKey']").setValue("Test ID Location").pressEnter();
    $x("//input[@name='location.name']").click();
    $x("//input[@name='location.name']").setValue("Test NAME Location").pressEnter();



    SelenideElement statusElement1 = $x("//div[@class='caption' and text()='Test ID Location']");

    statusElement1.shouldBe(Condition.visible)
            .shouldHave(Condition.text("Test ID Location"));
    String actualStatusMovement1 = statusElement1.getText();
    Assertions.assertTrue(actualStatusMovement1.contains("Test ID Location"), "Operation status does not contain 'Test ID Location' ");

    Selenide.closeWebDriver();

    //div[@class='caption' and text()='Test ID Location']

}



}


