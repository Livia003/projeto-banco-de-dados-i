package controller;

import java.util.ArrayList;
import java.util.List;

import model.Empresa;

public class EmpresaController {

    private List<Empresa> empresas = new ArrayList<>();

    public void cadastrarNovaEmpresa(Empresa empresa) {
        empresas.add(empresa);
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public List<String> getNomesEmpresas() {
        List<String> nomes = new ArrayList<>();
        for (Empresa empresa : empresas) {
            nomes.add(empresa.getNome());
        }
        return nomes;
    }

}
