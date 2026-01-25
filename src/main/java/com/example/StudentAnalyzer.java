package com.example;

import  java.util.List;

public class StudentAnalyzer {

    /**
     * Phân tích điểm số và trả về số lượng học sinh đạt loại Giỏi.
     * @param scores danh sách điểm số từ 0 đến 10
     * @return số học sinh đạt loại Giỏi (>= 8.0)
     * - Bỏ qua điểm âm hoặc lớn hơn 10 (coi là dữ liệu sai)
     * - Nếu danh sách rỗng hoặc null, trả về 0
     */
    public int countExcellentStudents(List<Double> scores) {
        // Điều kiện 2: Nếu danh sách rỗng hoặc null, trả về 0
        if (scores == null || scores.isEmpty()) {
            return 0;
        }

        int count = 0;

        // Vòng lặp 1: Duyệt qua danh sách để lọc học sinh giỏi
        for (Double score : scores) {
            if (score == null) {
                // Bỏ qua phần tử null (nếu có)
                continue;
            }
            // Điều kiện 1: Bỏ qua điểm không hợp lệ
            if (score < 0.0 || score > 10.0) {
                continue;
            }
            if (score >= 8.0) {
                count++;
            }
        }

        return count;
    }

    /**
     * Tính điểm trung bình hợp lệ (từ 0 đến 10)
     * @param scores danh sách điểm
     * @return điểm trung bình của các điểm hợp lệ (0 nếu không có điểm hợp lệ hoặc danh sách rỗng/null)
     */
    public double calculateValidAverage(List<Double> scores) {
        // Điều kiện 2: Nếu danh sách rỗng hoặc null, trả về 0
        if (scores == null || scores.isEmpty()) {
            return 0.0;
        }

        double sum = 0.0;
        int validCount = 0;

        // Vòng lặp 2: Duyệt qua danh sách để tính trung bình hợp lệ
        for (Double score : scores) {
            if (score == null) {
                // Bỏ qua phần tử null (nếu có)
                continue;
            }
            // Điều kiện 1: Bỏ qua điểm không hợp lệ
            if (score >= 0.0 && score <= 10.0) {
                sum += score;
                validCount++;
            }
        }

        // Trường hợp không có điểm hợp lệ -> trả về 0
        if (validCount == 0) {
            return 0.0;
        }

        return sum / validCount;
    }
}