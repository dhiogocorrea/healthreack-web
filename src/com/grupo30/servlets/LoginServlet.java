package com.grupo30.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.grupo30.dao.UsuarioDao;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private UsuarioDao usuarioDao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		usuarioDao = new UsuarioDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
  
        Integer codUsuario = usuarioDao.login(email, senha);
        
        if(codUsuario != null){
        	request.setAttribute("codUsuario", codUsuario);
        	request.getRequestDispatcher("home.jsp").forward(request, response);
        } else{
            response.sendRedirect("error.html");
        }
    }
}
