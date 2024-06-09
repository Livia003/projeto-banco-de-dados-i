package model;

public class Devolucao {
    private int id;
    private int clienteId;
    private int empresaId;
    private int produtoId;
    private String descricao;
    private String resposta;
    private StatusDevolucao status;

    // Construtor
    public Devolucao(int id, int clienteId, int empresaId, int produtoId, String descricao, String resposta,
            StatusDevolucao status) {
        this.id = id;
        this.clienteId = clienteId;
        this.empresaId = empresaId;
        this.produtoId = produtoId;
        this.descricao = descricao;
        this.resposta = resposta;
        this.status = status;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getResposta() {
        return resposta;
    }

    public StatusDevolucao getStatus() {
        return status;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public void setStatus(StatusDevolucao status) {
        this.status = status;
    }
}
