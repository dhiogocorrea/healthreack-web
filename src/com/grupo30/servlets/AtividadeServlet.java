package com.grupo30.servlets;

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

import com.grupo30.dao.AtividadeDao;
import com.grupo30.model.Alimento;
import com.grupo30.model.Atividade;


@WebServlet("/atividade")
public class AtividadeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private AtividadeDao atividadeDao;
	private DateFormat dtf;
	
	public void init() throws ServletException {
		super.init();
		atividadeDao = new AtividadeDao();
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
    	if (request.getParameter("codAtividade") != null) {
	    	int codAtividade = Integer.parseInt(request.getParameter("codAtividade"));
	    	Atividade atividade = atividadeDao.get(codAtividade);
	    	request.setAttribute("atividade", atividade);
    	} else {
    		int codUsuario = Integer.parseInt(request.getParameter("codUsuario"));
    		request.setAttribute("atividades", atividadeDao.getByUser(codUsuario));
    	}
    }
    
    protected void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
    	Atividade atividade = new Atividade();
    	atividade.setDtAtividade(dtf.parse(request.getParameter("dtAtividade")));
    	atividade.setDuracaoAtividade(Integer.parseInt(request.getParameter("duracaoAtividade")));
    	atividade.setNome(request.getParameter("nome"));
    	
    	int inserted = atividadeDao.insert(atividade);
    	
    	if (inserted == -1) {
        	request.setAttribute("error", "Ocorreu um erro ao incluir a atividade. Tente novamente.");
        } else {
        	request.setAttribute("msg", "Cadastro inserido com sucesso!");
        }
        
        request.getRequestDispatcher("listagem-exercicios.jsp").forward(request, response);
    }
    
    protected void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
    	int codAtividade = Integer.parseInt(request.getParameter("codAtividade"));
    	
    	Atividade atividade = new Atividade();
    	atividade.setDtAtividade(dtf.parse(request.getParameter("dtAtividade")));
    	atividade.setDuracaoAtividade(Integer.parseInt(request.getParameter("duracaoAtividade")));
    	atividade.setNome(request.getParameter("nome"));
    	
    	boolean updated = atividadeDao.update(codAtividade, atividade);
    	
    	if (!updated) {
        	request.setAttribute("error", "Ocorreu um erro ao editar a atividade. Tente novamente.");
        } else {
        	request.setAttribute("msg", "Cadastro atualizado com sucesso!");
        }
        
        request.getRequestDispatcher("listagem-exercicios.jsp").forward(request, response);
    }
    
    protected void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int codAtividade = Integer.parseInt(request.getParameter("codAtividade"));
    	
    	boolean deleted = atividadeDao.delete(codAtividade);
    	
    	if (!deleted) {
        	request.setAttribute("error", "Ocorreu um erro ao excluir a atividade. Tente novamente.");
        } else {
        	request.setAttribute("msg", "Cadastro excluído com sucesso!");
        }
        
        request.getRequestDispatcher("listagem-exercicios.jsp").forward(request, response);
    }
}
