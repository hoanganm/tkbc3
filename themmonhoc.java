package latkbc3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class themmonhoc {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/tkbc3";
        String username = "root";
        String password = "301103";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            if (connection != null) {
                System.out.println("Connected to the database!");

                // Tạo một đối tượng MonHoc
                MonHoc newMonHoc = new MonHoc(365417, "Dịa Lý", 45, 5);

                // Sử dụng PreparedStatement để thêm môn học vào cơ sở dữ liệu
                String sql = "INSERT INTO monhoc (Mamh, Tenmh, Sotietlythuyet, Sothietthuchanh) VALUES (?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, newMonHoc.getMamh());
                preparedStatement.setString(2, newMonHoc.getTenmh());
                preparedStatement.setInt(3, newMonHoc.getSotietlythuyet());
                preparedStatement.setInt(4, newMonHoc.getSothietthuchanh());

                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Môn học đã được thêm vào cơ sở dữ liệu!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

class MonHoc {
    private int Mamh;
    private String Tenmh;
    private int Sotietlythuyet;
    private int Sothietthuchanh;

    public MonHoc(int Mamh, String Tenmh, int Sotietlythuyet, int Sothietthuchanh) {
        this.Mamh = Mamh;
        this.Tenmh = Tenmh;
        this.Sotietlythuyet = Sotietlythuyet;
        this.Sothietthuchanh = Sothietthuchanh;
    }

    public int getMamh() {
        return Mamh;
    }

    public String getTenmh() {
        return Tenmh;
    }

    public int getSotietlythuyet() {
        return Sotietlythuyet;
    }

    public int getSothietthuchanh() {
        return Sothietthuchanh;
    }
}
