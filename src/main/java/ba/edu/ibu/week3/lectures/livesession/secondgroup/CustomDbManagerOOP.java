package ba.edu.ibu.week3.lectures.livesession.secondgroup;

import java.sql.*;

public class CustomDbManagerOOP {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/classicmodels";
    private static final String USER = "root";
    private static final String PASSWORD = "12345678";

    private static Connection connection;

    public CustomDbManagerOOP() {// throws SQLException { // one way of resolving error
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING, USER, PASSWORD);
            System.out.println("Successfully connected to database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CustomDbManagerOOP manager = new CustomDbManagerOOP();
        getEmployeeByIdLessThenAndLastName(1188, "Patterson");
        System.out.println("--------------------------");
        getAllEmployees();
    }

    public static void getAllEmployees() {
        String sql = "SELECT * FROM employees";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getInt("employeeNumber") + " " +
                        resultSet.getString("email") + " " +
                        resultSet.getString("jobTitle")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getEmployeeByIdLessThenAndLastName(int id, String lastName) {
        String sql = """
                      SELECT *
                      FROM employees
                      WHERE employeeNumber < ? AND lastName = ?
                     """;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, lastName);

            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                System.out.println(
                        rs.getInt("employeeNumber") + " " +
                        rs.getString("lastName") + " " +
                        rs.getString("email")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
