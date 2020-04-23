package com.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.dto.User;
import com.util.DBUtil;

public class UserDao implements UserDaoInterface{

	@Override
	public void signIn(User user) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into user (id, pw, email, address, tel) \n");
			sql.append("values (? , ? , ? , ? , ?)");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getTel());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}

	@Override
	public void login(String id, String pw) throws SQLException {
		
	}

	@Override
	public User getUser(String id) throws SQLException {
		return null;
	}

	@Override
	public void updateUser(User user) throws SQLException {
		
	}

}
