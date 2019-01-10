package com.ecodeup.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDAO {
	private Connection connection = null;

	

	public boolean registar(Articulo a) throws SQLException {
		boolean estado = false;
		connection = getConnnection();
		Statement stm;

		String sql = "INSERT INTO articulos (nombre,descripcion,precio) values ('" + a.getNombre() + "','"
				+ a.getDescripcion() + "','" + a.getPrecio() + "');";
		try {
			
			connection.setAutoCommit(false); // Le indicamos el inicio de la transaccion
			stm = connection.createStatement();
			stm.executeUpdate(sql);
			connection.commit(); // Si todo va bien hacemos commit y guardamos los datos
			estado = true;
			stm.close();
			connection.close();
		} catch (Exception e) {
			try {
				estado = false;
				connection.rollback();//Si algo paso en la transaccion hacemos rollback
			} catch (Exception e2) {
				
			}
		
			e.printStackTrace();
		}
		return estado;
	}	

	public boolean actualizar(Articulo a) throws SQLException {
		boolean estado = false;
		connection = getConnnection();
		Statement stm;
		String sql = "UPDATE articulos SET nombre='" + a.getNombre() + "' where id=" + a.getId() + ";";
		try {			
			stm = connection.createStatement();
			stm.executeUpdate(sql);
			estado = true;
			stm.close();
			connection.close();
		} catch (Exception e) {
			estado = false;
			e.printStackTrace();
		}
		return estado;
	}

	public boolean eliminar(Articulo a) throws SQLException {
		boolean estado = false;
		connection = getConnnection();
		Statement stm;
		String sql = "DELETE FROM articulos WHERE id=" + a.getId() + ";";
		try {
			stm = connection.createStatement();
			stm.executeUpdate(sql);
			estado = true;
			stm.close();
			connection.close();
		} catch (Exception e) {
			estado = false;
			e.printStackTrace();
		}
		return estado;
	}

	public void obtenerArticulos() throws SQLException {
		Statement stm;
		ResultSet res = null;
		Articulo a;
		connection = getConnnection();
		String sql = "SELECT * FROM articulos;";

		try {
			
			stm = connection.createStatement();
			res = stm.executeQuery(sql);

			while (res.next()) {
				a = new Articulo(res.getInt("id"), res.getString("nombre"), res.getString("descripcion"),
						res.getDouble("precio"));
				System.out.println(a);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ObtenerArticulo(int id) throws SQLException {
		Statement stm;
		ResultSet rs = null;
		connection = getConnnection();

		String sql = "SELECT * FROM articulos WHERE id=" + id + ";";

		try {
			stm = connection.createStatement();
			rs = stm.executeQuery(sql);
			Articulo a;
			if (rs.next()) {
				a = new Articulo(rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion"),
						rs.getDouble("precio"));
				System.out.println(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private Connection getConnnection() throws SQLException {		
		return Pool.getConexion();
	}
}
