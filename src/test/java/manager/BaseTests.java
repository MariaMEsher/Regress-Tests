package manager;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.By;

import java.util.Properties;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class BaseTests {
    protected static ApplicationManager app;
    private Properties properties;




    @Before

    public void setApp() {




        open("https://dev.eurochem.ru/flow/deals#All/new");
        $(By.id("login")).setValue("meshcheriakovame@suek.ru");
        $(By.id("password")).setValue("KlakPlak5375097");
        $(By.xpath("//input[@value='Войти']")).click();
        Configuration.browser = "Firefox";
        Configuration.browserSize = "1280x768";
        Configuration.timeout = 10000;
        Configuration.pageLoadTimeout = 1000;
        WebDriverManager.chromedriver().setup();


    }

}

///
