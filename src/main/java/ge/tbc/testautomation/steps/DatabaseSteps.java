package ge.tbc.testautomation.steps;

import ge.tbc.testautomation.utils.LocationCase;
import ge.tbc.testautomation.utils.MSSQLConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseSteps {
    public List<LocationCase> getAllLocationCases() {
        List<LocationCase> locationCases = new ArrayList<>();
        try (Connection connection = MSSQLConnection.connect()) {
            String SQL = "SELECT id, area, expected_min_results FROM location_cases";
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                locationCases.add(new LocationCase(
                        resultSet.getInt("id"),
                        resultSet.getString("area"),
                        resultSet.getInt("expected_min_results")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return locationCases;
    }
}
