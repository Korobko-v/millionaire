package ru.sk.millionaire.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sk.millionaire.model.Question;
import ru.sk.millionaire.repository.QuestionRepository;
import ru.sk.millionaire.service.QuestionService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Transactional
    @Override
    public List<Question> index() {

        return questionRepository.findAll().stream().sorted(Comparator.comparingInt(Question::getId)).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void save (Question question) {
        questionRepository.save(question);
    }

    @Transactional
    @Override
    public void insert(Question question) {
        questionRepository.insert(question);
    }

    @Transactional
    @Override
    public void update(int id, Question updatedQuestion) {
        Question toUpdate = show(id);
        toUpdate.setQuestion_text(updatedQuestion.getQuestion_text());
        toUpdate.setCorrectAnswer(updatedQuestion.getCorrectAnswer());
        toUpdate.setWrongAnswer1(updatedQuestion.getWrongAnswer1());
        toUpdate.setWrongAnswer2(updatedQuestion.getWrongAnswer2());
        toUpdate.setWrongAnswer3(updatedQuestion.getWrongAnswer3());
        toUpdate.setLevel(updatedQuestion.getLevel());
    }

    @Transactional
    @Override
    public void delete(int id) {
        questionRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Question show(int id) {
        return questionRepository.getById(id);
    }
}
