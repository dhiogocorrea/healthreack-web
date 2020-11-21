package com.grupo30.servlets;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        if(login.equals("userx") && senha.equals("xxxxx")){
            response.sendRedirect("sucesso.html");
        } else{
            response.sendRedirect("acesso_negado.html");
        }
    }
}
