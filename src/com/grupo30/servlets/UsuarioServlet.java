package com.grupo30.servlets;

import com.grupo30.dao.UsuarioDao;
import com.grupo30.model.Usuario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private UsuarioDao usuarioDao = new UsuarioDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = new Usuario();
        usuario.setNome(request.getParameter("nome"));
        usuario.setSobrenome(request.getParameter("sobrenome"));
        usuario.setCpf(request.getParameter("cpf"));
        usuario.setSexo(request.getParameter("sexo"));
        usuario.setEmail(request.getParameter("email"));

        UsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.insert(usuario);
        
        request.setAttribute("msg", "Cadastro concluído com sucesso!");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int codUsuario = Integer.parseInt(request.getParameter("codUsuario"));
    	
    	Usuario usuario = usuarioDao.get(codUsuario);
    	
    	request.setAttribute("user", usuario);
    }
}
