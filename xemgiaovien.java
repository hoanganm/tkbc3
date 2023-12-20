package latkbc3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class xemgiaovien {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/tkbc3";
        String username = "root";
        String password = "301103";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            if (connection != null) {
                System.out.println("Connected to the database!");

                // Sử dụng PreparedStatement để truy vấn thông tin giáo viên từ cơ sở dữ liệu
                String sql = "SELECT * FROM giaovien";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    String Magv = resultSet.getString("Magv");
                    String Tengv = resultSet.getString("Tengv");
                    String Diachi = resultSet.getString("Diachi");
                    String sdt = resultSet.getString("sdt");

                    // Hiển thị thông tin giáo viên
                    System.out.println("Magv: " + Magv);
                    System.out.println("Tengv: " + Tengv);
                    System.out.println("Diachi: " + Diachi);
                    System.out.println("sdt: " + sdt);
                    System.out.println();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
