package com.project.finance_manager.signup.api.userRegistration;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserRegRequest {
    @JsonProperty("email")
    String email;

    @JsonProperty("password")
    String password;

    @JsonProperty("name")
    String name;
}
