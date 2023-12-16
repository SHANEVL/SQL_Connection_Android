package db;

import android.content.Context;
import android.os.StrictMode;
import android.widget.Toast;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {

    // IPCONFIG in CMD to get your IP ADDRESS
    // Or 10.0.2.2 for LOCALHOST
    // Using SQL server directly IS NOT RECOMMENDED
    // Use a WEB SERVICE
    // Also note: I allow network operations on main thread = no bueno

    private static String ip = "10.0.2.2";
    private static String port = "1433";
    private static String Classes = "net.sourceforge.jtds.jdbc.Driver";
    private static String database = "DATABASENAME";
    private static String username = "USERNAME";
    private static String password = "PASSWORD";
    private static String url = "jdbc:jtds:sqlserver://" + ip + ":" + port + "/" + database;

    private static Connection connection = null;

    public static Connection openConnection(Context context) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {
            // Check if connection is already open
            if (connection != null && !connection.isClosed()) {
                Toast.makeText(context, "Connection already established", Toast.LENGTH_SHORT).show();
                return connection;
            }

            Class.forName(Classes);
            connection = DriverManager.getConnection(url, username, password);
            Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
        } catch (ClassNotFoundException e) {
            Toast.makeText(context, "Class not found: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        } catch (SQLException e) {
            Toast.makeText(context, "SQL Exception: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Context context) {
        try {
            // Check if connection is already closed
            if (connection == null || connection.isClosed()) {
                Toast.makeText(context, "Connection is already closed", Toast.LENGTH_SHORT).show();
                return;
            }

            connection.close();
            Toast.makeText(context, "Connection Closed", Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            Toast.makeText(context, "SQL Exception: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}
