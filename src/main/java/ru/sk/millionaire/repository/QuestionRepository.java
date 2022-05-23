package ru.sk.millionaire.repository;

import lombok.SneakyThrows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.sk.millionaire.model.Level;
import ru.sk.millionaire.model.Question;

import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Optional<Question> findByLevel(Level level);

    @SneakyThrows
    @Transactional
    default Question insert(Question question) {
        save(question);
        return question;
    }
}
