package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Model.UsuarioModel;
import Utilitarios.Conexao;

public class UsuarioDao {
    public UsuarioDao() {

    }

    public void cadastrar(UsuarioModel user) {
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
            JOptionPane.showMessageDialog(null, "Registro Salvo com sucesso", "Sucesso", 1, new ImageIcon(
                    "C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\ok.png"));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar no banco de dados", "Erro", 0, new ImageIcon(
                    "C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\btn_sair.png"));
        }
    }

    public String proximoUsuario() {
        String SELECT = "SELECT * from usuarios order by id desc limit 1";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(SELECT);
            ResultSet resposta = st.executeQuery();
            if (resposta.next()) {
                return (Integer.parseInt(resposta.getString("id")) + 1) + "";
            } else {
                return "1";
            }
        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "erro ao buscar com o registro", "Erro", 0, new ImageIcon(
                    "C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\btn_sair.png"));
            return "0";
        }
    }

    public void buscarUsuario(String pesquisa, DefaultTableModel modelo) {
        try {
            String SELECT = "SELECT * from usuarios where nome like '%" + pesquisa + "%'";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SELECT);
            ResultSet resultado = st.executeQuery();
            while (resultado.next()) {
                modelo.addRow(new Object[] { resultado.getInt("id"), resultado.getString("nome"),
                        resultado.getString("email"), resultado.getString("telefone"), resultado.getString("profissao"),
                        resultado.getString("endereco") });
            }
        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "erro ao buscar usuario", "Erro", 0, new ImageIcon(
                    "C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\btn_sair.png"));
        }
    }

    public void buscarUsuario(String pesquisa, List<String> lista) {
        try {
            String SELECT = "SELECT * from usuarios where nome like '%" + pesquisa + "%'";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SELECT);
            ResultSet resultado = st.executeQuery();
            while (resultado.next()) {
                lista.add(resultado.getInt("id") + "-----" + resultado.getString("nome") + "----"
                        + resultado.getString("email") + "-----" + resultado.getString("telefone") + "----"
                        + resultado.getString("profissao") + "-----" + resultado.getString("endereco"));
            }
        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "erro ao buscar usuario", "Erro", 0, new ImageIcon(
                    "C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\btn_sair.png"));
        }
    }

    public UsuarioModel PreecherCampos(int id) {
        UsuarioModel user = new UsuarioModel();
        try {
            String SELECT = "SELECT * FROM usuarios WHERE id = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SELECT);
            st.setInt(1, id);
            ResultSet result = st.executeQuery();
            while (result.next()) {
                user.setId(result.getInt("id"));
                user.setNome(result.getString("nome"));
                user.setEndereco(result.getString("endereco"));
                user.setTelefone(result.getString("telefone"));
                user.setEmail(result.getString("email"));
                user.setUf(result.getString("uf"));
                user.setCidade(result.getString("cidade"));
                user.setSexo(result.getString("sexo"));
                user.setProfissao(result.getString("profissao"));
                user.setEstadoCivil(result.getString("estadoCivil"));
            }
        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "erro ao buscar usuario", "Erro", 0, new ImageIcon(
                    "C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\btn_sair.png"));
        }
        return user;
    }

}
