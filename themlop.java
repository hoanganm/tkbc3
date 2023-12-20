package latkbc3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class themlop {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/tkbc3";
        String username = "root";
        String password = "301103";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            if (connection != null) {
                System.out.println("Connected to the database!");

                // Tạo một đối tượng LopHoc
                LopHoc newLopHoc = new LopHoc(1, "108", "11A7", "c", "154022");

                // Sử dụng PreparedStatement để thêm lớp học vào cơ sở dữ liệu
                String sql = "INSERT INTO lop (Malop, Tenlop, Mak, Mann, Siso) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, newLopHoc.getMalop());
                preparedStatement.setString(2, newLopHoc.getTenlop());
                preparedStatement.setString(3, newLopHoc.getMak());
                preparedStatement.setString(4, newLopHoc.getMann());
                preparedStatement.setString(5, newLopHoc.getSiso());

                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Lớp học đã được thêm vào cơ sở dữ liệu!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

class LopHoc {
    private int Malop;
    private String Tenlop;
    private String Mak;
    private String Mann;
    private String Siso;

    public LopHoc(int Malop, String Tenlop, String Mak, String Mann, String Siso) {
        this.Malop = Malop;
        this.Tenlop = Tenlop;
        this.Mak = Mak;
        this.Mann = Mann;
        this.Siso = Siso;
    }

    public int getMalop() {
        return Malop;
    }

    public String getTenlop() {
        return Tenlop;
    }

    public String getMak() {
        return Mak;
    }

    public String getMann() {
        return Mann;
    }

    public String getSiso() {
        return Siso;
    }
}
