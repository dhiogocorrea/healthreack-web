package com.grupo30.dao;

import com.grupo30.enums.TipoRefeicao;
import com.grupo30.model.Refeicao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RefeicaoDao implements Dao<Refeicao>{

    private Connection connection;

    @Override
    public Refeicao get(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Refeicao> getAll() {
        connection = ConnectionFactory.getConnection();
        if (connection == null) return null;

        List<Refeicao> allRefeicao = new ArrayList<Refeicao>();

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT cod_refeicao,tp_refeicao,dt_refeicao FROM T_HTK_REFCONSU");
            ResultSet res = stmt.executeQuery();

            while(res.next()) {
                Refeicao r = new Refeicao(res.getInt("cod_refeicao"), TipoRefeicao.valueOf(res.getString("tp_refeicao")), res.getDate("dt_refeicao"));
                allRefeicao.add(r);
            }
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allRefeicao;
    }

    @Override
    public int insert(Refeicao refeicao) {
        connection = ConnectionFactory.getConnection();
        if (connection == null) return -1;

        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO T_HTK_REFCONSU(cod_refeicao, tp_refeicao, dt_refeicao) VALUES (SQ_REFEICAO.NEXTVAL, ?, ?)");
            stmt.setString(1, refeicao.getTipoRefeicao().toString());
            stmt.setDate(2, new java.sql.Date(refeicao.getDtRefeicao().getTime()));

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
    public void update(Refeicao refeicao, String[] params) {
        // TODO Auto-generated method stub
    }

    @Override
    public void delete(Refeicao refeicao) {
        // TODO Auto-generated method stub
    }

	@Override
	public List<Refeicao> getByUser(int codUsuario) {
		// TODO Auto-generated method stub
		return null;
	}
}
