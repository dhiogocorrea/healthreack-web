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

import com.grupo30.dao.AlimentoDao;
import com.grupo30.model.Alimento;

@WebServlet("/alimento")
public class AlimentoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private AlimentoDao alimentoDao;
	private DateFormat dtf;
	
	public void init() throws ServletException {
		super.init();
		alimentoDao = new AlimentoDao();
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
    	if (request.getParameter("codAlimento") != null) {
	    	int codAlimento = Integer.parseInt(request.getParameter("codAlimento"));
	    	Alimento alimento = alimentoDao.get(codAlimento);
	    	request.setAttribute("alimento", alimento);
    	} else {
    		int codUsuario = Integer.parseInt(request.getParameter("codUsuario"));
    		request.setAttribute("alimentos", alimentoDao.getByUser(codUsuario));
    	}
    }
    
    protected void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
    	Alimento alimento = new Alimento();
    	alimento.setDtConsumida(dtf.parse(request.getParameter("dtConsumida")));
    	alimento.setNome(request.getParameter("nome"));
    	alimento.setQtCalorias(Integer.parseInt(request.getParameter("qtCalorias")));
    	alimento.setQtConsumida(Double.parseDouble(request.getParameter("qtConsumida")));
    	
        int inserted = alimentoDao.insert(alimento);

        if (inserted == -1) {
        	request.setAttribute("error", "Ocorreu um erro ao incluir o alimneto. Tente novamente.");
        } else {
        	request.setAttribute("msg", "Cadastro inserido com sucesso!");
        }
        
        int codUsuario = Integer.parseInt(request.getParameter("codUsuario"));
		request.setAttribute("alimentos", alimentoDao.getByUser(codUsuario));
        
        request.getRequestDispatcher("listagem-refeicoes.jsp").forward(request, response);
    }
    
    protected void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
    	int codAlimento = Integer.parseInt(request.getParameter("codAlimento"));
    	
    	Alimento alimento = new Alimento();
    	alimento.setDtConsumida(dtf.parse(request.getParameter("dtConsumida")));
    	alimento.setNome(request.getParameter("nome"));
    	alimento.setQtCalorias(Integer.parseInt(request.getParameter("qtCalorias")));
    	alimento.setQtConsumida(Double.parseDouble(request.getParameter("qtConsumida")));
    	
        boolean updated = alimentoDao.update(codAlimento, alimento);

        if (!updated) {
        	request.setAttribute("error", "Ocorreu um erro ao editar o alimneto. Tente novamente.");
        } else {
        	request.setAttribute("msg", "Cadastro atualizado com sucesso!");
        }
        
        int codUsuario = Integer.parseInt(request.getParameter("codUsuario"));
		request.setAttribute("alimentos", alimentoDao.getByUser(codUsuario));
        
        request.getRequestDispatcher("listagem-refeicoes.jsp").forward(request, response);
    }
    
    protected void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int codAlimento = Integer.parseInt(request.getParameter("codAlimento"));
    	
    	boolean deleted = alimentoDao.delete(codAlimento);
    	
    	if (!deleted) {
        	request.setAttribute("error", "Ocorreu um erro ao excluir o alimneto. Tente novamente.");
        } else {
        	request.setAttribute("msg", "Cadastro excluído com sucesso!");
        }
        
        request.getRequestDispatcher("listagem-refeicoes.jsp").forward(request, response);
    }
}
