/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexões.ConexaoBD;
import Entities.Imagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author mathe
 */
public class ImagemDAO {
    
    public void inserirMusculo(Imagem I) {

        String sql = "INSERT INTO Imagens (caminho, descricao, id_Musculo) VALUES (?, ?, ?);";
        try {
            Connection con = ConexaoBD.conectar();
            con.setClientInfo("characterEncoding", "UTF-8");
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, I.getCaminho());
            st.setString(2, I.getDescricao());
            st.setInt(3, I.getIdMusculo());

            st.executeUpdate();


            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
        public void inserirExercicio(Imagem I) {

        String sql = "INSERT INTO Imagens (caminho, descricao, id_Exercicio) VALUES (?, ?, ?);";
        try {
            Connection con = ConexaoBD.conectar();
            con.setClientInfo("characterEncoding", "UTF-8");
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, I.getCaminho());
            st.setString(2, I.getDescricao());
            st.setInt(3, I.getIdExercicio());

            st.executeUpdate();


            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
           public void atualizarImagemMusculo(Imagem imagem) {
        String sql = "UPDATE Imagens SET caminho = ?, descricao = ? WHERE id_Musculo = ?";
        try {
            Connection con = ConexaoBD.conectar();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, imagem.getCaminho());
            st.setString(2, imagem.getDescricao());
            st.setInt(3, imagem.getIdMusculo());
            st.executeUpdate();
            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
           
                      public void atualizarImagemExercicio(Imagem imagem) {
        String sql = "UPDATE Imagens SET caminho = ?, descricao = ? WHERE id_Exercicio = ?";
        try {
            Connection con = ConexaoBD.conectar();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, imagem.getCaminho());
            st.setString(2, imagem.getDescricao());
            st.setInt(3, imagem.getIdExercicio());
            st.executeUpdate();
            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
