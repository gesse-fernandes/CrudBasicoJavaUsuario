package Controller;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import DAO.UsuarioDao;
import Model.UsuarioModel;

public class UsuarioController {
    UsuarioDao usuarioDao;

    public UsuarioController()
    {
        usuarioDao = new UsuarioDao();
    }

    public boolean verificaDados(UsuarioModel user) {
        boolean x = true;
       /* if (user.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o Campo Nome", "Erro", 0, new ImageIcon(
                    "C:\\Users\\gesse\\OneDrive\\Documentos\\NetBeansProjects\\SofyDay\\src\\Imagens\\btn_sair.png"));
        }*/
        usuarioDao.cadastrar(user);
        return x;
    }
}
