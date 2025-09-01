package Conexões;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBD {
    
    private static String driver = "com.mysql.cj.jdbc.Driver";
private static String url = "jdbc:mysql://127.0.0.1:3306/hermes?useUnicode=true&characterEncoding=UTF-8&useTimezone=true&serverTimezone=UTC&characterSetResults=UTF-8";
    private static String user = "root";
    private static String password = "kioji";

    public static Connection conectar() {

        try {

            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, password);
            con.setClientInfo("characterEncoding", "UTF-8");
            return con;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public static void testeConexao() {
        try {

            Connection con = conectar();
            System.out.println("conexao estabelecida: "+con);
            con.close();

        } catch (Exception e) {
            System.out.println("erro na conexao: "+e);
        }
    }

    
    
}
