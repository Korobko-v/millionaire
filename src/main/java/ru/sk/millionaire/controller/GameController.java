package ru.sk.millionaire.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GameController {

    @GetMapping("/game")
    public String showGamePage() {
        return "game";
    }

    @PostMapping("/game")
    public String handleGamePage() {
        return "game";
    }
}
