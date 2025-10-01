package ge.tbc.testautomation.utils;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MSSQLConnection {

    //sql ნაწილი არ ვიცი რამდენად სწორად მუშაობს, ჩემს კომიუტერს სჭრის რაღაც და ვერაფრით ვერ დავაქონექთე.
    //sql ნაწილი დავწერე როგორც ვფიქრობდი რომ უუნდა დამეწერა უუბრალოდ კომიუტერის ხარვეზის გამო ვერ გავტესტე :(

    public static Connection connect() {
        try {
            DriverManager.registerDriver(new SQLServerDriver());

            String dbUrl = DBConfiguration.getURL();
            String dbUsername = DBConfiguration.getUsername();
            String dbPassword = DBConfiguration.getPassword();

            return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
