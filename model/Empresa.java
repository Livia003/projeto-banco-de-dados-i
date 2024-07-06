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
    private long cnpj;

    private List<Reclamacao> reclamacoesRecebidas;
    private List<Devolucao> pedidosDevolucaoRecebidos;
    private static List<Empresa> empresas = new ArrayList<>();

    public Empresa(String nome, String email, String descricao, String data, String senha, long cnpj) {
        this.id = proximoId++;
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.data = data;
        this.senha = senha;
        this.cnpj = cnpj;
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

    public void adicionarReclamacao(Reclamacao reclamacao) {
        this.reclamacoesRecebidas.add(reclamacao);
    }

    public List<Devolucao> getPedidosDevolucaoRecebidos() {
        return pedidosDevolucaoRecebidos;
    }

    public void adicionarDevolucao(Devolucao devolucao) {
        this.pedidosDevolucaoRecebidos.add(devolucao);
    }

    public static List<Empresa> getEmpresas() {
        return empresas;
    }

    public static Empresa buscarEmpresaPorId(int id) {
        for (Empresa empresa : empresas) {
            if (empresa.getId() == id) {
                return empresa;
            }
        }
        return null;
    }

    public static Empresa buscarEmpresaPorNome(String nome) {
        for (Empresa empresa : empresas) {
            if (empresa.getNome().equals(nome)) {
                return empresa;
            }
        }
        return null;
    }

    public void responderReclamacao(int reclamacaoId, String resposta) {
        for (Reclamacao reclamacao : reclamacoesRecebidas) {
            if (reclamacao.getId() == reclamacaoId) {
                reclamacao.setResposta(resposta);
                reclamacao.setStatus(StatusReclamacao.RESPONDIDA);
                break;
            }
        }
    }

    public void atualizarReclamacao(Reclamacao reclamacaoAtualizada) {
        for (Reclamacao reclamacao : reclamacoesRecebidas) {
            if (reclamacao.getId() == reclamacaoAtualizada.getId()) {
                reclamacao.setResposta(reclamacaoAtualizada.getResposta());
                reclamacao.setStatus(reclamacaoAtualizada.getStatus());
                break;
            }
        }
    }

    public void atualizarDevolucao(Devolucao devolucaoAtualizada) {
        for (Devolucao devolucao : pedidosDevolucaoRecebidos) {
            if (devolucao.getId() == devolucaoAtualizada.getId()) {
                devolucao.setResposta(devolucaoAtualizada.getResposta());
                devolucao.setStatus(devolucaoAtualizada.getStatus());
                break;
            }
        }
    }

}
