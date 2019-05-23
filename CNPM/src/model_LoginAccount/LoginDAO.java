package model_LoginAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LoginDAO {
	private static ArrayList<User> listUsers;

	public static ArrayList<User> getListUsers() {

		if (LoginDAO.listUsers == null) {
			listUsers = new ArrayList<User>();
		}
		try {
			Connection conn = DatabaseConnection.getConnection();
			Statement statement = conn.createStatement();
			String sql = "SELECT * FROM Users";
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				listUsers.add(new User(result.getString("userName"), result.getString("passWord")));
			}
			result.close();

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return LoginDAO.listUsers;
	}

	// 7. checkInfo(userName, pass)
	public static boolean checkInfo(String userName, String passWord) {
		Connection con = DatabaseConnection.getConnection();
		String sql = "SELECT * FROM Users WHERE userName='" + userName + "' and passWord='" + passWord + "'";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;

			}
			rs.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public static void main(String[] args) {
		System.out.println(LoginDAO.getListUsers());
		System.out.println(LoginDAO.checkInfo("ttdien", "dien1998"));
	}
}
