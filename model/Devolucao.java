package model;

public class Devolucao {
    private int id;
    private int clienteId;
    private int empresaId;
    private int produtoId;
    private String descricao;
    private String resposta;
    private StatusDevolucao status;
    private String motivo;
    private String justicativa;
    private String nomeCliente;
    private String emailCliente;
    private int quantidade;
    private String dataCompra;
    private int idSubstituicao;
    private static int proximoId = 1;

    // Construtor
    public Devolucao(int clienteId, int empresaId, int produtoId, String descricao,
            String motivo, int quantidade, int idSubstituicao, String justificativa, String dataCompra) {
        this.id = produtoId++;
        this.clienteId = clienteId;
        this.empresaId = empresaId;
        this.produtoId = produtoId;
        this.descricao = descricao;
        this.motivo = motivo;
        this.dataCompra = dataCompra;
        this.justicativa = justificativa;
        this.quantidade = quantidade;
        this.idSubstituicao = idSubstituicao;
        this.status = StatusDevolucao.EM_ANALISE;

    }

    public Devolucao() {
        //TODO Auto-generated constructor stub
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public String getJustificativa() {
        return justicativa;
    }

    public void setJustificativa(String justicativa) {
        this.justicativa = justicativa;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
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

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
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

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public int getIdSubstituicao() {
        return idSubstituicao;
    }

    public void setIdSubstituicao(int idSubstituicao) {
        this.idSubstituicao = idSubstituicao;
    }

    public static int getProximoId() {
        return proximoId;
    }

    public static void setProximoId(int proximoId) {
        Devolucao.proximoId = proximoId;
    }

}
