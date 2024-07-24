package com.example.quiz;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class GameController {
    private static final Logger logger = LogManager.getLogger(GameController.class);

    private List<Question> questions;
    private int currentQuestionIndex;
    private int score;

    @FXML
    private VBox questionPane;

    @FXML
    private Label feedbackLabel;

    @FXML
    private Label questionLabel;

    @FXML
    private Button option1;

    @FXML
    private Button option2;

    @FXML
    private Button option3;

    public GameController(List<Question> questions) {
        this.questions = questions;
        this.currentQuestionIndex = 0;
        this.score = 0;

        logger.info("GameController initialized with {} questions", questions.size());
    }

    @FXML
    public void initialize() {
        showQuestion();
    }

    private void showQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            questionLabel.setText(currentQuestion.getText());
            List<String> options = currentQuestion.getOptions();
            option1.setText(options.get(0));
            option2.setText(options.get(1));
            option3.setText(options.get(2));
            feedbackLabel.setText("");
        } else {
            // No more questions left
            logger.warn("No more questions left to display");
            questionLabel.setText("No more questions");
            option1.setDisable(true);
            option2.setDisable(true);
            option3.setDisable(true);
        }
    }

    @FXML
    private void handleOption1() {
        handleAnswer(option1.getText());
    }

    @FXML
    private void handleOption2() {
        handleAnswer(option2.getText());
    }

    @FXML
    private void handleOption3() {
        handleAnswer(option3.getText());
    }

    private void handleAnswer(String selectedOption) {
        Question currentQuestion = questions.get(currentQuestionIndex);
        String correctAnswer = currentQuestion.getCorrectAnswer();

        if (selectedOption.equals(correctAnswer)) {
            score++;
            feedbackLabel.setText("Correct!");
            logger.info("Question {} answered correctly", currentQuestion.getId());
        } else {
            feedbackLabel.setText("Wrong!");
            logger.info("Question {} answered incorrectly", currentQuestion.getId());
        }

        currentQuestionIndex++;
        showQuestion();
    }

    @FXML
    private void handleFinish() {
        questionPane.getChildren().removeAll(option1, option2, option3);

        String resultMessage = String.format("Quiz completed! Your score: %d out of %d", score, questions.size());
        feedbackLabel.setText(resultMessage);

        logger.info("Quiz completed with score: {} out of {}", score, questions.size());
    }
}
