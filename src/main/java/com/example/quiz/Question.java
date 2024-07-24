package com.example.quiz;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Question {
    private static final Logger logger = LogManager.getLogger(Question.class);

    private int id;
    private String text;
    private String option1;
    private String option2;
    private String option3;
    private String correctAnswer;

    public Question(int id, String text, String option1, String option2, String option3, String correctAnswer) {
        this.id = id;
        this.text = text;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.correctAnswer = correctAnswer;

        logger.info("Created question: ", id, text);
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getOptions() {
        return List.of(option1, option2, option3);
    }
}
