package tests;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {

    public static void sendXMLToApi(int operationId, String token, String xmlResponse) {
        try {
            String endpointUrl = "https://dev.eurochem.ru/flow/api/operationCallback";
            HttpClient client = HttpClient.newHttpClient();

            String requestBody = "operation_id=" + operationId +
                    "&token=" + token +
                    "&p_xml_info=" + xmlResponse;

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endpointUrl))
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Код ответа сервера: " + response.statusCode());
            System.out.println("Ответ от сервера: " + response.body());

        } catch (Exception e) {
            System.out.println("Ошибка при отправке запроса:");
            e.printStackTrace();
        }
    }
}