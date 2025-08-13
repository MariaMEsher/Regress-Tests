package tests;

import java.sql.*;

public class DatabaseService {
    private final Connection connection;

    // Конструктор: открываем соединение с БД
    public DatabaseService(String url, String user, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, user, password);
        System.out.println("Соединение с базой данных установлено!");
    }

    // Получаем operationId и token
    public int[] fetchOperationId() throws SQLException {
        String query = """
                SELECT id, token
                FROM operations
                WHERE Action = 'SUEK.websphere.materialMovement.loadVessel'
                  AND Name = 'SUEK.websphere.materialMovement.loadVessel'
                  AND Context LIKE '%{"salesUnit_id":"CHTRD"}%'
                  AND UpdatedAt >= NOW() - INTERVAL 40 MINUTE;
                """;

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            if (resultSet.next()) {
                int operationId = resultSet.getInt("id");
                String token = resultSet.getString("token");
                System.out.println("Найден operationId: " + operationId + ", token: " + token);

                return new int[]{operationId, Integer.parseInt(token)};
            } else {
                System.out.println("Не удалось найти operationId и token.");
            }
        } catch (NumberFormatException e) {
            System.err.println("Ошибка при преобразовании токена в число.");
            e.printStackTrace();
        }
        return null;
    }

    // Получаем transferId
    public int fetchTransferId(int operationId) throws SQLException {
        String query = "SELECT transfer_id FROM transferOperations WHERE operation_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, operationId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int transferId = resultSet.getInt("transfer_id");
                    System.out.println("Найден transferId: " + transferId);
                    return transferId;
                } else {
                    System.out.println("TransferId не найден для operationId: " + operationId);
                }
            }
        }
        return -1;
    }

    // Получаем lotIdentifier
    public String fetchLotIdentifier(int transferId) throws SQLException {
        String query = "SELECT LotIdentifier FROM transfers WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, transferId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String lotIdentifier = resultSet.getString("LotIdentifier");
                    System.out.println("Найден LotIdentifier: " + lotIdentifier);
                    return lotIdentifier;
                } else {
                    System.out.println("LotIdentifier не найден для transferId: " + transferId);
                }
            }
        }
        return null;
    }

    // Закрываем соединение с БД
    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Соединение закрыто.");
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при закрытии соединения с БД.");
            e.printStackTrace();
        }
    }
}