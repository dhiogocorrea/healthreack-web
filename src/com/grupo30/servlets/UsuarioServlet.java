package com.grupo30.servlets;

import com.grupo30.dao.UsuarioDao;
import com.grupo30.enums.Plano;
import com.grupo30.model.Peso;
import com.grupo30.model.Usuario;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private UsuarioDao usuarioDao;
	private DateFormat dtf;
	
	public void init() throws ServletException {
		super.init();
		usuarioDao = new UsuarioDao();
		dtf = new SimpleDateFormat("dd/MM/yyyy");
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String acao = request.getParameter("acao");
    	
    	switch(acao) {
    		case "cadastrar":
				try {
					cadastrar(request, response);
				} catch (ParseException e) {
					e.printStackTrace();
				}
	    		break;
    		case "editar":
    			try {
    				editar(request, response);
				} catch (ParseException e) {
					e.printStackTrace();
				}
    			break;
    		case "excluir":
    			excluir(request, response);
    			break;
    	}
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int codUsuario = Integer.parseInt(request.getParameter("codUsuario"));
    	
    	Usuario usuario = usuarioDao.get(codUsuario);
    	
    	request.setAttribute("user", usuario);
    }
    
    protected void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        Usuario usuario = new Usuario();
        usuario.setNome(request.getParameter("nome"));
        usuario.setSobrenome(request.getParameter("sobrenome"));
        usuario.setDtNascimento(dtf.parse(request.getParameter("dtNascimento")));
        usuario.setCpf(request.getParameter("cpf"));
        usuario.setSexo(request.getParameter("sexo"));
        usuario.setEmail(request.getParameter("email"));
        usuario.setPlano(Plano.BRONZE);

        double pesoValue = Double.parseDouble(request.getParameter("peso").replace(",", "."));
        Peso p = new Peso(pesoValue, new Date());
        List<Peso> peso = new ArrayList<Peso>();
        peso.add(p);
        usuario.setPeso(peso);

        UsuarioDao usuarioDao = new UsuarioDao();
        int inserted = usuarioDao.insert(usuario);

        if (inserted == -1) {
        	request.setAttribute("error", "Ocorreu um erro ao incluir o seu cadastro. Tente novamente.");
        } else {
        	request.setAttribute("msg", "Cadastro concluído com sucesso!");
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    
    protected void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        int codUsuario = Integer.parseInt(request.getParameter("codUsuario"));
    	
    	Usuario usuario = new Usuario();
        usuario.setNome(request.getParameter("nome"));
        usuario.setSobrenome(request.getParameter("sobrenome"));
        usuario.setDtNascimento(dtf.parse(request.getParameter("dtNascimento")));
        usuario.setCpf(request.getParameter("cpf"));
        usuario.setSexo(request.getParameter("sexo"));
        usuario.setEmail(request.getParameter("email"));

        UsuarioDao usuarioDao = new UsuarioDao();

        if(usuarioDao.update(codUsuario, usuario)) {
        	request.setAttribute("msg", "Cadastro atualizado com sucesso!");
        } else {
        	request.setAttribute("error", "Ocorreu um erro ao atualizar o seu cadastro. Tente novamente.");
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    
    protected void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int codUsuario = Integer.parseInt(request.getParameter("codUsuario"));
    	
    	if(usuarioDao.delete(codUsuario)) {
    		request.setAttribute("msg", "Cadastro excluído com sucesso!");
    		request.getRequestDispatcher("index.jsp").forward(request, response);
    	} else {
    		request.setAttribute("error", "Ocorreu um erro ao excluir o seu cadastro. Tente novamente.");
    	}
    }
}
