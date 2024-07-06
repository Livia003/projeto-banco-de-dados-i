package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Devolucao;
import model.Reclamacao;
import model.StatusDevolucao;

public class DevolucaoDAOjbdc implements IDevolucaoDAO {
@Override
    public ArrayList<Devolucao> getAllDevolucaos() {
        String sqlQuery = "select * from app.Devolucao";
        PreparedStatement pst;
        Connection connection;
        ResultSet resultSet;
        ArrayList<Devolucao> devolucaos = null;
        try {
            connection = new ConnectionFactory().getConnection();
            pst = connection.prepareStatement(sqlQuery);
            resultSet = pst.executeQuery();
            if (resultSet != null) {
                devolucaos = new ArrayList<Devolucao>();
                while (resultSet.next()) {
                    Devolucao devolucao = new Devolucao();
                        resultSet.getInt("clienteId");
                        resultSet.getInt("empresaId");
                        resultSet.getInt("produtoId");
                        resultSet.getString("descricao");
                        resultSet.getString("motivo");
                        resultSet.getInt("quantidade");
                        resultSet.getInt("idSubstituicao");
                    devolucao.setId(resultSet.getInt("id"));
                    devolucao.setStatus(StatusDevolucao.valueOf(resultSet.getString("status")));
                    devolucaos.add(devolucao);
                }
                resultSet.close();
                pst.close();
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return devolucaos;
    }

    @Override
    public void createDevolucao(Devolucao devolucao) {
        String sqlQuery = "insert into app.Devolucao (clienteId, empresaId, produtoId, descricao, motivo, quantidade, idSubstituicao, status) values (?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement pst;
        Connection connection;
        try {
            connection = new ConnectionFactory().getConnection();
            pst = connection.prepareStatement(sqlQuery);
            pst.setInt(1, devolucao.getClienteId());
            pst.setInt(2, devolucao.getEmpresaId());
            pst.setInt(3, devolucao.getProdutoId());
            pst.setString(4, devolucao.getDescricao());
            pst.setString(5, devolucao.getMotivo());
            //pst.setInt(6, devolucao.getQuantidade());
           // pst.setInt(7, devolucao.getIdSubstituicao());
            pst.setString(8, devolucao.getStatus().toString());
            pst.execute();
            pst.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Devolucao readDevolucao(int id) {
        String sqlQuery = "select * from app.Devolucao where id=?";
        PreparedStatement pst;
        Connection connection;
        ResultSet resultSet;
        Devolucao devolucao = null;
        try {
            connection = new ConnectionFactory().getConnection();
            pst = connection.prepareStatement(sqlQuery);
            pst.setInt(1, id);
            resultSet = pst.executeQuery();
            if (resultSet != null && resultSet.next()) {
                devolucao = new Devolucao();
                    resultSet.getInt("clienteId");
                    resultSet.getInt("empresaId");
                    resultSet.getInt("produtoId");
                    resultSet.getString("descricao");
                    resultSet.getString("motivo");
                    resultSet.getInt("quantidade");
                    resultSet.getInt("idSubstituicao");
                devolucao.setId(resultSet.getInt("id"));
                devolucao.setStatus(StatusDevolucao.valueOf(resultSet.getString("status")));
                resultSet.close();
                pst.close();
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return devolucao;
    }

    @Override
    public void updateDevolucao(Devolucao devolucao) {
        String sqlQuery = "update app.Devolucao set clienteId=?, empresaId=?, produtoId=?, descricao=?, motivo=?, quantidade=?, idSubstituicao=?, status=? where id=?";
        PreparedStatement pst;
        Connection connection;
        try {
            connection = new ConnectionFactory().getConnection();
            pst = connection.prepareStatement(sqlQuery);
            pst.setInt(1, devolucao.getClienteId());
            pst.setInt(2, devolucao.getEmpresaId());
            pst.setInt(3, devolucao.getProdutoId());
            pst.setString(4, devolucao.getDescricao());
            pst.setString(5, devolucao.getMotivo());
            //pst.setInt(6, devolucao.getQuantidade());
            //pst.setInt(7, devolucao.getIdSubstituicao());
            pst.setString(8, devolucao.getStatus().toString());
            pst.setInt(9, devolucao.getId());
            pst.execute();
            pst.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteDevolucao(Devolucao Devolucao) {
        String sqlQuery = "delete from app.Devolucao where id=?";
        PreparedStatement pst;
        Connection connection;
        try {
            connection = new ConnectionFactory().getConnection();
            pst = connection.prepareStatement(sqlQuery);
            //pst.setInt(1, id);
            pst.execute();
            pst.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        @Override
    public Devolucao queryAccount(int id) {
        return readDevolucao(id);
    }

    @Override
    public Devolucao queryName(int id) {
        return readDevolucao(id);
    }
  }

