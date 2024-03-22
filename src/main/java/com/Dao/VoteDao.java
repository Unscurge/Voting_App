package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VoteDao {
	
	String result = "";

	public String insert(Connection con, String id, String vote) {
		try {
			String sql = "insert into vote values(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, id);
			ps.setString(2, vote);

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
	
	public int countVote(Connection con,String cname)
	{
		int count= 0;
		try
		{
			String sql = "select * from vote where cname=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cname);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally
		{
			return count;
		}
	}

}
