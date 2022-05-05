package ru.sk.millionaire.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "questions")
@Getter
@Setter
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
}
