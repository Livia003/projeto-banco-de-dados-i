package data;
import java.util.ArrayList;
import model.Empresa;

public interface IEmpresaDAO {
    ArrayList<Empresa> getAllEmpresas();
    void createEmpresa (Empresa empresa);
    Empresa readEmpresa (String e_mail);
    void updateEmpresa (Empresa empresa);
    void deleteEmpresa (Empresa empresa);
    Empresa queryAccount (Long cnpj);
    Empresa queryName(String nome);
}
