package com.grupo30.dao;

import com.grupo30.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao implements Dao<Usuario>{

    private Connection connection;
    
    private AlimentoDao alimentoDao = new AlimentoDao();
    private AtividadeDao atividadeDao = new AtividadeDao();
    private BatimentoCardiacoDao batimentoCardiacoDao = new BatimentoCardiacoDao();
    private PesoDao pesoDao = new PesoDao();
    private RefeicaoDao refeicaoDao = new RefeicaoDao();

    @Override
    public Usuario get(int id) {
    	 connection = ConnectionFactory.getConnection();
         if (connection == null) return null;
         
         Usuario usuario = null;
         try {
             PreparedStatement stmt = connection.prepareStatement("SELECT cod_usuario,cod_pessoa,nome,sobrenome,cpf,sexo,email,senha,dt_nascimento,dt_registro,dt_assinatura,telefone FROM T_HTK_USU");
             ResultSet res = stmt.executeQuery();

             if(res.next()) {
            	 usuario = new Usuario(res.getInt("cod_usuario"), res.getInt("cod_pessoa"), res.getString("nome"), res.getString("sobrenome"), res.getString("cpf"),
                         res.getString("sexo"), res.getString("email"), res.getString("senha"), res.getDate("dt_nascimento"), res.getDate("dt_registro"),
                         res.getDate("dt_assinatura"), res.getInt("telefone"));
            	 
            	 
            	 usuario.setAlimento(alimentoDao.getByUser(usuario.getCodUsuario()));
            	 usuario.setAtividade(atividadeDao.getByUser(usuario.getCodUsuario()));
            	 usuario.setBatimentoCardiaco(batimentoCardiacoDao.getByUser(usuario.getCodUsuario()));
            	 usuario.setPeso(pesoDao.getByUser(usuario.getCodUsuario()));
            	 usuario.setRefeicao(refeicaoDao.getByUser(usuario.getCodUsuario())); 
             }
             stmt.close();
             connection.close();
         } catch (SQLException e) {
             e.printStackTrace();
         }
         
         return usuario;
    }

    @Override
    public List<Usuario> getAll() {
    	//TODO trazer valores de join
        connection = ConnectionFactory.getConnection();
        if (connection == null) return null;

        List<Usuario> allUsuarios = new ArrayList<Usuario>();

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT cod_usuario,cod_pessoa,nome,sobrenome,cpf,sexo,email,senha,dt_nascimento,dt_registro,dt_assinatura,telefone FROM T_HTK_USU");
            ResultSet res = stmt.executeQuery();

            while(res.next()) {
                Usuario p = new Usuario(res.getInt("cod_usuario"), res.getInt("cod_pessoa"), res.getString("nome"), res.getString("sobrenome"), res.getString("cpf"),
                        res.getString("sexo"), res.getString("email"), res.getString("senha"), res.getDate("dt_nascimento"), res.getDate("dt_registro"),
                        res.getDate("dt_assinatura"), res.getInt("telefone"));
                allUsuarios.add(p);
            }
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allUsuarios;
    }

    @Override
    public int insert(Usuario usuario) {
        connection = ConnectionFactory.getConnection();
        if (connection == null) return -1;

        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO T_HTK_USU(cod_pessoa,nome,sobrenome,cpf,sexo,email,senha,dt_nascimento,dt_registro,dt_assinatura,telefone) VALUES (SQ_USUARIO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSobrenome());
            stmt.setString(3, usuario.getCpf());
            stmt.setString(4, usuario.getSexo());
            stmt.setString(5, usuario.getEmail());
            stmt.setString(6, usuario.getSenha());
            stmt.setDate(7, new java.sql.Date(usuario.getDtNascimento().getTime()));
            stmt.setDate(8, new java.sql.Date(usuario.getDtRegistro().getTime()));
            stmt.setDate(9, new java.sql.Date(usuario.getDtAssinatura().getTime()));
            stmt.setInt(10, usuario.getNumeroTelefone());

            int res = stmt.executeUpdate();

            stmt.close();
            connection.close();

            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }
    
    public Integer login(String email, String senha) {
    	connection = ConnectionFactory.getConnection();
        if (connection == null) return null;
        
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT cod_usuario FROM T_HTK_USU WHERE email = ? AND senha = ?");
            stmt.setString(1, email);
            stmt.setString(2, senha);
            
            Integer response = null;
            
            ResultSet res = stmt.executeQuery();

            if(res.next()) {
            	response = res.getInt("cod_usuario");
            }
            stmt.close();
            connection.close();
            
            return response;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void update(Usuario usuario, String[] params) {
        // TODO Auto-generated method stub
    }

    @Override
    public void delete(Usuario usuario) {
        // TODO Auto-generated method stub
    }

	@Override
	public List<Usuario> getByUser(int codUsuario) {
		return null;
	}
}
