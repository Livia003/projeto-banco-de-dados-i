package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Empresa;

public class EmpresaDAOjbdc implements IEmpresaDAO {

  
  private void carregarReclamacoes(Empresa empresa) {
    String sqlQuery = "SELECT * FROM app.Reclamacao WHERE empresaId=?";
    PreparedStatement pst;
    Connection connection;
    ResultSet resultSet;
    try {
        connection = new ConnectionFactory().getConnection();
        pst = connection.prepareStatement(sqlQuery);
        pst.setInt(1, empresa.getId());
        resultSet = pst.executeQuery();
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
            empresa.adicionarReclamacao(reclamacao);
        }
        resultSet.close();
        pst.close();
        connection.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}

@Override
public ArrayList<Empresa> getAllEmpresas() {
    String sqlQuery = "SELECT * FROM app.Empresa";
    PreparedStatement pst;
    Connection connection;
    ResultSet resultSet;
    ArrayList<Empresa> empresas = null;
    try {
        connection = new ConnectionFactory().getConnection();
        pst = connection.prepareStatement(sqlQuery);
        resultSet = pst.executeQuery();
        if (resultSet != null) {
            empresas = new ArrayList<Empresa>();
            while (resultSet.next()) {
                Empresa empresa = new Empresa(
                    resultSet.getString("nome"),
                    resultSet.getString("email"),
                    resultSet.getString("descricao"),
                    resultSet.getString("data"),
                    resultSet.getString("senha"),
                    resultSet.getLong("cnpj")
                );
                empresa.setId(resultSet.getInt("id"));
                carregarReclamacoes(empresa);
                empresas.add(empresa);
            }
            resultSet.close();
            pst.close();
            connection.close();
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return empresas;
}

@Override
public void createEmpresa(Empresa empresa) {
    String sqlQuery = "INSERT INTO app.Empresa (nome, email, descricao, data, senha, cnpj) VALUES (?, ?, ?, ?, ?, ?)";
    PreparedStatement pst;
    Connection connection;
    try {
        connection = new ConnectionFactory().getConnection();
        pst = connection.prepareStatement(sqlQuery);
        pst.setString(1, empresa.getNome());
        pst.setString(2, empresa.getEmail());
        pst.setString(3, empresa.getDescricao());
        pst.setString(4, empresa.getData());
        pst.setString(5, empresa.getSenha());
        pst.setLong(6, empresa.getCnpj());
        pst.execute();
        pst.close();
        connection.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}

@Override
public Empresa readEmpresa(Long cnpj) {
    String sqlQuery = "SELECT * FROM app.Empresa WHERE cnpj=?";
    PreparedStatement pst;
    Connection connection;
    ResultSet resultSet;
    Empresa empresa = null;
    try {
        connection = new ConnectionFactory().getConnection();
        pst = connection.prepareStatement(sqlQuery);
        pst.setLong(1, cnpj);
        resultSet = pst.executeQuery();
        if (resultSet != null && resultSet.next()) {
            empresa = new Empresa(
                resultSet.getString("nome"),
                resultSet.getString("email"),
                resultSet.getString("descricao"),
                resultSet.getString("data"),
                resultSet.getString("senha"),
                resultSet.getLong("cnpj")
            );
            empresa.setId(resultSet.getInt("id"));
            carregarReclamacoes(empresa);
            resultSet.close();
            pst.close();
            connection.close();
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return empresa;
}

@Override
public Empresa queryAccount(Long cnpj) {
    return readEmpresa(cnpj);
}

@Override
public Empresa queryName(Long cnpj) {
    return readEmpresa(cnpj);
}

@Override
public void updateEmpresa(Empresa empresa) {
    String sqlQuery = "UPDATE app.Empresa SET nome=?, email=?, descricao=?, data=?, senha=? WHERE cnpj=?";
    PreparedStatement pst;
    Connection connection;
    try {
        connection = new ConnectionFactory().getConnection();
        pst = connection.prepareStatement(sqlQuery);
        pst.setString(1, empresa.getNome());
        pst.setString(2, empresa.getEmail());
        pst.setString(3, empresa.getDescricao());
        pst.setString(4, empresa.getData());
        pst.setString(5, empresa.getSenha());
        pst.setLong(6, empresa.getCnpj());
        pst.execute();
        pst.close();
        connection.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}

@Override
public void deleteEmpresa(Empresa empresa) {
    String sqlQuery = "DELETE FROM app.Empresa WHERE cnpj=?";
    PreparedStatement pst;
    Connection connection;
    try {
        connection = new ConnectionFactory().getConnection();
        pst = connection.prepareStatement(sqlQuery);
        pst.setLong(1, empresa.getCnpj());
        pst.execute();
        pst.close();
        connection.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
}