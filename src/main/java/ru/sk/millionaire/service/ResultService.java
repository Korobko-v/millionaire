package ru.sk.millionaire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sk.millionaire.model.Result;
import ru.sk.millionaire.repository.ResultRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    public List<Result> findTop10() {
        return resultRepository.
                findAll()
                .stream()
                .sorted(Comparator.comparingInt(Result::getWin).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }
}
