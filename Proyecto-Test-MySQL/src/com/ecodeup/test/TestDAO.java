package com.ecodeup.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDAO {
	private Conexion con;

	public TestDAO(String jdbcURL, String jdbcUserName, String jdbcPassword) throws SQLException {
		con = new Conexion(jdbcURL, jdbcUserName, jdbcPassword);
		con.connection();
		System.out.println(con.getJdbcConnection());
	}

	public boolean registar(Articulo a) {
		boolean estado = false;
		Statement stm;

		String sql = "INSERT INTO articulos (nombre,descripcion,precio) values ('" + a.getNombre() + "','"
				+ a.getDescripcion() + "','" + a.getPrecio() + "');";
		try {
			con.connection();
			con.getJdbcConnection().setAutoCommit(false); // Le indicamos el inicio de la transaccion
			stm = con.getJdbcConnection().createStatement();
			stm.executeUpdate(sql);
			con.getJdbcConnection().commit(); // Si todo va bien hacemos commit y guardamos los datos
			estado = true;
			stm.close();
			con.disconect();
		} catch (Exception e) {
			try {
				estado = false;
				con.getJdbcConnection().rollback();//Si algo paso en la transaccion hacemos rollback
			} catch (Exception e2) {
				
			}
		
			e.printStackTrace();
		}
		return estado;
	}

	public boolean actualizar(Articulo a) {
		boolean estado = false;
		Statement stm;
		String sql = "UPDATE articulos SET nombre='" + a.getNombre() + "' where id=" + a.getId() + ";";
		try {
			con.connection();
			stm = con.getJdbcConnection().createStatement();
			stm.executeUpdate(sql);
			estado = true;
			stm.close();
			con.disconect();
		} catch (Exception e) {
			estado = false;
			e.printStackTrace();
		}
		return estado;
	}

	public boolean eliminar(Articulo a) {
		boolean estado = false;
		Statement stm;
		String sql = "DELETE FROM articulos WHERE id=" + a.getId() + ";";
		try {
			con.connection();
			stm = con.getJdbcConnection().createStatement();
			stm.executeUpdate(sql);
			estado = true;
			stm.close();
			con.disconect();
		} catch (Exception e) {
			estado = false;
			e.printStackTrace();
		}
		return estado;
	}

	public void obtenerArticulos() {
		Statement stm;
		ResultSet res = null;
		Articulo a;
		String sql = "SELECT * FROM articulos;";

		try {
			con.connection();
			stm = con.getJdbcConnection().createStatement();
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

	public void ObtenerArticulo(int id) {
		Statement stm;
		ResultSet rs = null;

		String sql = "SELECT * FROM articulos WHERE id=" + id + ";";

		try {
			con.connection();
			stm = con.getJdbcConnection().createStatement();
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
}
