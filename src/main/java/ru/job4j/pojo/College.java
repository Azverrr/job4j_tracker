package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Иванов Иван Иванович");
        student.setGroup("ХЗ-22-1");
        student.setDateAdmission(new Date());
        System.out.println("ФИО: " + student.getName() + System.lineSeparator() + "Группа: " + student.getGroup()
        + System.lineSeparator() + "Дата поступления: " + student.getDateAdmission());
    }
}
