package ru.sk.millionaire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sk.millionaire.form.RegistrationForm;
import ru.sk.millionaire.model.User;
import ru.sk.millionaire.model.auth.Role;
import ru.sk.millionaire.model.auth.Status;
import ru.sk.millionaire.repository.UserRepository;

import javax.validation.Valid;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("/register")
    private String showRegisterForm(
            @ModelAttribute("form")
                    RegistrationForm form) {
        return "register";
    }
    @PostMapping("/register")
    public String handleRegister(
            @ModelAttribute("form")
            @Valid
                    RegistrationForm form,
            BindingResult result
    ) {
        if (!form.getPassword().equals(form.getPasswordConfirmation())) {
            result.addError(new FieldError("form", "passwordConfirmation",
                    "Пароли не совпадают"));
        }

        if (result.hasErrors()) {
            return "/register";
        }

        String encryptedPassword = encoder.encode(form.getPassword());

        try {
            userRepository.insert(new User(form.getUsername(), form.getPassword(), Role.USER, Status.ACTIVE));
        }
        catch (Exception cause) {
            result.addError(new FieldError(
                    "form",
                    "username",
                    "Пользователь с таким логином уже существует"
            ));
        }

        if (result.hasErrors()) {
            return "register";
        }

        return "redirect:/main";
    }
}
