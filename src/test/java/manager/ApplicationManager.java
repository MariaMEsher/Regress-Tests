package manager;

import com.codeborne.selenide.Configuration;

import java.util.Properties;

import static com.codeborne.selenide.Selenide.*;

;

public class ApplicationManager {


    public static class BrowserManager {
        private String browser;
        private Properties properties;

        public void init(String browser, Properties properties) {
            this.browser = browser;
            this.properties = properties;

            Configuration.browser = browser; // "chrome" или "firefox"
            Configuration.timeout = 30000; // Таймаут ожидания (в миллисекундах)
            Configuration.browserSize = "1690x800"; // Размер окна браузера
            Configuration.baseUrl = properties.getProperty("web.baseUrl");
        }

        public void startSession() {
            // Открытие базового URL из properties
            open(properties.getProperty("web.baseUrl"));

            // Авторизация в SSO
            login(properties.getProperty("web.username"), properties.getProperty("web.password"));

            // Переход к основной странице и повторная авторизация
            open(properties.getProperty("web.baseUrl"));
            login(properties.getProperty("web.SSOUsername"), properties.getProperty("web.SSOPassword"));
        }

        private void login(String username, String password) {
            // Заполняем поля логина и пароля и нажимаем кнопку "Войти"
            $("#login").setValue(username);
            $("#password").setValue(password);
            $("button[type='submit']").click();
        }

        public void closeSession() {
            // Закрываем браузер вручную, если нужно
            closeWebDriver();
        }
    }
}