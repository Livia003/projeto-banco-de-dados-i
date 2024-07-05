package controller;

import java.util.List;

import model.Cliente;

public class ClienteController {

    public void cadastrarNovoCliente(Cliente cliente) {
        Cliente.getClientes().add(cliente);
    }

    public List<Cliente> getClientes() {
        return Cliente.getClientes();
    }

    public static Cliente buscarClientePorId(int id) {
        List<Cliente> clientes = Cliente.getClientes();
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    public Cliente buscarClientePorEmailESenha(String email, String senha) {
        for (Cliente cliente : Cliente.getClientes()) {
            if (cliente.getEmail().equals(email) && cliente.getSenha().equals(senha)) {
                return cliente;
            }
        }
        return null;
    }
}
