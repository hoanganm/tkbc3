package latkbc3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class themgiaovien {
    public static void main(String[] args) {
        // Thông tin kết nối đến cơ sở dữ liệu MySQL
        String jdbcURL = "jdbc:mysql://localhost:3306/tkbc3";
        String username = "root";
        String password = "301103";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            if (connection != null) {
                System.out.println("Kết nối thành công đến cơ sở dữ liệu!");

                // Dữ liệu giáo viên cần thêm
                String Magv = "70107";
                String Tengv = "Nguyễn Kim Huệ";
                String Diachi = "71, Đuong Le Đuc Tho, Phuong 14, Go Vap, TP.HCM";
                String Sdt = "955684295";

                // Sử dụng PreparedStatement để thêm giáo viên vào bảng "giaovien"
                String sql = "INSERT INTO giaovien (Magv, Tengv, Diachi, sdt) VALUES (?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, Magv);
                preparedStatement.setString(2, Tengv);
                preparedStatement.setString(3, Diachi);
                preparedStatement.setString(4, Sdt);

                // Thực hiện thêm dữ liệu
                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Thêm giáo viên thành công!");
                } else {
                    System.out.println("Thêm giáo viên thất bại.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
