package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<StudentSubject> studentSubjects = new ArrayList<>();
        studentSubjects.add(new StudentSubject("Math", "10", "Linh", 8));
        studentSubjects.add(new StudentSubject("Math", "10", "Linh", 9));
        studentSubjects.add(new StudentSubject("Science", "10", "Nam", 6));
        studentSubjects.add(new StudentSubject("Science", "11", "Nam", 7));

        Map<String, Map<String, StudentSubject>> groupBySubjectGrade = studentSubjects.stream()
                .collect(Collectors.groupingBy(StudentSubject::getSubject, Collectors.toMap(StudentSubject::getGrade, Function.identity(), (studentSubject, studentSubject2) -> studentSubject2)));


        System.out.println("Hello world!\n" + groupBySubjectGrade);
    }

    static class StudentSubject {
        private String subject;
        private String grade;
        private String name;
        private Integer point;

        public StudentSubject(String subject, String grade, String name, Integer point) {
            this.subject = subject;
            this.grade = grade;
            this.name = name;
            this.point = point;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getPoint() {
            return point;
        }

        public void setPoint(Integer point) {
            this.point = point;
        }
    }
}