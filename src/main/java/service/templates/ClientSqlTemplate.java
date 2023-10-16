package service.templates;

public class ClientSqlTemplate {
    public static final String ADD_CLIENT = "INSERT INTO client(NAME) " +
            "VALUES (?)";
    public static final String GET_CLIENT_BY_ID = "SELECT name FROM client " +
            "WHERE id = ?";
    public static final String GET_CLIENT_BY_NAME = "SELECT name FROM client " +
            "WHERE id = ?";
    public static final String SET_CLIENT_NAME_BY_ID = "UPDATE client " +
            "SET name = ?" +
            "WHERE id = ?";
    public static final String DELETE_CLIENT_BY_ID = "DELETE FROM client " +
            "WHERE id = ?";
    public static final String GET_ALL_CLIENTS = "SELECT * FROM client";
}
