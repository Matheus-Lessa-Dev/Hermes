/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAO.ExercicioDAO;
import DAO.ExercicioMusculoDAO;
import DAO.ImagemDAO;
import DAO.MusculoDAO;
import Entities.Exercicio;
import Entities.Imagem;
import Entities.Musculo;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author mathe
 */
@WebServlet(name = "ControllerExercicio", urlPatterns = {"/ControllerExercicio", "/ListagemExercicioADM",
"/novoExercicio", "/CadastrarExerciciosADM", "/selecionarEx", "/deletarEx", "/editarEx"})
@MultipartConfig
public class ControllerExercicio extends HttpServlet {

    MusculoDAO dao2 = new MusculoDAO();
    Musculo musculo = new Musculo();
    ExercicioDAO dao = new ExercicioDAO();
    ExercicioMusculoDAO dao3 = new ExercicioMusculoDAO();
    
    Exercicio exercicio = new Exercicio();
    private static final String UPLOAD_DIR = "uploads";
    Imagem imagem = new Imagem();
    ImagemDAO daoI = new ImagemDAO();

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println(action);
        if (action.equals("/ListagemExercicioADM")) {
            exercicios(request, response);
        } else if (action.equals("/CadastrarExerciciosADM")) {
             CadastrarEADM(request, response);
        }else if (action.equals("/novoExercicio")) {
             novoExercicio(request, response);
        }else if (action.equals("/selecionarEx")) {
             listarExercicio(request, response);
        }else if (action.equals("/deletarEx")) {
            deletarExercicio(request, response);
        }else if (action.equals("/editarEx")) {
            editarExercicio(request, response);
        }
        
        }
  
