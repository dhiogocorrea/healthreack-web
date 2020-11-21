package com.grupo30.servlets;

import com.grupo30.dao.UsuarioDao;
import com.grupo30.model.Usuario;

import java.io.IOException;

@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = new Usuario();
        usuario.setNome(request.getParameter("nome"));
        usuario.setSobrenome(request.getParameter("sobrenome"));
        usuario.setCpf();
        usuario.setSexo();
        usuario.setEmail();
        usuario.setDtNascimento();
        usuario.setDtRegistro();
        usuario.setDtAssinatura();
        usuario.setNumeroTelefone();
        usuario.setPeso();
        usuario.setPlano();

        UsuarioDao usuarioDao = new UsuarioDao();

        usuarioDao.insert(usuario);

        request.getRequastDispatcher("sucesso.jsp").forward(request, response);
    }
}
