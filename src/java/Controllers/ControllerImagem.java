/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;


import DAO.ImagemDAO;
import Entities.Imagem;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.annotation.MultipartConfig;

/**
 *
 * @author mathe
 */
@MultipartConfig

@WebServlet(name = "ControllerImagem", urlPatterns = {"/ControllerImagem", "/uploadImagem"})
public class ControllerImagem extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
        private static final String UPLOAD_DIR = "uploads";
        Imagem imagem = new Imagem();
ImagemDAO dao = new ImagemDAO();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println(action);
        
               if (action.equals("/ControllerImagem")) {
            response.sendRedirect("index.html");
        } else if (action.equals("/uploadImagem")) {
            testeIMG(request, response);
        }
    }
    
    protected void testeIMG(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    
        Part filePart = request.getPart("file"); // Recebe o arquivo
    String descricao = request.getParameter("descricao");
    
    if (filePart != null && descricao != null && !descricao.isEmpty()) {
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
    System.out.println("Part:" + caminhoRelativo);
     System.out.println("Descrição:" + descricao);
     
     imagem.setDescricao(descricao);
     imagem.setCaminho(caminhoRelativo);
     dao.inserirMusculo(imagem);
    }
    

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
