package latkbc3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class xemmonhoc {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/tkbc3";
        String username = "root";
        String password = "301103";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            if (connection != null) {
                System.out.println("Connected to the database!");

                // Sử dụng PreparedStatement để truy vấn thông tin môn học từ cơ sở dữ liệu
                String sql = "SELECT * FROM monhoc";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int Mamh = resultSet.getInt("Mamh");
                    String Tenmh = resultSet.getString("Tenmh");
                    String Sotietlythuyet = resultSet.getString("Sotietlythuyet");
                    String Sothietthuchanh = resultSet.getString("Sothietthuchanh");

                    // Hiển thị thông tin môn học
                    System.out.println("Mamh: " + Mamh);
                    System.out.println("Tenmh: " + Tenmh);
                    System.out.println("Sotietlythuyet: " + Sotietlythuyet);
                    System.out.println("Sothietthuchanh: " + Sothietthuchanh);
                    System.out.println();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
