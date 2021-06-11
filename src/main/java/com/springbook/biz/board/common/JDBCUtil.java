package com.springbook.biz.board.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//오라클 드라이버 사용하려고, hr이랑 연결하는 함수
// 매개 2개랑 3개 있음
// 매개 2개는 인설트 딜리트 업데이트에서 사용, 리턴값이 없어서 쿼리문을 닫아 주기만 하면 됨
// 3개는 셀렉트 리절트셋으로 받아올거기 때문에 쿼리문 닫아주는거로 사용함
public class JDBCUtil {
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/studydb?serverTimezone=UTC","study","1111");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void close(PreparedStatement stmt, Connection conn) {
		if(stmt != null) {
			try {
				if(!stmt.isClosed()) stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				stmt = null;
			}
		}
		
		if(conn != null) {
			try {
				if(!conn.isClosed()) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}
	
	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
		if(rs != null) {
			try {
				if(!rs.isClosed()) rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				rs = null;
			}
		}
		
		if(stmt !=null ) {
			try {
				if(!stmt.isClosed()) stmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				stmt = null;
			}
		}
		
		if(conn != null ) {
			try {
				if(!conn.isClosed()) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}

}
