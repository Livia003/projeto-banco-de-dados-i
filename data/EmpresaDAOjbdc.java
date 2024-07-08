package data;

import java.security.spec.ECFieldFp;
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
          Empresa.setdt_nascimento(resultSet.getDate("dt_nascimento"));
          //Empresa.setId(resultSet.getId());
          Empresa.setEmail(resultSet.getString("e_email"));
          Empresa.setNome(resultSet.getString("nome"));
          Empresa.setSenha(resultSet.getString("e_senha"));
          Empresas.add(Empresa);
          //Empresa.adicionarDevolucao(resultSet.getArray("pedidosdevolucao"));
          //Empresa.setReclamacoes(resultSet.getInt("reclamacoesrecebidas"));
          //Array reclamacoesArray = resultSet.getArray("reclamacoesrecebidas");
          //if (reclamacoesArray != null) {
          // String[] reclamacoes = (String[]) reclamacoesArray.getArray();
          //empresa.setReclamacoes(reclamacoes); // Supondo que o método setReclamacoes aceite um array de Strings
  //}
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
    String sqlQuery = "insert into app.Empresa (e_senha,e_email,dt_nascimento,descricao,nome,cnpj) values (?,?,?,?,?,?);";
    PreparedStatement pst;
    Connection connection;
    try {
      connection = new ConnectionFactory().getConnection();
      pst = connection.prepareStatement(sqlQuery);
      pst.setString(1, Empresa.getSenha());
      pst.setString(2, Empresa.getEmail());
      pst.setDate(3, (Date) Empresa.getdt_nascimento());
      pst.setString(4, Empresa.getDescricao());
      pst.setString(5, Empresa.getNome());
      //pst.setString(6, Empresa.getEndereco());
      pst.setLong(6, Empresa.getCnpj());
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
    String sqlQuery = "update app.Empresa set senha=?, email=?, descricao=?, nome=?, dt_nascimento =? where cnpj=?";
    PreparedStatement pst;
    Connection connection;
    try {
      connection = new ConnectionFactory().getConnection();
      pst = connection.prepareStatement(sqlQuery);
      pst.setString(1, Empresa.getSenha());
      pst.setString(2, Empresa.getEmail());
      pst.setDate(3, (Date) Empresa.getdt_nascimento());
      pst.setString(4, Empresa.getDescricao());
      pst.setString(5, Empresa.getNome());
      //pst.setString(6, Empresa.getEndereco());
      pst.setLong(6, Empresa.getCnpj());
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