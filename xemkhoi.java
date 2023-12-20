package latkbc3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class xemkhoi {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/tkbc3";
        String username = "root";
        String password = "301103";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            if (connection != null) {
                System.out.println("Connected to the database!");

                // Sử dụng PreparedStatement để truy vấn thông tin khối từ cơ sở dữ liệu
                String sql = "SELECT * FROM khoi";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    String Mak = resultSet.getString("Mak");
                    String Tenk = resultSet.getString("Tenk");

                    // Hiển thị thông tin khối
                    System.out.println("Mak: " + Mak);
                    System.out.println("Tenk: " + Tenk);
                    System.out.println();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
