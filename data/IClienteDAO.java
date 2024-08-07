package data;
import java.util.ArrayList;
import model.*;

public interface IClienteDAO {
    ArrayList<Cliente> getAllClientes();
    void createCliente (Cliente cliente);
    Cliente readCliente (String email);
    void updateCliente (Cliente cliente);
    void deleteCliente (Cliente cliente);
    Cliente queryAccount (int id);
    Cliente queryName(Long cpf);
}