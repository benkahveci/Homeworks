package java.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;


import java.model.School;
import java.model.Student;
import java.util.ArrayList;
import java.util.List;

public class TestStudent {

    public static void main(String[] args) {

        Student student1 = new Student("Batuhan", "Pols", 3.14);
        Student student2 = new Student("Zeynep", "Psychologu", 2.88);
        Student student3 = new Student("Enver", "History", 3.33);

        School school1 = new School("Boğaziçi", "Bebek");
        School school2 = new School("KAOL", "Kütahya");

        List<Student> studentList= new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        student1.setSchool(school1);
        student2.setSchool(school2);
        student3.setSchool(school2);

        List<School> schoolList = new ArrayList<>();
        schoolList.add(school1);
        schoolList.add(school2);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
        EntityManager entityManager = emf.createEntityManager();

        saveSchools(schoolList, entityManager);
        saveStudents(studentList, entityManager);

    }

    private static void saveSchools(List<School> schoolList, EntityManager entityManager) {
        for (School school : schoolList) {
            entityManager.getTransaction().begin();
            entityManager.persist(school);
            entityManager.getTransaction().commit();
        }
    }

    private static void deleteStudent(EntityManager entityManager, Student student) {
        entityManager.getTransaction().begin();

        // JPQL --> Java Persistence Query Language
        // HQL --> Hibernate Query Language
        Student foundStudent = entityManager.createQuery
                        ("SELECT s FROM Student s WHERE s.studentName = :strName", Student.class)
                .setParameter("strName", student.getSchool())
                .getSingleResult();
        entityManager.remove(foundStudent);

        entityManager.getTransaction().commit();
        System.out.println("Student deleted");
    }

    private static void updateStudentName(EntityManager entityManager, Student student, String newStudentName) {
        entityManager.getTransaction().begin();

        Student foundStudent = entityManager.createQuery
                        ("FROM Student s WHERE s.studentName = :strName", Student.class)
                .setParameter("strName", student.getStudentName())
                .getSingleResult();
        foundStudent.setStudentName(newStudentName);
        entityManager.merge(foundStudent);

        entityManager.getTransaction().commit();
        System.out.println("Store phone updated to : " + newStudentName);
    }

    private static void findByStudentName(EntityManager entityManager, String studentName) {
        Student foundStudent = entityManager.createQuery
                        ("FROM Student s WHERE s.studentName = ?1", Student.class)
                .setParameter(1, studentName).getSingleResult();
        System.out.println(foundStudent);
    }

    private static void saveStudents(List<Student> studentList, EntityManager entityManager) {
        for (Student student : studentList) {
            entityManager.getTransaction().begin();
            entityManager.persist(student);
            entityManager.getTransaction().commit();
        }
    }

    private static void findAllStudent(EntityManager entityManager) {
        TypedQuery storeJpql = entityManager.createQuery("FROM Student s", Student.class);
        List<Student> studentList = storeJpql.getResultList();

        for (Student student : studentList) {
            System.out.println(student);
        }
    }

}
