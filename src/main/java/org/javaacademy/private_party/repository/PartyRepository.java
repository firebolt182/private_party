package org.javaacademy.private_party.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.javaacademy.private_party.dto.GuestDtoRs;
import org.springframework.stereotype.Service;

@Service
public class PartyRepository {

    public void addGuest(Connection connection, String name, String mail, String phoneNumber)
            throws SQLException {
        String sql = """
                insert into guest ("name", "email", "phone") values (?, ?, ?)
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, mail);
            preparedStatement.setString(3, phoneNumber);
            preparedStatement.execute();
        }
    }

    public List<String> findAllGuests(Connection connection) throws SQLException {
        List<String> guests = new ArrayList<>();
        String sql = """
                select name
               	    from guest_name;
                """;
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                GuestDtoRs guestDtoRs = new GuestDtoRs();
                guestDtoRs.setName(resultSet.getString("name"));
                guests.add(guestDtoRs.getName());
            }
        }
        return guests;
    }
}
