package latkbc3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class xoamonhoc {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/tkbc3";
        String username = "root";
        String password = "301103";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            if (connection != null) {
                System.out.println("Connected to the database!");

                // Sử dụng PreparedStatement để xóa thông tin môn học từ cơ sở dữ liệu
                String sql = "DELETE FROM.monhoc WHERE Mamh = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                // Thiết lập giá trị cho tham số Mamh (ID môn học cần xóa)
                int MamhToDelete = 1; // Thay thế bằng giá trị thực tế của Mamh cần xóa
                preparedStatement.setInt(365410, MamhToDelete);

                // Thực hiện xóa
                int rowsDeleted = preparedStatement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Môn học đã được xóa thành công!");
                } else {
                    System.out.println("Không tìm thấy môn học cần xóa.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
