package ba.edu.ibu.week3.lectures.livesession.firstgroup;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManagerCustom {
    private static String connectionString = "jdbc:mysql://localhost:3306/classicmodels";
    private static String username = "root";
    private static String password = "12345678";

    private static Connection connection;

    public DatabaseManagerCustom() { // 1st version
        try {
            connection = DriverManager.getConnection(connectionString, username, password);
            System.out.println("Connected to database");
        } catch (SQLException e) {
            e.printStackTrace(); // 2nd version of handling exceptions
        }
    }

    public static List<String> getAllEmployees(){
        List<String> employees = new ArrayList<>();

        String query = "SELECT * FROM employees";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                employees.add(
                        resultSet.getString("firstName") + " " +
                        resultSet.getInt("employeeNumber"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return employees;
    }

    public static String getEmployeeByFirstName(String firstName){
        String querySecond = "SELECT * FROM employees WHERE firstName " + firstName;
        String query = "SELECT * FROM employees WHERE firstName = ? AND customerId = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, firstName);
            statement.setInt(2, 1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }

    public static void main(String[] args) {
        DatabaseManagerCustom dbInstance = new DatabaseManagerCustom();
        List<String> employees = getAllEmployees();
        for (String employee : employees) {
            System.out.println(employee);
        }
    }
}
