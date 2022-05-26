package ru.sk.millionaire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sk.millionaire.model.Level;
import ru.sk.millionaire.model.Question;
import ru.sk.millionaire.repository.QuestionRepository;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;


    public void update(int id, String text, String correct, String wrong1, String wrong2, String wrong3, Level level) {
        Question toUpdate = questionRepository.getById(id);
        toUpdate.setCorrectAnswer(correct);
        toUpdate.setWrongAnswer1(wrong1);
        toUpdate.setWrongAnswer2(wrong2);
        toUpdate.setWrongAnswer3(wrong3);
        toUpdate.setLevel(level);
    }

    public void delete(int id) {
        questionRepository.deleteById(id);
    }
}
