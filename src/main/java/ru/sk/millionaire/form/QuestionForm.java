package ru.sk.millionaire.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class QuestionForm {

    @Size(min = 10, max = 255, message = "Длина вопроса не должна быть менее 10 символов или превышать 255 символов")
//    @Pattern(regexp = "\\?$", message = "Вопрос должен оканчиваться вопросительным знаком")
    private String questionText;

    @Size(min = 1, max = 100, message = "Длина ответа не должна быть менее 1 символа или превышать 100 символов")
    private String correctAnswer;

    @Size(min = 1, max = 100, message = "Длина ответа не должна быть менее 1 символа или превышать 100 символов")
    private String wrongAnswer1;

    @Size(min = 1, max = 100, message = "Длина ответа не должна быть менее 1 символа или превышать 100 символов")
    private String wrongAnswer2;

    @Size(min = 1, max = 100, message = "Длина ответа не должна быть менее 1 символа или превышать 100 символов")
    private String wrongAnswer3;

    private String level;
}
