package com.grupo30.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.grupo30.dao.PesoDao;
import com.grupo30.model.BatimentoCardiaco;
import com.grupo30.model.Peso;

public class PesoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private PesoDao pesoDao;
	private DateFormat dtf;
	
	public void init() throws ServletException {
		super.init();
		pesoDao = new PesoDao();
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
    	if (request.getParameter("codPeso") != null) {
	    	int codPeso = Integer.parseInt(request.getParameter("codPeso"));
	    	Peso peso = pesoDao.get(codPeso);
	    	request.setAttribute("peso", peso);
    	} else {
    		int codUsuario = Integer.parseInt(request.getParameter("codUsuario"));
    		request.setAttribute("pesos", pesoDao.getByUser(codUsuario));
    	}
    }
    
    protected void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
    	Peso peso = new Peso();
    	peso.setDtPesagem(dtf.parse(request.getParameter("dtPesagem")));
    	peso.setValor(Double.parseDouble(request.getParameter("valor")));
    	
    	int inserted = pesoDao.insert(peso);
    	
    	if (inserted == -1) {
        	request.setAttribute("error", "Ocorreu um erro ao incluir o peso. Tente novamente.");
        } else {
        	request.setAttribute("msg", "Cadastro inserido com sucesso!");
        }
        
        request.getRequestDispatcher("listagem-pesos.jsp").forward(request, response);
    	
    }
    
    protected void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
    	int codPeso = Integer.parseInt(request.getParameter("codPeso"));
    	
    	Peso peso = new Peso();
    	peso.setDtPesagem(dtf.parse(request.getParameter("dtPesagem")));
    	peso.setValor(Double.parseDouble(request.getParameter("valor")));
    	
    	boolean updated = pesoDao.update(codPeso, peso);
    	
    	if (!updated) {
        	request.setAttribute("error", "Ocorreu um erro ao editar o peso. Tente novamente.");
        } else {
        	request.setAttribute("msg", "Cadastro atualizado com sucesso!");
        }
        
        request.getRequestDispatcher("listagem-pesos.jsp").forward(request, response);
    }
    
    protected void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int codPeso = Integer.parseInt(request.getParameter("codPeso"));
    	
    	boolean deleted = pesoDao.delete(codPeso);
    	
    	if (!deleted) {
        	request.setAttribute("error", "Ocorreu um erro ao excluir o peso. Tente novamente.");
        } else {
        	request.setAttribute("msg", "Cadastro excluído com sucesso!");
        }
        
        request.getRequestDispatcher("listagem-pesos.jsp").forward(request, response);
    }
}
