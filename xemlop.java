package latkbc3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class xemlop {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/tkbc3";
        String username = "root";
        String password = "301103";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            if (connection != null) {
                System.out.println("Connected to the database!");

                // Sử dụng PreparedStatement để truy vấn thông tin lớp từ cơ sở dữ liệu
                String sql = "SELECT * FROM lop";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int Malop = resultSet.getInt("Malop");
                    String Tenlop = resultSet.getString("Tenlop");
                    String Mak = resultSet.getString("Mak");
                    String Mann = resultSet.getString("Mann");
                    String Siso = resultSet.getString("Siso");

                    // Hiển thị thông tin lớp
                    System.out.println("Malop: " + Malop);
                    System.out.println("Tenlop: " + Tenlop);
                    System.out.println("Mak: " + Mak);
                    System.out.println("Mann: " + Mann);
                    System.out.println("Siso: " + Siso);
                    System.out.println();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
