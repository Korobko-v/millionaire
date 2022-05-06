package ru.sk.millionaire.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "questions")
@Getter
@Setter
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "question_text")
    private String question_text;

    @Column(name = "correct_answer")
    private String correctAnswer;

    @Column(name = "wrong_answer1")
    private String wrongAnswer1;

    @Column(name = "wrong_answer2")
    private String wrongAnswer2;

    @Column(name = "wrong_answer3")
    private String wrongAnswer3;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "level")
    private Level level;

    public Question(String question_text, String correctAnswer, String wrongAnswer1, String wrongAnswer2, String wrongAnswer3, Level level) {
        this.question_text = question_text;
        this.correctAnswer = correctAnswer;
        this.wrongAnswer1 = wrongAnswer1;
        this.wrongAnswer2 = wrongAnswer2;
        this.wrongAnswer3 = wrongAnswer3;
        this.level = level;
    }
}
