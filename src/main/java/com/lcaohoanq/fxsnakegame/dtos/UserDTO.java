package com.lcaohoanq.fxsnakegame.dtos;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    private Integer userId;
    private String email;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String password;
    private String confirmPassword;
    private Integer score = 0;
    private LocalDateTime created = LocalDateTime.now();

    public UserDTO(String email, String firstName, String lastName, String password,
        String confirmPassword) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public UserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserDTO(String email, Integer score) {
        this.email = email;
        this.score = score;
    }

}
