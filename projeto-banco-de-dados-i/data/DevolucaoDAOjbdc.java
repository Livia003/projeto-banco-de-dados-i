package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Devolucao;

public class DevolucaoDAOjbdc implements IDevolucaoDAO {

  @Override
  public ArrayList<Devolucao> getAllDevolucaos() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAllDevolucaos'");
  }

  @Override
  public void createDevolucao(Devolucao Devolucao) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'createDevolucao'");
  }

  @Override
  public Devolucao readDevolucao(int id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'readDevolucao'");
  }

  @Override
  public void updateDevolucao(Devolucao Devolucao) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'updateDevolucao'");
  }

  @Override
  public void deleteDevolucao(Devolucao Devolucao) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteDevolucao'");
  }

  @Override
  public Devolucao queryAccount(int id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'queryAccount'");
  }

  @Override
  public Devolucao queryName(int id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'queryName'");
  }
    
 /* 
  @Override
  public ArrayList<Devolucao> getAllDevolucaos() {
    // Linkar valores com a interface
    String sqlQuery = "select * from app.Devolucao";
    PreparedStatement pst;
    Connection connection;
    ResultSet resultSet;
    ArrayList<Devolucao> Devolucaos = null;
    try {
      connection = new ConnectionFactory().getConnection();
      pst = connection.prepareStatement(sqlQuery);
      resultSet = pst.executeQuery();
      if (resultSet != null) {
        Devolucaos = new ArrayList<Devolucao>();
        while (resultSet.next()) {
          Devolucao Devolucao = new Devolucao();
          Devolucao.setDescricao(resultSet.getString("descricao"));
          //Devolucao.setCnpj(resultSet.getString("cnpj"));
        }
        resultSet.close();
        pst.close();
        connection.close();
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return Devolucaos;
  }

  @Override
  public void createDevolucao(Devolucao Devolucao){
    String sqlQuery = "insert into app.Devolucao (senha,email,dtNasc,telefone,nome,endereco,cpf,tipoPasse) values (?,?,?,?,?,?,?,?);";
    PreparedStatement pst;
    Connection connection;
    try {
      connection = new ConnectionFactory().getConnection();
      pst = connection.prepareStatement(sqlQuery);
      pst.setString(4, Devolucao.getDescricao());
      pst.execute();
      pst.close();
      connection.close();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  @Override
  public Devolucao readDevolucao(String descricao) {
    String sqlQuery = "select * from app.Devolucao where cpf=?";
    PreparedStatement pst;
    Connection connection;
    ResultSet resultSet;
    Devolucao Devolucao = null;
    try {
      connection = new ConnectionFactory().getConnection();
      pst = connection.prepareStatement(sqlQuery);
      pst.setString(1, cpf);
      resultSet = pst.executeQuery();
      if (resultSet != null) {
        while (resultSet.next()) {
          Devolucao = new Devolucao();
        }
        resultSet.close();
        pst.close();
        connection.close();
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return Devolucao;
  }
  @Override
  public Devolucao queryAccount(int devolucao) {
    String sqlQuery = "select * from app.Devolucao where cpf=?";
    PreparedStatement pst;
    Connection connection;
    ResultSet resultSet;
    Devolucao Devolucao = null;
    try {
      connection = new ConnectionFactory().getConnection();
      pst = connection.prepareStatement(sqlQuery);
      pst.setString(1, cpf);
      resultSet = pst.executeQuery();
      if (resultSet != null) {
        while (resultSet.next()) {
          Devolucao = new Devolucao();
          Devolucao.setEmail(resultSet.getString("email"));
          Devolucao.setSenha(resultSet.getString("senha"));
        }
        resultSet.close();
        pst.close();
        connection.close();
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return Devolucao;
  }
  @Override
  public Devolucao queryName(int id){
    String sqlQuery = "select * from app.Devolucao where cpf=?";
    PreparedStatement pst;
    Connection connection;
    ResultSet resultSet;
    Devolucao Devolucao = null;
    try {
      connection = new ConnectionFactory().getConnection();
      pst = connection.prepareStatement(sqlQuery);
      pst.setString(1, cpf);
      resultSet = pst.executeQuery();
      if (resultSet != null) {
        while (resultSet.next()) {
          Devolucao = new Devolucao();
        }
        resultSet.close();
        pst.close();
        connection.close();
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return Devolucao;
  }

  @Override
  public void updateDevolucao(Devolucao Devolucao) {
    String sqlQuery = "update app.Devolucao set senha=?, email=?, telefone=?, nome=?, endereco=? where cpf=?";
    PreparedStatement pst;
    Connection connection;
    try {
      connection = new ConnectionFactory().getConnection();
      pst = connection.prepareStatement(sqlQuery);
      pst.setString(8, Devolucao.getDescricao());
      pst.execute();
      pst.close();
      connection.close();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  @Override
  public void deleteDevolucao(Devolucao Devolucao) {
    String sqlQuery = "delete from app.Devolucao where cpf=?";
    PreparedStatement pst;
    Connection connection;
    try {
      connection = new ConnectionFactory().getConnection();
      pst = connection.prepareStatement(sqlQuery);
      //pst.setString(1, Devolucao.getCnpj());
      pst.execute();
      pst.close();
      connection.close();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }*/
}
