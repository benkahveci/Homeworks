package java.model;

import jakarta.persistence.*;

// POJO --> Plain Old Java Object
// Entity
@Entity
public class Student {

    // variables (fields)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String studentName;
    private String studentPhone;
    private double GPA;

    @ManyToOne
    private School school;

    //Constructors

    public Student(String studentName, String studentPhone, double GPA) {
        this.studentName = studentName;
        this.studentPhone = studentPhone;
        this.GPA = GPA;
    }

    public Student() {
    }

    //Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    //To String


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", studentPhone='" + studentPhone + '\'' +
                ", GPA=" + GPA +
                '}';
    }


}
