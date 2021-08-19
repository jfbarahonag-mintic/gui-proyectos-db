package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtilities {
    private static final String DATABASE_FILEPATH = "db/";
    private static final String DATABASE_FILENAME = "ProyectosConstruccion.db";
    private static final String DATABASE_LOCATION = DATABASE_FILEPATH + DATABASE_FILENAME;

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:" + DATABASE_LOCATION;

        return DriverManager.getConnection(url);
    }
}
