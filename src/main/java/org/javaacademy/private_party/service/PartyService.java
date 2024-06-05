package org.javaacademy.private_party.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.javaacademy.private_party.dto.GuestDtoRq;
import org.javaacademy.private_party.repository.PartyRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PartyService {
    private final ConnectionService connectionService;
    private final PartyRepository partyRepository;

    public void addGuest(String userName, String password, GuestDtoRq guestDtoRq)
            throws SQLException, ClassNotFoundException {
        try (Connection connection = connectionService.init(userName, password)) {
            partyRepository.addGuest(
                    connection,
                    guestDtoRq.getName(),
                    guestDtoRq.getMail(),
                    guestDtoRq.getPhone());
        }
    }

    public List<String> findAllGuests(String userName, String password)
            throws SQLException, ClassNotFoundException {
        try (Connection connection = connectionService.init(userName, password)) {
            return partyRepository.findAllGuests(connection);
        }
    }
}
