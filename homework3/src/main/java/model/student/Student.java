package model.student;

import jakarta.persistence.*;
import lombok.*;
import model.course.Course;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NonNull
    private String name;

    @NonNull
    private LocalDate birthDate;

    @NonNull
    private String address;
    @NonNull
    private String gender;

    @ManyToMany
    private List<Course> courseTaken = new ArrayList<Course>();

    public static void saveStudent(List<Student> studentList, EntityManager entityManager) {
        for (Student student : studentList) {
            entityManager.getTransaction().begin();
            entityManager.persist(student);
            entityManager.getTransaction().commit();
        }
    }
}


