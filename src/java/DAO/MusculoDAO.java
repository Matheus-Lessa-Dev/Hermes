/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexões.ConexaoBD;
import Entities.Musculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mathe
 */
public class MusculoDAO {
        public void inserir(Musculo M) {

        String sql = "INSERT INTO Musculo (nome, descricao) VALUES (?, ?);";
        try {
            Connection con = ConexaoBD.conectar();
            con.setClientInfo("characterEncoding", "UTF-8");
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, M.getNome());
            st.setString(2, M.getDescricao());


            st.executeUpdate();


            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
public String acharImagem(int id) {
    String sql = "select caminho from imagens where id_Musculo=?";
    try {
        Connection con = ConexaoBD.conectar();
        PreparedStatement st = con.prepareStatement(sql);
        con.setClientInfo("characterEncoding", "UTF-8");
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
        String sql = "select id from musculo where nome=?";
        try {
            Connection con = ConexaoBD.conectar();
            PreparedStatement st = con.prepareStatement(sql);
            con.setClientInfo("characterEncoding", "UTF-8");
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
        
        public ArrayList<Musculo> listarMusculos() {
		// criando um objeto para accessar a classe Java Beans
		ArrayList<Musculo> musculos = new ArrayList<>();
		String read = "select * from musculo";
		try 
                {
			// abrir a conexão
			Connection con = ConexaoBD.conectar();
                        con.setClientInfo("characterEncoding", "UTF-8");
			// preparar a query para execução no banco de dados
			PreparedStatement st = con.prepareStatement(read);
			// executar query e armazenar no set
			ResultSet rs = st.executeQuery();
			// O laço será executado enquanto houver musculos
			while (rs.next()) {
				// variaveis de apoio que recebem os dados do banco
				int id = rs.getInt(1);
				String nome = rs.getString(2);
                                String desc = rs.getString(3);
				// populandoo arraylist
				musculos.add(new Musculo(id, nome, desc));

			}
                         System.out.println("Lista de músculos DAO: " + musculos);
			// encerrar conexão com o banco
			con.close();
			// retornar musculos
			return musculos;
                        

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
        
        public void selecionarMusculo(Musculo musculo){
   String read2 = "select * from musculo where id =?";

		try {
			// abrir a conexão
			Connection con = ConexaoBD.conectar();
                        con.setClientInfo("characterEncoding", "UTF-8");
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(read2);
                        //substituir o ? 
                        pst.setInt(1, musculo.getID());
			// executar query e armazenar no set
			ResultSet rs = pst.executeQuery();
			// O laço será executado enquanto houver musculos
			while (rs.next()) {
				//setar as variaveis
                                
                                musculo.setID((rs.getInt(1)));
                                musculo.setNome(rs.getString(2));
                                musculo.setDescricao(rs.getString(3));
			}
			// encerrar conexão com o banco
			con.close();
			

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			
		}
}
        
        public void deletarMusculo(Musculo musculo){
            
    String deleteExercicioMusculo = "delete from exerciciomusculo where id_Musculo=?";
    String deleteIMG = "delete from imagens where id_Musculo=?";
    String delete = "delete from musculo where id=?";
    

   try {
        // abrir a conexão
        Connection con = ConexaoBD.conectar();
        con.setClientInfo("characterEncoding", "UTF-8");
        // preparar e executar a query para excluir registros na tabela exerciciomusculo
        PreparedStatement pst = con.prepareStatement(deleteExercicioMusculo);
        pst.setInt(1, musculo.getID());
        pst.executeUpdate();
        pst.close();

        // preparar e executar a query para excluir registros na tabela imagens
        pst = con.prepareStatement(deleteIMG);
        pst.setInt(1, musculo.getID());
        pst.executeUpdate();
        pst.close();

        // preparar e executar a query para excluir o registro na tabela exercicio
        pst = con.prepareStatement(delete);
        pst.setInt(1, musculo.getID());
        pst.executeUpdate();
        pst.close();
        
        // encerrar conexão com o banco
        con.close();

    } catch (Exception e) {
        // TODO: handle exception
        System.out.println(e);
    }
}
        public void alterarMusculo(Musculo musculo){
    
    String update = "update musculo set nome=?, descricao=? where id=?";
    

		try {
			// abrir a conexão
			Connection con = ConexaoBD.conectar();
                        con.setClientInfo("characterEncoding", "UTF-8");
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(update);
                        //substituir o ? 
                        pst.setString(1, musculo.getNome());
                        pst.setString(2, musculo.getDescricao());
                        pst.setInt(3, musculo.getID());
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
