package com.ecodeup.test;


import java.sql.Connection;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;


public class Pool {
	private static BasicDataSource ds = null;
	
	public static BasicDataSource getDataSource (){
		if(ds == null){
			ds = new BasicDataSource();
			ds.setDriverClassName("com.mysql.jdbc.Driver");
			ds.setUsername("root");
			ds.setPassword("Peru123.");
			ds.setUrl("jdbc:mysql://localhost:3306/test?useSSL=false");
			//Definimos el tamaño del pool de conexiones
			ds.setInitialSize(50);// 50 conexiones iniciales
			ds.setMaxIdle(10);
			ds.setMaxTotal(20);
			ds.setMaxWaitMillis(5000);
		}
		return ds;
	}
	
	public static Connection getConexion()throws SQLException{
		return getDataSource().getConnection();
	}
	
}
