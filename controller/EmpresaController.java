package controller;

import java.util.ArrayList;
import java.util.List;

import model.Empresa;

public class EmpresaController {

    private List<Empresa> empresas;

    // public void cadastrarNovaEmpresa(Empresa empresa) {
    // Empresa.getEmpresas().add(empresa);
    // }

    public EmpresaController() {
        empresas = new ArrayList<>();
    }

    public void cadastrarNovaEmpresa(Empresa empresa) {
        if (!empresas.contains(empresa)) {
            empresas.add(empresa);
        }
    }
/* 
    public List<Empresa> getEmpresas() {
        return Empresa.getEmpresas();
    }

    public List<String> getNomesEmpresas() {
        List<String> nomes = new ArrayList<>();
        for (Empresa empresa : Empresa.getEmpresas()) {
            nomes.add(empresa.getNome());
        }
        return nomes;
    }

    public static Empresa buscarEmpresaPorId(int id) {
        List<Empresa> empresas = Empresa.getEmpresas();
        for (Empresa empresa : empresas) {
            if (empresa.getId() == id) {
                return empresa;
            }
        }
        return null;
    }

    public Empresa buscarEmpresaPorNome(String nome) {
        return Empresa.buscarEmpresaPorNome(nome);
    }

    public Empresa buscarEmpresaPorEmailESenha(String email, String senha) {
        for (Empresa empresa : Empresa.getEmpresas()) {
            if (empresa.getEmail().equals(email) && empresa.getSenha().equals(senha)) {
                return empresa;
            }
        }
        return null;
    }*/

}
