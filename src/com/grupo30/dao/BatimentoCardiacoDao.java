package com.grupo30.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.grupo30.model.BatimentoCardiaco;

public class BatimentoCardiacoDao implements Dao<BatimentoCardiaco> {

	private Connection connection;

	@Override
	public BatimentoCardiaco get(int id) {
		BatimentoCardiaco bat_card = null;
		
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT codBatimentoCardiaco,batimentoMinimo,"
					+ "batimentoMaximo,batimentoMedio,dtMedicao"
					+ " FROM T_HTK_BATIMPROVA WHERE codBatimentoCardiaco=" + id);
			ResultSet res = stmt.executeQuery();

			if(res.next()) {
				bat_card = new BatimentoCardiaco(res.getInt("codBatimentoCardiaco"),
															       res.getInt("batimentoMinimo"),
															       res.getInt("batimentoMaximo"),
															       res.getInt("batimentoMedio"),
															       res.getDate("dtMedicao"));
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bat_card;
	}

	@Override
	public List<BatimentoCardiaco> getAll() {
		connection = ConnectionFactory.getConnection();
		if (connection == null) return null;
		
		List<BatimentoCardiaco> allBatimentoCardiacos = new ArrayList<BatimentoCardiaco>();

		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT codBatimentoCardiaco,batimentoMinimo,"
					+ "batimentoMaximo,batimentoMedio,dtMedicao"
					+ " FROM T_HTK_BATIMPROVA");
			ResultSet res = stmt.executeQuery();

			while(res.next()) {
				BatimentoCardiaco bat_card = new BatimentoCardiaco(res.getInt("codBatimentoCardiaco"),
															       res.getInt("batimentoMinimo"),
															       res.getInt("batimentoMaximo"),
															       res.getInt("batimentoMedio"),
															       res.getDate("dtMedicao"));
				allBatimentoCardiacos.add(bat_card);
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allBatimentoCardiacos;
	}

	@Override
	public int insert(BatimentoCardiaco t) {
		connection = ConnectionFactory.getConnection();
		if (connection == null) return -1;

		try {
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO T_HTK_BATIMPROVA(codBatimentoCardiaco,batimentoMinimo,"
					+ "batimentoMaximo,batimentoMedio,dtMedicao)"
					+ " VALUES (SQ_BATIMENTO_CARDIACO.NEXTVAL, ?, ?, ?, ?)");
			stmt.setInt(1, t.getBatimentoMinimo());
			stmt.setInt(2, t.getBatimentoMaximo());
			stmt.setInt(3, t.getBatimentoMedio());
			stmt.setDate(4, new java.sql.Date(t.getDtMedicao().getTime()));

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
	public boolean update(int id, BatimentoCardiaco batimentoCardiaco) {
		try {
			PreparedStatement stmt = connection.prepareStatement("UPDATE T_HTK_BATIMPROVA SET batimentoMinimo = ?, batimentoMaximo = ?, batimentoMedio = ?, dtMedicao = ? WHERE codBatimentoCardiaco = ?;");
			stmt.setInt(1, batimentoCardiaco.getBatimentoMinimo());
			stmt.setInt(2, batimentoCardiaco.getBatimentoMaximo());
			stmt.setInt(3, batimentoCardiaco.getBatimentoMedio());
			stmt.setDate(4, new java.sql.Date(batimentoCardiaco.getDtMedicao().getTime()));
			stmt.setInt(5, id);

			int res = stmt.executeUpdate();
			if (res > 0) {
				System.out.println("Batimento Cardíaco atualizado com sucesso.");
			}

			stmt.close();
			connection.close();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean delete(int id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM T_HTK_BATIMPROVA WHERE codAlimento=" + id);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<BatimentoCardiaco> getByUser(int codUsuario) {
		connection = ConnectionFactory.getConnection();
		if (connection == null) return null;
		
		List<BatimentoCardiaco> allBatimentoCardiacos = new ArrayList<BatimentoCardiaco>();

		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT codBatimentoCardiaco,batimentoMinimo,"
					+ "batimentoMaximo,batimentoMedio,dtMedicao, codUsuario"
					+ " FROM T_HTK_BATIMPROVA WHERE codUsuario=" + codUsuario);
			ResultSet res = stmt.executeQuery();

			while(res.next()) {
				BatimentoCardiaco bat_card = new BatimentoCardiaco(res.getInt("codBatimentoCardiaco"),
															       res.getInt("batimentoMinimo"),
															       res.getInt("batimentoMaximo"),
															       res.getInt("batimentoMedio"),
															       res.getDate("dtMedicao"));
				allBatimentoCardiacos.add(bat_card);
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allBatimentoCardiacos;
	}

}
