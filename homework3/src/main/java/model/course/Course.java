package model.course;

import jakarta.persistence.*;
import lombok.*;
import model.instructor.Instructor;
import model.student.Student;

import java.util.ArrayList;
import java.util.List;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String courseName;
    @NonNull
    private int courseCode;
    @NonNull
    private int creditScore;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Instructor instructor;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Student> studentYoklama = new ArrayList<>();


    public static void saveCourses(List<Course> courseList, EntityManager entityManager) {
        for (Course course : courseList) {
            entityManager.getTransaction().begin();
            entityManager.persist(course);
            entityManager.getTransaction().commit();
        }
    }


}
