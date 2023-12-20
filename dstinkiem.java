package latkbc3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class dstinkiem {
	public static void main(String[] args) throws SQLException {
		// Thông tin kết nối đến cơ sở dữ liệu MySQL
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String jdbcURL = "jdbc:mysql://localhost:3306/tkbc3?useSSL=false";
			String username = "root";
			String password = "301103";
			connection connection=(connection)DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Kết nối thành công đến MySQL!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Kết nối ko thành công đến MySQL!");
			e.printStackTrace();
		}
		String jdbcURL = "jdbc:mysql://localhost:3306/tkbc3";
		String username = "root";
		String password = "301103";

		try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
			if (connection != null) {
				System.out.println("Kết nối thành công đến MySQL!");

				Scanner scanner = new Scanner(System.in);
				System.out.print("Nhập từ khóa tìm kiếm: ");
				String keyword = scanner.nextLine();

				// Tìm kiếm trong bảng "giaovien"
				searchbangiaovien(connection, keyword);

				// Tìm kiếm trong bảng "khoi"
				searchkhoi(connection, keyword);

				// Tìm kiếm trong bảng "lop"
				searchInLop(connection, keyword);

				// Tìm kiếm trong bảng "monhoc"
				searchInmonhoc(connection, keyword);

				// Tìm kiếm trong bảng "ngoaingu"
				searchInngoaingu(connection, keyword);

				// Tìm kiếm trong bảng "thoikoabieu"
				searchInthoikhoabieu(connection, keyword);

				scanner.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void searchInLop(Connection connection, String keyword) {
		String sql = "SELECT * FROM tkbc3.lop WHERE ten_lop LIKE ? OR ma_lop LIKE ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, "%" + keyword + "%");
			preparedStatement.setString(2, "%" + keyword + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int Malop = resultSet.getInt("Malop");
				String Tenlop = resultSet.getString("Tenlop");
				String Mak = resultSet.getString("Mak");
				String Mann = resultSet.getString("Mann");
				String Siso = resultSet.getString("Siso");

				// Thực hiện xử lý hoặc hiển thị kết quả tìm kiếm tại đây
				System.out.println("Malop: " + Malop);
				System.out.println("Tenlop: " + Tenlop);
				System.out.println("Mak: " + Mak);
				System.out.println("Mann: " + Mann);
				System.out.println("Siso: " + Siso);
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void searchInngoaingu(Connection connection, String keyword) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tkbc3.ngoaingu WHERE ten_ngon_ngu LIKE ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, "%" + keyword + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int Mann = resultSet.getInt("Mann");
				String Tennn = resultSet.getString("Tennn");

				// Thực hiện xử lý hoặc hiển thị kết quả tìm kiếm tại đây
				System.out.println("Mann: " + Mann);
				System.out.println("Tennn: " + Tennn);
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void searchInthoikhoabieu(Connection connection, String keyword) {
		String sql = "SELECT * FROM tkbc3.thoikhoabieu WHERE class_name LIKE ? OR day_of_week LIKE ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, "%" + keyword + "%");
			preparedStatement.setString(2, "%" + keyword + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int Malop = resultSet.getInt("Malop");
				String Thu = resultSet.getString("Thu");
				String Sothututiet = resultSet.getString("Sothututiet");
				String Magv = resultSet.getString("Magv");
				String Mamh = resultSet.getString("Mamh");

				// Thực hiện xử lý hoặc hiển thị kết quả tìm kiếm tại đây
				System.out.println("Malop: " + Malop);
				System.out.println("Thu: " + Thu);
				System.out.println("Sothututiet: " + Sothututiet);
				System.out.println("Magv: " + Magv);
				System.out.println("Mamh: " + Mamh);
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void searchInmonhoc(Connection connection, String keyword) {
		String sql = "SELECT * FROM tkbc3.monhoc WHERE ten_mon_hoc LIKE ? OR ma_mon_hoc LIKE ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, "%" + keyword + "%");
			preparedStatement.setString(2, "%" + keyword + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int Mamh = resultSet.getInt("Mamh");
				String Tenmh = resultSet.getString("Tenmh");
				String Sotietlythuyet = resultSet.getString("Sotietlythuyet");

				// Thực hiện xử lý hoặc hiển thị kết quả tìm kiếm tại đây
				System.out.println("Mamh: " + Mamh);
				System.out.println("Tenmh: " + Tenmh);
				System.out.println("Sotietlythuyet: " + Sotietlythuyet);
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void searchkhoi(Connection connection, String keyword) {
		String sql = "SELECT * FROM tkbc3.khoi WHERE ten_khoi LIKE ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, "%" + keyword + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int Mak = resultSet.getInt("Mak");
				String Tenk = resultSet.getString("Tenk");

				// Thực hiện xử lý hoặc hiển thị kết quả tìm kiếm tại đây
				System.out.println("Mak: " + Mak);
				System.out.println("Tenk: " + Tenk);
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void searchbangiaovien(Connection connection, String keyword) {
		String sql = "SELECT * FROM tkbc3.giaovien WHERE ten_giao_vien LIKE ? OR mon_hoc LIKE ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, "%" + keyword + "%");
			preparedStatement.setString(2, "%" + keyword + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int Magv = resultSet.getInt("Magv");
				String Tengv = resultSet.getString("Tengv");
				String Diachi = resultSet.getString("Diachi");
				String sdt = resultSet.getString("sdt");

				// Thực hiện xử lý hoặc hiển thị kết quả tìm kiếm tại đây
				System.out.println("Magv: " + Magv);
				System.out.println("Tengv: " + Tengv);
				System.out.println("Diachi: " + Diachi);
				System.out.println("sdt: " + sdt);
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

// Tương tự, bạn có thể thêm các phương thức tìm kiếm cho các bảng khác.
