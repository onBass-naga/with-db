package com.example.with_db.generator;

import com.example.with_db.generator.artifacts.*;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Generator {

    public void printSetUpModel(final Settings settings) {

        try (var connection = initConnection(settings)) {
            final var tableNames = getTableNames(connection);

            final var tables = tableNames.stream().map(tableName -> createTableModel(tableName, connection)).toList();

            TablesEnum.generate(settings, tables);
            DataSet.generate(settings, tables);

            for (var table: tables) {
                SetupModel.generate(settings, table);
                Entity.generate(settings, table);
                Records.generate(settings, table);
                Predicates.generate(settings, table);
            }

        } catch (final SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException |
                       InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private Table createTableModel(String tableName, Connection connection) {

        try {
            DatabaseMetaData meta = connection.getMetaData();
            ResultSet result = meta.getColumns(null, connection.getSchema(), tableName, "%");

            final var columns = new ArrayList<Column>();
            while (result.next()) {
                columns.add(Column.of(result));
            }

            return new Table(tableName, columns);
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static List<String> getTableNames(Connection connection) throws SQLException {
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet result = meta.getTables(null, connection.getSchema(), "%", new String[]{"TABLE"});

        List<String> tableNames = new ArrayList<>();
        while (result.next()) {
            final var name = result.getString("TABLE_NAME");
            tableNames.add(name);
        }
        return tableNames;
    }

    private Connection initConnection(Settings settings) throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String driverClassName = settings.driverClassName();
        Class<?> driver = Class.forName(driverClassName, true, Thread.currentThread().getContextClassLoader());
        java.util.Properties credential = new java.util.Properties();
        credential.put("user", settings.username());
        credential.put("password", settings.password());
        Connection conn = ((Driver) driver.getDeclaredConstructor().newInstance()).connect(settings.url(), credential);

        if (driverClassName.contains("postgres")) {
            String schema = settings.schema();
            String schemaName = schema == null ? "public" : schema;
            conn.setSchema(schemaName);
        }

        return conn;
    }

    public static void main(String[] args) {
        final var settings = new Settings(
                "org.postgresql.Driver",
                "jdbc:postgresql://localhost:5432/sample",
                null,
                "postgres",
                "postgres",
                "./example/src/main/java/org/example/generated",
                "org.example.generated",
                "Sample"
        );
        new Generator().printSetUpModel(settings);
    }
}
