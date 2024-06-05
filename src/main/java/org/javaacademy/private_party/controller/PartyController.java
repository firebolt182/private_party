package org.javaacademy.private_party.controller;

import java.sql.SQLException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.javaacademy.private_party.dto.GuestDtoRq;
import org.javaacademy.private_party.service.PartyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("party")
@RequiredArgsConstructor
public class PartyController {
    private final PartyService partyService;

    @PostMapping("/add-guest")
    public ResponseEntity addGuest(@RequestHeader("user") String userName,
                                   @RequestHeader("password") String password,
                                   @RequestBody GuestDtoRq body)
                                        throws SQLException,
                                        ClassNotFoundException {
        partyService.addGuest(userName, password, body);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/all-guests")
    public ResponseEntity<List<String>> findAllGuests(@RequestHeader("user") String userName,
                                                      @RequestHeader("password") String password)
            throws SQLException,
            ClassNotFoundException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(partyService.findAllGuests(userName, password));
    }
}
