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

import com.grupo30.dao.BatimentoCardiacoDao;
import com.grupo30.model.Atividade;
import com.grupo30.model.BatimentoCardiaco;

@WebServlet("/batimentocardiaco")
public class BatimentoCardiacoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private BatimentoCardiacoDao batimentoCardiacoDao;
	private DateFormat dtf;
	
	public void init() throws ServletException {
		super.init();
		batimentoCardiacoDao = new BatimentoCardiacoDao();
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
    	if (request.getParameter("codBatimentoCardiaco") != null) {
	    	int codBatimentoCardiaco = Integer.parseInt(request.getParameter("codBatimentoCardiaco"));
	    	BatimentoCardiaco batimentoCardiaco = batimentoCardiacoDao.get(codBatimentoCardiaco);
	    	request.setAttribute("batimentoCardiaco", batimentoCardiaco);
    	} else {
    		int codUsuario = Integer.parseInt(request.getParameter("codUsuario"));
    		request.setAttribute("batimentosCardiacos", batimentoCardiacoDao.getByUser(codUsuario));
    	}
    }
    
    protected void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
    	BatimentoCardiaco batimentoCardiaco = new BatimentoCardiaco();
    	batimentoCardiaco.setBatimentoMaximo(Integer.parseInt(request.getParameter("batimentoMaximo")));
    	batimentoCardiaco.setBatimentoMinimo(Integer.parseInt(request.getParameter("batimentoMinimo")));
    	batimentoCardiaco.setBatimentoMedio(Integer.parseInt(request.getParameter("batimentoMedio")));
    	batimentoCardiaco.setDtMedicao(dtf.parse(request.getParameter("dtMedicao")));
    	
    	int inserted = batimentoCardiacoDao.insert(batimentoCardiaco);

        if (inserted == -1) {
        	request.setAttribute("error", "Ocorreu um erro ao incluir o batimento cardiaco. Tente novamente.");
        } else {
        	request.setAttribute("msg", "Cadastro inserido com sucesso!");
        }
        
        request.getRequestDispatcher("listagem-batimentos.jsp").forward(request, response);
    	
    }
    
    protected void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
    	int codBatimentoCardiaco = Integer.parseInt(request.getParameter("codBatimentoCardiaco"));
    	
    	BatimentoCardiaco batimentoCardiaco = new BatimentoCardiaco();
    	batimentoCardiaco.setBatimentoMaximo(Integer.parseInt(request.getParameter("batimentoMaximo")));
    	batimentoCardiaco.setBatimentoMinimo(Integer.parseInt(request.getParameter("batimentoMinimo")));
    	batimentoCardiaco.setBatimentoMedio(Integer.parseInt(request.getParameter("batimentoMedio")));
    	batimentoCardiaco.setDtMedicao(dtf.parse(request.getParameter("dtMedicao")));
    	
    	boolean updated = batimentoCardiacoDao.update(codBatimentoCardiaco, batimentoCardiaco);

        if (!updated) {
        	request.setAttribute("error", "Ocorreu um erro ao editar o batimento cardiaco. Tente novamente.");
        } else {
        	request.setAttribute("msg", "Cadastro atualizado com sucesso!");
        }
        
        request.getRequestDispatcher("listagem-batimentos.jsp").forward(request, response);
    }
    
    protected void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int codBatimentoCardiaco = Integer.parseInt(request.getParameter("codBatimentoCardiaco"));
    	
    	boolean deleted = batimentoCardiacoDao.delete(codBatimentoCardiaco);
    	
    	if (!deleted) {
        	request.setAttribute("error", "Ocorreu um erro ao excluir o batimento cardiaco. Tente novamente.");
        } else {
        	request.setAttribute("msg", "Cadastro excluído com sucesso!");
        }
        
        request.getRequestDispatcher("listagem-batimentos.jsp").forward(request, response);
    }
}
