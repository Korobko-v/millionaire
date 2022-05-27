package ru.sk.millionaire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.sk.millionaire.form.QuestionForm;
import ru.sk.millionaire.model.Level;
import ru.sk.millionaire.model.Question;
import ru.sk.millionaire.service.QuestionService;

import javax.validation.Valid;

@Controller
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("questionsList", questionService.index());
        return "questions/index";
    }

    @PostMapping
    public Question createQuestion(@RequestBody Question question) {
        questionService.save(question);
        return question;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("question", questionService.show(id));
        return "questions/show";
    }

    @GetMapping("/new_question")
    private String showQuestionForm(
            @ModelAttribute("questionForm")
                    QuestionForm questionForm) {
        return "questions/new_question";
    }

    @PostMapping("/new_question")
    public String handleQuestionForm(@ModelAttribute("questionForm")
                                     @Valid
                                             QuestionForm questionForm, BindingResult result,
                                     @RequestParam("level") Level level) {


        if (result.hasErrors()) {
            return "questions/new_question";
        }

        try {
            questionService.insert(new Question(questionForm.getQuestionText(), questionForm.getCorrectAnswer(),
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
            return "questions/new_question";
        }

        return "redirect:/questions";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("question", questionService.show(id));
        return "questions/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("question") @Valid Question question,
                         BindingResult bindingResult,
                         @PathVariable("id") int id) {

        if (bindingResult.hasErrors())
            return "questions/edit";

        questionService.update(id, question);
        return "redirect:/questions";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        questionService.delete(id);
        return "redirect:/questions";
    }
}
