package model;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private static int proximoId = 1;
    private int id;
    private String nome;
    private String email;
    private String descricao;
    private String data;
    private String senha;

    private List<Reclamacao> reclamacoesRecebidas;
    private List<Devolucao> pedidosDevolucaoRecebidos;
    private static List<Empresa> empresas = new ArrayList<>();

    public Empresa(String nome, String email, String descricao, String data, String senha) {
        this.id = proximoId++;
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.data = data;
        this.senha = senha;
        this.reclamacoesRecebidas = new ArrayList<>();
        this.pedidosDevolucaoRecebidos = new ArrayList<>();
        empresas.add(this);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Reclamacao> getReclamacoesRecebidas() {
        return reclamacoesRecebidas;
    }

    public void setReclamacoesRecebidas(List<Reclamacao> reclamacoesRecebidas) {
        this.reclamacoesRecebidas = reclamacoesRecebidas;
    }

    public List<Devolucao> getPedidosDevolucaoRecebidos() {
        return pedidosDevolucaoRecebidos;
    }

    public void setPedidosDevolucaoRecebidos(List<Devolucao> pedidosDevolucaoRecebidos) {
        this.pedidosDevolucaoRecebidos = pedidosDevolucaoRecebidos;
    }

    public static List<Empresa> getEmpresas() {
        return empresas;
    }

}
