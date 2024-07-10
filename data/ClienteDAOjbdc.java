package data;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Cliente;
import model.Empresa;

public class ClienteDAOjbdc implements IClienteDAO{

  @Override
  public ArrayList<Cliente> getAllClientes() {
    // Linkar valores com a interface
    String sqlQuery = "select * from app.cliente";
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
          cliente.setDataNascimento(resultSet.getDate("dt_nascimento"));
          cliente.setEndereco(resultSet.getString("endereco"));
          cliente.setEmail(resultSet.getString("c_email"));
          cliente.setNome(resultSet.getString("nome"));
          cliente.setSenha(resultSet.getString("c_senha"));
          cliente.setRec_id(resultSet.getInt("reclamacoesrecebidas"));
          //cliente.setReclamacoes(resultSet.getInt("reclamacoes"));
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
    String sqlQuery = "insert into app.cliente (c_senha,c_email,dt_nascimento,telefone,nome,endereco,cpf, cliente_id) values (?,?,?,?,?,?,?,?);";
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
      pst.setInt(8, cliente.getId());
      pst.execute();
      pst.close();
      connection.close();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  @Override
  public Cliente readCliente(String c_email) {
    String sqlQuery = "select * from app.cliente where c_email=?";
    PreparedStatement pst;
    Connection connection;
    ResultSet resultSet;
    Cliente cliente = null;
    try {
      connection = new ConnectionFactory().getConnection();
      pst = connection.prepareStatement(sqlQuery);
      pst.setString(1, c_email);
      resultSet = pst.executeQuery();
      if (resultSet != null) {
        while (resultSet.next()) {
          cliente = new Cliente();
          cliente.setNome(resultSet.getString("nome"));
          cliente.setCpf(resultSet.getLong("cpf"));
          cliente.setEmail(resultSet.getString("c_email"));
          cliente.setSenha(resultSet.getString("c_senha"));
          cliente.setTelefone(resultSet.getLong("telefone"));
          cliente.setEndereco(resultSet.getString("endereco"));
          cliente.setDataNascimento(resultSet.getDate("dt_nascimento"));
          cliente.setId(resultSet.getInt("cliente_id"));
          cliente.setRec_id(resultSet.getInt("reclamacoesrecebidas"));
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
  public Cliente queryAccount(int cliente_id) {
    String sqlQuery = "select * from app.cliente where cliente_id=?";
    PreparedStatement pst;
    Connection connection;
    ResultSet resultSet;
    Cliente cliente = null;
    try {
      connection = new ConnectionFactory().getConnection();
      pst = connection.prepareStatement(sqlQuery);
      pst.setInt(1, cliente_id);
      resultSet = pst.executeQuery();
      if (resultSet != null) {
        while (resultSet.next()) {
          cliente = new Cliente();
          cliente.setNome(resultSet.getString("nome"));
          cliente.setCpf(resultSet.getLong("cpf"));
          cliente.setEmail(resultSet.getString("c_email"));
          cliente.setSenha(resultSet.getString("c_senha"));
          cliente.setTelefone(resultSet.getLong("telefone"));
          cliente.setEndereco(resultSet.getString("endereco"));
          cliente.setDataNascimento(resultSet.getDate("dt_nascimento"));
          cliente.setId(resultSet.getInt("cliente_id"));
          cliente.setRec_id(resultSet.getInt("reclamacoesrecebidas"));
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
    String sqlQuery = "select * from app.cliente where cpf=?";
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
    String sqlQuery = "update app.cliente set c_senha=?, c_email=?, telefone=?, nome=?, cpf=?, reclamacoesrecebidas =?, endereco=?,dt_nascimento=? where cliente_id=?";
    PreparedStatement pst;
    Connection connection;
    try {
      connection = new ConnectionFactory().getConnection();
      pst = connection.prepareStatement(sqlQuery);
      pst.setString(1, cliente.getSenha());
      pst.setString(2, cliente.getEmail());
      pst.setLong(3, cliente.getTelefone());
      pst.setString(4, cliente.getNome());
      pst.setLong(5, cliente.getCpf());
      pst.setInt(6,cliente.getRec_id());
      pst.setString(7, cliente.getEndereco());
      pst.setDate(8, (Date) cliente.getDataNascimento());
      pst.setInt(9, cliente.getId());
      pst.execute();
      pst.close();
      connection.close();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  @Override
  public void deleteCliente(Cliente cliente) {
    String sqlQuery = "delete from app.cliente where cpf=?";
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
   

