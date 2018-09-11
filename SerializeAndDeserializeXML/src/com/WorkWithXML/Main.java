package com.WorkWithXML;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Students std1 = new Students();
        std1.set_name("Aliagha");
        std1.set_surname("Musayev");
        std1.set_age(29);

        Students std2 = new Students();
        std2.set_name("Tariyel");
        std2.set_surname("Aliyev");
        std2.set_age(36);

        List<Students> studentsList = new ArrayList<>();
        studentsList.add(std1);
        studentsList.add(std2);

        University university = new University();
        university.setStudentsList(studentsList);

        SerializeXML.serializeDataAndWriteToXMLFile(university);

        System.out.println("XML file created");

        System.out.println("==========================================");

        University newUniversity = new University();

        newUniversity = SerializeXML.deserializeXMLFileAndReturnAsObject(newUniversity);

        System.out.println("Deserialized university");
        System.out.println(newUniversity);
    }
}
