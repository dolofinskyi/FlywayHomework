package service;

import service.entity.Client;
import service.templates.ClientSqlTemplate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientService implements DatabaseService {
    private PreparedStatement addClient;
    private PreparedStatement getClientById;
    private PreparedStatement setClientNameById;
    private PreparedStatement deleteClientById;
    private PreparedStatement getAllClients;

    private final String[] generatedColumns = { "ID" };

    public static void main(String[] args) {
        ClientService service = new ClientService();

        // add new client
        long id = service.create("SpiderMan");
        System.out.println(id);

        // get client name
        String name = service.getById(id);
        System.out.println(name);

        // set new name
        service.setName(id, "NewSpiderMan");
        System.out.println(service.getById(id));

        // delete client
        service.deleteById(id);

        // print all clients
        System.out.println(service.listAll());
    }

    public ClientService() {
        try {
            // prepare statements
            addClient = databaseInstance
                    .getConnection()
                    .prepareStatement(ClientSqlTemplate.ADD_CLIENT,
                                      generatedColumns);

            getClientById = databaseInstance
                    .getConnection()
                    .prepareStatement(ClientSqlTemplate.GET_CLIENT_BY_ID);

            setClientNameById = databaseInstance
                    .getConnection()
                    .prepareStatement(ClientSqlTemplate.SET_CLIENT_NAME_BY_ID);

            deleteClientById = databaseInstance
                    .getConnection()
                    .prepareStatement(ClientSqlTemplate.DELETE_CLIENT_BY_ID);

            getAllClients = databaseInstance
                    .getConnection()
                    .prepareStatement(ClientSqlTemplate.GET_ALL_CLIENTS);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public long create(String name) {
        String formattedName = name.strip();
        validateName(formattedName);

        try {
            addClient.setString(1, formattedName);
            addClient.executeUpdate();

            try (ResultSet resultSet = addClient.getGeneratedKeys()) {
                if (resultSet.next()) {
                    return resultSet.getLong(1);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return -1;
    }

    public String getById(long id) {
        try {
            getClientById.setLong(1, id);
            try (ResultSet resultSet = getClientById.executeQuery()) {
                if (resultSet.next()){
                    return resultSet.getString(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "";
    }

    public void setName(long id, String name) {
        String formattedName = name.strip();
        validateName(formattedName);

        try {
            setClientNameById.setString(1, formattedName);
            setClientNameById.setLong(2, id);
            setClientNameById.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteById(long id) {
        try {
            deleteClientById.setLong(1, id);
            deleteClientById.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    List<Client> listAll() {
        List<Client> result = new ArrayList<>();

        try (ResultSet resultSet = getAllClients.executeQuery()) {
            while (resultSet.next()){
                Client client = new Client(
                        resultSet.getLong(1),
                        resultSet.getString(2)
                );
                result.add(client);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }

    private void validateName(String name){
        if (name.length() < 4){
            throw new IllegalArgumentException("Name must have at least 4 characters");
        }

        if (name.length() > 15){
            throw new IllegalArgumentException("Name must be shorter than 15 characters");
        }
    }
}
