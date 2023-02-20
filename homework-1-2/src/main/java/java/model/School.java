package java.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String address;

    @OneToMany(mappedBy = "school")
    private List<Student> studentList = new ArrayList<>();

    public School(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public School() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" +  name + '\'' +
                ", address='" + address + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
