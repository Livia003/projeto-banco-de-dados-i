package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {

    private static List<Cliente> clientes = new ArrayList<>();
    private List<Reclamacao> reclamacoes;
    private List<Devolucao> devolucoes;
    private int id;
    private static int proximoId = 0;

    public Cliente(String nome, String email, String senha) {
        super(nome, email, senha);
        this.id = proximoId++;
        this.reclamacoes = new ArrayList<>();
        this.devolucoes = new ArrayList<>();
        clientes.add(this);
    }

    public List<Reclamacao> getReclamacoes() {
        return reclamacoes;
    }

    public void setReclamacoes(List<Reclamacao> reclamacoes) {
        this.reclamacoes = reclamacoes;
    }

    public void adicionarReclamacao(Reclamacao reclamacao) {
        this.reclamacoes.add(reclamacao);
    }

    public void setDevolucao(List<Devolucao> devolucoes) {
        this.devolucoes = devolucoes;
    }

    public void adicionarDevolucao(Devolucao devolucao) {
        this.devolucoes.add(devolucao);
    }

    public int getId() {
        return id;
    }

    public static List<Cliente> getClientes() {
        return clientes;
    }

    public static Cliente buscarClientePorId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

}
