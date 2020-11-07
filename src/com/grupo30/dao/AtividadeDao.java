package com.grupo30.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.grupo30.enums.TipoRefeicao;
import com.grupo30.model.Atividade;

public class AtividadeDao implements Dao<Atividade> {

	private Connection connection;

	@Override
	public Atividade get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Atividade> getAll() {
		connection = ConnectionFactory.getConnection();
		if (connection == null) return null;
		
		List<Atividade> allAtividades = new ArrayList<Atividade>();

		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT cod_atividade,nome,duracao_atividade,dt_atividade"
					+ " FROM T_HTK_ATIV");
			ResultSet res = stmt.executeQuery();

			while(res.next()) {
				Atividade ativ = new Atividade(res.getInt("cod_atividade"),
											   res.getString("nome"),
											   res.getInt("duracao_atividade"),
											   res.getDate("dt_atividade"));
				allAtividades.add(ativ);
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allAtividades;
	}

	@Override
	public int insert(Atividade t) {
		connection = ConnectionFactory.getConnection();
		if (connection == null) return -1;

		try {
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO T_HTK_ATIV(cod_atividade,nome,duracao_atividade,dt_atividade)"
					+ " VALUES (SQ_ATIVIDADE.NEXTVAL, ?, ?, ?)");
			stmt.setString(1, t.getNome());
			stmt.setDouble(2, t.getDuracaoAtividade());
			stmt.setDate(3, new java.sql.Date(t.getDtAtividade().getTime()));

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
	public void update(Atividade t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Atividade t) {
		// TODO Auto-generated method stub
		
	}

}
