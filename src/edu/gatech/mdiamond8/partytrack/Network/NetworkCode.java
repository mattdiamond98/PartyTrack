package edu.gatech.mdiamond8.partytrack.Network;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import edu.gatech.mdiamond8.partytrack.model.Party;
import edu.gatech.mdiamond8.partytrack.model.user.Attendee;

public class NetworkCode {

    public static void main(String[] args) throws Exception {
        if (createParty(new Party())) {
            System.out.println("Yay");
        }
    }

    public static boolean createParty(Party party) throws Exception {
        Connection connection;
        Statement stmt = null;
        try
        {
            String url = String.format("jdbc:sqlserver://partypass.database.windows.net:1433;database=PartyPass;user=jewcubed@partypass;password={AEPi2017};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
            connection = DriverManager.getConnection(url);
        }
        catch (SQLException e)
        {
            throw new SQLException("Failed to create connection to database.", e);
        }
        String SQL = "";
        stmt = connection.createStatement();
        return stmt.execute(SQL);
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
                "code text" +
                ")";
    }
    public static Attendee getAttendee(){return null;}
}
