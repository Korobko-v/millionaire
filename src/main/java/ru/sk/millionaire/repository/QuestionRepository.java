package ru.sk.millionaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sk.millionaire.model.Level;
import ru.sk.millionaire.model.Question;

import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Optional<Question> findByLevel(Level level);
}
