package latkbc3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class themkhoi {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/tkbc3";
        String username = "root";
        String password = "301103";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            if (connection != null) {
                System.out.println("Connected to the database!");

                // Tạo một đối tượng Khoi
                Khoi newKhoi = new Khoi("C", "Xã Hội");

                // Sử dụng PreparedStatement để thêm khối học vào cơ sở dữ liệu
                String sql = "INSERT INTO khoi (Mak, Tenk) VALUES (?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, newKhoi.getMaKhoi());
                preparedStatement.setString(2, newKhoi.getTenKhoi());

                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Khối học đã được thêm vào cơ sở dữ liệu!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

class Khoi {
    private String Mak;
    private String Tenk;

    public Khoi(String Mak, String Tenk) {
        this.Mak = Mak;
        this.Tenk = Tenk;
    }

    public String getMaKhoi() {
        return Mak;
    }

    public String getTenKhoi() {
        return Tenk;
    }
}
