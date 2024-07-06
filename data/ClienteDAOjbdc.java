package data;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Cliente;

public class ClienteDAOjbdc implements IClienteDAO{

  @Override
  public ArrayList<Cliente> getAllClientes() {
    // Linkar valores com a interface
    String sqlQuery = "select * from FaleFeedback.cliente";
    PreparedStatement pst;
    Connection connection;
    ResultSet resultSet;
    ArrayList<Cliente> clientes = null;
    try {
      connection = new ConnectionFactory().getConnection();
      pst = connection.prepareStatement(sqlQuery);
      resultSet = pst.executeQuery();
      if (resultSet != null) {
        clientes = new ArrayList<Cliente>();
        while (resultSet.next()) {
          Cliente cliente = new Cliente();
          cliente.setTelefone(resultSet.getLong("telefone"));
          cliente.setCpf(resultSet.getLong("cpf"));
          cliente.setDataNascimento(resultSet.getDate("dtNasc"));
          cliente.setEndereco(resultSet.getString("endereco"));
          cliente.setEmail(resultSet.getString("email"));
          cliente.setNome(resultSet.getString("nome"));
          cliente.setSenha(resultSet.getString("senha"));
          clientes.add(cliente);
        }
        resultSet.close();
        pst.close();
        connection.close();
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return clientes;
  }

  @Override
  public void createCliente(Cliente cliente){
    String sqlQuery = "insert into FaleFeedback.cliente (senha,email,dtNasc,telefone,nome,endereco,cpf) values (?,?,?,?,?,?,?,?);";
    PreparedStatement pst;
    Connection connection;
    try {
      connection = new ConnectionFactory().getConnection();
      pst = connection.prepareStatement(sqlQuery);
      pst.setString(1, cliente.getSenha());
      pst.setString(2, cliente.getEmail());
      pst.setDate(3, (Date) cliente.getDataNascimento());
      pst.setLong(4, cliente.getTelefone());
      pst.setString(5, cliente.getNome());
      pst.setString(6, cliente.getEndereco());
      pst.setLong(7, cliente.getCpf());
      pst.execute();
      pst.close();
      connection.close();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  @Override
  public Cliente readCliente(Long cpf) {
    String sqlQuery = "select * from FaleFeedback.cliente where cpf=?";
    PreparedStatement pst;
    Connection connection;
    ResultSet resultSet;
    Cliente cliente = null;
    try {
      connection = new ConnectionFactory().getConnection();
      pst = connection.prepareStatement(sqlQuery);
      pst.setLong(1, cpf);
      resultSet = pst.executeQuery();
      if (resultSet != null) {
        while (resultSet.next()) {
          cliente = new Cliente();
          cliente.setNome(resultSet.getString("nome"));
          cliente.setCpf(resultSet.getLong("cpf"));
          cliente.setEmail(resultSet.getString("email"));
          cliente.setSenha(resultSet.getString("senha"));
          cliente.setTelefone(resultSet.getLong("telefone"));
          cliente.setEndereco(resultSet.getString("endereco"));
          cliente.setDataNascimento(resultSet.getDate("dtNasc"));
        }
        resultSet.close();
        pst.close();
        connection.close();
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return cliente;
  }
  @Override
  public Cliente queryAccount(Long cpf) {
    String sqlQuery = "select * from FaleFeedback.cliente where cpf=?";
    PreparedStatement pst;
    Connection connection;
    ResultSet resultSet;
    Cliente cliente = null;
    try {
      connection = new ConnectionFactory().getConnection();
      pst = connection.prepareStatement(sqlQuery);
      pst.setLong(1, cpf);
      resultSet = pst.executeQuery();
      if (resultSet != null) {
        while (resultSet.next()) {
          cliente = new Cliente();
          cliente.setEmail(resultSet.getString("email"));
          cliente.setSenha(resultSet.getString("senha"));
        }
        resultSet.close();
        pst.close();
        connection.close();
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return cliente;
  }
  @Override
  public Cliente queryName(Long cpf){
    String sqlQuery = "select * from FaleFeedback.cliente where cpf=?";
    PreparedStatement pst;
    Connection connection;
    ResultSet resultSet;
    Cliente cliente = null;
    try {
      connection = new ConnectionFactory().getConnection();
      pst = connection.prepareStatement(sqlQuery);
      pst.setLong(1, cpf);
      resultSet = pst.executeQuery();
      if (resultSet != null) {
        while (resultSet.next()) {
          cliente = new Cliente();
          cliente.setNome(resultSet.getString("nome"));
        }
        resultSet.close();
        pst.close();
        connection.close();
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return cliente;
  }

  @Override
  public void updateCliente(Cliente cliente) {
    String sqlQuery = "update FaleFeedback.cliente set senha=?, email=?, telefone=?, nome=?, endereco=? where cpf=?";
    PreparedStatement pst;
    Connection connection;
    try {
      connection = new ConnectionFactory().getConnection();
      pst = connection.prepareStatement(sqlQuery);
      pst.setString(1, cliente.getSenha());
      pst.setString(2, cliente.getEmail());
      pst.setDate(3, (Date) cliente.getDataNascimento());
      pst.setLong(4, cliente.getTelefone());
      pst.setString(5, cliente.getNome());
      pst.setString(6, cliente.getEndereco());
      pst.setLong(7, cliente.getCpf());
      pst.execute();
      pst.close();
      connection.close();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  @Override
  public void deleteCliente(Cliente cliente) {
    String sqlQuery = "delete from FaleFeedback.cliente where cpf=?";
    PreparedStatement pst;
    Connection connection;
    try {
      connection = new ConnectionFactory().getConnection();
      pst = connection.prepareStatement(sqlQuery);
      pst.setLong(1, cliente.getCpf());
      pst.execute();
      pst.close();
      connection.close();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
}
   

