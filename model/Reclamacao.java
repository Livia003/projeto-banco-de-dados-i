package model;

public class Reclamacao {

    private static int proximoId = 1;
    private int id;
    private int clienteId;
    private int empresaId;
    private int produtoId;
    private String descricao;
    private String motivo;
    private String resposta;
    private StatusReclamacao status;

    // Construtor
    public Reclamacao(int clienteId, int empresaId, int produtoId, String descricao, String motivo) {
        this.id = proximoId++;
        this.clienteId = clienteId;
        this.empresaId = empresaId;
        this.produtoId = produtoId;
        this.descricao = descricao;
        this.motivo = motivo;
        this.status = StatusReclamacao.NAO_RESPONDIDA;
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

    public StatusReclamacao getStatus() {
        return status;
    }

    public void setStatus(StatusReclamacao status) {
        this.status = status;
    }

    public static int getProximoId() {
        return proximoId;
    }

    public static void setProximoId(int proximoId) {
        Reclamacao.proximoId = proximoId;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

}
