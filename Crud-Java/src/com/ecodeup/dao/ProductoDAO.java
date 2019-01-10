package com.ecodeup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecodeup.conexion.Conexion;
import com.ecodeup.model.Producto;

public class ProductoDAO {
	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;

	public boolean guardar(Producto producto) {
		try {
			String sql = null;
			estadoOperacion = false;
			connection = obtenerConexion();
			connection.setAutoCommit(false);
			sql = "INSERT PRODUCTOS (ID,NOMBRE,CANTIDAD,PRECIO,FECHA_CREA,FECHA_ACT) VALUES (?,?,?,?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, null);
			statement.setString(2, producto.getNombre());
			statement.setDouble(3, producto.getCantidad());
			statement.setDouble(4, producto.getPrecio());
			statement.setDate(5, producto.getFechaCrea());
			statement.setDate(6, producto.getFechaAct());

			estadoOperacion = statement.executeUpdate() > 0;

			connection.commit();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		return estadoOperacion;
	}

	public boolean editar(Producto producto) {
		try {
			String sql = null;
			estadoOperacion = false;
			connection = obtenerConexion();
			connection.setAutoCommit(false);
			sql = "UPDATE productos SET nombre=?, cantidad=?, precio=?, fecha_act=? where id=?";
			statement.setString(1, producto.getNombre());
			statement.setDouble(2, producto.getCantidad());
			statement.setDouble(3, producto.getPrecio());
			statement.setDate(4, producto.getFechaAct());
			statement.setInt(5, producto.getId());
			estadoOperacion = statement.executeUpdate() > 0;

			connection.commit();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return estadoOperacion;
	}

	public boolean eliminar(Producto producto) {
		try {
			String sql = null;
			estadoOperacion = false;
			connection = obtenerConexion();
			connection.setAutoCommit(false);
			sql = "DELETE FROM productos WHERE id=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, producto.getId());
			estadoOperacion = statement.executeUpdate() > 0;
			connection.commit();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return estadoOperacion;
	}

	public List<Producto> obtenerProductos() {
		ResultSet resultSet = null;
		List<Producto> listaProductos = new ArrayList<>();
		Producto producto = new Producto();
		String sql = null;
		estadoOperacion = false;
		try {
			connection = obtenerConexion();
			sql = "SELECT * FROM productos";
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				producto.setId(resultSet.getInt(1));
				producto.setNombre(resultSet.getString(2));
				producto.setCantidad(resultSet.getDouble(3));
				producto.setPrecio(resultSet.getDouble(4));
				producto.setFechaCrea(resultSet.getDate(5));
				producto.setFechaAct(resultSet.getDate(6));
				listaProductos.add(producto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listaProductos;
	}

	public Producto obtenerProductos(Producto producto) {
		ResultSet resultSet = null;
		Producto producto2 = new Producto();
		String sql = null;
		estadoOperacion = false;
		try {
			connection = obtenerConexion();
			sql = "SELECT * FROM productos WHERE id=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, producto.getId());
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				producto2.setId(resultSet.getInt(1));
				producto2.setNombre(resultSet.getString(2));
				producto2.setCantidad(resultSet.getDouble(3));
				producto2.setPrecio(resultSet.getDouble(4));
				producto2.setFechaCrea(resultSet.getDate(5));
				producto2.setFechaAct(resultSet.getDate(6));
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return producto2;
	}

	private Connection obtenerConexion() {
		return Conexion.getConnection();
	}
}
