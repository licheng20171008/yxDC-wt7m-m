package com.yx.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
    private static final String url = "jdbc:mysql://localhost:3306/yxdc?user=root&password=root&useUnicode=true&characterEncoding=UTF8&useSSL=false&serverTimezone=UTC";
//    private static final String url = "jdbc:mysql://88.88.87.59:3306/indexlibrary?user=root&password=root&useUnicode=true&characterEncoding=UTF8&useSSL=true";
    private static final String name = "com.mysql.jdbc.Driver";
    private static  Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    public static Connection getConn(){
    	try {
			Class.forName(name);
			conn = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
    }
}
