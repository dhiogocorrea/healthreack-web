package com.grupo30.dao;

import com.grupo30.model.TipoAtividade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoAtividadeDao implements Dao<TipoAtividade>{

    private Connection connection;

    @Override
    public TipoAtividade get(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<TipoAtividade> getAll() {
        connection = ConnectionFactory.getConnection();
        if (connection == null) return null;

        List<TipoAtividade> allAtividades = new ArrayList<TipoAtividade>();

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT cod_tipo_atividade,tipo_atividade,calorias_gastas_hora FROM T_HTK_TIPO_ATIV");
            ResultSet res = stmt.executeQuery();

            while(res.next()) {
                TipoAtividade a = new TipoAtividade(res.getInt("cod_tipo_atividade"), res.getString("tipo_atividade"), res.getInt("calorias_gastas_hora"));
                allAtividades.add(a);
            }
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allAtividades;
    }

    @Override
    public int insert(TipoAtividade tipoAtividade) {
        connection = ConnectionFactory.getConnection();
        if (connection == null) return -1;

        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO T_HTK_ATIV(cod_tipo_atividade, tipo_atividade, calorias_gastas_hora) VALUES (SQ_TIPO_ATIVIDADE.NEXTVAL, ?, ?)");
            stmt.setString(1, tipoAtividade.getTipoAtividade());
            stmt.setInt(2, tipoAtividade.getCaloriasGastasHora());

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
    public void update(TipoAtividade tipoAtividade, String[] params) {
        // TODO Auto-generated method stub
    }

    @Override
    public void delete(TipoAtividade tipoAtividade) {
        // TODO Auto-generated method stub
    }
}
