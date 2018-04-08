package edu.gatech.mdiamond8.partytrack.Network;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import edu.gatech.mdiamond8.partytrack.model.Party;
import edu.gatech.mdiamond8.partytrack.model.user.Attendee;
import edu.gatech.mdiamond8.partytrack.view.bartender.DrinkOrder;

public class NetworkCode {
    /**
     * Creates a table of attendess in the database
     * @throws Exception If the Network fucks up
     */
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
                "code varchar(255)," +
                "had int," +
                "oHad int," +
                "PRIMARY KEY (code))";
        stmt = connection.createStatement();
        stmt.execute(SQL);
    }

    /**
     * Deletes the table of attendees in the party database
     * @throws Exception if the network fucks up
     */
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

    /**
     * Adds a guest to the table of attendees
     * @param guest the guest to add
     * @throws Exception if the network fucks up
     */
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

    /**
     * Pull an attendee from the database
     * @param qr the qr code of the attendee
     * @return the attendee
     * @throws Exception If the network fucks up
     */
    public static Attendee getAttendee(String qr) throws Exception{
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
        SQL = String.format("SELECT * FROM Attendees WHERE code = '%s'", qr );
        stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(SQL);
        int id = 0;
        String name = "Not Applicable";
        String QR = null;
        int dH = 0;
        double oH = 0;
        while (resultSet.next()) {
            id = resultSet.getInt("ID");
            name = resultSet.getString("Name");
            QR = resultSet.getString("code");
            dH = resultSet.getInt("had");
            oH = resultSet.getDouble("oHad");
            SQL = String.format("DELETE FROM Attendees WHERE code = '%s'", qr);
            stmt = connection.createStatement();
            stmt.execute(SQL);
        }
        return new Attendee("" + id, QR, null, name);
    }

    /**
     * Creates a drink table in the database
     * @throws Exception if the network fucks up
     */
    public static void makeDrinkOrderList() throws Exception {
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
        SQL = "CREATE TABLE DrinkOrders (" +
                "Name varchar(255), " +
                "Drink text, " +
                "DrinksHad int, " +
                "AlcoholConsumed float)";
        stmt = connection.createStatement();
        stmt.execute(SQL);
    }

    /**
     * Adds a drink order to the database
     * @param drinkOrder the order to add
     * @throws Exception if the network fucks up
     */
    public static void addDrinkOrder(DrinkOrder drinkOrder) throws Exception {
        Connection connection;
        Statement stmt = null;
        String SQL;
        if (drinkOrder == null) {
            throw new IllegalArgumentException("Drink Order Cannot be Null");
        }
        try
        {
            String url = String.format("jdbc:sqlserver://partypass.database.windows.net:1433;database=PartyPass;user=jewcubed@partypass;password={AEPi2017};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
            connection = DriverManager.getConnection(url);
        }
        catch (SQLException e)
        {
            throw new SQLException("Failed to create connection to database.", e);
        }
        SQL = String.format("INSERT INTO DrinkOrders VALUES ('%s', '%s', %d, %f)",
                drinkOrder.getAttendee().getName(),
                drinkOrder.getDrink().getName(),
                drinkOrder.getAttendee().getDrinksHad(),
                drinkOrder.getAttendee().getOuncesAHad()
                );
        stmt = connection.createStatement();
        stmt.execute(SQL);
    }

    /**
     * Removes a drink order from the databse
     * @param orderName the name of the order to remove
     * @throws Exception if the network fucks up
     */
    public static void removeDrinkOrder(String orderName) throws Exception {
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
        SQL = String.format("DELETE FROM DrinkOrders WHERE name = '%s'", orderName);
        stmt = connection.createStatement();
        stmt.execute(SQL);
    }

    public static void deleteDrinkOrderList() throws Exception {
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
        SQL = "DROP TABLE DrinkOrders";
        stmt = connection.createStatement();
        stmt.execute(SQL);
    }
}
