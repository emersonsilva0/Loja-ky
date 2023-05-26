package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projectdb.ClienteVip;

public class ClienteVipDAO {
    private static final String URL ="jdbc:mysql://localhost:3306/lojask?user=root&password=root";
   
    
    public void salvarClienteVip(ClienteVip clienteVip) {
        try (Connection connection = DriverManager.getConnection(URL)) {
            String query = "INSERT INTO ClienteVip (id_clienteFK, cpf, endereco, tempo_contribuicao) " +
                           "VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, clienteVip.getId_clienteFK());
            statement.setInt(2, clienteVip.getCpf());
            statement.setString(3, clienteVip.getEndereco());
            statement.setString(4, clienteVip.getTempo_contribuicao());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ClienteVip buscarClienteVip(int idClienteVip) {
        ClienteVip clienteVip = null;
        try (Connection connection = DriverManager.getConnection(URL)) {
            String query = "SELECT * FROM ClienteVip WHERE id_clienteFK = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idClienteVip);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                clienteVip = new ClienteVip();
                clienteVip.setId_clienteFK(resultSet.getInt("id_clienteFK"));
                clienteVip.setCpf(resultSet.getInt("cpf"));
                clienteVip.setEndereco(resultSet.getString("endereco"));
                clienteVip.setTempo_contribuicao(resultSet.getString("tempo_contribuicao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clienteVip;
    }
    
    public void atualizarClienteVip(ClienteVip clienteVip) {
        try (Connection connection = DriverManager.getConnection(URL)) {
            String query = "UPDATE ClienteVip SET cpf = ?, endereco = ?, tempo_contribuicao = ? " +
                           "WHERE id_clienteFK = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, clienteVip.getCpf());
            statement.setString(2, clienteVip.getEndereco());
            statement.setString(3, clienteVip.getTempo_contribuicao());
            statement.setInt(4, clienteVip.getId_clienteFK());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void excluirClienteVip(int idClienteVip) {
        try (Connection connection = DriverManager.getConnection(URL)) {
            String query = "DELETE FROM ClienteVip WHERE id_clienteFK = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idClienteVip);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<ClienteVip> listarClientesVip() {
        List<ClienteVip> clientesVip = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL)) {
            String query = "SELECT * FROM ClienteVip";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClienteVip clienteVip = new ClienteVip();
                clienteVip.setId_clienteFK(resultSet.getInt("id_clienteFK"));
                clienteVip.setCpf(resultSet.getInt("cpf"));
                clienteVip.setEndereco(resultSet.getString("endereco"));
                clienteVip.setTempo_contribuicao(resultSet.getString("tempo_contribuicao"));
                clientesVip.add(clienteVip);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientesVip;
    }
    
}
