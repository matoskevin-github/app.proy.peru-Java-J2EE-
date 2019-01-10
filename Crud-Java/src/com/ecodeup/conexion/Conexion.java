package com.ecodeup.conexion;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class Conexion {
	private static BasicDataSource datasource = null;

	private static DataSource getDataSource() {
		if (datasource == null) {
			datasource = new BasicDataSource();
			datasource.setDriverClassName("com.mysql.jdbc.Driver");
			datasource.setUsername("root");
			datasource.setPassword("Peru123.");
			datasource.setUrl("jdbc:mysql://localhost:3306/test?useSSL=false");

			datasource.setInitialSize(20);
			datasource.setMaxIdle(15);
			datasource.setMaxTotal(20);
			datasource.setMaxWaitMillis(5000);
		}
		return datasource;
	}

	public static Connection getConnection() {
		Connection cn = null;
		try {
			cn = getDataSource().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cn;
	}

}
