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
    	Refeicao r = null;
    	try {
            PreparedStatement stmt = connection.prepareStatement("SELECT codRefeicao,tipoRefeicao,dtRefeicao FROM T_HTK_REFCONSU WHERE codRefeicao=" + id);
            ResultSet res = stmt.executeQuery();

            if(res.next()) {
                r = new Refeicao(res.getInt("codRefeicao"), TipoRefeicao.valueOf(res.getString("tipoRefeicao")), res.getDate("dtRefeicao"));
            }
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return r;
    }

    @Override
    public List<Refeicao> getAll() {
        connection = ConnectionFactory.getConnection();
        if (connection == null) return null;

        List<Refeicao> allRefeicao = new ArrayList<Refeicao>();

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT codRefeicao,tipoRefeicao,dtRefeicao FROM T_HTK_REFCONSU");
            ResultSet res = stmt.executeQuery();

            while(res.next()) {
                Refeicao r = new Refeicao(res.getInt("codRefeicao"), TipoRefeicao.valueOf(res.getString("tipoRefeicao")), res.getDate("dtRefeicao"));
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
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO T_HTK_REFCONSU(codRefeicao, tipoRefeicao, dtRefeicao) VALUES (SQ_REFEICAO.NEXTVAL, ?, ?)");
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
    public boolean update(int id, Refeicao refeicao) {
        try {
            PreparedStatement stmt = connection.prepareStatement("UPDATE T_HTK_REFCONSU SET tipoRefeicao = ?, dtRefeicao = ? WHERE codRefeicao = ?;");
            stmt.setString(1, refeicao.getTipoRefeicao().toString());
            stmt.setDate(2, new java.sql.Date(refeicao.getDtRefeicao().getTime()));
            stmt.setInt(3, id);

            int res = stmt.executeUpdate();
            if (res > 0) {
                System.out.println("Refeição atualizada com sucesso.");
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
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM T_HTK_REFCONSU WHERE codRefeicao=" + id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
	public List<Refeicao> getByUser(int codUsuario) {
    	connection = ConnectionFactory.getConnection();
        if (connection == null) return null;

        List<Refeicao> allRefeicao = new ArrayList<Refeicao>();

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT codRefeicao,tipoRefeicao,dtRefeicao,codUsuario FROM T_HTK_REFCONSU WHERE codUsuario=" + codUsuario);
            ResultSet res = stmt.executeQuery();

            while(res.next()) {
                Refeicao r = new Refeicao(res.getInt("codRefeicao"), TipoRefeicao.valueOf(res.getString("tipoRefeicao")), res.getDate("dtRefeicao"));
                allRefeicao.add(r);
            }
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allRefeicao;
	}
}
