package data;

import java.util.ArrayList;

import model.Reclamacao;

public interface IReclamacaoDAO {
     ArrayList<Reclamacao> getAllReclamacaos();
    void createReclamacao (Reclamacao Reclamacao);
    Reclamacao readReclamacao (int id);
    void updateReclamacao (Reclamacao Reclamacao);
    void deleteReclamacao (Reclamacao Reclamacao);
    Reclamacao queryAccount (int id);
    Reclamacao queryName(int id);
}
