package Utilitarios;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;


public class Conexao {
    private final String URL = "jdbc:mysql://127.0.0.1:3306/biblioteca";
    private final String USUARIO = "root";
    private final String SENHA = "";
    private static Connection Con;

    public Conexao()
    {
        try {
            Con = DriverManager.getConnection(URL, USUARIO, SENHA);
            Con.setAutoCommit(false);
          //  JOptionPane.showMessageDialog(null, "Conectado com Sucesso", "Conectado", 1);
        } catch (Exception ex) {
         //   JOptionPane.showMessageDialog(null, "Erro ao Conectar com o Banco", "Erro", 0);
        }
    }
    
    public static Connection getConnection()
    {
        if (Con == null) {
            new Conexao();
        }
        return Con;
    }
    
    public static void fecharConexao()
    {
        try {
            if (!Con.isClosed()) {
                Con.close();
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    
    /*public static void main(String[] args) {
        Conexao.getConnection();
    }*/
}
