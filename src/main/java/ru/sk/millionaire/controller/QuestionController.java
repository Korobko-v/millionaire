package ru.sk.millionaire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.sk.millionaire.form.QuestionForm;
import ru.sk.millionaire.model.Level;
import ru.sk.millionaire.model.Question;
import ru.sk.millionaire.repository.QuestionRepository;

import javax.validation.Valid;

@Controller
@RequestMapping
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/new_question")
    private String showQuestionForm(
            @ModelAttribute("questionForm")
                    QuestionForm questionForm) {
        return "new_question";
    }

    @PostMapping("/new_question")
    public String handleQuestionForm(@ModelAttribute("questionForm")
                                     @Valid
                                             QuestionForm questionForm, BindingResult result,
                                     @RequestParam("level") Level level) {


        if (result.hasErrors()) {
            return "new_question";
        }

        try {
            questionRepository.insert(new Question(questionForm.getQuestionText(), questionForm.getCorrectAnswer(),
                    questionForm.getWrongAnswer1(), questionForm.getWrongAnswer2(), questionForm.getWrongAnswer3(),
                    Level.fromString(questionForm.getLevel())));
        } catch (Exception cause) {
            result.addError(new FieldError(
                    "form",
                    "question_text",
                    "Такой вопрос уже существует"
            ));
        }

        if (result.hasErrors()) {
            return "new_question";
        }

        return "redirect:/main/questions";
    }
}
