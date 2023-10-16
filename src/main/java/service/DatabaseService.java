package service;


import database.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public interface DatabaseService {
    Database databaseInstance = Database.getInstance();
}
