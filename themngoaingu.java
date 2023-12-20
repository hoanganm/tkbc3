package latkbc3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class themngoaingu {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/tkbc3";
        String username = "root";
        String password = "301103";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            if (connection != null) {
                System.out.println("Connected to the database!");

                // Tạo một đối tượng NgoaiNgu
                NgoaiNgu newNgoaiNgu = new NgoaiNgu(1, "Tiếng Anh");

                // Sử dụng PreparedStatement để thêm ngoại ngữ vào cơ sở dữ liệu
                String sql = "INSERT INTO ngoaingu (Mann, Tennn) VALUES (?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, newNgoaiNgu.getMann());
                preparedStatement.setString(2, newNgoaiNgu.getTennn());

                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Ngoại ngữ đã được thêm vào cơ sở dữ liệu!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

class NgoaiNgu {
    private int Mann;
    private String Tennn;

    public NgoaiNgu(int Mann, String Tennn) {
        this.Mann = Mann;
        this.Tennn = Tennn;
    }

    public int getMann() {
        return Mann;
    }

    public String getTennn() {
        return Tennn;
    }
}
