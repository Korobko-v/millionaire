package ru.sk.millionaire.service;

import ru.sk.millionaire.model.Question;
import java.util.List;

public interface QuestionService {

    List<Question> index();

    void save (Question question);

    void insert(Question question);

    void update(int id, Question updatedQuestion);

    void delete(int id);

    Question show(int id);
}
