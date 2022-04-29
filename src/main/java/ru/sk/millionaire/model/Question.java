package ru.sk.millionaire.model;

import javax.persistence.*;

@Entity
@Table
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "question_text")
    private String questionText;

    @Column(name = "correct_answer")
    private String correctAnswer;

    @Column(name = "wrong_answer1")
    private String wrongAnswer1;

    @Column(name = "wrong_answer2")
    private String wrongAnswer2;

    @Column(name = "wrong_answer3")
    private String wrongAnswer3;

    @Column(name = "level")
    private Level level;
}
