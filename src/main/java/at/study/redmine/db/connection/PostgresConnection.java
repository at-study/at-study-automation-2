package at.study.redmine.db.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.postgresql.util.PSQLException;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import lombok.SneakyThrows;

import static at.study.redmine.property.Property.getIntegerProperty;
import static at.study.redmine.property.Property.getStringProperty;

public class PostgresConnection implements DatabaseConnection {
    public final static DatabaseConnection INSTANCE = new PostgresConnection();

    private String host = getStringProperty("db.host");
    private Integer port = getIntegerProperty("db.port");
    private String database = getStringProperty("db.database");
    private String user = getStringProperty("db.user");
    private String password = getStringProperty("db.password");
    private Connection connection;

    public PostgresConnection() {
        connect();
    }

    @SneakyThrows
    private void connect() {
        Class.forName("org.postgresql.Driver");

        String url = String.format("jdbc:postgresql://%s:%d/%s", host, port, database);
        Properties connectionProperties = new Properties();
        connectionProperties.setProperty("user", user);
        connectionProperties.setProperty("password", password);

        connection = DriverManager.getConnection(url, connectionProperties);
    }

    @Override
    @SneakyThrows
    @Step("Выполнение SQL-запроса")
    public synchronized List<Map<String, Object>> executeQuery(String query, Object... parameters) {
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            for (int i = 0; i < parameters.length; i++) {
                stmt.setObject(i + 1, parameters[i]);
            }
            Allure.addAttachment("SQL-запрос", stmt.toString());
            ResultSet rs = stmt.executeQuery();

            List<Map<String, Object>> result = new ArrayList<>();
            while (rs.next()) {
                int columnCount = rs.getMetaData().getColumnCount();
                Map<String, Object> resultRow = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    String key = rs.getMetaData().getColumnName(i);
                    Object value = rs.getObject(key);
                    resultRow.put(key, value);
                }
                result.add(resultRow);
            }
            Allure.addAttachment("SQL-ответ", result.toString());
            return result;
        } catch (PSQLException exc) {
            if (exc.getMessage().equals("Запрос не вернул результатов.")) {
                return null;
            } else {
                throw exc;
            }
        }
    }
}
