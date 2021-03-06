package Controller;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.UsuarioDao;
import Model.UsuarioModel;

public class UsuarioController {
    UsuarioDao usuarioDao;

    public UsuarioController() {
        usuarioDao = new UsuarioDao();
    }

    public boolean verificaDados(UsuarioModel user) {
        boolean x = true;
        if (user.getNome().equals("")) {

            JOptionPane.showMessageDialog(null, "Preencha o Campo Nome", "Erro", 0, new ImageIcon(
                    "C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\btn_sair.png"));

            x = false;

        } else if (user.getNome().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "O Campo Nome não pode Ser Nulo", "Erro", 0, new ImageIcon(
                    "C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\btn_sair.png"));
            x = false;
        }

        else if (user.getEndereco().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o Campo Endereço", "Erro", 0, new ImageIcon(
                    "C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\btn_sair.png"));
            x = false;
        } else if (user.getEndereco().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "O Campo Endereço não pode Ser Nulo", "Erro", 0, new ImageIcon(
                    "C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\btn_sair.png"));
            x = false;
        }

        
        else if (user.getEmail().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o Campo Email", "Erro", 0, new ImageIcon(
                    "C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\btn_sair.png"));
            x = false;
        } else if (user.getEmail().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "O Campo Email não pode Ser Nulo", "Erro", 0, new ImageIcon(
                    "C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\btn_sair.png"));
            x = false;
        } else if (user.getCidade().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o Campo Cidade", "Erro", 0, new ImageIcon(
                    "C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\btn_sair.png"));
            x = false;
        } else if (user.getCidade().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "O Campo Cidade não pode Ser Nulo", "Erro", 0, new ImageIcon(
                    "C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\btn_sair.png"));
            x = false;
        } else if (user.getUf().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o Campo Uf", "Erro", 0, new ImageIcon(
                    "C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\btn_sair.png"));
            x = false;
        } else if (user.getUf().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "O Campo Uf não pode Ser Nulo", "Erro", 0, new ImageIcon(
                    "C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\btn_sair.png"));
            x = false;
        } else if (user.getSexo().equals("Selecione")) {
            JOptionPane.showMessageDialog(null, "Selecione o sexo", "Erro", 0, new ImageIcon(
                    "C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\btn_sair.png"));
            x = false;
        } else if (user.getProfissao().equals("Selecione sua Profissão")) {
            JOptionPane.showMessageDialog(null, "Selecione sua Profissão", "Erro", 0, new ImageIcon(
                    "C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\btn_sair.png"));
            x = false;
        } else if (user.getEstadoCivil().equals("Selecione o estado civil")) {
            JOptionPane.showMessageDialog(null, "Selecione o seu estado civil", "Erro", 0, new ImageIcon(
                    "C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\btn_sair.png"));
            x = false;

        } else if (usuarioDao.existe(user)) 
            {
                JOptionPane.showMessageDialog(null, "Já existe alguem com esse email tente outro", "Erro", 0, new ImageIcon(
                        "C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\btn_sair.png"));
                x = false;
            }
         else {
          
            x = true;
        }
        if(x == true)
        {
            usuarioDao.cadastrar(user);
            return x;
        }        
        return x;

    }

    public boolean isTelefoneValido(String numero) {
        boolean status = true;
        String msg = "";
        if (numero.length() != 11) {
            msg += "Faltam dígitos no número do telefone!\nEspera-se onze dígitos!";
            status = false;
        }
        if (!status) {
            JOptionPane.showMessageDialog(null, msg, "Dados inválidos", JOptionPane.WARNING_MESSAGE);
        }
        return status;
    }

    public String controleCodigo()
    {
        return usuarioDao.proximoUsuario();
    }

    public void controlePesquisa(String pesquisa, DefaultTableModel modelo)
    {
        usuarioDao.buscarUsuario(pesquisa, modelo);
    }

    public void controlePesquisa(String pesquisa, List<String> lista)
    {
        usuarioDao.buscarUsuario(pesquisa, lista);
    }

    public UsuarioModel preencherCampos(int id)
    {
        return usuarioDao.PreecherCampos(id);
    }
    
    public boolean verificaDadosEditar(UsuarioModel user) {
        boolean x = true;
        if (user.getNome().equals("")) {

            JOptionPane.showMessageDialog(null, "Preencha o Campo Nome", "Erro", 0, new ImageIcon(
                    "C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\btn_sair.png"));

            x = false;

        } else if (user.getNome().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "O Campo Nome não pode Ser Nulo", "Erro", 0, new ImageIcon(
                    "C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\btn_sair.png"));
            x = false;
        }

        else if (user.getEndereco().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o Campo Endereço", "Erro", 0, new ImageIcon(
                    "C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\btn_sair.png"));
            x = false;
        } else if (user.getEndereco().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "O Campo Endereço não pode Ser Nulo", "Erro", 0, new ImageIcon(
                    "C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\btn_sair.png"));
            x = false;
        }

        else if (user.getEmail().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o Campo Email", "Erro", 0, new ImageIcon(
                    "C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\btn_sair.png"));
            x = false;
        } else if (user.getEmail().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "O Campo Email não pode Ser Nulo", "Erro", 0, new ImageIcon(
                    "C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\btn_sair.png"));
            x = false;
        } else if (user.getCidade().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o Campo Cidade", "Erro", 0, new ImageIcon(
                    "C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\btn_sair.png"));
            x = false;
        } else if (user.getCidade().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "O Campo Cidade não pode Ser Nulo", "Erro", 0, new ImageIcon(
                    "C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\btn_sair.png"));
            x = false;
        } else if (user.getUf().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o Campo Uf", "Erro", 0, new ImageIcon(
                    "C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\btn_sair.png"));
            x = false;
        } else if (user.getUf().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "O Campo Uf não pode Ser Nulo", "Erro", 0, new ImageIcon(
                    "C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\btn_sair.png"));
            x = false;
        } else if (user.getSexo().equals("Selecione")) {
            JOptionPane.showMessageDialog(null, "Selecione o sexo", "Erro", 0, new ImageIcon(
                    "C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\btn_sair.png"));
            x = false;
        } else if (user.getProfissao().equals("Selecione sua Profissão")) {
            JOptionPane.showMessageDialog(null, "Selecione sua Profissão", "Erro", 0, new ImageIcon(
                    "C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\btn_sair.png"));
            x = false;
        } else if (user.getEstadoCivil().equals("Selecione o estado civil")) {
            JOptionPane.showMessageDialog(null, "Selecione o seu estado civil", "Erro", 0, new ImageIcon(
                    "C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\btn_sair.png"));
            x = false;

        } else {

            x = true;
        }
        if (x == true) {
            usuarioDao.editarUsuario(user);
            return x;
        }
        return x;

    }
    public void deletar(UsuarioModel user)
    {
        usuarioDao.deletarUsuario(user);
    }


  
}
