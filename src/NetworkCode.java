import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class NetworkCode {

    public static void main(String[] args) throws Exception {
        Connection connection;
        try
        {
            String url = String.format("jdbc:sqlserver://partypass.database.windows.net:1433;database=PartyPass;user=jewcubed@partypass;password={AEPi2017};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");

            // Set connection properties.
            Properties properties = new Properties();
            properties.setProperty("user", "jewcubed@partypass");
            properties.setProperty("password", "AEPi2017");
            properties.setProperty("useSSL", "true");
            properties.setProperty("verifyServerCertificate", "true");
            properties.setProperty("requireSSL", "false");

            // get connection
            connection = DriverManager.getConnection(url, properties);
        }
        catch (SQLException e)
        {
            throw new SQLException("Failed to create connection to database.", e);
        }
    }
}
