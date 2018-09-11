package com.WorkWithXML;

import java.util.List;

public class University {

    private List<Students> studentsList;

    public List<Students> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Students> studentsList) {
        this.studentsList = studentsList;
    }

    @Override
    public String toString() {
        return "University{" +
                "studentsList=" + studentsList +
                '}';
    }
}
