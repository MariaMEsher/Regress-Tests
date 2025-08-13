package utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties{
    public static final String URL = "https://dev.eurochem.ru/flow/transports#Invoiced";
    public static final String LOGIN = "meshcheriakovame@suek.ru";
    public static final String PASSWORD = "klaKplak5375097";

    // Статические методы для получения данных
    public static String getUrl() {
        return URL;
    }

    public static String getLogin() {
        return LOGIN;
    }

    public static String getPassword() {
        return PASSWORD;
    }

    private static final Properties properties = new Properties();

    static {
        try {
            properties.load(new FileInputStream("src/main/resources/config.properties"));
        } catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static String geProperty(String key) {
        return properties.getProperty(key);
    }
}
