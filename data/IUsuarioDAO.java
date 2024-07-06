package data;
import java.util.ArrayList;

import model.Usuario;

public interface IUsuarioDAO {
     ArrayList<Usuario> getAllUsuarios();
    void createUsuario (Usuario Usuario);
    Usuario readUsuario (int id);
    void updateUsuario (Usuario Usuario);
    void deleteUsuario (Usuario Usuario);
    Usuario queryAccount (int id);
    Usuario queryName(int id);
}
