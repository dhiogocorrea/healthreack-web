package com.grupo30.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.grupo30.dao.RefeicaoDao;
import com.grupo30.enums.TipoRefeicao;
import com.grupo30.model.Refeicao;

@WebServlet("/refeicao")
public class RefeicaoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private RefeicaoDao refeicaoDao;
	private DateFormat dtf;
	
	public void init() throws ServletException {
		super.init();
		refeicaoDao = new RefeicaoDao();
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
    	if (request.getParameter("codRefeicao") != null) {
	    	int codRefeicao = Integer.parseInt(request.getParameter("codRefeicao"));
	    	Refeicao refeicao = refeicaoDao.get(codRefeicao);
	    	request.setAttribute("refeicao", refeicao);
    	} else {
    		int codUsuario = Integer.parseInt(request.getParameter("codUsuario"));
    		request.setAttribute("refeicoes", refeicaoDao.getByUser(codUsuario));
    	}
    }
    
    protected void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
    	Refeicao refeicao = new Refeicao();
    	refeicao.setDtRefeicao(dtf.parse(request.getParameter("dtRefeicao")));
    	refeicao.setTipoRefeicao(TipoRefeicao.valueOf(request.getParameter("tipoRefeicao")));
    	
    	int inserted = refeicaoDao.insert(refeicao);
    
        if (inserted == -1) {
        	request.setAttribute("error", "Ocorreu um erro ao incluir a refeição. Tente novamente.");
        } else {
        	request.setAttribute("msg", "Cadastro inserido com sucesso!");
        }
        
        request.getRequestDispatcher("listagem-refeicoes.jsp").forward(request, response);
    }
    
    protected void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
    	int codRefeicao = Integer.parseInt(request.getParameter("codRefeicao"));
    	
    	Refeicao refeicao = new Refeicao();
    	refeicao.setDtRefeicao(dtf.parse(request.getParameter("dtRefeicao")));
    	refeicao.setTipoRefeicao(TipoRefeicao.valueOf(request.getParameter("tipoRefeicao")));
    	
        boolean updated = refeicaoDao.update(codRefeicao, refeicao);

        if (!updated) {
        	request.setAttribute("error", "Ocorreu um erro ao editar a refeição. Tente novamente.");
        } else {
        	request.setAttribute("msg", "Cadastro atualizado com sucesso!");
        }
        
        request.getRequestDispatcher("listagem-refeicoes.jsp").forward(request, response);
    }
    
    protected void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int codRefeicao = Integer.parseInt(request.getParameter("codRefeicao"));
    	
    	boolean deleted = refeicaoDao.delete(codRefeicao);
    	
    	if (!deleted) {
        	request.setAttribute("error", "Ocorreu um erro ao excluir a refeicao. Tente novamente.");
        } else {
        	request.setAttribute("msg", "Cadastro excluído com sucesso!");
        }
        
        request.getRequestDispatcher("listagem-refeicoes.jsp").forward(request, response);
    }
}
