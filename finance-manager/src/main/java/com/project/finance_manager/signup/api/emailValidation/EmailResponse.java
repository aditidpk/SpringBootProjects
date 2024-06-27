package com.project.finance_manager.signup.api.emailValidation;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
public class EmailResponse {
    @JsonProperty("id")
    private String uuid;
}
