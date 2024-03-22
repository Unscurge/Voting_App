package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDao {
	
	String result = "";

	public String insert(Connection con, String id, String upass) {
		try {
			String sql = "insert into users values(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, id);
			ps.setString(2, upass);

			int i = ps.executeUpdate();
			if (i == 1) {
				result = "inserted";
			} else {
				result = "failed";
			}
		} catch (Exception e) {
			result = "failed";
			System.out.println(e);
		} finally {
			return result;
		}

	}
	
	public String checkUser(Connection con, String id, String upass) {
		try {
			String sql = "select * from users";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				if (rs.getString(1).equals(id) && rs.getString(2).equals(upass)) {
					result = "exits";
					break;
				} else {
					result = "not exits";
				}
			}
		} catch (Exception e) {
			result = "not exits";
		} finally {
			return result;
		}
	}

}
