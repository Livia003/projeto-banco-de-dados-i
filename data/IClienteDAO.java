package data;
import java.util.ArrayList;
import model.*;

public interface IClienteDAO {
    ArrayList<Cliente> getAllClientes();
    void createCliente (Cliente cliente);
    Cliente readCliente (Long cpf);
    void updateCliente (Cliente cliente);
    void deleteCliente (Cliente cliente);
    Cliente queryAccount (Long cpf);
    Cliente queryName(Long cpf);
}