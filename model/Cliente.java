package model;

import java.util.Date;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {

    private static List<Cliente> clientes = new ArrayList<>();
    private List<Reclamacao> reclamacoes;
    private List<Devolucao> devolucoes;
    private int id;
    private static int proximoId = 0;
    private long cpf;
    private Date dataNascimento;
    private long telefone;
    private String endereco;

    public Cliente(String nome, String email, String senha, long cpf, Date dataNascimento, long telefone,
            String endereco) {
        super(nome, email, senha);
        Random random = new Random();
        int proximoId = random.nextInt(100);
        this.id = proximoId++;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.endereco = endereco;
        this.reclamacoes = new ArrayList<>();
        this.devolucoes = new ArrayList<>();
        clientes.add(this);
    }

    public Cliente() {
    }

    // Getters e Setters para os novos atributos
    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Reclamacao> getReclamacoes() {
        return reclamacoes;
    }

    public List<Devolucao> getDevolucoes() {
        return devolucoes;
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
