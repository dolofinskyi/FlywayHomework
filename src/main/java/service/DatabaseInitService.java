package service;

import org.flywaydb.core.Flyway;
import prefs.Prefs;

public class DatabaseInitService implements DatabaseService {

    public static void main(String[] args) {
        DatabaseInitService initService = new DatabaseInitService();
        initService.initDatabase();
    }

    public void initDatabase() {
        String connectionUrl = new Prefs().getString(Prefs.JDBC_CONNECTION_URL);

        Flyway flyway = Flyway
                .configure()
                .dataSource(connectionUrl, null, null)
                .load();

        flyway.migrate();
    }
}
