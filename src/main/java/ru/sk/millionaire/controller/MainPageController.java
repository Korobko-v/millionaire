package ru.sk.millionaire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sk.millionaire.model.Question;
import ru.sk.millionaire.model.Result;
import ru.sk.millionaire.model.User;
import ru.sk.millionaire.model.auth.Role;
import ru.sk.millionaire.repository.QuestionRepository;
import ru.sk.millionaire.repository.ResultRepository;
import ru.sk.millionaire.repository.UserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/main")
public class MainPageController {

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/userspage")
    public String usersTable(Model model) {
        List<User> userList = userRepository.findAll();
        userList.sort((o1, o2) -> (int) (o1.getId() - o2.getId()));
        model.addAttribute("userList", userList);
        return "userspage";
    }

    @PostMapping("/userspage")
    public User createUser(@RequestBody User user) {
        return userRepository.insert(user);
    }

    @GetMapping("/questions")
    public String questionsTable(Model model) {
        List<Question> questionsList = questionRepository.findAll();
        model.addAttribute("questionsList", questionsList);
        return "questions";
    }

    @PostMapping("/questions")
    public Question createQuestion(@RequestBody Question question) {
        questionRepository.save(question);
        return question;
    }

    @GetMapping
    public String main(Model model, Authentication authentication) {
        boolean loggedIn = authentication != null && authentication.isAuthenticated();
        String username = "";
        boolean isAdmin = false;
        boolean isCreator = false;

        if (loggedIn) {
            username = authentication.getName();
            isAdmin = userRepository.findByUsername(username).get().getRole().equals(Role.ADMIN);
            isCreator = userRepository.findByUsername(username).get().getRole().equals(Role.CREATOR);
        }

        model.addAttribute("login", username);
        model.addAttribute("loggedIn", loggedIn);
        model.addAttribute("isAdmin", isAdmin);
        model.addAttribute("isCreator", isCreator);

        return "main";
    }

    @PostMapping("/logout")
    public String logout(Model model, Authentication authentication) {
        authentication.setAuthenticated(false);
        model.addAttribute("loggedIn", false);
        return "redirect:/main";
    }

    @GetMapping("/records")
    public String getRecords(Model model) {
        List<Result> recordList = resultRepository.findAll()
                .stream()
                .sorted(Comparator.comparingInt(Result::getWin).reversed())
                .limit(10)
                .collect(Collectors.toList());
        model.addAttribute("recordList", recordList);
        return "records";
    }
}
