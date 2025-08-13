package tests;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import manager.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.openqa.selenium.*;
import pages.DealPage;
import salesObjects.Deals;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static utils.ConfigProperties.geProperty;
public class WarningCreatingInvoicesTests {



    //Перейти в транспортные расходы
    //Проверить статус и что создан инвойс
    //Перейти заново в создание транспортных
    //Создать аналогичные транспортные расходы
    //Проверить что появилось предупреждение
    //Сохранить
    //Перевести в статус pending
    //Перейти в создание инвойса
    //Создать новый
    //Проверить что появилось предупреждение
    //Статус драфт
    //Нажать на копирование инвойса
    //Добавить новые строки
    //Проверить предупреждение
    //Вернуться на создание транспортныз
    //Добавить новые строки
    //Проверить предупреждение

}
