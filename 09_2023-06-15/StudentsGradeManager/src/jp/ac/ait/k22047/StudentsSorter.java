package jp.ac.ait.k22047;

import jp.ac.ait.oop1.section09.IStudent;

import java.util.ArrayList;
import java.util.List;

public class StudentsSorter implements jp.ac.ait.oop1.section09.IStudentsSorter{
    List<IStudent> students;
    @Override
    public List<IStudent> getStudents() {
        return students;
    }

    @Override
    public void setStudents(List<IStudent> students) {
        this.students = students;
    }

    @Override
    public List<IStudent> sortByTotalCreditsEarnedAsc() {
        List<IStudent> rtn = new ArrayList<>();

        List<Student> students = new ArrayList<>();
        for(IStudent student : this.students) students.add((Student) student);

        students.sort((o1, o2) -> {
            if (o1.getTotalCreditsEarned() == o2.getTotalCreditsEarned()) return o1.getName().compareTo(o2.getName());
            else return o1.getTotalCreditsEarned() - o2.getTotalCreditsEarned();
        });

        for(Student student : students) rtn.add((IStudent) student);

        return rtn;
    }

    @Override
    public List<IStudent> sortByTotalCreditsEarnedDsc() {
        List<IStudent> rtn = new ArrayList<>();

        List<Student> students = new ArrayList<>();
        for(IStudent student : this.students) students.add((Student) student);

        students.sort((o1, o2) -> {
            if (o1.getTotalCreditsEarned() == o2.getTotalCreditsEarned()) return o1.getName().compareTo(o2.getName());
            else return o2.getTotalCreditsEarned() - o1.getTotalCreditsEarned();
        });

        for(Student student : students) rtn.add((IStudent) student);

        return rtn;
    }
}
