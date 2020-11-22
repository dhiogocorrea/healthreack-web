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
	public Atividade get(int id) {
		Atividade ativ = null;
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT codAtividade,nome,duracaoAtividade,dtAtividade"
					+ " FROM T_HTK_ATIV WHERE codAtividade=" + id);
			ResultSet res = stmt.executeQuery();

			while(res.next()) {
				ativ = new Atividade(res.getInt("codAtividade"),
								     res.getString("nome"),
								     res.getInt("duracaoAtividade"),
								     res.getDate("dtAtividade"));
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ativ;
	}

	@Override
	public List<Atividade> getAll() {
		connection = ConnectionFactory.getConnection();
		if (connection == null) return null;
		
		List<Atividade> allAtividades = new ArrayList<Atividade>();

		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT codAtividade,nome,duracaoAtividade,dtAtividade"
					+ " FROM T_HTK_ATIV");
			ResultSet res = stmt.executeQuery();

			while(res.next()) {
				Atividade ativ = new Atividade(res.getInt("codAtividade"),
											   res.getString("nome"),
											   res.getInt("duracaoAtividade"),
											   res.getDate("dtAtividade"));
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
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO T_HTK_ATIV(codAtividade,nome,duracaoAtividade,dtAtividade)"
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
	public boolean update(int id, Atividade atividade) {
		try {
			PreparedStatement stmt = connection.prepareStatement("UPDATE T_HTK_ATIV SET nome = ?, duracaoAtividade = ?, dtAtividade = ? WHERE codAtividade = ?;");
			stmt.setString(1, atividade.getNome());
			stmt.setInt(2, atividade.getDuracaoAtividade());
			stmt.setDate(3, new java.sql.Date(atividade.getDtAtividade().getTime()));
			stmt.setInt(4, id);

			int res = stmt.executeUpdate();
			if (res > 0) {
				System.out.println("Atividade atualizada com sucesso.");
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
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM T_HTK_ATIV WHERE codAtividade=" + id);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Atividade> getByUser(int codUsuario) {
		connection = ConnectionFactory.getConnection();
		if (connection == null) return null;
		
		List<Atividade> allAtividades = new ArrayList<Atividade>();

		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT codAtividade,nome,duracaoAtividade,dtAtividade, codUsuario"
					+ " FROM T_HTK_ATIV WHERE codUsuario=" + codUsuario);
			ResultSet res = stmt.executeQuery();

			while(res.next()) {
				Atividade ativ = new Atividade(res.getInt("codAtividade"),
											   res.getString("nome"),
											   res.getInt("duracaoAtividade"),
											   res.getDate("dtAtividade"));
				allAtividades.add(ativ);
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allAtividades;
	}

}
