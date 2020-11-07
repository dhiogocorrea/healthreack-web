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
	public BatimentoCardiaco get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BatimentoCardiaco> getAll() {
		connection = ConnectionFactory.getConnection();
		if (connection == null) return null;
		
		List<BatimentoCardiaco> allBatimentoCardiacos = new ArrayList<BatimentoCardiaco>();

		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT cod_batimento_cardiaco,batimento_minimo,"
					+ "batimento_maximo,batimento_medio,dt_medicao"
					+ " FROM T_HTK_BATIMPROVA");
			ResultSet res = stmt.executeQuery();

			while(res.next()) {
				BatimentoCardiaco bat_card = new BatimentoCardiaco(res.getInt("cod_batimento_cardiaco"),
															       res.getInt("batimento_minimo"),
															       res.getInt("batimento_maximo"),
															       res.getInt("batimento_medio"),
															       res.getDate("dt_medicao"));
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
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO T_HTK_BATIMPROVA(cod_batimento_cardiaco,batimento_minimo,"
					+ "batimento_maximo,batimento_medio,dt_medicao)"
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
	public void update(BatimentoCardiaco t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(BatimentoCardiaco t) {
		// TODO Auto-generated method stub
		
	}

}
