package jp.ac.ait.k22047;

import jp.ac.ait.oop1.section09.Grade;
import jp.ac.ait.oop1.section09.IStudent;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentsSorter sorter = new StudentsSorter();
        List<Grade> grades = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        grades.add(new Grade("Webプログラミング基礎", 2, 'S'));
        grades.add(new Grade("Webプログラミング及び演習", 2, 'S'));
        grades.add(new Grade("日本語リテラシ", 2, 'F'));
        grades.add(new Grade("線形代数", 2, 'B'));
        grades.add(new Grade("コミュニカティブイングリッシュA", 1, 'A'));

        students.add(new Student("k22047", "白上 聡", grades));
        grades.clear();


        grades.add(new Grade("Webプログラミング基礎", 2, 'A'));
        grades.add(new Grade("Webプログラミング及び演習", 2, 'S'));
        grades.add(new Grade("日本語リテラシ", 2, 'C'));
        grades.add(new Grade("線形代数", 2, 'S'));
        grades.add(new Grade("コミュニカティブイングリッシュB", 1, 'Q'));

        students.add(new Student("z22084", "田中ヤスタカ", grades));
        grades.clear();


        grades.add(new Grade("Webプログラミング基礎", 2, 'A'));
        grades.add(new Grade("Webプログラミング及び演習", 2, 'S'));
        grades.add(new Grade("日本語リテラシ", 2, 'C'));
        grades.add(new Grade("線形代数", 2, 'F'));
        grades.add(new Grade("コミュニカティブイングリッシュB", 1, 'Q'));

        students.add(new Student("z22083", "和入道", grades));
        grades.clear();


        grades.add(new Grade("Webプログラミング基礎", 2, 'A'));
        grades.add(new Grade("Webプログラミング及び演習", 2, 'S'));
        grades.add(new Grade("日本語リテラシ", 2, 'C'));
        grades.add(new Grade("線形代数", 2, 'F'));
        grades.add(new Grade("コミュニカティブイングリッシュB", 1, 'Q'));

        students.add(new Student("z22082", "呂布カルマ", grades));
        grades.clear();



        System.out.println("toString");
        for(Student student : students) System.out.println(student.toString());

        System.out.println("getGradesSortByRatingDsc");
        for(Student student : students) System.out.println(student.getName() + student.getGradesSortByRatingDsc());

        System.out.println("getGradesFilterByRating(S)");
        for(Student student : students) System.out.println(student.getName() + student.getGradesFilterByRating('S'));

        System.out.println("getGradesFilterByCreditsEarned");
        for(Student student : students) System.out.println(student.getName() + student.getGradesFilterByCreditsEarned());

        System.out.println("getTotalCreditsEarned");
        for(Student student : students) System.out.println(student.getName() + student.getTotalCreditsEarned());


        System.out.println("Test of StudentSorter");
        List<IStudent> iStudents = new ArrayList<>(students);
        sorter.setStudents(iStudents);

        System.out.println("sortByTotalCreditsEarnedAsc");
        for(IStudent iStudent : sorter.sortByTotalCreditsEarnedAsc()){
            Student student = (Student)iStudent;
            System.out.println(student.getName() + student.toString());
        }

        System.out.println("sortByTotalCreditsEarnedDsc");
        for(IStudent iStudent : sorter.sortByTotalCreditsEarnedDsc()){
            Student student = (Student)iStudent;
            System.out.println(student.getName() + student.toString());
        }
    }
}
