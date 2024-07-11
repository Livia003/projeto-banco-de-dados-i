package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Empresa {

    private static int proximoId;
    private int id;
    private String nome;
    private String email;
    private String descricao;

    private Date dt_nascimento;

    private String senha;
    private long cnpj;
    private static List<Empresa> empresas = new ArrayList<>();

    public Empresa(String nome, String email, String descricao, Date dt_nascimento, String senha, long cnpj) {
   
        Random random = new Random();
        int proximoId = random.nextInt(50);
        this.id = proximoId++;
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.senha = senha;
        this.cnpj = cnpj;
        empresas.add(this);
    }

    public Empresa() {
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

    public Date getdt_nascimento() {
        return dt_nascimento;
    }

    public void setdt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getSenha() {
        return senha;
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public static Empresa buscarEmpresaPorId(int id) {
        for (Empresa empresa : empresas) {
            if (empresa.getId() == id) {
                return empresa;
            }
        }
        return null;
    }

/*     public static Empresa buscarEmpresaPorNome(String nome) {
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
    }*/

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    public long getCnpj() {
        return cnpj;
    }



}
