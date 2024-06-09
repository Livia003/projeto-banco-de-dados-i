package model;

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

    public Empresa(String nome, String email, String descricao, String data, String senha) {
        this.id = proximoId++;
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.data = data;
        this.senha = senha;
    }

    // Construtor
    public Empresa(List<Reclamacao> reclamacoesRecebidas, List<Devolucao> pedidosDevolucaoRecebidos) {
        this.reclamacoesRecebidas = reclamacoesRecebidas;
        this.pedidosDevolucaoRecebidos = pedidosDevolucaoRecebidos;
    }

    // Getters e Setters para reclamacoesRecebidas
    public List<Reclamacao> getReclamacoesRecebidas() {
        return reclamacoesRecebidas;
    }

    public void setReclamacoesRecebidas(List<Reclamacao> reclamacoesRecebidas) {
        this.reclamacoesRecebidas = reclamacoesRecebidas;
    }

    // Getters e Setters para pedidosDevolucaoRecebidos
    public List<Devolucao> getPedidosDevolucaoRecebidos() {
        return pedidosDevolucaoRecebidos;
    }

    public void setPedidosDevolucaoRecebidos(List<Devolucao> pedidosDevolucaoRecebidos) {
        this.pedidosDevolucaoRecebidos = pedidosDevolucaoRecebidos;
    }
}
