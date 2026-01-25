
import org.junit.jupiter.api.Test;

import com.example.StudentAnalyzer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentAnalyzerTest {

    // =========================
    // countExcellentStudents
    // =========================

    @Test
    public void testCountExcellentStudents_MixedValidAndInvalid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0, 8.0);

        assertEquals(3, analyzer.countExcellentStudents(scores));
    }

    @Test
    public void testCountExcellentStudents_AllValid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(10.0, 8.0, 7.9, 8.1, 0.0);

        assertEquals(3, analyzer.countExcellentStudents(scores));
    }

    @Test
    public void testCountExcellentStudents_EmptyList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();

        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));
    }

    @Test
    public void testCountExcellentStudents_OnlyZeroAndTen() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(0.0, 10.0, 10.0, 0.0);

        assertEquals(2, analyzer.countExcellentStudents(scores));
    }

    @Test
    public void testCountExcellentStudents_AllInvalidScores() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(-5.0, 11.0, 100.0, -1.0);

        assertEquals(0, analyzer.countExcellentStudents(scores));
    }

    @Test
    public void testCountExcellentStudents_NullList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();

        assertEquals(0, analyzer.countExcellentStudents(null));
    }

    @Test
    public void testCountExcellentStudents_ContainsNullElement() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(9.0, null, 8.0, 7.0);

        assertEquals(2, analyzer.countExcellentStudents(scores));
    }

    // =========================
    // calculateValidAverage
    // =========================

    @Test
    public void testCalculateValidAverage_MixedValidAndInvalid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0);

        double avg = analyzer.calculateValidAverage(scores);

        assertEquals(8.1667, avg, 0.0001);
    }

    @Test
    public void testCalculateValidAverage_AllValid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(10.0, 8.0, 6.0, 0.0);

        assertEquals(6.0, analyzer.calculateValidAverage(scores), 0.0001);
    }

    @Test
    public void testCalculateValidAverage_EmptyList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();

        assertEquals(0.0, analyzer.calculateValidAverage(Collections.emptyList()), 0.0001);
    }

    @Test
    public void testCalculateValidAverage_OnlyZeroAndTen() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(0.0, 10.0, 10.0, 0.0);

        assertEquals(5.0, analyzer.calculateValidAverage(scores), 0.0001);
    }

    @Test
    public void testCalculateValidAverage_AllInvalidScores() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(-2.0, 12.0, 11.5, -1.0);

        assertEquals(0.0, analyzer.calculateValidAverage(scores), 0.0001);
    }

    @Test
    public void testCalculateValidAverage_NullList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();

        assertEquals(0.0, analyzer.calculateValidAverage(null), 0.0001);
    }

    @Test
    public void testCalculateValidAverage_ContainsNullElement() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(9.0, null, 7.0);

        assertEquals(8.0, analyzer.calculateValidAverage(scores), 0.0001);
    }
}

