package ru.sk.millionaire.model.auth;

public enum Permission {
    USERS_READ("users:read"),
    USERS_WRITE("users:write"),
    QUESTIONS_READ("questions:read"),
    QUESTIONS_WRITE("questions:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
