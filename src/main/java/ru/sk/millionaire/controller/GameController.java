package ru.sk.millionaire.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.sk.millionaire.form.UsernameForm;

import javax.validation.Valid;

@Controller
public class GameController {

    @GetMapping("/username")
    public String showUsernameForm(@ModelAttribute("form") UsernameForm form) {
        return "username";
    }

    @PostMapping("/username")
    public String handleUsernameForm(@ModelAttribute("form") @Valid UsernameForm form,
                                     BindingResult result) {
        if (result.hasErrors()) {
            return "username";
        }
        return "game";
    }

    @ModelAttribute("usernameForm")
    public UsernameForm createDefaultUsernameForm() {
        return new UsernameForm();
    }

    @GetMapping("/game")
    public String showGamePage() {
        return "game";
    }

    @PostMapping("/game")
    public String handleGamePage() {
        return "game";
    }
}
