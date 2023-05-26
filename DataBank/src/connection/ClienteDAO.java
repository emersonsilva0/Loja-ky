package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projectdb.Cliente;



public class ClienteDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/lojask?user=root&password=root";
    
    public void salvarCliente(Cliente cliente) {
        try (Connection connection = DriverManager.getConnection(URL)) {
            String query = "INSERT INTO Cliente (id_cliente, nome, data_nasc, telefone, tipo_cliente, valor) " +
                           "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, cliente.getId_cliente());
            statement.setString(2, cliente.getNome());
            statement.setDate(3, new java.sql.Date(cliente.getData_nasc().getTime()));
            statement.setString(4, cliente.getTelefone());
            statement.setString(5, cliente.getTipo_cliente());
            statement.setDouble(6, cliente.getValor());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Cliente buscarCliente(int idCliente) {
        Cliente cliente = null;
        try (Connection connection = DriverManager.getConnection(URL)) {
            String query = "SELECT * FROM Cliente WHERE id_cliente = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idCliente);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                cliente = new Cliente();
                cliente.setId_cliente(resultSet.getInt("id_cliente"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setData_nasc(resultSet.getDate("data_nasc"));
                cliente.setTelefone(resultSet.getString("telefone"));
                cliente.setTipo_cliente(resultSet.getString("tipo_cliente"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }
    
    public void atualizarCliente(Cliente cliente) {
        try (Connection connection = DriverManager.getConnection(URL)) {
            String query = "UPDATE Cliente SET nome = ?, data_nasc = ?, telefone = ?, tipo_cliente = ?, valor = ?, " +
                           " WHERE id_cliente = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, cliente.getNome());
            statement.setDate(2, new java.sql.Date(cliente.getData_nasc().getTime()));
            statement.setString(3, cliente.getTelefone());
            statement.setString(4, cliente.getTipo_cliente());
            statement.setDouble(5, cliente.getValor());

            statement.setInt(6, cliente.getId_cliente());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void excluirCliente(int idCliente) {
        try (Connection connection = DriverManager.getConnection(URL)) {
            String query = "DELETE FROM Cliente WHERE id_cliente = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idCliente);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL)) {
            String query = "SELECT * FROM Cliente";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setId_cliente(resultSet.getInt("id_cliente"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setData_nasc(resultSet.getDate("data_nasc"));
                cliente.setTelefone(resultSet.getString("telefone"));
                cliente.setTipo_cliente(resultSet.getString("tipo_cliente"));
                cliente.setValor(resultSet.getDouble("valor"));

                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }
}

// Implemente classes DAO similares para as outras entidades (ClienteVip, Fornecedor, FornecedorSede, Funcionario, Produtos, Sede)

