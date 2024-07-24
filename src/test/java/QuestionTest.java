import com.example.quiz.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionTest {

    private Question question;

    @BeforeEach
    public void setUp() {
        // Initialize a sample question before each test
        question = new Question(1, "What is 2 + 2?", "4", "5", "6", "4");
    }

    @Test
    public void testGetId() {
        assertEquals(1, question.getId());
    }

    @Test
    public void testGetText() {
        assertEquals("What is 2 + 2?", question.getText());
    }

    @Test
    public void testGetOption1() {
        assertEquals("4", question.getOption1());
    }

    @Test
    public void testGetOption2() {
        assertEquals("5", question.getOption2());
    }

    @Test
    public void testGetOption3() {
        assertEquals("6", question.getOption3());
    }

    @Test
    public void testGetCorrectAnswer() {
        assertEquals("4", question.getCorrectAnswer());
    }

    @Test
    public void testGetOptions() {
        assertEquals(3, question.getOptions().size());
        assertEquals("4", question.getOptions().get(0));
        assertEquals("5", question.getOptions().get(1));
        assertEquals("6", question.getOptions().get(2));
    }
}
