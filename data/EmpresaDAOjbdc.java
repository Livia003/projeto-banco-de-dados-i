package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Empresa;

public class EmpresaDAOjbdc implements IEmpresaDAO {

  
  @Override
  public ArrayList<Empresa> getAllEmpresas() {
    // Linkar valores com a interface
    String sqlQuery = "select * from app.Empresa";
    PreparedStatement pst;
    Connection connection;
    ResultSet resultSet;
    ArrayList<Empresa> Empresas = null;
    try {
      connection = new ConnectionFactory().getConnection();
      pst = connection.prepareStatement(sqlQuery);
      resultSet = pst.executeQuery();
      if (resultSet != null) {
        Empresas = new ArrayList<Empresa>();
        while (resultSet.next()) {
          Empresa Empresa = new Empresa();
          Empresa.setDescricao(resultSet.getString("descricao"));
          Empresa.setCnpj(resultSet.getLong("cnpj"));
          Empresa.setData(resultSet.getString("data"));
          //Empresa.setId(resultSet.getId());
          Empresa.setEmail(resultSet.getString("email"));
          Empresa.setNome(resultSet.getString("nome"));
          Empresa.setSenha(resultSet.getString("senha"));
          Empresas.add(Empresa);
        }
        resultSet.close();
        pst.close();
        connection.close();
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return Empresas;
  }

  @Override
  public void createEmpresa(Empresa Empresa){
    String sqlQuery = "insert into app.Empresa (senha,email,dtNasc,telefone,nome,endereco,cnpj) values (?,?,?,?,?,?,?,?);";
    PreparedStatement pst;
    Connection connection;
    try {
      connection = new ConnectionFactory().getConnection();
      pst = connection.prepareStatement(sqlQuery);
      pst.setString(1, Empresa.getSenha());
      pst.setString(2, Empresa.getEmail());
      pst.setString(3, Empresa.getData());
      pst.setString(4, Empresa.getDescricao());
      pst.setString(5, Empresa.getNome());
      //pst.setString(6, Empresa.getEndereco());
      pst.setLong(7, Empresa.getCnpj());
      pst.execute();
      pst.close();
      connection.close();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  @Override
  public Empresa readEmpresa(Long cnpj) {
    String sqlQuery = "select * from app.Empresa where cnpj=?";
    PreparedStatement pst;
    Connection connection;
    ResultSet resultSet;
    Empresa Empresa = null;
    try {
      connection = new ConnectionFactory().getConnection();
      pst = connection.prepareStatement(sqlQuery);
      pst.setLong(1, cnpj);
      resultSet = pst.executeQuery();
      if (resultSet != null) {
        while (resultSet.next()) {
          Empresa = new Empresa();
          Empresa.setNome(resultSet.getString("nome"));
          Empresa.setCnpj(resultSet.getLong("cnpj"));
          Empresa.setEmail(resultSet.getString("email"));
          Empresa.setSenha(resultSet.getString("senha"));
          Empresa.setDescricao(resultSet.getString("telefone"));
          //Empresa.setId(resultSet.getString("endereco"));
        }
        resultSet.close();
        pst.close();
        connection.close();
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return Empresa;
  }
  @Override
  public Empresa queryAccount(Long cnpj) {
    String sqlQuery = "select * from app.Empresa where cnpj=?";
    PreparedStatement pst;
    Connection connection;
    ResultSet resultSet;
    Empresa Empresa = null;
    try {
      connection = new ConnectionFactory().getConnection();
      pst = connection.prepareStatement(sqlQuery);
      pst.setLong(1, cnpj);
      resultSet = pst.executeQuery();
      if (resultSet != null) {
        while (resultSet.next()) {
          Empresa = new Empresa();
          Empresa.setEmail(resultSet.getString("email"));
          Empresa.setSenha(resultSet.getString("senha"));
        }
        resultSet.close();
        pst.close();
        connection.close();
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return Empresa;
  }
  @Override
  public Empresa queryName(Long cnpj){
    String sqlQuery = "select * from app.Empresa where cnpj=?";
    PreparedStatement pst;
    Connection connection;
    ResultSet resultSet;
    Empresa Empresa = null;
    try {
      connection = new ConnectionFactory().getConnection();
      pst = connection.prepareStatement(sqlQuery);
      pst.setLong(1, cnpj);
      resultSet = pst.executeQuery();
      if (resultSet != null) {
        while (resultSet.next()) {
          Empresa = new Empresa();
          Empresa.setNome(resultSet.getString("nome"));
        }
        resultSet.close();
        pst.close();
        connection.close();
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return Empresa;
  }

  @Override
  public void updateEmpresa(Empresa Empresa) {
    String sqlQuery = "update app.Empresa set senha=?, email=?, telefone=?, nome=?, endereco=? where cnpj=?";
    PreparedStatement pst;
    Connection connection;
    try {
      connection = new ConnectionFactory().getConnection();
      pst = connection.prepareStatement(sqlQuery);
      pst.setString(2, Empresa.getSenha());
      pst.setString(3, Empresa.getEmail());
      //pst.setString(5, Empresa.getCnpj());
      pst.setString(6, Empresa.getNome());
      pst.setString(8, Empresa.getDescricao());
      pst.execute();
      pst.close();
      connection.close();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  @Override
  public void deleteEmpresa(Empresa Empresa) {
    String sqlQuery = "delete from app.Empresa where cnpj=?";
    PreparedStatement pst;
    Connection connection;
    try {
      connection = new ConnectionFactory().getConnection();
      pst = connection.prepareStatement(sqlQuery);
      //pst.setString(1, Empresa.getCnpj());
      pst.execute();
      pst.close();
      connection.close();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }  
}