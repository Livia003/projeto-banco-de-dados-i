package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {

    private List<Reclamacao> reclamacoes;
    private int id;
    private static int proximoId = 0;

    public Cliente(String nome, String email, String senha) {
        super(nome, email, senha);
        this.id = proximoId++;
        this.reclamacoes = new ArrayList<>();
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

}
