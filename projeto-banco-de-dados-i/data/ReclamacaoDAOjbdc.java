package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Reclamacao;
import model.StatusReclamacao;

public class ReclamacaoDAOjbdc implements IReclamacaoDAO {
    
    @Override
    public ArrayList<Reclamacao> getAllReclamacaos() {
        String sqlQuery = "SELECT * FROM app.Reclamacao";
        PreparedStatement pst;
        Connection connection;
        ResultSet resultSet;
        ArrayList<Reclamacao> reclamacoes = null;
        try {
            connection = new ConnectionFactory().getConnection();
            pst = connection.prepareStatement(sqlQuery);
            resultSet = pst.executeQuery();
            if (resultSet != null) {
                reclamacoes = new ArrayList<Reclamacao>();
                while (resultSet.next()) {
                    Reclamacao reclamacao = new Reclamacao(
                        resultSet.getInt("clienteId"),
                        resultSet.getInt("empresaId"),
                        resultSet.getInt("produtoId"),
                        resultSet.getString("descricao"),
                        resultSet.getString("motivo")
                    );
                    reclamacao.setId(resultSet.getInt("id"));
                    reclamacao.setResposta(resultSet.getString("resposta"));
                    reclamacao.setStatus(StatusReclamacao.valueOf(resultSet.getString("status")));
                    reclamacoes.add(reclamacao);
                }
                resultSet.close();
                pst.close();
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return reclamacoes;
    }

    @Override
    public void createReclamacao(Reclamacao reclamacao) {
        String sqlQuery = "INSERT INTO app.Reclamacao (clienteId, empresaId, produtoId, descricao, motivo, resposta, status) VALUES (?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement pst;
        Connection connection;
        try {
            connection = new ConnectionFactory().getConnection();
            pst = connection.prepareStatement(sqlQuery);
            pst.setInt(1, reclamacao.getClienteId());
            pst.setInt(2, reclamacao.getEmpresaId());
            pst.setInt(3, reclamacao.getProdutoId());
            pst.setString(4, reclamacao.getDescricao());
            pst.setString(5, reclamacao.getMotivo());
            pst.setString(6, reclamacao.getResposta());
            pst.setString(7, reclamacao.getStatus().toString());
            pst.execute();
            pst.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Reclamacao readReclamacao(int id) {
        String sqlQuery = "SELECT * FROM app.Reclamacao WHERE id=?";
        PreparedStatement pst;
        Connection connection;
        ResultSet resultSet;
        Reclamacao reclamacao = null;
        try {
            connection = new ConnectionFactory().getConnection();
            pst = connection.prepareStatement(sqlQuery);
            pst.setInt(1, id);
            resultSet = pst.executeQuery();
            if (resultSet != null && resultSet.next()) {
                reclamacao = new Reclamacao(
                    resultSet.getInt("clienteId"),
                    resultSet.getInt("empresaId"),
                    resultSet.getInt("produtoId"),
                    resultSet.getString("descricao"),
                    resultSet.getString("motivo")
                );
                reclamacao.setId(resultSet.getInt("id"));
                reclamacao.setResposta(resultSet.getString("resposta"));
                reclamacao.setStatus(StatusReclamacao.valueOf(resultSet.getString("status")));
                resultSet.close();
                pst.close();
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return reclamacao;
    }

    @Override
    public void updateReclamacao(Reclamacao reclamacao) {
        String sqlQuery = "UPDATE app.Reclamacao SET clienteId=?, empresaId=?, produtoId=?, descricao=?, motivo=?, resposta=?, status=? WHERE id=?";
        PreparedStatement pst;
        Connection connection;
        try {
            connection = new ConnectionFactory().getConnection();
            pst = connection.prepareStatement(sqlQuery);
            pst.setInt(1, reclamacao.getClienteId());
            pst.setInt(2, reclamacao.getEmpresaId());
            pst.setInt(3, reclamacao.getProdutoId());
            pst.setString(4, reclamacao.getDescricao());
            pst.setString(5, reclamacao.getMotivo());
            pst.setString(6, reclamacao.getResposta());
            pst.setString(7, reclamacao.getStatus().toString());
            pst.setInt(8, reclamacao.getId());
            pst.execute();
            pst.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteReclamacao(Reclamacao reclamacao) {
        String sqlQuery = "DELETE FROM app.Reclamacao WHERE id=?";
        PreparedStatement pst;
        Connection connection;
        try {
            connection = new ConnectionFactory().getConnection();
            pst = connection.prepareStatement(sqlQuery);
            pst.setInt(1, id);
            pst.execute();
            pst.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Reclamacao queryAccount(int id) {
        return readReclamacao(id);
    }

    @Override
    public Reclamacao queryName(int id) {
        return readReclamacao(id);
    }
}
