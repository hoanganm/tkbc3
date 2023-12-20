package latkbc3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class thamthoikhoabieu {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/tkbc3";
        String username = "root";
        String password = "301103";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            if (connection != null) {
                System.out.println("Connected to the database!");

                // Tạo một đối tượng ThoiKhoaBieu
                ThoiKhoaBieu newThoiKhoaBieu = new ThoiKhoaBieu(108, "2", "123", "70101", "365415");

                // Sử dụng PreparedStatement để thêm thời khóa biểu vào cơ sở dữ liệu
                String sql = "INSERT INTO thoikhoabieu (Malop, Thu, Sothututiet, Magv, Mamh) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, newThoiKhoaBieu.getMalop());
                preparedStatement.setString(2, newThoiKhoaBieu.getThu());
                preparedStatement.setString(3, newThoiKhoaBieu.getSothututiet());
                preparedStatement.setString(4, newThoiKhoaBieu.getMagv());
                preparedStatement.setString(5, newThoiKhoaBieu.getMamh());

                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Thời khóa biểu đã được thêm vào cơ sở dữ liệu!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

class ThoiKhoaBieu {
    private int Malop;
    private String Thu;
    private String Sothututiet;
    private String Magv;
    private String Mamh;

    public ThoiKhoaBieu(int Malop, String Thu, String Sothututiet, String Magv, String Mamh) {
        this.Malop = Malop;
        this.Thu = Thu;
        this.Sothututiet = Sothututiet;
        this.Magv = Magv;
        this.Mamh = Mamh;
    }

    public int getMalop() {
        return Malop;
    }

    public String getThu() {
        return Thu;
    }

    public String getSothututiet() {
        return Sothututiet;
    }

    public String getMagv() {
        return Magv;
    }

    public String getMamh() {
        return Mamh;
    }
}
