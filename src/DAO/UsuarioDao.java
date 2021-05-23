package DAO;

import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Model.UsuarioModel;
import Utilitarios.Conexao;

public class UsuarioDao {
    public UsuarioDao()
    {

    }


    public void cadastrar(UsuarioModel user)
    {
        try {
            String sQlInsert = "INSERT INTO usuarios(nome, endereco, telefone, email, uf, cidade, sexo, profissao, estadoCivil)VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = Conexao.getConnection().prepareStatement(sQlInsert);
            st.setString(1, user.getNome());
            st.setString(2, user.getEndereco());
            st.setString(3, user.getTelefone());
            st.setString(4, user.getEmail());
            st.setString(5, user.getUf());
            st.setString(6, user.getCidade());
            st.setString(7, user.getSexo());
            st.setString(8, user.getProfissao());
            st.setString(9, user.getEstadoCivil());
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro Salvo com sucesso", "Sucesso", 1,new ImageIcon("C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\ok.png"));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar no banco de dados", "Erro", 0, new ImageIcon(
                    "C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\btn_sair.png"));
        }
    }
}
