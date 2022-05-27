package ru.sk.millionaire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sk.millionaire.model.Level;
import ru.sk.millionaire.model.Question;
import ru.sk.millionaire.repository.QuestionRepository;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public List<Question> index() {
        return questionRepository.findAll();
    }

    public void save (Question question) {
        questionRepository.save(question);
    }

    public void insert(Question question) {
        questionRepository.insert(question);
    }

    public void update(int id, Question updatedQuestion) {
        Question toUpdate = show(id);
        toUpdate.setQuestion_text(updatedQuestion.getQuestion_text());
        toUpdate.setCorrectAnswer(updatedQuestion.getCorrectAnswer());
        toUpdate.setWrongAnswer1(updatedQuestion.getWrongAnswer1());
        toUpdate.setWrongAnswer2(updatedQuestion.getWrongAnswer2());
        toUpdate.setWrongAnswer3(updatedQuestion.getWrongAnswer3());
        toUpdate.setLevel(updatedQuestion.getLevel());
    }

    public void delete(int id) {
        questionRepository.deleteById(id);
    }

    public Question show(int id) {
        return questionRepository.getById(id);
    }
}
