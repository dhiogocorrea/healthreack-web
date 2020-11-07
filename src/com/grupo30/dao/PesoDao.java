package com.grupo30.dao;

import com.grupo30.model.Peso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PesoDao implements Dao<Peso> {

	private Connection connection;

	@Override
	public Peso get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Peso> getAll() {
		connection = ConnectionFactory.getConnection();
		if (connection == null) return null;
		
		List<Peso> allPesos = new ArrayList<Peso>();

		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT cod_peso,valor,dt_pesagem FROM peso");
			ResultSet res = stmt.executeQuery();

			while(res.next()) {
				Peso p = new Peso(res.getInt("cod_peso"), res.getDouble("valor"), res.getDate("dt_pesagem"));
				allPesos.add(p);
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allPesos;
	}

	@Override
	public int insert(Peso t) {
		connection = ConnectionFactory.getConnection();
		if (connection == null) return -1;

		try {
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO peso(cod_peso, valor, dt_pesagem) VALUES (SQ_PESO.NEXTVAL, ?, ?)");
			stmt.setDouble(1, t.getValor());
			stmt.setDate(2, new java.sql.Date(t.getDtPesagem().getTime()));

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
	public void update(Peso t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Peso t) {
		// TODO Auto-generated method stub
		
	}

}
