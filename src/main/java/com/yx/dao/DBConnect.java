package com.yx.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBConnect {
	public SqlSessionFactory ssf  = null;

    public DBConnect(){

		InputStream is = null;
		try {
			// 获取路径
			String resource = "mybatis-config.xml";

			// 获取信息流
			is = Resources.getResourceAsStream(resource);

			// 创建会话工厂
			ssf = new SqlSessionFactoryBuilder().build(is);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
