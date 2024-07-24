package com.example.quiz;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DatabaseManager {

    private static final String PROPERTIES_FILE = "/db.properties";
    private static Properties properties = loadProperties();

    private static Properties loadProperties() {
        Properties props = new Properties();
        try (InputStream inputStream = DatabaseManager.class.getResourceAsStream(PROPERTIES_FILE)) {
            props.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace(); // Handle error loading properties file
        }
        return props;
    }

    public List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();
        String query = "SELECT * FROM questions"; // Adjust SQL query if necessary
        try (Connection connection = DriverManager.getConnection(
                properties.getProperty("db.url"),
                properties.getProperty("db.user"),
                properties.getProperty("db.password"));
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int questionId = resultSet.getInt("question_id");
                String questionText = resultSet.getString("question_text");
                String option1 = resultSet.getString("option1");
                String option2 = resultSet.getString("option2");
                String option3 = resultSet.getString("option3");
                String correctAnswer = resultSet.getString("correct_answer");

                Question question = new Question(questionId, questionText, option1, option2, option3, correctAnswer);
                questions.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print exception for debugging
        }
        return questions;
    }
}
