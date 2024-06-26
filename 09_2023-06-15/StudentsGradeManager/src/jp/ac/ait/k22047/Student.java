package jp.ac.ait.k22047;

import jp.ac.ait.oop1.section09.Grade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student extends jp.ac.ait.oop1.section09.StudentBase implements jp.ac.ait.oop1.section09.IStudent{
    public Student(String studentId, String name, List<Grade> grades){
        setStudentId(studentId);
        setName(name);
        setGrades(new ArrayList<>(grades));
    }

    @Override
    public List<Grade> getGradesSortByRatingDsc() {
        List<Grade> grades = getGrades();
        Collections.sort(grades, new Comparator<Grade>() {
            @Override
            public int compare(Grade o1, Grade o2) {
                return getGP(o2) - getGP(o1);
            }
        });

        return grades;
    }

    @Override
    public List<Grade> getGradesFilterByRating(char rating) {
        List<Grade> rtn = new ArrayList<>();
        for(Grade grade : getGrades()){
            if(grade.getMyRating() == rating) rtn.add(grade);
        }

        return rtn;
    }

    @Override
    public List<Grade> getGradesFilterByCreditsEarned() {
        List<Grade> rtn = new ArrayList<>();
        for(Grade grade : getGrades()) {
            if(grade.getMyRating() != 'Q' && grade.getMyRating() != 'F'){
                rtn.add(grade);
            }
        }

        return rtn;
    }

    @Override
    public int getTotalCreditsEarned() {
        int sum = 0;
        for(Grade grade : getGradesFilterByCreditsEarned()) sum+= grade.getMyCredit();

        return sum;
    }

    private int getGP(Grade grade){
        char rating = grade.getMyRating();

        if(rating == 'S') return 4;
        else if(rating == 'A') return 3;
        else if(rating == 'B') return 2;
        else if(rating == 'C') return 1;
        else if(rating == 'F') return 0;
        else return -1;
    }
}
