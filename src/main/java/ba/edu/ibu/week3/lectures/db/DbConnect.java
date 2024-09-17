package ba.edu.ibu.week3.lectures.db;

import java.sql.*;

public class DbConnect {
    private static final String CONNECTION_STRING = "jdbc:mysql://db1.ibu.edu.ba:3306/sepfin_db";
    private static final String USERNAME = "sepfin_usr";
    private static final String PASSWORD = "fin42sepUSR";

    private Connection connection = null;

    public static void main(String[] args) throws SQLException {
        DbConnect dbConnect = new DbConnect();
        dbConnect.getAllFilms();
        dbConnect.getFilmsByReleaseYear(2006);
    }

    public DbConnect() {
        try {
            connection = DriverManager.getConnection(
                    CONNECTION_STRING,
                    USERNAME,
                    PASSWORD
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getAllFilms() throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement(
                "SELECT * FROM film LIMIT 5"
        );
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("title"));
            System.out.println(rs.getString("description"));
        }
    }

    public void getFilmsByReleaseYear(int releaseYear) throws SQLException {
        // READ MORE ABOUT SQL INJECTION ATTACKS AND SHY PREPARED STATEMENT IS IMPORTANT
        PreparedStatement statement = this.connection.prepareStatement(
                "SELECT * FROM film WHERE release_year = ?"
        );
        statement.setInt(1, releaseYear);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("title"));
            System.out.println(rs.getString("description"));
        }
    }
}
