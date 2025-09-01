/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexões.ConexaoBD;
import Entities.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author mathe
 */
public class UsuarioDAO {
    
           public ArrayList<Usuario> listarUsuarios() {
		// criando um objeto para accessar a classe Java Beans
		ArrayList<Usuario> usuario = new ArrayList<>();
		String read = "select * from usuario";
		try 
                {
			// abrir a conexão
			Connection con = ConexaoBD.conectar();
			// preparar a query para execução no banco de dados
			PreparedStatement st = con.prepareStatement(read);
			// executar query e armazenar no set
			ResultSet rs = st.executeQuery();
			// O laço será executado enquanto houver usuario
			while (rs.next()) {
				// variaveis de apoio que recebem os dados do banco
				int id = rs.getInt(1);
				String email = rs.getString(2);
                                String senha = rs.getString(3);
				// populandoo arraylist
				usuario.add(new Usuario(id, email, senha));

			}
                         System.out.println("Lista de Usuarios DAO: " + usuario);
			// encerrar conexão com o banco
			con.close();
			// retornar usuario
			return usuario;
                        

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
    
    
public boolean buscarUsuario(Usuario usuario) {
    String sql = "SELECT * FROM Usuario WHERE gmail = ? AND senha = ?";
    try (Connection con = ConexaoBD.conectar(); 
         PreparedStatement st = con.prepareStatement(sql)) {

        // Define os parâmetros da consulta
        st.setString(1, usuario.getGmail());
        st.setString(2, usuario.getSenha());

        ResultSet rs = st.executeQuery();
        
        if (rs.next()) {
            return true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

    
            public void inserir(Usuario U) {

        String sql = "INSERT INTO Usuario (gmail, senha, nome, peso, altura, gorduraCorporal, administrador) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection con = ConexaoBD.conectar();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, U.getGmail());
            st.setString(2, U.getSenha());
            st.setString(3, U.getNome());
            st.setDouble(4, U.getPeso());
            st.setInt(5, U.getAltura());
            st.setInt(6, U.getGorduraCorporal());
            st.setBoolean(7, U.isAdministrador());

            st.executeUpdate();


            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
            
            public boolean verificarEmailExistente(String email) {
    String sql = "SELECT COUNT(*) FROM Usuario WHERE gmail = ?";
    try (Connection con = ConexaoBD.conectar();
         PreparedStatement st = con.prepareStatement(sql)) {
        
        st.setString(1, email);
        ResultSet rs = st.executeQuery();
        
        if (rs.next()) {
            // Se o resultado for maior que 0, o e-mail já está cadastrado
            return rs.getInt(1) > 0;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return false;
}

}
