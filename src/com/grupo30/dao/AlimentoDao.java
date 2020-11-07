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
	public Alimento get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alimento> getAll() {
		connection = ConnectionFactory.getConnection();
		if (connection == null) return null;
		
		List<Alimento> allAlimentos = new ArrayList<Alimento>();

		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT cod_alimento,nome,qt_consumida,qt_calorias,dt_consumida"
					+ " FROM T_HTK_ALIM_CONSU");
			ResultSet res = stmt.executeQuery();

			while(res.next()) {
				Alimento alim = new Alimento(res.getInt("cod_alimento"),
											 res.getString("nome"),
											 res.getDouble("qt_consumida"),
											 res.getInt("qt_calorias"),
											 res.getDate("dt_consumida"));
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
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO T_HTK_ALIM_CONSU(cod_alimento,nome,qt_consumida,qt_calorias,dt_consumida)"
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
	public void update(Alimento t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Alimento t) {
		// TODO Auto-generated method stub
		
	}

}
