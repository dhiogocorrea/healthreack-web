package com.grupo30.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.grupo30.model.Alimento;

public class AlimentoDao implements Dao<Alimento> {

	private Connection connection;

	@Override
	public Alimento get(int id) {
		Alimento alim = null;
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT codAlimento, nome, qtConsumida, qtCalorias,dtConsumida"
					+ " FROM T_HTK_ALIM WHERE codlimento=" + id);
			ResultSet res = stmt.executeQuery();

			if(res.next()) {
				alim = new Alimento(res.getInt("codAlimento"),
											 res.getString("nome"),
											 res.getDouble("qtConsumida"),
											 res.getInt("qtCalorias"),
											 res.getDate("dtConsumida"));
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return alim;
	}

	@Override
	public List<Alimento> getAll() {
		connection = ConnectionFactory.getConnection();
		if (connection == null) return null;
		
		List<Alimento> allAlimentos = new ArrayList<Alimento>();

		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT codAlimento, nome, qtConsumida, qtCalorias,dtConsumida"
					+ " FROM T_HTK_ALIM");
			ResultSet res = stmt.executeQuery();

			while(res.next()) {
				Alimento alim = new Alimento(res.getInt("codAlimento"),
											 res.getString("nome"),
											 res.getDouble("qtConsumida"),
											 res.getInt("qtCalorias"),
											 res.getDate("dtConsumida"));
				allAlimentos.add(alim);
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allAlimentos;
	}

	@Override
	public int insert(Alimento t) {
		connection = ConnectionFactory.getConnection();
		if (connection == null) return -1;

		try {
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO T_HTK_ALIM(codAlimento, nome, qtConsumida, qtCalorias, dtConsumida)"
					+ " VALUES (SQ_ALIMENTO.NEXTVAL, ?, ?, ?,?)");
			stmt.setString(1, t.getNome());
			stmt.setDouble(2, t.getQtConsumida());
			stmt.setInt(3, t.getQtCalorias());
			stmt.setDate(4, new java.sql.Date(t.getDtConsumida().getTime()));

			int res = stmt.executeUpdate();

			stmt.close();
			connection.close();
			
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}

	@Override
	public boolean update(int id, Alimento alimento) {
		return false;
	}

	@Override
	public boolean delete(int id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM T_HTK_ALIM WHERE codAlimento=" + id);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<Alimento> getByUser(int codUsuario) {
		connection = ConnectionFactory.getConnection();
		if (connection == null) return null;
		
		List<Alimento> allAlimentos = new ArrayList<Alimento>();

		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT codAlimento, nome, qtConsumida, qtCalorias,dtConsumida, codUsuario"
					+ " FROM T_HTK_ALIM WHERE codUsuario=" + codUsuario);
			ResultSet res = stmt.executeQuery();

			while(res.next()) {
				Alimento alim = new Alimento(res.getInt("codAlimento"),
											 res.getString("nome"),
											 res.getDouble("qtConsumida"),
											 res.getInt("qtCalorias"),
											 res.getDate("dtConsumida"));
				allAlimentos.add(alim);
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allAlimentos;
	}

}
