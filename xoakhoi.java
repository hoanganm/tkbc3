package latkbc3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class xoakhoi {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/tkbc3";
        String username = "root";
        String password = "301103";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            if (connection != null) {
                System.out.println("Connected to the database!");

                // Sử dụng PreparedStatement để xóa thông tin khối từ cơ sở dữ liệu
                String sql = "DELETE FROM.khoi WHERE Mak = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                // Thiết lập giá trị cho tham số Mak (ID khối cần xóa)
                int MakToDelete = 1; // Thay thế bằng giá trị thực tế của Mak cần xóa
                preparedStatement.setInt(MakToDelete, MakToDelete);

                // Thực hiện xóa
                int rowsDeleted = preparedStatement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Khối đã được xóa thành công!");
                } else {
                    System.out.println("Không tìm thấy khối cần xóa.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
