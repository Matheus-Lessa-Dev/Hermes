package Controllers;

import DAO.ExercicioDAO;
import DAO.ExercicioMusculoDAO;
import DAO.ImagemDAO;
import DAO.MusculoDAO;
import Entities.Exercicio;
import Entities.ExercicioMusculo;
import Entities.Imagem;
import Entities.Musculo;
import com.sun.jdi.connect.spi.Connection;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.annotation.MultipartConfig;



@WebServlet(name = "ControllerMusculo", urlPatterns = 
        {"/ControllerMusculo", "/ListagemMusculoADM", "/CadastrarMusculosADM", "/novoMusculo", "/deletar", "/selecionar",
        "/editarMusculo", "/ListagemMusculo", "/MusculoEx"})
@MultipartConfig
public class ControllerMusculo extends HttpServlet {

    MusculoDAO dao = new MusculoDAO();
    Musculo musculo = new Musculo();
    private static final String UPLOAD_DIR = "uploads";
    Imagem imagem = new Imagem();
    ImagemDAO daoI = new ImagemDAO();
    ExercicioMusculoDAO daoEM = new ExercicioMusculoDAO();
    ExercicioDAO DAOexercicio = new ExercicioDAO();
        

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println(action);
        if (action.equals("/ListagemMusculoADM")) {
            musculos(request, response);
        } else if (action.equals("/CadastrarMusculosADM")) {
            cadastrarMusculo(request, response);
        }
        else if (action.equals("/novoMusculo")) {
            novoMusculo(request, response);
        }
        else if (action.equals("/deletar")) {
            deletarMusculo(request, response);
        }
         else if (action.equals("/selecionar")) {
            listarMusculoADM(request, response);
        }
        else if (action.equals("/editarMusculo")) {
            editarMusculo(request, response);
        } else if (action.equals("/ListagemMusculo")) {
            listarMusculo(request, response);        
    }else if (action.equals("/MusculoEx")) {
            listarMusculoEExer(request, response);
        }
   }
    
    
    
    protected void listarMusculoEExer(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));

        musculo.setID(id);
        dao.selecionarMusculo(musculo);

        
        request.setAttribute("id", musculo.getID());
        request.setAttribute("nome", musculo.getNome());
        request.setAttribute("imgMusculo", dao.acharImagem(id));
        request.setAttribute("desc", musculo.getDescricao());
        System.out.println("Nome no Listagem" + musculo.getNome());
        System.out.println("Descrição no Listagem" + musculo.getDescricao());
        
        daoEM.buscarExercicios(id);  
        
    List<Integer> exercicios = daoEM.buscarExercicios(id);
    request.setAttribute("exercicios", exercicios);

              ArrayList<Musculo> lista = dao.listarMusculos();
          request.setAttribute("musculos", lista); 
          
    if (!exercicios.isEmpty()) {
    ArrayList<Exercicio> Exercicios = new ArrayList();
    for(int i = 0; i < exercicios.size(); i++){
        
    Integer ExercicioI = exercicios.get(i);
    DAOexercicio.listarExerciciosSelecionados(i);
 
     Exercicio exercicio = DAOexercicio.buscarEx(ExercicioI);
    
     Exercicios.add(DAOexercicio.buscarEx(ExercicioI));
    }
    System.out.println("Exercicios: " + Exercicios);
    request.setAttribute("Exercicios", Exercicios);
    
} else {
    System.out.println("Lista esta Nula");
}
    


        
       RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/MusculoExercicio.jsp");
        rd.forward(request, response);


    }

    
    protected void listarMusculo(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
          
          ArrayList<Musculo> lista = dao.listarMusculos();
          request.setAttribute("musculos", lista); 
           System.out.println("Lista de músculos: " + lista);
          request.getRequestDispatcher("WEB-INF/ListagemMusculo.jsp").forward(request, response);
    }
    
    protected void musculos(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
          
          ArrayList<Musculo> lista = dao.listarMusculos();
          request.setAttribute("musculos", lista); 
           System.out.println("Lista de músculos: " + lista);
          request.getRequestDispatcher("WEB-INF/ListagemMusculosADM.jsp").forward(request, response);
    }
      
    protected void cadastrarMusculo(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/CadastrarMusculosADM.jsp").forward(request, response);
    }
            
    protected void novoMusculo(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); 

        System.out.println("Nome Musculo: " + request.getParameter("nome"));
        System.out.println("Desc Musculo: " + request.getParameter("desc"));

        musculo.setNome(request.getParameter("nome"));
        musculo.setDescricao(request.getParameter("desc"));
        dao.inserir(musculo);
        
        response.sendRedirect("ListagemMusculoADM");
        // recuperar o ID do musculo Inserido
        int id = dao.buscarID(musculo.getNome());
        System.out.println("ID do musculo cadastrado" + id);
        // Mudar o insert da Imagem na DAO
    
    Part filePart = request.getPart("file"); // Recebe o arquivo
    String descricao = request.getParameter("descricao");
    
    System.out.println("filePart" + filePart);
    System.out.println("Descrição da Imagem" + descricao);
    
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
     imagem.setIdMusculo(id);
     imagem.setDescricao(descricao);
     imagem.setCaminho(caminhoRelativo);
   //  imagem.setIdMusculo();
     daoI.inserirMusculo(imagem);
    }

    }
    
    protected void deletarMusculo(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        musculo.setID(Integer.parseInt(request.getParameter("id")));
        System.out.println("ID Controller" +  request.getParameter("id"));
                //executar metodo dao
                dao.deletarMusculo(musculo);
         response.sendRedirect("ListagemMusculoADM");
    }
     
    protected void listarMusculoADM(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));

        musculo.setID(id);
        dao.selecionarMusculo(musculo);

        
        request.setAttribute("id", musculo.getID());
        request.setAttribute("nome", musculo.getNome());
        request.setAttribute("imgMusculo", dao.acharImagem(id));
        request.setAttribute("desc", musculo.getDescricao());
        System.out.println("Nome no Listagem" + musculo.getNome());
        System.out.println("Descrição no Listagem" + musculo.getDescricao());
        
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/EditarExcluirMusculosADM.jsp");
        rd.forward(request, response);

    }
    
    protected void editarMusculo(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    // Configurações para multipart/form-data
    request.setCharacterEncoding("UTF-8");


    int id = Integer.parseInt(request.getParameter("id"));
    String nome = request.getParameter("nome");
    String descricao = request.getParameter("desc");

    musculo.setID(id);
    musculo.setNome(nome);
    musculo.setDescricao(descricao);

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

        imagem.setIdMusculo(id);
        imagem.setCaminho(caminhoRelativo);
        imagem.setDescricao(descricao);

        System.out.println("IdMusculo: " + id);
        System.out.println("CaminhoRelativo: " + caminhoRelativo);
        // Executar método DAO para atualizar a imagem

        daoI.atualizarImagemMusculo(imagem);
    }

    // Executar método DAO para atualizar o músculo

    dao.alterarMusculo(musculo);

    response.sendRedirect("ListagemMusculoADM");
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
    }
}
