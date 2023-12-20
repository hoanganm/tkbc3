package latkbc3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class xoathoikhoabieu {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/tkbc3";
        String username = "root";
        String password = "301103";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            if (connection != null) {
                System.out.println("Connected to the database!");

                // Sử dụng PreparedStatement để xóa thông tin thời khóa biểu từ cơ sở dữ liệu
                String sql = "DELETE FROM.thoikhoabieu WHERE Malop = ? AND Thu = ? AND Sothututiet = ? AND Magv = ? AND Mamh = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                // Thiết lập giá trị cho các tham số cần xóa
                int MalopToDelete = 1; // Thay thế bằng giá trị thực tế của Malop cần xóa
                String ThuToDelete = "2"; // Thay thế bằng giá trị thực tế của Thu cần xóa
                String SothututietToDelete = "123"; // Thay thế bằng giá trị thực tế của Sothututiet cần xóa
                String MagvToDelete = "70101"; // Thay thế bằng giá trị thực tế của Magv cần xóa
                String MamhToDelete = "365415"; // Thay thế bằng giá trị thực tế của Mamh cần xóa

                preparedStatement.setInt(1, MalopToDelete);
                preparedStatement.setString(2, ThuToDelete);
                preparedStatement.setString(3, SothututietToDelete);
                preparedStatement.setString(4, MagvToDelete);
                preparedStatement.setString(5, MamhToDelete);

                // Thực hiện xóa
                int rowsDeleted = preparedStatement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Thời khóa biểu đã được xóa thành công!");
                } else {
                    System.out.println("Không tìm thấy thời khóa biểu cần xóa.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
