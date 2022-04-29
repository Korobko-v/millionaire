package ru.sk.millionaire.form;

import javax.validation.constraints.NotBlank;

public class UsernameForm {

    @NotBlank(message = "Имя не должно быть пустым")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
