package com.lcaohoanq.fxsnakegame.dtos;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

    private Integer userId;
    private String email;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String password;
    private String confirmPassword;
    private Integer score = 0;
    private LocalDateTime created;


}
