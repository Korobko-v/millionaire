package ru.sk.millionaire.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class UsernameForm {

    @NotEmpty(message = "Имя не должно быть пустым")
    private String username;
}