protected void exercicios(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8"); 
          ArrayList<Exercicio> lista = dao.listarExercicios();
          request.setAttribute("exercicios", lista); 
          request.getRequestDispatcher("WEB-INF/ListagemExerciciosADM.jsp").forward(request, response);
    }
    
    protected void CadastrarEADM(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
         request.setCharacterEncoding("UTF-8"); 
        ArrayList<Musculo> lista = dao2.listarMusculos();
        request.setAttribute("musculos", lista); 
          System.out.println("lista Controller" + lista);

          request.getRequestDispatcher("WEB-INF/CadastrarExerciciosADM.jsp").forward(request, response);
    }
    
   protected void novoExercicio(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
request.setCharacterEncoding("UTF-8"); 
    // Captura o nome e descrição do exercício
    String nomeExercicio = request.getParameter("nome");
    String descricaoExercicio = request.getParameter("desc");

    // Preenche o objeto exercício
    exercicio.setNome(nomeExercicio);
    exercicio.setDescricao(descricaoExercicio);

    // Insere o exercício no banco e recupera o ID gerado
    dao.inserir(exercicio);
    int idExercicio = dao.buscarID(nomeExercicio); // Recupera o ID do exercício inserido

    if (idExercicio > 0) {
        System.out.println("Exercício cadastrado com ID: " + idExercicio);

        // Captura os IDs dos músculos selecionados
        String[] musculosSelecionados = request.getParameterValues("musculosSelecionados");
        if (musculosSelecionados != null && musculosSelecionados.length > 0) {
            System.out.println("Músculos selecionados para o exercício:");
            for (String musculoId : musculosSelecionados) {
                int musculoIdCerto = Integer.parseInt(musculoId);
                   
                dao3.inserir(idExercicio, musculoIdCerto);
             
                System.out.println("Músculo associado com ID: " + musculoIdCerto);
            }
        } else {
            System.out.println("Nenhum músculo foi selecionado.");
        }

        // Captura o arquivo enviado
        Part filePart = request.getPart("file"); // Recebe o arquivo
        String descricaoImagem = request.getParameter("descricao");

        if (filePart != null && descricaoImagem != null && !descricaoImagem.isEmpty()) {
            // Caminho do diretório de uploads
            String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) uploadDir.mkdir(); // Cria o diretório de uploads se não existir

            // Obter o nome do arquivo e definir o caminho completo onde ele será salvo
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            String filePath = uploadPath + File.separator + fileName;

            // Salva o arquivo no diretório especificado
            filePart.write(filePath);

            // Caminho relativo para armazenar no banco de dados
            String caminhoRelativo = UPLOAD_DIR + File.separator + fileName;
            System.out.println("Arquivo salvo em: " + caminhoRelativo);

            // Preenche o objeto imagem
            imagem.setIdExercicio(idExercicio);
            imagem.setDescricao(descricaoImagem);
            imagem.setCaminho(caminhoRelativo);

            // Insere a imagem no banco
            daoI.inserirExercicio(imagem);
            System.out.println("Imagem associada ao exercício com ID: " + idExercicio);
        }
    } else {
        System.out.println("Erro ao cadastrar o exercício. ID inválido.");
    }

    // Redireciona para a lista de exercícios
    response.sendRedirect("ListagemExercicioADM");
}

        
            
        
   protected void listarExercicio(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); 
        int id = Integer.parseInt(request.getParameter("id"));

        exercicio.setID(id);
        dao.selecionarExercicio(exercicio);

        ArrayList<Musculo> lista = dao2.listarMusculos();
        request.setAttribute("musculos", lista); 
        
        ArrayList<Integer> lista2 = (ArrayList<Integer>) dao3.buscarMusculos(exercicio.getID());
        request.setAttribute("musculosSelecionados", lista2); 
        
        request.setAttribute("id", exercicio.getID());
        request.setAttribute("nome", exercicio.getNome());
        request.setAttribute("imgMusculo", dao.acharImagem(id));
        request.setAttribute("desc", exercicio.getDescricao());
        System.out.println("Nome no Listagem" + exercicio.getNome());
        System.out.println("Descrição no Listagem" + exercicio.getDescricao());
        
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/EditarExcluirExerciciosADM.jsp");
        rd.forward(request, response);

    
    }
    
        protected void deletarExercicio(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); 
            exercicio.setID(Integer.parseInt(request.getParameter("id")));
        System.out.println("ID Controller" +  request.getParameter("id"));
                //executar metodo dao
                
                dao.deletarExercicio(exercicio);
                response.sendRedirect("ListagemExercicioADM");
   
    }
        
          protected void editarExercicio(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");

    int idExercicio = Integer.parseInt(request.getParameter("id"));
    String nome = request.getParameter("nome");
    String descricao = request.getParameter("desc");

    exercicio.setID(idExercicio);
    exercicio.setNome(nome);
    exercicio.setDescricao(descricao);

    // Executar método DAO para atualizar o exercício
    dao.alterarExercicio(exercicio);

    // Captura os IDs dos músculos selecionados
    String[] musculosSelecionados = request.getParameterValues("musculosSelecionados");
    if (musculosSelecionados != null && musculosSelecionados.length > 0) {
        
        dao3.OutroMetodo(idExercicio);
        
        for (String musculoId : musculosSelecionados) {
            int musculoIdCerto = Integer.parseInt(musculoId);
            dao3.inserir(idExercicio, musculoIdCerto); // Atualiza a associação
            System.out.println("Músculo associado ao exercício com ID: " + musculoIdCerto);
        }
        
    } else {
        // Caso não haja músculos selecionados, limpa as associações
        dao3.OutroMetodo(idExercicio);
    }

    // Verificar se uma nova imagem foi carregada
    Part filePart = request.getPart("novaImgMusculo"); // Recebe o arquivo
    if (filePart != null && filePart.getSize() > 0) {
        // Caminho do diretório de uploads
        String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir(); // Cria o diretório de uploads se não existir

        // Obter o nome do arquivo e definir o caminho completo onde ele será salvo
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String filePath = uploadPath + File.separator + fileName;

        // Salvar arquivo no diretório especificado
        filePart.write(filePath);

        // Caminho relativo para armazenar no banco de dados
        String caminhoRelativo = "uploads" + File.separator + fileName;

        // Atualizar os dados da imagem
        imagem.setIdExercicio(idExercicio);
        imagem.setCaminho(caminhoRelativo);
        imagem.setDescricao(descricao);

        System.out.println("IdExercicio: " + idExercicio);
        System.out.println("CaminhoRelativo: " + caminhoRelativo);

        // Executar método DAO para atualizar a imagem
        daoI.atualizarImagemExercicio(imagem);
    }

    // Redireciona para a listagem de exercícios
    response.sendRedirect("ListagemExercicioADM");
}


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
