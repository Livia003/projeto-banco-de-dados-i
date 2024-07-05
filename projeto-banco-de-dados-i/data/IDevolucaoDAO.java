package data;

import java.util.ArrayList;

import model.Devolucao;

public interface IDevolucaoDAO {
    ArrayList<Devolucao> getAllDevolucaos();
    void createDevolucao (Devolucao Devolucao);
    Devolucao readDevolucao (int id);
    void updateDevolucao (Devolucao Devolucao);
    void deleteDevolucao (Devolucao Devolucao);
    Devolucao queryAccount (int id);
    Devolucao queryName(int id);
}
