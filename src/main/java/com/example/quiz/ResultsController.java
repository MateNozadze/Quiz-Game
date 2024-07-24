package com.example.quiz;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ResultsController {

    @FXML
    private Label resultLabel;

    public void setResults(int correctCount, int totalQuestions) {
        String resultsText = "You answered " + correctCount + " out of " + totalQuestions + " questions correctly.";
        resultLabel.setText(resultsText);
    }
}
