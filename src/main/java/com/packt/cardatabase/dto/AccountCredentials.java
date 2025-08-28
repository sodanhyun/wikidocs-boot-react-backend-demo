package com.packt.cardatabase.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class AccountCredentials {
    private final String username;
    private final String password;
}
