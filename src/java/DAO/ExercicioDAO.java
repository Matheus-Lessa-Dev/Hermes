/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexões.ConexaoBD;
import Entities.Exercicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;


/**
 *
 * @author mathe
 */
public class ExercicioDAO {
    
    public String acharImagem(int id) {
    String sql = "select caminho from imagens where id_Exercicio=?";
    try {
        Connection con = ConexaoBD.conectar();
        con.setClientInfo("characterEncoding", "UTF-8");
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();

        // Verifica se há algum registro antes de tentar obter o valor
        String caminho = null;
        if (rs.next()) {
            caminho = rs.getString("caminho");
            System.out.println("Caminho: " + caminho);
        }

        st.close();
        con.close();
        return caminho;
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
    
            public int buscarID(String nome) {
        String sql = "select id from exercicio where nome=?";
        try {
            Connection con = ConexaoBD.conectar();
            con.setClientInfo("characterEncoding", "UTF-8");
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, nome);
            ResultSet rs = st.executeQuery();
            int id = 0;
            while(rs.next()){
             id = rs.getInt("id");
            }
        
            

            st.close();
            con.close();
            return id;
        } catch (Exception e) {
            e.printStackTrace();
              return 0;
        }
        }
            
public Exercicio buscarEx(int id) {
    String sql = "select * from exercicio where id=?";
    try {
        System.out.println("ExercicioDAO Buscar ID:" + id);
        Connection con = ConexaoBD.conectar();
        con.setClientInfo("characterEncoding", "UTF-8");
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        
        // Verifique se há um resultado válido
        if (rs.next()) {
            String desc = rs.getString("descricao");
            String nome = rs.getString("nome");

            // Cria o objeto Exercicio com os dados do banco
            Exercicio exercicio = new Exercicio(id, nome, desc);

            st.close();
            con.close();

            return exercicio;
        } else {
            // Caso não encontre o exercício com o id fornecido
            st.close();
            con.close();
            return null;  // Ou lance uma exceção, dependendo da sua necessidade
        }
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}

            
    
            public void inserir(Exercicio E) {

        String sql = "INSERT INTO Exercicio (nome, descricao) VALUES (?, ?);";
        try {
            Connection con = ConexaoBD.conectar();
            con.setClientInfo("characterEncoding", "UTF-8");
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, E.getNome());
            st.setString(2, E.getDescricao());


            st.executeUpdate();


            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
       public ArrayList<Exercicio> listarExerciciosSelecionados(int i) {
		// criando um objeto para accessar a classe Java Beans
		ArrayList<Exercicio> exercicios = new ArrayList<>();
		String read = "select * from exercicio where id=?";
		try 
                {
			// abrir a conexão
			Connection con = ConexaoBD.conectar();
                        con.setClientInfo("characterEncoding", "UTF-8");
			// preparar a query para execução no banco de dados
			PreparedStatement st = con.prepareStatement(read);
                        st.setInt(1, i);
			// executar query e armazenar no set
			ResultSet rs = st.executeQuery();
			// O laço será executado enquanto houver exercicios
			while (rs.next()) {
				// variaveis de apoio que recebem os dados do banco
				int id = rs.getInt(1);
				String nome = rs.getString(2);
                                String desc = rs.getString(3);
				// populandoo arraylist
				exercicios.add(new Exercicio(id, nome, desc));

			}
			// encerrar conexão com o banco
			con.close();
			// retornar exercicios
			return exercicios;
                        

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
    
     public ArrayList<Exercicio> listarExercicios() {
		// criando um objeto para accessar a classe Java Beans
		ArrayList<Exercicio> exercicios = new ArrayList<>();
		String read = "select * from exercicio";
		try 
                {
			// abrir a conexão
			Connection con = ConexaoBD.conectar();
                        con.setClientInfo("characterEncoding", "UTF-8");
			// preparar a query para execução no banco de dados
			PreparedStatement st = con.prepareStatement(read);
			// executar query e armazenar no set
			ResultSet rs = st.executeQuery();
			// O laço será executado enquanto houver exercicios
			while (rs.next()) {
				// variaveis de apoio que recebem os dados do banco
				int id = rs.getInt(1);
				String nome = rs.getString(2);
                                String desc = rs.getString(3);
				// populandoo arraylist
				exercicios.add(new Exercicio(id, nome, desc));

			}
                         System.out.println("Lista de Exercícios DAO: " + exercicios);
			// encerrar conexão com o banco
			con.close();
			// retornar exercicios
			return exercicios;
                        

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
     
     public void selecionarExercicio(Exercicio exercicio){
   String read2 = "select * from exercicio where id =?";

		try {
			// abrir a conexão
			Connection con = ConexaoBD.conectar();
                        con.setClientInfo("characterEncoding", "UTF-8");
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(read2);
                        //substituir o ? 
                        pst.setInt(1, exercicio.getID());
			// executar query e armazenar no set
			ResultSet rs = pst.executeQuery();
			// O laço será executado enquanto houver exercicios
			while (rs.next()) {
				//setar as variaveis
                                
                                exercicio.setID((rs.getInt(1)));
                                exercicio.setNome(rs.getString(2));
                                exercicio.setDescricao(rs.getString(3));
			}
			// encerrar conexão com o banco
			con.close();
			

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			
		}
}
             public void deletarExercicio(Exercicio exercicio){
    String deleteExercicioMusculo = "delete from exerciciomusculo where id_Exercicio=?";
    String deleteIMG = "delete from imagens where id_Exercicio=?";
    String delete = "delete from exercicio where id=?";
     try {
        // abrir a conexão
        Connection con = ConexaoBD.conectar();
        con.setClientInfo("characterEncoding", "UTF-8");
        
        // preparar e executar a query para excluir registros na tabela exerciciomusculo
        PreparedStatement pst = con.prepareStatement(deleteExercicioMusculo);
        pst.setInt(1, exercicio.getID());
        pst.executeUpdate();
        pst.close();

        // preparar e executar a query para excluir registros na tabela imagens
        pst = con.prepareStatement(deleteIMG);
        pst.setInt(1, exercicio.getID());
        pst.executeUpdate();
        pst.close();

        // preparar e executar a query para excluir o registro na tabela exercicio
        pst = con.prepareStatement(delete);
        pst.setInt(1, exercicio.getID());
        pst.executeUpdate();
        pst.close();
        
        // encerrar conexão com o banco
        con.close();

    } catch (Exception e) {
        // TODO: handle exception
        System.out.println(e);
    }
}
             
                     public void alterarExercicio(Exercicio exercicio){
    
    String update = "update exercicio set nome=?, descricao=? where id=?";
    

		try {
			// abrir a conexão
			Connection con = ConexaoBD.conectar();
                        con.setClientInfo("characterEncoding", "UTF-8");
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(update);
                        //substituir o ? 
                        pst.setString(1, exercicio.getNome());
                        pst.setString(2, exercicio.getDescricao());
                        pst.setInt(3, exercicio.getID());
                        //executar query
                        pst.executeUpdate();
			// encerrar conexão com o banco
			con.close();
			

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			
		}
}
}
