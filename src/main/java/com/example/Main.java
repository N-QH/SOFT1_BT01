package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    /**
     * Hàm tiện ích: tách và parse một dòng thành danh sách Double.
     * Chấp nhận phân tách bởi khoảng trắng hoặc dấu phẩy.
     * Bỏ qua token rỗng hoặc không phải số.
     */
    private static List<Double> parseScores(String line) {
        List<Double> scores = new ArrayList<>();
        if (line == null) return scores;

        // Cho phép cả khoảng trắng và dấu phẩy làm phân tách
        String[] tokens = line.trim().split("[,\\s]+");
        for (String t : tokens) {
            if (t.isEmpty()) continue;
            try {
                scores.add(Double.valueOf(t));
            } catch (NumberFormatException ex) {
                // Bỏ qua token không phải số
            }
        }
        return scores;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentAnalyzer analyzer = new StudentAnalyzer();

        System.out.println("Nhap danh sach diem (0-10), phan tach bang dau cach hoac dau phay.");
        System.out.println("Vi du: 9 8.5 7, 10, 12, -1, 8.0");
        System.out.print("Diem: ");

        String line = scanner.nextLine();
        List<Double> scores = parseScores(line);

        int excellentCount = analyzer.countExcellentStudents(scores);
        double validAverage = analyzer.calculateValidAverage(scores);

        System.out.println("\nKET QUA:");
        System.out.println("- So hoc sinh Gioi (>= 8.0, chi tinh diem hop le): " + excellentCount);
        System.out.printf("- Diem trung binh hop le (0..10): %.2f%n", validAverage);
    }
}
