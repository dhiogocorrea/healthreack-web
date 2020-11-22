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
	public Peso get(int id) {
		Peso p = null;
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT codPeso,valor,dtPesagem FROM peso WHERE codPeso=" + id);
			ResultSet res = stmt.executeQuery();

			if(res.next()) {
				p = new Peso(res.getInt("codPeso"), res.getDouble("valor"), res.getDate("dtPesagem"));
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}

	@Override
	public List<Peso> getAll() {
		connection = ConnectionFactory.getConnection();
		if (connection == null) return null;
		
		List<Peso> allPesos = new ArrayList<Peso>();

		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT codPeso,valor,dtPesagem FROM peso");
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
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO peso(codPeso, valor, dtPesagem) VALUES (SQ_PESO.NEXTVAL, ?, ?)");
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
	public boolean update(int id, Peso t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Peso> getByUser(int codUsuario) {
		connection = ConnectionFactory.getConnection();
		if (connection == null) return null;
		
		List<Peso> allPesos = new ArrayList<Peso>();

		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT codPeso,valor,dtPesagem,codUsuario FROM peso WHERE codUsuario=" + codUsuario);
			ResultSet res = stmt.executeQuery();

			while(res.next()) {
				Peso p = new Peso(res.getInt("codPeso"), res.getDouble("valor"), res.getDate("dtPesagem"));
				allPesos.add(p);
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allPesos;
	}

}
