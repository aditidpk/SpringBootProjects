package com.project.finance_manager.signup.api.emailValidation;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EmailRequest {
    @JsonProperty("email")
    private String email;
}
