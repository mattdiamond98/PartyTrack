package edu.gatech.mdiamond8.partytrack.Network;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import edu.gatech.mdiamond8.partytrack.model.Party;
import edu.gatech.mdiamond8.partytrack.model.user.Attendee;

public class NetworkCode {

    public static void main(String[] args) throws Exception {
        deleteAttendees();
        makeAttendees();
        addGuest(new Attendee());
        getAttendee(123456789);
    }
    public static void makeAttendees() throws Exception {
        Connection connection;
        Statement stmt = null;
        String SQL;
        try
        {
            String url = String.format("jdbc:sqlserver://partypass.database.windows.net:1433;database=PartyPass;user=jewcubed@partypass;password={AEPi2017};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
            connection = DriverManager.getConnection(url);
        }
        catch (SQLException e)
        {
            throw new SQLException("Failed to create connection to database.", e);
        }
        SQL = "CREATE TABLE Attendees (" +
                "ID int," +
                "Name text," +
                "code text," +
                "had int," +
                "oHad int," +
                "PRIMARY KEY (ID))";
        stmt = connection.createStatement();
        stmt.execute(SQL);
    }
    public static void deleteAttendees() throws Exception {
        Connection connection;
        Statement stmt = null;
        String SQL;
        try
        {
            String url = String.format("jdbc:sqlserver://partypass.database.windows.net:1433;database=PartyPass;user=jewcubed@partypass;password={AEPi2017};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
            connection = DriverManager.getConnection(url);
        }
        catch (SQLException e)
        {
            throw new SQLException("Failed to create connection to database.", e);
        }
        SQL = "DROP TABLE Attendees";
        stmt = connection.createStatement();
        stmt.execute(SQL);
    }

    public static void addGuest(Attendee guest) throws Exception {
        Connection connection;
        Statement stmt = null;
        String SQL;
        try
        {
            String url = String.format("jdbc:sqlserver://partypass.database.windows.net:1433;database=PartyPass;user=jewcubed@partypass;password={AEPi2017};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
            connection = DriverManager.getConnection(url);
        }
        catch (SQLException e)
        {
            throw new SQLException("Failed to create connection to database.", e);
        }
        SQL = String.format("INSERT INTO Attendees VALUES (%d, '%s', '%s', %d, %f);",
                Integer.parseInt(guest.getid()),
                guest.getName(),
                guest.getqrCode(),
                guest.getDrinksHad(),
                guest.getOuncesAHad());
        stmt = connection.createStatement();
        stmt.execute(SQL);
    }
    public static Attendee getAttendee(int idNumber) throws Exception{
        Connection connection;
        Statement stmt = null;
        String SQL;
        try
        {
            String url = String.format("jdbc:sqlserver://partypass.database.windows.net:1433;database=PartyPass;user=jewcubed@partypass;password={AEPi2017};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
            connection = DriverManager.getConnection(url);
        }
        catch (SQLException e)
        {
            throw new SQLException("Failed to create connection to database.", e);
        }
        SQL = String.format("SELECT * FROM Attendees WHERE ID = %d", idNumber);
        stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(SQL);
        resultSet.next();
        int id = resultSet.getInt("ID");
        String name = resultSet.getString("Name");
        String QR = resultSet.getString("code");
        int dH = resultSet.getInt("had");
        double oH = resultSet.getDouble("oHad");
        return new Attendee("" + id, QR, null, name);
    }
}
