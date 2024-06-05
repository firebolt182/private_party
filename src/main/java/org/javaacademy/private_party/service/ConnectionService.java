package org.javaacademy.private_party.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.stereotype.Service;

@Service
public class ConnectionService {
    private static final String URL = "jdbc:postgresql://localhost:5432/party";

    public Connection init(String userName, String password)
            throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(URL, userName, password);
    }
}
