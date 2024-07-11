package data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Empresa;

public class EmpresaDAOjbdc implements IEmpresaDAO {

  
  @Override
  public ArrayList<Empresa> getAllEmpresas() {
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
          Empresa.setdt_nascimento(resultSet.getDate("dt_nascimento"));
          Empresa.setEmail(resultSet.getString("e_email"));
          Empresa.setNome(resultSet.getString("nome"));
          Empresa.setSenha(resultSet.getString("e_senha"));          
          Empresa.setId(resultSet.getInt("empresa_id"));
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
  public void createEmpresa(Empresa empresa) {
      String sqlQuery = "insert into app.Empresa (e_senha, e_email, dt_nascimento, descricao, nome, cnpj, empresa_id) values (?,?,?,?,?,?,?)";
      PreparedStatement pst;
      Connection connection;
      try {
          connection = new ConnectionFactory().getConnection();
          pst = connection.prepareStatement(sqlQuery, PreparedStatement.RETURN_GENERATED_KEYS);
          pst.setString(1, empresa.getSenha());
          pst.setString(2, empresa.getEmail());
          pst.setDate(3, (Date) empresa.getdt_nascimento());
          pst.setString(4, empresa.getDescricao());
          pst.setString(5, empresa.getNome());
          pst.setLong(6, empresa.getCnpj());      
          pst.setInt(7, empresa.getId());
          pst.execute();
          pst.close();
          connection.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
      }
  
  @Override
  public Empresa readEmpresa(String e_email) {
    String sqlQuery = "select * from app.Empresa where e_email=?";
    PreparedStatement pst;
    Connection connection;
    ResultSet resultSet;
    Empresa Empresa = null;
    try {
      connection = new ConnectionFactory().getConnection();
      pst = connection.prepareStatement(sqlQuery);
      pst.setString(1, e_email);
      resultSet = pst.executeQuery();
      if (resultSet != null) {
        while (resultSet.next()) {
          Empresa = new Empresa();
          Empresa.setNome(resultSet.getString("nome"));
          Empresa.setCnpj(resultSet.getLong("cnpj"));
          Empresa.setEmail(resultSet.getString("e_email"));
          Empresa.setSenha(resultSet.getString("e_senha"));
          Empresa.setDescricao(resultSet.getString("descricao"));
          Empresa.setId(resultSet.getInt("empresa_id"));
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
  public Empresa queryName(String nome){
    String sqlQuery = "select * from app.Empresa where nome=?";
    PreparedStatement pst;
    Connection connection;
    ResultSet resultSet;
    Empresa Empresa = null;
    try {
      connection = new ConnectionFactory().getConnection();
      pst = connection.prepareStatement(sqlQuery);
      pst.setString(1, nome);
      resultSet = pst.executeQuery();
      if (resultSet != null) {
        while (resultSet.next()) {
          Empresa = new Empresa();
          Empresa.setNome(resultSet.getString("nome"));
          Empresa.setId(resultSet.getInt("empresa_id"));
          Empresa.setEmail(resultSet.getString("e_email"));
          Empresa.setCnpj(resultSet.getLong("cnpj"));
          Empresa.setdt_nascimento(resultSet.getDate("dt_nascimento"));
          Empresa.setDescricao(resultSet.getString("descricao"));
          Empresa.setSenha(resultSet.getString("e_senha"));
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
  public void updateEmpresa(Empresa empresa) {
      String sqlQuery = "UPDATE app.Empresa SET e_senha = ?, e_email = ?, descricao = ?, empresa_id = ?, dt_nascimento = ? WHERE nome = ?";
      PreparedStatement pst;
      Connection connection;
      try {
          connection = new ConnectionFactory().getConnection();
          pst = connection.prepareStatement(sqlQuery);
          pst.setString(1, empresa.getSenha());
          pst.setString(2, empresa.getEmail());
          pst.setString(3, empresa.getDescricao());
          pst.setInt(4, empresa.getId());
          pst.setDate(6, new Date(empresa.getdt_nascimento().getTime()));
          pst.setString(7, empresa.getNome());
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
      pst.setLong(1, Empresa.getCnpj());
      pst.execute();
      pst.close();
      connection.close();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }  
}