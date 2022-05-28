package ru.sk.millionaire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sk.millionaire.model.Result;
import ru.sk.millionaire.service.ResultService;

import java.util.List;

@Controller
@RequestMapping("/results")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @GetMapping("/records")
    public String getRecords(Model model) {
        List<Result> recordList = resultService.findTop10();
        model.addAttribute("recordList", recordList);
        return "results/records";
    }
}
