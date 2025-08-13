package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.openqa.selenium.By;



import static com.codeborne.selenide.Selenide.*;
import static utils.ConfigProperties.geProperty;

public class CheckingPositionChangesTests {


public CheckingPositionChangesTests(){

}

//Перейти в словарь Go to: https://test.eurochem.ru/flow/dictionaries#All
//Выбрать  'products' table
//Таблица открыта
//В name найти ACETIC ACID
//Поменять данные CNCode = 00000 и Group One - test96
//Нажать на сохранить
//Проверить предупреждение Please correct the following errors before continuing serviceRequest can't be blank
//Заполнить поле и сохранить
//Проверить что данные сохранены
//Нажать на all
//Таблица открыта
//Открыть 6 позицию
//Заполнить данные по Sales Unit = Any и Contractor = Any
//Проверить сохраненное


@Test

public void CanCheckDictionaries() {


    Configuration.browserSize = "1920x1080";
    open("https://test.eurochem.ru/flow/dictionaries#All");
    $(By.id("login")).setValue(geProperty("web.username"));
    $(By.id("password")).setValue(geProperty("web.password"));
    $(By.xpath("//input[@value='Войти']")).click();


//Нажать на products
refresh();
    $x("//tr[@data-meta='products']").click();
    $x("//input[@name='product.name']").click();
    $x("//input[@name='product.name']").setValue("ACETIC ACID").pressEnter();
    $x("//div[text()='ACETIC ACID']").click();
    $x("//input[@name='product.CNCode']").click();
    $x("//input[@name='product.CNCode']").clear();
    $x("//input[@name='product.CNCode']").setValue("123");
    $x("//input[@name='product.groupOne']").click();
    $x("//input[@name='product.groupOne']").setValue("test96");
    $x("//a[@class='button primary']").click();

    SelenideElement statusSave = $x("//div[@class='errors']");

    statusSave.shouldBe(Condition.visible)
            .shouldHave(Condition.text("Please correct the following errors before continuing "));



    $x("//textarea[@name='dictionaryRegistry.serviceRequest']").click();
    $x("//textarea[@name='dictionaryRegistry.serviceRequest']").setValue("123");
    $x("//a[@class='button primary']").click();
    $x("//li[@data-name='All']").click();
    $x("//tr[@data-meta='contracts']").click();
    $x("//div[text()='6']").click();
    $x("//input[@id='contract.salesUnit']").click();
    $x("//li[@data-id='BEANF']").click();
    $x("//input[@id='contract.contractor']").click();
    $x("//input[@id='contract.contractor']").clear();
    $x("//input[@id='contract.contractor']").setValue("AGROMEGA");
    $x("//li[@data-id='3100631']").click();
    $x("//textarea[@name='dictionaryRegistry.serviceRequest']").click();
    $x("//textarea[@name='dictionaryRegistry.serviceRequest']").setValue("123");
$x("//a[@data-action='pageForm.save']").click();
    Selenide.closeWebDriver();

}
}