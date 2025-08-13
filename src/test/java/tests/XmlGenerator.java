package tests;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.*;

import static utils.ConfigProperties.geProperty;

public class XmlGenerator {
    private static int operationId;
    private static int transferId;
    private String lotIdentifier;
    private static String token;
    private int batchIdentifier;
    //Операция первая
    public static void main(String[] args) {

        String url = "jdbc:mysql://" + geProperty("hostDbUrl") + ":" + geProperty("dbPort") + "/" + geProperty("dbName");

        try (Connection connection = DriverManager.getConnection(url, geProperty("hostDbUser"), geProperty("hostPassword"))) {
            System.out.println("Соединение с базой данных установлено!");

            if (fetchOperationId(connection)) {
                if (fetchTransferId(connection)) {
//                    if (fetchLotIdentifier(connection)) {
                    // Генерация XML
                    String xmlResponse = generateXMLResponse(transferId);
                    System.out.println("Сформированный XML:\n" + xmlResponse);

                    // Отправка XML на API
                    sendXMLToApi(operationId, token, xmlResponse);

                }
            } else {
                System.out.println("Данные не найдены по заданным критериям.");
            }
        } catch (Exception e) {
            System.out.println("Ошибка при работе с базой данных: ");
            e.printStackTrace();
        }
    }

    private static boolean fetchOperationId(Connection connection) throws SQLException {
        String query = """
    SELECT id, token
    FROM operations
    WHERE Action = 'SUEK.websphere.materialMovement.loadVessel'
      AND Name = 'SUEK.websphere.materialMovement.loadVessel'
      AND Context LIKE '%{\"salesUnit_id\":\"CHTRD\"}%'
      AND UpdatedAt >= DATE_SUB(NOW(), INTERVAL 2 MINUTE);
    """;


        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next()) {
                operationId = resultSet.getInt("id");
                token = resultSet.getString("token");
                System.out.println("Найден operationId: " + operationId + ", token: " + token);
                return true;
            }
        }
        return false;
    }

    private static boolean fetchTransferId(Connection connection) throws SQLException {
        String query = "SELECT transfer_id FROM transferOperations WHERE operation_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, operationId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    transferId = resultSet.getInt("transfer_id");
                    System.out.println("Найден transferId: " + transferId);
                    return true;
                }
            }
        }
        return false;
    }

//    private static boolean fetchLotIdentifier(Connection connection) throws SQLException {
//        String query = "SELECT lotIdentifier FROM transfers WHERE id = ?";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setInt(1, transferId);
//            try (ResultSet resultSet = statement.executeQuery()) {
//                if (resultSet.next()) {
//                    lotIdentifier = resultSet.getString("LotIdentifier");
//                    System.out.println("Найден LotIdentifier: " + lotIdentifier);
//                    return true;
//                }
//            }
//        }
//        return false;


    private static String generateXMLResponse(int transferId) {
        return """
                <Response>
                  <Status>SUCCESS</Status>
                  <Body>
                    <AccountingDate>2024-12-09</AccountingDate>
                    <Lots>
                      <Lot>
                        <LotNo>241209_RUBYN</LotNo>
                        <TransferIdentifier>%d</TransferIdentifier>
                        <BatchNo>0000078163</BatchNo>
                        <Item>1010000259201</Item>
                        <unitMeasure>Т</unitMeasure>
                        <NetWeight>1.000</NetWeight>
                      </Lot>
                    </Lots>
                  </Body>
                </Response>
                """.formatted(transferId);
    }

    private static void sendXMLToApi(int operationId, String token, String xmlResponse) {
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
