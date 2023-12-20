package latkbc3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class xoagiaovien {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/tkbc3";
        String username = "root";
        String password = "301103";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            if (connection != null) {
                System.out.println("Connected to the database!");

                // Sử dụng PreparedStatement để xóa thông tin giáo viên từ cơ sở dữ liệu
                String sql = "DELETE FROM.giaovien WHERE Magv = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                // Thiết lập giá trị cho tham số Magv (ID giáo viên cần xóa)
                int MagvToDelete = 1; // Thay thế bằng giá trị thực tế của Magv cần xóa
                preparedStatement.setInt(70107, MagvToDelete);

                // Thực hiện xóa
                int rowsDeleted = preparedStatement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Giáo viên đã được xóa thành công!");
                } else {
                    System.out.println("Không tìm thấy giáo viên cần xóa.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
