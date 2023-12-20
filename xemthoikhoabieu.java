package latkbc3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class xemthoikhoabieu {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/tkbc3";
        String username = "root";
        String password = "301103";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            if (connection != null) {
                System.out.println("Connected to the database!");

                // Sử dụng PreparedStatement để truy vấn thông tin thời khóa biểu từ cơ sở dữ liệu
                String sql = "SELECT * FROM thoikhoabieu";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int Malop = resultSet.getInt("Malop");
                    String Thu = resultSet.getString("Thu");
                    String Sothututiet = resultSet.getString("Sothututiet");
                    String Magv = resultSet.getString("Magv");
                    String Mamh = resultSet.getString("Mamh");

                    // Hiển thị thông tin thời khóa biểu
                    System.out.println("Malop: " + Malop);
                    System.out.println("Thu: " + Thu);
                    System.out.println("Sothututiet: " + Sothututiet);
                    System.out.println("Magv: " + Magv);
                    System.out.println("Mamh: " + Mamh);
                    System.out.println();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
