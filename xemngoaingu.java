package latkbc3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class xemngoaingu {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/tkbc3";
        String username = "root";
        String password = "301103";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            if (connection != null) {
                System.out.println("Connected to the database!");

                // Sử dụng PreparedStatement để truy vấn thông tin ngoại ngữ từ cơ sở dữ liệu
                String sql = "SELECT * FROM ngoaingu";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int Mann = resultSet.getInt("Mann");
                    String Tennn = resultSet.getString("Tennn");

                    // Hiển thị thông tin ngoại ngữ
                    System.out.println("Mann: " + Mann);
                    System.out.println("Tennn: " + Tennn);
                    System.out.println();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
