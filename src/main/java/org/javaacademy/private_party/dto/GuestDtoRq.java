package org.javaacademy.private_party.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GuestDtoRq {
    private String name;
    private String mail;
    private String phone;
}
