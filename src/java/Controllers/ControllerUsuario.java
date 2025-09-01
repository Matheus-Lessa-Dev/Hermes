/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAO.UsuarioDAO;
import Entities.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mathe
 */
@WebServlet(name = "ControllerUsuario", urlPatterns = {"/ControllerUsuario", "/Cadastro", "/irCadastrar", "/Login", "/index", "/ListagemUsuarioADM"})
public class ControllerUsuario extends HttpServlet {
    
    Usuario usuario = new Usuario();
    UsuarioDAO dao = new UsuarioDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String action = request.getServletPath();
                        System.out.println(action);

        if (action.equals("/Cadastro")) {
            Cadastro(request, response);
        } else if (action.equals("/irCadastrar")) {
            irCadastrar(request, response);
        }
        else if (action.equals("/Login")) {
            Login(request, response);
        } else if (action.equals("/index")) {
            index(request, response);
        }
        else if (action.equals("/ListagemUsuarioADM")) {
            usuarios(request, response);
        }
 
        
        
    }
    
        protected void usuarios(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
          
          ArrayList<Usuario> lista = dao.listarUsuarios();
          request.setAttribute("usuarios", lista); 
           System.out.println("Lista de Usuários: " + lista);
          request.getRequestDispatcher("WEB-INF/ListagemUsuarioADM.jsp").forward(request, response);
          
    }
        protected void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             request.setAttribute("erroLogin", "Usuário ou senha não encontrados");
         request.getRequestDispatcher("index.jsp").forward(request, response);
    }
protected void Login(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    
    String Email = request.getParameter("email");
    String Senha = request.getParameter("senha");
    usuario.setGmail(Email);
    usuario.setSenha(Senha);
    
    // Verifica se o usuário e senha estão corretos
    if (dao.buscarUsuario(usuario)) {
        // Se for válido, redireciona para o menu
        request.getRequestDispatcher("Menu").forward(request, response);
    } else {
        // Se não encontrar, envia uma mensagem de erro apenas no caso de falha no login
        HttpSession session = request.getSession();
        session.setAttribute("erroLogin", "Usuário ou senha não encontrados");
        response.sendRedirect("index.jsp"); // Redireciona para a página de login
    }
}




    protected void irCadastrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           request.getRequestDispatcher("WEB-INF/CadastrarUsuario.jsp").forward(request, response);
    }
    
protected void Cadastro(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    
    String Email = request.getParameter("email");
    String Senha = request.getParameter("senha");
    String nome = request.getParameter("nome");
    
    // Verifica se o e-mail já está cadastrado
    boolean emailExistente = dao.verificarEmailExistente(Email);
    
    if (emailExistente) {
        // Se o e-mail já existir, envie uma mensagem de erro para a página
        request.setAttribute("erroEmail", "Este e-mail já está cadastrado.");
        request.getRequestDispatcher("WEB-INF/CadastrarUsuario.jsp").forward(request, response);
    } else {
        // Caso contrário, continue com o cadastro
        Usuario usuario = new Usuario();
        usuario.setGmail(Email);
        usuario.setNome(nome);
        usuario.setSenha(Senha);
        usuario.setAdministrador(false); // Se for administrador, modifique conforme necessário
        dao.inserir(usuario);
        
        request.getRequestDispatcher("index").forward(request, response);
    }
}


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
