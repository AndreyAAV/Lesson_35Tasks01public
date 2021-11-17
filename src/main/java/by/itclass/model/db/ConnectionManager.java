package by.itclass.model.db;

import java.sql.*;
import java.util.Objects;

public class ConnectionManager {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/itclassdb/purchase" +
            "?serverTimezone=Europe/Minsk";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    private static Connection cn;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        if (Objects.isNull(cn) || cn.isClosed()){
            cn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }
        return cn;
    }

    public static void closeStatement (Statement st) {
        if (Objects.nonNull(st)) {
            try {
                st.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeResultSet (ResultSet rs) {
        if (Objects.nonNull(rs)) {
            try {
                rs.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeConnection() {
        if (Objects.nonNull(cn)) {
            try {
                cn.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
