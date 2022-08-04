package com.personalsoft.crudSpringAngular.models;

import lombok.*;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class UserDto {

    @NotBlank
    private String name;

    private int documentNumber;

    private String userName;

    private String password;

}
