package model;

import java.util.Date;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Cliente  {

    private String nome;
    private String email;
    private String senha;
    private static List<Cliente> clientes = new ArrayList<>();
    private int id;
    // private static int proximoId;
    private long cpf;
    private Date dataNascimento;
    private long telefone;
    private String endereco;

    public Cliente(String nome, String email, String senha, long cpf, Date dataNascimento, long telefone,
            String endereco) {
        Random random = new Random();
        int proximoId = random.nextInt(100);
        this.nome=nome;
        this.email=email;
        this.senha=senha;
        this.id = proximoId++;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.endereco = endereco;
        clientes.add(this);
    }

    public Cliente() {
    }

    // Getters
    public int getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
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

    public void setId(int id){
        this.id =id;
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
