package ru.sk.millionaire.model;

public enum Level {
    EASY,
    MEDIUM,
    HARD,
    ULTIMATE;

    public static Level fromString(String level) {
        switch (level) {
            case "MEDIUM" : return MEDIUM;
            case "HARD" : return HARD;
            case "ULTIMATE" : return ULTIMATE;
            default: return EASY;
        }
    }
}
