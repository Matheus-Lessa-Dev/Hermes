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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author mathe
 */
public class ExercicioMusculoDAO {
          public void alterarMusculosSelecionados(int idE, int id){
   
                      String update2 = "DELETE FROM exerciciomusculo WHERE id_Exercicio = ? AND id_Musculo <> ?;";
                      String update = "INSERT INTO exerciciomusculo (id_Exercicio, id_Musculo) VALUES (?, ?);";
    
   
		try {
			// abrir a conexão
			Connection con = ConexaoBD.conectar();
                        con.setClientInfo("characterEncoding", "UTF-8");
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(update);
                        PreparedStatement pst2 = con.prepareStatement(update2);
                        //substituir o ? 
                        pst.setInt(2, id);
                        pst.setInt(1, idE);
                        pst2.setInt(2, id);
                        pst2.setInt(1, idE);
                        //executar query
                        pst.executeUpdate();
                        pst2.executeUpdate();
			// encerrar conexão com o banco
			con.close();
			

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			
		}
              
              

}
          
              public void OutroMetodo(int idE) {

                 String update = "delete from exerciciomusculo where id_Exercicio=?";
    
   
		try {
			// abrir a conexão
			Connection con = ConexaoBD.conectar();
                        con.setClientInfo("characterEncoding", "UTF-8");
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(update);
                        //substituir o ? 

                        pst.setInt(1, idE);
                        //executar query
                        pst.executeUpdate();
			// encerrar conexão com o banco
			con.close();
			

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			
		}
    }
    
    public void inserir(int idE, int idM) {

        String sql = "INSERT INTO exerciciomusculo (id_Exercicio, id_Musculo) VALUES (?, ?);";
        try {
            Connection con = ConexaoBD.conectar();
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, idE);
            st.setInt(2, idM);


            
            st.executeUpdate();


            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
public List<Integer> buscarExercicios(int id) {
    String sql = "select id_Exercicio from exerciciomusculo where id_Musculo=?";
    List<Integer> exercicios = new ArrayList<>();

    try {
        Connection con = ConexaoBD.conectar();
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            int exercicioId = rs.getInt("id_Exercicio");
            exercicios.add(exercicioId);
            // Printar o exercício encontrado
            System.out.println("Exercício encontrado: " + exercicioId);
        }
  System.out.println("Gozei" + exercicios);
        st.close();
        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return exercicios;
  
}

public List<Integer> buscarMusculos(int id) {
    String sql = "select id_Musculo from exerciciomusculo where id_Exercicio=?";
    List<Integer> musculos = new ArrayList<>();

    try {
        Connection con = ConexaoBD.conectar();
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
     
            int musculoId = rs.getInt("id_Musculo");
            musculos.add(musculoId);
            // Printar o exercício encontrado
            System.out.println("Exercício encontrado: " + musculoId);
        }

        st.close();
        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return musculos;
  
}


}
