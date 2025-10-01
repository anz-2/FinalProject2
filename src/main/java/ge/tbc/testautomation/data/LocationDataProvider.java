package ge.tbc.testautomation.data;

import ge.tbc.testautomation.utils.MSSQLConnection;
import org.testng.annotations.DataProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationDataProvider {
    @DataProvider(name = "locationData")
    public static Object[][] getLocationData() {
        try (Connection connection = MSSQLConnection.connect()) {
            String SQL = "SELECT area, expected_min_results FROM location_cases";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.last();
            int rowCount = resultSet.getRow();
            resultSet.beforeFirst();

            Object[][] data = new Object[rowCount][2];
            int index = 0;
            while (resultSet.next()) {
                data[index][0] = resultSet.getString("area");
                data[index][1] = resultSet.getInt("expected_min_results");
                index++;
            }
            return data;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
