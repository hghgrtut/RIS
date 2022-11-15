package com.kharitonov.flower.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    @NonNull
    private Long id;
    @NonNull
    private String login;
    @NonNull
    private String password;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String role;
    @NonNull
    private BasketDTO basket;
}
